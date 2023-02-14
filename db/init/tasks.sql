# -- Adminer 4.8.1 MySQL 8.0.32 dump
#
# SET NAMES utf8;
# SET time_zone = '+00:00';
# SET foreign_key_checks = 0;
# SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';
#
# SET NAMES utf8mb4;
#
# DROP TABLE IF EXISTS `tasks`;
# CREATE TABLE `tasks` (
#   `id` int NOT NULL AUTO_INCREMENT,
#   `created_on` datetime(6) DEFAULT NULL,
#   `description` varchar(255) NOT NULL,
#   `slug` binary(16) NOT NULL,
#   `status` bit(1) NOT NULL,
#   `title` varchar(255) NOT NULL,
#   `updated_on` datetime(6) DEFAULT NULL,
#   PRIMARY KEY (`id`),
#   UNIQUE KEY `UK_qpovfl3b0k3v76u0bgc6su1fy` (`slug`)
# ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
#
# INSERT INTO `tasks` (`id`, `created_on`, `description`, `slug`, `status`, `title`, `updated_on`) VALUES
# (1,	'2023-02-12 12:28:51.396085',	'I have to learn and finish Spring Start here',	UNHEX('3FE9F507EE17468EA6E24519E978A70E'),	CONV('0', 2, 10) + 0,	'Finishing My Book',	'2023-02-12 12:28:51.396402'),
# (2,	'2023-02-12 12:28:51.426012',	'I have to learn and finish the Java FSD course',	UNHEX('8444F717B72F4354B80B9B09D83719A4'),	CONV('0', 2, 10) + 0,	'Finishing My Other Course',	'2023-02-12 12:28:51.426036');
#
# -- 2023-02-12 12:30:55
