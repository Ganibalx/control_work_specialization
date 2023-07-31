CREATE DATABASE IF NOT EXISTS Human_Friends;

CREATE TABLE IF NOT EXISTS animals
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    animal_name VARCHAR(15),
    birthday DATE
);

CREATE TABLE IF NOT EXISTS pets
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    animal_name VARCHAR(15),
    birthday DATE
);

CREATE TABLE IF NOT EXISTS pack_animals
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    animal_name VARCHAR(15),
    birthday DATE,
    command VARCHAR(20)    
);

CREATE TABLE IF NOT EXISTS dogs
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    animal_name VARCHAR(15),
    birthday DATE,
    command VARCHAR(45)    
);

CREATE TABLE IF NOT EXISTS cats
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    animal_name VARCHAR(15),
    birthday DATE       
);

CREATE TABLE IF NOT EXISTS hamsters
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    animal_name VARCHAR(15),
    birthday DATE   
);

CREATE TABLE IF NOT EXISTS horses
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    animal_name VARCHAR(15),
    birthday DATE,
    command VARCHAR(20)    
);

CREATE TABLE IF NOT EXISTS camels
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    animal_name VARCHAR(15),
    birthday DATE,
    command VARCHAR(20)    
);

CREATE TABLE IF NOT EXISTS donkeys
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    animal_name VARCHAR(15),
    birthday DATE,
    command VARCHAR(20)    
);

INSERT dogs (animal_name, birthday, command)
VALUES
("Бобик", '2023-07-01', "Лежать, Сидеть, Фас, Место"),
("Рекс", '2020-01-15', "Стоять на одной лапе, Танцуй"),
("Гром", '2015-11-30', "Сторожи");

INSERT cats (animal_name, birthday)
VALUES
("Мурзик", '2010-01-15'),
("Барсик", '2021-02-16'),
("Пушок", '2011-03-25');

INSERT hamsters (animal_name, birthday)
VALUES
("Ноунейм", '2020-04-9'),
("Хомяк 2", '2018-05-20'),
("Хомяк 3", '2021-06-26');

INSERT horses (animal_name, birthday, command)
VALUES
("Ветер", '2012-07-10', "Но, стой"),
("Кляча", '2013-08-21', "Ну встань пожалуйста"),
("Спиди", '2015-09-11', "");

INSERT camels (animal_name, birthday, command)
VALUES
("Верблюд 1", '2012-10-12', "вперед, назад, нейтралка"),
("Верблюд 2", '2018-12-22', "пошел, копать воду"),
("Верблюд 3", '2015-11-28', "-");

INSERT donkeys (animal_name, birthday, command)
VALUES
("Осел", '2020-04-9', "пошел"),
("Без", '2018-05-20', "пошел, кушать"),
("Названия", '2021-06-26', "встань");

DELETE from camels;

SELECT * from horses
UNION
SELECT * from donkeys;

ALTER TABLE cats
ADD command VARCHAR(20) DEFAULT "не знает";

ALTER TABLE hamsters
ADD command VARCHAR(20) DEFAULT "не знает";

CREATE FUNCTION print_refund
(
	birthday DATE 
)	
RETURNS VARCHAR(45)
DETERMINISTIC
RETURN CONCAT("mounth ", datediff(CURRENT_DATE(),birthday) div 30 mod 12, ", yars ", datediff(CURRENT_DATE(),birthday) div 30 div 12);

CREATE TABLE youing_animals (id INT PRIMARY KEY AUTO_INCREMENT)
SELECT animal_name, birthday, command, print_refund(birthday) AS refund from horses
WHERE datediff(CURRENT_DATE(),birthday)/365>1 AND datediff(CURRENT_DATE(),birthday)/365<3
UNION
SELECT animal_name, birthday, command, print_refund(birthday) AS refund from donkeys
WHERE datediff(CURRENT_DATE(),birthday)/365>1 AND datediff(CURRENT_DATE(),birthday)/365<3
UNION
SELECT animal_name, birthday, command, print_refund(birthday) AS refund from dogs
WHERE datediff(CURRENT_DATE(),birthday)/365>1 AND datediff(CURRENT_DATE(),birthday)/365<3
UNION 
SELECT animal_name, birthday, command, print_refund(birthday) AS refund from cats
WHERE datediff(CURRENT_DATE(),birthday)/365>1 AND datediff(CURRENT_DATE(),birthday)/365<3
UNION 
SELECT animal_name, birthday, command, print_refund(birthday) AS refund from hamsters
WHERE datediff(CURRENT_DATE(),birthday)/365>1 AND datediff(CURRENT_DATE(),birthday)/365<3;

CREATE TABLE all_animals (id INT PRIMARY KEY AUTO_INCREMENT)
SELECT animal_name, birthday, command, 'horse' AS categories from horses
UNION
SELECT animal_name, birthday, command, 'donkey' AS categories from donkeys
UNION
SELECT animal_name, birthday, command, 'dog' AS categories from dogs
UNION 
SELECT animal_name, birthday, command, 'cat' AS categories from cats
UNION 
SELECT animal_name, birthday, command, 'hamster' AS categories from hamsters;