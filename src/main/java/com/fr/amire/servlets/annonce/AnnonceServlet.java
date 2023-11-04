package com.fr.amire.servlets.annonce;

import com.fr.amire.entities.AnnonceEntity;
import com.fr.amire.services.AnnonceService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.ConvertClass;

import java.io.IOException;
import java.util.List;

@WebServlet("/annonce")
public class AnnonceServlet extends HttpServlet {

    private AnnonceService annonceService;

    public void init() {
        this.annonceService = new AnnonceService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<AnnonceEntity> annonces = annonceService.getAllAnnonces();

        String jsonResponse = ConvertClass.convertAnnonceListToJson(annonces);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonResponse);
    }
}
