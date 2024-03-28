CREATE TABLE medicines_management.medicines_timing
(
    id                INT AUTO_INCREMENT PRIMARY KEY,
    medicines_id  INT NOT NULL,
    timing            ENUM('朝', '昼', '晩', 'とん服') NOT NULL,
    CONSTRAINT FOREIGN KEY (medicines_id) REFERENCES medicines_management.medicines(id)
);
