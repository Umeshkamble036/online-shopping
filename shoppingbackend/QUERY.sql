CREATE TABLE categeory(
 id MEDIUMINT NOT NULL,
 name VARCHAR(50),
 description VARCHAR(255),
 image_url VARCHAR(50),
 is_active BOOLEAN,
 CONSTRAINT pk_categeory_id PRIMARY KEY (id)
);


CREATE TABLE categeory(
 id IDENTITY,
 name VARCHAR(50),
 description VARCHAR(255),
 image_url VARCHAR(50),
 is_active BOOLEAN,
 CONSTRAINT pk_categeory_id PRIMARY KEY (id)
);


INSERT INTO CATEGEORY VALUES(3,'MOBILES','I am description of mOBILES','MOBILES.png','TRUE');