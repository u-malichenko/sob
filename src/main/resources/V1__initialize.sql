-- У фильма, который идет в кинотеатре,есть название,длительность (пусть будет 60, 90 или 120 минут),
-- цена билета (в разное время и дни может быть разной),
-- время начала сеанса (один фильм может быть показан несколько раз в разное время и с разной ценой билета).
-- Есть информация о купленных билетах (номер билета, на какой сеанс).
--
-- Составить грамотную нормализованную схему хранения этих данных в БД. Внести в нее 4–5 фильмов,
-- расписание на один день и несколько проданных билетов.
--
-- Сделать запросы, считающие и выводящие в понятном виде:
-- ошибки в расписании (фильмы накладываются друг на друга), отсортированные по возрастанию времени.
-- Выводить надо колонки «фильм 1», «время начала», «длительность», «фильм 2», «время начала», «длительность»;

-- перерывы 30 минут и более между фильмами — выводить по уменьшению длительности перерыва.
-- Колонки «фильм 1», «время начала», «длительность», «время начала второго фильма», «длительность перерыва»;

SELECT  m.title, s.time, l.duration, DATEADD(MINUTE,  l.duration, s.time) as end,
        m1.title, s1.time, l1.duration, DATEADD(MINUTE,  l1.duration, s1.time) as end1

from movies as m
         join sessions as s on m.id = s.film_id
         join lengths as l on m.length_id= l.id

         join movies as m1
         join sessions as s1 on m1.id = s1.film_id
         join lengths as l1 on m1.length_id= l1.id

where s1.time BETWEEN s.time and DATEADD(MINUTE,  l.duration, s.time) and s.time != s1.time;
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
values ('Гараж',3),
       ('Операция Ы', 1),
       ('Терминатор', 2);

create table sessions
(
    id      bigserial primary key,
    date    date  not null,
    time    time  not null,
    film_id bigint references movies (id)
);

insert into sessions (date, time, film_id)
values ('2021-03-16', '09:00:00', 1),
       ('2021-03-16', '09:30:00', 2),
       ('2021-03-16', '15:00:00', 3);

create table prices
(
    id      bigserial primary key,
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
