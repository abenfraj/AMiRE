create table candidature
(
    idCandidature       int         not null
        primary key,
    dateCandidature     varchar(45) null,
    contacteParPersonne varchar(45) null,
    contacteLe          varchar(45) null,
    decision            varchar(45) null,
    idEnseignant        int         null,
    idAnnonce           int         null
);

INSERT INTO amire.candidature (idCandidature, dateCandidature, contacteParPersonne, contacteLe, decision, idEnseignant, idAnnonce) VALUES (1, '2023-01-15', 'Chef de departement Informatique', '2023-01-20', 'Accepté', 1, 1);
INSERT INTO amire.candidature (idCandidature, dateCandidature, contacteParPersonne, contacteLe, decision, idEnseignant, idAnnonce) VALUES (2, '2023-02-10', 'Responsable pédagogique', '2023-02-15', 'Refusé', 2, 2);
INSERT INTO amire.candidature (idCandidature, dateCandidature, contacteParPersonne, contacteLe, decision, idEnseignant, idAnnonce) VALUES (3, '2023-03-05', 'Responsable des admissions', '2023-03-10', 'En attente', 3, 3);
INSERT INTO amire.candidature (idCandidature, dateCandidature, contacteParPersonne, contacteLe, decision, idEnseignant, idAnnonce) VALUES (4, '2023-04-20', 'Responsable pédagogique', '2023-04-25', 'Accepté', 1, 1);
INSERT INTO amire.candidature (idCandidature, dateCandidature, contacteParPersonne, contacteLe, decision, idEnseignant, idAnnonce) VALUES (5, '2023-05-15', 'Chef de département Informatique', '2023-05-20', 'Refusé', 4, 4);
INSERT INTO amire.candidature (idCandidature, dateCandidature, contacteParPersonne, contacteLe, decision, idEnseignant, idAnnonce) VALUES (6, '2023-06-30', 'Responsable des admissions', '2023-07-05', 'Accepté', 2, 2);
INSERT INTO amire.candidature (idCandidature, dateCandidature, contacteParPersonne, contacteLe, decision, idEnseignant, idAnnonce) VALUES (7, '2023-07-10', 'Chef de département Informatique', '2023-07-15', 'Refusé', 5, 5);
INSERT INTO amire.candidature (idCandidature, dateCandidature, contacteParPersonne, contacteLe, decision, idEnseignant, idAnnonce) VALUES (8, '2023-08-05', 'Responsable pédagogique', '2023-08-10', 'En attente', 3, 3);
INSERT INTO amire.candidature (idCandidature, dateCandidature, contacteParPersonne, contacteLe, decision, idEnseignant, idAnnonce) VALUES (9, '2023-09-20', 'Directeur de l\'école', '2023-09-25', 'Accepté', 4, 4);
INSERT INTO amire.candidature (idCandidature, dateCandidature, contacteParPersonne, contacteLe, decision, idEnseignant, idAnnonce) VALUES (10, '2023-10-15', 'Responsable pédagogique', '2023-10-20', 'Refusé', 5, 5);
INSERT INTO amire.candidature (idCandidature, dateCandidature, contacteParPersonne, contacteLe, decision, idEnseignant, idAnnonce) VALUES (11, '2023-10-30', 'Responsable des admissions', '2023-11-05', 'En attente', 6, 6);
INSERT INTO amire.candidature (idCandidature, dateCandidature, contacteParPersonne, contacteLe, decision, idEnseignant, idAnnonce) VALUES (12, '2023-11-10', 'Chef de département Informatique', '2023-11-15', 'Refusé', 8, 8);
INSERT INTO amire.candidature (idCandidature, dateCandidature, contacteParPersonne, contacteLe, decision, idEnseignant, idAnnonce) VALUES (13, '2023-12-05', 'Responsable pédagogique', '2023-12-10', 'En attente', 7, 7);
INSERT INTO amire.candidature (idCandidature, dateCandidature, contacteParPersonne, contacteLe, decision, idEnseignant, idAnnonce) VALUES (14, '2024-01-15', 'Responsable des admissions', '2024-01-20', 'Accepté', 7, 7);
INSERT INTO amire.candidature (idCandidature, dateCandidature, contacteParPersonne, contacteLe, decision, idEnseignant, idAnnonce) VALUES (15, '2023-11-10', 'Chef de département Informatique', '2023-11-15', 'Refusé', 9, 9);
INSERT INTO amire.candidature (idCandidature, dateCandidature, contacteParPersonne, contacteLe, decision, idEnseignant, idAnnonce) VALUES (16, '2023-12-05', 'Responsable pédagogique', '2023-12-10', 'En attente', 10, 10);
INSERT INTO amire.candidature (idCandidature, dateCandidature, contacteParPersonne, contacteLe, decision, idEnseignant, idAnnonce) VALUES (17, '2024-01-15', 'Responsable des admissions', '2024-01-20', 'Accepté', 9, 9);
