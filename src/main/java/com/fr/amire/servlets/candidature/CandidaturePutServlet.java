package com.fr.amire.servlets.candidature;

import com.fr.amire.entities.CandidatureEntity;
import com.fr.amire.services.CandidatureService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.ConversionUtil;

import java.io.IOException;
import java.util.stream.Collectors;

import static utils.ApiException.ID_EQUALS_ZERO;
import static utils.ApiException.INVALID_DATA_GIVEN_IN_BODY;

@WebServlet("/candidature/put")
public class CandidaturePutServlet extends HttpServlet {

    private CandidatureService candidatureService;

    public void init() {
        this.candidatureService = new CandidatureService();
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idCandidature = Integer.parseInt(request.getParameter("id"));

        if (idCandidature == 0) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, ID_EQUALS_ZERO);
            return;
        }

        String requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        CandidatureEntity candidatureFromBody = ConversionUtil.convertJsonToCandidature(requestBody);

        if (candidatureFromBody == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, INVALID_DATA_GIVEN_IN_BODY);
            return;
        }

        boolean success = candidatureService.updateCandidature(idCandidature, candidatureFromBody);

        if (success) {
            CandidatureEntity updatedCandidature = candidatureService.getCandidatureById(idCandidature);

            String updatedCandidatureJson = ConversionUtil.convertSingleCandidatureToJson(updatedCandidature);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(updatedCandidatureJson);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Candidature not found with ID: " + idCandidature);
        }
    }
}
