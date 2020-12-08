package servlets;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.Duration;

public class RateLimitingFilter implements Filter {
  private Bucket createNewBucket() {
    Bandwidth limit = Bandwidth.simple(50, Duration.ofSeconds(1));
    return Bucket4j.builder().addLimit(limit).build();
  }


  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                       FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
    HttpSession session = httpRequest.getSession(
        true
    );

    String appKey = httpRequest.getHeader("X-FORWARDED-FOR");
    if (appKey == null) {
      appKey = httpRequest.getRemoteAddr();
    }
    Bucket bucket = (Bucket) session.getAttribute("throttler-" + appKey);
    if (bucket == null) {
      bucket = createNewBucket();
      session.setAttribute("throttler-" + appKey, bucket);
    }

    // tryConsume returns false immediately if no tokens available with the bucket
    if (bucket.tryConsume(1)) {
      // the limit is not exceeded
      filterChain.doFilter(servletRequest, servletResponse);
    } else {
      // limit is exceeded
      HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
      httpResponse.setContentType("text/plain");
      httpResponse.setStatus(429);
      httpResponse.getWriter().append("Too many requests");
    }
  }
}
