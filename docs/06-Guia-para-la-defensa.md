# 6. Guía para la defensa oral

## 6.1 Objetivo

La defensa debe demostrar que el grupo comprende la estructura utilizada, las decisiones adoptadas y el comportamiento de los algoritmos. No es suficiente ejecutar las opciones; cada integrante debe poder explicar qué sucede internamente.

## 6.2 Presentación sugerida

### Parte 1 — Problema y modelo

Explicar brevemente:

- qué necesidad tiene NovaTech;
- por qué la jerarquía se representa con un árbol;
- por qué el árbol es N-ario;
- quién ocupa la raíz;
- qué representan los hijos de un nodo.

### Parte 2 — Arquitectura

Mostrar el diagrama UML y explicar:

- `Principal` para consola;
- `Controladora` para coordinación y validaciones;
- entidades para datos;
- `NodoEmpleado` para la posición jerárquica;
- `ArbolOrganigrama` para algoritmos estructurales.

### Parte 3 — Demostración

Orden recomendado:

1. Mostrar el organigrama.
2. Buscar un empleado.
3. Contar subordinados.
4. Calcular masa salarial.
5. Mostrar cadena de mando.
6. Reasignar un subárbol.
7. Demostrar la actualización de niveles.
8. Intentar una reasignación que forme un ciclo.
9. Mostrar proyectos y horas.

### Parte 4 — Algoritmos

Elegir al menos dos métodos recursivos y seguir sus llamadas utilizando un ejemplo pequeño.

## 6.3 Preguntas y respuestas sugeridas

### ¿Por qué utilizaron un árbol?

Porque la empresa posee una estructura jerárquica con una única raíz. Cada empleado, excepto el Gerente General, tiene un único jefe y puede tener subordinados.

### ¿Por qué es N-ario y no binario?

Porque un jefe puede tener más de dos subordinados. La lista `aSubordinados` permite almacenar cualquier cantidad de hijos.

### ¿Qué es la raíz?

Es el primer nodo del árbol. Representa al Gerente General, tiene nivel 0 y su referencia a jefe es `null`.

### ¿Qué representa un nodo?

Representa la ubicación de un empleado dentro del organigrama. Contiene al empleado, su jefe, su lista de subordinados y su nivel.

### ¿Por qué separaron Empleado de NodoEmpleado?

Para separar los datos laborales de la estructura del árbol. `Empleado` representa a la persona; `NodoEmpleado` representa su posición jerárquica.

### ¿Qué significa legajo?

Es el identificador único del empleado dentro de la empresa. En el código corresponde a `Empleado.aId`.

### ¿Qué diferencia existe entre nivel jerárquico y nivel del árbol?

El nivel jerárquico pertenece al cargo y clasifica el tipo de responsabilidad. El nivel del árbol pertenece al nodo e indica su distancia desde la raíz.

### ¿Qué es un caso base?

Es la condición que detiene las llamadas recursivas. Por ejemplo, en una búsqueda se detiene al encontrar `null` o el legajo buscado.

### ¿Qué es el paso recursivo?

Es la llamada del método sobre una parte más pequeña del problema. En este árbol consiste en ejecutar el método para cada subordinado.

### ¿Cómo funciona la búsqueda por legajo?

Compara el nodo actual. Si coincide, lo retorna. En caso contrario busca recursivamente en cada subárbol hasta encontrarlo o agotar todos los nodos.

### ¿Por qué se considera DFS?

Porque profundiza en el subárbol de un hijo antes de continuar con el siguiente hijo del mismo nivel.

### ¿Cómo cuentan subordinados totales?

Se comienza con la cantidad de hijos directos y se suma recursivamente la cantidad de descendientes de cada hijo.

### ¿Cómo calculan la masa salarial?

Se toma el salario del empleado actual y se suma la masa salarial calculada recursivamente para cada subordinado.

### ¿Qué representa la altura?

La cantidad máxima de niveles del árbol. Una hoja tiene altura 1 y el árbol vacío altura 0.

### ¿Qué representa el nivel?

La profundidad de un nodo desde la raíz. La raíz está en nivel 0 y cada hijo tiene el nivel de su jefe más uno.

### ¿Por qué deben actualizar niveles al reasignar?

Porque al mover un empleado también se mueve todo su subárbol. Todos los descendientes cambian su distancia respecto de la raíz.

### ¿Cómo impiden un ciclo?

Antes de reasignar se busca si el nuevo jefe ya pertenece al subárbol del empleado. Si pertenece, la operación se rechaza.

### ¿Qué ocurriría si existiera un ciclo?

La estructura dejaría de ser un árbol y algunos recorridos recursivos podrían no terminar.

### ¿Cómo se obtiene la cadena de mando?

Se comienza en el empleado y se sigue recursivamente la referencia al jefe hasta alcanzar la raíz, cuyo jefe es `null`.

### ¿Cómo encuentran el jefe común más cercano?

Primero se igualan los niveles de ambos nodos. Luego se suben simultáneamente hasta que ambos apuntan al mismo nodo.

### ¿Qué regla eligieron para la baja?

Se impide eliminar un empleado con subordinados. También se protege la raíz y los responsables de departamentos o proyectos.

### ¿Qué pasa con las asignaciones al eliminar un empleado válido?

Se eliminan de la lista general y de la lista del proyecto correspondiente.

### ¿Por qué los datos se pierden al cerrar?

Porque se almacenan únicamente en memoria y el alcance no incluye base de datos ni archivos.

### ¿Por qué las fechas son String?

Porque el proyecto está centrado en árboles y recursividad. Guardarlas como texto evita agregar una API no necesaria para los objetivos evaluados.

### ¿Para qué se usa `Scanner.nextLine()` después de `nextInt()`?

Para consumir el salto de línea que queda pendiente después de leer un número. De lo contrario, una lectura de texto posterior puede quedar vacía.

## 6.4 Seguimiento manual de una búsqueda

Buscar el legajo `1006`, correspondiente a Lucía:

```text
Buscar(Laura, 1006)
├── Laura no coincide
└── Buscar(Diego, 1006)
    ├── Diego no coincide
    └── Buscar(Ana, 1006)
        ├── Ana no coincide
        ├── Buscar(Martín, 1006) -> null
        └── Buscar(Sofía, 1006) -> null
    └── Buscar(Pablo, 1006)
        ├── Pablo no coincide
        └── Buscar(Lucía, 1006) -> encontrada
```

## 6.5 Seguimiento manual del conteo

Contar subordinados de Ana:

```text
Ana tiene 2 hijos directos: Martín y Sofía.
Martín tiene 0 hijos.
Sofía tiene 0 hijos.

Resultado = 2 + 0 + 0 = 2.
```

## 6.6 Seguimiento manual de masa salarial

Rama de Ana:

```text
Masa(Ana)
= salario Ana + Masa(Martín) + Masa(Sofía)
= 125000 + 92000 + 91000
= 308000
```

## 6.7 Distribución posible de la exposición

### Integrante 1

- problema;
- entidades;
- arquitectura;
- árbol N-ario.

### Integrante 2

- búsqueda DFS;
- preorden;
- subordinados y masa salarial.

### Integrante 3

- reasignación;
- prevención de ciclos;
- altura, nivel y jefe común.

### Integrante 4, si corresponde

- ABM;
- proyectos y asignaciones;
- validaciones y pruebas.

Todos deben conocer la solución completa aunque se dividan la presentación.

## 6.8 Recomendaciones para la demostración

- Compilar antes de comenzar.
- Utilizar los legajos precargados.
- Tener preparada una secuencia corta de opciones.
- No improvisar datos numéricos difíciles de recordar.
- Mostrar al menos una validación rechazada.
- Explicar el resultado antes de ejecutar la opción.
- Evitar modificar demasiados datos antes de las capturas principales.
- Si se necesita volver al estado inicial, cerrar y reiniciar la aplicación.

## 6.9 Aspectos que deben confirmar con el docente

- aceptación de la separación entre `Empleado` y `NodoEmpleado`;
- formato final de PRE y POST;
- criterio exacto para la altura: niveles o aristas;
- si el desafío del jefe común es obligatorio para todos los grupos;
- formato solicitado para el UML y el PDF.
