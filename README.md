# Taller 2 - Rest Microservicios
Integrantes: Santiago Caroprese, Daniel Hernández, Juan Carlos Suárez

## Instrucciones

### Parte 1 - REST

#### Servidor
1. **Iniciar Editor de Código**: Se puede confirmar que el servidor funciona tanto en Eclipse como en NetBeans, pero durante las pruebas resultó que no siempre funciona en Visual Studio Code.
2. **Iniciar aplicación**: Dentro del editor seleccionado, abrir el directorio "Taller 1/jerseyServer". Luego, iniciar la ejecución del programa, con archivo principal "/Taller 1/jerseyServer/src/main/java/co/edu/javeriana/ws/rest/Main.java".
3. **Base de Datos**: El servidor utiliza un archivo xml como base de datos con la información necesaria para la ejecución, incluido en la ubicación: "/Taller 1/jerseyServer/paseos.xml".

#### Cliente: Bono usando Flutter
1. **Instalar flutter:** Acceda al siguiente enlace https://flutter.dev/docs/get-started/install y siga los pasos para instalar flutter en su equipo.
2. **Instalar dependencias:** Abra el directorio "Taller 1/front_taller_uno" en Visual Studio Code. Luego, abra la terminal y escriba "flutter pub get".
3. **Instalar android studio:** Acceda al siguiente enlace https://developer.android.com/studio para descargar e instalar Android studio.
4. **Iniciar emulador de android:** Acceda al siguiente enlace https://developer.android.com/studio/run/emulator#runningemulator y siga las instrucciones para ejecutar el emulador de android.
5. **Iniciar aplicación:** Abra el archivo "Taller 1/front_taller_uno/lib/main.dart" desde Visual Studio Code. Luego en el menú superior izquierdo seleccione "run" y "Start debuggin"
6. **Usar servicios:** Ahora ya puede usar la aplicación.

### Parte 2 - Spring Cloud
1. **Configurar base de datos:** Inicie una instancia de MongoDB en localhost:27017.
2. **Iniciar Servidor Eureka:** Abra el directorio "Taller 2"/eurekaserver en Visual Studio Code. Luego, abra la terminal y escriba los comandos "mvn clean install" y "mvn spring-boot:run".
3. **Iniciar Servicio Sumador:** Abra el directorio "Taller 2"/sumador en Visual Studio Code. Luego, abra la terminal y escriba los comandos "mvn clean install" y "mvn spring-boot:run". Si desea iniciar una nueva instancia, modifique el valor de la propiedad server.port en el archivo src/main/resources/application.properties y vuelva a correr el comando "mvn spring-boot:run" en una nueva terminal. Asegúrese de que el puerto esté libre.
4. **Iniciar Servicio Restador:** Abra el directorio "Taller 2"/restador en Visual Studio Code. Luego, abra la terminal y escriba los comandos "mvn clean install" y "mvn spring-boot:run". Si desea iniciar una nueva instancia, modifique el valor de la propiedad server.port en el archivo src/main/resources/application.properties y vuelva a correr el comando "mvn spring-boot:run" en una nueva terminal. Asegúrese de que el puerto esté libre.
5. **Iniciar Servicio Divisor:** Abra el directorio "Taller 2"/divisor en Visual Studio Code. Luego, abra la terminal y escriba los comandos "mvn clean install" y "mvn spring-boot:run". Si desea iniciar una nueva instancia, modifique el valor de la propiedad server.port en el archivo src/main/resources/application.properties y vuelva a correr el comando "mvn spring-boot:run" en una nueva terminal. Asegúrese de que el puerto esté libre.
6. **Iniciar Servicio Multiplicador:** Abra el directorio "Taller 2"/sumador en Visual Studio Code. Luego, abra la terminal y escriba los comandos "mvn clean install" y "mvn spring-boot:run". Si desea iniciar una nueva instancia, modifique el valor de la propiedad server.port en el archivo src/main/resources/application.properties y vuelva a correr el comando "mvn spring-boot:run" en una nueva terminal. Asegúrese de que el puerto esté libre.
7. **Iniciar Servicio Calculadora:** Abra el directorio "Taller 2"/calculadora en Visual Studio Code. Luego, abra la terminal y escriba los comandos "mvn clean install" y "mvn spring-boot:run".
8. **Realizar solicitudes:** Desde el navegador, puede hacer solicitudes a los endpoints de la calculadora en http://localhost:8888/.

## Demo
Los enlaces de los videos de la demostración de la ejecución del taller están incluidos en la wiki del repositorio.
