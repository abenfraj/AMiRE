package com.fr.amire.servlets.ecole;

import com.fr.amire.entities.EcoleEntity;
import com.fr.amire.services.EcoleService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ecole")
public class EcoleByIdServlet extends HttpServlet {

    private EcoleService ecoleService;

    public void init() {
        this.ecoleService = new EcoleService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String getRequestParameter = request.getParameter("id");
        int idEcole = Integer.parseInt(request.getParameter("id"));
        if (idEcole == 0) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Id cannot be equal to 0");
            return;
        } else if (getRequestParameter.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Id is missing");
            return;
        }

        EcoleEntity ecole = ecoleService.getEcoleById(idEcole);
        String jsonResponse = convertListToJson(ecole);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse);
    }

    private String convertListToJson(EcoleEntity ecole) {
        StringBuilder jsonBuilder = new StringBuilder("[");
        jsonBuilder.append("{")
                .append("\"id\":").append(ecole.getIdEcole()).append(",")
                .append("\"raisonSociale\":\"").append(ecole.getRaisonSociale()).append("\",")
                .append("\"competences\":\"").append(ecole.getCompetences()).append("\",")
                .append("\"besoins\":\"").append(ecole.getBesoins()).append("\",")
                .append("\"exigences\":\"").append(ecole.getExigences()).append("\",")
                .append("\"periode\":").append(ecole.getPeriode()).append(",")
                .append("\"remarques\":\"").append(ecole.getRemarques()).append("\"")
                .append("}");

        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }
}

