-- Create user table
CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create article table
CREATE TABLE article (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    published_date DATE,
    author_id BIGINT NOT NULL,
    FOREIGN KEY (author_id) REFERENCES user(id)
);

-- Create comment table
CREATE TABLE comment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    content TEXT NOT NULL,
    article_id BIGINT NOT NULL,
    author_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (article_id) REFERENCES article(id),
    FOREIGN KEY (author_id) REFERENCES user(id)
);
