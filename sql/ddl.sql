-- Drop table

-- DROP TABLE public."member";

CREATE TABLE public."member" (
                                 id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
                                 email varchar(255) NULL,
                                 name varchar(255) NULL,
                                 passwrd varchar(255) NULL,
                                 CONSTRAINT member_pkey PRIMARY KEY (id)
);


-- Drop table

-- DROP TABLE public.y_logger;

CREATE TABLE public.y_logger (
                                 id varchar NOT NULL,
                                 ip varchar NOT NULL,
                                 vist_route varchar NULL,
                                 regdt timestamp NULL
);


-- Drop table

-- DROP TABLE public.y_member;

CREATE TABLE public.y_member (
                                 id int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
                                 email varchar(255) NULL,
                                 "name" varchar(255) NULL,
                                 passwrd varchar(255) NULL,
                                 regdt timestamp NULL,
                                 rem_email varchar(255) NULL,
                                 updt timestamp NULL,
                                 CONSTRAINT y_member_pkey PRIMARY KEY (id)
);
