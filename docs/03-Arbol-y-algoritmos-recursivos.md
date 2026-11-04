# 3. Árbol N-ario y algoritmos recursivos

## 3.1 Estructura elegida

El organigrama se representa mediante un árbol N-ario. Cada nodo contiene un empleado y una lista de subordinados. La cantidad de hijos no está limitada a dos.

La raíz representa al Gerente General:

```text
NodoEmpleado raíz
├── empleado = Laura Méndez
├── jefe = null
├── nivel = 0
└── subordinados = [Diego, Carolina, Fernando]
```

Cada subordinado puede ser a su vez la raíz de un subárbol.

## 3.2 Conceptos utilizados

### Nodo

Elemento individual del árbol. En este proyecto es una instancia de `NodoEmpleado`.

### Raíz

Primer nodo del árbol. No tiene jefe y su nivel es cero.

### Padre o jefe

Nodo ubicado inmediatamente por encima de otro.

### Hijo o subordinado directo

Nodo ubicado inmediatamente debajo de otro.

### Descendiente

Subordinado directo o indirecto.

### Hoja

Nodo sin subordinados.

### Subárbol

Un nodo junto con todos sus descendientes.

### Nivel

Distancia desde la raíz. La raíz tiene nivel 0.

### Altura

Cantidad máxima de niveles que contiene el árbol o subárbol. En esta implementación una hoja tiene altura 1.

## 3.3 Recursividad

Un método recursivo se llama a sí mismo para resolver una versión más pequeña del mismo problema. Debe tener:

1. uno o más casos base que detengan las llamadas;
2. un paso recursivo que avance hacia un caso más pequeño.

En un árbol, el caso más pequeño suele ser un nodo `null` o una hoja. El paso recursivo consiste en aplicar el algoritmo a cada hijo.

---

## 3.4 Búsqueda DFS por legajo

### Método público

```java
public NodoEmpleado BuscarPorId(int pId)
```

### Método recursivo

```java
private NodoEmpleado BuscarPorIdRecursivo(
        NodoEmpleado pActual, int pId)
```

### Objetivo

Encontrar el nodo correspondiente a un número de legajo.

### PRE

- `pActual` es `null` o pertenece al organigrama.
- `pId` representa el legajo buscado.

### POST

- Retorna el nodo cuyo empleado tiene el legajo buscado.
- Retorna `null` si el empleado no existe.
- No modifica el árbol.

### Casos base

```java
if (pActual == null) {
    return null;
}

if (pActual.getEmpleado().getId() == pId) {
    return pActual;
}
```

### Paso recursivo

Busca dentro del subárbol de cada subordinado. Cuando encuentra el nodo, lo retorna sin continuar con las ramas restantes.

### Ejemplo resumido

Para buscar a Martín (`1003`):

```text
Laura != 1003
└── Diego != 1003
    └── Ana != 1003
        └── Martín = 1003 -> encontrado
```

### Complejidad

En el peor caso visita todos los empleados: `O(n)`.

---

## 3.5 Búsqueda por apellido

### Objetivo

Encontrar todos los empleados cuyo apellido coincida con el solicitado.

### PRE

- El nodo actual es `null` o pertenece al árbol.
- La lista de resultados está creada.
- El apellido no es `null`.

### POST

- La lista contiene todos los empleados con el apellido buscado.
- Puede quedar vacía si no existen coincidencias.
- El árbol no se modifica.

### Diferencia con la búsqueda por legajo

El legajo es único y permite detenerse en la primera coincidencia. El apellido puede repetirse, por lo que es necesario recorrer todas las ramas.

### Complejidad

Siempre visita el árbol completo: `O(n)`.

---

## 3.6 Recorrido preorden

### Método

```java
private String MostrarPreordenRecursivo(NodoEmpleado pActual)
```

### Objetivo

Construir una representación textual del organigrama, mostrando primero al jefe y después a sus subordinados.

### PRE

- `pActual` no es `null`.
- `pActual` pertenece al organigrama.
- Los niveles del subárbol están actualizados.

### POST

- Retorna el subárbol en recorrido preorden.
- Cada empleado aparece indentado según su nivel.
- Incluye cargo, nivel y subordinados totales.
- No modifica el árbol.

### Orden

```text
1. Procesar el nodo actual.
2. Recorrer el primer hijo.
3. Recorrer el segundo hijo.
4. Continuar con los restantes.
```

Ejemplo:

```text
Laura
    Diego
        Ana
            Martín
            Sofía
        Pablo
            Lucía
    Carolina
        Jorge
        Valentina
    Fernando
        Camila
```

### Complejidad

Visita cada nodo una vez, aunque el listado también calcula subordinados para cada empleado. El recorrido base es `O(n)`; al recalcular descendientes para cada nodo, la visualización completa puede llegar a `O(n²)` en una estructura muy desbalanceada.

---

## 3.7 Conteo de subordinados totales

### Método público

```java
public int ContarSubordinados(int pIdEmpleado)
```

### Método recursivo

```java
private int ContarSubordinadosRecursivo(NodoEmpleado pActual)
```

### PRE

- `pActual` no es `null`.
- `pActual` pertenece al organigrama.

### POST

- Retorna la cantidad de descendientes directos e indirectos.
- Una hoja retorna 0.
- No modifica el árbol.

### Lógica

```text
cantidad = cantidad de hijos directos

por cada hijo:
    cantidad = cantidad + subordinados totales del hijo
```

### Ejemplo con Diego

```text
Hijos directos de Diego: Ana y Pablo = 2
Descendientes de Ana: Martín y Sofía = 2
Descendientes de Pablo: Lucía = 1
Total = 2 + 2 + 1 = 5
```

### Complejidad

`O(k)`, donde `k` es la cantidad de nodos del subárbol consultado.

---

## 3.8 Masa salarial

### Método público

```java
public double CalcularMasaSalarial(int pIdEmpleado)
```

### Método recursivo

```java
private double CalcularMasaSalarialRecursiva(NodoEmpleado pActual)
```

### PRE

- `pActual` no es `null`.
- Todos los empleados del subárbol tienen salario mayor que cero.

### POST

- Retorna el salario del empleado actual más los salarios de todos sus descendientes.
- No modifica salarios ni estructura.

### Lógica

```text
total = salario del empleado actual

por cada subordinado:
    total = total + masa salarial del subordinado
```

### Ejemplo con Diego

```text
Diego   155000
Ana     125000
Martín   92000
Sofía    91000
Pablo   123000
Lucía    97000
----------------
Total   683000
```

### Complejidad

`O(k)`, donde `k` es la cantidad de empleados del subárbol.

---

## 3.9 Cadena de mando

### Método

```java
private String ObtenerCadenaRecursiva(NodoEmpleado pActual)
```

### Objetivo

Construir la ruta desde un empleado hasta el Gerente General.

### PRE

- `pActual` no es `null`.
- El nodo pertenece al árbol.
- Las referencias a jefe son correctas.

### POST

- Retorna una cadena desde el empleado hasta la raíz.
- La raíz aparece al final.
- El árbol no se modifica.

### Caso base

```java
if (pActual.getJefe() == null) {
    return pActual.getEmpleado().getNombreCompleto();
}
```

### Ejemplo

```text
Martín Silva <- Ana Rodríguez <- Diego Pérez <- Laura Méndez
```

### Complejidad

`O(h)`, donde `h` es la cantidad de nodos entre el empleado y la raíz.

---

## 3.10 Altura del organigrama

### Método recursivo

```java
private int CalcularAlturaRecursiva(NodoEmpleado pActual)
```

### PRE

- `pActual` es `null` o pertenece al árbol.

### POST

- Retorna 0 para un árbol vacío.
- Retorna 1 para una hoja.
- Para un nodo interno retorna 1 más la mayor altura de sus hijos.
- No modifica el árbol.

### Lógica

```text
si actual es null:
    retornar 0

mayorAltura = 0

por cada hijo:
    calcular altura del hijo
    conservar la mayor

retornar mayorAltura + 1
```

El organigrama inicial tiene altura 4:

```text
Nivel 0: Laura
Nivel 1: Diego
Nivel 2: Ana
Nivel 3: Martín
```

### Complejidad

`O(n)`.

---

## 3.11 Empleados de un nivel

### Método recursivo

```java
private void EmpleadosDelNivelRecursivo(
        NodoEmpleado pActual,
        int pNivel,
        ArrayList<Empleado> pResultado)
```

### PRE

- La lista de resultados está creada.
- `pNivel` es mayor o igual que cero.
- `pActual` es `null` o pertenece al árbol.

### POST

- La lista contiene todos los empleados del nivel buscado.
- El árbol no se modifica.

### Resultado conocido para nivel 2

```text
Ana Rodríguez
Pablo Gómez
Jorge Núñez
Valentina Rossi
Camila Torres
```

### Complejidad

`O(n)` porque se revisan todos los nodos.

---

## 3.12 Reasignación de un subárbol

### Método

```java
public boolean Reasignar(int pIdEmpleado, int pIdNuevoJefe)
```

### PRE

- El empleado existe.
- El nuevo jefe existe.
- El empleado no es la raíz.
- El empleado no es su propio nuevo jefe.
- El nuevo jefe no pertenece al subárbol del empleado.

### POST si la operación es válida

- El empleado deja de pertenecer a los hijos del jefe anterior.
- Su referencia a jefe apunta al nuevo jefe.
- Aparece en la lista de subordinados del nuevo jefe.
- Todos los niveles de su subárbol quedan actualizados.
- La estructura continúa siendo un árbol.

### POST si la operación es inválida

- Retorna `false`.
- El organigrama no se modifica.

### Pasos

```text
1. Buscar el empleado.
2. Buscar el nuevo jefe.
3. Validar la operación.
4. Quitar del jefe anterior.
5. Cambiar la referencia a jefe.
6. Agregar al nuevo jefe.
7. Actualizar niveles recursivamente.
```

---

## 3.13 Prevención de ciclos

### Método

```java
private boolean EstaEnSubarbolRecursivo(
        NodoEmpleado pActual,
        NodoEmpleado pBuscado)
```

### PRE

- Ambos nodos existen.
- `pActual` pertenece al organigrama.

### POST

- Retorna `true` si `pBuscado` es el nodo actual o uno de sus descendientes.
- Retorna `false` en caso contrario.
- No modifica el árbol.

### Motivo

Si Diego contiene a Ana y Ana contiene a Martín, mover a Diego debajo de Martín produciría:

```text
Diego -> Ana -> Martín -> Diego -> ...
```

La estructura tendría un ciclo, las búsquedas recursivas no terminarían y dejaría de ser un árbol.

---

## 3.14 Actualización recursiva de niveles

### Método

```java
private void ActualizarNivelesRecursivo(
        NodoEmpleado pActual,
        int pNivel)
```

### PRE

- `pActual` no es `null`.
- `pNivel` corresponde al nuevo nivel del nodo.

### POST

- El nodo actual queda en `pNivel`.
- Cada hijo queda un nivel por debajo de su padre.
- Se actualiza todo el subárbol.

### Ejemplo

Si Ana se mueve debajo de Jorge:

```text
Antes:
Ana nivel 2
Martín nivel 3
Sofía nivel 3

Después:
Ana nivel 3
Martín nivel 4
Sofía nivel 4
```

---

## 3.15 Jefe común más cercano

### Método

```java
public Empleado JefeComunMasCercano(
        int pIdPrimero,
        int pIdSegundo)
```

### PRE

- Los dos legajos corresponden a empleados existentes.
- Las referencias a jefe y los niveles son correctos.

### POST

- Retorna el ancestro común más bajo de ambos nodos.
- Retorna `null` si alguno no existe.
- No modifica el árbol.

### Algoritmo

1. Buscar ambos nodos.
2. Subir el nodo de mayor nivel hasta igualar profundidades.
3. Subir ambos nodos simultáneamente.
4. Detenerse cuando las referencias coincidan.

### Ejemplos

```text
Martín + Sofía      -> Ana
Martín + Lucía      -> Diego
Martín + Jorge      -> Laura
```

### Complejidad

Las búsquedas iniciales son `O(n)`. La subida posterior es `O(h)`.

## 3.16 Terminación de los métodos recursivos

Los recorridos hacia abajo terminan porque cada llamada avanza hacia un hijo y el árbol es finito. En las hojas, la lista de subordinados está vacía y no se producen nuevas llamadas.

Los recorridos hacia arriba terminan al encontrar un nodo cuyo jefe es `null`, es decir, la raíz.

La prevención de ciclos es fundamental para conservar esta propiedad de terminación.
