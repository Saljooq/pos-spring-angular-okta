# POS-SPRING-ANGULAR-OKTA

This is just a base project to see if everything comes together and can be run locally

# Versions used

- JAVA - 11
- Maven - 3.6.3
- Node - 16

# Installing ng for running Angular and running frontend code

```bash
npm install -g @angular/cli
cd frontend-angular
npm i
ng serve
```

In windows `ng serve` may not be allowed because of RESTRICTED execution policy - try changing it with this

```bash
Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
```

# Commands needed to compile a JAR / run it

```bash
cd spring-boot
mvn clean install
java -jar target/*.jar
```


# Instructions to run backend/frontend silently ( NEEDED FOR DEPLOYMENT)

## Backend
```bash
cd backend-spring-boot

# Only need to run chmod the first time
chmod +x run_silently.sh

./run_silently.sh
```
## Frontend
```bash
cd frontend-angular

# Only need to run chmod the first time
chmod +x run_silently.sh

./run_silently.sh
```


# Random stuff

## `ng generate component <component-name>` not working
Try:
```bash
ng add @angular-eslint/schematics@latest
```