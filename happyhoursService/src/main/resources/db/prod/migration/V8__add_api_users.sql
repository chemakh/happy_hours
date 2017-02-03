set FOREIGN_KEY_CHECKS=0 ;

  REPLACE INTO `user` (`type`, `id`, `activated`, `email_key`, `email`, `firstname`, `lang_key`, `lastname`, `password`, `reference`,  `reset_password_key`,`sex`) VALUES
	 ('user', 1008, b'1', NULL, 'api@agenda.ch', 'Agenda api', 'fr', 'agenda api', '$2a$10$NShtKcDuQYN6NXUpclIHM.ru7z386myP4FTPzE/v59hiObwdzrYs2', MD5(59),  NULL,'M') ;

	 REPLACE INTO `user` (`type`, `id`, `activated`, `email_key`, `email`, `firstname`, `lang_key`, `lastname`, `password`, `reference`,  `reset_password_key`,`sex`) VALUES
	 ('user', 1007, b'1', NULL, 'admin_api@agenda.ch', 'admin api', 'fr', 'admin api', '$2a$10$NShtKcDuQYN6NXUpclIHM.ru7z386myP4FTPzE/v59hiObwdzrYs2', MD5(89),  NULL,'M') ;

   REPLACE INTO `user` (`type`, `id`, `activated`, `email_key`, `email`, `firstname`, `lang_key`, `lastname`, `password`, `reference`,  `reset_password_key`,`sex`) VALUES
	 ('doctor', 1000, b'1', NULL, 'doctor_api@agenda.ch', 'Doctor api', 'fr', 'Doctor api', '$2a$10$NShtKcDuQYN6NXUpclIHM.ru7z386myP4FTPzE/v59hiObwdzrYs2', MD5(79), NULL,'M') ;

	REPLACE INTO `user` (`type`, `id`, `activated`, `email_key`, `email`, `firstname`, `lang_key`, `lastname`, `password`, `reference`,  `reset_password_key`,`sex`) VALUES
	('patient', 1001, b'1', NULL, 'patient_api@agenda.ch', 'Patient_api', 'fr', 'Patient api', '$2a$10$NShtKcDuQYN6NXUpclIHM.ru7z386myP4FTPzE/v59hiObwdzrYs2', MD5(23), NULL,'M') ;

	REPLACE INTO `user` (`type`, `id`, `activated`, `email_key`, `email`, `firstname`, `lang_key`, `lastname`, `password`, `reference`, `reset_password_key`,`sex`) VALUES
	('user', 1002, b'1', NULL, 'assistant_admin_api@agenda.ch', 'Assistant admin api', 'fr', 'Assistant admin api', '$2a$10$NShtKcDuQYN6NXUpclIHM.ru7z386myP4FTPzE/v59hiObwdzrYs2', MD5(45),  NULL,'M') ;

	REPLACE INTO `user` (`type`, `id`, `activated`, `email_key`, `email`, `firstname`, `lang_key`, `lastname`, `password`, `reference`, `reset_password_key`,`sex`) VALUES
	('assistant', 1003, b'1', NULL, 'assistant_doctor_api@agenda.ch', 'Assistant doctor api', 'fr', 'Assistant doctor api', '$2a$10$NShtKcDuQYN6NXUpclIHM.ru7z386myP4FTPzE/v59hiObwdzrYs2', MD5(36), NULL,'M') ;

	REPLACE INTO `patient` (`avs_number`, `birthday`, `deleted`, `mobile`, `reference_parent`, `tel`, `id`) VALUES
	(NULL, '1989-04-01', 0, NULL, NULL, NULL, 1001);

	REPLACE INTO `doctor` (`accept_rdv`,  `gln`, `id`, `subscription_id`, `first_bill`) VALUES
	(1,   '4567899512478',  1000, 1 ,false);

	REPLACE INTO `assistant` (`active`,  `reference_doctor`, `id`) VALUES
	(1 , MD5(79), 1003);

	REPLACE INTO user_authority (`user_id`, `authority_id`) values (1000,5) ;
	REPLACE INTO user_authority (`user_id`, `authority_id`) values (1001,2) ;
	REPLACE INTO user_authority (`user_id`, `authority_id`) values (1002,4) ;
	REPLACE INTO user_authority (`user_id`, `authority_id`) values (1003,6) ;

	set FOREIGN_KEY_CHECKS=1 ;