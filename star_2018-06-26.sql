CREATE DATABASE star;

CREATE TABLE `star`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(45) NOT NULL,
  `user_name` VARCHAR(45) NOT NULL,
  `user_department` VARCHAR(45) NOT NULL,
  `user_category` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `star`.`book` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `book_name` VARCHAR(45) NOT NULL,
  `book_category` VARCHAR(45) NOT NULL,
  `book_id` VARCHAR(45) NOT NULL,
  `book_author` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `star`.`time` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `borrow_time` VARCHAR(45) NOT NULL,
  `return_time` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
