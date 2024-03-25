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


-- 전체 coupon table
CREATE TABLE `coupon_list` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`coupon_name` VARCHAR(255) NOT NULL DEFAULT '0' COLLATE 'utf8mb4_general_ci',
	`price` INT(11) NOT NULL DEFAULT '0',
	`expire_date` DATETIME NOT NULL DEFAULT '0000-00-00 00:00:00',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;


-- coupon 발행테이블(중간)
CREATE TABLE `coupon_published` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`user_id` INT(11) NOT NULL DEFAULT '0',
	`whether_used` CHAR(1) NOT NULL DEFAULT 'N' COLLATE 'utf8mb4_general_ci',
	`download_date` DATETIME NOT NULL DEFAULT current_timestamp(),
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;
