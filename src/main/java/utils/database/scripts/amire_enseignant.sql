create table enseignant
(
    idenseignant      int          not null
        primary key,
    nomEnseignant     varchar(256) null,
    prenomEnseignant  varchar(256) null,
    siteWeb           varchar(256) null,
    email             varchar(256) null,
    telephone         varchar(256) null,
    typeDeContrat     varchar(256) null,
    disponibilites    varchar(256) null,
    competences       varchar(256) null,
    interetEcole      varchar(256) null,
    interetDomaines   varchar(256) null,
    niveauxSouhaites  varchar(256) null,
    experience        varchar(256) null,
    titresAcademiques varchar(256) null,
    divers            varchar(256) null,
    recommandations   varchar(256) null,
    evaluation        varchar(256) null
);

INSERT INTO amire.enseignant (idenseignant, nomEnseignant, prenomEnseignant, siteWeb, email, telephone, typeDeContrat, disponibilites, competences, interetEcole, interetDomaines, niveauxSouhaites, experience, titresAcademiques, divers, recommandations, evaluation) VALUES (1, 'Durand', 'Marie', 'http://www.mariedurand.com', 'marie.durand@example.com', '123456789', 'Interim', 'Disponibilités 1', 'Python, JavaScript, C++', 'Informatique', 'Développement Web', 'Universitaires', 'Expérience 1', 'Titres académiques 1', 'Divers 1', 'Recommandations 1', 'Évaluation 1');
INSERT INTO amire.enseignant (idenseignant, nomEnseignant, prenomEnseignant, siteWeb, email, telephone, typeDeContrat, disponibilites, competences, interetEcole, interetDomaines, niveauxSouhaites, experience, titresAcademiques, divers, recommandations, evaluation) VALUES (2, 'Lefebvre', 'Thomas', 'http://www.thomaslefebvre.com', 'thomas.lefebvre@example.com', '987654321', 'Salarié', 'Disponibilités 2', 'HTML, CSS, JavaScript, Node.js', 'Informatique', 'Développement Web', 'Universitaires', 'Expérience 2', 'Titres académiques 2', 'Divers 2', 'Recommandations 2', 'Évaluation 2');
INSERT INTO amire.enseignant (idenseignant, nomEnseignant, prenomEnseignant, siteWeb, email, telephone, typeDeContrat, disponibilites, competences, interetEcole, interetDomaines, niveauxSouhaites, experience, titresAcademiques, divers, recommandations, evaluation) VALUES (3, 'Martin', 'Sophie', 'http://www.sophiemartin.com', 'sophie.martin@example.com', '555555555', 'Interim', 'Disponibilités 3', 'Java, Python, C', 'Informatique', 'Programmation', 'Universitaires', 'Expérience 3', 'Titres académiques 3', 'Divers 3', 'Recommandations 3', 'Évaluation 3');
INSERT INTO amire.enseignant (idenseignant, nomEnseignant, prenomEnseignant, siteWeb, email, telephone, typeDeContrat, disponibilites, competences, interetEcole, interetDomaines, niveauxSouhaites, experience, titresAcademiques, divers, recommandations, evaluation) VALUES (4, 'Dubois', 'Antoine', 'http://www.antoinedubois.com', 'antoine.dubois@example.com', '666666666', 'Salarié', 'Disponibilités 4', 'JavaScript, PHP, Ruby', 'Informatique', 'Développement Web', 'Universitaires', 'Expérience 4', 'Titres académiques 4', 'Divers 4', 'Recommandations 4', 'Évaluation 4');
INSERT INTO amire.enseignant (idenseignant, nomEnseignant, prenomEnseignant, siteWeb, email, telephone, typeDeContrat, disponibilites, competences, interetEcole, interetDomaines, niveauxSouhaites, experience, titresAcademiques, divers, recommandations, evaluation) VALUES (5, 'Girard', 'Luc', 'http://www.lucgirard.com', 'luc.girard@example.com', '777777777', 'Salarié', 'Disponibilités 5', 'React Native, React, Android', 'Informatique', 'Développement Mobile', 'Universitaires', 'Expérience 5', 'Titres académiques 5', 'Divers 5', 'Recommandations 5', 'Évaluation 5');
INSERT INTO amire.enseignant (idenseignant, nomEnseignant, prenomEnseignant, siteWeb, email, telephone, typeDeContrat, disponibilites, competences, interetEcole, interetDomaines, niveauxSouhaites, experience, titresAcademiques, divers, recommandations, evaluation) VALUES (6, 'Moreau', 'Julie', 'http://www.juliemoreau.com', 'julie.moreau@example.com', '888888888', 'Interim', 'Disponibilités 6', 'Data Science, Python, R', 'Sciences des Données', 'Data Science', 'Universitaires', 'Expérience 6', 'Titres académiques 6', 'Divers 6', 'Recommandations 6', 'Évaluation 6');
INSERT INTO amire.enseignant (idenseignant, nomEnseignant, prenomEnseignant, siteWeb, email, telephone, typeDeContrat, disponibilites, competences, interetEcole, interetDomaines, niveauxSouhaites, experience, titresAcademiques, divers, recommandations, evaluation) VALUES (7, 'Roux', 'Pierre', 'http://www.pierreroux.com', 'pierre.roux@example.com', '999999999', 'Interim', 'Disponibilités 7', 'C#, .NET, SQL', 'Informatique', 'Base de Données', 'Universitaires', 'Expérience 7', 'Titres académiques 7', 'Divers 7', 'Recommandations 7', 'Évaluation 7');
INSERT INTO amire.enseignant (idenseignant, nomEnseignant, prenomEnseignant, siteWeb, email, telephone, typeDeContrat, disponibilites, competences, interetEcole, interetDomaines, niveauxSouhaites, experience, titresAcademiques, divers, recommandations, evaluation) VALUES (8, 'Leroy', 'Marcelle', 'http://www.marcelleleroy.com', 'marcelle.leroy@example.com', '1010101010', 'Salarié', 'Disponibilités 8', 'React, Vue.js, Front-End', 'Informatique', 'Développement Web', 'Universitaires', 'Expérience 8', 'Titres académiques 8', 'Divers 8', 'Recommandations 8', 'Évaluation 8');
