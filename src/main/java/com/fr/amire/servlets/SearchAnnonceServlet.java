package com.fr.amire.servlets;

import com.fr.amire.entities.AnnonceEntity;
import com.fr.amire.services.AnnonceService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/annonce/search")
public class SearchAnnonceServlet extends HttpServlet {
    private AnnonceService annonceService;

    public void init() {
        this.annonceService = new AnnonceService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String searchQuery = request.getParameter("q");
        if (searchQuery == null || searchQuery.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Search query is missing");
            return;
        }

        List<AnnonceEntity> searchResults = annonceService.searchAnnonces(searchQuery);

        String jsonResponse = convertListToJson(searchResults);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse);
    }

    private String convertListToJson(List<AnnonceEntity> annonces) {
        StringBuilder jsonBuilder = new StringBuilder("[");
        for (int i = 0; i < annonces.size(); i++) {
            AnnonceEntity annonce = annonces.get(i);
            jsonBuilder.append("{")
                    .append("\"id\":").append(annonce.getIdAnnonce()).append(",")
                    .append("\"titre\":\"").append(annonce.getTitre()).append("\",")
                    .append("\"niveauxSouhaites\":\"").append(annonce.getNiveauxSouhaites()).append("\",")
                    .append("\"typeDeContrat\":\"").append(annonce.getTypeDeContrat()).append("\",")
                    .append("\"description\":\"").append(annonce.getDescription()).append("\",")
                    .append("\"idEcole\":").append(annonce.getIdEcole()).append(",")
                    .append("\"expirationAnnonce\":\"").append(annonce.getExpirationAnnonce()).append("\"")
                    .append("}");
            if (i < annonces.size() - 1) {
                jsonBuilder.append(", ");
            }
        }
        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }
}
