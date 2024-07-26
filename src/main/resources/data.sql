use just_dab_db;

insert into employee(id, first_name, last_name, email, password)
values (1, 'first_employee_1', 'last_employee_1', 'email@employee.1', 'password_1');

insert into employee(id, first_name, last_name, email, password)
values (2, 'first_employee_2', 'last_employee_2', 'email@employee.2', 'password_2');

insert into employee(id, first_name, last_name, email, password)
values (3, 'first_employee_3', 'last_employee_3', 'email@employee.3', 'password_3');

insert into client(advisor_id, id, email, first_name, last_name, password)
values (1, 1, 'email@client.1', 'first_client_1', 'last_client_1', 'password_1');

insert into client(advisor_id, id, email, first_name, last_name, password)
values (1, 2, 'email@client.2', 'first_client_2', 'last_client_2', 'password_2');

insert into client(advisor_id, id, email, first_name, last_name, password)
values (1, 3, 'email@client.3', 'first_client_3', 'last_client_3', 'password_3');

insert into client(advisor_id, id, email, first_name, last_name, password)
values (2, 4, 'email@client.4', 'first_client_4', 'last_client_4', 'password_4');

insert into client(advisor_id, id, email, first_name, last_name, password)
values (2, 5, 'email@client.5', 'first_client_5', 'last_client_5', 'password_5');

insert into client(advisor_id, id, email, first_name, last_name, password)
values (2, 6, 'email@client.6', 'first_client_6', 'last_client_6', 'password_6');

insert into client(advisor_id, id, email, first_name, last_name, password)
values (3, 7, 'email@client.7', 'first_client_7', 'last_client_7', 'password_7');

insert into client(advisor_id, id, email, first_name, last_name, password)
values (3, 8, 'email@client.8', 'first_client_8', 'last_client_8', 'password_8');

insert into client(advisor_id, id, email, first_name, last_name, password)
values (3, 9, 'email@client.9', 'first_client_9', 'last_client_9', 'password_9');

insert into account(balance, client_id, id)
values (100, 1, 1);

insert into account(balance, client_id, id)
values (100, 2, 2);

insert into account(balance, client_id, id)
values (100, 3, 3);

insert into account(balance, client_id, id)
values (100, 4, 4);

insert into account(balance, client_id, id)
values (100, 5, 5);

insert into account(balance, client_id, id)
values (100, 6, 6);

insert into account(balance, client_id, id)
values (100, 7, 7);

insert into account(balance, client_id, id)
values (100, 8, 8);

insert into account(balance, client_id, id)
values (100, 9, 9);