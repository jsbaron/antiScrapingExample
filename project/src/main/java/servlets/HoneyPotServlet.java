package servlets;

import repositories.EventLogRepository;
import utils.RequestParser;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@WebServlet(name = "servlets.HoneyPotServlet")
public class HoneyPotServlet extends HttpServlet {

  private final EventLogRepository eventLogRepository = EventLogRepository.getRepo();

  private void preProcessResponse(HttpServletResponse response) {
    response.setContentType("application/json");
    response.setHeader("Access-Control-Allow-Origin", "*");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
    preProcessResponse(resp);
    try {
      eventLogRepository.insertBadIp(RequestParser.getClientIp(req));
      resp.setStatus(201);
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }
}
