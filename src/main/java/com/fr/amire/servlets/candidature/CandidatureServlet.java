package com.fr.amire.servlets.candidature;

import com.fr.amire.entities.CandidatureEntity;
import com.fr.amire.services.CandidatureService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.ConversionUtil;
import utils.JsonUtils;

import java.io.IOException;
import java.util.List;

import static utils.ApiException.*;

@WebServlet("/candidatures/*")
public class CandidatureServlet extends HttpServlet {
    private CandidatureService candidatureService;

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
        int idAnnonce;
        try {
            idAnnonce = Integer.parseInt(pathParts[1]);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid offer ID");
            return;
        }

        List<CandidatureEntity> candidatures = candidatureService.getCandidaturesByOfferId(idAnnonce);
        if (candidatures == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "No candidature found for offer ID: " + idAnnonce);
            return;
        }

        String jsonResponse = JsonUtils.convertToJson(candidatures);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pathInfo = request.getPathInfo();
        String[] pathParts = pathInfo.split("/");

        if (pathParts.length != 2) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid URL format");
            return;
        }

        // Parse the candidature data from the request body
        CandidatureEntity candidature = candidatureService.parseCandidatureFromRequest(request);

        if (candidature == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid candidature data");
            return;
        }

        // Save the candidature
        boolean saveSuccess = candidatureService.saveCandidature(candidature);

        if (!saveSuccess) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to save candidature");
        } else {
            response.setStatus(HttpServletResponse.SC_CREATED);
            response.getWriter().write("Candidature created successfully");
        }
    }
}