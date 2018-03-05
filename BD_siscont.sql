/**
Arquivo com a criação do banco de dados para o Sistema de manutenção de Contatos, SisCont.
Edmilson Almemida - 05/03/2018
**/

CREATE DATABASE siscont
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE siscont
    IS 'Banco de dados para o sistema de manutenção de contatos';
	

-- SCHEMA: siscont

CREATE SCHEMA siscont
    AUTHORIZATION siscont;

CREATE SEQUENCE siscont.contato_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE siscont.contato_id_seq
    OWNER TO postgres

CREATE SEQUENCE siscont.grupo_contato_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE siscont.grupo_contato_id_seq
    OWNER TO siscont;;
	
CREATE SEQUENCE siscont.telefone_contato_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE siscont.telefone_contato_id_seq
    OWNER TO siscont;
	
-- Table: siscont.contato
CREATE TABLE siscont.contato
(
    id bigint NOT NULL DEFAULT nextval('siscont.contato_id_seq'::regclass),
    nome character varying(100) COLLATE pg_catalog."default" NOT NULL,
    email character varying(100) COLLATE pg_catalog."default" NOT NULL,
    id_grupo_contato bigint,
    CONSTRAINT contato_pkey PRIMARY KEY (id),
    CONSTRAINT fkid_grupocont_contato FOREIGN KEY (id_grupo_contato)
        REFERENCES siscont.grupo_contato (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE siscont.contato
    OWNER to postgres;
COMMENT ON TABLE siscont.contato
    IS 'tabela de contatos';

COMMENT ON CONSTRAINT fkid_grupocont_contato ON siscont.contato
    IS 'FK da tabela grupo_contato na tabela de contatos.';
	

-- Table: siscont.grupo_contato


CREATE TABLE siscont.grupo_contato
(
    id bigint NOT NULL DEFAULT nextval('siscont.grupo_contato_id_seq'::regclass),
    nome character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT grupo_contato_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE siscont.grupo_contato
    OWNER to siscont;
COMMENT ON TABLE siscont.grupo_contato
    IS 'Tabela de grupos de contatos';



-- Table: siscont.telefone_contato

-- DROP TABLE siscont.telefone_contato;

CREATE TABLE siscont.telefone_contato
(
    id bigint NOT NULL DEFAULT nextval('siscont.telefone_contato_id_seq'::regclass),
    numero character varying(13) COLLATE pg_catalog."default" NOT NULL,
    id_contato bigint NOT NULL,
    CONSTRAINT telefone_contato_pkey PRIMARY KEY (id),
    CONSTRAINT uni_contato_telefone UNIQUE (id_contato, numero),
    CONSTRAINT "fkid_contato#telefone" FOREIGN KEY (id_contato)
        REFERENCES siscont.contato (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE siscont.telefone_contato
    OWNER to siscont;
COMMENT ON TABLE siscont.telefone_contato
    IS 'Tabela para armazenar telefones de contatos.';

COMMENT ON CONSTRAINT uni_contato_telefone ON siscont.telefone_contato
    IS 'Unique das colunas de id_contato e numero na tabela de telefone';

COMMENT ON CONSTRAINT "fkid_contato#telefone" ON siscont.telefone_contato
    IS 'Fk do id da tabela de contato na tabela de tefones';	
	