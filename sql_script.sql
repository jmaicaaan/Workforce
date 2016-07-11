USE [Workforce]
GO
/****** Object:  Table [dbo].[ProgrammingLanguage]    Script Date: 07/12/2016 01:55:23 ******/
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
/****** Object:  Table [dbo].[AccountType]    Script Date: 07/12/2016 01:55:23 ******/
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
/****** Object:  Table [dbo].[Users]    Script Date: 07/12/2016 01:55:23 ******/
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
INSERT [dbo].[Users] ([ID], [AccessToken], [Email], [HasAccessToken], [HasTemporaryPassword], [Password], [Timestamp], [AccountTypeID]) VALUES (1, N'23191dbc-b902-4daf-ab0f-0f44d7c2a3b2', N'jmsantos@yahoo.com', 0, 0, N'QWWl2+aaQg91VS6fQLrJuw==', N'2016-07-09T12:04:32.116', 2)
INSERT [dbo].[Users] ([ID], [AccessToken], [Email], [HasAccessToken], [HasTemporaryPassword], [Password], [Timestamp], [AccountTypeID]) VALUES (2, N'82070b70-3b42-4e38-a71f-7698afe71c94', N'willistowerswatson_workforce@gmail.com', 0, 1, N'oQy+wurTaXpOGGxu2QNOAO9fW0wb6YVnsEYgogo9w/w=', N'2016-07-09T12:04:33.298', 3)
INSERT [dbo].[Users] ([ID], [AccessToken], [Email], [HasAccessToken], [HasTemporaryPassword], [Password], [Timestamp], [AccountTypeID]) VALUES (3, N'dbdbd2a3-5a3d-4cf3-9e76-902ac76beba2', N'accenture_workforce@gmail.com', 0, 1, N'oQy+wurTaXpOGGxu2QNOAO9fW0wb6YVnsEYgogo9w/w=', N'2016-07-09T12:04:33.309', 3)
INSERT [dbo].[Users] ([ID], [AccessToken], [Email], [HasAccessToken], [HasTemporaryPassword], [Password], [Timestamp], [AccountTypeID]) VALUES (4, NULL, N'hewlettpackard_workforce@gmail.com', 0, 1, N'oQy+wurTaXpOGGxu2QNOAO9fW0wb6YVnsEYgogo9w/w=', N'2016-07-09T12:04:33.313', 3)
INSERT [dbo].[Users] ([ID], [AccessToken], [Email], [HasAccessToken], [HasTemporaryPassword], [Password], [Timestamp], [AccountTypeID]) VALUES (5, NULL, N'jpmorganchase_workforce@gmail.com', 0, 1, N'oQy+wurTaXpOGGxu2QNOAO9fW0wb6YVnsEYgogo9w/w=', N'2016-07-09T12:04:33.319', 3)
INSERT [dbo].[Users] ([ID], [AccessToken], [Email], [HasAccessToken], [HasTemporaryPassword], [Password], [Timestamp], [AccountTypeID]) VALUES (6, NULL, N'wellsfargo_workforce@gmail.com', 0, 1, N'oQy+wurTaXpOGGxu2QNOAO9fW0wb6YVnsEYgogo9w/w=', N'2016-07-09T12:04:33.322', 3)
INSERT [dbo].[Users] ([ID], [AccessToken], [Email], [HasAccessToken], [HasTemporaryPassword], [Password], [Timestamp], [AccountTypeID]) VALUES (7, NULL, N'toyota_workforce@gmail.com', 0, 1, N'oQy+wurTaXpOGGxu2QNOAO9fW0wb6YVnsEYgogo9w/w=', N'2016-07-09T12:04:33.325', 3)
SET IDENTITY_INSERT [dbo].[Users] OFF
/****** Object:  Table [dbo].[Participant]    Script Date: 07/12/2016 01:55:23 ******/
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
	[IsAvailable] [bit] NULL,
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
INSERT [dbo].[Participant] ([ID], [Firstname], [ImageURL], [IsAvailable], [Lastname], [Location], [ProgrammingLanguageID]) VALUES (1, N'Jm', N'https://lh3.googleusercontent.com/-N_NN1Rj6BWE/VGtZJNyfn0I/AAAAAAAAAts/w2VBCjx7SKApvmc25RLOFqqQuBomuKjCgCKgB/w139-h140-p/10620093_928903470459549_958004845142057258_o_1409843705211_l.jpg', 0, N'Santos', NULL, 1)
/****** Object:  Table [dbo].[Company]    Script Date: 07/12/2016 01:55:23 ******/
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
INSERT [dbo].[Company] ([ID], [Description], [Email], [ImageURL], [Location], [Name], [Website], [ProgrammingLanguageID]) VALUES (2, NULL, N'willistowerswatson_workforce@gmail.com', N'http://cicpac.com/wp-content/uploads/2015/07/WSBF7qtg.jpg', NULL, N'Willis Towers Watson', N'https://www.willistowerswatson.com/en', 1)
INSERT [dbo].[Company] ([ID], [Description], [Email], [ImageURL], [Location], [Name], [Website], [ProgrammingLanguageID]) VALUES (3, NULL, N'accenture_workforce@gmail.com', N'http://www.brandsoftheworld.com/sites/default/files/styles/logo-thumbnail/public/0015/2593/brand.gif?itok=HskBZ97Y', NULL, N'Accenture', N'https://www.accenture.com/ph-en', NULL)
INSERT [dbo].[Company] ([ID], [Description], [Email], [ImageURL], [Location], [Name], [Website], [ProgrammingLanguageID]) VALUES (4, NULL, N'hewlettpackard_workforce@gmail.com', N'http://www.brandsoftheworld.com/sites/default/files/styles/logo-thumbnail/public/0024/8548/brand.gif?itok=GBxhXRdq', NULL, N'Hewlett-Packard', N'http://www8.hp.com/ph/en/home.html', NULL)
INSERT [dbo].[Company] ([ID], [Description], [Email], [ImageURL], [Location], [Name], [Website], [ProgrammingLanguageID]) VALUES (5, NULL, N'jpmorganchase_workforce@gmail.com', N'https://stocksaints.com/sites/default/files/styles/article_image_full_node/public/field/image/JPMorgan%20Chase%20%26%20Co._1.jpg?itok=K2y5-1jw', NULL, N'JPMorgan Chase & Co.', N'https://www.jpmorganchase.com/', NULL)
INSERT [dbo].[Company] ([ID], [Description], [Email], [ImageURL], [Location], [Name], [Website], [ProgrammingLanguageID]) VALUES (6, NULL, N'wellsfargo_workforce@gmail.com', N'https://www01.wellsfargomedia.com/assets/images/global/wf-logo.gif', NULL, N'Wells Fargo', N'https://www.wellsfargo.com', NULL)
INSERT [dbo].[Company] ([ID], [Description], [Email], [ImageURL], [Location], [Name], [Website], [ProgrammingLanguageID]) VALUES (7, NULL, N'toyota_workforce@gmail.com', N'http://www.brandsoftheworld.com/sites/default/files/styles/logo-thumbnail/public/0000/3428/brand.gif?itok=Y52aPAAv', NULL, N'Toyota', N'http://www.toyota.com.ph/', NULL)
/****** Object:  ForeignKey [FK_r1vx4rn058fvtwhrqqg1q8ftx]    Script Date: 07/12/2016 01:55:23 ******/
ALTER TABLE [dbo].[Company]  WITH CHECK ADD  CONSTRAINT [FK_r1vx4rn058fvtwhrqqg1q8ftx] FOREIGN KEY([ProgrammingLanguageID])
REFERENCES [dbo].[ProgrammingLanguage] ([ID])
GO
ALTER TABLE [dbo].[Company] CHECK CONSTRAINT [FK_r1vx4rn058fvtwhrqqg1q8ftx]
GO
/****** Object:  ForeignKey [FK_icjp0ttrnb7k9js04t6ngb2ga]    Script Date: 07/12/2016 01:55:23 ******/
ALTER TABLE [dbo].[Participant]  WITH CHECK ADD  CONSTRAINT [FK_icjp0ttrnb7k9js04t6ngb2ga] FOREIGN KEY([ProgrammingLanguageID])
REFERENCES [dbo].[ProgrammingLanguage] ([ID])
GO
ALTER TABLE [dbo].[Participant] CHECK CONSTRAINT [FK_icjp0ttrnb7k9js04t6ngb2ga]
GO
/****** Object:  ForeignKey [FK_bc65dlpo7m3f6ndegmyak6xsg]    Script Date: 07/12/2016 01:55:23 ******/
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [FK_bc65dlpo7m3f6ndegmyak6xsg] FOREIGN KEY([AccountTypeID])
REFERENCES [dbo].[AccountType] ([ID])
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [FK_bc65dlpo7m3f6ndegmyak6xsg]
GO
