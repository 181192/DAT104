package no.hvl.dat104.controller;

import no.hvl.dat104.dataaccess.VareDAO;
import no.hvl.dat104.model.Vare;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SlettServlet", urlPatterns = "/slett")
public class SlettServlet extends HttpServlet {
    @EJB
    private VareDAO vareDAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String slett = request.getParameter("varenavn");
        Vare varen = vareDAO.finnVare(slett);
        vareDAO.slettVare(varen);
        response.sendRedirect("handleliste");
    }
}
