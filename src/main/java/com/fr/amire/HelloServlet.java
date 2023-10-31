package com.fr.amire;

import java.io.*;
import java.util.List;

import com.fr.amire.entities.AccountEntity;
import jakarta.ejb.EJB;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    @EJB
    private AccountSessionBean accountSessionBean;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        List<AccountEntity> accountEntityList = accountSessionBean.getAllAccounts();
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        for(AccountEntity accountEntity : accountEntityList) {
            out.println("<p>" + accountEntity.getName() + "</p>");
        }
        out.println("</body></html>");
    }

    public void destroy() {
    }
}