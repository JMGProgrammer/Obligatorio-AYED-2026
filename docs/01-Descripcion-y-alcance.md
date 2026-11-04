# 1. Descripción y alcance del sistema

## 1.1 Datos de la entrega

| Campo | Información |
|---|---|
| Proyecto | Sistema de Gestión de Organigrama Empresarial |
| Empresa ficticia | NovaTech |
| Materia | Algoritmos y Estructuras de Datos |
| Lenguaje | Java |
| Modalidad | Aplicación de consola |
| Persistencia | En memoria |
| Institución | CTC Rosario |
| Docente | Gonzalo Alonso |
| Integrantes | Mateo Rilla, Juan Meny, Facundo Villalba |
| Fecha de entrega | 3 de diciembre de 2026, 19:00 |

## 1.2 Introducción

El proyecto consiste en una aplicación de consola destinada a representar y administrar el organigrama de la empresa ficticia NovaTech. La empresa cuenta con un Gerente General, diferentes gerencias, líderes y empleados operativos. Cada empleado tiene un único jefe directo y puede tener cualquier cantidad de subordinados.

Esta relación jerárquica se representa mediante un árbol N-ario. El Gerente General ocupa la raíz del árbol y los subordinados de cada empleado constituyen sus nodos hijos. A diferencia de un árbol binario, un árbol N-ario no limita cada nodo a dos hijos.

Además del organigrama, el sistema administra cargos, departamentos, proyectos y asignaciones de empleados. Todos los datos permanecen en memoria durante la ejecución; al cerrar el programa se pierden, ya que no se utiliza una base de datos ni almacenamiento en archivos.

## 1.3 Objetivo general

Desarrollar una aplicación Java de consola que permita administrar la estructura jerárquica del personal de NovaTech, junto con las entidades relacionadas, aplicando recorridos, búsquedas y cálculos recursivos sobre un árbol N-ario.

## 1.4 Objetivos específicos

- Representar el organigrama mediante un árbol N-ario.
- Implementar altas, bajas y modificaciones de las entidades principales.
- Buscar empleados por legajo y por apellido.
- Mostrar la jerarquía completa en recorrido preorden.
- Calcular subordinados totales y masa salarial de un subárbol.
- Obtener la cadena de mando de un empleado.
- Calcular la altura del organigrama.
- Listar empleados pertenecientes a un nivel determinado.
- Reasignar un empleado junto con todo su subárbol.
- Impedir que una reasignación forme ciclos.
- Encontrar el jefe común más cercano entre dos empleados.
- Administrar proyectos, asignaciones y horas de dedicación.
- Precargar datos suficientes para demostrar las funcionalidades.

## 1.5 Alcance funcional

### Gestión del organigrama

El sistema permite:

- mostrar el organigrama con indentación según el nivel;
- mostrar el nivel de cada empleado;
- mostrar la cantidad total de subordinados;
- contratar un empleado indicando su jefe;
- modificar cargo, departamento y salario;
- dar de baja empleados que cumplan las condiciones establecidas;
- reasignar empleados a otro jefe;
- buscar por legajo o apellido;
- consultar altura, niveles y cadenas de mando;
- calcular el jefe común más cercano.

### Gestión de cargos

Se implementan:

- alta;
- modificación;
- baja;
- listado;
- validación para impedir la eliminación de cargos utilizados.

### Gestión de departamentos

Se implementan:

- alta;
- modificación;
- baja;
- listado;
- asignación de responsable;
- listado y conteo de empleados pertenecientes al departamento;
- validación para impedir la eliminación de departamentos con empleados.

### Gestión de proyectos y asignaciones

Se implementan:

- alta, modificación, baja y listado de proyectos;
- cambio de estado;
- asignación de empleados;
- modificación y baja de asignaciones;
- cálculo de horas totales;
- validación de empleados repetidos dentro del mismo proyecto.

## 1.6 Funcionalidades excluidas

El sistema no incluye:

- base de datos;
- persistencia en archivos;
- interfaz gráfica;
- autenticación de usuarios;
- conexión de red;
- validación avanzada de fechas;
- recuperación automática de datos al reiniciar.

Estas exclusiones son coherentes con el alcance académico y con la exigencia de trabajar en memoria mediante una aplicación de consola.

## 1.7 Datos iniciales

La aplicación se inicia con:

- 12 empleados, incluyendo al Gerente General;
- 4 niveles de árbol, numerados del 0 al 3;
- 4 departamentos;
- 7 cargos;
- 2 proyectos;
- 5 asignaciones.

El organigrama precargado es:

```text
Laura Méndez — Gerente General
├── Diego Pérez — Gerente de Área
│   ├── Ana Rodríguez — Líder
│   │   ├── Martín Silva — Programador
│   │   └── Sofía Castro — Programadora
│   └── Pablo Gómez — Líder
│       └── Lucía Fernández — Administradora de Redes
├── Carolina Díaz — Gerente de Área
│   ├── Jorge Núñez — Vendedor
│   └── Valentina Rossi — Vendedora
└── Fernando López — Gerente de Área
    └── Camila Torres — Analista de RRHH
```

## 1.8 Reglas de negocio adoptadas

1. Los identificadores deben ser únicos dentro de cada entidad.
2. El Gerente General es la única raíz y no tiene jefe.
3. No puede eliminarse la raíz.
4. No puede eliminarse un empleado que tenga subordinados.
5. No puede eliminarse un empleado responsable de un departamento o proyecto.
6. Al eliminar un empleado válido se eliminan sus asignaciones.
7. No puede eliminarse un cargo en uso.
8. No puede eliminarse un departamento con empleados.
9. Los salarios y horas deben ser mayores que cero.
10. Los estados válidos son `PLANIFICADO`, `EN_CURSO` y `FINALIZADO`.
11. Un empleado no puede repetirse dentro del mismo proyecto.
12. Una reasignación no puede colocar un empleado debajo de su propio subárbol.

## 1.9 Decisiones técnicas

### Separación entre Empleado y NodoEmpleado

`Empleado` conserva los datos personales y laborales, mientras que `NodoEmpleado` conserva la información estructural: jefe, subordinados y nivel.

La separación permite distinguir dos responsabilidades:

- la entidad representa al empleado;
- el nodo representa su ubicación dentro del organigrama.

La información exigida por el enunciado continúa presente entre ambas clases. Esta decisión debe confirmarse con el docente antes de la entrega definitiva.

### Fechas almacenadas como texto

Las fechas se guardan mediante `String`. Esta decisión mantiene el código dentro de los contenidos trabajados y evita incorporar APIs que no son necesarias para demostrar árboles y recursividad.

### Baja de empleados con subordinados

Se eligió impedir la baja en lugar de reasignar automáticamente los subordinados. La regla resulta fácil de verificar, evita cambios jerárquicos involuntarios y es una de las alternativas permitidas por el enunciado.
