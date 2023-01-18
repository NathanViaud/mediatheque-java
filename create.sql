CREATE DATABASE IF NOT EXISTS mediatheque;

use mediatheque;

CREATE TABLE IF NOT EXISTS magazine(
    id int NOT NULL primary key AUTO_INCREMENT,
    editor varchar(255) NOT NULL,
    publication_date date NOT NULL,
    reference varchar(255) NOT NULL,
    title varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS book(
    id int NOT NULL primary key AUTO_INCREMENT,
    author varchar(255) NOT NULL,
    genre varchar(255) NOT NULL,
    reference varchar(255) NOT NULL,
    title varchar(255) NOT NULL,
    borrowed boolean NOT NULL
);

CREATE TABLE IF NOT EXISTS cd(
    id int NOT NULL primary key AUTO_INCREMENT,
    nb_of_tracks int NOT NULL,
    artist varchar(255) NOT NULL,
    reference varchar(255) NOT NULL,
    title varchar(255) NOT NULL,
    borrowed boolean NOT NULL
);

CREATE TABLE IF NOT EXISTS dvd(
    id int NOT NULL primary key AUTO_INCREMENT,
    producer varchar(255) NOT NULL,
    zone varchar(255) NOT NULL,
    reference varchar(255) NOT NULL,
    title varchar(255) NOT NULL,
    borrowed boolean NOT NULL
);
