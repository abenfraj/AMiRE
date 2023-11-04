package com.fr.amire.servlets.candidature;

import com.fr.amire.entities.CandidatureEntity;
import com.fr.amire.services.CandidatureService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.ConvertClass;

import java.io.IOException;

import static utils.ApiException.*;

@WebServlet("/candidature")
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
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, WRONG_OFFER_ID);
                return;
            }

            CandidatureEntity candidature = candidatureService.getCandidatureByOfferId(idCandidature);
            if (candidature == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, NO_CANDIDATURE_FOUND + idCandidature);
                return;
            }

            String jsonResponse = ConvertClass.convertCandidatureToJson(candidature);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(jsonResponse);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, WRONG_URL_FORMAT);
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
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, WRONG_OFFER_ID);
                return;
            }

            CandidatureEntity newCandidature = candidatureService.parseCandidatureFromRequest(request);

            if (newCandidature == null) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, INVALID_CANDIDATURE_DATA);
                return;
            }

            boolean saveSuccess = candidatureService.saveCandidature(newCandidature);

            if (!saveSuccess) {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, SAVE_CANDIDATURE_ERROR);
            } else {
                response.setStatus(HttpServletResponse.SC_CREATED);
                response.getWriter().write("Candidature created successfully for offer ID: " + idCandidature);
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, WRONG_URL_FORMAT);
        }
    }
}