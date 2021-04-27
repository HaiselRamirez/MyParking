CREATE DATABASE myparking;
USE myparkin;

DROP TABLE IF EXISTS  usuarios;
CREATE  TABLE usuarios(
  id int not null auto_increment primary key,
  usuario varchar(25) not null UNIQUE  ADD KEY,
  clave VArchar(255) not null,
  nombre varchar(200) not null,
  correo varchar(200) null,
  cargo varchar(50) not null,
  tanda varchar(50) not null,
  estado boolean not null default 1
);