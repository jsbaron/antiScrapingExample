package servlets;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import utils.RequestParser;
import utils.ScrapingEnforcer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class RateLimitingFilter implements Filter {

  private Map<String, Bucket> bucketMap;

  private Bucket createNewBucket() {
    Bandwidth limit = Bandwidth.simple(1, Duration.ofSeconds(1));
    return Bucket4j.builder().addLimit(limit).build();
  }


  @Override
  public void init(FilterConfig filterConfig) {
    bucketMap = new HashMap<>();
  }

  private Bucket getBucket(String ip) {
    if (!bucketMap.containsKey(ip)) {
      bucketMap.put(ip, createNewBucket());
    }
    return bucketMap.get(ip);
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                       FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
    String ip = RequestParser.getClientIp(httpRequest);
    Bucket bucket = getBucket(ip);


    // tryConsume returns false immediately if no tokens available with the bucket
    if (bucket.tryConsume(1)) {
      // the limit is not exceeded
      filterChain.doFilter(servletRequest, servletResponse);
    } else {
      // limit is exceeded
      ScrapingEnforcer.enforce(servletResponse);
    }
  }
}
