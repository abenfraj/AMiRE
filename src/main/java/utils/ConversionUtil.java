package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fr.amire.entities.AnnonceEntity;
import com.fr.amire.entities.CandidatureEntity;
import com.fr.amire.entities.EcoleEntity;
import com.fr.amire.entities.EnseignantEntity;

import java.util.List;

public class ConversionUtil {

    public static String convertEcoleListToJson(List<EcoleEntity> ecoles) {
        StringBuilder jsonBuilder = new StringBuilder("[");
        for (int i = 0; i < ecoles.size(); i++) {
            EcoleEntity ecole = ecoles.get(i);
            jsonBuilder.append("{")
                    .append("\"id\":").append(ecole.getIdEcole()).append(",")
                    .append("\"raisonSociale\":\"").append(ecole.getRaisonSociale()).append("\",")
                    .append("\"competences\":\"").append(ecole.getCompetences()).append("\",")
                    .append("\"besoins\":\"").append(ecole.getBesoins()).append("\",")
                    .append("\"exigences\":\"").append(ecole.getExigences()).append("\",")
                    .append("\"periode\":\"").append(ecole.getPeriode()).append("\",")
                    .append("\"remarques\":\"").append(ecole.getRemarques()).append("\"")
                    .append("}");
            if (i < ecoles.size() - 1) {
                jsonBuilder.append(", ");
            }
        }
        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }

    public static String convertSingleEcoleToJson(EcoleEntity ecole) {
        StringBuilder jsonBuilder = new StringBuilder("[");
        jsonBuilder.append("{")
                .append("\"id\":").append(ecole.getIdEcole()).append(",")
                .append("\"raisonSociale\":\"").append(ecole.getRaisonSociale()).append("\",")
                .append("\"competences\":\"").append(ecole.getCompetences()).append("\",")
                .append("\"besoins\":\"").append(ecole.getBesoins()).append("\",")
                .append("\"exigences\":\"").append(ecole.getExigences()).append("\",")
                .append("\"periode\":\"").append(ecole.getPeriode()).append("\",")
                .append("\"remarques\":\"").append(ecole.getRemarques()).append("\"")
                .append("}");

        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }

    public static String convertAnnonceListToJson(List<AnnonceEntity> annonces) {
        StringBuilder jsonBuilder = new StringBuilder("[");
        for (int i = 0; i < annonces.size(); i++) {
            AnnonceEntity annonce = annonces.get(i);
            jsonBuilder.append("{")
                    .append("\"id\":").append(annonce.getIdAnnonce()).append(",")
                    .append("\"titre\":\"").append(annonce.getTitre()).append("\",")
                    .append("\"niveauxSouhaites\":\"").append(annonce.getNiveauxSouhaites()).append("\",")
                    .append("\"typeDeContrat\":\"").append(annonce.getTypeDeContrat()).append("\",")
                    .append("\"description\":\"").append(annonce.getDescription()).append("\",")
                    .append("\"idEcole\":").append(annonce.getIdEcole()).append(",")
                    .append("\"expirationAnnonce\":\"").append(annonce.getExpirationAnnonce()).append("\"")
                    .append("}");
            if (i < annonces.size() - 1) {
                jsonBuilder.append(", ");
            }
        }
        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }

    public static String convertCandidatureListToJson(List<CandidatureEntity> candidatures) {
        StringBuilder jsonBuilder = new StringBuilder("[");
        for (int i = 0; i < candidatures.size(); i++) {
            CandidatureEntity candidature = candidatures.get(i);
            jsonBuilder.append("{")
                    .append("\"idCandidature\":").append(candidature.getIdCandidature()).append(",")
                    .append("\"dateCandidature\":\"").append(candidature.getDateCandidature()).append("\",")
                    .append("\"contacteParPersonne\":\"").append(candidature.getContacteParPersonne()).append("\",")
                    .append("\"contacteLe\":\"").append(candidature.getContacteLe()).append("\",")
                    .append("\"decision\":\"").append(candidature.getDecision()).append("\",")
                    .append("\"idEnseignant\":").append(candidature.getIdEnseignant())
                    .append("}");
            if (i < candidatures.size() - 1) {
                jsonBuilder.append(", ");
            }
        }
        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }


    public static String convertSingleCandidatureToJson(CandidatureEntity candidature) {
        return "{"
                + "\"idCandidature\":" + candidature.getIdCandidature() + ","
                + "\"dateCandidature\":\"" + candidature.getDateCandidature() + "\","
                + "\"contacteParPersonne\":\"" + candidature.getContacteParPersonne() + "\","
                + "\"contacteLe\":\"" + candidature.getContacteLe() + "\","
                + "\"decision\":\"" + candidature.getDecision() + "\","
                + "\"idEnseignant\":" + candidature.getIdEnseignant()
                + "}";
    }

    public static String convertSingleEnseignantToJson(EnseignantEntity enseignant) {
        StringBuilder jsonBuilder = new StringBuilder("{");
        jsonBuilder
                .append("\"idEnseignant\":").append(enseignant.getIdEnseignant()).append(",")
                .append("\"nomEnseignant\":\"").append(enseignant.getNomEnseignant()).append("\",")
                .append("\"prenomEnseignant\":\"").append(enseignant.getPrenomEnseignant()).append("\",")
                .append("\"siteWeb\":\"").append(enseignant.getSiteWeb()).append("\",")
                .append("\"email\":\"").append(enseignant.getEmail()).append("\",")
                .append("\"telephone\":\"").append(enseignant.getTelephone()).append("\",")
                .append("\"typeDeContrat\":\"").append(enseignant.getTypeDeContrat()).append("\",")
                .append("\"disponibilites\":\"").append(enseignant.getDisponibilites()).append("\",")
                .append("\"competences\":\"").append(enseignant.getCompetences()).append("\",")
                .append("\"interetEcole\":\"").append(enseignant.getInteretEcole()).append("\",")
                .append("\"interetDomaines\":\"").append(enseignant.getInteretDomaines()).append("\",")
                .append("\"niveauxSouhaites\":\"").append(enseignant.getNiveauxSouhaites()).append("\",")
                .append("\"experience\":\"").append(enseignant.getExperience()).append("\",")
                .append("\"titresAcademiques\":\"").append(enseignant.getTitresAcademiques()).append("\",")
                .append("\"divers\":\"").append(enseignant.getDivers()).append("\",")
                .append("\"recommandations\":\"").append(enseignant.getRecommandations()).append("\",")
                .append("\"evaluation\":\"").append(enseignant.getEvaluation()).append("\"")
                .append("}");
        return jsonBuilder.toString();
    }

    public static String convertEnseignantListToJson(List<EnseignantEntity> enseignants) {
        StringBuilder jsonBuilder = new StringBuilder("[");
        for (int i = 0; i < enseignants.size(); i++) {
            EnseignantEntity enseignant = enseignants.get(i);
            jsonBuilder.append("{")
                    .append("\"idEnseignant\":").append(enseignant.getIdEnseignant()).append(",")
                    .append("\"nomEnseignant\":\"").append(enseignant.getNomEnseignant()).append("\",")
                    .append("\"prenomEnseignant\":\"").append(enseignant.getPrenomEnseignant()).append("\",")
                    .append("\"siteWeb\":\"").append(enseignant.getSiteWeb()).append("\",")
                    .append("\"email\":\"").append(enseignant.getEmail()).append("\",")
                    .append("\"telephone\":").append(enseignant.getTelephone()).append(",")
                    .append("\"typeDeContrat\":\"").append(enseignant.getTypeDeContrat()).append("\",")
                    .append("\"disponibilites\":\"").append(enseignant.getDisponibilites()).append("\",")
                    .append("\"competences\":\"").append(enseignant.getCompetences()).append("\",")
                    .append("\"interetEcole\":\"").append(enseignant.getInteretEcole()).append("\",")
                    .append("\"interetDomaines\":\"").append(enseignant.getInteretDomaines()).append("\",")
                    .append("\"niveauxSouhaites\":\"").append(enseignant.getNiveauxSouhaites()).append("\",")
                    .append("\"experience\":\"").append(enseignant.getExperience()).append("\",")
                    .append("\"titresAcademiques\":\"").append(enseignant.getTitresAcademiques()).append("\",")
                    .append("\"divers\":\"").append(enseignant.getDivers()).append("\",")
                    .append("\"recommandations\":\"").append(enseignant.getRecommandations()).append("\",")
                    .append("\"evaluation\":\"").append(enseignant.getEvaluation()).append("\"")
                    .append("}");
            if (i < enseignants.size() - 1) {
                jsonBuilder.append(", ");
            }
        }
        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }

    public static EnseignantEntity convertJsonToEnseignant(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            EnseignantEntity enseignant = mapper.readValue(json, EnseignantEntity.class);
            return enseignant;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static EcoleEntity convertJsonToEcole(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            EcoleEntity ecole = mapper.readValue(json, EcoleEntity.class);
            return ecole;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static CandidatureEntity convertJsonToCandidature(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, CandidatureEntity.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

}
