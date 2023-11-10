create table ecole
(
    idEcole       int auto_increment
        primary key,
    raisonSociale varchar(256)  null,
    competences   varchar(4256) null,
    besoins       varchar(256)  null,
    exigences     varchar(256)  null,
    periode       varchar(256)  null,
    remarques     varchar(256)  null
);

INSERT INTO amire.ecole (idEcole, raisonSociale, competences, besoins, exigences, periode, remarques) VALUES (1, 'Efrei', 'Développement informatique', 'Enseignants qualifiés', 'Inscription en cours', '2023-2024', 'Remarques sur l\'école');
INSERT INTO amire.ecole (idEcole, raisonSociale, competences, besoins, exigences, periode, remarques) VALUES (2, 'Epita', 'Formation en développement informatique', 'Formateurs expérimentés', 'Inscriptions ouvertes', '2023-2024', 'Remarques sur l\'école de développeurs');
INSERT INTO amire.ecole (idEcole, raisonSociale, competences, besoins, exigences, periode, remarques) VALUES (3, 'IUT de Paris', 'Sciences informatiques avancées', 'Professeurs hautement qualifiés', 'Inscriptions en cours', '2023-2024', 'Remarques sur l\'école de sciences informatiques');
