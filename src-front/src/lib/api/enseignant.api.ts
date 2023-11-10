import type { CandidatureEntity, EnseignantEntity } from "./entities";
import { __tmpCandidatures, __tmpTeacher, tmpPause } from "./tmpMemoryDB";
import axios from "axios";
import {API_ENDPOINT} from "./entities";

export class EnseignantApi {
  /**
   * GET /teacher/:id
   * @returns {EnseignantEntity}
   */
  public static async getEnseignant(id: number): Promise<EnseignantEntity> {
    const req =
        await axios.get<EnseignantEntity>(`${API_ENDPOINT}/enseignantById?id=${id}`);
    return req.data;
  }

  /**
   * !! Back : Vérifier qu'on est bien admin.
   * PATCH /teacher/:id
   */
  public static async saveEnseignant(
    id: number,
    teacher: Partial<EnseignantEntity>,
  ): Promise<EnseignantEntity> {
    const req =
        await axios.put<EnseignantEntity>(`${API_ENDPOINT}/enseignant/put?id=${id}`, teacher);
    return req.data;
  }

  /**
   * !! Back : Afficher seulement les candidatures du professeur actuel.
   * GET /teacher/:id/candidatures
   */
  public static async getCandidatures(userId: number): Promise<CandidatureEntity[]> {
    await tmpPause();
    const req = await axios.get(`${API_ENDPOINT}/candidature/${userId}`);
    return req.data;
  }
}
