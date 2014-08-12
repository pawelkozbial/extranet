-- You can use this file to load seed data into the database using SQL statements
insert into roles (id, authority, description) values (1, 'ROLE_READ', 'Tylko do odczytu')
insert into roles (id, authority, description) values (2, 'ROLE_USER', 'Uprawnienia użytkownika')
insert into roles (id, authority, description) values (3, 'ROLE_ADMIN', 'Uprawnienia administratora')

alter sequence role_seq restart with 4

insert into users (id, firstname, lastname, email, password, dateofbirth, enabled) values (1, 'Paweł', 'Koźbiał', 'pawel@pl.pl', 'ab406338ae5d5e1acee59fb051d2ef143d5e9f5de1473d590014256e3e97e0a2', '1982-08-31', true)
insert into users (id, firstname, lastname, email, password, dateofbirth, enabled) values (2, 'User', 'User', 'user@user.pl', '76d95e58766715225a65b9651769f9f409d77616d2f860cd32e55669f2a81d30', '1990-01-01', true)
insert into users (id, firstname, lastname, email, password, dateofbirth, enabled) values (3, 'Admin', 'Admin', 'admin@adm.com', 'a8b3904ee0206046acc2b3d705bdb47d79257b5ffb126dd5f9a280d893ab87df', '1985-04-15', true)
insert into users (id, firstname, lastname, email, password, dateofbirth, enabled) values (4, 'Test', 'XXX', 'test@xxx.yyy', 'e08bd589cf3d1e4259f47802c81ec195e88b458acd9b95c15f238b64c93bdd6a', '2000-06-16', false)
insert into users (id, firstname, lastname, email, password, dateofbirth, enabled) values (5, 'User1', 'User1', 'user1@user.pl', '76d95e58766715225a65b9651769f9f409d77616d2f860cd32e55669f2a81d30', '1990-01-01', true)
insert into users (id, firstname, lastname, email, password, dateofbirth, enabled) values (6, 'User2', 'User2', 'user2@user.pl', '76d95e58766715225a65b9651769f9f409d77616d2f860cd32e55669f2a81d30', '1990-01-01', true)
insert into users (id, firstname, lastname, email, password, dateofbirth, enabled) values (7, 'User3', 'User3', 'user3@user.pl', '76d95e58766715225a65b9651769f9f409d77616d2f860cd32e55669f2a81d30', '1990-01-01', true)
insert into users (id, firstname, lastname, email, password, dateofbirth, enabled) values (8, 'User4', 'User4', 'user4@user.pl', '76d95e58766715225a65b9651769f9f409d77616d2f860cd32e55669f2a81d30', '1990-01-01', true)
insert into users (id, firstname, lastname, email, password, dateofbirth, enabled) values (9, 'User5', 'User5', 'user5@user.pl', '76d95e58766715225a65b9651769f9f409d77616d2f860cd32e55669f2a81d30', '1990-01-01', true)
insert into users (id, firstname, lastname, email, password, dateofbirth, enabled) values (10, 'User6', 'User6', 'user6@user.pl', '76d95e58766715225a65b9651769f9f409d77616d2f860cd32e55669f2a81d30', '1990-01-01', true)
insert into users (id, firstname, lastname, email, password, dateofbirth, enabled) values (11, 'User7', 'User7', 'user7@user.pl', '76d95e58766715225a65b9651769f9f409d77616d2f860cd32e55669f2a81d30', '1990-01-01', true)
insert into users (id, firstname, lastname, email, password, dateofbirth, enabled) values (12, 'User8', 'User8', 'user8@user.pl', '76d95e58766715225a65b9651769f9f409d77616d2f860cd32e55669f2a81d30', '1990-01-01', true)
insert into users (id, firstname, lastname, email, password, dateofbirth, enabled) values (13, 'User9', 'User9', 'user9@user.pl', '76d95e58766715225a65b9651769f9f409d77616d2f860cd32e55669f2a81d30', '1990-01-01', true)

alter sequence user_seq restart with 14

insert into user_roles (user_id, role_id) values (1, 3)
insert into user_roles (user_id, role_id) values (2, 2)
insert into user_roles (user_id, role_id) values (3, 1)
insert into user_roles (user_id, role_id) values (4, 1)
insert into user_roles (user_id, role_id) values (5, 2)
insert into user_roles (user_id, role_id) values (6, 1)
insert into user_roles (user_id, role_id) values (7, 2)
insert into user_roles (user_id, role_id) values (8, 1)
insert into user_roles (user_id, role_id) values (9, 1)
insert into user_roles (user_id, role_id) values (10, 2)
insert into user_roles (user_id, role_id) values (11, 1)
insert into user_roles (user_id, role_id) values (12, 1)
insert into user_roles (user_id, role_id) values (13, 2)

--alter sequence user_role_seq restart 4

insert into contact (id, firstname, lastname, email, telephone) values (1, 'pawel', 'kozbial', 'pawel@wp.pl', '333-444-555')
insert into contact (id, firstname, lastname, email, telephone) values (2, 'user', 'user', 'user@user.pl', '000-000-000')

ALTER SEQUENCE con_seq RESTART WITH 3

INSERT INTO district VALUES (1, 'Ogólnopolska')
INSERT INTO district VALUES (2, 'Grupa zachodnia')
INSERT INTO district VALUES (3, 'Grupa wschodnia')
INSERT INTO district VALUES (4, 'Grupa dolnośląsko-lubuska')
INSERT INTO district VALUES (5, 'Grupa kujawsko-pomorsko-wielkopolska')
INSERT INTO district VALUES (6, 'Grupa lubelsko-podkarpacka')
INSERT INTO district VALUES (7, 'Grupa łódzko-mazowiecka')
INSERT INTO district VALUES (8, 'Grupa małopolsko-świętokrzyska')
INSERT INTO district VALUES (9, 'Grupa opolsko-śląska')
INSERT INTO district VALUES (10, 'Grupa podlasko-warmińsko-mazurska')
INSERT INTO district VALUES (11, 'Grupa pomorsko-zachodniopomorska')

ALTER SEQUENCE district_seq RESTART WITH 12

INSERT INTO league VALUES (1, 'Ekstraklasa')
INSERT INTO league VALUES (2, 'II liga')
INSERT INTO league VALUES (3, 'III liga')

ALTER SEQUENCE league_seq RESTART WITH 3

INSERT INTO league_district VALUES (1, 1)
INSERT INTO league_district VALUES (2, 2)
INSERT INTO league_district VALUES (2, 3)
INSERT INTO league_district VALUES (3, 4)
INSERT INTO league_district VALUES (3, 5)
INSERT INTO league_district VALUES (3, 6)
INSERT INTO league_district VALUES (3, 7)
INSERT INTO league_district VALUES (3, 8)
INSERT INTO league_district VALUES (3, 9)
INSERT INTO league_district VALUES (3, 10)
INSERT INTO league_district VALUES (3, 11)

INSERT INTO club VALUES (1, 'MKS Myszków')
INSERT INTO club VALUES (2, 'Zieloni Żarki')

ALTER SEQUENCE club_seq RESTART WITH 3