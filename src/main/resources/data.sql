insert into user_details(id, user_name, password, first_name, last_name, active, roles) values (1, 'admin@nodomain.com', '$2a$12$fEYdXtclmcXXBxdWJbqvD..0zk.3LOKCRUGJnmluJraMtymzPPRiO', 'admin', 'user' ,true, 'ROLE_ADMIN');
insert into user_details(id, user_name, password, first_name, last_name, active, roles) values (2, 'bot@nodomain.com', '$2a$12$fEYdXtclmcXXBxdWJbqvD..0zk.3LOKCRUGJnmluJraMtymzPPRiO', 'bot', 'user' ,true, 'ROLE_BOT');
insert into user_details(id, user_name, password, first_name, last_name, active, roles) values (3, 'user@nodomain.com', '$2a$12$fEYdXtclmcXXBxdWJbqvD..0zk.3LOKCRUGJnmluJraMtymzPPRiO', 'Amith', 'Bharadwaj' ,true, 'ROLE_USER');

insert into channel_details(id, channel_name, channel_description, field1, field2, user_id) values (12345, 'test channel1 name', 'test channel1 description', 'field1 name', 'field2 name', 3);
insert into channel_details(id, channel_name, channel_description, field1, field2, user_id) values (12346, 'test channel2 name', 'test channel2 description', 'field1 name', 'field2 name', 3);