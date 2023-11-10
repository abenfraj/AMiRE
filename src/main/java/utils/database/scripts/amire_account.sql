create table account
(
    id           int          not null
        primary key,
    name         varchar(256) null,
    password     varchar(90)  null,
    idEcole      int          null,
    idEnseignant int          null,
    constraint account_ecole_idEcole_fk
        foreign key (idEcole) references ecole (idEcole),
    constraint account_enseignant_idenseignant_fk
        foreign key (idEnseignant) references enseignant (idenseignant)
);

INSERT INTO amire.account (id, name, password, idEcole, idEnseignant) VALUES (1, 'demo', 'demo', null, 1);
INSERT INTO amire.account (id, name, password, idEcole, idEnseignant) VALUES (2, 'efrei', 'je paie les frais', 1, null);
INSERT INTO amire.account (id, name, password, idEcole, idEnseignant) VALUES (3, 'admin', 'admin', null, null);
INSERT INTO amire.account (id, name, password, idEcole, idEnseignant) VALUES (4, 'epita', 'demo', 2, null);
INSERT INTO amire.account (id, name, password, idEcole, idEnseignant) VALUES (5, 'IutParis', 'demo', 3, null);
INSERT INTO amire.account (id, name, password, idEcole, idEnseignant) VALUES (6, 'toto.mobile', 'demo', null, 2);
INSERT INTO amire.account (id, name, password, idEcole, idEnseignant) VALUES (7, 'jean.naymar', 'demo', null, 3);
INSERT INTO amire.account (id, name, password, idEcole, idEnseignant) VALUES (8, 'alex.terieur', 'demo', null, 4);
INSERT INTO amire.account (id, name, password, idEcole, idEnseignant) VALUES (9, 'alain.terieur', 'demo', null, 5);
INSERT INTO amire.account (id, name, password, idEcole, idEnseignant) VALUES (10, 'hannah.tomie', 'demo', null, 6);
INSERT INTO amire.account (id, name, password, idEcole, idEnseignant) VALUES (11, 'justin.bridou', 'demo', null, 7);
INSERT INTO amire.account (id, name, password, idEcole, idEnseignant) VALUES (12, 'jean.soma', 'demo', null, 8);
