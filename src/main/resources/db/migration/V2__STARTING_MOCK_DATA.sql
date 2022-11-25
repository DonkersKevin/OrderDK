insert into addresses (country, housenumber, city, postal_code, streetname)
values ('Belgium', '22', 'Leuven', '3000', 'Langestraat');

insert into addresses (country, housenumber, city, postal_code, streetname)
values ('Belgium', '1', 'Antwerpen', '2000', 'Kortestraat');

insert into addresses (country, housenumber, city, postal_code, streetname)
values ('Belgium', '5', 'Brussel', '1000', 'Hogestraat');

insert into addresses (country, housenumber, city, postal_code, streetname)
values ('Belgium', '7', 'Hasselt', '4000', 'Lagestraat');

insert into addresses (country, housenumber, city, postal_code, streetname)
values ('Belgium', '78', 'Luik', '5000', 'Rue haute');

insert into addresses (country, housenumber, city, postal_code, streetname)
values ('Belgium', '22', 'Namur', '4500', 'Rue courte');

insert into addresses (country, housenumber, city, postal_code, streetname)
values ('Belgium', '175', 'Brussel', '1030', 'Boulevard de la distance');



INSERT INTO customers (email, first_name, last_name, country_code, phone_number, fk_address_id)
VALUES ('stefbemindt@switchfully.com', 'Stef', 'Bemindt', 'BELGIUM', '0478451278', 1);

INSERT INTO customers (email, first_name, last_name, country_code, phone_number, fk_address_id)
VALUES ('janbroeckx@switchfully.com', 'Jan', 'Broeckx', 'BELGIUM', '0478451248', 2);

INSERT INTO customers (email, first_name, last_name, country_code, phone_number, fk_address_id)
VALUES ('rubenfobe@switchfully.com', 'Ruben', 'Fobe', 'BELGIUM', '0478451478', 3);

INSERT INTO customers (email, first_name, last_name, country_code, phone_number, fk_address_id)
VALUES ('stijnschouppe@switchfully.com', 'Stijn', 'Schouppe', 'BELGIUM', '0496038353', 4);

INSERT INTO customers (email, first_name, last_name, country_code, phone_number, fk_address_id)
VALUES ('kevindonkers@switchfully.com', 'Kevin', 'Donkers', 'BELGIUM', '0478451999', 5);

INSERT INTO customers (email, first_name, last_name, country_code, phone_number, fk_address_id)
VALUES ('haroldvandoo@switchfully.com', 'Harold', 'van Doorslaer', 'BELGIUM', '0478451143',
        6);
INSERT INTO customers (email, first_name, last_name, country_code, phone_number, fk_address_id)
VALUES ('timvercruysse@switchfully.com', 'Tim', 'Vercruysse', 'BELGIUM', '0478478278', 7);



insert into items(item_description, item_name, currency, unit_price, stock)
values ('A fuzzy fruit', 'Kiwi', 'EUR', 0.5, 24);

insert into items(item_description, item_name, currency, unit_price, stock)
values ('A sour fruit', 'Lemon', 'EUR', 0.25, 20);

insert into items(item_description, item_name, currency, unit_price, stock)
values ('A long yellow fruit', 'Banana', 'EUR', 1.0, 10);

insert into items(item_description, item_name, currency, unit_price, stock)
values ('An orange fruit', 'Orange', 'EUR', 1.5, 9);

insert into items(item_description, item_name, currency, unit_price, stock)
values ('A smelly fruit', 'Durian', 'EUR', 7.5, 1);

