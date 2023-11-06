package com.fr.amire.servlets;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fr.amire.entities.CandidatureEntity;
import com.fr.amire.services.CandidatureService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.JsonUtils;

import java.io.IOException;
import java.util.Date;

@WebServlet("/annonce/*")
public class CandidatureServlet extends HttpServlet {
    private CandidatureService candidatureService;

    public void init() {
        this.candidatureService = new CandidatureService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pathInfo = request.getPathInfo();
        String[] pathParts = pathInfo.split("/");

        if (pathParts.length == 3 && "candidature".equals(pathParts[2])) {
            int idCandidature;
            try {
                idCandidature = Integer.parseInt(pathParts[1]);
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid offer ID");
                return;
            }

            CandidatureEntity candidature = candidatureService.getCandidatureByOfferId(idCandidature);
            if (candidature == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "No candidature found for offer ID " + idCandidature);
                return;
            }

            String jsonResponse = JsonUtils.convertToJson(candidature);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(jsonResponse);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid URL format");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pathInfo = request.getPathInfo();
        String[] pathParts = pathInfo.split("/");

        if (pathParts.length == 3 && "candidature".equals(pathParts[2])) {
            int idCandidature;
            try {
                idCandidature = Integer.parseInt(pathParts[1]);
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid offer ID");
                return;
            }

            CandidatureEntity newCandidature = candidatureService.parseCandidatureFromRequest(request);

            if (newCandidature == null) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid candidature data");
                return;
            }

            boolean saveSuccess = candidatureService.saveCandidature(newCandidature);

            if (!saveSuccess) {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Could not save candidature");
            } else {
                response.setStatus(HttpServletResponse.SC_CREATED);
                response.getWriter().write("Candidature created successfully for offer ID: " + idCandidature);
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid URL format");
        }
    }
}