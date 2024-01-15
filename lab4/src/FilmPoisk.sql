CREATE TABLE public.directors(
                                 director_id uuid primary key,
                                 name varchar(50)
);

CREATE TABLE public.movies(
                              movie_id uuid primary key,
                              title varchar(50),
                              director_id uuid,
                              Foreign Key (director_id) REFERENCES public.directors(director_id)
);

CREATE TABLE public.audit(
							  datetime   timestamp(6),
							  id         uuid not null primary key,
							  event      varchar(255),
							  info       varchar(255),
							  table_name varchar(255)
);

CREATE TABLE public.mailing_rules(
							  id         uuid not null primary key,
							  email      varchar(255),
							  table_name varchar(255)
);