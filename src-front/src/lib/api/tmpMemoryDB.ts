import type {
  AnnonceEntity,
  CandidatureEntity,
  EcoleEntity,
  EnseignantEntity,
} from "./entities";

export const tmpPause = (): Promise<void> => {
  return new Promise((resolve) => setTimeout(resolve, 400));
};

export const __tmpStores = {
  ecoleId: 1,
};

export const __tmpTeacher: EnseignantEntity = {
  idEnseignant: 1,
  nomEnseignant: "Doe",
  prenomEnseignant: "John",
  siteWeb: "https://www.google.com",
  email: "logan.tann@efrei.net",
  telephone: "+33 06 12 34 56 78",

  typeDeContrat: "CDI,Prestation",
  disponibilites: "- de 8h à 17h",
  competences: "- pédagogie \n- informatique \n- mathématiques",
  interetEcole: "Efrei Paris,Epita,Epitech",
  interetDomaines:
    "Programmation Orientée Objet,Architecture logicielle,L'argent",
  niveauxSouhaites: "L1, M1, M2",

  experience: "Prof super crack à l'EFREI",
  titresAcademiques: "- DUT Informatique\n- Ingénieur Efrei",
  divers: "Je suis intelligent",
  recommandations: '- Créateur du livre "Comment devenir un super prof"',
  evaluation: "- IUT de Paris : Très bon prof, je recommande",
};

export const __tmpAnnonces: AnnonceEntity[] = [
  {
    id: 1,
    titre: "Professeur d'informatique",
    niveauxSouhaites: "L1,M1,M2",
    typeDeContrat: "CDI",
    description:
      "Nous recherchons un professeur d'informatique pour enseigner à nos étudiants",
    idEcole: 1,
    expirationAnnonce: "2024-06-30",
  },
];

export const __tmpCandidatures: CandidatureEntity[] = [
  {
    idCandidature: 1,
    dateCandidature: "2021-06-01",
    contacteParPersonne: "John Doe",
    contacteLe: "2021-06-15",
    decision: "Attente",
    idEnseignant: 1,
    enseignant: __tmpTeacher,
    annonce: __tmpAnnonces[0],
  },
];

export const __tmpEcoles: EcoleEntity[] = [
  {
    id: 1,
    raisonSociale: "EFREI",
    competences: "Informatique",
    besoins: "Intervenants extérieurs pour les M1 car les gens font grève",
    exigences: "Distanciel uniquement",
    periode: "2024-2025",
    remarques: "RAS",
  },
];
