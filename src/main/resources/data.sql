DROP TABLE IF EXISTS CACHE;

CREATE TABLE CACHE (
  id int AUTO_INCREMENT  PRIMARY KEY,
  term VARCHAR NOT NULL,
  instant DATETIME NOT NULL,
  return VARCHAR NULL
);

insert into cache(term, instant, return) values ('teste', CURRENT_TIMESTAMP, 'teste' );
insert into cache(term, instant, return) values ('teste2', CURRENT_TIMESTAMP, 'teste' );
insert into cache(term, instant, return) values ('teste3', CURRENT_TIMESTAMP, 'teste' );