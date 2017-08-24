package no.hvl.dat104;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TemperaturOmregner
 * 
 * @author Kristoffer-Andre Kalliainen
 */
@WebServlet("/result")
public class TempServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter out;
	private String enhet;
	private Double temp;
	private String resultat;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TempOmregner to = new TempOmregner();
		response.setContentType("text/html; charset=ISO-8859-1");
		out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Temperaturomregning resultat</title>");
		out.println("</head>");
		out.println("<body>");
		
		try {
			enhet = to.skjekkInputEnhet(request.getParameter("enhet"));
			temp = to.skjekkInputTemperatur(request.getParameter("temp"));

			resultat = to.regnTemperatur(temp, enhet);

			
			out.println("<h1>Temperaturomregning resultat</h1>");
			out.println("<p>" + temp.toString() + " ºC = " + resultat + "  ºF</p>");
			out.println("<p><a href=\"/lab26\">En gang til</a></p>");
			
			
		} catch (Exception e) {
			feilMelding();
		} 
		out.println("</body>");
		out.println("</html>");

	}

	private void feilMelding() {
		out.println("<title>Temperaturomregning feilmelding</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Temperaturomregning feilmelding</h1>");
		out.println("<p>Ugyldig brukerinput. Temperaturen må være ett tall (lik eller over det absolutte nullpunkt).");
		out.println("Pass også på at du har valgt en av omregningene før du trykker \"Regn om\".</p>");
		out.println("<p><a href=\"/lab26\">En gang til</a></p>");
	}

}
