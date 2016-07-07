create table duongthuy_message_packages (
	messagePackagesId LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	messageFunction VARCHAR(75) null,
	messageId VARCHAR(75) null,
	messageFileIdData VARCHAR(75) null,
	sendDate DATE null,
	version VARCHAR(75) null
);