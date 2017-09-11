package no.hvl.dat104.controller;

import no.hvl.dat104.Validator;
import no.hvl.dat104.dataaccess.VareDAO;
import no.hvl.dat104.model.Vare;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HandleListeServlet", urlPatterns = "/handleliste")
public class HandleListeServlet extends javax.servlet.http.HttpServlet {
    @EJB
    private VareDAO vareDAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String valg = Validator.escapeHtml(request.getParameter("submit"));
        String vare = Validator.escapeHtml(request.getParameter("vare"));
        System.out.println(valg);
        System.out.println(vare);
        if (Validator.validerStreng(valg) && Validator.validerSubmit(valg) && Validator.validerStreng(vare)) {
            if (valg.equals("Slett")) {
                vareDAO.slettVare(vareDAO.finnVare(vare));
            } else {
                vareDAO.leggTilVare(new Vare(vare));
            }
            response.sendRedirect("handleliste");
        } else {
            response.sendError(500);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Vare> handleliste = vareDAO.alleVarer();
        request.setAttribute("handleliste", handleliste);
        response.setContentType("text/html; charset=ISO-8859-1");
        try {
            request.getRequestDispatcher("handleliste.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

}
