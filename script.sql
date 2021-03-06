USE [Workforce]
GO
/****** Object:  Table [dbo].[ProgrammingLanguage]    Script Date: 07/20/2016 17:10:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ProgrammingLanguage](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Language] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[ProgrammingLanguage] ON
INSERT [dbo].[ProgrammingLanguage] ([ID], [Language]) VALUES (1, N'Java')
INSERT [dbo].[ProgrammingLanguage] ([ID], [Language]) VALUES (2, N'C#')
INSERT [dbo].[ProgrammingLanguage] ([ID], [Language]) VALUES (3, N'Ruby')
INSERT [dbo].[ProgrammingLanguage] ([ID], [Language]) VALUES (4, N'Python')
INSERT [dbo].[ProgrammingLanguage] ([ID], [Language]) VALUES (5, N'PHP')
SET IDENTITY_INSERT [dbo].[ProgrammingLanguage] OFF
/****** Object:  Table [dbo].[AccountType]    Script Date: 07/20/2016 17:10:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[AccountType](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Type] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[AccountType] ON
INSERT [dbo].[AccountType] ([ID], [Type]) VALUES (1, N'Admin')
INSERT [dbo].[AccountType] ([ID], [Type]) VALUES (2, N'Participant')
INSERT [dbo].[AccountType] ([ID], [Type]) VALUES (3, N'Company')
SET IDENTITY_INSERT [dbo].[AccountType] OFF
/****** Object:  Table [dbo].[Company]    Script Date: 07/20/2016 17:10:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Company](
	[ID] [int] NOT NULL,
	[Description] [varchar](255) NULL,
	[Email] [varchar](255) NULL,
	[ImageURL] [varchar](255) NULL,
	[Location] [varchar](255) NULL,
	[Name] [varchar](255) NULL,
	[Website] [varchar](255) NULL,
	[ProgrammingLanguageID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Company] ([ID], [Description], [Email], [ImageURL], [Location], [Name], [Website], [ProgrammingLanguageID]) VALUES (2, N'Sample Description', N'willistowerswatson_workforce@gmail.com', N'http://cicpac.com/wp-content/uploads/2015/07/WSBF7qtg.jpg', N'10th, 16th, and 24th Floors Bonifacio One Technology Tower, 3030 31st Street, Taguig, 1634 Metro Manila', N'Willis Towers Watson', N'https://www.willistowerswatson.com/', 1)
INSERT [dbo].[Company] ([ID], [Description], [Email], [ImageURL], [Location], [Name], [Website], [ProgrammingLanguageID]) VALUES (3, NULL, N'accenture_workforce@gmail.com', N'http://www.brandsoftheworld.com/sites/default/files/styles/logo-thumbnail/public/0015/2593/brand.gif?itok=HskBZ97Y', NULL, N'Accenture', NULL, 1)
INSERT [dbo].[Company] ([ID], [Description], [Email], [ImageURL], [Location], [Name], [Website], [ProgrammingLanguageID]) VALUES (4, NULL, N'hewlettpackard_workforce@gmail.com', N'http://www.brandsoftheworld.com/sites/default/files/styles/logo-thumbnail/public/0024/8548/brand.gif?itok=GBxhXRdq', NULL, N'Hewlett-Packard', NULL, 3)
INSERT [dbo].[Company] ([ID], [Description], [Email], [ImageURL], [Location], [Name], [Website], [ProgrammingLanguageID]) VALUES (5, NULL, N'jpmorganchase_workforce@gmail.com', N'https://stocksaints.com/sites/default/files/styles/article_image_full_node/public/field/image/JPMorgan%20Chase%20%26%20Co._1.jpg?itok=K2y5-1jw', NULL, N'JPMorgan Chase & Co.', N'https://www.jpmorganchase.com/', NULL)
INSERT [dbo].[Company] ([ID], [Description], [Email], [ImageURL], [Location], [Name], [Website], [ProgrammingLanguageID]) VALUES (6, NULL, N'wellsfargo_workforce@gmail.com', N'https://www01.wellsfargomedia.com/assets/images/global/wf-logo.gif', NULL, N'Wells Fargo', N'https://www.wellsfargo.com', NULL)
INSERT [dbo].[Company] ([ID], [Description], [Email], [ImageURL], [Location], [Name], [Website], [ProgrammingLanguageID]) VALUES (7, NULL, N'toyota_workforce@gmail.com', N'http://www.brandsoftheworld.com/sites/default/files/styles/logo-thumbnail/public/0000/3428/brand.gif?itok=Y52aPAAv', NULL, N'Toyota', N'http://www.toyota.com.ph/', NULL)
/****** Object:  Table [dbo].[Participant]    Script Date: 07/20/2016 17:10:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Participant](
	[ID] [int] NOT NULL,
	[Firstname] [varchar](255) NULL,
	[ImageURL] [varchar](255) NULL,
	[Lastname] [varchar](255) NULL,
	[Location] [varchar](255) NULL,
	[ProgrammingLanguageID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Participant] ([ID], [Firstname], [ImageURL], [Lastname], [Location], [ProgrammingLanguageID]) VALUES (1, N'Jm', N'https://lh3.googleusercontent.com/-N_NN1Rj6BWE/VGtZJNyfn0I/AAAAAAAAAts/w2VBCjx7SKApvmc25RLOFqqQuBomuKjCgCKgB/w139-h140-p/10620093_928903470459549_958004845142057258_o_1409843705211_l.jpg', N'Santos', N'799 Nueve de Febrero, Mandaluyong, Manila', 1)
INSERT [dbo].[Participant] ([ID], [Firstname], [ImageURL], [Lastname], [Location], [ProgrammingLanguageID]) VALUES (8, N'Krister', NULL, N'Chua', N'Manila City', 1)
INSERT [dbo].[Participant] ([ID], [Firstname], [ImageURL], [Lastname], [Location], [ProgrammingLanguageID]) VALUES (9, N'Mark', NULL, N'Ling', N'Manila City', 5)
INSERT [dbo].[Participant] ([ID], [Firstname], [ImageURL], [Lastname], [Location], [ProgrammingLanguageID]) VALUES (10, N'Gianne', NULL, N'Confesor', N'Quezon City', 1)
INSERT [dbo].[Participant] ([ID], [Firstname], [ImageURL], [Lastname], [Location], [ProgrammingLanguageID]) VALUES (11, N'Kyla', N'https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAAJbAAAAJGFkMmYwOTNjLTE2NzEtNDYwMy04MjNjLTk1YTNhOGNhNTM5Yw.jpg', N'Lim', N'Manila City', 2)
INSERT [dbo].[Participant] ([ID], [Firstname], [ImageURL], [Lastname], [Location], [ProgrammingLanguageID]) VALUES (12, N'Bryan', NULL, N'Dizon', N'Manila City', 3)
INSERT [dbo].[Participant] ([ID], [Firstname], [ImageURL], [Lastname], [Location], [ProgrammingLanguageID]) VALUES (21, N'Yara', NULL, N'Palacay', N'Parañaque City', 1)
/****** Object:  Table [dbo].[Users]    Script Date: 07/20/2016 17:10:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Users](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[AccessToken] [varchar](255) NULL,
	[Email] [varchar](255) NULL,
	[HasAccessToken] [bit] NULL,
	[HasTemporaryPassword] [bit] NULL,
	[Password] [varchar](255) NULL,
	[Timestamp] [varchar](255) NULL,
	[AccountTypeID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Users] ON
INSERT [dbo].[Users] ([ID], [AccessToken], [Email], [HasAccessToken], [HasTemporaryPassword], [Password], [Timestamp], [AccountTypeID]) VALUES (1, N'29fad0f7-9b04-45a5-8acf-c95e1b340c56', N'jmsantos@yahoo.com', 1, 0, N'QWWl2+aaQg91VS6fQLrJuw==', N'2016-07-09T12:04:32.116', 2)
INSERT [dbo].[Users] ([ID], [AccessToken], [Email], [HasAccessToken], [HasTemporaryPassword], [Password], [Timestamp], [AccountTypeID]) VALUES (2, NULL, N'willistowerswatson_workforce@gmail.com', 1, 0, N'X/EtVY2g0Gk6RzvXwAA4Wg==', N'2016-07-09T12:04:33.298', 3)
INSERT [dbo].[Users] ([ID], [AccessToken], [Email], [HasAccessToken], [HasTemporaryPassword], [Password], [Timestamp], [AccountTypeID]) VALUES (3, NULL, N'accenture_workforce@gmail.com', 1, 1, N'oQy+wurTaXpOGGxu2QNOAO9fW0wb6YVnsEYgogo9w/w=', N'2016-07-09T12:04:33.309', 3)
INSERT [dbo].[Users] ([ID], [AccessToken], [Email], [HasAccessToken], [HasTemporaryPassword], [Password], [Timestamp], [AccountTypeID]) VALUES (4, NULL, N'hewlettpackard_workforce@gmail.com', 1, 1, N'oQy+wurTaXpOGGxu2QNOAO9fW0wb6YVnsEYgogo9w/w=', N'2016-07-09T12:04:33.313', 3)
INSERT [dbo].[Users] ([ID], [AccessToken], [Email], [HasAccessToken], [HasTemporaryPassword], [Password], [Timestamp], [AccountTypeID]) VALUES (5, NULL, N'jpmorganchase_workforce@gmail.com', 0, 1, N'oQy+wurTaXpOGGxu2QNOAO9fW0wb6YVnsEYgogo9w/w=', N'2016-07-09T12:04:33.319', 3)
INSERT [dbo].[Users] ([ID], [AccessToken], [Email], [HasAccessToken], [HasTemporaryPassword], [Password], [Timestamp], [AccountTypeID]) VALUES (6, NULL, N'wellsfargo_workforce@gmail.com', 0, 1, N'oQy+wurTaXpOGGxu2QNOAO9fW0wb6YVnsEYgogo9w/w=', N'2016-07-09T12:04:33.322', 3)
INSERT [dbo].[Users] ([ID], [AccessToken], [Email], [HasAccessToken], [HasTemporaryPassword], [Password], [Timestamp], [AccountTypeID]) VALUES (7, NULL, N'toyota_workforce@gmail.com', 0, 1, N'oQy+wurTaXpOGGxu2QNOAO9fW0wb6YVnsEYgogo9w/w=', N'2016-07-09T12:04:33.325', 3)
INSERT [dbo].[Users] ([ID], [AccessToken], [Email], [HasAccessToken], [HasTemporaryPassword], [Password], [Timestamp], [AccountTypeID]) VALUES (8, NULL, N'kristerchua@gmail.com', 0, 0, N'QWWl2+aaQg91VS6fQLrJuw==', N'2016-07-12T15:31:47.552', 2)
INSERT [dbo].[Users] ([ID], [AccessToken], [Email], [HasAccessToken], [HasTemporaryPassword], [Password], [Timestamp], [AccountTypeID]) VALUES (9, NULL, N'markling@gmail.com', 0, 0, N'QWWl2+aaQg91VS6fQLrJuw==', N'2016-07-12T15:32:36.796', 2)
INSERT [dbo].[Users] ([ID], [AccessToken], [Email], [HasAccessToken], [HasTemporaryPassword], [Password], [Timestamp], [AccountTypeID]) VALUES (10, N'3218f83b-e6f8-4957-b230-aca71d1b10e0', N'gianneconfesor@gmail.com', 0, 0, N'QWWl2+aaQg91VS6fQLrJuw==', N'2016-07-12T15:33:27.064', 2)
INSERT [dbo].[Users] ([ID], [AccessToken], [Email], [HasAccessToken], [HasTemporaryPassword], [Password], [Timestamp], [AccountTypeID]) VALUES (11, N'1ba76002-e34c-4d4b-858c-3d74ed8ce24e', N'kylalim@gmail.com', 0, 0, N'QWWl2+aaQg91VS6fQLrJuw==', N'2016-07-12T15:34:00.380', 2)
INSERT [dbo].[Users] ([ID], [AccessToken], [Email], [HasAccessToken], [HasTemporaryPassword], [Password], [Timestamp], [AccountTypeID]) VALUES (12, N'28d6ded1-b8b4-44c7-ae95-03581aa54a39', N'bryandizon@gmail.com', 0, 0, N'QWWl2+aaQg91VS6fQLrJuw==', N'2016-07-14T13:37:18.425', 2)
INSERT [dbo].[Users] ([ID], [AccessToken], [Email], [HasAccessToken], [HasTemporaryPassword], [Password], [Timestamp], [AccountTypeID]) VALUES (19, NULL, N'asdasda@yahoo.com', 1, 0, N'SiUu7Ji7qrJjoiowD2UiAA==', N'2016-07-20T16:04:04.667', 2)
INSERT [dbo].[Users] ([ID], [AccessToken], [Email], [HasAccessToken], [HasTemporaryPassword], [Password], [Timestamp], [AccountTypeID]) VALUES (20, NULL, N'hahaha@yahoo.com', 1, 0, N'OOVGQZl2d74BOjy8zgJvTg==', N'2016-07-20T16:28:58.818', 2)
INSERT [dbo].[Users] ([ID], [AccessToken], [Email], [HasAccessToken], [HasTemporaryPassword], [Password], [Timestamp], [AccountTypeID]) VALUES (21, NULL, N'yarapalacay@gmail.com', 1, 0, N'y1y/u7MSdrcDhejJqtn94g==', N'2016-07-20T16:46:17.920', 2)
SET IDENTITY_INSERT [dbo].[Users] OFF
/****** Object:  Table [dbo].[Workforce]    Script Date: 07/20/2016 17:10:10 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Workforce](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Timestamp] [varchar](255) NULL,
	[CompanyID] [int] NULL,
	[ParticipantID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Workforce] ON
INSERT [dbo].[Workforce] ([ID], [Timestamp], [CompanyID], [ParticipantID]) VALUES (1, N'2016-07-20T14:40:45.529', 2, 8)
INSERT [dbo].[Workforce] ([ID], [Timestamp], [CompanyID], [ParticipantID]) VALUES (3, N'2016-07-20T15:07:54.482', 2, 1)
INSERT [dbo].[Workforce] ([ID], [Timestamp], [CompanyID], [ParticipantID]) VALUES (4, N'2016-07-20T15:14:37.761', 2, 10)
SET IDENTITY_INSERT [dbo].[Workforce] OFF
/****** Object:  Table [dbo].[Notification]    Script Date: 07/20/2016 17:10:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Notification](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[IsRead] [bit] NULL,
	[Message] [varchar](255) NULL,
	[Timestamp] [varchar](255) NULL,
	[UserID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  ForeignKey [FK_r1vx4rn058fvtwhrqqg1q8ftx]    Script Date: 07/20/2016 17:10:09 ******/
ALTER TABLE [dbo].[Company]  WITH CHECK ADD  CONSTRAINT [FK_r1vx4rn058fvtwhrqqg1q8ftx] FOREIGN KEY([ProgrammingLanguageID])
REFERENCES [dbo].[ProgrammingLanguage] ([ID])
GO
ALTER TABLE [dbo].[Company] CHECK CONSTRAINT [FK_r1vx4rn058fvtwhrqqg1q8ftx]
GO
/****** Object:  ForeignKey [FK_j4elt2frphin2twtpnf34lu]    Script Date: 07/20/2016 17:10:09 ******/
ALTER TABLE [dbo].[Notification]  WITH CHECK ADD  CONSTRAINT [FK_j4elt2frphin2twtpnf34lu] FOREIGN KEY([UserID])
REFERENCES [dbo].[Users] ([ID])
GO
ALTER TABLE [dbo].[Notification] CHECK CONSTRAINT [FK_j4elt2frphin2twtpnf34lu]
GO
/****** Object:  ForeignKey [FK_icjp0ttrnb7k9js04t6ngb2ga]    Script Date: 07/20/2016 17:10:10 ******/
ALTER TABLE [dbo].[Participant]  WITH CHECK ADD  CONSTRAINT [FK_icjp0ttrnb7k9js04t6ngb2ga] FOREIGN KEY([ProgrammingLanguageID])
REFERENCES [dbo].[ProgrammingLanguage] ([ID])
GO
ALTER TABLE [dbo].[Participant] CHECK CONSTRAINT [FK_icjp0ttrnb7k9js04t6ngb2ga]
GO
/****** Object:  ForeignKey [FK_bc65dlpo7m3f6ndegmyak6xsg]    Script Date: 07/20/2016 17:10:10 ******/
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [FK_bc65dlpo7m3f6ndegmyak6xsg] FOREIGN KEY([AccountTypeID])
REFERENCES [dbo].[AccountType] ([ID])
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [FK_bc65dlpo7m3f6ndegmyak6xsg]
GO
/****** Object:  ForeignKey [FK_8w080v6ivtkk2coc3p4huk9jy]    Script Date: 07/20/2016 17:10:10 ******/
ALTER TABLE [dbo].[Workforce]  WITH CHECK ADD  CONSTRAINT [FK_8w080v6ivtkk2coc3p4huk9jy] FOREIGN KEY([CompanyID])
REFERENCES [dbo].[Company] ([ID])
GO
ALTER TABLE [dbo].[Workforce] CHECK CONSTRAINT [FK_8w080v6ivtkk2coc3p4huk9jy]
GO
/****** Object:  ForeignKey [FK_942ekt2cxf3hk7w0xpk2y7jrt]    Script Date: 07/20/2016 17:10:10 ******/
ALTER TABLE [dbo].[Workforce]  WITH CHECK ADD  CONSTRAINT [FK_942ekt2cxf3hk7w0xpk2y7jrt] FOREIGN KEY([ParticipantID])
REFERENCES [dbo].[Participant] ([ID])
GO
ALTER TABLE [dbo].[Workforce] CHECK CONSTRAINT [FK_942ekt2cxf3hk7w0xpk2y7jrt]
GO
