CREATE TABLE contact
(
    contact_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(255),
    phone_number VARCHAR(255)
);
CREATE UNIQUE INDEX contact_contact_id_index ON contact (contact_id);