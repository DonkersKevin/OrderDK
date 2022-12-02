Insert into orders (total_price, fk_customer_id)
values (10, 1);

Insert into orders (total_price, fk_customer_id)
values (20, 3);


insert into itembatches(amount, item_batch_price, shipping_date, fk_item_id, fk_order_id)
values (4, 2, '2022-4-22', 2, 1);

insert into itembatches(amount, item_batch_price, shipping_date, fk_item_id, fk_order_id)
values (2, 1.0, '2022-4-22', 1, 1);

insert into itembatches(amount, item_batch_price, shipping_date, fk_item_id, fk_order_id)
values (5, 7.5, '2022-4-22', 4, 1);

insert into itembatches(amount, item_batch_price, shipping_date, fk_item_id, fk_order_id)
values (10, 75, '2022-4-22', 5, 1);


insert into itembatches(amount, item_batch_price, shipping_date, fk_item_id, fk_order_id)
values (1, 1, '2022-4-22', 3, 2);

insert into itembatches(amount, item_batch_price, shipping_date, fk_item_id, fk_order_id)
values (1, 0.25, '2022-4-22', 2, 2);

insert into itembatches(amount, item_batch_price, shipping_date, fk_item_id, fk_order_id)
values (1, 7.5, '2022-4-22', 5, 2);

insert into itembatches(amount, item_batch_price, shipping_date, fk_item_id, fk_order_id)
values (1, 4.5, '2022-4-22', 6, 2);
