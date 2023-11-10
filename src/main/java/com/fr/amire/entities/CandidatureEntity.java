package com.fr.amire.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "candidature", schema = "amire", catalog = "")
public class CandidatureEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCandidature", nullable = false)
    private int idCandidature;
    @Basic
    @Column(name = "dateCandidature", nullable = true, length = 45)
    private String dateCandidature;
    @Basic
    @Column(name = "contacteParPersonne", nullable = true, length = 45)
    private String contacteParPersonne;
    @Basic
    @Column(name = "contacteLe", nullable = true, length = 45)
    private String contacteLe;
    @Basic
    @Column(name = "decision", nullable = true, length = 45)
    private String decision;
    @Basic
    @Column(name = "idEnseignant", nullable = true)
    private Integer idEnseignant;

    @OneToOne
    @JoinColumn(name = "idAnnonce", referencedColumnName = "idAnnonce")
    private AnnonceEntity annonce;

    public int getIdCandidature() {
        return idCandidature;
    }

    public void setIdCandidature(int idCandidature) {
        this.idCandidature = idCandidature;
    }

    public String getDateCandidature() {
        return dateCandidature;
    }

    public String getContacteParPersonne() {
        return contacteParPersonne;
    }

    public void setContacteParPersonne(String contacteParPersonne) {
        this.contacteParPersonne = contacteParPersonne;
    }

    public String getContacteLe() {
        return contacteLe;
    }

    public void setContacteLe(String contacteLe) {
        this.contacteLe = contacteLe;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public Integer getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(Integer idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public AnnonceEntity getAnnonce() {
        return annonce;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CandidatureEntity that = (CandidatureEntity) o;

        if (idCandidature != that.idCandidature) return false;
        if (dateCandidature != null ? !dateCandidature.equals(that.dateCandidature) : that.dateCandidature != null)
            return false;
        if (contacteParPersonne != null ? !contacteParPersonne.equals(that.contacteParPersonne) : that.contacteParPersonne != null)
            return false;
        if (contacteLe != null ? !contacteLe.equals(that.contacteLe) : that.contacteLe != null) return false;
        if (decision != null ? !decision.equals(that.decision) : that.decision != null) return false;
        if (idEnseignant != null ? !idEnseignant.equals(that.idEnseignant) : that.idEnseignant != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCandidature;
        result = 31 * result + (dateCandidature != null ? dateCandidature.hashCode() : 0);
        result = 31 * result + (contacteParPersonne != null ? contacteParPersonne.hashCode() : 0);
        result = 31 * result + (contacteLe != null ? contacteLe.hashCode() : 0);
        result = 31 * result + (decision != null ? decision.hashCode() : 0);
        result = 31 * result + (idEnseignant != null ? idEnseignant.hashCode() : 0);
        return result;
    }
}
