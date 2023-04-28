/*Populate tables*/
INSERT INTO cargousuarios(tipo_cargo,estado) VALUES('Administrador',1);
INSERT INTO cargousuarios(tipo_cargo,estado) VALUES('Jefe',1);
INSERT INTO cargousuarios(tipo_cargo,estado) VALUES('Trabajador',1);
INSERT INTO cargousuarios(tipo_cargo,estado) VALUES('Secretarua',0);


/*Populat tabla productos*/
INSERT INTO usuarios(nombres,apellido_pat,apellido_mat,fecha_naci,correo,login,pass,estado,id_cargo) VALUES('Andy','Fernandez','Erazo',NOW(),'fernandez@escalafon.com','ferErazo','12345',TRUE,1);
INSERT INTO usuarios(nombres,apellido_pat,apellido_mat,fecha_naci,correo,login,pass,estado,id_cargo) VALUES('Zidane','Ortiz','Diaz',NOW(),'zidane@escalafon.com','zd16','12345',TRUE,1);
INSERT INTO usuarios(nombres,apellido_pat,apellido_mat,fecha_naci,correo,login,pass,estado,id_cargo) VALUES('Freddy','Moya','Pacheco',NOW(),'moya@escalafon.com','ferErazo','12345',TRUE,2);
INSERT INTO usuarios(nombres,apellido_pat,apellido_mat,fecha_naci,correo,login,pass,estado,id_cargo) VALUES('Tatiana','Quesquen','Carvallo',NOW(),'quesquen@escalafon.com','quesCarva','12345',TRUE,3);


/*tabla facultades*/
INSERT INTO facultades(nombre_facultad,estado) VALUES('Bromatología y Nutrición',TRUE);
INSERT INTO facultades(nombre_facultad,estado) VALUES('Ciencias',TRUE);
INSERT INTO facultades(nombre_facultad,estado) VALUES('Ciencias Económicas, Contables y Finacieras',TRUE);
INSERT INTO facultades(nombre_facultad,estado) VALUES('Ciencias Empresariales',TRUE);
INSERT INTO facultades(nombre_facultad,estado) VALUES('Ciencias Sociales',TRUE);
INSERT INTO facultades(nombre_facultad,estado) VALUES('Derecho y Ciencias Políticas',TRUE);
INSERT INTO facultades(nombre_facultad,estado) VALUES('Educación',TRUE);
INSERT INTO facultades(nombre_facultad,estado) VALUES('Ingeniería Agaria, Industrias Alimentarias y Ambiental',TRUE);
INSERT INTO facultades(nombre_facultad,estado) VALUES('Ingeniería Civil',TRUE);
INSERT INTO facultades(nombre_facultad,estado) VALUES('Ingeniería Industrial, Sistemas e Informática',TRUE);
INSERT INTO facultades(nombre_facultad,estado) VALUES('Ingeniería Pesquera',TRUE);
INSERT INTO facultades(nombre_facultad,estado) VALUES('Ingeniería Química y Metalúrgica',TRUE);
INSERT INTO facultades(nombre_facultad,estado) VALUES('Medicina Humana',TRUE);

/*Tabla escuelas*/
INSERT INTO escuelas(nombre_escuela,id_facultad,estado) VALUES('Ingenieria Electrónica',10,TRUE);
INSERT INTO escuelas(nombre_escuela,id_facultad,estado) VALUES('Ingenieria Industrial',10,TRUE);
INSERT INTO escuelas(nombre_escuela,id_facultad,estado) VALUES('Ingenieria Informática',10,TRUE);
INSERT INTO escuelas(nombre_escuela,id_facultad,estado) VALUES('Ingenieria de Sistemas',10,TRUE);
INSERT INTO escuelas(nombre_escuela,id_facultad,estado) VALUES('Bromatología y Nutrición',1,TRUE);
INSERT INTO escuelas(nombre_escuela,id_facultad,estado) VALUES('Gestón en Hoteleria y Turismo',4,TRUE);
INSERT INTO escuelas(nombre_escuela,id_facultad,estado) VALUES('Administración',4,TRUE);
INSERT INTO escuelas(nombre_escuela,id_facultad,estado) VALUES('Negocios Internacionales',4,TRUE);