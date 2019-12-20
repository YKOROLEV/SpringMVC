insert into roles (id, name) values (1, 'ROLE_ADMIN');
insert into roles (id, name) values (2, 'ROLE_USER');

insert into user (id, login, name, password, accountNonExpired, accountNonLocked, credentialsNonExpired, enabled) values (1, 'admin', 'tomato', '123', true, true, true, true);
insert into user (id, login, name, password, accountNonExpired, accountNonLocked, credentialsNonExpired, enabled) values (2, 'user', 'ifactor', '123', true, true, true, true);

insert into user_roles (user_id, role_id) values (1, 1);
insert into user_roles (user_id, role_id) values (1, 2);
insert into user_roles (user_id, role_id) values (2, 2);