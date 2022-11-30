# dockerization
- step1:
D:\workspace\dockerization>docker run -p 3307:3306 --name mysqldb mysql
----------------------------------------------------------------------------

- step2:
D:\workspace\dockerization>docker rm mysqldb
---------------------------------------------------------------------------

- step3:
D:\workspace\dockerization>docker run -p 3307:3306 --name mysqldb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=test mysql
----------------------------------------------------------------------------

- step4:
D:\workspace\dockerization>docker rm -f mysqldb
--------------------------------------------------------------------------------

- step5:
D:\workspace\dockerization>docker run -d -p 3307:3306 --name mysqldb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=test mysql

Now the above command will create mysql container and move in detached /background 
in order to see the logs we use the following command

D:\workspace\dockerization>docker logs mysqldb

----------------------------------------------------------------------------------


- step6:
D:\workspace\dockerization>docker network create spring-net
------------------------------------------------------------------------

- step7: now connect mysql with network

>docker network conect spring-net mysqldb
--------------------------------------------------------------------------

- step8:now connect mysql with network and sprigboot application
>docker run -p 8003:6003 --name myapp --net spring-net -e MYSQL_HOST=mysqldb -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_PORT=3306 myapp
---------------------------------------------------------------------------------

step9:open the browser and test it.

- URL: http://localhost:8003/api/
---------------------------------------------------

# DOCKERCOMPOSE

-STEP1: Create Docker compose file as below
--------------------------------------------------------
- STEP2 : OPEN THE TERMINAL 
  > docker-compose up --build
---------------------------------------------------

-STEP3: OPEN DOCKER-DESKTOP AND CHECK
---------------------------------------------------

-STEP4: OPEN THE MYSQL AND CHECK
---------------------------------------------------

-STEP5: OPEN THE BROWSER AND TEST THE FOLLOWING ENDPOINTS:
-----------------------------------------------

GET : http://localhost:8003/api/msg

GET : http://localhost:8003/api/products

POST: http://localhost:8003/api/save

BODY{
"id":1006,
"name":"abc",
"price":30000

}




