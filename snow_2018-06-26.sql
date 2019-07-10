CREATE DATABASE snow;

CREATE TABLE `snow`.`book` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `book_id` VARCHAR(45) NOT NULL,
  `book_name` VARCHAR(45) NOT NULL,
  `book_category` VARCHAR(45) NOT NULL,
  `book_author` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `snow`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(45) NOT NULL,
  `user_name` VARCHAR(45) NOT NULL,
  `user_department` VARCHAR(45) NOT NULL,
  `user_category` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `snow`.`borrow_time` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `year` VARCHAR(45) NOT NULL,
  `month` VARCHAR(45) NOT NULL,
  `day` VARCHAR(45) NOT NULL,
  `hour` VARCHAR(45) NOT NULL,
  `minute` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `snow`.`return_time` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `year` VARCHAR(45) NOT NULL,
  `month` VARCHAR(45) NOT NULL,
  `day` VARCHAR(45) NOT NULL,
  `hour` VARCHAR(45) NOT NULL,
  `minute` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
