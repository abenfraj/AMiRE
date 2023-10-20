import type { EcoleEntity } from "./entities";
import { __tmpEcoles } from "./tmpMemoryDB";


export class EcoleApi {
    /**
     * Crée une école
     * 401 si l'utilisateur n'est pas admin
     * POST /ecole/
     */
    public static async createEcole(ecole: Omit<EcoleEntity, "idEcole">): Promise<EcoleEntity[]> {
        __tmpEcoles.push({
            ...ecole,
            idEcole: __tmpEcoles.length + 1
        });
        return __tmpEcoles;
    }

    /**
     * Liste les écoles
     * 401 si l'utilisateur n'est pas admin
     * GET /ecole/
     */
    public static async getEcoles(): Promise<EcoleEntity[]> {
        return __tmpEcoles;
    }

    /**
     * Affiche les infos d'une école.
     * GET /ecole/:id
     */
    public static async getEcole(id: number): Promise<EcoleEntity> {
        const found = __tmpEcoles.find((e) => e.idEcole === id);
        if (!found) {
            throw new Error("404 Ecole (id) not found");
        }
        return found;
    }
}