create table AUTHOR
(
    ID         integer PRIMARY KEY,
    FIRST_NAME varchar(255),
    LAST_NAME  varchar(255),
    AGE        integer
);

create table ARTICLE
(
    ID          integer PRIMARY KEY,
    TITLE       varchar(255) not null,
    DESCRIPTION varchar(255),
    AUTHOR_ID   integer
        CONSTRAINT fk_author_id REFERENCES AUTHOR
);


INSERT INTO public.author
(id, first_name, last_name, age)
VALUES(0, 'afn0', 'aln0', 0);

INSERT INTO public.author
(id, first_name, last_name, age)
VALUES(1, 'afn1', 'al1', 1);

INSERT INTO public.author
(id, first_name, last_name, age)
VALUES(2, 'afn2', 'al2', 2);