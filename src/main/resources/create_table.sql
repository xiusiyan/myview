CREATE TABLE topic_data( id int NOT NULL PRIMARY KEY AUTO_INCREMENT, topid int NOT NULL, x_axis varchar(200), y_axis double, create_time timestamp not null default current_timestamp);

CREATE TABLE topic ( id int NOT NULL PRIMARY KEY, url varchar(2000), regx varchar(2000), title varchar(2000));