set FOREIGN_KEY_CHECKS=0 ;

REPLACE INTO `user` (`type`, `id`, `activated`, `email_key`, `email`, `firstname`, `lang_key`, `lastname`, `password`, `reference`, `reset_password_key`,`sex`) VALUES
	('user', 1, b'1', NULL, 'admin@agenda.ch', 'Admin', 'fr', 'Admin', '$2a$04$dA/H3TOPUuZ93BQIWReISOmidNcZJQ9UWL00sL.uSGFWD0h4L.QEW', MD5(1), NULL,'M') ;

	REPLACE INTO user_authority (`user_id`, `authority_id`) values (1,1) ;


DELETE  FROM  `subscription` ;

INSERT INTO `subscription` (`id`, `fix_price`,`max_agenda`,`smspu`,`type`,`user`,`max_sms`, `subscription_price`) VALUES
(1,0,1,0.08,'BASIC','DOCTOR',0,10),
(2,100,3,0,'MEDIUM','DOCTOR',520,0),
(3,200,5,0,'PREMIUM','DOCTOR',520,0),
(4,0,12,0.08,'BASIC','CENTER',0,40),
(5,0,20,0.07,'MEDIUM','CENTER',0,50),
(6,0,0,0.06,'PREMIUM','CENTER',0,60) ;


	set FOREIGN_KEY_CHECKS=1 ;