import type { AnnonceEntity, CandidatureEntity } from "./entities";
import {
  __tmpAnnonces,
  __tmpCandidatures,
  __tmpStores,
  __tmpTeacher,
  tmpPause,
} from "./tmpMemoryDB";
import axios from "axios";
import {API_ENDPOINT} from "./entities";

export class AnnonceApi {
  /**
   * Créer une offre de recrutement pour l'école actuelle.
   * 401 si l'utilisateur n'est pas une école
   * POST /annonce/
   */
  public static async createAnnonce(
    annonce: Omit<AnnonceEntity, "id" | "idEcole" | "nbCandidatures">,
  ): Promise<AnnonceEntity[]> {
    __tmpAnnonces.push({
      ...annonce,
      id: __tmpAnnonces.length + 1,
      idEcole: __tmpStores.ecoleId,
      nbCandidatures: 2,
    });
    return __tmpAnnonces;
  }

  /**
   * Lister toutes les annonces pour l'école actuelle
   * 401 si l'utilisateur n'est pas une école
   * GET /annonce/
   */
  public static async getAnnonces(): Promise<AnnonceEntity[]> {
    const req = await axios.get<AnnonceEntity[]>(`${API_ENDPOINT}/annonce`);
    return req.data;
  }

  /**
   * Recherche une annonce. Uniquement pour les enseignants.
   * POST /annonce/search?q=<query>
   * @param query
   */
  public async searchAnnonce(query: string): Promise<AnnonceEntity[]> {
    return __tmpAnnonces.filter(
      (a) => a.titre.includes(query) || a.description.includes(query),
    );
  }

  /**
   * Permet à l'enseignant actuel de candidater à une annonce.
   * 401 si l'utilisateur actuel n'est pas enseignant
   * POST /annonce/:offerId/candidature/
   * @param offerId
   */
  public static async createCandidature(offerId: number): Promise<void> {
    const annonce = __tmpAnnonces.find((a) => a.id === offerId);
    if (!annonce) {
      throw new Error("404 Annonce (offerId) not found");
    }
    __tmpCandidatures.push({
      idCandidature: __tmpCandidatures.length + 1,
      dateCandidature: new Date().toISOString(),
      contacteParPersonne: "N/A",
      contacteLe: "N/A",
      decision: "Attente",
      idEnseignant: __tmpTeacher.idEnseignant,
      annonce,
      enseignant: __tmpTeacher,
    });
  }

  /**
   * Voir les candidatures (détail) d'une annonce
   * 401 si l'utilisateur actuel n'est pas école
   * GET /annonce/:offerId/candidature/
   */
  public static async getCandidaturesOfOffer(
    offerId: number,
  ): Promise<CandidatureEntity[]> {
    const req = await axios.get(`${API_ENDPOINT}/candidatures/${offerId}`);
    return req.data;
  }

  /**
   * Répondre à une candidature (changer son statut)
   * 401 si l'utilisateur actuel n'est pas école
   * PATCH /candidature/:candidatureId
   */
  public static async saveCandidature(
    candidature: Partial<CandidatureEntity>,
  ): Promise<CandidatureEntity> {
    const req = await axios.post(`${API_ENDPOINT}/candidatures/${candidature.idCandidature}`, candidature);
    return req.data;
  }
}
