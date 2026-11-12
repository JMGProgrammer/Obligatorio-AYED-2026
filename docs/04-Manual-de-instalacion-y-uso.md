# 4. Manual de instalación y uso

## 4.1 Requisitos

- Java Development Kit instalado.
- Terminal o consola.
- Editor de código opcional, por ejemplo Visual Studio Code.

El proyecto fue verificado con OpenJDK 21.

Para consultar la versión instalada:

```bash
java -version
javac -version
```

## 4.2 Ubicación del proyecto

```text
~/Documentos/PROYECTOS LOCALES/Obligatorio-AYED-IA
```

El código fuente está dentro de `src`.

## 4.3 Compilación

Abrir una terminal y ejecutar:

```bash
cd ~/Documentos/PROYECTOS\ LOCALES/Obligatorio-AYED-IA/src
javac Principal.java Dominio/Controladora.java Dominio/Entidades/*.java Dominio/Estructuras/*.java
```

Si la compilación termina sin mostrar errores, se generarán archivos `.class`.

## 4.4 Ejecución

Desde la carpeta `src`:

```bash
java Principal
```

Se mostrará el menú principal:

```text
========== NOVATECH ==========
1 - Organigrama
2 - Empleados
3 - Departamentos
4 - Cargos
5 - Proyectos y asignaciones
6 - Consultas recursivas
0 - Salir
Opción:
```

## 4.5 Eliminación de archivos compilados

Si se desea limpiar la carpeta:

```bash
find . -name '*.class' -delete
```

Este comando elimina solamente los archivos generados por el compilador, no los `.java`.

## 4.6 Uso del Scanner

La entrada se realiza mediante:

```java
static Scanner Scanner = new Scanner(System.in);
```

Lectura numérica:

```java
System.out.print("Legajo: ");
int id = Scanner.nextInt();
Scanner.nextLine();
```

Lectura de texto:

```java
System.out.print("Nombre: ");
String nombre = Scanner.nextLine();
```

Después de `nextInt()` o `nextDouble()` se ejecuta `nextLine()` para consumir el Enter que permanece en el búfer.

## 4.7 Menú de organigrama

### Mostrar organigrama

Presenta la estructura completa con indentación, cargo, nivel y cantidad total de subordinados.

### Reasignar empleado

Solicita:

- legajo del empleado;
- legajo del nuevo jefe.

La operación se rechaza si genera un ciclo, intenta mover la raíz o utiliza legajos inexistentes.

### Mostrar altura

Indica la cantidad máxima de niveles. El valor inicial es 4.

### Mostrar empleados de un nivel

Solicita un nivel numérico. La raíz pertenece al nivel 0.

### Jefe común más cercano

Solicita dos legajos y muestra el ancestro común más bajo.

## 4.8 Menú de empleados

### Alta

Solicita:

- legajo;
- nombre;
- apellido;
- id de cargo;
- id de departamento;
- salario;
- fecha de ingreso;
- legajo del jefe.

Antes del alta conviene consultar los listados de cargos y departamentos.

### Modificación

Permite modificar cargo, departamento y salario. El legajo no cambia.

### Baja

Se rechaza si el empleado:

- no existe;
- es la raíz;
- tiene subordinados;
- es responsable de departamento;
- es responsable de proyecto.

### Búsquedas

- Por legajo: retorna una única coincidencia.
- Por apellido: puede retornar varias coincidencias.

## 4.9 Menú de departamentos

Permite alta, modificación, baja y listado. También muestra empleados y cantidad por departamento.

Para modificar un departamento se solicita el legajo del responsable.

## 4.10 Menú de cargos

Permite alta, modificación, baja y listado.

El nivel jerárquico sugerido es:

```text
1 = Dirección
2 = Supervisión
3 = Operativo
```

No puede eliminarse un cargo utilizado por un empleado.

## 4.11 Menú de proyectos y asignaciones

### Proyectos

Permite:

- alta;
- modificación;
- baja;
- listado;
- cambio de estado.

Estados válidos:

```text
PLANIFICADO
EN_CURSO
FINALIZADO
```

### Asignaciones

Permite:

- asignar un empleado;
- modificar horas y rol;
- eliminar una asignación;
- listar asignaciones;
- calcular horas totales de un proyecto.

## 4.12 Menú de consultas recursivas

Incluye:

- conteo de subordinados totales;
- cálculo de masa salarial;
- cadena de mando;
- organigrama en preorden.

## 4.13 Identificadores precargados

### Empleados

| Legajo | Empleado |
|---:|---|
| 1000 | Laura Méndez |
| 1001 | Diego Pérez |
| 1002 | Ana Rodríguez |
| 1003 | Martín Silva |
| 1004 | Sofía Castro |
| 1005 | Pablo Gómez |
| 1006 | Lucía Fernández |
| 1007 | Carolina Díaz |
| 1008 | Jorge Núñez |
| 1009 | Valentina Rossi |
| 1010 | Fernando López |
| 1011 | Camila Torres |

### Departamentos

| Id | Departamento |
|---:|---|
| 1 | Tecnología |
| 2 | Comercial |
| 3 | RRHH |
| 4 | Dirección General |

### Cargos

| Id | Cargo |
|---:|---|
| 1 | Gerente General |
| 2 | Gerente de Área |
| 3 | Líder |
| 4 | Programador |
| 5 | Administrador de Redes |
| 6 | Vendedor |
| 7 | Analista de RRHH |

### Proyectos

| Id | Proyecto | Estado inicial |
|---:|---|---|
| 1 | Migración a la nube | EN_CURSO |
| 2 | Nuevo sistema CRM | PLANIFICADO |

## 4.14 Errores de entrada

La aplicación supone que el usuario ingresa números cuando se solicitan valores numéricos. Si se escribe texto en una lectura `nextInt()` o `nextDouble()`, Java puede generar una excepción de entrada.

Esta limitación se conserva para mantener el código dentro del nivel trabajado. Durante la demostración se recomienda ingresar datos del tipo solicitado.
