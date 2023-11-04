package com.fr.amire.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "enseignant", schema = "amire", catalog = "")
public class EnseignantEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idenseignant", nullable = false)
    private int idenseignant;
    @Basic
    @Column(name = "nomEnseignant", nullable = true, length = 256)
    private String nomEnseignant;
    @Basic
    @Column(name = "prenomEnseignant", nullable = true, length = 256)
    private String prenomEnseignant;
    @Basic
    @Column(name = "siteWeb", nullable = true, length = 256)
    private String siteWeb;
    @Basic
    @Column(name = "email", nullable = true, length = 256)
    private String email;
    @Basic
    @Column(name = "telephone", nullable = true, length = 256)
    private String telephone;
    @Basic
    @Column(name = "typeDeContrat", nullable = true, length = 256)
    private String typeDeContrat;
    @Basic
    @Column(name = "disponibilites", nullable = true, length = 256)
    private String disponibilites;
    @Basic
    @Column(name = "competences", nullable = true, length = 256)
    private String competences;
    @Basic
    @Column(name = "interetEcole", nullable = true, length = 256)
    private String interetEcole;
    @Basic
    @Column(name = "interetDomaines", nullable = true, length = 256)
    private String interetDomaines;
    @Basic
    @Column(name = "niveauxSouhaites", nullable = true, length = 256)
    private String niveauxSouhaites;
    @Basic
    @Column(name = "experience", nullable = true, length = 256)
    private String experience;
    @Basic
    @Column(name = "titresAcademiques", nullable = true, length = 256)
    private String titresAcademiques;
    @Basic
    @Column(name = "divers", nullable = true, length = 256)
    private String divers;
    @Basic
    @Column(name = "recommandations", nullable = true, length = 256)
    private String recommandations;
    @Basic
    @Column(name = "evaluation", nullable = true, length = 256)
    private String evaluation;

    public int getIdenseignant() {
        return idenseignant;
    }

    public void setIdenseignant(int idenseignant) {
        this.idenseignant = idenseignant;
    }

    public String getNomEnseignant() {
        return nomEnseignant;
    }

    public void setNomEnseignant(String nomEnseignant) {
        this.nomEnseignant = nomEnseignant;
    }

    public String getPrenomEnseignant() {
        return prenomEnseignant;
    }

    public void setPrenomEnseignant(String prenomEnseignant) {
        this.prenomEnseignant = prenomEnseignant;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTypeDeContrat() {
        return typeDeContrat;
    }

    public void setTypeDeContrat(String typeDeContrat) {
        this.typeDeContrat = typeDeContrat;
    }

    public String getDisponibilites() {
        return disponibilites;
    }

    public void setDisponibilites(String disponibilites) {
        this.disponibilites = disponibilites;
    }

    public String getCompetences() {
        return competences;
    }

    public void setCompetences(String competences) {
        this.competences = competences;
    }

    public String getInteretEcole() {
        return interetEcole;
    }

    public void setInteretEcole(String interetEcole) {
        this.interetEcole = interetEcole;
    }

    public String getInteretDomaines() {
        return interetDomaines;
    }

    public void setInteretDomaines(String interetDomaines) {
        this.interetDomaines = interetDomaines;
    }

    public String getNiveauxSouhaites() {
        return niveauxSouhaites;
    }

    public void setNiveauxSouhaites(String niveauxSouhaites) {
        this.niveauxSouhaites = niveauxSouhaites;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getTitresAcademiques() {
        return titresAcademiques;
    }

    public void setTitresAcademiques(String titresAcademiques) {
        this.titresAcademiques = titresAcademiques;
    }

    public String getDivers() {
        return divers;
    }

    public void setDivers(String divers) {
        this.divers = divers;
    }

    public String getRecommandations() {
        return recommandations;
    }

    public void setRecommandations(String recommandations) {
        this.recommandations = recommandations;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EnseignantEntity that = (EnseignantEntity) o;

        if (idenseignant != that.idenseignant) return false;
        if (nomEnseignant != null ? !nomEnseignant.equals(that.nomEnseignant) : that.nomEnseignant != null)
            return false;
        if (prenomEnseignant != null ? !prenomEnseignant.equals(that.prenomEnseignant) : that.prenomEnseignant != null)
            return false;
        if (siteWeb != null ? !siteWeb.equals(that.siteWeb) : that.siteWeb != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;
        if (typeDeContrat != null ? !typeDeContrat.equals(that.typeDeContrat) : that.typeDeContrat != null)
            return false;
        if (disponibilites != null ? !disponibilites.equals(that.disponibilites) : that.disponibilites != null)
            return false;
        if (competences != null ? !competences.equals(that.competences) : that.competences != null) return false;
        if (interetEcole != null ? !interetEcole.equals(that.interetEcole) : that.interetEcole != null) return false;
        if (interetDomaines != null ? !interetDomaines.equals(that.interetDomaines) : that.interetDomaines != null)
            return false;
        if (niveauxSouhaites != null ? !niveauxSouhaites.equals(that.niveauxSouhaites) : that.niveauxSouhaites != null)
            return false;
        if (experience != null ? !experience.equals(that.experience) : that.experience != null) return false;
        if (titresAcademiques != null ? !titresAcademiques.equals(that.titresAcademiques) : that.titresAcademiques != null)
            return false;
        if (divers != null ? !divers.equals(that.divers) : that.divers != null) return false;
        if (recommandations != null ? !recommandations.equals(that.recommandations) : that.recommandations != null)
            return false;
        if (evaluation != null ? !evaluation.equals(that.evaluation) : that.evaluation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idenseignant;
        result = 31 * result + (nomEnseignant != null ? nomEnseignant.hashCode() : 0);
        result = 31 * result + (prenomEnseignant != null ? prenomEnseignant.hashCode() : 0);
        result = 31 * result + (siteWeb != null ? siteWeb.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (typeDeContrat != null ? typeDeContrat.hashCode() : 0);
        result = 31 * result + (disponibilites != null ? disponibilites.hashCode() : 0);
        result = 31 * result + (competences != null ? competences.hashCode() : 0);
        result = 31 * result + (interetEcole != null ? interetEcole.hashCode() : 0);
        result = 31 * result + (interetDomaines != null ? interetDomaines.hashCode() : 0);
        result = 31 * result + (niveauxSouhaites != null ? niveauxSouhaites.hashCode() : 0);
        result = 31 * result + (experience != null ? experience.hashCode() : 0);
        result = 31 * result + (titresAcademiques != null ? titresAcademiques.hashCode() : 0);
        result = 31 * result + (divers != null ? divers.hashCode() : 0);
        result = 31 * result + (recommandations != null ? recommandations.hashCode() : 0);
        result = 31 * result + (evaluation != null ? evaluation.hashCode() : 0);
        return result;
    }
}
