insert into user_details(id, user_name, password, first_name, last_name, active, roles) values (1, 'admin@nodomain.com', '$2a$12$fEYdXtclmcXXBxdWJbqvD..0zk.3LOKCRUGJnmluJraMtymzPPRiO', 'admin', 'user' ,true, 'ROLE_ADMIN');
insert into user_details(id, user_name, password, first_name, last_name, active, roles) values (2, 'bot@nodomain.com', '$2a$12$fEYdXtclmcXXBxdWJbqvD..0zk.3LOKCRUGJnmluJraMtymzPPRiO', 'bot', 'user' ,true, 'ROLE_BOT');
insert into user_details(id, user_name, password, first_name, last_name, active, roles) values (3, 'user@nodomain.com', '$2a$12$fEYdXtclmcXXBxdWJbqvD..0zk.3LOKCRUGJnmluJraMtymzPPRiO', 'Amith', 'Bharadwaj' ,true, 'ROLE_USER');

insert into channel_details(id, channel_name, channel_description, field1, field2, field3, user_id) values (12345, 'test channel1 name', 'test channel1 description', 'Channel1 field1', 'Channel1 field2', 'Channel1 field3', 3);
insert into channel_details(id, channel_name, channel_description, field1, field2, field3, user_id) values (12346, 'test channel2 name', 'test channel2 description', 'Channel2 field1', 'Channel2 field2', 'Channel2 field3', 3);

insert into feed_details(id, created_at, channel_id, field1, field2, field3) values (1, PARSEDATETIME('08-03-2019 12:00:00','DD-MM-YYYY HH:mm:ss'), 12345, 90, 100, 101);
insert into feed_details(id, created_at, channel_id, field1, field2, field3) values (2, PARSEDATETIME('08-03-2019 12:03:00','DD-MM-YYYY HH:mm:ss'), 12345, 91, 104, 101);
insert into feed_details(id, created_at, channel_id, field1, field2, field3) values (3, PARSEDATETIME('08-03-2019 12:04:00','DD-MM-YYYY HH:mm:ss'), 12345, 92, 105, 101);
insert into feed_details(id, created_at, channel_id, field1, field2, field3) values (4, PARSEDATETIME('08-03-2019 12:06:00','DD-MM-YYYY HH:mm:ss'), 12345, 93, 108, 101);
insert into feed_details(id, created_at, channel_id, field1, field2, field3) values (5, PARSEDATETIME('08-03-2019 12:07:00','DD-MM-YYYY HH:mm:ss'), 12345, 100, 120, 101);
insert into feed_details(id, created_at, channel_id, field1, field2, field3) values (6, PARSEDATETIME('08-03-2019 12:09:00','DD-MM-YYYY HH:mm:ss'), 12345, 120, 140, 101);
insert into feed_details(id, created_at, channel_id, field1, field2, field3) values (7, PARSEDATETIME('08-03-2019 12:11:00','DD-MM-YYYY HH:mm:ss'), 12345, 93, 105, 101);
insert into feed_details(id, created_at, channel_id, field1, field2, field3) values (8, PARSEDATETIME('08-03-2019 12:33:00','DD-MM-YYYY HH:mm:ss'), 12345, 99, 105, 101);
insert into feed_details(id, created_at, channel_id, field1, field2, field3) values (9, PARSEDATETIME('08-03-2019 12:22:00','DD-MM-YYYY HH:mm:ss'), 12345, 101, 160, 101);


insert into feed_details(id, created_at, channel_id, field1, field2, field3) values (11, PARSEDATETIME('07-03-2019 12:00:00','DD-MM-YYYY HH:mm:ss'), 12346, 190, 100, 101);
insert into feed_details(id, created_at, channel_id, field1, field2, field3) values (12, PARSEDATETIME('08-03-2019 12:03:00','DD-MM-YYYY HH:mm:ss'), 12346, 191, 104, 101);
insert into feed_details(id, created_at, channel_id, field1, field2, field3) values (13, PARSEDATETIME('08-03-2019 12:04:00','DD-MM-YYYY HH:mm:ss'), 12346, 192, 105, 101);
insert into feed_details(id, created_at, channel_id, field1, field2, field3) values (14, PARSEDATETIME('06-03-2019 12:06:00','DD-MM-YYYY HH:mm:ss'), 12346, 193, 108, 101);
insert into feed_details(id, created_at, channel_id, field1, field2, field3) values (15, PARSEDATETIME('08-03-2019 12:07:00','DD-MM-YYYY HH:mm:ss'), 12346, 200, 120, 101);
insert into feed_details(id, created_at, channel_id, field1, field2, field3) values (16, PARSEDATETIME('05-03-2019 12:09:00','DD-MM-YYYY HH:mm:ss'), 12346, 220, 140, 101);
insert into feed_details(id, created_at, channel_id, field1, field2, field3) values (17, PARSEDATETIME('08-03-2019 12:11:00','DD-MM-YYYY HH:mm:ss'), 12346, 193, 105, 101);
insert into feed_details(id, created_at, channel_id, field1, field2, field3) values (18, PARSEDATETIME('02-03-2019 12:33:00','DD-MM-YYYY HH:mm:ss'), 12346, 199, 105, 101);
insert into feed_details(id, created_at, channel_id, field1, field2, field3) values (19, PARSEDATETIME('08-03-2019 12:22:00','DD-MM-YYYY HH:mm:ss'), 12346, 201, 160, 101);