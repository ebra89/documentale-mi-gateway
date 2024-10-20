# documentale-mi-gateway

Requirements before start:
-
- JDK 17
- Docker Desktop /  Rancher Desktop
- Maven
- IDEA (IntelliJ IDEA Community Edition / Eclipse )

components:
-
- api-gateway
- discovery-server

Steps to running this app in local:
- 
1- lunch command compose up in terminal in /local folder: 
```
docker compose up -d / nerdctl compose -f docker-compose.yaml up -d
```

2- configure keycloak:

after docker compose up correctly navigate to : http://localhost:8090
sin-in with admin/admin 
![img.png](images/img.png)

create new realm in our case documentale-mi:
![img_1.png](images/img_1.png)
![img_2.png](images/img_2.png)

create new client in our realm click next and save:
![img_3.png](images/img_3.png)
![img_4.png](images/img_4.png)
![img_5.png](images/img_5.png)
![img_6.png](images/img_6.png)

create new scope and save:
![img_7.png](images/img_7.png)
![img_8.png](images/img_8.png)

now go to clients list and choose our client and in add our new scope :
![img_9.png](images/img_9.png)
![img_10.png](images/img_10.png)
![img_11.png](images/img_11.png)

create new user and set credentials:
![img_12.png](images/img_12.png)
![img_13.png](images/img_13.png)
![img_14.png](images/img_14.png)

in realm setting you can find all information for configure your app:
![img_15.png](images/img_15.png)
![img_16.png](images/img_16.png)




3- run discover server with maven command:

``` mvn spring-boot:run ```
![img.png](images/discovery/img.png)

open browser in http://localhost:8761 and log-in with the credentials you can find in application.yaml 
![img_2.png](images/discovery/img_2.png)

for now there is no application registered yet
![img_3.png](images/discovery/img_3.png)

4- run api-gateway
run api-gateway 
![img_4.png](images/discovery/img_4.png)

now you can see api-gateway is registered in discovery server
![img_5.png](images/discovery/img_5.png)

5- Test: now navigate to our api-gateway utl: http://localhost:8080/token
it should be open keycloak login page like you can see in the image below
![img.png](images/discovery/img_6.png)

you can sign-in with the user we created before, in first step you have to change password:
![img_1.png](images/discovery/img_7.png)

this endpoint return a JWT token our service is up and running and the keycloak configuration works
![img_2.png](images/discovery/img_8.png)

we see how to start keycloak from a docker-compose and a simple configuration,
and how to run discovery server and api-gateway in our machine