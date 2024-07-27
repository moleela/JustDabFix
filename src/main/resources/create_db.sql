drop database just_dab_db;
create database if not exists just_dab_db;

USE just_dab_db;

-- Create the employee table
CREATE TABLE employee (
    id INT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Create the client table
CREATE TABLE client (
    advisor_id INT NOT NULL,
    id INT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    FOREIGN KEY (advisor_id) REFERENCES employee(id)
);

-- Create the account table
CREATE TABLE account (
    balance DECIMAL(10, 2) NOT NULL,
    client_id INT NOT NULL,
    id INT PRIMARY KEY,
    FOREIGN KEY (client_id) REFERENCES client(id)
);

drop database just_dab_db_test;
create database if not exists just_dab_db_test;