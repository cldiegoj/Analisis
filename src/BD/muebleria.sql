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
INSERT INTO usuario VALUES('U0004','arturogo','geek456','C0001');
INSERT INTO usuario VALUES('U0005','henrygaa','style789','C0001');



CREATE TABLE `categoria` (
  `cat_cod` char(5) NOT NULL PRIMARY KEY,
  `cat_nom` varchar(40) NOT NULL,
  `cat_des` varchar(40) NOT NULL
);

INSERT INTO categoria VALUES('C0001','admin','Administradores');
INSERT INTO categoria VALUES('C0002','usuario','Usuarios generales');
INSERT INTO categoria VALUES('C0003','cliente','Clientes regulares');
INSERT INTO categoria VALUES('C0004','invitado','Usuarios invitados');
INSERT INTO categoria VALUES('C0005','premium','Usuarios premium');
INSERT INTO categoria VALUES('C0006','moderador','Moderadores del sistema');
INSERT INTO categoria VALUES('C0007','editor','Editores de contenido');
INSERT INTO categoria VALUES('C0008','analista','Analistas de datos');
INSERT INTO categoria VALUES('C0009','soporte','Equipo de soporte técnico');
INSERT INTO categoria VALUES('C0010','visitante','Visitantes del sitio');


CREATE TABLE `articulos` (
  `art_cod` char(5) NOT NULL DEFAULT '' PRIMARY KEY,
  `art_nom` varchar(30) DEFAULT NULL,
  `art_des` varchar(60) DEFAULT NULL,
  `art_pre` decimal(10,2) DEFAULT NULL,
  `art_stk` int(11) DEFAULT NULL,
  `pro_cod` char(5) NOT NULL
);

INSERT INTO articulos VALUES('A0001','Prueba','Prueba sql','31.10','20','P0001');
INSERT INTO articulos VALUES('A0002', 'Silla', 'silla de comedor', '25.50', '15', 'P0002');
INSERT INTO articulos VALUES('A0003', 'Sofa', 'sofá de cuero', '499.99', '5', 'P0003');
INSERT INTO articulos VALUES('A0004', 'Escritorio', 'escritorio de roble', '150.20', '10', 'P0001');
INSERT INTO articulos VALUES('A0005', 'Cama', 'cama queen-size', '299.90', '8', 'P0004');
INSERT INTO articulos VALUES('A0006', 'Estante', 'estante de libros', '75.00', '20', 'P0005');
INSERT INTO articulos VALUES('A0007', 'Mesita', 'mesita de noche', '50.30', '12', 'P0006');
INSERT INTO articulos VALUES('A0008', 'Armario', 'armario de pino', '199.50', '18', 'P0007');
INSERT INTO articulos VALUES('A0009', 'Mesa de café', 'mesa de café moderna', '120.99', '25', 'P0008');
INSERT INTO articulos VALUES('A0010', 'Comoda', 'cómoda de nogal', '180.75', '15', 'P0009');
INSERT INTO articulos VALUES('A0011', 'Sillon', 'sillón reclinable', '349.60', '7', 'P0010');
INSERT INTO articulos VALUES('A0012', 'Mesa de centro', 'mesa de centro de vidrio', '89.80', '14', 'P0001');
INSERT INTO articulos VALUES('A0013', 'Perchero', 'perchero de metal', '45.15', '30', 'P0010');
INSERT INTO articulos VALUES('A0014', 'Banco', 'banco para barra de cocina', '65.30', '22', 'P0003');
INSERT INTO articulos VALUES('A0015', 'Lámpara', 'lámpara de pie moderna', '120.90', '18', 'P0004');
INSERT INTO articulos VALUES('A0016', 'Espejo', 'espejo de pared grande', '55.50', '20', 'P0005');
INSERT INTO articulos VALUES('A0017', 'Reloj', 'reloj de pared vintage', '30.25', '25', 'P0006');
INSERT INTO articulos VALUES('A0018', 'Alfombra', 'alfombra de lana', '89.99', '12', 'P0010');
INSERT INTO articulos VALUES('A0019', 'Candelabro', 'candelabro de cristal', '55.75', '15', 'P0010');
INSERT INTO articulos VALUES('A0020', 'Jarrón', 'jarrón de cerámica', '40.50', '20', 'P0009');
INSERT INTO articulos VALUES('A0021', 'Cojines', 'cojines decorativos', '18.75', '30', 'P0001');
INSERT INTO articulos VALUES('A0022', 'Mantel', 'mantel de lino', '22.40', '18', 'P0001');
INSERT INTO articulos VALUES('A0023', 'Cortinas', 'cortinas opacas', '35.90', '10', 'P0002');
INSERT INTO articulos VALUES('A0024', 'Planta artificial', 'planta decorativa', '15.80', '25', 'P0010');
INSERT INTO articulos VALUES('A0025', 'Copas de vino', 'juego de copas de vino', '28.60', '20', 'P0009');
INSERT INTO articulos VALUES('A0026', 'Cubertería', 'set de cubiertos de acero inoxidable', '45.20', '15', 'P0010');

CREATE TABLE `clientes` (
  `cli_cod` char(5) NOT NULL PRIMARY KEY DEFAULT '',
  `cli_nom` varchar(35) DEFAULT NULL,
  `cli_tel` char(8) DEFAULT NULL,
  `cli_cor` varchar(30) DEFAULT NULL,
  `cli_dir` varchar(30) DEFAULT NULL
);

INSERT INTO clientes VALUES('T0001','Aaron','960182123','aaronfijas@hotmail.com','Av. Fijas');
INSERT INTO clientes VALUES ('T0002', 'Beatriz', '987654321', 'beatriz@email.com', 'Calle Principal');
INSERT INTO clientes VALUES ('T0003', 'Carlos', '912345678', 'carlos@gmail.com', 'Avenida Central');
INSERT INTO clientes VALUES ('T0004', 'Daniela', '934567890', 'daniela@yahoo.com', 'Calle de la Rosa');
INSERT INTO clientes VALUES ('T0005', 'Eduardo', '923456789', 'eduardo@email.com', 'Paseo del Sol');
INSERT INTO clientes VALUES ('T0006', 'Fernanda', '945678901', 'fernanda@gmail.com', 'Callejón de Flores');
INSERT INTO clientes VALUES ('T0007', 'Gabriel', '978901234', 'gabriel@hotmail.com', 'Avenida del Bosque');
INSERT INTO clientes VALUES ('T0008', 'Hilda', '965432189', 'hilda@yahoo.com', 'Calle del Mar');
INSERT INTO clientes VALUES ('T0009', 'Ignacio', '989012345', 'ignacio@email.com', 'Avenida de las Montañas');
INSERT INTO clientes VALUES ('T0010', 'Jasmine', '911223344', 'jasmine@gmail.com', 'Calle del Arcoiris');
INSERT INTO clientes VALUES ('T0011', 'Kurt', '956783412', 'kurt@email.com', 'Paseo de las Estrellas');
INSERT INTO clientes VALUES ('T0012', 'Lorena', '977894561', 'lorena@hotmail.com', 'Calle de los Sueños');
INSERT INTO clientes VALUES ('T0013', 'Miguel', '934561278', 'miguel@yahoo.com', 'Avenida de la Luna');
INSERT INTO clientes VALUES ('T0014', 'Natalia', '988765432', 'natalia@email.com', 'Calle de los Recuerdos');
INSERT INTO clientes VALUES ('T0015', 'Oscar', '923487654', 'oscar@gmail.com', 'Avenida de los Sueños');
INSERT INTO clientes VALUES ('T0016', 'Paola', '911122334', 'paola@hotmail.com', 'Calle de las Flores');
INSERT INTO clientes VALUES ('T0017', 'Quentin', '955566677', 'quentin@email.com', 'Avenida de la Libertad');
INSERT INTO clientes VALUES ('T0018', 'Rosa', '977788899', 'rosa@yahoo.com', 'Calle de la Esperanza');
INSERT INTO clientes VALUES ('T0019', 'Santiago', '966677788', 'santiago@email.com', 'Avenida de los Ángeles');
INSERT INTO clientes VALUES ('T0020', 'Teresa', '922334455', 'teresa@gmail.com', 'Calle de las Mariposas');

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
  `pro_cod` char(5) NOT NULL PRIMARY KEY,
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