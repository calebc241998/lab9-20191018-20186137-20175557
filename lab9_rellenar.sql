#Rellenar tabla Humanos (Estado = (0 = Humano, 1 = Zombie))
INSERT INTO Humanos (idHumanos,nombre,apellido,sexo,estado)
VALUES ('97488413128','Ángel','Velasco','Masculino',0),
('89746475918','Emiliana','Holgado','Femenino',1),
('77806510558','Andrea','Cruz','Otro',0),
('74135829468','Agustín','Cañas','Masculino',1),
('69696250983','Aurelia','Bravo','Femenino',0),
('21236975207','Paris','Marques','Otro',1),
('74158246528','Aarón','Almagro','Masculino',0),
('81222159247','Sara','Bustamante','Femenino',1),
('30749711428','Sol','Padrón','Otro',0),
('87527762156','Francisco','Martos','Masculino',1),
('70261922721','María','Corral','Femenino',0),
('91804205897','Paz','Taboada','Otro',1),
('63814016213','Edgar','Morillas','Masculino',0),
('58626217672','Alicia','Rivera','Femenino',1),
('65451083214','Noel','Coronado','Otro',0),
('85108319319','Emilio','Córdova','Masculino',1),
('17008401432','Petra','Tudela','Femenino',0),
('15696505953','Gael','Olivera','Otro',1),
('90064731703','Enrique','Luján','Masculino',0),
('80824997512','Iris','Ubeda','Femenino',1);

#Rellenar tabla Supervivientes
INSERT INTO Supervivientes (idHumanos,peso,fuerza,idPareja)
VALUES ('97488413128',67.9,99.96,NULL),
('77806510558',62.01,85.75,NULL),
('69696250983',56.2,71.54,NULL),
('74158246528',80.7,118.58,NULL),
('30749711428',70.1,99.96,NULL),
('70261922721',59.5,81.34,NULL),
('63814016213',74.1,96.04,NULL),
('65451083214',66.2,85.75,NULL),
('17008401432',58.3,75.46,NULL),
('90064731703',67.6,88.34,NULL);

UPDATE Supervivientes SET idPareja = '69696250983' WHERE idHumanos = '97488413128';
UPDATE Supervivientes SET idPareja = '97488413128' WHERE idHumanos = '69696250983';
UPDATE Supervivientes SET idPareja = '70261922721' WHERE idHumanos = '74158246528';
UPDATE Supervivientes SET idPareja = '74158246528' WHERE idHumanos = '70261922721';
UPDATE Supervivientes SET idPareja = '17008401432' WHERE idHumanos = '63814016213';
UPDATE Supervivientes SET idPareja = '63814016213' WHERE idHumanos = '17008401432';

#Rellenar tabla Virus
INSERT INTO Virus (nombre)
VALUES ('Tyrant'),
('Green Flu'),
('Cordyceps');

#Rellenar tabla Variantes
INSERT INTO Variante (nombre,idVirus)
VALUES ('Alpha',1),
('Beta',1),
('Epsilon',1),
('Boomer',2),
('Hunter',2),
('Smoker',2),
('Runner',3),
('Stalker',3),
('Clicker',3);

#Rellenar tabla Tipos
INSERT INTO Tipo (nombre) 
VALUES ('Demoledor'),
('Rápido'),
('Niño'),
('Normal'),
('Otro');

#Rellenar tabla Zombies
INSERT INTO Zombies (idHumanos,fechaInfeccion,idVariante,idTipo,victimas)
VALUES ('89746475918','2022-04-03 14:00:45',1,4,6),
('74135829468','2022-01-28 18:26:23',2,4,3),
('21236975207','2022-02-15 16:38:51',1,4,0),
('81222159247','2022-01-30 13:23:12',6,3,21),
('87527762156','2021-12-21 11:19:19',8,2,5),
('91804205897','2022-05-16 19:36:34',9,2,12),
('58626217672','2021-12-26 20:22:57',7,2,10),
('85108319319','2022-06-05 10:14:46',5,1,16),
('15696505953','2022-04-03 06:08:35',1,3,4),
('80824997512','2021-12-01 02:54:06',3,5,32);

#Rellenar tabla Objetos (Vacuna = (0 = No es vacuna, 1 = Es vacuna))
INSERT INTO Objetos (nombre,peso,vacuna)
VALUES ('Botiquin',0.5,0),
('Palanca',2.5,0),
('Soga',1.2,0),
('Vacuna Tipo A',0.1,1),
('Vacuna Tipo B',0.1,1);

#Rellenar tabla Efectividad
INSERT INTO Efectividad (idTipo,idObjetos,porcentaje)
VALUES (1,4,35),
(2,4,45),
(3,4,98),
(4,4,95),
(5,4,23),
(1,5,85),
(2,5,79),
(3,5,60),
(4,5,56),
(5,5,10);

#Rellenar tabla Mochila
INSERT INTO Mochila (idObjetos,idHumanos,stock)
VALUES (1,'97488413128',4),
(4,'97488413128',1),
(5,'97488413128',2),
(1,'77806510558',1),
(2,'77806510558',1),
(3,'77806510558',1),
(2,'69696250983',1),
(4,'69696250983',2),
(5,'69696250983',3),
(1,'74158246528',1),
(3,'74158246528',1),
(4,'74158246528',2),
(2,'30749711428',1),
(3,'30749711428',1),
(5,'30749711428',3),
(1,'70261922721',2),
(2,'70261922721',1),
(4,'70261922721',4),
(3,'63814016213',1),
(4,'63814016213',3),
(5,'63814016213',4),
(1,'65451083214',4),
(2,'65451083214',1),
(5,'65451083214',1),
(1,'17008401432',3),
(2,'17008401432',1),
(4,'17008401432',3),
(1,'90064731703',3),
(2,'90064731703',1),
(3,'90064731703',1);