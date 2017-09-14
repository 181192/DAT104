package no.hvl.dat104.controller;

import no.hvl.dat104.dataaccess.IItemEAO;
import no.hvl.dat104.model.ItemEntity;
import no.hvl.dat104.util.FlashUtil;
import no.hvl.dat104.util.ValidatorUtil;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static no.hvl.dat104.controller.UrlMappings.LOGIN_URL;
import static no.hvl.dat104.controller.UrlMappings.SHOPPING_LIST_URL;

@WebServlet(name = "ShoppingListServlet", urlPatterns = "/" + SHOPPING_LIST_URL)
public class ShoppingListServlet extends HttpServlet {
    @EJB
    private IItemEAO itemEAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("loggedInUser") != null) {
            String submitType = ValidatorUtil.escapeHtml(request.getParameter("submit"));

            if (ValidatorUtil.isValidString(submitType) && ValidatorUtil.isValidSubmitType(submitType)) {
                if (submitType.equals("Slett")) {
                    deleteItem(request);
                    FlashUtil.flash(request, "Success", "Vare slettet");
                } else {
                    newItem(request);
                    FlashUtil.flash(request, "Success", "Vare lagt til");
                }
            } else {
                FlashUtil.flash(request, "Error", "Ugyldig input");
            }
        }
        response.sendRedirect(SHOPPING_LIST_URL);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("loggedInUser") != null) {
            List<ItemEntity> shoppingList = itemEAO.allItems();
            request.setAttribute("shoppingList", shoppingList);
            request.getRequestDispatcher("WEB-INF/shoppingList.jsp").forward(request, response);
        } else {
            FlashUtil.needToBeLoggedIn(request);
            response.sendRedirect(LOGIN_URL);
        }
    }

    private void deleteItem(HttpServletRequest request) {
        String delItem = ValidatorUtil.escapeHtml(request.getParameter("delItem"));
        if (ValidatorUtil.isValidNumber(delItem)) {
            ItemEntity item = itemEAO.findItem(Integer.parseInt(delItem));
            itemEAO.removeItem(item);
        }
    }

    private void newItem(HttpServletRequest request) {
        String itemName = ValidatorUtil.escapeHtml(request.getParameter("newItem"));
        if (ValidatorUtil.isValidString(itemName)) {
            itemEAO.addItem(new ItemEntity(itemName));
        }
    }
}
