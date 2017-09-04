package no.hvl.dat104.no.hvl.dat104.servlets;

import no.hvl.dat104.Options;
import no.hvl.dat104.Seed;
import no.hvl.dat104.Votes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@WebServlet("")
public class IndexServlet extends HttpServlet {

    private Votes v;
    private Options o;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        request.getSession().setAttribute("votes", v);
        request.getSession().setAttribute("options", o);

        try {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
            response.sendRedirect("error");
        }
    }

    @Override
    public void init() throws ServletException {
        o = new Options();
        v = new Votes();
        Seed seed = new Seed();

        try {
            seed.setOptions(readOptionsFromFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        seed.seedHashMaps(v.getVotes(), o.getAlternatives());
    }

    private List<String> readOptionsFromFile()
            throws IOException {
        List<String> options = new ArrayList<>();
        InputStream optionsStream = getServletContext()
                .getResourceAsStream("/WEB-INF/options.txt");
        BufferedReader optionsReader = new BufferedReader(
                new InputStreamReader(optionsStream));
        String option = optionsReader.readLine();
        while (option != null) {
            options.add(option);
            option = optionsReader.readLine();
        }
        optionsReader.close();
        return options;
    }


}
