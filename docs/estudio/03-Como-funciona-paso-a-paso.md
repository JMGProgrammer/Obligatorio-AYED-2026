# 3. Cómo funciona paso a paso

## Crear el nodo (lo esencial)

```java
// 1) Crear la lista de hijos (vacía si es hoja).
ArrayList<NodoEmpleado> hijos = new ArrayList<NodoEmpleado>();

// 2) Crear el nodo.
NodoEmpleado nodo = new NodoEmpleado(empleado, jefe, hijos, nivel);

// 3) Agregarlo a la lista de hijos de su jefe.
jefe.getSubordinados().add(nodo);
```

No hay `izq` ni `der`. El "lugar" del nodo lo da su pertenencia a la
lista `aSubordinados` de su jefe.

## Crear la raíz

```java
arbol.CrearRaiz(emp);   // jefe = null, nivel = 0, hijos = lista vacía
```

## Insertar un hijo

```java
arbol.Insertar(hijo, 1000);   // 1000 = legajo del jefe
```

Internamente: busca el jefe (DFS), verifica legajo no repetido, crea el
nodo con nivel = jefe.getNivel() + 1 y lo agrega a la lista.

## Recorrer los hijos

```java
NodoEmpleado actual = arbol.getRaiz();
for (int i = 0; i < actual.getSubordinados().size(); i++) {
    NodoEmpleado hijo = actual.getSubordinados().get(i);
    System.out.println(hijo.getEmpleado().getNombreCompleto());
}
```

## Hoja vs nodo con hijos

```java
// Hoja: lista vacía.
NodoEmpleado hoja = new NodoEmpleado(emp, jefe, new ArrayList<NodoEmpleado>(), nivel);
// Atajo:
NodoEmpleado hoja2 = NodoEmpleado.crearHoja(emp, jefe, nivel);
```

## Recursividad: estructura general

Todo método recursivo tiene:
1. **Caso base** que detiene las llamadas.
2. **Paso recursivo** que avanza hacia un caso más pequeño.

En un árbol: caso base = `null` o hoja; paso recursivo = aplicar a
cada hijo.

## Búsqueda DFS por legajo — O(n)

```java
if (pActual == null) return null;                       // caso base 1
if (pActual.getEmpleado().getId() == pId) return pActual; // caso base 2
for (...) {
    NodoEmpleado encontrado = BuscarPorIdRecursivo(hijo, pId);
    if (encontrado != null) return encontrado;          // se detiene al encontrar
}
return null;
```

## Recorrido preorden

Procesar el nodo actual, luego cada hijo recursivamente. "Pre" porque el
nodo se procesa **antes** que sus hijos.

## Contar subordinados — O(k)

```java
int cantidad = pActual.getSubordinados().size(); // directos
for (...) cantidad += ContarSubordinadosRecursivo(hijo);
```

## Masa salarial — O(k)

```java
double total = pActual.getEmpleado().getSalario();
for (...) total += CalcularMasaSalarialRecursiva(hijo);
```

## Cadena de mando — O(h)

Sube por `jefe` hasta `null`:

```java
if (pActual.getJefe() == null) return nombre; // caso base: raíz
return nombre + " <- " + ObtenerCadenaRecursiva(pActual.getJefe());
```

## Altura — O(n)

```java
if (pActual == null) return 0;
int mayor = 0;
for (...) mayor = max(mayor, CalcularAlturaRecursiva(hijo));
return mayor + 1;
```

Vacío = 0, hoja = 1, interno = 1 + mayor altura de hijos.

## Empleados de un nivel — O(n)

Recorre todo el árbol y agrega los que tienen `aNivel == pNivel`.

## Reasignación — O(n) + O(k)

1. Buscar empleado y nuevo jefe.
2. Validar (existen, no es raíz, no es sí mismo).
3. Verificar que el nuevo jefe no esté en el subárbol del empleado.
4. Quitar de la lista del jefe anterior.
5. Cambiar referencia `aJefe`.
6. Agregar a la lista del nuevo jefe.
7. `ActualizarNivelesRecursivo` sobre el subárbol.

## Prevención de ciclos

```java
private boolean EstaEnSubarbolRecursivo(NodoEmpleado pActual, NodoEmpleado pBuscado) {
    if (pActual == pBuscado) return true;
    for (...) if (EstaEnSubarbolRecursivo(hijo, pBuscado)) return true;
    return false;
}
```

## Jefe común más cercano (LCA) — O(n) + O(h)

1. Buscar ambos nodos.
2. Subir el más profundo hasta igualar niveles.
3. Subir ambos simultáneamente.
4. El primer nodo donde coinciden es el ancestro común más cercano.

Ejemplos: Martín + Sofía → Ana; Martín + Lucía → Diego; Martín + Jorge → Laura.