package com.fr.amire.servlets.candidature;

import com.fr.amire.entities.CandidatureEntity;
import com.fr.amire.services.CandidatureService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.JsonUtils;

import java.io.IOException;
import java.util.List;

@WebServlet("/candidature/*")
public class CandidatureEnseignantServlet extends HttpServlet {

    private CandidatureService candidatureService = new CandidatureService();

    public void init() {
        this.candidatureService = new CandidatureService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pathInfo = request.getPathInfo();
        String[] pathParts = pathInfo.split("/");

        if (pathParts.length != 2) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid URL format");
            return;
        }
        // Get candidatures by enseignant ID
        int idEnseignant;
        try {
            idEnseignant = Integer.parseInt(pathParts[1]);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid enseignant ID");
            return;
        }
        List<CandidatureEntity> candidatures = candidatureService.getCandidaturesByEnseignantId(idEnseignant);
        if (candidatures == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "No candidature found for enseignant ID: " + idEnseignant);
        }

        String jsonResponse = JsonUtils.convertToJson(candidatures);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse);
    }
}
