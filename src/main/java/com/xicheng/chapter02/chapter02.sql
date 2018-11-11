CREATE TABLE customer (
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) DEFAULT NULL ,
  contact VARCHAR(255) DEFAULT NULL ,
  telephone VARCHAR(255) DEFAULT NULL ,
  email VARCHAR(255) DEFAULT NULL ,
  remark TEXT,
  PRIMARY KEY (id)
) ENGINE = innoDB DEFAULT CHARSET = utf8;

INSERT INTO customer VALUES ('1', 'customer1', 'Cathy', '18618618618', 'cathy@163.com', null);
INSERT INTO customer VALUES ('2', 'customer2', 'Bryan', '13513513513', 'bryan@163.com', null);