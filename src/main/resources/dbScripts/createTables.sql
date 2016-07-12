CREATE TABLE accounts
(
  account_id BIGSERIAL PRIMARY KEY,
  login character varying(255) UNIQUE,
  hashed_password CHARACTER VARYING(255),
  uuid CHARACTER VARYING(255)
)