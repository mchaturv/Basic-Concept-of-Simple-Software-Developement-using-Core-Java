
ALTER TABLE payments ADD CONSTRAINT checkNumber UNIQUE(checkNumber);

ALTER TABLE orders ADD checkNumber varchar(50);

ALTER TABLE orders ADD FOREIGN KEY (checkNumber) REFERENCES payments(checkNumber);