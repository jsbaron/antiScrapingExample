package utils;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ScrapingEnforcer {
  private ScrapingEnforcer() {}
  public static void enforce(ServletResponse servletResponse) throws IOException {
    HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
    httpResponse.setHeader("Access-Control-Allow-Origin", "*");
    httpResponse.setContentType("text/plain");
    httpResponse.setStatus(429);
    httpResponse.getWriter().append("Too many requests");
  }
}
