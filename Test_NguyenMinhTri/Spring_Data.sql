
create database Sales;

create table products(
	ID INT PRIMARY KEY auto_increment,
    NAME VARCHAR(255),
    UnitPrice double
);

create table Orders(
	ID INT PRIMARY KEY auto_increment,
    orderDate date,
    customerName varchar(255)
);

create table OrderDetails(
	ID INT PRIMARY KEY auto_increment,
    CONSTRAINT FK_1 foreign key (orderId) REFERENCES Orders(ID),
    CONSTRAINT FK_2 foreign key (productId) REFERENCES Products(ID),
    quantity int
);


INSERT INTO products (name, unitPrice) VALUES ('T shirt', 100);
INSERT INTO products (name, unitPrice) VALUES ('Sweater', 150);
INSERT INTO products (name, unitPrice) VALUES ('Shoes', 200);
INSERT INTO products (name, unitPrice) VALUES ('Glasses', 139);
INSERT INTO products (name, unitPrice) VALUES ('Headphone', 129);

INSERT INTO orders (customerName, orderDate) VALUES ('Nguyen Minh Tri', '2023/10/02');
INSERT INTO orders (customerName, orderDate) VALUES ('Tommy', '2023/09/10');
INSERT INTO orders (customerName, orderDate) VALUES ('Nguyen Thi Lan', '2023/08/12');
INSERT INTO orders (customerName, orderDate) VALUES ('Nguyen Thi Hong', '2023/10/07');
INSERT INTO orders (customerName, orderDate) VALUES ('Nguyen Hong Nhung', '2023/10/05');

INSERT INTO orderdetails (quantity, orderId, productId) VALUES (2, 1, 2);
INSERT INTO orderdetails (quantity, orderId, productId) VALUES (1, 2, 1);
INSERT INTO orderdetails (quantity, orderId, productId) VALUES (3, 4, 3);
INSERT INTO orderdetails (quantity, orderId, productId) VALUES (1, 3, 4);
INSERT INTO orderdetails (quantity, orderId, productId) VALUES (1, 5, 5);
