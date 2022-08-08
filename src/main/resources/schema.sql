DROP TABLE IF EXISTS dogs CASCADE;
CREATE TABLE dogs (
id INT NOT NULL,
name VARCHAR(250) NOT NULL,
age INT NOT NULL
);

DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (
id INT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
email VARCHAR(50) NOT NULL,
role VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS book CASCADE;
CREATE TABLE book (
id INT PRIMARY KEY,
book_name VARCHAR(50) NOT NULL
);


DROP TABLE IF EXISTS book_user CASCADE;
CREATE TABLE book_user (
id INT PRIMARY KEY,
book_id INT,
user_id INT,
FOREIGN KEY (book_id) REFERENCES book(id),
FOREIGN KEY (user_id) REFERENCES users(id)
);


DROP TABLE IF EXISTS security CASCADE;

CREATE TABLE security (
id INT PRIMARY KEY,
ISIN INT NOT NULL,
CUSIP INT NOT NULL,
issuer VARCHAR(50),
maturity_date DATE,
coupon INT ,
type VARCHAR(50),
facevalue INT,
status VARCHAR(50)
);

DROP TABLE IF EXISTS counter_party CASCADE;

CREATE TABLE counter_party (
id INT PRIMARY KEY,
name VARCHAR(50)
);

DROP TABLE IF EXISTS trade CASCADE;

CREATE TABLE trade (
id INT PRIMARY KEY,
book_id INT,
counter_party_id INT,
security_id INT,
quantity INT,
status VARCHAR(50),
price INT,
buy_sell VARCHAR(50),
trade_date DATE,
settlement_date DATE,
FOREIGN KEY (book_id) REFERENCES book(id),
FOREIGN KEY (counter_party_id) REFERENCES counter_party(id),
FOREIGN KEY (security_id) REFERENCES security(id)
);
