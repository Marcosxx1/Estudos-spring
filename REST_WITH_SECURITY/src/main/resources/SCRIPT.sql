-- Connect to the database
\c employee_directory

-- Drop the tables if they exist
DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;

-- Table structure for table `users`
CREATE TABLE users (
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  enabled SMALLINT NOT NULL,
  PRIMARY KEY (username)
);

-- Inserting data for table `users`
INSERT INTO users (username, password, enabled) VALUES
('john', '{noop}test123', true),
('mary', '{noop}test123', true),
('susan', '{noop}test123', true);

-- Table structure for table `authorities`
CREATE TABLE authorities (
  username VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  UNIQUE (username, authority),
  FOREIGN KEY (username) REFERENCES users (username)
);

-- Inserting data for table `authorities`
INSERT INTO authorities (username, authority) VALUES
('john', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_EMPLOYEE'),
('mary', 'ROLE_MANAGER'),
('susan', 'ROLE_EMPLOYEE'),
('susan', 'ROLE_ADMIN');

