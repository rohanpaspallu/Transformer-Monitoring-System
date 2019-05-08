-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 29, 2017 at 06:42 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tms`
--

-- --------------------------------------------------------

--
-- Table structure for table `complaint`
--

CREATE TABLE `complaint` (
  `Sr_no` int(3) NOT NULL,
  `c_id` int(6) NOT NULL,
  `c_date` date NOT NULL,
  `type` varchar(30) NOT NULL,
  `status` varchar(30) NOT NULL,
  `emp_id` int(6) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `complaint`
--

INSERT INTO `complaint` (`Sr_no`, `c_id`, `c_date`, `type`, `status`, `emp_id`) VALUES
(1, 45678, '2017-09-28', 'transformer', 'successfull', 12345);

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

CREATE TABLE `notification` (
  `Sr_no` int(3) NOT NULL,
  `n_id` int(6) NOT NULL,
  `volt` decimal(3,0) NOT NULL,
  `temp` decimal(3,0) NOT NULL,
  `oil` decimal(3,0) NOT NULL,
  `longitude` varchar(8) NOT NULL,
  `latitude` varchar(8) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transformer`
--

CREATE TABLE `transformer` (
  `Sr_no` int(3) NOT NULL,
  `t_id` int(6) NOT NULL,
  `t_details` varchar(30) NOT NULL,
  `company_name` varchar(30) NOT NULL,
  `warranty` int(2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transformer`
--

INSERT INTO `transformer` (`Sr_no`, `t_id`, `t_details`, `company_name`, `warranty`) VALUES
(1, 34578, 'active ', 'Siemens', 5);

-- --------------------------------------------------------

--
-- Table structure for table `user_reg`
--

CREATE TABLE `user_reg` (
  `id` int(11) NOT NULL,
  `emp_id` varchar(10) NOT NULL,
  `password` varchar(20) NOT NULL,
  `designation` varchar(30) NOT NULL,
  `emp_name` varchar(30) NOT NULL,
  `email_id` varchar(50) NOT NULL,
  `mobile_no` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_reg`
--

INSERT INTO `user_reg` (`id`, `emp_id`, `password`, `designation`, `emp_name`, `email_id`, `mobile_no`) VALUES
(3, '145236', 'abel', 'junior engineer', 'abel varkey', 'abel@gmail.com', '999999999'),
(2, '859675', 'rohan', 'junior engineer', 'rohan paspallu', 'paspallu.rohan@gmail.com', '9173927448');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `complaint`
--
ALTER TABLE `complaint`
  ADD PRIMARY KEY (`Sr_no`,`c_id`,`emp_id`);

--
-- Indexes for table `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`Sr_no`,`n_id`);

--
-- Indexes for table `transformer`
--
ALTER TABLE `transformer`
  ADD PRIMARY KEY (`Sr_no`,`t_id`);

--
-- Indexes for table `user_reg`
--
ALTER TABLE `user_reg`
  ADD PRIMARY KEY (`id`,`emp_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `complaint`
--
ALTER TABLE `complaint`
  MODIFY `Sr_no` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `notification`
--
ALTER TABLE `notification`
  MODIFY `Sr_no` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `transformer`
--
ALTER TABLE `transformer`
  MODIFY `Sr_no` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `user_reg`
--
ALTER TABLE `user_reg`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
