package com.fr.amire.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "annonce", schema = "amire", catalog = "")
public class AnnonceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idAnnonce", nullable = false)
    private int idAnnonce;
    @Basic
    @Column(name = "titre", nullable = true, length = 256)
    private String titre;
    @Basic
    @Column(name = "niveauxSouhaites", nullable = true, length = 256)
    private String niveauxSouhaites;
    @Basic
    @Column(name = "typeDeContrat", nullable = true, length = 256)
    private String typeDeContrat;
    @Basic
    @Column(name = "description", nullable = true, length = 256)
    private String description;
    @Basic
    @Column(name = "idEcole", nullable = true)
    private Integer idEcole;
    @Basic
    @Column(name = "expirationAnnonce", nullable = true, length = 256)
    private String expirationAnnonce;

    public int getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(int idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNiveauxSouhaites() {
        return niveauxSouhaites;
    }

    public void setNiveauxSouhaites(String niveauxSouhaites) {
        this.niveauxSouhaites = niveauxSouhaites;
    }

    public String getTypeDeContrat() {
        return typeDeContrat;
    }

    public void setTypeDeContrat(String typeDeContrat) {
        this.typeDeContrat = typeDeContrat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIdEcole() {
        return idEcole;
    }

    public void setIdEcole(Integer idEcole) {
        this.idEcole = idEcole;
    }

    public String getExpirationAnnonce() {
        return expirationAnnonce;
    }

    public void setExpirationAnnonce(String expirationAnnonce) {
        this.expirationAnnonce = expirationAnnonce;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnnonceEntity that = (AnnonceEntity) o;

        if (idAnnonce != that.idAnnonce) return false;
        if (titre != null ? !titre.equals(that.titre) : that.titre != null) return false;
        if (niveauxSouhaites != null ? !niveauxSouhaites.equals(that.niveauxSouhaites) : that.niveauxSouhaites != null)
            return false;
        if (typeDeContrat != null ? !typeDeContrat.equals(that.typeDeContrat) : that.typeDeContrat != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (idEcole != null ? !idEcole.equals(that.idEcole) : that.idEcole != null) return false;
        if (expirationAnnonce != null ? !expirationAnnonce.equals(that.expirationAnnonce) : that.expirationAnnonce != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAnnonce;
        result = 31 * result + (titre != null ? titre.hashCode() : 0);
        result = 31 * result + (niveauxSouhaites != null ? niveauxSouhaites.hashCode() : 0);
        result = 31 * result + (typeDeContrat != null ? typeDeContrat.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (idEcole != null ? idEcole.hashCode() : 0);
        result = 31 * result + (expirationAnnonce != null ? expirationAnnonce.hashCode() : 0);
        return result;
    }
}
