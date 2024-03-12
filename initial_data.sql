CREATE TABLE nguoi_dung (
  ma_nguoi_dung INT PRIMARY KEY AUTO_INCREMENT,
  ten_hien_thi VARCHAR(32),
  ten_dang_nhap VARCHAR(32),
  email VARCHAR(64),
  so_dien_thoai VARCHAR(16),
  mat_khau VARCHAR(256),
  da_khoa BOOLEAN,
  co_gang_dang_nhap INT,
  thoi_gian_tao TIMESTAMP
);

CREATE TABLE quyen (
  ma_quyen INT PRIMARY KEY AUTO_INCREMENT,
  ten_quyen VARCHAR(32),
  mo_ta VARCHAR(256)
);

CREATE TABLE phan_quyen (
  ma_nguoi_dung INT NOT NULL REFERENCES nguoi_dung (ma_nguoi_dung),
  ma_quyen INT NOT NULL REFERENCES quyen (ma_quyen)
);

CREATE TABLE the_loai (
  ma_the_loai INT PRIMARY KEY AUTO_INCREMENT,
  ten_the_loai VARCHAR(64),
  anh_dai_dien VARCHAR(256) DEFAULT '/public/anh-trong.jpg'
);

CREATE TABLE chat_lieu (
  ma_chat_lieu INT PRIMARY KEY AUTO_INCREMENT,
  ten_chat_lieu VARCHAR(64)
);

CREATE TABLE thuong_hieu (
  ma_thuong_hieu INT PRIMARY KEY AUTO_INCREMENT,
  ten_thuong_hieu VARCHAR(64)
);

CREATE TABLE san_pham (
  ma_san_pham INT PRIMARY KEY AUTO_INCREMENT,
  ten_san_pham VARCHAR(128),
  anh_xem_truoc VARCHAR(256) DEFAULT '/public/anh-trong.jpg',
  diem_trung_binh DECIMAL,
  so_danh_gia INT,
  mo_ta TEXT,
  gia DECIMAL,
  so_luong INT,
  trong_luong DECIMAL,
  kich_thuoc VARCHAR(16),
  ma_chat_lieu INT NOT NULL REFERENCES chat_lieu (ma_chat_lieu),
  ma_thuong_hieu INT NOT NULL REFERENCES thuong_hieu (ma_thuong_hieu),
  ma_the_loai INT NOT NULL REFERENCES the_loai (ma_the_loai),
  da_an BOOLEAN
);

CREATE TABLE IF NOT EXISTS anh_san_pham (
  ma_anh INT PRIMARY KEY AUTO_INCREMENT,
  ma_san_pham INT NOT NULL REFERENCES san_pham (ma_san_pham),
  duong_dan VARCHAR(256)
);

CREATE TABLE san_pham_trong_gio (
  ma_muc_gio_hang INT PRIMARY KEY AUTO_INCREMENT,
  ma_san_pham INT NOT NULL REFERENCES san_pham (ma_san_pham),
  so_luong_mua INT
);

CREATE TABLE dat_hang (
  ma_dat_hang INT PRIMARY KEY AUTO_INCREMENT,
  dia_chi_giao VARCHAR(128),
  hinh_thuc_thanh_toan INT,
  ghi_chu VARCHAR(128),
  phuong_thuc_van_chuyen INT,
  sdt_nhan VARCHAR(16),
  ten_nguoi_nhan VARCHAR(64),
  trang_thai INT,
  ngay_dat_hang TIMESTAMP,
  tong_tien DECIMAL,
  ma_nguoi_dat INT NOT NULL REFERENCES nguoi_dung (ma_nguoi_dung)
);

CREATE TABLE san_pham_dat (
  ma_san_pham_dat INT PRIMARY KEY AUTO_INCREMENT,
  ma_san_pham INT NOT NULL REFERENCES san_pham (ma_san_pham),
  don_gia DECIMAL,
  so_luong INT
);

CREATE TABLE danh_gia (
  ma_danh_gia INT PRIMARY KEY AUTO_INCREMENT,
  ma_nguoi_danh_gia INT NOT NULL REFERENCES nguoi_dung (ma_nguoi_dung),
  noi_dung_danh_gia VARCHAR(256),
  diem_danh_gia INT,
  ngay_danh_gia TIMESTAMP,
  ma_san_pham_dat INT NOT NULL REFERENCES san_pham_dat (ma_san_pham_dat)
);

CREATE TABLE binh_luan (
  ma_binh_luan INT PRIMARY KEY AUTO_INCREMENT,
  noi_dung_binh_luan VARCHAR(256),
  ma_san_pham INT NOT NULL REFERENCES san_pham (ma_san_pham),
  ngay_binh_luan TIMESTAMP,
  ma_nguoi_dung INT NOT NULL REFERENCES nguoi_dung (ma_nguoi_dung),
  ma_binh_luan_goc INT REFERENCES binh_luan (id)
);

CREATE TABLE tin_tuc (
  ma_tin_tuc INT PRIMARY KEY AUTO_INCREMENT,
  tieu_de VARCHAR(128),
  mo_ta VARCHAR(256),
  nhan_nut_lien_ket VARCHAR(256),
  anh VARCHAR(256)
);

CREATE TABLE lich_su_hanh_dong (
  ma_hang_dong INT PRIMARY KEY AUTO_INCREMENT,
  ma_nguoi_dung INT NOT NULL REFERENCES nguoi_dung (ma_nguoi_dung),
  loai_hanh_dong INT,
  dia_chi_ip VARCHAR(256),
  thoi_gian TIMESTAMP,
  chi_tiet VARCHAR(128),
  thanh_cong BOOLEAN
);

INSERT INTO nguoi_dung (ma_nguoi_dung, ten_hien_thi, ten_dang_nhap, email, so_dien_thoai, mat_khau, da_khoa, co_gang_dang_nhap, thoi_gian_tao)
VALUES (1, 'Luu Van Dung', 'dunglv', 'dunglv202@gmail.com', '0987654321', '$2a$10$xnQ5yz8NYJTsRDEMsFUwRu.ZGspgb6rrAIKyQvzziR1xc8voSedDW', FALSE, 0, '2002-01-01 00:00:00');

INSERT INTO quyen (ma_quyen, ten_quyen)
VALUES  (1, 'KHACH_HANG'),
        (2, 'ADMIN'),
        (3, 'QUAN_LY'),
        (4, 'NHAN_VIEN');

INSERT INTO phan_quyen (ma_nguoi_dung, ma_quyen)
VALUES  (1, 2),
        (1, 3),
        (1, 4);

INSERT INTO the_loai (ten_the_loai)
VALUES  ('Quần'),
        ('Áo'),
        ('Giày'),
        ('Váy'),
        ('Mũ'),
        ('Túi xách');

INSERT INTO thuong_hieu (ten_thuong_hieu)
VALUES  ('Adidas'),
        ('Nike'),
        ('Puma'),
        ('5S'),
        ('Dior'),
        ('Louis Vuitton'),
        ('Gucci'),
        ('Hermes');

INSERT INTO chat_lieu (ten_chat_lieu)
VALUES  ('Vải'),
        ('Da'),
        ('Len'),
        ('Nhung'),
        ('Khác');

