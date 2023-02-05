/* DROP DATABASE IF EXISTS cinema;

CREATE DATABASE cinema;

USE cinema; */


DROP TABLE IF EXISTS Film_Peli;
DROP TABLE IF EXISTS Director;
DROP TABLE IF EXISTS Films;


-- database structure
CREATE TABLE Director(
idDirector int(11) AUTO_INCREMENT PRIMARY KEY NOT NULL,
Nom VARCHAR(255) NOT NULL,
Any_Naixament int(11) NOT NULL,
PAIS VARCHAR(50) NOT NULL
);

CREATE TABLE Films(
idFilm int(11) AUTO_INCREMENT PRIMARY KEY NOT NULL,
Titol VARCHAR(125) NOT NULL,
Data_Estrena DATE NOT NULL,
PAIS VARCHAR(50) NOT NULL
);

CREATE TABLE Film_Peli(
idFilm int(11)  NOT NULL,
idDirector int(11)  NOT NULL,
FOREIGN KEY (idDirector) REFERENCES Director(idDirector) on delete cascade on update cascade,
FOREIGN KEY (idFilm) REFERENCES Films(idFilm) on delete cascade on update cascade
);

-- Values

INSERT INTO Director (Nom, Any_Naixament, PAIS) VALUES("Steven Spielberg",  1946, "Cincinnati, Ohio, Estats Units"),
("George Lucas", 1944 , "Modesto, Califòrnia, Estats Units"),
("Gareth Edwards", 1975, "Nuneaton, Regne, Unit");

INSERT INTO Films (Titol, Data_Estrena, PAIS) VALUES("Indiana Jones y el templo maldito",  "1984-5-8", "Estats Units"),
("La amenaza fantasma", "1999-5-19" , "Estats Units"),
("Star Wars: Rogue One", "2016-12-15", "Estats Units"),
("Godzilla", "2014-5-8", "Estats Units"),
("Star Wars Episode IV: A New Hope", "1977-5-25", "Estats Units"),
("Jaws", "1975-12-19", "Estats Units");

-- 
INSERT INTO Film_Peli VALUES(1, 1),
(2, 2), (3, 3), (4, 3), (5, 2), (6, 1);