package com.fr.amire.servlets.ecole;

import com.fr.amire.entities.EcoleEntity;
import com.fr.amire.services.EcoleService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.JsonUtils;

import java.io.IOException;
import java.util.List;

@WebServlet("/ecole")
public class EcoleServlet extends HttpServlet {

    private EcoleService ecoleService;

    public void init() {
        this.ecoleService = new EcoleService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<EcoleEntity> ecoles = ecoleService.getAllEcoles();

        String jsonResponse = JsonUtils.convertToJson(ecoles);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse);
    }
}
