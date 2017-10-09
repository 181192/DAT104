package no.hvl.dat104.controller.deltager;

import static no.hvl.dat104.controller.UrlMappings.DELTAGERLISTE_URL;
import static no.hvl.dat104.controller.UrlMappings.PAAMELDINGSBEKREFTELSE_URL;
import static no.hvl.dat104.controller.UrlMappings.PAAMELDING_URL;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat104.dataaccess.IDeltagerEAO;
import no.hvl.dat104.model.DeltagerEntity;
import no.hvl.dat104.util.DeltagerUtil;
import no.hvl.dat104.util.InnlogginUtil;
import no.hvl.dat104.util.RegistrerUtil;

/**
 * Servlet implementation class PaameldingServlet
 */
public class PaameldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private IDeltagerEAO deltagerEAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (InnlogginUtil.erInnlogget(request)) {
			response.sendRedirect(DELTAGERLISTE_URL);
		} else {
			RegistrerUtil.setUpCookiesTilRequest(request);
			RegistrerUtil.setUpfeilMeldinger(request);
			request.getRequestDispatcher("WEB-INF/jsp/deltager/paameldingsskjema.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!InnlogginUtil.erInnlogget(request)) {
			DeltagerEntity d = DeltagerUtil.leggTilDeltager(request, deltagerEAO);
			if (d != null) {
				request.getSession().setAttribute("registrert", true);
				request.getSession().setAttribute("regDeltager", d);
				response.sendRedirect(PAAMELDINGSBEKREFTELSE_URL);
			} else {
				List<Cookie> cookies = RegistrerUtil.hentPersonOpplysninger(request, response);
				RegistrerUtil.sjekkCookies(cookies, request);
				request.getSession().setAttribute("registrert", false);
				response.sendRedirect(PAAMELDING_URL);
			}
		} else {
			response.sendRedirect(DELTAGERLISTE_URL);
		}
	}

}
