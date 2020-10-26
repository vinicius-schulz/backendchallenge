DROP TABLE IF EXISTS CACHE;

CREATE TABLE CACHE (
  id int AUTO_INCREMENT  PRIMARY KEY,
  term VARCHAR NOT NULL,
  response VARCHAR NULL,
  branch VARCHAR NOT NULL
);

CREATE UNIQUE INDEX "UNIQUE_CACHE" ON CACHE
  (
    term, branch
  );