CREATE TABLE category (
  category_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255)
);
CREATE UNIQUE INDEX contact_category_id_index ON category (category_id);

ALTER TABLE contact ADD category_id INT NULL;
ALTER TABLE contact
  ADD CONSTRAINT contact_category_category_id_fk
FOREIGN KEY (category_id) REFERENCES category (category_id);