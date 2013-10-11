# --- Sample dataset

# --- !Ups

-- Types de compte
insert into typecompte (id,name,description) values (  1,'Admin','Compte administrateur de l''application');
insert into typecompte (id,name,description) values (  2,'OVH','Compte OVH');
insert into typecompte (id,name,description) values (  3,'1&1', 'Compte 1&1');
insert into typecompte (id,name,description) values (  4,'Mail','Compte mail');
insert into typecompte (id,name,description) values (  5,'FTP', 'Compte FTP');
insert into typecompte (id,name,description) values (  6,'Free', 'Compte free');

-- Projets
insert into projet (id,name, statut, url) values ( 1,'Hypnose et changement','TERMINE', 'http://www.hypnose56.fr/');
insert into projet (id,name,statut, url) values ( 2,'Hypnose Bretagne Tabac','TMA', 'http://www.hypnose-bretagne-tabac.fr/');

-- Comptes
insert into compte (id,login,password,url,projet_id,typecompte_id) values ( 1,'admin', 'coolman', 'http://www.hypnose56.fr/', 1, 1);

# --- !Downs

delete from computer;
delete from company;
