--
-- PostgreSQL database dump
--

-- Dumped from database version 13.0
-- Dumped by pg_dump version 13.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: User; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."User" (
    "Username" character varying(20),
    "Surname" character varying(20),
    "Name" character varying(20),
    "Password" character varying(20),
    min integer DEFAULT '-40'::integer,
    max integer DEFAULT '-10'::integer
);


ALTER TABLE public."User" OWNER TO postgres;

--
-- Data for Name: User; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."User" VALUES
	('msigirci', 'Sigirci', 'Mert', '12345', -40, -10),
	('ismailB', 'Buyukyabat', 'Ismail', '54321', -20, 0);


--
-- PostgreSQL database dump complete
--

