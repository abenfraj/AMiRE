package com.fr.amire.servlets.ecole;

import com.fr.amire.entities.EcoleEntity;
import com.fr.amire.services.EcoleService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.JsonUtils;

import java.io.IOException;

import static utils.ApiException.ID_EQUALS_ZERO;
import static utils.ApiException.PARAMETER_MISSING_IN_REQUEST;

@WebServlet("/ecoleById")
public class EcoleByIdServlet extends HttpServlet {

    private EcoleService ecoleService;

    public void init() {
        this.ecoleService = new EcoleService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String getRequestParameter = request.getParameter("id");
        int idEcole = Integer.parseInt(request.getParameter("id"));
        if (idEcole == 0) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, ID_EQUALS_ZERO);
            return;
        } else if (getRequestParameter.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, PARAMETER_MISSING_IN_REQUEST);
            return;
        }

        EcoleEntity ecole = ecoleService.getEcoleById(idEcole);
        String jsonResponse = JsonUtils.convertToJson(ecole);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse);
    }
}

