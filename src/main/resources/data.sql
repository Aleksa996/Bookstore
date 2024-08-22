INSERT INTO Authors (name, bio) VALUES
('J.K. Rowling', 'British author, best known for the Harry Potter series.'),
('George R.R. Martin', 'American novelist and short story writer, best known for A Song of Ice and Fire.'),
('J.R.R. Tolkien', 'English writer, poet, philologist, and academic, best known for The Lord of the Rings.');

INSERT INTO Publishers (name, address, phone_number, email) VALUES
('Bloomsbury', '50 Bedford Square, London, WC1B 3DP, UK', '+44 20 7631 5600', 'info@bloomsbury.com'),
('Bantam Books', '1745 Broadway, New York, NY 10019, USA', '+1 212-782-9000', 'info@bantambooks.com'),
('Allen & Unwin', '83 Alexander St, Crows Nest NSW 2065, Australia', '+61 2 8425 0100', 'info@allenandunwin.com');

INSERT INTO Categories (name, description) VALUES
('Fantasy', 'Books that contain magical or supernatural elements.'),
('Science Fiction', 'Books that are based on speculative scientific discoveries or developments.'),
('Mystery', 'Books that involve solving a crime or uncovering secrets.');

INSERT INTO Books (title, author_id, publisher_id, category_id, price, published_date, isbn, stock_quantity) VALUES
('Harry Potter and the Philosopher''s Stone', 1, 1, 1, 19.99, '1997-06-26', '9780747532699', 100);

INSERT INTO Books (title, author_id, publisher_id, category_id, price, published_date, isbn, stock_quantity) VALUES
('A Game of Thrones', 2, 2, 1, 22.99, '1996-08-06', '9780553103540', 50);

INSERT INTO Books (title, author_id, publisher_id, category_id, price, published_date, isbn, stock_quantity) VALUES
('The Fellowship of the Ring', 3, 3, 1, 15.99, '1954-07-29', '9780261103573', 80);

INSERT INTO Users (username, password, email, phone_number, address, role) VALUES
('John','$2a$12$hSfAnDfFjIflzyK5g7WCHemXfUP8ko0RfhLvtTUvEaRvs6pcsyNPS','john.doe@example.com', '555-1234', '123 Elm Street, Springfield, IL 62701, USA', 'ADMIN'),
('Jane', '$2a$12$2V8r0w2OT7CvmXyKViXpL.y.yhKqdLR/PnRnblOBh6qrrBuSBLoZC','jane.smith@example.com', '555-5678', '456 Oak Avenue, Springfield, IL 62702, USA', 'USER');

INSERT INTO Orders (user_id, order_date, total_amount, status) VALUES
(1, '2024-05-01', 39.98, 'OPEN'),
(2, '2024-05-02', 22.99, 'OPEN');

INSERT INTO Order_Items (order_id, book_id, quantity, unit_price) VALUES
(1, 1, 1, 19.99),
(1, 3, 1, 19.99),
(2, 2, 1, 22.99);

INSERT INTO Reviews (book_id, user_id, rating, comment, review_date) VALUES
(1, 1, 5, 'An amazing start to a magical series!', '2024-05-05'),
(2, 2, 4, 'Great book, but a bit too many characters to follow.', '2024-05-06'),
(3, 1, 5, 'A timeless classic that everyone should read.', '2024-05-07');