-- Database: freelancer

CREATE DATABASE freelancer
  WITH OWNER = "user"

-- Create tables

CREATE TABLE users
(
  id serial NOT NULL,
  address character varying(255),
  email character varying(255),
  firstname character varying(255),
  login character varying(255),
  othercontacts character varying(255),
  password character varying(255),
  portfoliolinks character varying(255),
  secondname character varying(255),
  skills character varying(255),
  CONSTRAINT "usersPK" PRIMARY KEY (id)
);

CREATE TABLE project
(
  id serial NOT NULL ,
  cost double precision,
  deadline character varying(255),
  demands character varying(255),
  describe character varying(255),
  finishdate timestamp without time zone,
  name character varying(255),
  notes character varying(255),
  startdate timestamp without time zone,
  user_id integer,
  status_id integer,
  CONSTRAINT "projectPK" PRIMARY KEY (id),
  CONSTRAINT "FK_60d0g900v88hwu1mfng1nbewq" FOREIGN KEY (user_id)
      REFERENCES users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_cmq2womflwqgdijyxklbasgdi" FOREIGN KEY (status_id)
      REFERENCES projectstatus (status_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE roles
(
  id bigserial NOT NULL,
  name character varying(255),
  CONSTRAINT "rolesPK" PRIMARY KEY (id),
  CONSTRAINT uc_rolesid_col UNIQUE (id)
);

CREATE TABLE user_roles
(
  user_id integer NOT NULL,
  role_id bigint NOT NULL,
  CONSTRAINT user_roles_pkey PRIMARY KEY (user_id, role_id),
  CONSTRAINT "FK_5q4rc4fh1on6567qk69uesvyf" FOREIGN KEY (role_id)
      REFERENCES roles (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_g1uebn6mqk9qiaw45vnacmyo2" FOREIGN KEY (user_id)
      REFERENCES users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE projectstatus
(
  status_id serial NOT NULL,
  status_name character varying(255),
  CONSTRAINT "projectstatusPK" PRIMARY KEY (status_id)
);

CREATE TABLE application
(
  id integer NOT NULL DEFAULT nextval('application_id_seq1'::regclass),
  applydate timestamp without time zone,
  note character varying(255),
  user_id integer,
  project_id integer,
  status_id integer,
  CONSTRAINT "applicationPK" PRIMARY KEY (id),
  CONSTRAINT "FK_d1dxnskiax7enhcfeqd98jd1v" FOREIGN KEY (project_id)
      REFERENCES project (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_dkr6bo95o1seayk7xddr9g7n5" FOREIGN KEY (user_id)
      REFERENCES users (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT application_status_id_fkey FOREIGN KEY (status_id)
      REFERENCES projectstatus (status_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

-- Insert data

INSERT INTO users VALUES (1, 'x', 'x', 'x', 'x','$2a$11$cIR8VYGXq5o7bwuucUfCmuvDqQxym7/3kgkwTlOnizoEQ2HLymGnC','x', 'x', 'x', 'user1');


INSERT INTO roles VALUES (1, 'ROLE_FREELANCER');
INSERT INTO roles VALUES (2, 'ROLE_CUSTOMER');
INSERT INTO roles VALUES (3, 'ROLE_ADMIN');
INSERT INTO roles VALUES (3, 'ROLE_GUEST');

INSERT INTO user_roles VALUES (1, 3);

INSERT INTO projectstatus VALUES (1, 'CREATED'); -- or 'FREE'
INSERT INTO projectstatus VALUES (2, 'UNDERWAY');
INSERT INTO projectstatus VALUES (3, 'CLOSED');
INSERT INTO projectstatus VALUES (4, 'AWAITING');
INSERT INTO projectstatus VALUES (5, 'APPROVED');
INSERT INTO projectstatus VALUES (6, 'DECLINE');

ALTER TABLE application ADD COLUMN status_id INT
      REFERENCES projectstatus (status_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;