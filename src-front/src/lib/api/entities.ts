
export const API_ENDPOINT = document.location.port  === "5173" ? "http://localhost:8080/AMiRE-1.0-SNAPSHOT" : ".";


export type AnnonceEntity = {
  id: number;
  titre: string;
  niveauxSouhaites: string;
  typeDeContrat: string;
  description: string;
  idEcole: number;
  expirationAnnonce: string;

  nbCandidatures?: number;
};
export type CandidatureEntity = {
  idCandidature: number;
  dateCandidature: string;
  contacteParPersonne: string;
  contacteLe: string;
  decision: "Attente" | "Acceptée" | "Refusée";
  idEnseignant: number;

  annonce?: AnnonceEntity;
  enseignant?: EnseignantEntity;
};

export type EnseignantEntity = {
  idEnseignant: number;
  nomEnseignant: string;
  prenomEnseignant: string;
  siteWeb: string;
  email: string;
  telephone: string;

  typeDeContrat: string;
  disponibilites: string;
  competences: string;
  interetEcole: string;
  interetDomaines: string;
  niveauxSouhaites: string;

  experience: string;
  titresAcademiques: string;
  divers: string;
  recommandations: string;
  evaluation: string;
};

export type EcoleEntity = {
  idEcole: number;
  raisonSociale: string;
  competences: string;
  besoins: string;
  exigences: string;
  periode: string;
  remarques: string;
};
