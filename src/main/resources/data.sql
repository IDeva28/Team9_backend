INSERT INTO dogs (id, name, age) VALUES (1, 'Einstein', 3);
INSERT INTO dogs (id, name, age) VALUES (2, 'Kaya', 5);

INSERT INTO users (id, name, email, role, password) VALUES (1, 'abc', 'abc@gmail.com', 'role1', '1234');
INSERT INTO users (id, name, email, role, password) VALUES (2, 'xyz', 'xyz@gmail.com', 'role2', '1234');

INSERT INTO book (id, book_name) VALUES (11, 'book1');
INSERT INTO book (id, book_name) VALUES (12, 'book2');

INSERT INTO book_user 
VALUES (51,11,1),(52,12,2);

INSERT INTO security (id, ISIN, CUSIP, issuer, maturity_date, coupon, type, 
facevalue, status, action, issue)
VALUES (21, 12345, 67890, 'company1', '2023-12-25', 5, 'type1', 100, 'active', true ,'issue1'),
(22, 23456, 78901, 'company2', '2022-12-25', 3, 'type2', 1000, 'mature', false, 'issue2');

INSERT INTO counter_party (id, name) 
VALUES (31, 'counterParty1'), (32, 'counterParty2');

INSERT INTO trade(id, book_id, counter_party_id, security_id, quantity,
status, price, buy_sell, trade_date, settlement_date) 
VALUES (41, 11, 31, 21, 1000, 'active', 1000, 'buy', '2021-12-25', '2020-12-25'),
(42, 12, 32, 22, 2000, 'mature', 100, 'sell', '2020-12-25', '2021-12-25');


