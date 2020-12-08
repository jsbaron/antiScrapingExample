package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.User;
import repositories.UserRepository;
import utils.RequestParser;
import utils.RequestType;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "servlets.UserServlet")
public class UserServlet extends HttpServlet {

  private final UserRepository repository = UserRepository.getRepo();

  private void preProcessResponse(HttpServletResponse response) {
    response.setContentType("application/json");
    response.setHeader("Access-Control-Allow-Origin", "*");
  }

  private void handleInvalidRequest(HttpServletResponse resp) throws IOException {
    resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    resp.getWriter().write("Invalid Request");
  }

  private void handleGetUsersByPage(HttpServletRequest request, HttpServletResponse resp) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    resp.setStatus(HttpServletResponse.SC_OK);
    List<User> users = repository.getTweetsByPage(RequestParser.getPageNumber(request));
    resp.getWriter().write(mapper.writeValueAsString(users));
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
