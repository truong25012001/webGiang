
CREATE DATABASE [PTHTTTQL];
USE [PTHTTTQL]
GO
CREATE TABLE [dbo].[Book](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](200) NOT NULL,
	[author] [nvarchar](200) NOT NULL,
	[description] [nvarchar](500) NOT NULL,
	[day] [date] NOT NULL,
	[page] [int] NOT NULL,
	[cid] [int] NOT NULL,
	[image] [nvarchar](500) NOT NULL,
	[quantity] [int] NOT NULL,
	[sold] [int] NOT NULL,
	[price] [int] NULL,
 CONSTRAINT [PK__Book__3213E83F491F7C5C] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 5/30/2023 7:39:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK__Category__3213E83FB7B162D3] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Oder]    Script Date: 5/30/2023 7:39:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Oder](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[uid] [int] NULL,
	[quantity] [int] NULL,
	[date] [char](50) NULL,
	[totalmoney] [int] NULL,
	[status] [int] NULL,
 CONSTRAINT [PK__Oder__3213E83F7B00471C] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderLine]    Script Date: 5/30/2023 7:39:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderLine](
	[oid] [int] NOT NULL,
	[bid] [int] NOT NULL,
	[quantity] [int] NULL,
	[totalMoney] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[oid] ASC,
	[bid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Review]    Script Date: 5/30/2023 7:39:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Review](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[uid] [int] NOT NULL,
	[bid] [int] NULL,
	[content] [nvarchar](500) NOT NULL,
	[rating] [int] NOT NULL,
	[day] [date] NULL,
 CONSTRAINT [PK_Review] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 5/30/2023 7:39:19 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](100) NOT NULL,
	[password] [nvarchar](100) NOT NULL,
	[email] [nchar](100) NOT NULL,
	[duty] [int] NOT NULL,
 CONSTRAINT [PK__User__3213E83F2B10F17A] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Book] ON 

INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (1, N'Atlat Địa Lý Việt Nam ', N'Bộ Giáo Dục', N'Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2003-09-04' AS Date), 50, 3, N'giaokhoa1.jpg', 32, 21, 100000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (2, N'Đề Minh Họa Tiếng Anh', N'Vũ An Khang', N'Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2003-09-04' AS Date), 150, 3, N'giaokhoa2.jpg', 12, 17, 120000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (3, N'Ngữ Văn 9', N'Bộ Giáo Dục', N'Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2010-11-04' AS Date), 120, 3, N'giaokhoa3.jpg', -11, 36, 190000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (4, N'Vật Lý 12', N'Bộ Giáo Dục', N'Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2019-04-04' AS Date), 90, 3, N'giaokhoa4.jpg', -2, 28, 150000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (5, N'Toán 9', N'Bộ Giáo Dục', N'Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2022-10-04' AS Date), 130, 3, N'giaokhoa5.jpg', 12, 10, 130000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (6, N'Bài Tập Toán 5', N'Bộ Giáo Dục', N'Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2021-12-04' AS Date), 80, 3, N'giaokhoa6.jpg', 11, 12, 140000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (7, N'Tiếng Việt 5', N'Bộ Giáo Dục', N'Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2018-09-21' AS Date), 50, 3, N'giaokhoa7.jpg', 20, 5, 160000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (8, N'Khoa Học 5', N'Bộ Giáo Dục', N'Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2003-05-11' AS Date), 105, 3, N'giaokhoa8.jpg', 18, 9, 135000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (9, N'Âm Nhạc 2', N'Bộ Giáo Dục', N'Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2010-08-17' AS Date), 40, 3, N'giaokhoa9.jpg', 15, 14, 120000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (10, N'Tiếng Anh 7 Friend Plus', N'Vũ Văn Mạnh', N'Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2009-07-04' AS Date), 70, 3, N'giaokhoa10.jpg', 11, 20, 180000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (11, N'Thấu Hiểu Khách Hàng', N'Sơn Tùng', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2019-08-01' AS Date), 50, 1, N'kinhdoanh1.jpg', 12, 14, 195000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (12, N'Khởi Nghiệp Olline', N'Hoài An', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2020-09-07' AS Date), 60, 1, N'kinhdoanh2.jpg', 18, 9, 180000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (13, N'Chiến Lược Thực Thi', N'Lê Bá Long', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2022-11-23' AS Date), 70, 1, N'kinhdoanh3.jpg', 17, 8, 170000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (14, N'Nghệ Thuật Bán Hàng', N'Vũ Khánh Ly', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2021-12-25' AS Date), 80, 1, N'kinhdoanh4.jpg', 18, 18, 200000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (15, N'Marketing', N'Lê Văn Mạnh', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2022-10-17' AS Date), 90, 1, N'kinhdoanh5.jpg', 18, 8, 190000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (16, N'Khách Hàng Tiềm Năng', N'Vũ Hoài Nam', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2011-09-19' AS Date), 120, 1, N'kinhdoanh6.jpg', 18, 11, 210000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (17, N'Người Bán Hàng', N'Nguyễn Tú My', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2021-05-09' AS Date), 40, 1, N'kinhdoanh7.jpg', 11, 16, 220000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (18, N'Bí Quyết Bán Hàng', N'Đỗ Hoài Nam', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2017-04-11' AS Date), 30, 1, N'kinhdoanh8.jpg', 18, 7, 145000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (19, N'Chiến Lược Thực Thi 2', N'Lê Bá Long', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2016-06-07' AS Date), 50, 1, N'kinhdoanh9.jpg', 20, 3, 198000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (20, N'Nghệ Thuật Bán Hàng 2', N'Vũ Khánh An', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2009-09-08' AS Date), 70, 1, N'kinhdoanh10.jpg', 20, 4, 230000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (21, N'2000 Từ Vựng', N'Vũ Văn Linh', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2009-09-08' AS Date), 70, 5, N'ngoaingu1.jpg', 20, 4, 140000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (22, N'Ngữ Pháp Tiếng Anh', N'Hoài Thương', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2009-09-08' AS Date), 80, 5, N'ngoaingu2.jpg', 20, 2, 178000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (23, N'English Speaking', N'Long Mạnh', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2009-09-08' AS Date), 90, 5, N'ngoaingu3.jpg', 17, 12, 210000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (24, N'301 Câu Đàm Thoại', N'Vũ Văn Luân', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2009-09-08' AS Date), 60, 5, N'ngoaingu4.jpg', 18, 13, 190000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (25, N'Basic Ielts', N'Lê Trọng Biên', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2009-09-08' AS Date), 120, 5, N'ngoaingu5.jpg', 20, 7, 200000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (26, N'Tự Học Tiếng Thái', N'Vũ Khánh Lý', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2009-09-08' AS Date), 140, 5, N'ngoaingu6.jpg', 19, 5, 150000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (27, N'Tiếng Việt Cho Hoa', N'Vũ Hoài An', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2009-09-08' AS Date), 150, 5, N'ngoaingu7.jpg', 18, 3, 180000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (28, N'Hackers Ielts 1', N'Sơn Tùng', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2009-09-08' AS Date), 140, 5, N'ngoaingu8.jpg', 20, 2, 190000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (29, N'Cấu Trúc Tiếng Anh', N'Lê Văn Luyện', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2009-09-08' AS Date), 120, 5, N'ngoaingu9.jpg', 20, 15, 210000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (30, N'Hackers Ielts 2', N'Vũ Khánh An', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2009-09-08' AS Date), 110, 5, N'ngoaingu10.jpg', 20, 13, 100000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (31, N'Hoàng Tử Bé', N'Vũ Khánh An', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2022-09-25' AS Date), 110, 4, N'thieunhi1.jpg', 20, 13, 180000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (32, N'Còn Sẽ Tự Giác', N'Vương An An', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2021-01-23' AS Date), 180, 4, N'thieunhi2.jpg', 20, 12, 110000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (33, N'Con Mào', N'Đỗ Thị Hoài', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2021-09-18' AS Date), 140, 4, N'thieunhi3.jpg', 18, 4, 140000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (34, N'Bác Hồ Sống Mãi', N'Vương Khánh', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2021-04-03' AS Date), 110, 4, N'thieunhi4.jpg', 20, 1, 150000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (35, N'Tuổi Thơ Dữ Dội', N'Văn Mạnh', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2022-09-08' AS Date), 67, 4, N'thieunhi5.jpg', 20, 5, 160000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (36, N'Einstein', N'Thủy Tiên', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2020-10-04' AS Date), 80, 4, N'thieunhi6.jpg', 20, 7, 135000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (37, N'Lớp Mật Ngữ', N'Long Hách', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2018-11-14' AS Date), 90, 4, N'thieunhi7.jpg', 20, 9, 120000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (38, N'Bách Khoa Khủng Long', N'Vũ Khánh Ly', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2019-12-28' AS Date), 150, 4, N'thieunhi8.jpg', 20, 4, 105000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (39, N'Dế Mèn Phiêu Lưu Ký', N'Trọng Bách', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2019-06-11' AS Date), 40, 4, N'thieunhi9.jpg', 20, 3, 100000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (40, N'Newton', N'Vũ Khánh Ly', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2019-07-17' AS Date), 70, 4, N'thieunhi10.jpg', 19, 6, 190000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (41, N'Nhà Giả Kim', N'Vũ Văn Long', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2019-07-11' AS Date), 70, 2, N'vanhoc1.jpg', 20, 5, 110000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (42, N'Tôi Là Bê Tô', N'Hoài Anh', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2019-05-20' AS Date), 80, 2, N'vanhoc2.jpg', 20, 5, 185000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (43, N'Làm Bạn Với Bầu Trời', N'Văn Mạnh', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2020-06-17' AS Date), 90, 2, N'vanhoc3.jpg', 19, 4, 130000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (44, N'Lời Tiên Tri', N'Yên Thế', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2019-07-16' AS Date), 110, 2, N'vanhoc4.jpg', 20, 2, 100000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (45, N'Đóa Hoa Sương', N'Long Hách', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2022-12-12' AS Date), 120, 2, N'vanhoc5.jpg', 20, 5, 185000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (46, N'Dấu Chân Trên Cát', N'Vũ Khánh Lý', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2021-11-14' AS Date), 130, 2, N'vanhoc6.jpg', 20, 1, 150000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (47, N'Chiến Binh cầu Vồng', N'Dương An An', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2020-03-09' AS Date), 150, 2, N'vanhoc7.jpg', 20, 7, 197000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (48, N'Cánh Cửa Thầm Thì', N'Trần Văn Tính', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2019-05-07' AS Date), 80, 2, N'vanhoc8.jpg', 20, 8, 135000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (49, N'Hãy Chăm Sóc Mẹ', N'Vũ Thị Yến', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2018-02-04' AS Date), 90, 2, N'vanhoc9.jpg', 20, 9, 210000)
INSERT [dbo].[Book] ([id], [title], [author], [description], [day], [page], [cid], [image], [quantity], [sold], [price]) VALUES (50, N'Hai Số Phận', N'Vũ Thị Lan', N'Đây là cuốn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.Đây là cuồn sách rất hay. Sách mang lại những kiến thức thú vị và bổ ích cho người đọc, với nội dung có ý nghĩa sâu sắc cho cuộc sống.', CAST(N'2017-07-02' AS Date), 150, 2, N'vanhoc10.jpg', 20, 5, 200000)
SET IDENTITY_INSERT [dbo].[Book] OFF
GO
SET IDENTITY_INSERT [dbo].[Category] ON 

INSERT [dbo].[Category] ([id], [name]) VALUES (1, N'Kinh Doanh')
INSERT [dbo].[Category] ([id], [name]) VALUES (2, N'Văn Học')
INSERT [dbo].[Category] ([id], [name]) VALUES (3, N'Sách Giáo Khoa')
INSERT [dbo].[Category] ([id], [name]) VALUES (4, N'Thiếu Nhi')
INSERT [dbo].[Category] ([id], [name]) VALUES (5, N'Ngoại Ngữ')
SET IDENTITY_INSERT [dbo].[Category] OFF
GO
SET IDENTITY_INSERT [dbo].[Oder] ON 

INSERT [dbo].[Oder] ([id], [uid], [quantity], [date], [totalmoney], [status]) VALUES (1101, 1, 3, N'2023-05-29                                        ', 520000, 1)
INSERT [dbo].[Oder] ([id], [uid], [quantity], [date], [totalmoney], [status]) VALUES (1110, 1, 1, N'2023-05-29                                        ', 150000, 0)
INSERT [dbo].[Oder] ([id], [uid], [quantity], [date], [totalmoney], [status]) VALUES (1120, 1, 1, N'2023-05-29                                        ', 120000, -1)
INSERT [dbo].[Oder] ([id], [uid], [quantity], [date], [totalmoney], [status]) VALUES (1122, 1, 4, N'2023-05-29                                        ', 690000, 0)
SET IDENTITY_INSERT [dbo].[Oder] OFF
GO
INSERT [dbo].[OrderLine] ([oid], [bid], [quantity], [totalMoney]) VALUES (1101, 3, 2, 380000)
INSERT [dbo].[OrderLine] ([oid], [bid], [quantity], [totalMoney]) VALUES (1101, 6, 1, 140000)
INSERT [dbo].[OrderLine] ([oid], [bid], [quantity], [totalMoney]) VALUES (1110, 4, 1, 150000)
INSERT [dbo].[OrderLine] ([oid], [bid], [quantity], [totalMoney]) VALUES (1120, 2, 1, 120000)
INSERT [dbo].[OrderLine] ([oid], [bid], [quantity], [totalMoney]) VALUES (1122, 2, 1, 120000)
INSERT [dbo].[OrderLine] ([oid], [bid], [quantity], [totalMoney]) VALUES (1122, 3, 3, 570000)
GO
SET IDENTITY_INSERT [dbo].[Review] ON 

INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (1, 1, 1, N'chán', 2, CAST(N'2023-04-15' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (2, 2, 2, N'Sách rất hay', 5, CAST(N'2023-08-03' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (3, 3, 3, N'Sách này không hay', 1, CAST(N'2023-04-15' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (4, 4, 4, N'Sách không hay lắm', 1, CAST(N'2023-04-16' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (5, 5, 5, N'Cũng được', 3, CAST(N'2023-04-15' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (6, 1, 3, N'Sách rất hay, mình rất thích', 4, CAST(N'2023-04-15' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (7, 2, 4, N'sách rất hay, tôi rất thích sách này', 5, CAST(N'2023-02-02' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (8, 3, 2, N'sách không hay, tối sẽ không mua sách này nữa', 3, CAST(N'2023-04-16' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (9, 4, 1, N'Tôi đã đọc và thấy sách rất hay, cảm ơn nhiều', 5, CAST(N'2023-04-17' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (10, 5, 3, N'Sách chán quá, mua phí cả tiền, đọc chả hiểu gì', 1, CAST(N'2023-04-17' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (11, 1, 2, N'Biết thế không mua sách này', 2, CAST(N'2023-04-17' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (12, 2, 2, N'Sách vừa đắt vừa không hay gì cả, mọi người cân nhắc kĩ trước khi mua', 1, CAST(N'2023-04-17' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (13, 3, 3, N'sách nhàm chán quá', 1, CAST(N'2023-04-17' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (14, 4, 4, N'sách đắt tiền quá', 2, CAST(N'2023-04-17' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (15, 5, 2, N'Sách hay quá, mình đã đọc và thấy rất ý nghĩa', 5, CAST(N'2023-04-17' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (16, 4, 4, N'hay quá', 5, CAST(N'2023-04-17' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (17, 3, 5, N'Chán !', 1, CAST(N'2023-04-17' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (18, 1, 4, N'hay quá', 4, CAST(N'2023-04-17' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (19, 2, 3, N'đã đọc và thấy rất hay ', 5, CAST(N'2023-04-17' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (20, 3, 2, N'hay qua', 3, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (21, 4, 3, N'chán', 1, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (22, 5, 1, N'sách đọc rất hay', 4, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (23, 1, 1, N'Sách hay tuyệt vời', 5, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (24, 2, 2, N'chán', 1, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (25, 3, 3, N'Sách không hay lắm', 2, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (26, 4, 4, N'chán', 1, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (27, 5, 5, N'chán quá', 2, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (28, 5, 3, N'Sách không hay', 1, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (29, 1, 5, N'Sách rất bổ ích', 5, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (30, 2, 1, N'sách không hay', 2, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (31, 3, 2, N'Nhàm chán', 1, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (32, 2, 1, N'phí tiền', 1, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (33, 4, 3, N'Sách hay quá', 5, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (34, 5, 4, N'Đã đọc thấy rất hay', 5, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (35, 2, 5, N'Đã mua và thấy rất hay', 5, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (36, 1, 3, N'không hay lắm', 2, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (37, 2, 5, N'chán quá, sách không hay', 2, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (38, 1, 3, N'Sách hay lắm', 5, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (39, 3, 2, N'hay quá', 4, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (40, 4, 5, N'Sách đọc không hay, nhàm chán', 2, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (41, 2, 4, N'hay quá, sách đọc rất hay', 5, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (42, 3, 2, N'hay', 4, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (43, 4, 5, N'chán', 2, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (44, 5, 3, N'hay quá', 4, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (45, 3, 2, N'chán quá', 2, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (46, 4, 1, N'hay quá', 5, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (47, 5, 4, N'Đã đọc và thấy sách rất hay', 5, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (48, 3, 1, N'hay lắm mọi người ơi', 5, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (49, 2, 2, N'hay quá', 5, CAST(N'2023-04-22' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (50, 1, 3, N'dsfdf akhjsdj sdsfdk fdsfdsfd', 4, CAST(N'2023-04-28' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (51, 6, 4, N'sách rất hay và bổ ích', 5, CAST(N'2023-04-30' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (52, 5, 5, N'Sách rất hay và bổ ích', 5, CAST(N'2023-05-05' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (53, 4, 2, N'hay bình thường', 3, CAST(N'2023-05-12' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (54, 7, 3, N'sach hay', 4, CAST(N'2023-05-15' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (55, 3, 4, N'chán', 1, CAST(N'2023-05-15' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (56, 4, 5, N'hay', 5, CAST(N'2023-05-16' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (57, 2, 2, N'hay', 4, CAST(N'2023-05-17' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (58, 5, 1, N'hay quá', 5, CAST(N'2023-05-21' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (59, 6, 2, N'sách rất hay và ý nghĩa', 5, CAST(N'2023-05-21' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (62, 3, 3, N'sách hay', 4, CAST(N'2023-05-21' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (63, 2, 4, N'sách hay', 4, CAST(N'2023-05-21' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (72, 4, 1, N'èdfdfdsf', 3, CAST(N'2023-05-24' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (74, 5, 3, N'sfsfs', 2, CAST(N'2023-05-24' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (75, 3, 2, N'sfdsfdsf', 4, CAST(N'2023-05-24' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (76, 2, 1, N'dfdfdf', 3, CAST(N'2023-05-25' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (77, 1, 4, N'xbfbfhfghgfhg', 3, CAST(N'2023-05-26' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (78, 1, 3, N'chán', 1, CAST(N'2023-05-26' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (80, 1, 3, N'sách hay', 5, CAST(N'2023-05-27' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (81, 1, 6, N'chán', 1, CAST(N'2023-05-27' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (82, 1, 3, N'sách rất hay', 5, CAST(N'2023-05-27' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (83, 1, 2, N'chán', 1, CAST(N'2023-05-27' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (84, 1, 3, N'bình thường', 3, CAST(N'2023-05-27' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (85, 1, 3, N'sach hay binh thuong', 4, CAST(N'2023-05-27' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (86, 1, 3, N'zfzfdsfdsfd', 2, CAST(N'2023-05-27' AS Date))
INSERT [dbo].[Review] ([id], [uid], [bid], [content], [rating], [day]) VALUES (87, 1, 3, N'szfdggfgf', 4, CAST(N'2023-05-27' AS Date))
SET IDENTITY_INSERT [dbo].[Review] OFF
GO
SET IDENTITY_INSERT [dbo].[User] ON 

INSERT [dbo].[User] ([id], [username], [password], [email], [duty]) VALUES (1, N'guest', N'888', N'admin@gmail.com                                                                                     ', 2)
INSERT [dbo].[User] ([id], [username], [password], [email], [duty]) VALUES (2, N'trantinh', N'888', N'tinh@gmail.com                                                                                      ', 2)
INSERT [dbo].[User] ([id], [username], [password], [email], [duty]) VALUES (3, N'lebao', N'888', N'binh@gmail.com                                                                                      ', 2)
INSERT [dbo].[User] ([id], [username], [password], [email], [duty]) VALUES (4, N'muathu', N'888', N'trang2406@gmail.com                                                                                 ', 2)
INSERT [dbo].[User] ([id], [username], [password], [email], [duty]) VALUES (5, N'alone', N'888', N'alone@gmail.com                                                                                     ', 2)
INSERT [dbo].[User] ([id], [username], [password], [email], [duty]) VALUES (6, N'hahaha', N'888', N'haha@gmail.com                                                                                      ', 2)
INSERT [dbo].[User] ([id], [username], [password], [email], [duty]) VALUES (7, N'tinh456', N'888', N'admin1@gmail.com                                                                                    ', 2)
INSERT [dbo].[User] ([id], [username], [password], [email], [duty]) VALUES (8, N'alone123', N'888', N'admin2@gmail.com                                                                                    ', 2)
INSERT [dbo].[User] ([id], [username], [password], [email], [duty]) VALUES (9, N'zozo', N'888', N'admin3@gmail.com                                                                                    ', 2)
INSERT [dbo].[User] ([id], [username], [password], [email], [duty]) VALUES (10, N'admin', N'888', N'admin0308@gmail.com                                                                                 ', 1)
INSERT [dbo].[User] ([id], [username], [password], [email], [duty]) VALUES (11, N'nam123', N'123', N'luyen@gmail.com                                                                                     ', 2)
INSERT [dbo].[User] ([id], [username], [password], [email], [duty]) VALUES (12, N'mono', N'888', N'trantinh.ptit@gmail.com                                                                             ', 2)
SET IDENTITY_INSERT [dbo].[User] OFF
GO
ALTER TABLE [dbo].[Book]  WITH CHECK ADD  CONSTRAINT [FK__Book__cid__2D27B809] FOREIGN KEY([cid])
REFERENCES [dbo].[Category] ([id])
GO
ALTER TABLE [dbo].[Book] CHECK CONSTRAINT [FK__Book__cid__2D27B809]
GO
ALTER TABLE [dbo].[Oder]  WITH CHECK ADD  CONSTRAINT [FK__Oder__uid__0E6E26BF] FOREIGN KEY([uid])
REFERENCES [dbo].[User] ([id])
GO
ALTER TABLE [dbo].[Oder] CHECK CONSTRAINT [FK__Oder__uid__0E6E26BF]
GO
ALTER TABLE [dbo].[OrderLine]  WITH CHECK ADD FOREIGN KEY([bid])
REFERENCES [dbo].[Book] ([id])
GO
ALTER TABLE [dbo].[OrderLine]  WITH CHECK ADD FOREIGN KEY([oid])
REFERENCES [dbo].[Oder] ([id])
GO
ALTER TABLE [dbo].[Review]  WITH CHECK ADD FOREIGN KEY([bid])
REFERENCES [dbo].[Book] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Review]  WITH CHECK ADD FOREIGN KEY([uid])
REFERENCES [dbo].[User] ([id])
GO
USE [master]
GO
ALTER DATABASE [PTHTTTQL] SET  READ_WRITE 
GO
