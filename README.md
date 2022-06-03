# amigoscode_springboot_tutorial

## Pull image from DockerHub
```
docker pull postgres:14
```

# Run the database
```
docker run --name spring-student -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -v /Projects/amigoscode_springboot_tutorial/data:/var postgres
```

# To restart
```
docker start spring-student
```

# PSQL
```
psql -h localhost -p 5432 -U postgres -d student

CREATE DATABASE student;
GRANT ALL PRIVILEGES ON DATABASE "student" TO postgres;
```
