-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 27, 2020 at 05:25 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bioskop`
--

-- --------------------------------------------------------

--
-- Table structure for table `hall`
--

CREATE TABLE `hall` (
  `HallId` int(11) NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Capacity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hall`
--

INSERT INTO `hall` (`HallId`, `Name`, `Capacity`) VALUES
(1, 'Petar Pan', 100),
(2, 'Merlin Monro', 10),
(3, 'Trnova Ruzica', 50),
(4, 'Crvenkapa', 10);

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE `movie` (
  `MovieId` int(11) NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Genre` varchar(50) DEFAULT NULL,
  `Director` varchar(50) DEFAULT NULL,
  `Year` int(11) DEFAULT NULL,
  `DurationInMinutes` int(11) DEFAULT NULL,
  `UserId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `movie`
--

INSERT INTO `movie` (`MovieId`, `Name`, `Genre`, `Director`, `Year`, `DurationInMinutes`, `UserId`) VALUES
(1, 'Film1', 'action', 'Producent Producentic', 2020, 120, 2),
(2, 'Film2', 'crime', 'Prod Procent', 2020, 129, 2),
(3, 'Movi3', 'comedy', 'Ivona Heldrih', 2020, 134, 2),
(4, 'Film1299', 'historical', 'Producent Producentic', 2020, 120, 2);

-- --------------------------------------------------------

--
-- Table structure for table `moviemarathon`
--

CREATE TABLE `moviemarathon` (
  `MarathonId` int(11) NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `UserId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `moviemarathon`
--

INSERT INTO `moviemarathon` (`MarathonId`, `Name`, `UserId`) VALUES
(1, 'Maraton1', 2),
(2, 'Maraton1239191', 2);

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `reservationId` int(11) NOT NULL,
  `nameLastname` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `userId` int(11) NOT NULL,
  `showtimeId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`reservationId`, `nameLastname`, `email`, `userId`, `showtimeId`) VALUES
(1, 'Ivona Heldrih', 'ivona@gmail.com', 2, 1),
(2, 'Ivon Ivonic', 'ivonicivon@gmail.com', 2, 2),
(3, 'Iv Ivic', 'iv@gmail.com', 2, 4),
(4, 'Pera Peric', 'peki@gmail.com', 2, 11);

-- --------------------------------------------------------

--
-- Table structure for table `showtime`
--

CREATE TABLE `showtime` (
  `ShowtimeId` int(11) NOT NULL,
  `Date` date DEFAULT NULL,
  `UserId` int(11) DEFAULT NULL,
  `HallId` int(11) DEFAULT NULL,
  `MovieId` int(11) DEFAULT NULL,
  `MovieMarathonId` int(11) DEFAULT NULL,
  `time` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `showtime`
--

INSERT INTO `showtime` (`ShowtimeId`, `Date`, `UserId`, `HallId`, `MovieId`, `MovieMarathonId`, `time`) VALUES
(1, '2020-06-08', 2, 1, 1, 1, '14:00:00'),
(2, '2020-06-08', 2, 3, 2, 1, '18:15:00'),
(3, '2020-06-08', 2, 4, 2, NULL, '21:15:00'),
(4, '2020-06-08', 2, 4, 1, NULL, '12:00:00'),
(5, '2020-06-11', 2, 4, 2, NULL, '12:00:00'),
(6, '2020-06-08', 2, 4, 2, NULL, '10:00:00'),
(7, '2020-06-08', 2, 3, 2, NULL, '11:00:00'),
(8, '2020-06-08', 2, 4, 1, NULL, '23:40:00'),
(9, '2020-06-30', 2, 2, 2, NULL, '14:00:00'),
(10, '2020-07-07', 2, 4, 4, 2, '12:00:00'),
(11, '2020-07-07', 2, 4, 3, 2, '15:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `UserId` int(11) NOT NULL,
  `Username` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Lastname` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Password` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`UserId`, `Username`, `Name`, `Lastname`, `Password`) VALUES
(1, 'pera', 'Pera', 'Peric', 'pera'),
(2, 'ivona', 'Ivona', 'Heldrih', 'ivona98');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hall`
--
ALTER TABLE `hall`
  ADD PRIMARY KEY (`HallId`);

--
-- Indexes for table `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`MovieId`),
  ADD KEY `fk_movie` (`UserId`);

--
-- Indexes for table `moviemarathon`
--
ALTER TABLE `moviemarathon`
  ADD PRIMARY KEY (`MarathonId`),
  ADD KEY `fk_userM` (`UserId`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`reservationId`),
  ADD KEY `dh` (`showtimeId`),
  ADD KEY `usernfn` (`userId`);

--
-- Indexes for table `showtime`
--
ALTER TABLE `showtime`
  ADD PRIMARY KEY (`ShowtimeId`),
  ADD KEY `fk_userS` (`UserId`),
  ADD KEY `fk_hallS` (`HallId`),
  ADD KEY `fk_movieS` (`MovieId`),
  ADD KEY `fk_marathonS` (`MovieMarathonId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`UserId`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `movie`
--
ALTER TABLE `movie`
  ADD CONSTRAINT `fk_movie` FOREIGN KEY (`UserId`) REFERENCES `user` (`UserId`);

--
-- Constraints for table `moviemarathon`
--
ALTER TABLE `moviemarathon`
  ADD CONSTRAINT `fk_userM` FOREIGN KEY (`UserId`) REFERENCES `user` (`UserId`);

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `dh` FOREIGN KEY (`showtimeId`) REFERENCES `showtime` (`ShowtimeId`),
  ADD CONSTRAINT `usernfn` FOREIGN KEY (`userId`) REFERENCES `user` (`UserId`);

--
-- Constraints for table `showtime`
--
ALTER TABLE `showtime`
  ADD CONSTRAINT `fk_hallS` FOREIGN KEY (`HallId`) REFERENCES `hall` (`HallId`),
  ADD CONSTRAINT `fk_marathonS` FOREIGN KEY (`MovieMarathonId`) REFERENCES `moviemarathon` (`MarathonId`),
  ADD CONSTRAINT `fk_movieS` FOREIGN KEY (`MovieId`) REFERENCES `movie` (`MovieId`),
  ADD CONSTRAINT `fk_userS` FOREIGN KEY (`UserId`) REFERENCES `user` (`UserId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
