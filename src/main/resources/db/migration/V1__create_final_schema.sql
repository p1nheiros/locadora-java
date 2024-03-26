-- CREATE TABLE IF NOT EXISTS Region (
--     region_id SERIAL PRIMARY KEY,
--     code VARCHAR,
--     name VARCHAR
-- );

-- CREATE TABLE IF NOT EXISTS Address_detail (
--     address_detail_id SERIAL PRIMARY KEY,
--     postal_code VARCHAR,
--     street VARCHAR,
--     neighborhood VARCHAR,
--     city VARCHAR,
--     country VARCHAR,
--     region_id INT REFERENCES Region(region_id)
-- );

-- CREATE TABLE IF NOT EXISTS Address (
--     address_id SERIAL PRIMARY KEY,
--     number VARCHAR,
--     complement VARCHAR,
--     address_detail_id INT REFERENCES Address_detail(address_detail_id)
-- );

CREATE TABLE IF NOT EXISTS Movies (
    movie_id SERIAL PRIMARY KEY,
    original_title VARCHAR,
    release_date DATE,
    original_language VARCHAR,
    overview VARCHAR,
    budget FLOAT,
    revenue FLOAT,
    runtime INTEGER,
    vote_average DECIMAL,
    category VARCHAR
);

--CREATE TABLE IF NOT EXISTS Users (
--    user_id SERIAL PRIMARY KEY,
--    password VARCHAR,
--    username VARCHAR,
--    email VARCHAR,
--    UNIQUE (user_id, username, email)
--);
--
--CREATE TABLE IF NOT EXISTS Customer (
--    customer_id SERIAL PRIMARY KEY,
--    first_name VARCHAR,
--    last_name VARCHAR,
--    cpf VARCHAR,
--    phone_number VARCHAR,
--    user_id INT REFERENCES Users(user_id),
--    UNIQUE(cpf, phone_number)
--);
--
--CREATE TABLE IF NOT EXISTS Rent (
--    rental_id SERIAL PRIMARY KEY,
--    rental_date TIMESTAMP,
--    return_date TIMESTAMP,
--    customer_id INT REFERENCES Customer(customer_id)
--);
--
--CREATE TABLE IF NOT EXISTS Rent_movies (
--    rental_id INT REFERENCES Rent(rental_id),
--    movie_id INT REFERENCES Movies(movie_id),
--    PRIMARY KEY (rental_id, movie_id)
--);

-- CREATE TABLE IF NOT EXISTS Customer_Addresses (
--     customer_id INT REFERENCES Customer(customer_id),
--     address_id INT REFERENCES Address(address_id),
--     PRIMARY KEY (customer_id, address_id)
-- );

-- ALTER TABLE Address
--     ADD CONSTRAINT FK_Address_3
--     FOREIGN KEY (address_detail_id)
--     REFERENCES Address_detail (address_detail_id);

--ALTER TABLE Rent
--    ADD CONSTRAINT FK_Rent_3
--    FOREIGN KEY (customer_id)
--    REFERENCES Customer (customer_id);
--
--ALTER TABLE Customer
--    ADD CONSTRAINT FK_Customer_3
--    FOREIGN KEY (user_id)
--    REFERENCES Users (user_id);
--
--ALTER TABLE Rent_movies
--    ADD CONSTRAINT FK_Rent_Movies_1
--    FOREIGN KEY (rental_id)
--    REFERENCES Rent (rental_id);
--
--ALTER TABLE Rent_Movies
--    ADD CONSTRAINT FK_Rent_Movies_2
--    FOREIGN KEY (movie_id)
--    REFERENCES Movies (movie_id);

-- ALTER TABLE Customer_Addresses
--     ADD CONSTRAINT FK_Customer_Addresses_1
--     FOREIGN KEY (customer_id)
--     REFERENCES Customer (customer_id);

-- ALTER TABLE Customer_Addresses
--     ADD CONSTRAINT FK_Customer_Addresses_2
--     FOREIGN KEY (address_id)
--     REFERENCES Address (address_id);
