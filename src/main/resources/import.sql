/*Populate tables*/
INSERT INTO cargousuarios(tipo_cargo,estado) VALUES('Administrador',1);
INSERT INTO cargousuarios(tipo_cargo,estado) VALUES('Jefe',1);
INSERT INTO cargousuarios(tipo_cargo,estado) VALUES('Trabajador',1);
INSERT INTO cargousuarios(tipo_cargo,estado) VALUES('Secretarua',0);


/*Populat tabla productos*/
INSERT INTO usuarios(nombre,apellido_pat,apellido_mat,fecha_naci,correo,login,pass,estado,id_cargo) VALUES('Andy','Fernandez','Erazo',NOW(),'fernandez@escalafon.com','ferErazo','12345',TRUE,1);
INSERT INTO usuarios(nombre,apellido_pat,apellido_mat,fecha_naci,correo,login,pass,estado,id_cargo) VALUES('Zidane','Ortiz','Diaz',NOW(),'zidane@escalafon.com','zd16','12345',TRUE,1);
INSERT INTO usuarios(nombre,apellido_pat,apellido_mat,fecha_naci,correo,login,pass,estado,id_cargo) VALUES('Freddy','Moya','Pacheco',NOW(),'moya@escalafon.com','ferErazo','12345',TRUE,2);
INSERT INTO usuarios(nombre,apellido_pat,apellido_mat,fecha_naci,correo,login,pass,estado,id_cargo) VALUES('Tatiana','Quesquen','Carvallo',NOW(),'quesquen@escalafon.com','quesCarva','12345',TRUE,3);