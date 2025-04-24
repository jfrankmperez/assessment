# Evaluación Técnica

## Tabla de Contenidos
- [Descripción General](#descripción-general)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Prerrequisitos](#prerrequisitos)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Construcción del Proyecto](#construcción-del-proyecto)
- [Ejecución de la Aplicación](#ejecución-de-la-aplicación)
- [Pruebas](#pruebas)
- [Problemas Comunes](#problemas-comunes)

## Descripción General
Este proyecto es una evaluación técnica que implementa funcionalidades de registro e inicio de sesión de usuarios utilizando Spring Boot y Gradle.

## Tecnologías Utilizadas
- Spring Boot: 3.4.4
- Java: 17
- Gradle
- H2 Database: Base de datos embebida para pruebas locales
- Spring Security: Para autenticación y autorización
- JUnit 5 y Mockito: Utilizado para pruebas unitarias
- JWT: Para generación de tokens
- MapStruct: Para mapeo de entidades y DTOs
- Lombok: Reducción de boilerplate

## Prerrequisitos
Antes de construir o ejecutar la aplicación, asegúrate de tener lo siguiente:

- Java Development Kit (JDK) 17 instalado. Verifica usando:
```bash
java -version
```
- Gradle instalado (o usar el wrapper):
```bash
gradle -v
```
- IDE como IntelliJ IDEA o Eclipse

## Estructura del Proyecto
```plaintext
root/
  |- codigo/                  # Código fuente del proyecto
      |- src/main/java/...   
      |- src/test/java/...   
      |- build.gradle         
      |- settings.gradle      
  |- documentacion/           # Archivos de documentación
      |- README.md           
```

## Construcción del Proyecto
```bash
cd codigo
./gradlew build   # macOS/Linux
gradlew.bat build # Windows
```

## Ejecución de la Aplicación
```bash
./gradlew bootRun  # macOS/Linux
gradlew.bat bootRun  # Windows
```
La aplicación se ejecuta en `http://localhost:8081`.

### Endpoints de la API:
- `POST /api/v1/user` - Registro de usuario

## Pruebas
```bash
./gradlew test
```
Resultados disponibles en: `build/reports/tests/test/index.html`

## Problemas Comunes

**"El directorio no contiene una construcción de Gradle"**
- Asegúrate de estar en el directorio correcto antes de ejecutar Gradle.

**Conflictos de Puerto**
- Cambia el puerto en `application.yml` si 8081 está en uso:
```yaml
server:
  port: 8080
```
