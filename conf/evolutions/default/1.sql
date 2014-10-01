# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table contact (
  id                        bigint,
  first_name                varchar(255),
  last_name                 varchar(255),
  email                     varchar(255),
  phone                     varchar(255),
  street_address            varchar(255),
  company_name              varchar(255),
  user_id                   bigint)
;

create table user (
  id                        bigint not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  constraint pk_user primary key (id))
;

create sequence user_seq;

alter table contact add constraint fk_contact_user_1 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_contact_user_1 on contact (user_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists contact;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists user_seq;

