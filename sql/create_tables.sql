---- Creation of database
--CREATE DATABASE homework3
--    WITH
--    OWNER = postgres
--    ENCODING = 'UTF8'
--    CONNECTION LIMIT = -1;
--
--GRANT ALL ON DATABASE homework3 TO postgres;

-- Creation of messages table
CREATE TABLE IF NOT EXISTS messages (
  id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
  username varchar(250) NOT NULL,
  message varchar(250) NOT NULL,
  PRIMARY KEY (id)
);