DROP SEQUENCE IF EXISTS hibernate_sequence CASCADE;
DROP TABLE IF EXISTS salaire CASCADE;
DROP TABLE IF EXISTS employe CASCADE;
DROP TABLE IF EXISTS agence CASCADE;


--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: minibase
--
CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE hibernate_sequence OWNER TO minibase;


--
-- Name: salaire; Type: TABLE; Schema: public; Owner: minibase
--
CREATE TABLE agence (
  id bigint NOT NULL,
  nom text NOT NULL,
  directeur_id bigint,
  version integer NOT NULL,

  CONSTRAINT agence_pk PRIMARY KEY (id)
);

ALTER TABLE agence OWNER TO minibase;


--
-- Name: salaire; Type: TABLE; Schema: public; Owner: minibase
--
CREATE TABLE employe (
  id bigint NOT NULL,
  nom text NOT NULL,
  prenom text NOT NULL,
  agence_id bigint NOT NULL,
  version integer NOT NULL,

  CONSTRAINT employe_pk PRIMARY KEY (id)
);

ALTER TABLE employe OWNER TO minibase;


--
-- Name: salaire; Type: TABLE; Schema: public; Owner: minibase
--
CREATE TABLE salaire (
  id bigint NOT NULL,
  montant integer NOT NULL,
  seuil_imposition text,
  employe_id bigint NOT NULL,
  version integer NOT NULL,

  CONSTRAINT salaire_pk PRIMARY KEY (id)
);

ALTER TABLE salaire OWNER TO minibase;


--
-- Name: salaire_employe_fk; Type: FK CONSTRAINT; Schema: public; Owner: minibase
--
ALTER TABLE salaire ADD CONSTRAINT salaire_employe_fk FOREIGN KEY (employe_id) REFERENCES employe(id);

--
-- Name: agence_directeur_fk; Type: FK CONSTRAINT; Schema: public; Owner: minibase
--
ALTER TABLE agence ADD CONSTRAINT agence_directeur_fk FOREIGN KEY (directeur_id) REFERENCES employe(id);

--
-- Name: employe_agence_fk; Type: FK CONSTRAINT; Schema: public; Owner: minibase
--
ALTER TABLE employe ADD CONSTRAINT employe_agence_fk FOREIGN KEY (agence_id) REFERENCES agence(id);
