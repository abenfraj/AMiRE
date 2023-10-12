package com.amire;

import com.amire.entities.UserEntity;
import com.amire.entities.UserSessionBean;
import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    @EJB
    private UserSessionBean userSessionBean;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        List<UserEntity> users = userSessionBean.getAll();

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        for (UserEntity user : users) {
            out.println("<p>" + user.getName() + "</p>");
        }
        out.println("</body></html>");
    }

}