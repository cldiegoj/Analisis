DROP DATABASE IF EXISTS muebleria;
CREATE DATABASE muebleria;
USE muebleria;


CREATE TABLE `usuario` (
  `cod` char(5) NOT NULL PRIMARY KEY,
  `usr` varchar(40) NOT NULL,
  `pass` varchar(40) NOT NULL,
  `cat_cod` char(5) NOT NULL
);

INSERT INTO usuario VALUES('U0001','cldiegoj','pas123','C0001');
INSERT INTO usuario VALUES('U0002','capysoza','con123','C0001');
INSERT INTO usuario VALUES('U0003','aaron123','qwe123','C0001');

CREATE TABLE `categoria` (
  `cat_cod` char(5) NOT NULL PRIMARY KEY,
  `cat_nom` varchar(40) NOT NULL,
  `cat_des` varchar(40) NOT NULL
);

INSERT INTO categoria VALUES('C0001','admin','Administradores');
INSERT INTO categoria VALUES('C0002','usuario','Usuarios generales');

CREATE TABLE `articulos` (
  `art_cod` char(5) NOT NULL DEFAULT '' PRIMARY KEY,
  `art_nom` varchar(30) DEFAULT NULL,
  `art_uni` char(4) DEFAULT NULL,
  `art_pre` decimal(10,2) DEFAULT NULL,
  `art_stk` int(11) DEFAULT NULL,
  `pro_cod` int(11) DEFAULT NULL
);


CREATE TABLE `clientes` (
  `cli_cod` char(5) NOT NULL PRIMARY KEY DEFAULT '',
  `cli_nom` varchar(35) DEFAULT NULL,
  `cli_tel` char(8) DEFAULT NULL,
  `cli_cor` varchar(30) DEFAULT NULL,
  `cli_dir` varchar(30) DEFAULT NULL
);

CREATE TABLE `fac_cabe` (
  `fac_num` char(12) NOT NULL PRIMARY KEY DEFAULT '',
  `fac_fec` datetime DEFAULT NULL,
  `cli_cod` char(5) DEFAULT NULL,
  `fac_igv` char(1) DEFAULT NULL
);

CREATE TABLE `fac_deta` (
  `fac_num` char(12) NOT NULL PRIMARY KEY DEFAULT '',
  `art_cod` char(5) NOT NULL DEFAULT '',
  `art_can` int(11) DEFAULT NULL
);

CREATE TABLE `proveedor` (
  `pro_cod` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `pro_nom` varchar(25) DEFAULT NULL,
  `pro_ruc` int(11) DEFAULT NULL
);



ALTER TABLE `fac_cabe`
ADD CONSTRAINT `fk_fac_cabe_cliente` FOREIGN KEY (`cli_cod`) REFERENCES `clientes` (`cli_cod`);

ALTER TABLE `fac_deta`
ADD CONSTRAINT `fk_fac_deta_articulos` FOREIGN KEY (`art_cod`) REFERENCES `articulos` (`art_cod`);

ALTER TABLE `fac_deta`
ADD CONSTRAINT `fk_fac_deta_fac_cabe` FOREIGN KEY (`fac_num`) REFERENCES `fac_cabe` (`fac_num`);

ALTER TABLE `articulos`
ADD CONSTRAINT `fk_articulos_proveedor` FOREIGN KEY (`pro_cod`) REFERENCES `proveedor` (`pro_cod`);

ALTER TABLE `usuario`
ADD CONSTRAINT `fk_usuario_categoria` FOREIGN KEY (`cat_cod`) REFERENCES `categoria` (`cat_cod`);

