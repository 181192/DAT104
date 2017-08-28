package no.hvl.dat104;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

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
		String belop = request.getParameter("belop");

		Omregner o = new Omregner();

		response.setContentType("text/html; charset=ISO-8859-1");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Valutaveksling resultat</title>");
		out.println("</head>");
		out.println("<body>");

        if (o.isValidEnhet(fra) && o.isValidEnhet(til) && o.isValidBelop(belop)) {
            double beregnet = o.beregnValuta(Double.parseDouble(belop), fra, til);
            DecimalFormat df = new DecimalFormat("####0.00");
            String resultat = df.format(beregnet);

            out.println("<h1>Valutaveksling resultat</h1>");
            out.println("<p>" + belop + " " + fra + " blir " + resultat + " " + til + "</p>");
        } else {
            out.println("<h1>Valutaveksling feilmelding</h1>");
            out.println("<p>Error input er ikke godkjent</p>");
        }


		out.println("<p><a href=\"/lab25\">Veksle en gang til</a></p>");
		out.println("</body>");
		out.println("</html>");
	
	}

}
