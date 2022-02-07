-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 24, 2019 at 04:42 PM
-- Server version: 5.7.24
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `privatehire`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
CREATE TABLE IF NOT EXISTS `booking` (
  `book_id` int(11) DEFAULT NULL,
  `pickup` text,
  `destination` text,
  `datetime` text,
  `clientid` int(11) DEFAULT NULL,
  `driverid` int(11) DEFAULT NULL,
  KEY `clientid` (`clientid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`book_id`, `pickup`, `destination`, `datetime`, `clientid`, `driverid`) VALUES
(2, 'thisplace', 'thatplace', 'now', 4, 1),
(1, 'shcool', 'homne', 'Tue Apr 23 13:06:44 GMT-08:00 2019', 2, 1),
(1, 'here', 'now', 'Wed Apr 24 02:51:33 GMT-08:00 2019', 2, 1),
(1, 'there', 'here', 'Wed Apr 24 08:27:34 GMT-08:00 2019', 2, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `userid` int(11) DEFAULT NULL,
  `name` text,
  `phone` text,
  `address` text,
  `email` text,
  KEY `uid` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`userid`, `name`, `phone`, `address`, `email`) VALUES
(2, 'Idiom Hipster', '0700639459', 'Everywhere', 'idiom@everywhere.com'),
(4, 'another client', '0712345678', 'No where', 'another@nowhere.com');

-- --------------------------------------------------------

--
-- Table structure for table `drivers`
--

DROP TABLE IF EXISTS `drivers`;
CREATE TABLE IF NOT EXISTS `drivers` (
  `driverid` int(11) DEFAULT NULL,
  `name` text,
  `car` text,
  `seats` int(11) DEFAULT NULL,
  KEY `driverid` (`driverid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `drivers`
--

INSERT INTO `drivers` (`driverid`, `name`, `car`, `seats`) VALUES
(1, 'Adam Onyango', 'KAF 036X', 6);

-- --------------------------------------------------------

--
-- Table structure for table `enquiry`
--

DROP TABLE IF EXISTS `enquiry`;
CREATE TABLE IF NOT EXISTS `enquiry` (
  `id` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `title` tinytext,
  `enquiry` text,
  `reply` text,
  KEY `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `enquiry`
--

INSERT INTO `enquiry` (`id`, `userid`, `title`, `enquiry`, `reply`) VALUES
(2, 2, 'that', 'another sample', NULL),
(3, 2, 'new', 'Type any query here and hit submit', NULL),
(4, 2, 'working', 'is it working?', 'yes it is');

-- --------------------------------------------------------

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
CREATE TABLE IF NOT EXISTS `reviews` (
  `bookingid` int(3) NOT NULL,
  `rating` int(3) NOT NULL,
  `review` varchar(250) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reviews`
--

INSERT INTO `reviews` (`bookingid`, `rating`, `review`) VALUES
(1, 3, 'Meh');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(250) DEFAULT NULL,
  `pass` varchar(250) DEFAULT NULL,
  `ID` int(11) NOT NULL,
  `role` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `pass`, `ID`, `role`) VALUES
('driver', 'driver', 1, 'driver'),
('client', 'client', 2, 'client'),
('center', 'center', 3, 'ccenter'),
('client b', 'client b', 4, 'client');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `clientid` FOREIGN KEY (`clientid`) REFERENCES `users` (`ID`);

--
-- Constraints for table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `uid` FOREIGN KEY (`userid`) REFERENCES `users` (`ID`);

--
-- Constraints for table `drivers`
--
ALTER TABLE `drivers`
  ADD CONSTRAINT `driverid` FOREIGN KEY (`driverid`) REFERENCES `users` (`ID`);

--
-- Constraints for table `enquiry`
--
ALTER TABLE `enquiry`
  ADD CONSTRAINT `user` FOREIGN KEY (`userid`) REFERENCES `users` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
