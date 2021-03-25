-- ошибки в расписании (фильмы накладываются друг на друга)
-- SELECT m.title,
--        s.time,
--        l.duration,
--        m1.title,
--        s1.time,
--        l1.duration
--
-- from movies as m
--          join sessions as s on m.id = s.film_id
--          join lengths as l on m.length_id = l.id
--          join movies as m1
--          join sessions as s1 on m1.id = s1.film_id
--          join lengths as l1 on m1.length_id = l1.id
--
-- where s1.time BETWEEN s.time and DATEADD(MINUTE, l.duration, s.time)
--   and s.time != s1.time
-- order by s.time

--перерывы 30 минут и более между фильмами —
-- SELECT m.title      as name,
--        s.time       as start_time,
--        l.duration,
--        s1.time      as next_start_movies,
--        DATEDIFF(MINUTE, DATEADD(MINUTE, l.duration, s.time), s1.time) as timeout
--
-- from SESSIONS as s
--          join movies as m on m.id = s.film_id
--          join lengths as l on m.length_id = l.id
--          join sessions as s1 on s.film_id = s1.film_id - 1
--          join movies as m1 on m1.id = s1.film_id
--
-- where DATEDIFF(MINUTE, DATEADD(MINUTE, l.duration, s.time), s1.time) > 30
-- order by s.time


create table lengths
(
    id       serial primary key,
    duration int not null
);

insert into lengths (duration)
values (60),
       (90),
       (120);

create table movies
(
    id        bigserial primary key,
    title     varchar(60) not null,
    length_id int         not null,
    foreign key (length_id) references lengths (id)
);

insert into movies (title, length_id)
values ('Гараж', 3),
       ('Операция Ы', 1),
       ('Терминатор', 2);

create table sessions
(
    id      bigserial primary key,
    date    date not null,
    time    time not null,
    film_id bigint references movies (id)
);

insert into sessions (date, time, film_id)
values ('2021-03-16', '09:00:00', 1),
       ('2021-03-16', '11:30:00', 2),
       ('2021-03-16', '15:00:00', 3);

create table prices
(
    id         bigserial primary key,
    session_id bigint references sessions (id),
    price      float not null
);

insert into prices (session_id, price)
values (1, 100),
       (2, 200),
       (3, 300);

create table tickets
(
    number     bigserial primary key,
    session_id bigint references sessions (id)
);

insert into tickets (session_id)
values (1),
       (2),
       (3);
