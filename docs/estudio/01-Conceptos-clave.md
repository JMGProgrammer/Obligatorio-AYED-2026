# 1. Conceptos clave

## ¿Qué es un árbol N-ario?

Estructura jerárquica donde **cada nodo puede tener cualquier cantidad de
hijos** (no solo dos, como en el binario). En NovaTech cada nodo es un
empleado y sus hijos son sus subordinados directos.

## Vocabulario (saberlo de memoria)

| Concepto | Significado en el organigrama |
|---|---|
| Nodo | Un empleado (`NodoEmpleado`) |
| Raíz | Gerente General (Laura). Sin jefe. Nivel 0. |
| Padre / jefe | Nodo inmediatamente superior |
| Hijo / subordinado directo | Nodo inmediatamente inferior |
| Descendiente | Subordinado directo o indirecto |
| Hoja | Empleado sin subordinados |
| Subárbol | Un nodo junto con todos sus descendientes |
| Nivel | Distancia desde la raíz (raíz = 0) |
| Altura | Cantidad máxima de niveles (hoja = 1) |

## Por qué N-ario y no binario

Binario: máximo 2 hijos (`izq`, `der`). Un jefe puede tener 3, 5 o 10
subordinados. No alcanza. Por eso se usa una lista:

```java
private ArrayList<NodoEmpleado> aSubordinados;
```

## Árbol vs lista

- Lista: orden lineal, un solo "siguiente".
- Árbol: jerarquía, un nodo puede tener varios "siguientes" (hijos).

## Propiedad clave: terminación

Los recorridos recursivos terminan porque:
- Hacia abajo: cada llamada avanza hacia un hijo; las hojas no generan
  nuevas llamadas.
- Hacia arriba: se detiene al llegar a la raíz (`jefe == null`).

La prevención de ciclos es fundamental para conservar esta propiedad.
Si se formara un ciclo, la recursión nunca terminaría.

## Separación Empleado / NodoEmpleado

- `Empleado` = la persona (id, nombre, cargo, salario, ...).
- `NodoEmpleado` = su posición en el árbol (jefe, hijos, nivel).

Frase defendible: "Empleado representa a la persona y NodoEmpleado
representa su ubicación dentro del organigrama."

## ArrayList: operaciones usadas

```java
aSubordinados.add(nodo);      // agregar un hijo
aSubordinados.get(i);         // obtener el hijo en posición i
aSubordinados.size();         // cantidad de hijos directos
aSubordinados.remove(nodo);   // quitar un hijo
```

## Regla de oro

> El nodo NO sabe cuántos hijos tendrá. La lista crece con `add`.
> Esto es lo que permite "cualquier cantidad de subordinados".