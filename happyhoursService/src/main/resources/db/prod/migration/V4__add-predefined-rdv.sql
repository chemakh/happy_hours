SET NAMES 'utf8' COLLATE 'utf8_general_ci' ;

set FOREIGN_KEY_CHECKS=0 ;

REPLACE INTO predefined_rdv (`id`,`bg_color`,`period`,`label`,`reference`,`reference_doctor`,`state`) VALUES
(1,'#03d13b',15,'rdv-15','1d412e5a0eaf4f68',NULL ,TRUE ),
(2,'#03d13b',30,'rdv-30','1dd3de5a0eaf4f68',NULL ,TRUE ),
(3,'#03d13b',45,'rdv-45','1dz1de5a0eaf4f68',NULL ,TRUE ),
(4,'#03d13b',60,'rdv-60','1db3de5a0eaf4f68',NULL ,TRUE ) ;

set FOREIGN_KEY_CHECKS=1