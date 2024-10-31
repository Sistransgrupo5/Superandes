# 🛒 Superandes - Sistema de Gestión de Inventarios y Transacciones

Este repositorio contiene el proyecto **Superandes**, una aplicación diseñada para gestionar inventarios y transacciones en una tienda. Este proyecto forma parte del curso **Sistemas Transaccionales (ISIS2304)**.

## 📑 Tabla de Contenidos
- [Descripción General](#-descripción-general)
- [Tecnologías Utilizadas](#-tecnologías-utilizadas)
- [Entregas](#-entregas)
  - [Entrega 1](#entrega-1---modelado-de-datos)
  - [Entrega 2](#entrega-2---implementación-de-transacciones)
  - [Entrega 3](#entrega-3---pruebas-de-concurrencia)
- [Configuración Inicial](#-configuración-inicial)
- [Ejecución de Pruebas](#-ejecución-de-pruebas)
- [Contacto](#-contacto)

---

## 📋 Descripción General

**Superandes** permite la gestión de inventarios, ordenes de compra, consultas sobre productos y el control de transacciones concurrentes usando diferentes niveles de aislamiento. La aplicación implementa transacciones para gestionar de forma segura y eficiente las operaciones de inventario.

---

## 💻 Tecnologías Utilizadas
- **Base de datos**: Oracle 12c
- **Backend**: Java (Spring Framework)
- **Pruebas de API**: Postman

---

## 📦 Entregas

### Entrega 1 - Modelado de Datos
La primera entrega incluye:
- 📋 **Modelo ER** para la base de datos de Superandes.
- 🗄️ **Tablas Normalizadas** en 3NF, con estructuras adecuadas para consultas y transacciones.

### Entrega 2 - Implementación de Transacciones
En esta entrega, se desarrollaron los siguientes requisitos funcionales (RF) y de consulta (RFC):
- **RF1 - RF9**: Operaciones básicas de inventario y gestión de órdenes de compra.
- **RF10**: Registro de ingreso de productos a la bodega. Esta transacción implica registrar el ingreso de productos, actualizar el inventario, y marcar la orden como **ENTREGADA**.
- **RFC1 - RFC5**: Consultas sobre productos y documentos de órdenes de compra.
- **RFC6 - RFC7**: Consultas de documentos de ingreso usando niveles de aislamiento **Serializable** y **Read Committed**.

### Entrega 3 - Pruebas de Concurrencia
Esta entrega incluye pruebas para verificar el correcto funcionamiento de las transacciones y su manejo de concurrencia:
- 🔄 **Escenario de Prueba 1**: Prueba de concurrencia entre RFC6 y RF10.
- 🔄 **Escenario de Prueba 2**: Prueba de concurrencia entre RFC7 y RF10.

---

## ⚙️ Configuración Inicial

### Paso 1: Configuración de la Base de Datos
1. **Conectar a Oracle 12c** y ejecutar el script SQL la base de datos y las tablas.
2. Configurar las credenciales en el archivo `application.properties`:
   ```properties
    spring.jpa.hibernate.ddl-auto=none
    spring.jpa.properties.hibernate.hql.bulk_id_strategy.global_temporary.create_tables=false
    #spring.data.mongodb.uri=mongodb://ISIS2304F04202410:hpRKwgCQYw@157.253.236.88:8087/ISIS2304A30202420
    spring.datasource.url=jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD
    spring.datasource.username=ISIS2304A15202420
    spring.datasource.password=JAKejJkjHm
    spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
    spring.jpa.database-platform=org.hibernate.dialect.OracleDialect
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.OracleDialect
    spring.jpa.show-sql=true
   ```

### Paso 2: Ejecutar la Aplicación
1. En el directorio raíz del proyecto, ejecutar:
   ```bash
   ./mvnw spring-boot:run
   ```

### Paso 3: Poblar la Base de Datos
Poblar la base de datos con datos de ejemplo usando el archivo `poblacion.sql` en `Analisis_modelo_datos`.

---

## 🧪 Ejecución de Pruebas

### Pruebas para RF10, RFC6 y RFC7
1. **RF10 - Registro de Ingreso de Productos**:
   - Ejecutar la transacción en Postman.
   - Verificar que el estado de la orden cambia a **ENTREGADA** y que el inventario se actualiza.

2. **RFC6 (Serializable)**:
   - Realizar una consulta sobre documentos de ingreso de productos. El nivel **Serializable** bloquea cambios concurrentes hasta que finalice la transacción.
   - Configurar un temporizador de 30 segundos.

3. **RFC7 (Read Committed)**:
   - Similar a RFC6, pero este nivel permite leer solo los datos confirmados.

### Pruebas de Concurrencia
- **Escenario de Prueba 1**:
  - Ejecutar **RFC6** y luego **RF10** antes de que termine el temporizador.
  - Verificar que RF10 espere a que RFC6 finalice.

- **Escenario de Prueba 2**:
  - Ejecutar **RFC7** y luego **RF10** antes de que termine el temporizador.
  - Confirmar que RF10 espere a que RFC7 libere los bloqueos necesarios.