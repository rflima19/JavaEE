package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String senha = request.getParameter("senha");

		if (senha.equals("123456")) {
			response.sendRedirect("/Applet/ok.jsp");
		} else {
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
		}
	}
}
