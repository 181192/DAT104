package no.hvl.dat104.controller;

import no.hvl.dat104.Validator;
import no.hvl.dat104.dataaccess.IItemEAO;
import no.hvl.dat104.dataaccess.jpa.ItemEAO;
import no.hvl.dat104.model.ItemEntity;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static no.hvl.dat104.controller.UrlMappings.SHOPPING_LIST_URL;

@WebServlet(name = "ShoppingListServlet", urlPatterns = "/" + SHOPPING_LIST_URL)
public class ShoppingListServlet extends javax.servlet.http.HttpServlet {
    @EJB
    private IItemEAO itemEAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String submitType = Validator.escapeHtml(request.getParameter("submit"));
        String item = Validator.escapeHtml(request.getParameter("item"));
        System.out.println(submitType);
        System.out.println(item);
        if (Validator.isValidString(submitType) && Validator.isValidSubmitType(submitType) && Validator.isValidString(item)) {
            if (submitType.equals("Slett")) {
                itemEAO.removeItem(itemEAO.findItem(item));
            } else {
                itemEAO.addItem(new ItemEntity(item));
            }
            response.sendRedirect("shoppinglist");
        } else {
            response.sendError(500, "Validering av input feilet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ItemEntity> shoppingList = itemEAO.allItems();
        request.setAttribute("shoppingList", shoppingList);
        response.setContentType("text/html; charset=ISO-8859-1");
        try {
            request.getRequestDispatcher("WEB-INF/shoppingList.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() throws ServletException {
        itemEAO = new ItemEAO();
    }
}
