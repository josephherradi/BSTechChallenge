# BS Tech Challenge
La solution technique proposée comprend:
* Une API Rest qui implémente la logique métier, l'accès et la lecture des données et le routage URI.


## Tehnologies utilisées:
* JDK 8
* Spring Boot 2
* Spring Boot data jpa
* Maven
* mySQL 5.6.41 (login: root, pwd=)
* IntelliJ 2018.2
* Apache Tomcat (embeded)



## Lancer les modules à l'aide du plugin Maven

Il est possible de compiler et d'executer rapidement l'application avec la commande suivante maven

```
mvn spring-boot:run
```

## Compiler en JAR

La compilation des livrables se fait avec la commande suivante à l'aide de maven selon la balise <packaging>jar</packaging> du pom.xml
```
mvn clean package
```

## Lancer les modules compilés JAR
Le lancement le backend  Rest se fait par la commande suivante
```
java -jar backend-rest.jar
```

## URLs

L'Api rest  est déployée sur le port 8082

## Auteur

Joseph Herradi
