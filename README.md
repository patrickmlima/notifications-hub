# notifications-hub

A simple and demonstration for a notification hub in which users can subscribe to categories and, for every new message created for a category, the user is notified according to the notification methods it has activated.

It uses Java with Spring Boot framework to create a REST API and Angular to create a frontend SPA. Postgres is the chosen database to store data.

## In order to serve this project

To only execute this project only Docker is required as dependency.

- Docker CE >= 27.1.1
  > does not requires some newest specific docker features. This version is set only because it was the used verion on development environment.

Execute docker compose from the root folder:

`docker compose up --build`

If successful completed, it will run 4 containers

- database (on port 5432)
- frontend (on port 80)
- backend (on port 8000)
- adminer (on port 8085)

## In order to run this project in development mode

In order to run project in development mode you need:

- openjdk-17
- Apache Maven >= 3.6.3
- node >= 20
- angular/cli >= 18

Intall frontend dependencies:

```bash
cd frontend/notifications-hub-fe
npm i
```

Install backend dependencies:

```bash
cd backend/notification
mvn install
```
