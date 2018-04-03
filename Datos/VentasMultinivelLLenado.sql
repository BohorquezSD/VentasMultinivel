INSERT into CATEGORIA values('1', 'Belleza', 'Productos que sirven para el cuidado de la belleza');
INSERT into CATEGORIA values('2', 'Alimento', 'Productos comestibles');
INSERT into CATEGORIA values('3', 'Medicina', 'Productos que sirven el cuidado de la salud');

INSERT into SUBCATEGORIA values('1', 'Cremas', 'Cremas corporales', '1');
INSERT into SUBCATEGORIA values('2', 'Shampoo', 'Jabon de cabello', '1');
INSERT into SUBCATEGORIA values('3', 'Suplementos deportivos', 'Productos que sirven como complemento deportivo', '2');
INSERT into SUBCATEGORIA values('4', 'Pastillas', 'Medicamentos en pastilla', '3');

INSERT into PRODUCTO values('1','Crema buena','crema antiedad para la piel', '1');
INSERT into PRODUCTO values('2','Proteina de soya','suplemento de proteina de origen vegetal', '3');
INSERT into PRODUCTO values('3','Shampo 0 caspa','shampoo anti caspa', '1');

INSERT into PRECIO values('1',DATE'2018-03-01','50000');
INSERT into PRECIO values('2',DATE'2018-03-01','1690000.32');
INSERT into PRECIO values('3',DATE'2018-03-01','80000');

INSERT into PAIS values('1','Colombia');

INSERT into REGION values('1','Andina','1');
INSERT into REGION values('2','Pacifica','1');

INSERT into PRODUCTO_REGION values('1','1','30');
INSERT into PRODUCTO_REGION values('2','1','10');
INSERT into PRODUCTO_REGION values('3','2','5');

INSERT into CLASIFICACION values('1','BEGINNER','0.01');
INSERT into CLASIFICACION values('2','JUNIOR','0.03');
INSERT into CLASIFICACION values('3','SENIOR','0.05');
INSERT into CLASIFICACION values('4','MASTER','0.07');

INSERT into REP_VENTAS(K_CODREPVENTAS , N_NOMBRE , N_APELLIDO, I_CORREO, I_GENERO, F_FECHANAC, F_FECHACON, I_TELEFONO, I_DIRECCION, K_REGION, K_CLASIFICACION)values('1000001','Maria','Marquez','mama@correo','F',DATE'1987-01-01',DATE'2016-03-04', '1000000', 'kr123', '1','1');
INSERT into REP_VENTAS(K_CODREPVENTAS , N_NOMBRE , N_APELLIDO, I_CORREO, I_GENERO, F_FECHANAC, F_FECHACON, I_TELEFONO, I_DIRECCION, K_REGION, K_CLASIFICACION)values('10000000','Sebastian','Bohorquez','seb@correo','M',DATE'1997-01-01',DATE'2018-03-04', '1111111', 'calle123', '1','1');
INSERT into REP_VENTAS values('20000000','Duvan','Prieto','dup@correo','M',DATE'1996-03-01',DATE'2018-02-20', '22222222', 'calle1234', '1','10000000' ,'2');
INSERT into REP_VENTAS values('30000000','Alexis','Sanchez','alsb@correo','M',DATE'1990-06-15',DATE'2018-04-01', '3333333', 'calle1235', '2','10000000' ,'3');


INSERT into CLIENTE values ('400000', 'Juan','Rodriguez','calle 40 cr 7','villavicencio','4444444', 'jam@correo', '10000000');


