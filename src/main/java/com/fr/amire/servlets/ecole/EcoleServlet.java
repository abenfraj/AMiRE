package com.fr.amire.servlets.ecole;

import com.fr.amire.entities.AnnonceEntity;
import com.fr.amire.entities.EcoleEntity;
import com.fr.amire.services.EcoleService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/ecole")
public class EcoleServlet extends HttpServlet {

    private EcoleService ecoleService;

    public void init() {
        this.ecoleService = new EcoleService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<EcoleEntity> ecoles = ecoleService.getAllEcoles();

        String jsonResponse = convertListToJson(ecoles);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse);
    }

    private String convertListToJson(List<EcoleEntity> ecoles) {
        StringBuilder jsonBuilder = new StringBuilder("[");
        for (int i = 0; i < ecoles.size(); i++) {
            EcoleEntity ecole = ecoles.get(i);
            jsonBuilder.append("{")
                    .append("\"id\":").append(ecole.getIdEcole()).append(",")
                    .append("\"raisonSociale\":\"").append(ecole.getRaisonSociale()).append("\",")
                    .append("\"competences\":\"").append(ecole.getCompetences()).append("\",")
                    .append("\"besoins\":\"").append(ecole.getBesoins()).append("\",")
                    .append("\"exigences\":\"").append(ecole.getExigences()).append("\",")
                    .append("\"periode\":").append(ecole.getPeriode()).append(",")
                    .append("\"remarques\":\"").append(ecole.getRemarques()).append("\"")
                    .append("}");
            if (i < ecoles.size() - 1) {
                jsonBuilder.append(", ");
            }
        }
        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }
}
