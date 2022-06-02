drop database if exists neigesoleil;
create database neigesoleil;
use neigesoleil;
CREATE TABLE user(
        iduser int(11) NOT NULL AUTO_INCREMENT,
        username varchar (30),
        prenom varchar(25) DEFAULT 'Prenon',
        dateNaissance Date DEFAULT '1999-02-27',
        ville varchar(25) DEFAULT 'Rouen',
        cp varchar(25) DEFAULT '76000',
        adresse varchar(25) DEFAULT 'ladressedubureau',
        tel varchar(25) DEFAULT '06.06.06.06.06',
        nom varchar (30) DEFAULT 'Nom',
        mail varchar (30),
        password varchar (30),
        type varchar(1) DEFAULT '0',
        PRIMARY KEY (iduser)
);

CREATE TABLE employe(
         idemploye int(11) NOT NULL AUTO_INCREMENT,
         username varchar (30),
         prenom varchar(25),
         nom varchar (30),
         mail varchar (30),
         password varchar (30),
         PRIMARY KEY (idemploye)
);

CREATE TABLE habitat(
        idhab int(11) NOT NULL AUTO_INCREMENT,
        nom varchar (30),
        description varchar (30),
        nbpersonne varchar (30),
        vacant varchar(1) DEFAULT '1',
        PRIMARY KEY (idhab)
);

CREATE TABLE reservation (
        idreser int(11) NOT NULL AUTO_INCREMENT,
        dateA   VARCHAR(50),
        dateD   VARCHAR(50),
        idhab   int(11) NOT NULL,
        iduser  int(11) NOT NULL,
        PRIMARY KEY (idreser),
        foreign key(idhab) references habitat(idhab),
        foreign key(iduser) references user(iduser)
);

INSERT INTO user
values (NULL,'Pepito','Idgie','1999-02-27','Rouen','76130','2 parc de la varenne','0613198126','T-Paris','idgie@iris.com','password','1');

INSERT INTO user
values (
                NULL,
                'Granito',
                'Guillaume',
                '1999-02-27',
                'Rouen',
                '76130',
                '2 parc de la varenne',
                '0613198126',
                'Hurard',
                'hurard@iris.com',
                'password',
                '0'
        );

INSERT INTO employe
values (
           NULL,
           'Flaflito',
           'Admin',
           'Ladmin',
           'admin@iris.com',
           'password'
       );

INSERT INTO habitat
values (NULL, 'Glace', 'test', '2', '0');
-- in php_post.php -->$vacant = $_POST ['vacant'] --