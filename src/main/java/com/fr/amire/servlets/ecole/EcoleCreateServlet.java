package com.fr.amire.servlets.ecole;

import com.fr.amire.entities.AccountEntity;
import com.fr.amire.entities.EcoleEntity;
import com.fr.amire.services.AccountService;
import com.fr.amire.services.EcoleService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.JsonUtils;

import java.io.BufferedReader;
import java.io.IOException;

import static utils.ApiException.INVALID_DATA_GIVEN_IN_BODY;

@WebServlet("/ecole/create")
public class EcoleCreateServlet extends HttpServlet {

    private EcoleService ecoleService;
    private AccountService accountService;

    public void init() {
        this.ecoleService = new EcoleService();
        this.accountService = new AccountService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuilder requestBody = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            requestBody.append(line);
        }

        EcoleEntity newEcole = JsonUtils.convertJsonToEcole(requestBody.toString());
        if (newEcole != null) {
            ecoleService.save(newEcole);

            AccountEntity newAccount = new AccountEntity();
            newAccount.setName(newEcole.getUsername());
            newAccount.setPassword(newEcole.getPassword());
            newAccount.setEcole(newEcole);

            accountService.saveAccount(newAccount);

            response.setStatus(HttpServletResponse.SC_CREATED);
            String createdEcole = JsonUtils.convertToJson(newEcole);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(createdEcole);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, INVALID_DATA_GIVEN_IN_BODY);
        }
    }
}
