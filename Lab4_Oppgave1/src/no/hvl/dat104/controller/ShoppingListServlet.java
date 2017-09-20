package no.hvl.dat104.controller;

import no.hvl.dat104.dataaccess.IItemEAO;
import no.hvl.dat104.dataaccess.IShoppingListEAO;
import no.hvl.dat104.dataaccess.IUserEAO;
import no.hvl.dat104.model.ItemEntity;
import no.hvl.dat104.model.UserEntity;
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

@WebServlet
public class ShoppingListServlet extends HttpServlet {
    @EJB
    private IItemEAO itemEAO;
    @EJB
    private IUserEAO userEAO;
    @EJB
    private IShoppingListEAO shoppingListEAO;

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
        String loggedInUser = (String) request.getSession().getAttribute("loggedInUser");
        if (ValidatorUtil.isValidUsername(loggedInUser)) {
            UserEntity currentUser = userEAO.findUser(loggedInUser);
            request.getSession().setMaxInactiveInterval(Integer.parseInt(getInitParameter("timeout")));
            request.getSession().setAttribute("currentUser", currentUser);

            List shoppingList = shoppingListEAO.allItemsInShoppingList(currentUser.getShoppingList());
            request.setAttribute("shoppingList", shoppingList);

            FlashUtil.loggedInn(request, currentUser.getUserId());
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
        UserEntity user = (UserEntity) request.getSession().getAttribute("currentUser");
        System.out.println(user.getUserId() + " " + itemName);
        if (ValidatorUtil.isValidString(itemName)) {
            ItemEntity item = new ItemEntity(itemName, user.getShoppingList());
            user.getShoppingList().addItemToShoppingList(item);
            itemEAO.addItem(item);
        }
    }
}
