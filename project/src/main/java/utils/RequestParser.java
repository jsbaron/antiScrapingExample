package utils;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

public class RequestParser {
  private static final String GET_USERS_BY_PAGE = "/page/\\d+";

  public static Integer getPageNumber(HttpServletRequest request) throws IllegalArgumentException {
    if (!Pattern.matches(GET_USERS_BY_PAGE, request.getPathInfo())) {
      throw new IllegalArgumentException("Request does not match " + GET_USERS_BY_PAGE);
    }
    return Integer.parseInt(request.getPathInfo().split("/")[2]);
  }


  public static RequestType parseRequest(HttpServletRequest request) {
    String urlPath = request.getPathInfo();

    if (Pattern.matches(GET_USERS_BY_PAGE, urlPath)) {
      return RequestType.GET_USERS_BY_PAGE;
    }

    return RequestType.INVALID;
  }

  private RequestParser() {}
}
