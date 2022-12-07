--liquibase formatted sql
--changeset wsikora:1
insert into languages (code, name)
values ('pl', 'polski'),
       ('en', 'english');

--changeset wsikora:2
insert into currencies (code, name, symbol)
values ('PLN', 'Złoty', 'zł'),
       ('USD', 'United States dollar', '$'),
       ('EUR', 'Euro', '€'),
       ('CHF', 'Confœderatio Helvetica Franc', 'fr'),
       ('GBP', 'Pound sterling', '£');
