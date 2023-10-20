export type AnnonceEntity = {
    id: number,
    titre: string,
    niveauxSouhaites: string,
    typeDeContrat: string,
    description: string,
    idEcole: number;
    expirationAnnonce: string;
};
export type CandidatureEntity = {
    idCandidature: number,
    dateCandidature: string,
    contacteParPersonne: string,
    contacteLe: string,
    decision: string,
    idEnseignant: number,
    
    annonce?: AnnonceEntity
    enseignant?: EnseignantEntity
}

export type EnseignantEntity = {
    idEnseignant: number,
    nomEnseignant: string,
    prenomEnseignant: string,
    siteWeb: string,
    email: string,
    telephone: string,

    typeDeContrat: string,
    disponibilites: string,
    competences: string,
    interetEcole: string,
    interetsDomaines: string,
    niveauxSouhaites: string,

    experience: string,
    titresAcademiques: string,
    divers: string,
    recommandations: string,
    evaluation: string,
};

export type EcoleEntity = {
    idEcole: number;
    raisonSociale: string;
    competences: string;
    besoins: string; 
    exigences: string; 
    periode: string;
    remarques: string;
}