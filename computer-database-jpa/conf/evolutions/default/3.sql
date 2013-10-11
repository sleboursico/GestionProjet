# --- First database schema

# --- !Ups

create table typecompte (
  id                        bigint not null,
  name                      varchar(255) not null,
  description               varchar(255),
  constraint pk_typecompte primary key (id))
;

create table projet (
  id                        bigint not null,
  name                      varchar(255) not null,
  statut               varchar(255) not null,
  url               varchar(255),
  constraint pk_projet primary key (id))
;

create table compte (
  id                        bigint not null,
  login                      varchar(255) not null,
  password               varchar(255),
  url               varchar(255) not null,
  typecompte_id                bigint not null,
  projet_id                bigint not null,
  constraint pk_compte primary key (id))
;

create sequence typecompte_seq start with 1000;

create sequence projet_seq start with 1000;

create sequence compte_seq start with 1000;

alter table compte add constraint fk_compte_typecompte_1 foreign key (typecompte_id) references typecompte (id) on delete restrict on update restrict;
alter table compte add constraint fk_compte_projet_1 foreign key (projet_id) references projet (id) on delete restrict on update restrict;
create index ix_compte_typecompte_1 on compte (typecompte_id);
create index ix_compte_projet_1 on compte(projet_id);


# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists compte;

drop table if exists typecompte;

drop table if exists projet;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists typecompte_seq;

drop sequence if exists compte_seq;

drop sequence if exists projet_seq;

