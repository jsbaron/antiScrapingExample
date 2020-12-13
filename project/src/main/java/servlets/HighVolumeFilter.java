package servlets;

import repositories.EventLogRepository;
import utils.RequestParser;
import utils.ScrapingEnforcer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;


public class HighVolumeFilter implements Filter {

  private EventLogRepository eventLogRepository = null;

  @Override
  public void init(FilterConfig filterConfig) {
    eventLogRepository = EventLogRepository.getRepo();
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
    String ip = RequestParser.getClientIp(httpRequest);
    if (!shouldEnforce(ip)) {
      filterChain.doFilter(servletRequest, servletResponse);
    } else {
      ScrapingEnforcer.enforce(servletResponse);
    }
  }

  private boolean shouldEnforce(String ip) {
    try {
      return eventLogRepository.hasHighTrafficVolume(ip);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return false;
  }
}
