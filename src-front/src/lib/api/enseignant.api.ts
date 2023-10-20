import { AnnonceApi } from "./annonce.api";
import type { CandidatureEntity, EnseignantEntity } from "./entities";

export class EnseignantApi {
    /**
     * !! Back : Vérifier que l'utilisateur est bien connecté
     * GET /teacher/:id
     * @returns {EnseignantEntity}
     */
    public static async getTeacher(): Promise<EnseignantEntity> {
        return this.__tmpTeacher;
    }

    /**
     * !! Back : Vérifier qu'on est bien admin.
     * PATCH /teacher/:id
     */
    public static async saveTeacher(teacher: EnseignantEntity): Promise<EnseignantEntity> {
        this.__tmpTeacher = {...this.__tmpTeacher, ...teacher};
        return this.__tmpTeacher;
    }

    /**
     * !! Back : Afficher seulement les candidatures du professeur actuel.
     * GET /teacher/:id/candidatures
     */
    public static async getCandidatures(): Promise<CandidatureEntity[]> {
        return AnnonceApi.__tmpCandidatures.filter((c) => c.idEnseignant === this.__tmpTeacher.idEnseignant);
    }

    static __tmpTeacher: EnseignantEntity = {
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
        interetsDomaines: "Programmation Orientée Objet,Architecture logicielle,L'argent",
        niveauxSouhaites: "L1, M1, M2",

        experience: "Prof super crack à l'EFREI",
        titresAcademiques: "- DUT Informatique\n- Ingénieur Efrei",
        divers: "Je suis intelligent",
        recommandations: "- Créateur du livre \"Comment devenir un super prof\"",
        evaluation: "- IUT de Paris : Très bon prof, je recommande",
    };
};
