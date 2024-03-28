CREATE TABLE medicines_management.medicines
(
    id                INT AUTO_INCREMENT PRIMARY KEY,
    user_id           INT NOT NULL,
    medicine_name     VARCHAR(100) NOT NULL,
    type              ENUM('処方箋', '市販薬') NOT NULL,
    CONSTRAINT FOREIGN KEY (user_id) REFERENCES medicines_management.accounts(id)
);