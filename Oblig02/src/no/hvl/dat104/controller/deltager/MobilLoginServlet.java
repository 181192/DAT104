package no.hvl.dat104.controller.deltager;

import static no.hvl.dat104.controller.UrlMappings.DELTAGERLISTE_URL;
import static no.hvl.dat104.controller.UrlMappings.MOBILLOGIN_URL;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat104.dataaccess.IDeltagerEAO;
import no.hvl.dat104.model.DeltagerEntity;
import no.hvl.dat104.util.DeltagerUtil;
import no.hvl.dat104.util.FlashUtil;
import no.hvl.dat104.util.InnlogginUtil;

/**
 * Servlet implementation class LoginServlet
 */
public class MobilLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private IDeltagerEAO deltagerEAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (InnlogginUtil.erInnlogget(request)) {
			response.sendRedirect(DELTAGERLISTE_URL);
		} else {
			request.getRequestDispatcher("WEB-INF/jsp/deltager/mobillogin.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DeltagerEntity d = DeltagerUtil.hentDeltager(request, deltagerEAO);
		if (d != null) {
			// TODO fikse bug med at getInitParameter returnerer null
			// String timeout = getServletContext().getInitParameter("timeout");
			String timeout = "30";
			InnlogginUtil.loggInnSom(request, d, timeout);
			response.sendRedirect(DELTAGERLISTE_URL);
		} else {
			FlashUtil.flash(request, "error", "Må tilhøre registrert deltager");
			response.sendRedirect(MOBILLOGIN_URL);
		}
	}

}
