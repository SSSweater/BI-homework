create database lib;

CREATE TABLE `lib`.`oltp` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `borrow_time` VARCHAR(45) NOT NULL,
  `return_time` VARCHAR(45) NOT NULL,
  `user_id` VARCHAR(45) NOT NULL,
  `user_name` VARCHAR(45) NOT NULL,
  `user_department` VARCHAR(45) NOT NULL,
  `user_category` VARCHAR(45) NOT NULL,
  `book_id` VARCHAR(45) NOT NULL,
  `book_category` VARCHAR(45) NOT NULL,
  `book_name` VARCHAR(45) NOT NULL,
  `book_author` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

INSERT INTO `lib`.`oltp` (`borrow_time`, `return_time`, `user_id`, `user_name`, `user_department`, `user_category`, `book_id`, `book_category`, `book_name`, `book_author`) VALUES ('2019-03-14-10-33', '2019-04-01-11-23', '161250050', '刘元', '软件学院', '学生', '1', '教材', '微积分', '李四');
INSERT INTO `lib`.`oltp` (`borrow_time`, `return_time`, `user_id`, `user_name`, `user_department`, `user_category`, `book_id`, `book_category`, `book_name`, `book_author`) VALUES ('2019-05-01-13-21', '2019-05-02-14-25', '16120060', '马琳', '软件学院', '学生', '2', '英语', '托福冲刺30天', '张三');
INSERT INTO `lib`.`oltp` (`borrow_time`, `return_time`, `user_id`, `user_name`, `user_department`, `user_category`, `book_id`, `book_category`, `book_name`, `book_author`) VALUES ('2019-05-10-16-44', '2019-05-20-10-22', '12345', '章云', '软件学院', '老师', '3', '计算机', '单片机原理', '陈旭');



