import type { Ecole } from "./entities";


export class EcoleApi {
    /**
     * Crée une école
     * 401 si l'utilisateur n'est pas admin
     * POST /ecole/
     */
    public static async createEcole(ecole: Omit<Ecole, "idEcole">): Promise<Ecole[]> {
        EcoleApi.__tmpEcoles.push({
            ...ecole,
            idEcole: EcoleApi.__tmpEcoles.length + 1
        });
        return EcoleApi.__tmpEcoles;
    }

    /**
     * Liste les écoles
     * 401 si l'utilisateur n'est pas admin
     * GET /ecole/
     */
    public static async getEcoles(): Promise<Ecole[]> {
        return EcoleApi.__tmpEcoles;
    }

    /**
     * Affiche les infos d'une école.
     * GET /ecole/:id
     */
    public static async getEcole(id: number): Promise<Ecole> {
        const found = EcoleApi.__tmpEcoles.find((e) => e.idEcole === id);
        if (!found) {
            throw new Error("404 Ecole (id) not found");
        }
        return found;
    }


    static __tmpEcoleId = 1;
    static __tmpEcoles: Ecole[] = [
        {
            idEcole: 1,
            raisonSociale: "EFREI",
            competences: "Informatique",
            besoins: "Intervenants extérieurs pour les M1 car les gens font grève",
            exigences: "Distanciel uniquement",
            periode: "2024-2025",
            remarques: "RAS",
        }
    ];
}