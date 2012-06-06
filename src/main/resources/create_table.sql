CREATE TABLE topic_data( id int NOT NULL PRIMARY KEY, topid int NOT NULL, x_axis varchar(200), y_axis double);

CREATE TABLE topic ( id int NOT NULL PRIMARY KEY, url varchar(2000), regx varchar(2000), title varchar(2000));