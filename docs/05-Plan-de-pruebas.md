# 5. Plan de pruebas

## 5.1 Objetivo

El plan verifica que las operaciones produzcan los resultados esperados y que las validaciones protejan la estructura y las relaciones entre entidades.

## 5.2 Criterios generales

- Ejecutar las pruebas desde una nueva instancia de `Controladora` cuando se necesiten los datos iniciales.
- Registrar resultado esperado y obtenido.
- Tomar capturas de las funcionalidades principales.
- Repetir la compilación antes de la entrega.

## 5.3 Pruebas de precarga

| Id | Prueba | Resultado esperado |
|---|---|---|
| P01 | Iniciar aplicación | Menú principal visible |
| P02 | Listar empleados | 12 empleados |
| P03 | Listar departamentos | 4 departamentos |
| P04 | Listar cargos | 7 cargos |
| P05 | Listar proyectos | 2 proyectos |
| P06 | Listar asignaciones | 5 asignaciones |

## 5.4 Pruebas del organigrama

| Id | Operación | Entrada | Resultado esperado |
|---|---|---|---|
| A01 | Mostrar organigrama | — | Laura aparece como raíz |
| A02 | Altura inicial | — | 4 |
| A03 | Empleados nivel 0 | 0 | Laura |
| A04 | Empleados nivel 2 | 2 | Ana, Pablo, Jorge, Valentina y Camila |
| A05 | Jefe común | 1003 y 1004 | Ana Rodríguez |
| A06 | Jefe común | 1003 y 1006 | Diego Pérez |
| A07 | Jefe común | 1003 y 1008 | Laura Méndez |

## 5.5 Pruebas de búsqueda

| Id | Operación | Entrada | Resultado esperado |
|---|---|---|---|
| B01 | Buscar legajo existente | 1003 | Martín Silva |
| B02 | Buscar legajo raíz | 1000 | Laura Méndez |
| B03 | Buscar legajo inexistente | 9999 | No se encontró |
| B04 | Buscar apellido existente | Silva | Martín Silva |
| B05 | Buscar apellido inexistente | García | Lista vacía |

## 5.6 Pruebas recursivas

| Id | Operación | Entrada | Resultado esperado |
|---|---|---|---|
| R01 | Subordinados de Laura | 1000 | 11 |
| R02 | Subordinados de Diego | 1001 | 5 |
| R03 | Subordinados de Ana | 1002 | 2 |
| R04 | Subordinados de Martín | 1003 | 0 |
| R05 | Masa salarial de Diego | 1001 | 683000 |
| R06 | Cadena de Martín | 1003 | Martín ← Ana ← Diego ← Laura |
| R07 | Cadena de Laura | 1000 | Laura Méndez |

## 5.7 Pruebas de contratación

### Alta válida

Datos sugeridos:

```text
Legajo: 2000
Nombre: Juan
Apellido: Prueba
Cargo: 4
Departamento: 1
Salario: 90000
Fecha: 02/11/2026
Jefe: 1002
```

Resultado esperado:

- operación realizada;
- empleado visible en búsquedas;
- aparece debajo de Ana;
- nivel 3.

### Legajo repetido

Intentar crear otro empleado con legajo `1003`.

Resultado esperado: operación rechazada.

### Jefe inexistente

Crear un empleado indicando jefe `9999`.

Resultado esperado: operación rechazada.

## 5.8 Pruebas de baja

| Id | Entrada | Condición | Resultado esperado |
|---|---:|---|---|
| D01 | 1000 | Es raíz | Rechazada |
| D02 | 1001 | Tiene subordinados | Rechazada |
| D03 | 1007 | Responsable | Rechazada |
| D04 | 1009 | Hoja no responsable | Aceptada |
| D05 | 9999 | No existe | Rechazada |

Después de D04, Valentina no debe aparecer en búsquedas ni listados.

## 5.9 Pruebas de reasignación

### Reasignación válida

Mover a Ana (`1002`) debajo de Jorge (`1008`).

Resultado esperado:

```text
Ana: nivel 3
Martín: nivel 4
Sofía: nivel 4
Altura total: 5
```

### Intento de ciclo

Después de la operación anterior, intentar mover a Jorge (`1008`) debajo de Martín (`1003`).

Resultado esperado: operación rechazada y árbol sin modificaciones.

### Mover la raíz

Intentar mover a Laura (`1000`) debajo de Diego (`1001`).

Resultado esperado: operación rechazada.

### Empleado como su propio jefe

Intentar mover `1003` debajo de `1003`.

Resultado esperado: operación rechazada.

## 5.10 Pruebas de cargos

| Id | Operación | Resultado esperado |
|---|---|---|
| C01 | Alta con id nuevo y salario positivo | Aceptada |
| C02 | Alta con id repetido | Rechazada |
| C03 | Modificar nombre y salario | Datos actualizados |
| C04 | Eliminar cargo 4, actualmente en uso | Rechazada |
| C05 | Eliminar cargo nuevo sin uso | Aceptada |

## 5.11 Pruebas de departamentos

| Id | Operación | Resultado esperado |
|---|---|---|
| DP01 | Listar empleados de Tecnología | 6 empleados inicialmente |
| DP02 | Eliminar Tecnología | Rechazada |
| DP03 | Alta de departamento nuevo | Aceptada |
| DP04 | Modificar responsable con legajo válido | Aceptada |
| DP05 | Eliminar departamento sin empleados | Aceptada |

## 5.12 Pruebas de proyectos

| Id | Operación | Entrada | Resultado esperado |
|---|---|---|---|
| PR01 | Horas proyecto 1 | 1 | 80 |
| PR02 | Horas proyecto 2 | 2 | 35 |
| PR03 | Estado válido | FINALIZADO | Aceptado |
| PR04 | Estado inválido | PAUSADO | Rechazado |
| PR05 | Asignar empleado nuevo | Datos válidos | Aceptado |
| PR06 | Repetir empleado en proyecto | Mismo empleado/proyecto | Rechazado |
| PR07 | Asignar cero horas | 0 | Rechazado |
| PR08 | Eliminar proyecto | Id existente | Proyecto y asignaciones eliminados |

## 5.13 Registro de ejecución

Completar durante las pruebas finales:

| Id | Resultado obtenido | Estado | Observaciones |
|---|---|---|---|
| P01 |  | Pendiente |  |
| A01 |  | Pendiente |  |
| A02 |  | Pendiente |  |
| B01 |  | Pendiente |  |
| R01 |  | Pendiente |  |
| R05 |  | Pendiente |  |
| D02 |  | Pendiente |  |
| D04 |  | Pendiente |  |
| PR01 |  | Pendiente |  |

## 5.14 Verificaciones ya realizadas durante el desarrollo

Durante la preparación del proyecto se verificaron:

- compilación completa con `javac`;
- inicio y cierre de la aplicación;
- alta y búsqueda de un empleado mediante consola;
- conteo de subordinados de Diego igual a 5;
- masa salarial de Diego igual a 683000;
- cadena de mando de Martín;
- reasignación válida de un subárbol;
- actualización de niveles descendientes;
- cambio de altura de 4 a 5;
- rechazo de una reasignación cíclica;
- baja válida de una hoja;
- rechazo de la baja de un cargo en uso;
- horas del proyecto 1 iguales a 80.
