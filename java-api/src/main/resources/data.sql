

INSERT INTO users (id, name, email, role, password) VALUES (1, 'devarshee', 'devarshee@gmail.com', 'operations', 'xyz@1234'), 
(2, 'bharat', 'bharat@gmail.com', 'operations', 'abc@123'),
(3, 'balaji', 'balaji@gmail.com', 'operations', 'asd@1234'),
(4, 'bhavya', 'bhavya@gmail.com', 'operations', 'dfg@123');

INSERT INTO book (id, book_name) VALUES (11, 'Government Bonds'), (12, 'Corporate Bonds'), (13, 'Municipal Bonds'),(14, 'Mortgage Bonds');

INSERT INTO book_user VALUES (51,11,1),(52,12,2),(53,13,3),(54,14,4);

INSERT INTO security (id, ISIN, CUSIP, issuer, maturity_date, coupon, type, 
facevalue, status, action, issue)
VALUES (21, 12345, 67890, 'Kotak', '2005-12-25', 5, 'Government Bonds', 100, 'active', true ,null),
(22, 23456, 78901, 'Axis', '2006-12-25', 3, 'Corporate Bonds', 1000, 'mature', false, 'trade failure'),
(23, 34566, 45678, 'Mirae', '2010-09-25', 5, 'Municipal Bonds', 100, 'active', true ,null),
(24, 39876, 56784, 'Sundaram', '2015-2-25', 3, 'Government Bonds', 10000, 'mature', false, 'mis-booking'),
(25, 56778, 98765, 'PFC finance', '2020-2-25', 3, 'Mortgage Bonds', 1000, 'mature', true, 'mis-scheduling');

INSERT INTO counter_party (id, name) 
VALUES (31, 'Dhruv'), (32, 'Dakshita'), (33, 'Balram'), (34, 'Chirag');

INSERT INTO trade(id, book_id, counter_party_id, security_id, quantity,
status, price, buy_sell, trade_date, settlement_date) 
VALUES (41, 11, 31, 21, 1000, 'active', 1000, 'buy', '2002-12-25', '2003-02-25'),
(42, 12, 32, 22, 4000, 'mature', 100, 'sell', '2005-12-25', '2006-02-25'),
(43, 13, 33, 23, 2000, 'active', 1000, 'buy', '2008-09-25', '2008-12-25'),
(44, 14, 34, 24, 3000, 'mature', 1000, 'sell', '2012-02-25', '2012-03-25'),
(45, 13, 33, 25, 1000, 'active', 100, 'buy', '2018-02-25', '2018-12-25');


