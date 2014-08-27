-- You can use this file to load seed data into the database using SQL statements
insert into roles (id, authority, description) values (1, 'ROLE_READ', 'Tylko do odczytu')
insert into roles (id, authority, description) values (2, 'ROLE_USER', 'Uprawnienia użytkownika')
insert into roles (id, authority, description) values (3, 'ROLE_ADMIN', 'Uprawnienia administratora')

alter sequence role_seq restart with 4

insert into users (id, firstname, lastname, email, password, dateofbirth, enabled) values (1, 'Paweł', 'Koźbiał', 'pawel@pl.pl', 'ab406338ae5d5e1acee59fb051d2ef143d5e9f5de1473d590014256e3e97e0a2', '1982-08-31', true)
insert into users (id, firstname, lastname, email, password, dateofbirth, enabled) values (2, 'User', 'User', 'user@user.pl', '76d95e58766715225a65b9651769f9f409d77616d2f860cd32e55669f2a81d30', '1990-01-01', true)
insert into users (id, firstname, lastname, email, password, dateofbirth, enabled) values (3, 'Admin', 'Admin', 'admin@adm.com', 'a8b3904ee0206046acc2b3d705bdb47d79257b5ffb126dd5f9a280d893ab87df', '1985-04-15', true)
insert into users (id, firstname, lastname, email, password, dateofbirth, enabled) values (4, 'Test', 'XXX', 'test@xxx.yyy', 'e08bd589cf3d1e4259f47802c81ec195e88b458acd9b95c15f238b64c93bdd6a', '2000-06-16', false)
insert into users (id, firstname, lastname, email, password, dateofbirth, enabled) values (5, 'User1', 'User1', 'user1@user.pl', '76d95e58766715225a65b9651769f9f409d77616d2f860cd32e55669f2a81d30', '1990-01-01', false)
insert into users (id, firstname, lastname, email, password, dateofbirth, enabled) values (6, 'User2', 'User2', 'user2@user.pl', '76d95e58766715225a65b9651769f9f409d77616d2f860cd32e55669f2a81d30', '1989-02-28', false)
insert into users (id, firstname, lastname, email, password, dateofbirth, enabled) values (7, 'User3', 'User3', 'user3@user.pl', '76d95e58766715225a65b9651769f9f409d77616d2f860cd32e55669f2a81d30', '1990-04-04', true)
insert into users (id, firstname, lastname, email, password, dateofbirth, enabled) values (8, 'User4', 'User4', 'user4@user.pl', '76d95e58766715225a65b9651769f9f409d77616d2f860cd32e55669f2a81d30', '1993-11-13', true)
insert into users (id, firstname, lastname, email, password, dateofbirth, enabled) values (9, 'User5', 'User5', 'user5@user.pl', '76d95e58766715225a65b9651769f9f409d77616d2f860cd32e55669f2a81d30', '1990-07-27', false)
insert into users (id, firstname, lastname, email, password, dateofbirth, enabled) values (10, 'User6', 'User6', 'user6@user.pl', '76d95e58766715225a65b9651769f9f409d77616d2f860cd32e55669f2a81d30', '1990-01-01', true)
insert into users (id, firstname, lastname, email, password, dateofbirth, enabled) values (11, 'User7', 'User7', 'user7@user.pl', '76d95e58766715225a65b9651769f9f409d77616d2f860cd32e55669f2a81d30', '1991-12-24', true)
insert into users (id, firstname, lastname, email, password, dateofbirth, enabled) values (12, 'User8', 'User8', 'user8@user.pl', '76d95e58766715225a65b9651769f9f409d77616d2f860cd32e55669f2a81d30', '1990-01-30', true)
insert into users (id, firstname, lastname, email, password, dateofbirth, enabled) values (13, 'User9', 'User9', 'user9@user.pl', '76d95e58766715225a65b9651769f9f409d77616d2f860cd32e55669f2a81d30', '1980-10-01', false)

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

INSERT INTO league (id, name, description) VALUES (1, 'Ekstraklasa' ,'T-Mobile Ekstraklasa')
INSERT INTO league (id, name, description) VALUES (2, 'I liga' ,'Zaplecze ekstraklasy')
INSERT INTO league (id, name, description) VALUES (3, 'II liga', 'Druga liga')
INSERT INTO league (id, name, description) VALUES (4, 'III liga', 'Trzecia liga')

ALTER SEQUENCE league_seq RESTART WITH 5

INSERT INTO district (id, name, description) VALUES (1, 'Okręg ekstraklasy', 'pierwsza w hierarchii klasa męskich ligowych rozgrywek piłkarskich w Polsce.')
INSERT INTO district (id, name, description) VALUES (2, 'Okręg pierwszej ligi', 'druga w hierarchii klasa męskich ligowych rozgrywek piłkarskich w Polsce.')
INSERT INTO district (id, name, description) VALUES (3, 'Grupa zachodnia', null)
INSERT INTO district (id, name, description) VALUES (4, 'Grupa wschodnia', null)
INSERT INTO district (id, name, description) VALUES (5, 'Grupa dolnośląsko-lubuska', 'Lorem ipsum')
INSERT INTO district (id, name, description) VALUES (6, 'Grupa kujawsko-pomorsko-wielkopolska', 'Tworzy grupę drużyn z Krakowa')
INSERT INTO district (id, name, description) VALUES (7, 'Grupa lubelsko-podkarpacka', null)
INSERT INTO district (id, name, description) VALUES (8, 'Grupa łódzko-mazowiecka', null)
INSERT INTO district (id, name, description) VALUES (9, 'Grupa małopolsko-świętokrzyska', 'Lorem ipsum')
INSERT INTO district (id, name, description) VALUES (10, 'Grupa opolsko-śląska', null)
INSERT INTO district (id, name, description) VALUES (11, 'Grupa podlasko-warmińsko-mazurska', null)
INSERT INTO district (id, name, description) VALUES (12, 'Grupa pomorsko-zachodniopomorska', 'Lorem ipsum')

ALTER SEQUENCE district_seq RESTART WITH 13

INSERT INTO league_district (league_id, district_id) VALUES (1, 1)
INSERT INTO league_district (league_id, district_id) VALUES (2, 2)
INSERT INTO league_district (league_id, district_id) VALUES (3, 3)
INSERT INTO league_district (league_id, district_id) VALUES (3, 4)
INSERT INTO league_district (league_id, district_id) VALUES (4, 5)
INSERT INTO league_district (league_id, district_id) VALUES (4, 6)
INSERT INTO league_district (league_id, district_id) VALUES (4, 7)
INSERT INTO league_district (league_id, district_id) VALUES (4, 8)
INSERT INTO league_district (league_id, district_id) VALUES (4, 9)
INSERT INTO league_district (league_id, district_id) VALUES (4, 10)
INSERT INTO league_district (league_id, district_id) VALUES (4, 11)
INSERT INTO league_district (league_id, district_id) VALUES (4, 12)

INSERT INTO club (id, name, description, district_id) VALUES (1, 'MKS Myszków', 'Klub założony w 1999 r.', 2)
INSERT INTO club (id, name, description, district_id) VALUES (2, 'Zieloni Żarki', 'Klub na jurze krakowsko-częstochowskiej', 3)
INSERT INTO club (id, name, description, district_id) VALUES (3, 'Raków Częstochowa', 'Klub założony w 1999 r.', 4)
INSERT INTO club (id, name, description, district_id) VALUES (4, 'Legia Wolbrom', 'Klub na jurze krakowsko-częstochowskiej', 3)
INSERT INTO club (id, name, description, district_id) VALUES (5, 'Jura Niegowa', 'Klub założony w 1999 r.', 4)
INSERT INTO club (id, name, description, district_id) VALUES (6, 'GKS Katowice', 'Klub na jurze krakowsko-częstochowskiej', 1)

ALTER SEQUENCE club_seq RESTART WITH 7

INSERT INTO round (id, name) VALUES (1, 'Runda wiosenna 2014')
INSERT INTO round (id, name) VALUES (2, 'Runda jesienna 2014')

ALTER SEQUENCE round_seq RESTART WITH 3

INSERT INTO queue (id, number, round_id) VALUES (1, 1, 2)
INSERT INTO queue (id, number, round_id) VALUES (2, 2, 2)
INSERT INTO queue (id, number, round_id) VALUES (3, 3, 2)
INSERT INTO queue (id, number, round_id) VALUES (4, 4, 2)
INSERT INTO queue (id, number, round_id) VALUES (5, 5, 2)
INSERT INTO queue (id, number, round_id) VALUES (6, 6, 2)

ALTER SEQUENCE queue_seq RESTART WITH 7

INSERT INTO game (id, dateofgame, queue_id) VALUES (1, '2014-10-01', 1)
INSERT INTO game (id, dateofgame, queue_id) VALUES (2, '2014-10-01', 1)
INSERT INTO game (id, dateofgame, queue_id) VALUES (3, '2014-10-03', 1)
INSERT INTO game (id, dateofgame, queue_id) VALUES (4, '2014-10-09', 2)
INSERT INTO game (id, dateofgame, queue_id) VALUES (5, '2014-10-09', 2)
INSERT INTO game (id, dateofgame, queue_id) VALUES (6, '2014-10-09', 2)

ALTER SEQUENCE game_seq RESTART WITH 7

INSERT INTO game_club (game_id, club_id) VALUES (1, 1)
INSERT INTO game_club (game_id, club_id) VALUES (1, 2)
INSERT INTO game_club (game_id, club_id) VALUES (2, 3)
INSERT INTO game_club (game_id, club_id) VALUES (2, 4)
INSERT INTO game_club (game_id, club_id) VALUES (3, 5)
INSERT INTO game_club (game_id, club_id) VALUES (3, 6)
INSERT INTO game_club (game_id, club_id) VALUES (4, 2)
INSERT INTO game_club (game_id, club_id) VALUES (4, 3)
INSERT INTO game_club (game_id, club_id) VALUES (5, 4)
INSERT INTO game_club (game_id, club_id) VALUES (5, 5)
INSERT INTO game_club (game_id, club_id) VALUES (6, 1)
INSERT INTO game_club (game_id, club_id) VALUES (6, 6)

--INSERT INTO club_league (club_id, league_id) VALUES (1, 1)
--INSERT INTO club_league (club_id, league_id) VALUES (2, 2)