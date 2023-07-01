# Spring Boot Application with Kubernetes
This is a Spring Boot project using PostgreSQL as its primary database. It also uses OpenFeign to make requests to another API hosted on another pod inside a Kubernetes cluster. The project exposes its service using a NodePort and is also accessible internally within the cluster through a ClusterIP.

## Prerequisites

* JDK 17
* Maven 3.6+
* Docker
* Kubernetes
* PostgreSQL

## Setup Instructions

Follow these steps to get the project running on your local machine:

### Database Setup

This project uses PostgreSQL as its database. Use the following commands to start a PostgreSQL instance using Docker:

```
docker run --name postgres-db -e POSTGRES_PASSWORD=movie -d -p 5432:5432 postgres
```

Update `src/main/resources/application.properties` file with your database credentials.

### Building the Application

Build the project using Maven. From the root directory of the project, run:

```
mvn clean install
```

This will create a JAR file in the `target` directory.

### Dockerize the Application

Now, build the Docker image. Replace `{version}` with the current version of your application.

```
docker build -t my-spring-app:{version} .
```

### Kubernetes Deployment

We will use Kubernetes to deploy the application. Replace `{version}` with the current version of your application in `kubernetes/deployment.yaml` and `kubernetes/service.yaml`.

Apply the Kubernetes configuration using:

```
kubectl apply -f kubernetes/deployment.yaml
kubectl apply -f kubernetes/service.yaml
```

### Accessing the Application

The application is exposed on port 30001 (defined in service.yaml) through a NodePort. Access the application using `http://localhost:30001/swagger-ui.html`.

The application is also accessible internally within the cluster through a ClusterIP.

## Working with the API

### Using OpenFeign

This project uses OpenFeign to communicate with other services within the Kubernetes cluster. Feign creates a proxy and implements the HTTP client so that we don't have to manually write the client code.

### Health Check

The application also includes a health check endpoint at `http://localhost:30001/actuator/health` for checking the application status.

