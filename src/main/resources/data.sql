--usersへ登録
INSERT INTO users(user_name,pass)
--パスワードをハッシュ化済み、もとのパスワード「testpass0!」
VALUES('TestUser','$2a$10$pAfELt7qqoUcgmySXBq1xuIpRSzZJaWNM.uusKPP3xKeUxy.yWIta')
ON CONFLICT(USER_NAME) DO NOTHING;

INSERT INTO users(user_name,pass)
--パスワードをハッシュ化済み、もとのパスワード「dec0pin;」
VALUES('KEIRA30','$2a$10$CHDZGMtjLNApOodeLmMRguwAXLR8cQeClYe69/6jngM.r4nMPh3jC')
ON CONFLICT(USER_NAME) DO NOTHING;

--coping_strategyへ登録
--INSERT INTO coping_strategy(user_id,title,description,category)
--VALUES(1,'コーヒーを淹れる','コーヒーの香りと味も楽しむ','不安なとき');

--INSERT INTO coping_strategy(user_id,title,description,category)
--VALUES(1,'銭湯に行く','お湯につかってリラックスできるかも','イライラしているとき');

--INSERT INTO coping_strategy(user_id,title,description,category)
--VALUES(2,'ラーメンを食べる','油で悲しみを流し込む','悲しいとき');


--executionへ登録
--INSERT INTO execution_record(coping_id)
--values(1);