package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.EventConstants;
import models.User;
import repositories.EventLogRepository;
import repositories.UserRepository;
import utils.RequestParser;
import utils.RequestType;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(name = "servlets.UserServlet")
public class UserServlet extends HttpServlet {

  private final UserRepository userRepository = UserRepository.getRepo();
  private final EventLogRepository eventLogRepository = EventLogRepository.getRepo();

  private void preProcessResponse(HttpServletResponse response) {
    response.setContentType("application/json");
    response.setHeader("Access-Control-Allow-Origin", "*");
  }

  private void handleInvalidRequest(HttpServletResponse resp) throws IOException {
    resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    resp.getWriter().write("Invalid Request");
  }

  private void logGetUsersByPage(HttpServletRequest request) {
    try {
      eventLogRepository.insertEventLog(
          RequestParser.getClientIp(request),
          EventConstants.GET_USERS_BY_PAGE,
          RequestParser.getPageNumber(request).toString(),
          new Timestamp(System.currentTimeMillis())
      );
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }

  private void handleGetUsersByPage(HttpServletRequest request, HttpServletResponse resp) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    resp.setStatus(HttpServletResponse.SC_OK);
    List<User> users = userRepository.getTweetsByPage(RequestParser.getPageNumber(request));
    resp.getWriter().write(mapper.writeValueAsString(users));
    logGetUsersByPage(request);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    preProcessResponse(resp);
    RequestType requestType = RequestParser.parseRequest(req);
    switch (requestType) {
      case INVALID:
        handleInvalidRequest(resp);
        break;
      case GET_USERS_BY_PAGE:
        handleGetUsersByPage(req, resp);
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + requestType);
    }
  }
}
