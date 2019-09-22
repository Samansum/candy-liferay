create table Candy_Book (
	uuid_ VARCHAR(75) null,
	bookId LONG not null primary key,
	bookTitle VARCHAR(75) null,
	author VARCHAR(75) null,
	publishDate DATE null
);