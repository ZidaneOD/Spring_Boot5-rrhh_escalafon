/*Populate tables*/
INSERT INTO cargoUsuario(tipoCargo,estado) VALUES('Administrador',TRUE);
INSERT INTO cargoUsuario(tipoCargo,estado) VALUES('Jefe',TRUE);
INSERT INTO cargoUsuario(tipoCargo,estado) VALUES('Trabajador',TRUE);
INSERT INTO cargoUsuario(tipoCargo,estado) VALUES('Secretarua',FALSE);


/*Populat tabla productos*/
INSERT INTO usuarios(nombre,apellidoPat,apellidoMat,fechaNaci,correo,login,pass,estado,idCargo) VALUES('Andy','Fernandez','Erazo',NOW(),'fernandez@escalafon.com','ferErazo','12345',TRUE,1);
INSERT INTO usuarios(nombre,apellidoPat,apellidoMat,fechaNaci,correo,login,pass,estado,idCargo) VALUES('Zidane','Ortiz','Diaz',NOW(),'zidane@escalafon.com','zd16','12345',TRUE,1);
INSERT INTO usuarios(nombre,apellidoPat,apellidoMat,fechaNaci,correo,login,pass,estado,idCargo) VALUES('Freddy','Moya','Pacheco',NOW(),'moya@escalafon.com','ferErazo','12345',TRUE,2);
INSERT INTO usuarios(nombre,apellidoPat,apellidoMat,fechaNaci,correo,login,pass,estado,idCargo) VALUES('Tatiana','Quesquen','Carvallo',NOW(),'quesquen@escalafon.com','quesCarva','12345',TRUE,3);