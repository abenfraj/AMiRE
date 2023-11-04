package com.fr.amire.servlets.login;

import com.fr.amire.entities.AccountEntity;
import com.fr.amire.services.AuthenticationService;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @EJB
    private AuthenticationService authenticationService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (authenticationService.authenticate(username, password)) {
            AccountEntity account = authenticationService.getAccount(username);
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            addCookiesToResponse(response, account);

            response.sendRedirect("home.jsp");
        } else {
            request.setAttribute("errorMessage", "Invalid username or password");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void addCookiesToResponse(HttpServletResponse response, AccountEntity account) {
        Cookie idCookie = new Cookie("userId", String.valueOf(account.getId()));
        Cookie typeCookie = new Cookie("userType", account.getType());

        idCookie.setMaxAge(60 * 60 * 24);  // 1 day
        typeCookie.setMaxAge(60 * 60 * 24);  // 1 day

        response.addCookie(idCookie);
        response.addCookie(typeCookie);
    }
}