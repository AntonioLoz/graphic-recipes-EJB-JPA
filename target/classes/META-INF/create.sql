CREATE TABLE `Users` (`user_id` VARCHAR(255) NOT NULL,`name` VARCHAR(255) NOT NULL,`last_name` VARCHAR(255) NOT NULL,`email` VARCHAR(255) NOT NULL,`password` VARCHAR(255) NOT NULL,`role` VARCHAR(255) NOT NULL,PRIMARY KEY (`email`));
CREATE TABLE `recipes` (`recipe_id` VARCHAR(255) NOT NULL,`description` TEXT NOT NULL,`likes` INT,`category_fk` INT NOT NULL,`short_description` VARCHAR(255),PRIMARY KEY (`recipe_id`));
CREATE TABLE `users_recipes` (`user_id` VARCHAR(155) NOT NULL,`recipes_id` VARCHAR(155) NOT NULL,PRIMARY KEY (`user_id`,`recipes_id`));
CREATE TABLE `categories` (`id` INT NOT NULL,`name` VARCHAR(55) NOT NULL,PRIMARY KEY (`id`));
ALTER TABLE `recipes` ADD CONSTRAINT `recipes_fk0` FOREIGN KEY (`category_fk`) REFERENCES `categories`(`id`);
ALTER TABLE `users_recipes` ADD CONSTRAINT `users_recipes_fk0` FOREIGN KEY (`user_id`) REFERENCES `Users`(`user_id`);
ALTER TABLE `users_recipes` ADD CONSTRAINT `users_recipes_fk1` FOREIGN KEY (`recipes_id`) REFERENCES `recipes`(`recipe_id`);