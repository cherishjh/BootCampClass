-- customer 테이블
CREATE TABLE `customer` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`user_id` VARCHAR(255) NOT NULL COLLATE 'utf8mb4_general_ci',
	`name` VARCHAR(255) NOT NULL COLLATE 'utf8mb4_general_ci',
	`password` VARCHAR(255) NOT NULL COLLATE 'utf8mb4_general_ci',
	`tel` CHAR(11) NOT NULL COLLATE 'utf8mb4_general_ci',
	`address` VARCHAR(255) NOT NULL DEFAULT '0' COLLATE 'utf8mb4_general_ci',
	`age` INT(11) NULL DEFAULT NULL,
	`gender` ENUM('M','W') NOT NULL COLLATE 'utf8mb4_general_ci',
	`point` BIGINT(20) NULL DEFAULT NULL,
	`alarm` CHAR(1) NULL DEFAULT 'Y' COLLATE 'utf8mb4_general_ci',
	`signin_date` DATETIME NULL DEFAULT NULL,
	`coupon` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;
