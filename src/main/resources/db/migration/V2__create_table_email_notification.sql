CREATE TABLE email(
  id UUID DEFAULT uuid_generate_v4() PRIMARY KEY ,
  destination varchar(100),
  subject varchar(100),
  body varchar(100)
);