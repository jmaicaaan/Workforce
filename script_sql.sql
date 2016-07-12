USE [Workforce]
GO
/****** Object:  Table [dbo].[ProgrammingLanguage]    Script Date: 07/12/2016 16:20:31 ******/
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
/****** Object:  Table [dbo].[AccountType]    Script Date: 07/12/2016 16:20:30 ******/
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
/****** Object:  Table [dbo].[Users]    Script Date: 07/12/2016 16:20:31 ******/
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
/****** Object:  Table [dbo].[Participant]    Script Date: 07/12/2016 16:20:30 ******/
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
/****** Object:  Table [dbo].[Company]    Script Date: 07/12/2016 16:20:30 ******/
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
/****** Object:  ForeignKey [FK_r1vx4rn058fvtwhrqqg1q8ftx]    Script Date: 07/12/2016 16:20:30 ******/
ALTER TABLE [dbo].[Company]  WITH CHECK ADD  CONSTRAINT [FK_r1vx4rn058fvtwhrqqg1q8ftx] FOREIGN KEY([ProgrammingLanguageID])
REFERENCES [dbo].[ProgrammingLanguage] ([ID])
GO
ALTER TABLE [dbo].[Company] CHECK CONSTRAINT [FK_r1vx4rn058fvtwhrqqg1q8ftx]
GO
/****** Object:  ForeignKey [FK_icjp0ttrnb7k9js04t6ngb2ga]    Script Date: 07/12/2016 16:20:30 ******/
ALTER TABLE [dbo].[Participant]  WITH CHECK ADD  CONSTRAINT [FK_icjp0ttrnb7k9js04t6ngb2ga] FOREIGN KEY([ProgrammingLanguageID])
REFERENCES [dbo].[ProgrammingLanguage] ([ID])
GO
ALTER TABLE [dbo].[Participant] CHECK CONSTRAINT [FK_icjp0ttrnb7k9js04t6ngb2ga]
GO
/****** Object:  ForeignKey [FK_bc65dlpo7m3f6ndegmyak6xsg]    Script Date: 07/12/2016 16:20:31 ******/
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [FK_bc65dlpo7m3f6ndegmyak6xsg] FOREIGN KEY([AccountTypeID])
REFERENCES [dbo].[AccountType] ([ID])
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [FK_bc65dlpo7m3f6ndegmyak6xsg]
GO
