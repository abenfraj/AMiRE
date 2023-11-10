package com.fr.amire.servlets.ecole;

import com.fr.amire.services.EcoleService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static utils.ApiException.INVALID_DATA_GIVEN_IN_BODY;

@WebServlet("/ecole/delete")
public class EcoleDeleteServlet extends HttpServlet {

    private EcoleService ecoleService;

    public void init() {
        this.ecoleService = new EcoleService();
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ecoleIdParam = request.getParameter("id");

        if (ecoleIdParam != null && !ecoleIdParam.isEmpty()) {
            try {
                int ecoleId = Integer.parseInt(ecoleIdParam);
                ecoleService.delete(ecoleId);

                response.setStatus(HttpServletResponse.SC_OK);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("{\"message\": \"Ecole deleted successfully\"}");
            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, INVALID_DATA_GIVEN_IN_BODY);
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, INVALID_DATA_GIVEN_IN_BODY);
        }
    }
}
