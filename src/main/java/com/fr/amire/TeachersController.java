package com.fr.amire;

import com.fr.amire.entities.TeachersEntity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "teachersController", value = "/teachers-controller")
public class TeachersController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        List<TeachersEntity> fauxEnseignants = new ArrayList<>();
        fauxEnseignants.add(new TeachersEntity(1,"John", "Doe"));
        fauxEnseignants.add(new TeachersEntity(2, "Jane", "Smith"));

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        for (TeachersEntity enseignant : fauxEnseignants) {
            out.println("<p>Id : " + enseignant.getId() + "</p>");
            out.println("<p>Nom : " + enseignant.getLastName() + "</p>");
            out.println("<p>Prénom : " + enseignant.getFirstName() + "</p>");
        }
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
