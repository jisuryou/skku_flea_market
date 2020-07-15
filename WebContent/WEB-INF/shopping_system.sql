create schema shopping_system;

create table shopping_system.USER (
	userID varchar(45) not null,
    userPW varchar(45) not null,
    user_email varchar(45),
    user_type varchar(45) not null,
    primary key (userID)
);

insert into shopping_system.USER(userID, userPW, user_type) values ('admin0', '0000', 'ADMINISTRATOR');
insert into shopping_system.USER(userID, userPW, user_email, user_type) values ('buyer0', '0000', 'buyer0@skku.com', 'BUYER');
insert into shopping_system.USER(userID, userPW, user_email, user_type) values ('seller0', '0000', 'seller0@skku.com', 'SELLER');

CREATE TABLE shopping_system.PRODUCT (
    productID INTEGER NOT NULL,
    product_name VARCHAR(45) NOT NULL,
    product_price INTEGER NOT NULL,
    product_status varchar(45),
    product_img TEXT NOT NULL,
    product_desc TEXT,
    product_category varchar(45),
    sellerID VARCHAR(45),
    PRIMARY KEY (productID),
    FOREIGN KEY (sellerID)
        REFERENCES USER (userID)
);

INSERT INTO shopping_system.PRODUCT(productID, product_name, product_price, product_status, product_img, product_desc, product_category, sellerID) VALUES (1, 'Gigabyte P55K V5', 1500, 'PURCHASED IN PROGRESS', 'laptop.png','Display Screen 15 inch, Chip set made by Intel, i7', 'Computers', 'seller0');
INSERT INTO shopping_system.PRODUCT(productID, product_name, product_price, product_status, product_img, product_desc, product_category, sellerID) VALUES (2, 'Gigabyte GM-M6900', 20, 'PURCHASED COMPLETE', 'mouse.jpg','Interface USB, Maximum sensitivity 32', 'Computers', 'seller0');


create table shopping_system.CART(
	cartID integer,
	buyerID VARCHAR(45),
  productID integer,
  total_price integer,
  primary key (cartID),
  foreign key (buyerID) references USER(userID),
  foreign key (productID) references PRODUCT(productID)
);

CREATE TABLE shopping_system.PAYMENT (
    paymentID INTEGER NOT NULL,
    buyerID VARCHAR(45),
    productID integer,
    payment_amount INTEGER,
	cardNumber varchar(20),
	cardPassword varchar(10),
    PRIMARY KEY (paymentID),
    FOREIGN KEY (buyerID)
        REFERENCES USER (userID),
       FOREIGN KEY (productID)
        REFERENCES PRODUCT (productID) 
);

