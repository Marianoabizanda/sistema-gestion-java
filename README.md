# Sistema de Gestión en Java (Consola)

## Descripción
Sistema de gestión desarrollado en Java que funciona por consola.
Permite administrar personas a través de un menú interactivo, aplicando
Programación Orientada a Objetos y una arquitectura por capas.

El proyecto fue realizado con fines de aprendizaje y portfolio, enfocándose
en escribir código claro, ordenado y funcional.

---

## Funcionalidades
- Agregar personas
- Listar personas
- Listar personas ordenadas por nombre
- Listar personas ordenadas por edad
- Buscar persona por ID
- Editar persona
- Eliminar persona (con confirmación)
- Persistencia de datos en archivo CSV

---

## Tecnologías y conceptos utilizados
- Java
- Programación Orientada a Objetos (POO)
- Colecciones (`ArrayList`)
- Streams y `Comparator`
- Manejo de archivos (CSV)
- Arquitectura por capas
- Validación de entradas por consola

---

## Estructura del proyecto
com.gestion
├── model
│ └── Persona.java
├── repository
│ └── PersonaRepository.java
├── service
│ └── PersonaService.java
├── ui
│ └── Main.java
└── util
└── Resultado.java (opcional)


---

## Persistencia
Los datos se guardan en un archivo `personas.csv`.
Al cerrar y volver a ejecutar el programa, las personas cargadas
se mantienen disponibles.

---

## Cómo ejecutar el proyecto
1. Clonar el repositorio
2. Abrir el proyecto en IntelliJ IDEA
3. Ejecutar la clase `Main`
4. Interactuar con el sistema mediante el menú por consola

---

## Objetivo del proyecto
Este proyecto fue desarrollado para:
- Practicar Java y POO
- Comprender la separación de responsabilidades
- Simular el funcionamiento de un sistema de gestión real

