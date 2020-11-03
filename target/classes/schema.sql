DROP TABLE IF EXISTS app_users;
DROP SEQUENCE IF EXISTS user_id_seq;
CREATE TABLE app_users (
    user_id INT UNIQUE,
    first_Name VARCHAR(255),
    last_name VARCHAR(255),
    birth_date DATE,
    login VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    about VARCHAR(255),
    country VARCHAR(255),
    city VARCHAR(255),
    street VARCHAR(255),
    house_no INT,

    PRIMARY KEY(user_id)
);
CREATE SEQUENCE user_id_seq START 1 NO MAXVALUE;