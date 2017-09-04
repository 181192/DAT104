package no.hvl.dat104;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/result")
public class FruktServlet extends HttpServlet {

    private Map<Integer, Integer> stemmer;
    private Map<Integer, String> alternativ;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String valg = request.getParameter("frukt");
        if (!isValidFrukt(valg)) {
            response.sendRedirect("error");
        } else {
            int frukt = Integer.parseInt(valg);
            System.out.println(frukt);
            leggTilStemme(frukt);
            request.getSession().setAttribute("stemmer", stemmer);
            response.sendRedirect("result");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        for (int i = 0; i < alternativ.size(); i++) {
            out.println("<p>" + alternativ.get(i) + " = " + stemmer.get(i) + "</p>");
        }
        out.println("<p><a href=/lab32>Stem engang til</a></p>");
    }

    @Override
    public void init() throws ServletException {
        stemmer = new HashMap<>();
        alternativ = new HashMap<>();
        seedHashMaps();
    }

    private void seedHashMaps() {
        alternativ.put(0, "Eple");
        alternativ.put(1, "Pære");
        alternativ.put(2, "Kiwi");
        alternativ.put(3, "Banan");

        stemmer.put(0, 0);
        stemmer.put(1, 0);
        stemmer.put(2, 0);
        stemmer.put(3, 0);
    }

    private boolean isValidFrukt(String frukt) {
        return frukt != null && frukt.matches("^\\d+$");
    }

    private void leggTilStemme(int valg) {
        stemmer.put(valg, stemmer.get(valg) + 1);
        System.out.println(stemmer.get(valg));
    }
}
