CREATE DATABASE sgpzf;
USE sgpzf;

CREATE TABLE country (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE region (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    idcountry INT,
    FOREIGN KEY (idcountry) REFERENCES country(id)
);

CREATE TABLE city (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    idregion INT,
    FOREIGN KEY (idregion) REFERENCES region(id)
);

CREATE TABLE gender (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE persons (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    idcity INT,
    address VARCHAR(50),
    age INT,
    email VARCHAR(100),
    idgender INT,
    FOREIGN KEY (idcity) REFERENCES city(id),
    FOREIGN KEY (idgender) REFERENCES gender(id)
);

CREATE TABLE skill (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE stack (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE stack_skill (
    idskill INT,
    idstack INT,
    idstatus INT,
    PRIMARY KEY (idskill, idstack),
    FOREIGN KEY (idskill) REFERENCES skill(id),
    FOREIGN KEY (idstack) REFERENCES stack(id)
);

CREATE TABLE persons_skill (
    id INT AUTO_INCREMENT PRIMARY KEY,
    registration_date DATE,
    idperson INT,
    idskill INT,
    FOREIGN KEY (idperson) REFERENCES persons(id),
    FOREIGN KEY (idskill) REFERENCES skill(id)
);