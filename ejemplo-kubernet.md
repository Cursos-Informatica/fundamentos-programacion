# Practica

Aquí tienes un ejemplo completo de cómo desplegar una aplicación Java con Spring Boot en un clúster Kubernetes usando Minikube. 🚀

🛠 Requisitos previos
Antes de empezar, asegúrate de tener instalado: ✅ Docker → Para construir la imagen del microservicio
✅ Minikube → Para un clúster local de Kubernetes
✅ kubectl → Para gestionar Kubernetes
✅ JDK 17+ → Para compilar el código Java
✅ Maven o Gradle → Para construir la aplicación

Si aún no tienes Minikube, instálalo y ejecútalo:

sh
Copy
Edit
minikube start
## 1 Crear una aplicación Spring Boot simple
Si no tienes una aplicación lista, puedes generar un proyecto en Spring Initializr:
🔗 https://start.spring.io/

Selecciona:

Spring Boot 3.x
Dependencias: Spring Web
Idioma: Java
Build: Maven
Group: com.example
Artifact: miapp


## 2 Crear un controlador en src/main/java/com/example/miapp/HelloController.java
java
Copy
Edit
package com.example.miapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "¡Hola desde Kubernetes!";
    }
}

## 3 Configurar el puerto en src/main/resources/application.properties
properties
Copy
Edit
server.port=8080

## 4 Construir el JAR
Ejecuta:

sh
Copy
Edit
mvn clean package
Esto generará un archivo target/miapp-0.0.1-SNAPSHOT.jar.

## 5 Crear un Dockerfile
En la raíz del proyecto, crea un archivo llamado Dockerfile:

dockerfile
Copy
Edit
FROM openjdk:17-jdk
COPY target/miapp-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

## 6 Construir la imagen Docker
Si usas Minikube, usa su Docker interno:

sh
Copy
Edit
eval $(minikube docker-env)
Luego, crea la imagen:

sh
Copy
Edit
docker build -t miapp:v1 .
Verifica que la imagen existe:

sh
Copy
Edit
docker images

## 7 Crear un deployment en Kubernetes
Crea un archivo YAML llamado deployment.yaml con el siguiente contenido:

yaml
Copy
Edit
apiVersion: apps/v1
kind: Deployment
metadata:
  name: miapp-deployment
spec:
  replicas: 1
  selector:
    matchLabels:
      app: miapp
  template:
    metadata:
      labels:
        app: miapp
    spec:
      containers:
        - name: miapp
          image: miapp:v1
          ports:
            - containerPort: 8080
## 8 Aplicar el deployment en Kubernetes
Ejecuta:

sh
Copy
Edit
kubectl apply -f deployment.yaml
Verifica que el pod está corriendo:

sh
Copy
Edit
kubectl get pods


## 9  Exponer la aplicación
Para acceder al microservicio, crea un servicio:

sh
Copy
Edit
kubectl expose deployment miapp-deployment --type=NodePort --port=8080
Obtén la URL con:

sh
Copy
Edit
minikube service miapp-deployment --url

## 10 Probar la API
Abre la URL en tu navegador o usa curl:

sh
Copy
Edit
curl $(minikube service miapp-deployment --url)/api/hello
Deberías recibir:

txt
Copy
Edit


¡Hola desde Kubernetes!
🎉 ¡Felicidades! Has desplegado tu microservicio Spring Boot en Kubernetes. 🚀







