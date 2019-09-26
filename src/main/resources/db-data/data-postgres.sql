INSERT INTO public.agence(id, nom, directeur_id, version) VALUES (1, 'youpi_agence', null, 1);
INSERT INTO public.agence(id, nom, directeur_id, version) VALUES (2, 'zz_agence', null, 1);

INSERT INTO public.employe(id, nom, prenom, agence_id, version) VALUES (1, 'Ru', 'Paul', 1, 1);
INSERT INTO public.employe(id, nom, prenom, agence_id, version) VALUES (2, 'Frederic', 'Frederique', 1, 1);
INSERT INTO public.employe(id, nom, prenom, agence_id, version) VALUES (3, 'Hugues', 'Paul', 1, 1);
INSERT INTO public.employe(id, nom, prenom, agence_id, version) VALUES (4, 'Jean', 'Lassalle', 1, 1);
INSERT INTO public.employe(id, nom, prenom, agence_id, version) VALUES (5, 'Catherine', 'Deneuve', 2, 1);
INSERT INTO public.employe(id, nom, prenom, agence_id, version) VALUES (6, 'Rick', 'Sanchez', 2, 1);

INSERT INTO public.salaire(id, montant, seuil_imposition, employe_id, version) VALUES (1, 1000, 'A', 1, 1);
INSERT INTO public.salaire(id, montant, seuil_imposition, employe_id, version) VALUES (2, 1000, 'A', 2, 1);
INSERT INTO public.salaire(id, montant, seuil_imposition, employe_id, version) VALUES (3, 1000, 'B', 2, 1);
INSERT INTO public.salaire(id, montant, seuil_imposition, employe_id, version) VALUES (4, 1000, 'A', 3, 1);
INSERT INTO public.salaire(id, montant, seuil_imposition, employe_id, version) VALUES (5, 1000, 'A', 4, 1);
INSERT INTO public.salaire(id, montant, seuil_imposition, employe_id, version) VALUES (6, 1000, 'B', 4, 1);
INSERT INTO public.salaire(id, montant, seuil_imposition, employe_id, version) VALUES (7, 1000, 'A', 4, 1);
INSERT INTO public.salaire(id, montant, seuil_imposition, employe_id, version) VALUES (8, 1000, 'B', 5, 1);
INSERT INTO public.salaire(id, montant, seuil_imposition, employe_id, version) VALUES (9, 1000, 'A', 6, 1);
INSERT INTO public.salaire(id, montant, seuil_imposition, employe_id, version) VALUES (10, 1000, 'B', 6, 1);
INSERT INTO public.salaire(id, montant, seuil_imposition, employe_id, version) VALUES (11, 1000, 'A', 6, 1);

UPDATE agence SET directeur_id = 1
Where id  = 1;
UPDATE agence SET directeur_id = 5
Where id  = 2;
