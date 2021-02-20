# CATALOG api-beercatalog
A catalog where different producers can add their beers


## Features 

 ### Users CRUD
 Creating / updating / getting / deleting / listing users ( ROLE_ADMIN needed ). If the user is a producer, the name of the user should be equal with the name of the producer. 
 
 
 ### Producers CRUD
 Creating / updating / deleting ( ROLE_ADMIN needed ) and the retrieval of information is for general use 
 
 
 ### Beers CRUD 
 Creating/updating ( ROLE_PRODUCER needed ). Each producer can add and update only his beers. Endpoint the lists beer sorted alphabetically.
 Endpoints for listing beers by type and by producer. 
 
## Installation 

Prerequisites:
- Java 8 installation
- Maven installation
- Java IDE 
- MySQL 8 installation

1) Clone the repository:

>  git clone https://github.com/andreitz31/api-beercatalog.git

2) Install the catalog schema on your MySQL server:

> CREATE SCEHMA catalog;
> USE catalog;
> SOURCE .\api-beercatalog\catalogV2.sql;

3) Open application.properties and change the data source corresponding lines to your database address and credentials:
```
> spring.datasource.url=jdbc:mysql://localhost:3306/catalog?useSSL=false&serverTimezone=UTC
> spring.datasource.username=root
> spring.datasource.password=admin
 ```
 
4) Enter in your IDE and File>Import>Maven>Existing Maven project

5) Do a Maven clean install. One test is still failing. 

```
mvn clean install -DskipTests

```
6) Run application on server and connect from your browser to http://localhost:8080/swagger-ui.html

## Login 

Credentials:

ADMIN_ROLE
>user: test_admin
>password: test_admin

PRODUCER_ROLE
>user: test_producer
>password: test_producer

USER_ROLE

>user: test_user
>password: test_password


## Run on Docker 

We will need to create two containers one for the app and one for the mysql database which can communicate between them.

Create docker network:
```docker network create catalog-mysql```

Create mysql container:
```docker container run --name mysqldb --network catalog-mysql -e MYSQL_ROOT_PASSWORD=<PASSWORD> -e MYSQL_DATABASE=catalog -d mysql:8```

Get the container id:
```docker container ls```

Exec into the mysql container:
```docker container exec -it <CONTAINER_ID> mysql```

Enter your credentials:
```mysql -uroot -proot```

Setup database:
```create schema catalog;```
``` use catalog;```
``` source .\api-beercatalog\catalogV2.sql;```

Create application docker image(run this command from the same level with the Dockerfile)
```docker image build -t catalog .```

Run the image locally on the created network:
```docker container run --network catalog-mysql --name catalog -p 8080:8080 -d catalog```

Finally, you should be able to connect to http://localhost:8080 from your browser.


