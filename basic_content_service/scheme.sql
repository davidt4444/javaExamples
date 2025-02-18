CREATE TABLE JPost (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    uniqueId CHAR(36) NOT NULL DEFAULT (UUID()),
    title VARCHAR(200) NOT NULL,
    content TEXT NOT NULL,
    createdAt DATETIME NOT NULL,
    author VARCHAR(200),
    category VARCHAR(100),
    updatedAt DATETIME,
    likesCount INTEGER NOT NULL,
    authorId INTEGER,
    isPublished BOOLEAN NOT NULL,
    views INTEGER NOT NULL
);