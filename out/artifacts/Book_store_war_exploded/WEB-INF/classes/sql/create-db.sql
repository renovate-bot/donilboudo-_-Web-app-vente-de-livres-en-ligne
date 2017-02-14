CREATE TABLE `BOOK` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `isbn` varchar(50) DEFAULT NULL,
  `title` text,
  `author` varchar(100) DEFAULT NULL,
  `editor` varchar(100) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `details` text,
  `coverImage` varchar(100) DEFAULT '',
  `releaseDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;


CREATE TABLE `SHOPPING_CART_ITEM` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `bookFK` int(11) unsigned NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `totalCost` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `CART_BOOK` (`bookFK`),
  CONSTRAINT `CART_BOOK` FOREIGN KEY (`bookFK`) REFERENCES `BOOK` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;