DROP DATABASE IF EXISTS muebleria;
CREATE DATABASE muebleria;
USE muebleria;


CREATE TABLE `usuario` (
  `cod` int PRIMARY KEY AUTO_INCREMENT,
  `usr` varchar(40) NOT NULL,
  `pass` varchar(40) NOT NULL,
  `est` int,
  `cat_cod` int NOT NULL
);

INSERT INTO usuario VALUES(null,'cldiegoj','pas123',0,'1');
INSERT INTO usuario VALUES(null,'capysoza','con123',0,'1');
INSERT INTO usuario VALUES(null,'aaron123','qwe123',0,'1');
INSERT INTO usuario VALUES(null,'arturogo','geek456',0,'1');
INSERT INTO usuario VALUES(null,'henrygaa','style789',0,'1');



CREATE TABLE `categoria` (
  `cat_cod` int PRIMARY KEY AUTO_INCREMENT,
  `cat_nom` varchar(40) NOT NULL,
  `cat_des` varchar(40) NOT NULL
);

INSERT INTO categoria VALUES(null,'Admin','Administradores');
INSERT INTO categoria VALUES(null,'Usuario','Usuarios generales');
INSERT INTO categoria VALUES(null,'Cliente','Clientes regulares');
INSERT INTO categoria VALUES(null,'Proveedor','Proveedor de muebleria');


CREATE TABLE `articulos` (
  `art_cod` int PRIMARY KEY AUTO_INCREMENT,
  `art_nom` varchar(30) DEFAULT NULL,
  `art_des` varchar(60) DEFAULT NULL,
  `art_pre` decimal(10,2) DEFAULT NULL,
  `art_stk` int(11) DEFAULT NULL,
  `pro_cod` int NOT NULL
);

INSERT INTO articulos VALUES(null,'Prueba','Prueba sql','31.10','20',1);
INSERT INTO articulos VALUES(null, 'Silla', 'silla de comedor', '25.50', '15', 2);
INSERT INTO articulos VALUES(null, 'Sofa', 'sofá de cuero', '499.99', '5', 3);
INSERT INTO articulos VALUES(null, 'Escritorio', 'escritorio de roble', '150.20', '10', 1);
INSERT INTO articulos VALUES(null, 'Cama', 'cama queen-size', '299.90', '8', 4);
INSERT INTO articulos VALUES(null, 'Estante', 'estante de libros', '75.00', '20', 5);
INSERT INTO articulos VALUES(null, 'Mesita', 'mesita de noche', '50.30', '12', 6);
INSERT INTO articulos VALUES(null, 'Armario', 'armario de pino', '199.50', '18', 7);
INSERT INTO articulos VALUES(null, 'Mesa de café', 'mesa de café moderna', '120.99', '25', 8);
INSERT INTO articulos VALUES(null, 'Comoda', 'cómoda de nogal', '180.75', '15', 9);
INSERT INTO articulos VALUES(null, 'Sillon', 'sillón reclinable', '349.60', '7', 10);
INSERT INTO articulos VALUES(null, 'Mesa de centro', 'mesa de centro de vidrio', '89.80', '14', 1);
INSERT INTO articulos VALUES(null, 'Perchero', 'perchero de metal', '45.15', '30', 10);
INSERT INTO articulos VALUES(null, 'Banco', 'banco para barra de cocina', '65.30', '22', 3);
INSERT INTO articulos VALUES(null, 'Lámpara', 'lámpara de pie moderna', '120.90', '18', 4);
INSERT INTO articulos VALUES(null, 'Espejo', 'espejo de pared grande', '55.50', '20', 5);
INSERT INTO articulos VALUES(null, 'Reloj', 'reloj de pared vintage', '30.25', '25', 6);
INSERT INTO articulos VALUES(null, 'Alfombra', 'alfombra de lana', '89.99', '12', 10);
INSERT INTO articulos VALUES(null, 'Candelabro', 'candelabro de cristal', '55.75', '15', 10);
INSERT INTO articulos VALUES(null, 'Jarrón', 'jarrón de cerámica', '40.50', '20', 9);
INSERT INTO articulos VALUES(null, 'Cojines', 'cojines decorativos', '18.75', '30', 1);
INSERT INTO articulos VALUES(null, 'Mantel', 'mantel de lino', '22.40', '18', 1);
INSERT INTO articulos VALUES(null, 'Cortinas', 'cortinas opacas', '35.90', '10', 2);
INSERT INTO articulos VALUES(null, 'Planta artificial', 'planta decorativa', '15.80', '25', 10);
INSERT INTO articulos VALUES(null, 'Copas de vino', 'juego de copas de vino', '28.60', '20', 9);
INSERT INTO articulos VALUES(null, 'Cubertería', 'set de cubiertos de acero inoxidable', '45.20', '15', 10);

CREATE TABLE `clientes` (
  `cli_cod` int PRIMARY KEY AUTO_INCREMENT, 
  `cli_nom` varchar(35) DEFAULT NULL,
  `cli_tel` int(9) DEFAULT NULL,
  `cli_cor` varchar(30) DEFAULT NULL,
  `cli_dir` varchar(30) DEFAULT NULL,
  `cli_usr` varchar(30) NOT NULL,
  `cli_pas` varchar(30) NOT NULL,
  `cli_est` int
);

INSERT INTO clientes VALUES (null,'Aaron','960182123','aaronfijas@hotmail.com','Av. Fijas','aaron1','pas123',0);
INSERT INTO clientes VALUES (null, 'Beatriz', '987654321', 'beatriz@email.com', 'Calle Principal','beat31','pas12',0);
INSERT INTO clientes VALUES (null, 'Carlos', '912345678', 'carlos@gmail.com', 'Avenida Central','car91','pas556',0);
INSERT INTO clientes VALUES (null, 'Daniela', '934567890', 'daniela@yahoo.com', 'Calle de la Rosa','dan1xd','pas999',0);
INSERT INTO clientes VALUES (null, 'Eduardo', '923456789', 'eduardo@email.com', 'Paseo del Sol','eduf','wor12',0);
INSERT INTO clientes VALUES (null, 'Fernanda', '945678901', 'fernanda@gmail.com', 'Callejón de Flores','fer22','llor1',0);
INSERT INTO clientes VALUES (null, 'Gabriel', '978901234', 'gabriel@hotmail.com', 'Avenida del Bosque','gab22','man22',0);
INSERT INTO clientes VALUES (null, 'Hilda', '965432189', 'hilda@yahoo.com', 'Calle del Mar','hild69','lol123',0);
INSERT INTO clientes VALUES (null, 'Ignacio', '989012345', 'ignacio@email.com', 'Avenida de las Montañas','igna','pass444',0);
INSERT INTO clientes VALUES (null, 'Jasmine', '911223344', 'jasmine@gmail.com', 'Calle del Arcoiris','pp202','aisdji2',0);
INSERT INTO clientes VALUES (null, 'Kurt', '956783412', 'kurt@email.com', 'Paseo de las Estrellas','kurt14u9','oqwioe',0);
INSERT INTO clientes VALUES (null, 'Lorena', '977894561', 'lorena@hotmail.com', 'Calle de los Sueños','lor921','lsdjop2',0);
INSERT INTO clientes VALUES (null, 'Miguel', '934561278', 'miguel@yahoo.com', 'Avenida de la Luna','migu0582','ñkjsapias',0);
INSERT INTO clientes VALUES (null, 'Natalia', '988765432', 'natalia@email.com', 'Calle de los Recuerdos','nat292','ppasduq2',0);
INSERT INTO clientes VALUES (null, 'Oscar', '923487654', 'oscar@gmail.com', 'Avenida de los Sueños','osc22892','isisiwq',0);
INSERT INTO clientes VALUES (null, 'Paola', '911122334', 'paola@hotmail.com', 'Calle de las Flores','pao9u8','iojdoi',0);
INSERT INTO clientes VALUES (null, 'Quentin', '955566677', 'quentin@email.com', 'Avenida de la Libertad','queenxd','jqhwjdw',0);
INSERT INTO clientes VALUES (null, 'Rosa', '977788899', 'rosa@yahoo.com', 'Calle de la Esperanza','rosa29','2910sao',0);
INSERT INTO clientes VALUES (null, 'Santiago', '966677788', 'santiago@email.com', 'Avenida de los Ángeles','saned','99292',0);
INSERT INTO clientes VALUES (null, 'Teresa', '922334455', 'teresa@gmail.com', 'Calle de las Mariposas','tere9099','oksdjw2',0);
INSERT INTO clientes VALUES (null, 'Diego', '966089151', 'djcornejoli@hotmail.com' , 'Domingo Nieto' , 'cldiegoj', '123', 0);

CREATE TABLE `fac_cabe` (
  `fac_num` int PRIMARY KEY AUTO_INCREMENT,
  `fac_fec` date DEFAULT NULL,
  `cli_cod` int NOT NULL,
  `fac_igv` char(1) DEFAULT NULL
);


INSERT INTO `fac_cabe` VALUES (1,'2023-12-1',1,1);
INSERT INTO `fac_cabe` VALUES (2,'2023-10-2',1,1);

CREATE TABLE `fac_deta` (
  `fac_num` int ,
  `art_cod` int ,
  `art_can` int(11),
  PRIMARY KEY (fac_num,art_cod)
);

INSERT INTO `fac_deta` VALUES (1,2,5);
INSERT INTO `fac_deta` VALUES (1,4,10);
INSERT INTO `fac_deta` VALUES (2,7,10);

CREATE TABLE `proveedor` (
  `pro_cod` int PRIMARY KEY AUTO_INCREMENT,
  `pro_nom` varchar(25) DEFAULT NULL,
  `pro_ruc` int(11) DEFAULT NULL
);

INSERT INTO proveedor VALUES('P0001','Saga Fallabella','1234567');
INSERT INTO proveedor VALUES('P0002','ElectroMart','9876543');
INSERT INTO proveedor VALUES('P0003','TechTrends','8765432');
INSERT INTO proveedor VALUES('P0004','FashionRUs','7654321');
INSERT INTO proveedor VALUES('P0005','HomeEssentials','6543210');
INSERT INTO proveedor VALUES('P0006','GadgetGalore','5432109');
INSERT INTO proveedor VALUES('P0007','BeautyHub','4321098');
INSERT INTO proveedor VALUES('P0008','SportsZone','3210987');
INSERT INTO proveedor VALUES('P0009','BookHaven','2109876');
INSERT INTO proveedor VALUES('P0010','PetParadise','1098765');



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