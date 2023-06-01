# joins-with-spring-data-r2dbc

### Run in local
    1. Buil step `clean build -xtest`
    2. Start the application and to save hit Get : http://localhost:8080/demo

### Data base structure
    1.  
```agsl
CREATE TABLE country 
( 
  id SERIAL PRIMARY KEY,
  name TEXT
);

CREATE TABLE city 
( 
   id SERIAL,
   name text,
   country_id integer REFERENCES country
);
```
