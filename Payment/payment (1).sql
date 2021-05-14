-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2021 at 05:44 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `payment`
--

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `Payment_ID` int(11) NOT NULL,
  `Benefactor` varchar(50) NOT NULL,
  `Payer` varchar(50) NOT NULL,
  `Amount` double(12,2) NOT NULL,
  `Account_No` int(20) NOT NULL,
  `Bank` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`Payment_ID`, `Benefactor`, `Payer`, `Amount`, `Account_No`, `Bank`) VALUES
(1, 'Thushan', 'Chanka', 15000.00, 12345648, 'HNB'),
(5, 'Malar', ' Tap', 2999.00, 393733, 'BOC'),
(9, 'Sharmilan', 'Nilakshana', 10000.00, 200034678, 'Commercial Bank'),
(10, 'Sharmilan', 'Nilu', 2000.00, 200034678, 'Commercial Bank'),
(11, 'Malar', ' Tap', 2999.00, 393733, 'BOC'),
(13, 'souji', 'kishomi', 10000.00, 2333332, 'peoples'),
(14, 'souji', 'kishomi', 10000.00, 2333332, 'peoples');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`Payment_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `Payment_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
