package no.hvl.dat104.controller.deltagere;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat104.util.InnlogginUtil;

/**
 * Servlet implementation class FerdigServlet
 */
public class FerdigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (InnlogginUtil.erInnlogget(request)) {
			InnlogginUtil.loggUt(request);
		}
		request.getRequestDispatcher("WEB-INF/jsp/deltagere/ferdig.jsp").forward(request, response);
	}
}
