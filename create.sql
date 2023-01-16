CREATE DATABASE IF NOT EXISTS mediatheque;

use mediatheque;

CREATE TABLE IF NOT EXISTS items(
    id int NOT NULL primary key AUTO_INCREMENT,
    reference varchar(255) NOT NULL,
    title varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS empruntable(
    id int NOT NULL primary key AUTO_INCREMENT,
    reference_id int NOT NULL,
    borrowed boolean NOT NULL,
    FOREIGN KEY (reference_id) REFERENCES items(id)
);

CREATE TABLE IF NOT EXISTS magazine(
    id int NOT NULL primary key AUTO_INCREMENT,
    reference_id int NOT NULL,
    editor varchar(255) NOT NULL,
    publication_date date NOT NULL,
    FOREIGN KEY (reference_id) REFERENCES items(id)
);

CREATE TABLE IF NOT EXISTS book(
    id int NOT NULL primary key AUTO_INCREMENT,
    empruntable_id int NOT NULL,
    author varchar(255) NOT NULL,
    genre varchar(255) NOT NULL,
    FOREIGN KEY (empruntable_id) REFERENCES empruntable(id)
);

CREATE TABLE IF NOT EXISTS cd(
    id int NOT NULL primary key AUTO_INCREMENT,
    empruntable_id int NOT NULL,
    nb_of_tracks int NOT NULL,
    artist varchar(255) NOT NULL,
    FOREIGN KEY (empruntable_id) REFERENCES empruntable(id)
);

CREATE TABLE IF NOT EXISTS dvd(
    id int NOT NULL primary key AUTO_INCREMENT,
    empruntable_id int NOT NULL,
    producer int NOT NULL,
    zone varchar(255) NOT NULL,
    FOREIGN KEY (empruntable_id) REFERENCES empruntable(id)
);

CREATE TABLE IF NOT EXISTS library(
    id int NOT NULL primary key AUTO_INCREMENT,
    item_id int NOT NULL,
    FOREIGN KEY (item_id) REFERENCES items(id)
);
