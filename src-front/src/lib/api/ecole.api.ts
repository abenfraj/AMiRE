import type { EcoleEntity } from "./entities";
import { __tmpEcoles } from "./tmpMemoryDB";
import axios from "axios";
import {API_ENDPOINT} from "./entities";

export class EcoleApi {
  /**
   * Crée une école
   * 401 si l'utilisateur n'est pas admin
   * POST /ecole/
   */
  public static async createEcole(
    ecole: Omit<EcoleEntity, "id">,
  ): Promise<EcoleEntity[]> {
    const req = await axios.post(`${API_ENDPOINT}/ecole/create`, ecole);
    return req.data;
  }

  /**
   * Liste les écoles
   * 401 si l'utilisateur n'est pas admin
   * GET /ecole/
   */
  public static async getEcoles(): Promise<EcoleEntity[]> {
    const req = await axios.get(`${API_ENDPOINT}/ecole`);
    return req.data;
  }

  /**
   * Affiche les infos d'une école.
   * GET /ecole/:id
   */
  public static async getEcole(id: number): Promise<EcoleEntity> {
    const found = __tmpEcoles.find((e) => e.id === id);
    if (!found) {
      throw new Error("404 Ecole (id) not found");
    }
    return found;
  }

  public static async deleteEcole(id: number) {
    await axios.delete(`${API_ENDPOINT}/ecole?id=${id}`);
  }
}
