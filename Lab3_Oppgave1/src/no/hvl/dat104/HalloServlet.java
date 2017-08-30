package no.hvl.dat104;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/result")
public class HalloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String navn = request.getParameter("navn");

        Validator v = new Validator();
        navn = v.rensInputManuell(navn);

        response.setContentType("text/html; charset=ISO-8859-1");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("<title>Hallo resultat</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<fieldset>");
        out.println("<legend>Hallo resultat</legend>");
        if (v.validerNavn(navn)) {
            out.println("<p>Hallo " + navn + "</p>");
        } else {
            out.println("<p style=\"color:red;\">Feil, prøv igjen</p>");
        }

        out.println("<p><a href=\"/lab31\">Hilse igjen</a></p>");
        out.println("</fieldset>");
        out.println("</body>");
        out.println("</html>");

    }
}
