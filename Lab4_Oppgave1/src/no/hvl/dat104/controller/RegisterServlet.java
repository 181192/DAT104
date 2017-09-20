package no.hvl.dat104.controller;

import no.hvl.dat104.dataaccess.IUserEAO;
import no.hvl.dat104.model.ShoppingListEntity;
import no.hvl.dat104.model.UserEntity;
import no.hvl.dat104.util.FlashUtil;
import no.hvl.dat104.util.InnloggingUtil;
import no.hvl.dat104.util.ValidatorUtil;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static no.hvl.dat104.controller.UrlMappings.LOGIN_URL;
import static no.hvl.dat104.controller.UrlMappings.SHOPPING_LIST_URL;

@WebServlet
public class RegisterServlet extends HttpServlet {

    @EJB
    private IUserEAO userEAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!InnloggingUtil.isInnlogget(request)) {
            String username = ValidatorUtil.escapeHtml(request.getParameter("username"));
            String password = ValidatorUtil.escapeHtml(request.getParameter("password"));
            if (ValidatorUtil.isValidUsername(username) && ValidatorUtil.isValidPassword(password)) {
                UserEntity u = new UserEntity(username, password, new ShoppingListEntity());
                userEAO.addUser(u);
                FlashUtil.registerUser(request);
            } else {
                FlashUtil.unValidRegisterUser(request);
            }
        } else {
            response.sendRedirect(SHOPPING_LIST_URL);
        }
        response.sendRedirect(LOGIN_URL);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (InnloggingUtil.isInnlogget(request)) {
            response.sendRedirect(SHOPPING_LIST_URL);
        } else {
            request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
        }
    }
}
