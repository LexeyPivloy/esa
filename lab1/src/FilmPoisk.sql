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