package com.fr.amire.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ecole", schema = "amire", catalog = "")
public class EcoleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idEcole", nullable = false)
    private int idEcole;
    @Basic
    @Column(name = "raisonSociale", nullable = true, length = 256)
    private String raisonSociale;
    @Basic
    @Column(name = "competences", nullable = true, length = 4256)
    private String competences;
    @Basic
    @Column(name = "besoins", nullable = true, length = 256)
    private String besoins;
    @Basic
    @Column(name = "exigences", nullable = true, length = 256)
    private String exigences;
    @Basic
    @Column(name = "periode", nullable = true, length = 256)
    private String periode;
    @Basic
    @Column(name = "remarques", nullable = true, length = 256)
    private String remarques;

    public int getIdEcole() {
        return idEcole;
    }

    public void setIdEcole(int idEcole) {
        this.idEcole = idEcole;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getCompetences() {
        return competences;
    }

    public void setCompetences(String competences) {
        this.competences = competences;
    }

    public String getBesoins() {
        return besoins;
    }

    public void setBesoins(String besoins) {
        this.besoins = besoins;
    }

    public String getExigences() {
        return exigences;
    }

    public void setExigences(String exigences) {
        this.exigences = exigences;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcoleEntity that = (EcoleEntity) o;

        if (idEcole != that.idEcole) return false;
        if (raisonSociale != null ? !raisonSociale.equals(that.raisonSociale) : that.raisonSociale != null)
            return false;
        if (competences != null ? !competences.equals(that.competences) : that.competences != null) return false;
        if (besoins != null ? !besoins.equals(that.besoins) : that.besoins != null) return false;
        if (exigences != null ? !exigences.equals(that.exigences) : that.exigences != null) return false;
        if (periode != null ? !periode.equals(that.periode) : that.periode != null) return false;
        if (remarques != null ? !remarques.equals(that.remarques) : that.remarques != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEcole;
        result = 31 * result + (raisonSociale != null ? raisonSociale.hashCode() : 0);
        result = 31 * result + (competences != null ? competences.hashCode() : 0);
        result = 31 * result + (besoins != null ? besoins.hashCode() : 0);
        result = 31 * result + (exigences != null ? exigences.hashCode() : 0);
        result = 31 * result + (periode != null ? periode.hashCode() : 0);
        result = 31 * result + (remarques != null ? remarques.hashCode() : 0);
        return result;
    }
}
