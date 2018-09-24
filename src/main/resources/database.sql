CREATE TABLE bank (
  id   SERIAL       NOT NULL PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE employee (
  id           SERIAL      NOT NULL PRIMARY KEY,
  first_name   VARCHAR(50) NOT NULL,
  last_name    VARCHAR(50) NOT NULL,
  phone_number VARCHAR(30) NOT NULL,
  bank_id      INT         NOT NULL,

  FOREIGN KEY (bank_id) REFERENCES bank (id)
);

CREATE TABLE client (
  id           SERIAL       NOT NULL PRIMARY KEY,
  first_name   VARCHAR(50)  NOT NULL,
  last_name    VARCHAR(50)  NOT NULL,
  phone_number VARCHAR(30)  NOT NULL,
  address      VARCHAR(100) NOT NULL,
  email        VARCHAR(20)  NOT NULL,
  bank_id      INT          NOT NULL,

  FOREIGN KEY (bank_id) REFERENCES bank (id)
);

CREATE TABLE bank_account (
  id SERIAL NOT NULL PRIMARY KEY ,
  currency FLOAT NOT NULL ,
  amount FLOAT NOT NULL ,
  amount_of_credit FLOAT NOT NULL ,
  client_id INT NOT NULL ,

  FOREIGN KEY (client_id) REFERENCES client (id)
);

INSERT INTO bank VALUES (1, 'testBank');
INSERT INTO employee VALUES (1, 'firstName', 'lastName', '00000000', 1);
INSERT INTO client VALUES (1, 'firstName', 'lastName', '00000000', 'address', 'test@mail.ru', 1);
INSERT INTO bank_account VALUES (1, 200, 100, 1000, 1);