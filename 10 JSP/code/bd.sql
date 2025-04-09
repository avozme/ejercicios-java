CREATE TABLE Users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    github_url VARCHAR(200),
    photo VARCHAR(200)
);


INSERT INTO Users (username, email, first_name, last_name, github_url, photo) VALUES
('jdoe', 'jdoe@example.com', 'John', 'Doe', 'https://github.com/jdoe', 'jdoe.jpg'),
('jjones', 'jjones@example.com', 'Jessica', 'Jones', 'https://github.com/jjones', 'jjones.jpg'),
('bwayne', 'bwayne@example.com', 'Bruce', 'Wayne', 'https://github.com/bwayne', 'bwayne.jpg'),
('ckent', 'ckent@example.com', 'Clark', 'Kent', 'https://github.com/ckent', 'ckent.jpg'),
('dprince', 'dprince@example.com', 'Diana', 'Prince', 'https://github.com/dprince', 'dprince.jpg'),
('pparker', 'pparker@example.com', 'Peter', 'Parker', 'https://github.com/pparker', 'pparker.jpg'),
('tstark', 'tstark@example.com', 'Tony', 'Stark', 'https://github.com/tstark', 'tstark.jpg'),
('ssummers', 'ssummers@example.com', 'Scott', 'Summers', 'https://github.com/ssummers', 'ssummers.jpg'),
('jstorm', 'jstorm@example.com', 'Johnny', 'Storm', 'https://github.com/jstorm', 'jstorm.jpg'),
('hquinn', 'hquinn@example.com', 'Harley', 'Quinn', 'https://github.com/hquinn', 'hquinn.jpg');

