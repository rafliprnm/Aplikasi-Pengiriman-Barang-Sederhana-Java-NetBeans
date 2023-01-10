-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 10 Jan 2023 pada 09.07
-- Versi server: 10.4.27-MariaDB
-- Versi PHP: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pbokel4`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `akun`
--

CREATE TABLE `akun` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  `wallet` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `akun`
--

INSERT INTO `akun` (`username`, `password`, `role`, `wallet`) VALUES
('pengirim', '123', 'pengirim', 0),
('admin', '123', 'admin', 0),
('kurir', '123', 'kurir', 585000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `paket`
--

CREATE TABLE `paket` (
  `idBarang` int(50) NOT NULL,
  `namaBarang` varchar(50) NOT NULL,
  `beratBarang` double NOT NULL,
  `jumlahBarang` double NOT NULL,
  `totalBerat` double NOT NULL,
  `alamat` varchar(10000) NOT NULL,
  `penerima` varchar(50) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 0,
  `jenis_pengiriman` varchar(50) NOT NULL,
  `jenis_paket` varchar(50) NOT NULL,
  `harga_paket` int(11) NOT NULL,
  `pembayaran` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `paket`
--

INSERT INTO `paket` (`idBarang`, `namaBarang`, `beratBarang`, `jumlahBarang`, `totalBerat`, `alamat`, `penerima`, `status`, `jenis_pengiriman`, `jenis_paket`, `harga_paket`, `pembayaran`) VALUES
(1, 'mainan', 2, 2, 4, 'shvbfjakfvob', 'rafli', 1, 'fast', 'barang', 50000, 'Transfer'),
(2, 'kadal', 23, 3, 69, 'pondok sukahati', 'iqbal', 1, 'Express', 'Tumbuhan/Hewan', 30000, 'Transfer'),
(3, 'KTP', 3, 2, 6, 'Pondok Sukahati Indah', 'Rafli', 1, 'Express', 'Dokumen', 25000, 'Transfer'),
(4, 'tumbuhan langka', 32, 2, 64, 'Jl Happy', 'bayu', 1, 'Express', 'Tumbuhan/Hewan', 30000, 'Transfer'),
(6, 'RAM 100 GB', 20, 2, 40, 'PBB', 'yezenk', 1, 'Express', 'Pecah Belah', 95000, 'Transfer'),
(7, 'kucing', 4, 2, 8, 'Bandung', 'Bagir', 1, 'Express', 'Tumbuhan/Hewan', 30000, 'Transfer'),
(8, 'pulpen', 2, 5, 10, 'PBB', 'zaza', 1, 'Fast', 'Pecah Belah', 90000, 'Transfer'),
(9, 'Laptop', 5, 2, 10, 'Pbb', 'Nugi', 1, 'Express', 'Pecah Belah', 95000, 'Transfer'),
(10, 'Laptop ', 25, 2, 50, 'Kircon', 'Gumelar', 1, 'Express', 'Dokumen', 25000, 'Transfer');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `paket`
--
ALTER TABLE `paket`
  ADD PRIMARY KEY (`idBarang`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `paket`
--
ALTER TABLE `paket`
  MODIFY `idBarang` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
