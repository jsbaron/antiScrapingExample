package servlets;

import repositories.EventLogRepository;
import utils.RequestParser;
import utils.ScrapingEnforcer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

public class MaliciousIdentifierFilter implements Filter {

  private EventLogRepository eventLogRepository = null;

  @Override
  public void init(FilterConfig filterConfig) {
    eventLogRepository = EventLogRepository.getRepo();
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
    String userAgent = RequestParser.getUserAgent(httpRequest);
    if (!shouldEnforce(userAgent)) {
      filterChain.doFilter(servletRequest, servletResponse);
    } else {
      ScrapingEnforcer.enforce(servletResponse);
    }
  }

  private boolean shouldEnforce(String userAgent) {
    try {
      return eventLogRepository.hasBadUserAgent(userAgent);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return false;
  }
}
