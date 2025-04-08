CREATE TABLE Users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    first_name VARCHAR(50),
    last_name VARCHAR(50)
);


INSERT INTO Users (username, email, first_name, last_name) VALUES
('john_doe', 'john.doe@example.com', 'John', 'Doe'),
('mary_jane', 'mary.jane@example.com', 'Mary', 'Jane'),
('alex_smith', 'alex.smith@example.com', 'Alex', 'Smith'),
('laura_brown', 'laura.brown@example.com', 'Laura', 'Brown'),
('michael_white', 'michael.white@example.com', 'Michael', 'White'),
('susan_lee', 'susan.lee@example.com', 'Susan', 'Lee'),
('david_clark', 'david.clark@example.com', 'David', 'Clark'),
('jennifer_martin', 'jennifer.martin@example.com', 'Jennifer', 'Martin'),
('robert_taylor', 'robert.taylor@example.com', 'Robert', 'Taylor'),
('elizabeth_harris', 'elizabeth.harris@example.com', 'Elizabeth', 'Harris');