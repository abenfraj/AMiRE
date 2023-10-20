import { EcoleApi } from "./ecole.api";
import { EnseignantApi } from "./enseignant.api";
import type { AnnonceEntity, CandidatureEntity } from "./entities";


export class AnnonceApi {
    /**
     * Créer une offre de recrutement pour l'école actuelle.
     * 401 si l'utilisateur n'est pas une école
     * POST /annonce/
     */
    public static async createAnnonce(annonce: Omit<AnnonceEntity, "idCandidature"|"idEcole">): Promise<AnnonceEntity[]> {
        AnnonceApi.__tmpAnnonces.push({
            ...annonce,
            id: AnnonceApi.__tmpAnnonces.length + 1 ,
            idEcole: EcoleApi.__tmpEcoleId
        });
        return AnnonceApi.__tmpAnnonces;
    }

    /**
     * Lister toutes les annonces pour l'école actuelle
     * 401 si l'utilisateur n'est pas une école
     * GET /annonce/
     */
    public static async getAnnonces(): Promise<AnnonceEntity[]> {
        return AnnonceApi.__tmpAnnonces.filter((a) => a.idEcole === EcoleApi.__tmpEcoleId);
    }

    /**
     * Recherche une annonce. Uniquement pour les enseignants.
     * POST /annonce/search?q=<query>
     * @param query 
     */
    public async searchAnnonce(query: string): Promise<AnnonceEntity[]> {
        return AnnonceApi.__tmpAnnonces.filter(
            (a) => 
                a.titre.includes(query)
                || a.description.includes(query)
        );
    }

    /**
     * Permet à l'enseignant actuel de candidater à une annonce.
     * 401 si l'utilisateur actuel n'est pas enseignant
     * POST /annonce/:offerId/candidature/
     * @param offerId 
     */
    public static async createCandidature(offerId: number): Promise<void> {
        const annonce = AnnonceApi.__tmpAnnonces.find((a) => a.id === offerId);
        if (!annonce) {
            throw new Error("404 Annonce (offerId) not found");
        }
        this.__tmpCandidatures.push({
            idCandidature: AnnonceApi.__tmpCandidatures.length + 1,
            dateCandidature: new Date().toISOString(),
            contacteParPersonne: "N/A",
            contacteLe: "N/A",
            decision: "En attente",
            idEnseignant: EnseignantApi.__tmpTeacher.idEnseignant,
            annonce,
            enseignant: EnseignantApi.__tmpTeacher
        });
    }

    /**
     * Voir les candidatures (détail) d'une annonce
     * 401 si l'utilisateur actuel n'est pas école
     * GET /annonce/:offerId/candidature/
     */
    public static async getCandidaturesOfOffer(offerId: number): Promise<CandidatureEntity[]> {
        return this.__tmpCandidatures.filter((c) => c.annonce?.id === offerId);
    }

    /**
     * Répondre à une candidature (changer son statut)
     * 401 si l'utilisateur actuel n'est pas école
     * PATCH /candidature/:candidatureId
     */
    public static async saveCandidature(candidature: Partial<CandidatureEntity>): Promise<CandidatureEntity> {
        const index = this.__tmpCandidatures.findIndex((c) => c.idCandidature === candidature.idCandidature);
        if (index < 0) {
            throw new Error("404 Candidature (id) not found");
        }
        this.__tmpCandidatures[index] = {...this.__tmpCandidatures[index], ...candidature};
        return this.__tmpCandidatures[index];
    }

    static __tmpAnnonces: AnnonceEntity[] = [
        {
            id: 1,
            titre: "Professeur d'informatique",
            niveauxSouhaites: "L1,M1,M2",
            typeDeContrat: "CDI",
            description: "Nous recherchons un professeur d'informatique pour enseigner à nos étudiants",
            idEcole: 1,
            expirationAnnonce: "2024-06-30"
        }
    ];

    static __tmpCandidatures: CandidatureEntity[] = [
        {
            idCandidature: 1,
            dateCandidature: "2021-06-01",
            contacteParPersonne: "John Doe",
            contacteLe: "2021-06-15",
            decision: "En attente",
            idEnseignant: 1,
            enseignant: EnseignantApi.__tmpTeacher,
            annonce: AnnonceApi.__tmpAnnonces[0]
        }
    ];

}