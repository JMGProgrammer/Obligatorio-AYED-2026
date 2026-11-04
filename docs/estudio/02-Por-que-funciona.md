# 2. Por qué funciona

## Por qué un árbol y no una lista

La empresa tiene una jerarquía con una única raíz. Cada empleado (salvo el
Gerente General) tiene un único jefe y puede tener varios subordinados.
Eso es exactamente la definición de árbol: un nodo padre con N hijos.

## Por qué N-ario y no binario

Un árbol binario limita a 2 hijos (`izq`, `der`). En NovaTech un gerente
puede tener 3 gerencias. Con `izq`/`der` no se puede. La lista
`aSubordinados` permite cualquier cantidad y crece dinámicamente con
`add`.

## Por qué la recursión termina

- Hacia abajo: el caso base es `null` o una hoja (lista vacía). Cada
  llamada avanza hacia un hijo, que es "más pequeño" (menos nodos por
  visitar). Eventually llega a hoja/null.
- Hacia arriba: caso base `jefe == null` (raíz). Cada llamada sube un
  nivel. Eventually llega a la raíz.

## Por qué se separan Empleado y NodoEmpleado

Para separar dos responsabilidades:
- `Empleado` = datos laborales (persona).
- `NodoEmpleado` = posición estructural (jefe, hijos, nivel).

Ventaja: se puede cambiar la estructura (mover un empleado) sin tocar sus
datos, y viceversa. También facilita razonar sobre el árbol sin mezclarlo
con lógica de negocio.

## Por qué se recalculan niveles al reasignar

Al mover un empleado se mueve todo su subárbol. Si solo se cambia el nivel
del empleado, sus descendientes quedan con niveles incorrectos (su
distancia a la raíz cambió). Por eso `ActualizarNivelesRecursivo` recorre
todo el subárbol sumando 1 por nivel.

## Por qué se impide la baja con subordinados

Para no dejar nodos "huérfanos" ni romper la jerarquía. La regla es simple,
verificable y evita cambios involuntarios. Alternativa (reasignar
automáticamente) fue descartada por seguridad.

## Por qué se previenen ciclos

Si Diego está bajo Laura y se mueve Laura bajo Diego, se forma
`Diego -> Laura -> Diego -> ...`. La estructura deja de ser árbol, las
búsquedas recursivas no terminan y el sistema se cuelga. Por eso antes de
reasignar se verifica que el nuevo jefe NO esté en el subárbol del empleado
movido.

## Por qué las fechas son String

Para mantener el código dentro de los contenidos trabajados y evitar APIs
innecesarias. El foco del obligatorio es árboles y recursividad, no fechas.

## Por qué no hay persistencia

El alcance académico pide consola y memoria. Agregar BD/archivos desvía el
foco y complica la defensa. Los datos se precargan al iniciar.