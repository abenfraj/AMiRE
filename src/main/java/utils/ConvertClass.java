package utils;

import com.fr.amire.entities.AnnonceEntity;
import com.fr.amire.entities.CandidatureEntity;
import com.fr.amire.entities.EcoleEntity;
import com.fr.amire.entities.EnseignantEntity;

import java.util.List;

public class ConvertClass {

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
                    .append("\"periode\":").append(ecole.getPeriode()).append(",")
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
                .append("\"periode\":").append(ecole.getPeriode()).append(",")
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

    public static String convertCandidatureToJson(CandidatureEntity candidature) {
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
        StringBuilder jsonBuilder = new StringBuilder("[");
        jsonBuilder.append("{")
                .append("\"idEnseignant\":").append(enseignant.getIdenseignant()).append(",")
                .append("\"nomEnseignant\":\"").append(enseignant.getNomEnseignant()).append("\",")
                .append("\"prenomEnseignant\":\"").append(enseignant.getPrenomEnseignant()).append("\",")
                .append("\"siteWeb\":\"").append(enseignant.getSiteWeb()).append("\",")
                .append("\"email\":\"").append(enseignant.getEmail()).append("\",")
                .append("\"telephone\":").append(enseignant.getTelephone()).append(",")
                .append("\"typeDeContrat\":\"").append(enseignant.getTypeDeContrat()).append("\"")
                .append("\"disponibilites\":\"").append(enseignant.getDisponibilites()).append("\"")
                .append("\"competences\":\"").append(enseignant.getCompetences()).append("\"")
                .append("\"interetEcole\":\"").append(enseignant.getInteretEcole()).append("\"")
                .append("\"interetsDomaines\":\"").append(enseignant.getInteretDomaines()).append("\"")
                .append("\"niveauxSouhaites\":\"").append(enseignant.getNiveauxSouhaites()).append("\"")
                .append("\"experience\":\"").append(enseignant.getExperience()).append("\"")
                .append("\"titresAcademiques\":\"").append(enseignant.getTitresAcademiques()).append("\"")
                .append("\"divers\":\"").append(enseignant.getDivers()).append("\"")
                .append("\"recommandations\":\"").append(enseignant.getRecommandations()).append("\"")
                .append("\"evaluation\":\"").append(enseignant.getEvaluation()).append("\"")
                .append("}");

        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }

    public static String convertEnseignantListToJson(List<EnseignantEntity> enseignants) {
        StringBuilder jsonBuilder = new StringBuilder("[");
        for (int i = 0; i < enseignants.size(); i++) {
            EnseignantEntity enseignant = enseignants.get(i);
            jsonBuilder.append("{")
                    .append("\"idEnseignant\":").append(enseignant.getIdenseignant()).append(",")
                    .append("\"nomEnseignant\":\"").append(enseignant.getNomEnseignant()).append("\",")
                    .append("\"prenomEnseignant\":\"").append(enseignant.getPrenomEnseignant()).append("\",")
                    .append("\"siteWeb\":\"").append(enseignant.getSiteWeb()).append("\",")
                    .append("\"email\":\"").append(enseignant.getEmail()).append("\",")
                    .append("\"telephone\":").append(enseignant.getTelephone()).append(",")
                    .append("\"typeDeContrat\":\"").append(enseignant.getTypeDeContrat()).append("\"")
                    .append("\"disponibilites\":\"").append(enseignant.getDisponibilites()).append("\"")
                    .append("\"competences\":\"").append(enseignant.getCompetences()).append("\"")
                    .append("\"interetEcole\":\"").append(enseignant.getInteretEcole()).append("\"")
                    .append("\"interetsDomaines\":\"").append(enseignant.getInteretDomaines()).append("\"")
                    .append("\"niveauxSouhaites\":\"").append(enseignant.getNiveauxSouhaites()).append("\"")
                    .append("\"experience\":\"").append(enseignant.getExperience()).append("\"")
                    .append("\"titresAcademiques\":\"").append(enseignant.getTitresAcademiques()).append("\"")
                    .append("\"divers\":\"").append(enseignant.getDivers()).append("\"")
                    .append("\"recommandations\":\"").append(enseignant.getRecommandations()).append("\"")
                    .append("\"evaluation\":\"").append(enseignant.getEvaluation()).append("\"")
                    .append("}");
            if (i < enseignants.size() - 1) {
                jsonBuilder.append(", ");
            }
        }
        jsonBuilder.append("]");
        return jsonBuilder.toString();
    }

}
