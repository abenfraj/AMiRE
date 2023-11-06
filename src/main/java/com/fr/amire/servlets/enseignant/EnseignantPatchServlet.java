package com.fr.amire.servlets.enseignant;

import com.fr.amire.entities.EnseignantEntity;
import com.fr.amire.services.EnseignantService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.ApiException;
import utils.ConvertClass;

import java.io.IOException;
import java.util.stream.Collectors;

import static utils.ApiException.ID_EQUALS_ZERO;
import static utils.ApiException.INVALID_DATA_GIVEN_IN_BODY;

@WebServlet("/enseignant/patch")
public class EnseignantPatchServlet extends HttpServlet {

    private EnseignantService enseignantService;

    public void init() {
        this.enseignantService = new EnseignantService();
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idEnseignant = Integer.parseInt(request.getParameter("id"));
        if (idEnseignant == 0) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, ID_EQUALS_ZERO);
            return;
        }

        String requestBody = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        EnseignantEntity enseignantFromBody = ConvertClass.convertJsonToEnseignant(requestBody);

        if (enseignantFromBody == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, INVALID_DATA_GIVEN_IN_BODY);
            return;
        }

        boolean success = enseignantService.updateEnseignant(idEnseignant, enseignantFromBody);

        if (success) {
            EnseignantEntity updatedEnseignant = enseignantService.getEnseignantById(idEnseignant);

            String updatedEnseignantJson = ConvertClass.convertSingleEnseignantToJson(updatedEnseignant);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(updatedEnseignantJson);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Enseignant not found with ID: " + idEnseignant);
        }
    }
}


