-- You can use this file to load seed data into the database using SQL statements

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

INSERT INTO club (id, name, description, district_id) VALUES (1, 'MKS Myszków', 'Klub założony w 1999 r.', 1)
INSERT INTO club (id, name, description, district_id) VALUES (2, 'Zieloni Żarki', 'Klub na jurze krakowsko-częstochowskiej', 1)
INSERT INTO club (id, name, description, district_id) VALUES (3, 'Raków Częstochowa', 'Klub założony w 1999 r.', 1)
INSERT INTO club (id, name, description, district_id) VALUES (4, 'Legia Wolbrom', 'Klub na jurze krakowsko-częstochowskiej', 1)
INSERT INTO club (id, name, description, district_id) VALUES (5, 'Jura Niegowa', 'Klub założony w 1999 r.', 1)
INSERT INTO club (id, name, description, district_id) VALUES (6, 'GKS Katowice', 'Klub na jurze krakowsko-częstochowskiej', 1)
INSERT INTO club (id, name, description, district_id) VALUES (7, 'Górnik Zabrze', 'Klub', 1)
INSERT INTO club (id, name, description, district_id) VALUES (8, 'Arka Gdynia', 'Klub na pomorzu', 1)

ALTER SEQUENCE club_seq RESTART WITH 9

INSERT INTO round (id, name) VALUES (1, 'Runda wiosenna 2014')
INSERT INTO round (id, name) VALUES (2, 'Runda jesienna 2014')
INSERT INTO round (id, name) VALUES (3, 'Runda wiosenna 2015')
INSERT INTO round (id, name) VALUES (4, 'Runda jesienna 2015')

ALTER SEQUENCE round_seq RESTART WITH 5

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
INSERT INTO game (id, dateofgame, queue_id) VALUES (7, '2014-10-09', 2)

ALTER SEQUENCE game_seq RESTART WITH 8

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
INSERT INTO game_club (game_id, club_id) VALUES (7, 7)
INSERT INTO game_club (game_id, club_id) VALUES (7, 8)

INSERT INTO game_playerone (game_id, user_id) values (1, 3)
INSERT INTO game_playerone (game_id, user_id) values (1, 5)
INSERT INTO game_playerone (game_id, user_id) values (1, 7)
INSERT INTO game_playerone (game_id, user_id) values (1, 9)
INSERT INTO game_playerone (game_id, user_id) values (1, 11)
INSERT INTO game_playerone (game_id, user_id) values (1, 13)
INSERT INTO game_playerone (game_id, user_id) values (1, 15)
INSERT INTO game_playerone (game_id, user_id) values (1, 17)
INSERT INTO game_playerone (game_id, user_id) values (1, 19)
INSERT INTO game_playerone (game_id, user_id) values (1, 21)
INSERT INTO game_playerone (game_id, user_id) values (1, 23)
INSERT INTO game_playerone (game_id, user_id) values (1, 25)
INSERT INTO game_playerone (game_id, user_id) values (1, 27)
INSERT INTO game_playerone (game_id, user_id) values (1, 29)
INSERT INTO game_playerone (game_id, user_id) values (1, 31)
INSERT INTO game_playerone (game_id, user_id) values (1, 33)
INSERT INTO game_playerone (game_id, user_id) values (1, 35)
INSERT INTO game_playerone (game_id, user_id) values (1, 37)
INSERT INTO game_playerone (game_id, user_id) values (1, 39)
INSERT INTO game_playerone (game_id, user_id) values (1, 41)
INSERT INTO game_playerone (game_id, user_id) values (1, 43)
INSERT INTO game_playerone (game_id, user_id) values (1, 45)

INSERT INTO game_playertwo (game_id, user_id) values (1, 4)
INSERT INTO game_playertwo (game_id, user_id) values (1, 6)
INSERT INTO game_playertwo (game_id, user_id) values (1, 8)
INSERT INTO game_playertwo (game_id, user_id) values (1, 10)
INSERT INTO game_playertwo (game_id, user_id) values (1, 12)
INSERT INTO game_playertwo (game_id, user_id) values (1, 14)
INSERT INTO game_playertwo (game_id, user_id) values (1, 16)
INSERT INTO game_playertwo (game_id, user_id) values (1, 18)
INSERT INTO game_playertwo (game_id, user_id) values (1, 20)
INSERT INTO game_playertwo (game_id, user_id) values (1, 22)
INSERT INTO game_playertwo (game_id, user_id) values (1, 24)
INSERT INTO game_playertwo (game_id, user_id) values (1, 26)
INSERT INTO game_playertwo (game_id, user_id) values (1, 28)
INSERT INTO game_playertwo (game_id, user_id) values (1, 30)
INSERT INTO game_playertwo (game_id, user_id) values (1, 32)
INSERT INTO game_playertwo (game_id, user_id) values (1, 34)
INSERT INTO game_playertwo (game_id, user_id) values (1, 36)
INSERT INTO game_playertwo (game_id, user_id) values (1, 38)
INSERT INTO game_playertwo (game_id, user_id) values (1, 40)
INSERT INTO game_playertwo (game_id, user_id) values (1, 42)
INSERT INTO game_playertwo (game_id, user_id) values (1, 44)
INSERT INTO game_playertwo (game_id, user_id) values (1, 46)

INSERT INTO game_referee (game_id, user_id) values (1, 1)
INSERT INTO game_referee (game_id, user_id) values (1, 2)
INSERT INTO game_referee (game_id, user_id) values (1, 100)
--INSERT INTO club_league (club_id, league_id) VALUES (1, 1)
--INSERT INTO club_league (club_id, league_id) VALUES (2, 2)