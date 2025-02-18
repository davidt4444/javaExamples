CREATE TABLE User ( 
    id BIGINT key NOT NULL AUTO_INCREMENT,
    uniqueId CHAR(36) NOT NULL DEFAULT (UUID()),
    username VARCHAR(20), 
    email VARCHAR(50), 
    roles VARCHAR(255), 
    password varchar(32)
    );
