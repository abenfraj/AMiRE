import { AnnonceApi } from "./annonce.api";
import type { CandidatureEntity, EnseignantEntity } from "./entities";
import { __tmpCandidatures, __tmpTeacher, tmpPause } from "./tmpMemoryDB";

export class EnseignantApi {
  /**
   * !! Back : Vérifier que l'utilisateur est bien connecté
   * GET /teacher/:id
   * @returns {EnseignantEntity}
   */
  public static async getEnseignant(id: number): Promise<EnseignantEntity> {
    await tmpPause();
    return __tmpTeacher;
  }

  /**
   * !! Back : Vérifier qu'on est bien admin.
   * PATCH /teacher/:id
   */
  public static async saveEnseignant(
    id: number,
    teacher: Partial<EnseignantEntity>,
  ): Promise<EnseignantEntity> {
    Object.assign(__tmpTeacher, teacher);
    await tmpPause();
    return __tmpTeacher;
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
