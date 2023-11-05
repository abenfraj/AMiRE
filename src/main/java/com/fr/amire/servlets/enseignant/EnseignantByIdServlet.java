package com.fr.amire.servlets.enseignant;

import com.fr.amire.entities.EnseignantEntity;
import com.fr.amire.services.EnseignantService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.ConvertClass;

import java.io.IOException;

import static utils.ApiException.ID_EQUALS_ZERO;
import static utils.ApiException.PARAMETER_MISSING_IN_REQUEST;

@WebServlet("/enseignantById")
public class EnseignantByIdServlet extends HttpServlet {

    private EnseignantService enseignantService;

    public void init() {
        this.enseignantService = new EnseignantService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String getRequestParameter = request.getParameter("id");
        int idEnseignant = Integer.parseInt(request.getParameter("id"));
        if (idEnseignant == 0) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, ID_EQUALS_ZERO);
            return;
        } else if (getRequestParameter.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, PARAMETER_MISSING_IN_REQUEST);
            return;
        }

        EnseignantEntity enseignant = enseignantService.getEnseignantById(idEnseignant);
        String jsonResponse = ConvertClass.convertSingleEnseignantToJson(enseignant);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse);
    }
}

