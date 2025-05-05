--
-- PostgreSQL database dump
--

-- Dumped from database version 15.3
-- Dumped by pg_dump version 17.1

-- Started on 2025-05-04 12:38:38

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
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
-- TOC entry 215 (class 1259 OID 16440)
-- Name: car_types; Type: TABLE; Schema: public; Owner: colvir
--

CREATE TABLE public.car_types (
    id integer NOT NULL,
    name character varying(64)
);


ALTER TABLE public.car_types OWNER TO colvir;

--
-- TOC entry 216 (class 1259 OID 16443)
-- Name: car_types_id_seq; Type: SEQUENCE; Schema: public; Owner: colvir
--

CREATE SEQUENCE public.car_types_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.car_types_id_seq OWNER TO colvir;

--
-- TOC entry 3336 (class 0 OID 0)
-- Dependencies: 216
-- Name: car_types_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: colvir
--

ALTER SEQUENCE public.car_types_id_seq OWNED BY public.car_types.id;


--
-- TOC entry 214 (class 1259 OID 16437)
-- Name: spare_parts; Type: TABLE; Schema: public; Owner: colvir
--

CREATE TABLE public.spare_parts (
    id integer NOT NULL,
    name character varying(128) NOT NULL,
    cost numeric NOT NULL,
    car_type_id integer NOT NULL
);


ALTER TABLE public.spare_parts OWNER TO colvir;

--
-- TOC entry 217 (class 1259 OID 16450)
-- Name: spare_part_id_seq; Type: SEQUENCE; Schema: public; Owner: colvir
--

CREATE SEQUENCE public.spare_part_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.spare_part_id_seq OWNER TO colvir;

--
-- TOC entry 3337 (class 0 OID 0)
-- Dependencies: 217
-- Name: spare_part_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: colvir
--

ALTER SEQUENCE public.spare_part_id_seq OWNED BY public.spare_parts.id;


--
-- TOC entry 3179 (class 2604 OID 16444)
-- Name: car_types id; Type: DEFAULT; Schema: public; Owner: colvir
--

ALTER TABLE ONLY public.car_types ALTER COLUMN id SET DEFAULT nextval('public.car_types_id_seq'::regclass);


--
-- TOC entry 3178 (class 2604 OID 16451)
-- Name: spare_parts id; Type: DEFAULT; Schema: public; Owner: colvir
--

ALTER TABLE ONLY public.spare_parts ALTER COLUMN id SET DEFAULT nextval('public.spare_part_id_seq'::regclass);


--
-- TOC entry 3328 (class 0 OID 16440)
-- Dependencies: 215
-- Data for Name: car_types; Type: TABLE DATA; Schema: public; Owner: colvir
--

COPY public.car_types (id, name) FROM stdin;
1	Грузовик
2	Трактор
\.


--
-- TOC entry 3327 (class 0 OID 16437)
-- Dependencies: 214
-- Data for Name: spare_parts; Type: TABLE DATA; Schema: public; Owner: colvir
--

COPY public.spare_parts (id, name, cost, car_type_id) FROM stdin;
1	Вал отбора мощности	1999.99	2
2	Самосвал	53000	1
\.


--
-- TOC entry 3338 (class 0 OID 0)
-- Dependencies: 216
-- Name: car_types_id_seq; Type: SEQUENCE SET; Schema: public; Owner: colvir
--

SELECT pg_catalog.setval('public.car_types_id_seq', 2, true);


--
-- TOC entry 3339 (class 0 OID 0)
-- Dependencies: 217
-- Name: spare_part_id_seq; Type: SEQUENCE SET; Schema: public; Owner: colvir
--

SELECT pg_catalog.setval('public.spare_part_id_seq', 2, true);


--
-- TOC entry 3183 (class 2606 OID 16449)
-- Name: car_types car_types_pkey; Type: CONSTRAINT; Schema: public; Owner: colvir
--

ALTER TABLE ONLY public.car_types
    ADD CONSTRAINT car_types_pkey PRIMARY KEY (id);


--
-- TOC entry 3181 (class 2606 OID 16458)
-- Name: spare_parts spare_part_pkey; Type: CONSTRAINT; Schema: public; Owner: colvir
--

ALTER TABLE ONLY public.spare_parts
    ADD CONSTRAINT spare_part_pkey PRIMARY KEY (id);


--
-- TOC entry 3184 (class 2606 OID 16459)
-- Name: spare_parts fk_car_types; Type: FK CONSTRAINT; Schema: public; Owner: colvir
--

ALTER TABLE ONLY public.spare_parts
    ADD CONSTRAINT fk_car_types FOREIGN KEY (car_type_id) REFERENCES public.car_types(id) NOT VALID;


-- Completed on 2025-05-04 12:38:38

--
-- PostgreSQL database dump complete
--

