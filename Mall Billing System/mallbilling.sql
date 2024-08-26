-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 02, 2023 at 07:26 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mallbilling`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `StockUpdate` (IN `NAME` TEXT, IN `QUANTITY` INT(20))   BEGIN
UPDATE products set quantity=QUANTITY where pname=NAME;
end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `aid` int(20) NOT NULL,
  `aname` text NOT NULL,
  `aemail` text NOT NULL,
  `aphone` text NOT NULL,
  `apass` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`aid`, `aname`, `aemail`, `aphone`, `apass`) VALUES
(1, 'Pratham', 'pratham1234@gmail.com', '9638432112', 'pratham@1234'),
(2, 'mihir', 'mihir1234@gmail.com', '6351756058', 'mihir@1234'),
(3, 'foram', 'foram1234@gmail.com', '7990584884', 'foram@1234'),
(4, 'kalp', 'kalp1234@gmail.com', '9265315053', 'kalp@1234'),
(5, 'stavan', 'stavan1234@gmail.com', '9409384160', 'stavan@1234');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `barcodeno` bigint(20) NOT NULL,
  `pname` text NOT NULL,
  `price` double NOT NULL,
  `quantity` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`barcodeno`, `pname`, `price`, `quantity`) VALUES
(22002171310001, 'milk', 43, 852),
(22002171310002, 'pencil', 10, 307),
(22002171310003, 'book', 200, 693),
(220021713100012, 'tea', 400, 100),
(220021713100013, 'kurkure', 40, 100),
(220021713100014, 'chips', 40, 100),
(220021713100015, 'nutella', 500, 50),
(220021713100016, 'pen', 5, 500),
(220021713100017, 'dustbin', 400, 20),
(220021713100018, 'kitkat', 30, 150),
(220021713100019, 'pasta', 45, 100);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`aid`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`barcodeno`),
  ADD UNIQUE KEY `pname` (`pname`) USING HASH;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `aid` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `barcodeno` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=220021713100021;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
