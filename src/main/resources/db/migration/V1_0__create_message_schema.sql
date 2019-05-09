CREATE TABLE message (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  sender varchar(255) ,
  receiver varchar(255) ,
  subject varchar(255) ,
  body nvarchar(500) ,
  createdOn date
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;