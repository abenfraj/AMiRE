create table annonce
(
    idAnnonce         int          not null
        primary key,
    titre             varchar(256) null,
    niveauxSouhaites  varchar(256) null,
    typeDeContrat     varchar(256) null,
    description       varchar(256) null,
    idEcole           int          null,
    expirationAnnonce varchar(256) null
);

INSERT INTO amire.annonce (idAnnonce, titre, niveauxSouhaites, typeDeContrat, description, idEcole, expirationAnnonce) VALUES (1, 'Cours avancé de Python', 'Universitaires', 'CDD, CDI', 'Cours avancé de Python pour les étudiants universitaires.', 1, '2023-12-31');
INSERT INTO amire.annonce (idAnnonce, titre, niveauxSouhaites, typeDeContrat, description, idEcole, expirationAnnonce) VALUES (2, 'Développement Web Full Stack', 'Universitaires', 'CDD, Intérim', 'Cours de développement web Full Stack avec HTML, CSS, JavaScript, et Node.js.', 2, '2023-11-30');
INSERT INTO amire.annonce (idAnnonce, titre, niveauxSouhaites, typeDeContrat, description, idEcole, expirationAnnonce) VALUES (3, 'Introduction à la Programmation C++', 'Universitaires', 'Intérim', 'Cours d\'introduction à la programmation en C++ pour les étudiants.', 1, '2024-01-15');
INSERT INTO amire.annonce (idAnnonce, titre, niveauxSouhaites, typeDeContrat, description, idEcole, expirationAnnonce) VALUES (4, 'Développement Mobile avec React Native', 'Universitaires', 'CDD', 'Cours de développement mobile avec React Native pour les étudiants en informatique.', 3, '2023-12-31');
INSERT INTO amire.annonce (idAnnonce, titre, niveauxSouhaites, typeDeContrat, description, idEcole, expirationAnnonce) VALUES (5, 'Cours de Data Science avec Python', 'Universitaires', 'CDD, CDI', 'Cours de Data Science avec Python pour les étudiants en sciences des données.', 2, '2023-10-20');
INSERT INTO amire.annonce (idAnnonce, titre, niveauxSouhaites, typeDeContrat, description, idEcole, expirationAnnonce) VALUES (6, 'Sécurité Informatique Avancée', 'Universitaires', 'CDD, Intérim', 'Cours avancé sur la sécurité informatique pour les étudiants en informatique.', 1, '2023-11-05');
INSERT INTO amire.annonce (idAnnonce, titre, niveauxSouhaites, typeDeContrat, description, idEcole, expirationAnnonce) VALUES (7, 'Développement d\'Applications Android', 'Universitaires', 'Intérim', 'Cours de développement d\'applications Android pour les étudiants en génie logiciel.', 3, '2023-12-31');
INSERT INTO amire.annonce (idAnnonce, titre, niveauxSouhaites, typeDeContrat, description, idEcole, expirationAnnonce) VALUES (8, 'Programmation Java Avancée', 'Universitaires', 'CDD, CDI', 'Cours avancé de programmation Java pour les étudiants en informatique.', 1, '2023-10-10');
INSERT INTO amire.annonce (idAnnonce, titre, niveauxSouhaites, typeDeContrat, description, idEcole, expirationAnnonce) VALUES (9, 'Conception de Bases de Données', 'Universitaires', 'CDD, Intérim', 'Cours de conception de bases de données pour les étudiants en informatique.', 3, '2023-12-31');
INSERT INTO amire.annonce (idAnnonce, titre, niveauxSouhaites, typeDeContrat, description, idEcole, expirationAnnonce) VALUES (10, 'Développement Web Front-End', 'Universitaires', 'Intérim', 'Cours de développement web Front-End avec HTML, CSS et JavaScript.', 2, '2023-12-31');
INSERT INTO amire.annonce (idAnnonce, titre, niveauxSouhaites, typeDeContrat, description, idEcole, expirationAnnonce) VALUES (11, 'Sécurité des Réseaux Informatiques', 'Universitaires', 'CDD', 'Cours sur la sécurité des réseaux informatiques pour les étudiants en informatique.', 1, '2023-11-15');
INSERT INTO amire.annonce (idAnnonce, titre, niveauxSouhaites, typeDeContrat, description, idEcole, expirationAnnonce) VALUES (12, 'Introduction à la Programmation Java', 'Universitaires', 'CDD, CDI', 'Cours d\'introduction à la programmation Java pour les étudiants.', 2, '2023-11-30');
