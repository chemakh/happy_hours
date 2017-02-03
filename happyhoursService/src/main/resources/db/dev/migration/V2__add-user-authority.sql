	SET NAMES 'utf8' COLLATE 'utf8_general_ci' ;

set FOREIGN_KEY_CHECKS=0 ;

	DELETE FROM `authority`;
  INSERT INTO `authority` (`id`,`name`) VALUES
	(1,'ROLE_CLIENT'),
	(2,'ROLE_ADMIN'),
	(4,'ROLE_MANAGER');

	set FOREIGN_KEY_CHECKS=1 ;