import type { CandidatureEntity, EnseignantEntity } from "./entities";
import { __tmpCandidatures, __tmpTeacher, tmpPause } from "./tmpMemoryDB";
import axios from "axios";


const API_ENDPOINT = document.location.port  === "5173" ? "http://localhost:8080/AMiRE-1.0-SNAPSHOT" : ".";

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
  public static async getCandidatures(): Promise<CandidatureEntity[]> {
    await tmpPause();
    return __tmpCandidatures.filter(
      (c) => c.idEnseignant === __tmpTeacher.idEnseignant,
    );
  }
}
