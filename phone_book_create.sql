CREATE TABLE IF NOT EXISTS public.phone_book
(
    id integer NOT NULL,
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    address character varying(200) COLLATE pg_catalog."default" NOT NULL,
    phone_number_1 character varying(20) COLLATE pg_catalog."default" NOT NULL,
    phone_number_2 character varying(20) COLLATE pg_catalog."default",
    created_date timestamp without time zone,
    created_by character varying(20) COLLATE pg_catalog."default",
    updated_date timestamp without time zone,
    updated_by character varying(20) COLLATE pg_catalog."default",
    status integer,
    CONSTRAINT phone_book_pkey PRIMARY KEY (id)
)