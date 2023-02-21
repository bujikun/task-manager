begin;
 insert into`users` (
 `created_on`,
 `full_name`,
 `is_account_expired`,
 `is_account_locked`,
 `is_credentials_locked`,
 `is_enabled`,
 `password`,
 `updated_on`, `username`)values(
 "2023-02-21 17:54:16.217501","Admin",0,0,0,1,
"{bcrypt}$2a$10$hbMuJ4inth2wa0VvYbpGne74sGWOXJJ91bJSOylumx1aM824EwWpm",
 "2023-02-21 17:54:16.217788","admin");
insert into `roles`(name) values("ROLE_ADMIN");
select @last_inserted_id :=max(roles.id) from roles;
insert into permissions(name) values("read task");
insert into permissions(name) values("edit task");
insert into permissions(name) values("delete task");
insert into permissions(name) values("read user");
insert into permissions(name) values("edit user");
insert into permissions(name) values("delete user");
insert into roles_permissions(fk_role_id, fk_permission_id)  values ( @last_inserted_id,1);
insert into roles_permissions(fk_role_id, fk_permission_id)  values ( @last_inserted_id,2);
insert into roles_permissions(fk_role_id, fk_permission_id)  values ( @last_inserted_id,3);
insert into roles_permissions(fk_role_id, fk_permission_id)  values ( @last_inserted_id,4);
insert into roles_permissions(fk_role_id, fk_permission_id)  values ( @last_inserted_id,5);
insert into roles_permissions(fk_role_id, fk_permission_id)  values ( @last_inserted_id,6);
insert into `roles`(name) values("ROLE_USER");
select @last_inserted_id :=max(roles.id) from roles;
insert into roles_permissions(fk_role_id, fk_permission_id)  values ( @last_inserted_id,1);
insert into roles_permissions(fk_role_id, fk_permission_id)  values ( @last_inserted_id,2);
insert into roles_permissions(fk_role_id, fk_permission_id)  values ( @last_inserted_id,3);
insert into users_roles (fk_user_id, fk_role_id)
values (1,1);
commit;
select * from `users_roles`;