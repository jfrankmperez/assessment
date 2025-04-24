Evaluación Técnica
Evaluación Técnica - Registro e Inicio de Sesión de Usuarios

Tabla de Contenidos
Descripción General

Tecnologías Utilizadas

Prerrequisitos

Estructura del Proyecto

Construcción del Proyecto

Ejecución de la Aplicación

Pruebas

Problemas Comunes

Descripción General
Este proyecto es una evaluación técnica que implementa funcionalidades de registro de usuarios. Utiliza Java 17, Spring Boot 3, MapStruct, JPA/Hibernate y JWT para autenticación. El diseño sigue principios de arquitectura limpia y hexagonal.

Tecnologías Utilizadas
Java: 17

Spring Boot: 3.4.4

Gradle

MapStruct: 1.5.5.Final

Lombok

JWT (jjwt): 0.11.5

Base de datos: H2 embebida

JUnit 5 y Mockito: Para pruebas unitarias

Prerrequisitos
Asegúrate de tener instalado lo siguiente:

JDK 17
Verifica con:

bash
Copiar
Editar
java -version
Gradle (opcional, ya que se incluye wrapper)
Verifica con:

bash
Copiar
Editar
gradle -v
IDE como IntelliJ IDEA o Eclipse recomendado.

Estructura del Proyecto
bash
Copiar
Editar
challange_april/
├── src/
│   ├── main/
│   │   ├── java/   # Código fuente de la aplicación
│   └── test/       
│       └── java/   # Pruebas unitarias
├── build.gradle    # Archivo de configuración de Gradle
├── settings.gradle # Configuración de Gradle
|──...
Construcción del Proyecto
Desde la raíz del proyecto, ejecuta:

bash
Copiar
Editar
./gradlew build       # macOS/Linux
gradlew.bat build     # Windows
Esto compilará el proyecto y generará el artefacto en build/libs.

Ejecución de la Aplicación
Para ejecutar la aplicación:

bash
Copiar
Editar
./gradlew bootRun     # macOS/Linux
gradlew.bat bootRun   # Windows
La aplicación estará disponible en: http://localhost:8080

Endpoints de la API
Registro de Usuario: POST /api/v1/user

Pruebas
Para ejecutar las pruebas unitarias:

bash
Copiar
Editar
./gradlew test        # macOS/Linux
gradlew.bat test      # Windows
Los resultados estarán disponibles en: build/reports/tests/test/index.html.

Problemas Comunes
Puerto ocupado
Si el puerto 8080 está en uso, cambia la configuración en application.yml:

yaml
Copiar
Editar
server:
port: 8080
Error "Directory does not contain a Gradle build"
Asegúrate de ejecutar los comandos desde el directorio raíz del proyecto donde está ubicado build.gradle.