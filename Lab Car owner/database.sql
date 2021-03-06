PGDMP         7            
    x            oop    10.14    10.14     ?
           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            ?
           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            ?
           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            ?
           1262    49152    oop    DATABASE     ?   CREATE DATABASE oop WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Kazakhstan.1251' LC_CTYPE = 'Russian_Kazakhstan.1251';
    DROP DATABASE oop;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            ?
           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            ?
           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            ?            1259    57366 	   car_owner    TABLE     +  CREATE TABLE public.car_owner (
    id integer NOT NULL,
    fname character varying(50),
    lname character varying(50),
    car_brand character varying(50),
    car_color character varying(50),
    car_number character varying(50),
    reg_num character varying(10),
    year_of_issue integer
);
    DROP TABLE public.car_owner;
       public         postgres    false    3            ?            1259    57364    car_owner_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.car_owner_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.car_owner_id_seq;
       public       postgres    false    3    197            ?
           0    0    car_owner_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.car_owner_id_seq OWNED BY public.car_owner.id;
            public       postgres    false    196            ?            1259    57380    students    TABLE     ?   CREATE TABLE public.students (
    id integer NOT NULL,
    name character varying(50),
    surname character varying(50),
    faculty character varying(50),
    groups character varying(50)
);
    DROP TABLE public.students;
       public         postgres    false    3            ?            1259    57378    students_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.students_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.students_id_seq;
       public       postgres    false    199    3                        0    0    students_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.students_id_seq OWNED BY public.students.id;
            public       postgres    false    198            t
           2604    57369    car_owner id    DEFAULT     l   ALTER TABLE ONLY public.car_owner ALTER COLUMN id SET DEFAULT nextval('public.car_owner_id_seq'::regclass);
 ;   ALTER TABLE public.car_owner ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    197    196    197            u
           2604    57383    students id    DEFAULT     j   ALTER TABLE ONLY public.students ALTER COLUMN id SET DEFAULT nextval('public.students_id_seq'::regclass);
 :   ALTER TABLE public.students ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    199    198    199            ?
          0    57366 	   car_owner 
   TABLE DATA               o   COPY public.car_owner (id, fname, lname, car_brand, car_color, car_number, reg_num, year_of_issue) FROM stdin;
    public       postgres    false    197   ?       ?
          0    57380    students 
   TABLE DATA               F   COPY public.students (id, name, surname, faculty, groups) FROM stdin;
    public       postgres    false    199                     0    0    car_owner_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.car_owner_id_seq', 39, true);
            public       postgres    false    196                       0    0    students_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.students_id_seq', 7, true);
            public       postgres    false    198            w
           2606    57377    car_owner car_owner_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.car_owner
    ADD CONSTRAINT car_owner_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.car_owner DROP CONSTRAINT car_owner_pkey;
       public         postgres    false    197            y
           2606    57385    students students_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.students
    ADD CONSTRAINT students_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.students DROP CONSTRAINT students_pkey;
       public         postgres    false    199            ?
   W  x?uT???0=????6?pL?v?([U??z??	V?b??6????H??ͼyo
?E?aUU?[_?f??k???x???P?Z?@?"%v??`u??|??	?h?VyX???V?	?v8?$	Ia???J?????,?)?bUSI7?#??~)?5>8k?3.??Y¦?AX????Q??\????h?h??@Yˋ?Z?G8?^??????H??????)#???aeXK?_K?k㨜P???H|?j??F?	,!4泶6Գ?cLŧPZ{?A?NT?;#??
?udŸhFh?0׵q?j`'??u?Z?֝??U>???K???????id,F??A??)c??aBY?I???ޫ??R4?}g?<??7???*??kq??ɠ?%??u?]??<w5????FitWׅ???C??Q2??u?1?????SC??Z+???r?a?X
[???b????C?;?%a߁?]???ז????n?O??o?u?'??^????w'j???o?/????6?(??'3?4????[hx?ꞓ??9ה?r?h??i?)|"&???????X??q???~[???I_??Ʋ??$??>D?????z?? ??\}??      ?
   ?   x?Mν
?0???|#Iڦt?t??O6?I ??wo? ????#?O?g??x?v???????Ș???ӎ???0?x+?-*??&?v?\u-u0?#?.?????qX?ZQ????!?W~??]!?7D??c,     