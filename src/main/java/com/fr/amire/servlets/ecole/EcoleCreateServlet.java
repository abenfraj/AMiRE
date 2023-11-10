package com.fr.amire.servlets.ecole;

import com.fr.amire.entities.EcoleEntity;
import com.fr.amire.services.EcoleService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.ConversionUtil;

import java.io.BufferedReader;
import java.io.IOException;

import static utils.ApiException.INVALID_DATA_GIVEN_IN_BODY;

@WebServlet("/ecole/create")
public class EcoleCreateServlet extends HttpServlet {

    private EcoleService ecoleService;

    public void init() {
        this.ecoleService = new EcoleService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuilder requestBody = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            requestBody.append(line);
        }
        EcoleEntity newEcole = ConversionUtil.convertJsonToEcole(requestBody.toString());

        if (newEcole != null) {
            ecoleService.save(newEcole);

            response.setStatus(HttpServletResponse.SC_CREATED);
            String createdEcole = ConversionUtil.convertSingleEcoleToJson(newEcole);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(createdEcole);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, INVALID_DATA_GIVEN_IN_BODY);
        }
    }
}
