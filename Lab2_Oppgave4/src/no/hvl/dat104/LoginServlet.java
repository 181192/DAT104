package no.hvl.dat104;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
//		String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getRequestURI();
		
		String path = request.getHeader("Referer");
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Login Result</title>");
		out.println("</head>");
		out.println("<style>span {color:red;}</style>");
		out.println("<body>");
		out.println("<h1>Login result</h1>");
		out.println("<p>Logged in from <span>" + (path!=null?path:"localhost") + "</span></p>");
		out.println("<p>Username: <span>" + (username!=null?username:"username") + "</span></p>");
		out.println("<p>Password: <span>" + (password!=null?password:"password") + "</span></p>");
		out.println("</body>");
		out.println("</html>");
	}
}
