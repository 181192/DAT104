package no.hvl.dat104.no.hvl.dat104.servlets;

import no.hvl.dat104.Options;
import no.hvl.dat104.Votes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static no.hvl.dat104.Validator.isValidFruit;

@WebServlet("/result")
public class FruitServlet extends HttpServlet {

    private Votes v;
    private Options o;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        o = (Options) request.getSession().getAttribute("options");
        v = (Votes) request.getSession().getAttribute("votes");

        String valg = request.getParameter("frukt");
        if (!isValidFruit(valg)) {
            response.sendRedirect("error");
        } else {
            int frukt = Integer.parseInt(valg);
            v.addVote(frukt);
            request.getSession().setAttribute("options", o);
            request.getSession().setAttribute("votes", v);
            response.sendRedirect("result");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        o = (Options) request.getSession().getAttribute("options");
        v = (Votes) request.getSession().getAttribute("votes");

        response.setContentType("text/html; charset=ISO-8859-1");

        request.getSession().setAttribute("options", o);
        request.getSession().setAttribute("votes", v);

        try {
            request.getRequestDispatcher("result.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
            response.sendRedirect("error");
        }
    }
}
