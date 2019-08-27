DROP TABLE IF EXISTS billionaires;
 
CREATE TABLE billionaire (
  ID INT AUTO_INCREMENT  PRIMARY KEY,
  FIRSTNAME VARCHAR(250) NOT NULL,
  LASTNAME VARCHAR(250) NOT NULL,
  CAREER VARCHAR(250) DEFAULT NULL,
  VALUE INT DEFAULT NULL
);
 
INSERT INTO billionaire (FIRSTNAME, LASTNAME, CAREER, VALUE) VALUES
  ('Aliko', 'Dangote', 'Billionaire Industrialist', 10),
  ('Bill', 'Gates', 'Billionaire Tech Entrepreneur', 1000),
  ('Folrunsho', 'Alakija', 'Billionaire Oil Magnate', 50);
