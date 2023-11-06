package com.fr.amire.servlets;

import com.fr.amire.entities.AnnonceEntity;
import com.fr.amire.services.AnnonceService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.JsonUtils;

import java.io.IOException;
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

        String jsonResponse = JsonUtils.convertToJson(searchResults);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse);
    }
}
