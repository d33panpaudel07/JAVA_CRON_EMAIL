-- ROLES
insert into ROLES (NAME)
values ('SUPER_ADMIN')

insert into ROLES (NAME)
values ('ADMIN')

insert into ROLES (NAME)
values ('USER')

-- USERS
insert into USERS (EMAIL, PASSWORD, USERNAME)
VALUES ('superAdmin@gmail.com', 'admin1234', 'SUPER_ADMIN')

-- USER_ROLES
insert into USER_ROLES(USER_ID, ROLE_ID)
values (1, 1)
