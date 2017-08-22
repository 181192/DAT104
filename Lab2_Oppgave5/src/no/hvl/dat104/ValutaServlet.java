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
 * Servlet implementation class ValutaOmformer
 */
@WebServlet("/result")
public class ValutaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fra = request.getParameter("fra");
		String til = request.getParameter("til");
		double belop = Double.parseDouble(request.getParameter("belop"));
		
		Omregner o = new Omregner();
		double beregnet = o.beregnValuta(belop, fra, til);
		DecimalFormat df = new DecimalFormat("####0.00");
		String resultat = df.format(beregnet);
		
		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Valutaveksling resultat</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Valutaveksling resultat</h1>");
		out.println("<p>" + belop + " " + fra + " blir " + resultat + " " + til + "</p>");
		out.println("<p><a href=\"/lab25\">Veksle en gang til</a></p>");
		out.println("</body>");
		out.println("</html>");
	
	}

}
