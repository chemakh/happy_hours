set FOREIGN_KEY_CHECKS=0 ;

REPLACE INTO `user` (`type`, `id`, `activated`, `email_key`, `email`, `firstname`, `lastname`, `password`, `reference`, `reset_password_key`,`sex`) VALUES
	('user', 1, b'1', NULL, 'lazher.chemakh@gmail.com', 'Admin','Admin', '$2a$04$dA/H3TOPUuZ93BQIWReISOmidNcZJQ9UWL00sL.uSGFWD0h4L.QEW', MD5(1), NULL,'M') ;

	REPLACE INTO user_authority (`user_id`, `authority_id`) values (1,2) ;
