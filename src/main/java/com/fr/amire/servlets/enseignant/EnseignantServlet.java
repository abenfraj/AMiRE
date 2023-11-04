package com.fr.amire.servlets.enseignant;

import com.fr.amire.entities.EnseignantEntity;
import com.fr.amire.services.EnseignantService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.ConvertClass;

import java.io.IOException;
import java.util.List;

@WebServlet("/enseignant")
public class EnseignantServlet extends HttpServlet {

    private EnseignantService enseignantService;

    public void init() {
        this.enseignantService = new EnseignantService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<EnseignantEntity> enseignants = enseignantService.getAllEnseigannts();

        String jsonResponse = ConvertClass.convertEnseignantListToJson(enseignants);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse);
    }
}
