CREATE TABLE client
(
  id SERIAL PRIMARY KEY,
  login character varying(255) UNIQUE
)