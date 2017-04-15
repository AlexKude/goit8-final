
-- Insert data
INSERT INTO users VALUES (1, 'x', 'x', 'x', 'x','$2a$11$cIR8VYGXq5o7bwuucUfCmuvDqQxym7/3kgkwTlOnizoEQ2HLymGnC','x', 'x', 'x', 'user1');


INSERT INTO roles VALUES (1, 'ROLE_FREELANCER');
INSERT INTO roles VALUES (2, 'ROLE_CUSTOMER');
INSERT INTO roles VALUES (3, 'ROLE_ADMIN');


INSERT INTO user_roles VALUES (1, 3);

INSERT INTO projectstatus VALUES (1, 'FREE');
INSERT INTO projectstatus VALUES (2, 'UNDERWAY');
INSERT INTO projectstatus VALUES (3, 'CLOSED');
INSERT INTO projectstatus VALUES (4, 'AWAITING');
INSERT INTO projectstatus VALUES (5, 'APPROVED');
INSERT INTO projectstatus VALUES (6, 'DECLINE');

ALTER TABLE application ADD COLUMN status_id INT
      REFERENCES projectstatus (status_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;