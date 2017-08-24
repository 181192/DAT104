package no.hvl.dat104;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TemperaturOmregner
 */
@WebServlet("/result")
public class TempServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TempOmregner to = new TempOmregner();
		
		String enhet = request.getParameter("enhet");
		double temp = to.skjekkInputTemperatur(request.getParameter("temp"));
		
		
		DecimalFormat df = new DecimalFormat("####0.00");
		String resultat = df.format(to.regnTemperatur(temp, enhet));
		
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Temperaturomregning resultat</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Temperaturomregning resultat</h1>");
		out.println("<p>" + temp + " ºC = " + resultat + "  ºF</p>");
		out.println("<p><a href=\"/lab26\">En gang til</a></p>");
		out.println("</body>");
		out.println("</html>");
	}
	
	
	
}
