# 5. Preguntas avanzadas (para lucirse y acortar la defensa)

Si demostramos dominio de estos puntos desde el inicio, el profesor reduce
la defensa a 2 preguntas máximo.

## Para mostrar que sabemos de sobra

1. **Trazar una búsqueda a mano**: tomar legajo 1006 (Lucía) y recorrer
   Laura → Diego → Ana → Martín/Sofía (null) → Pablo → Lucía. Explicar
   que se detiene al encontrar y no sigue ramas restantes.

2. **Explicar el conteo con ejemplo**: subordinados de Diego = 2 directos
   (Ana, Pablo) + 2 de Ana + 1 de Pablo = 5.

3. **Masa salarial con ejemplo**: Diego 155000 + Ana 125000 + Martín 92000
   + Sofía 91000 + Pablo 123000 + Lucía 97000 = 683000.

4. **Explicar la reasignación con actualización de niveles**: mover Ana
   (1002) bajo Jorge (1008) → Ana nivel 2→3, Martín/Sofía 3→4, altura
   4→5. Demuestra que se mueve el subárbol completo.

5. **Demostrar el rechazo de ciclo**: intentar mover Diego bajo Martín
   → rechazado porque Martín está en el subárbol de Diego.

6. **Explicar LCA con ejemplo**: Martín + Jorge → Laura (igualar niveles
   y subir simultáneamente).

## Preguntas avanzadas que podría hacer

- **¿Qué complejidad tiene mostrar el organigrama?**
  O(n) base, pero O(n²) en el peor caso porque recalcula descendientes
  para cada nodo.

- **¿Por qué el conteo es O(k) y no O(n)?**
  Porque solo recorre el subárbol consultado, no todo el árbol.

- **¿Qué pasaría si un empleado tuviera 1000 subordinados?**
  La lista crece dinámicamente; no hay límite fijo. La búsqueda sigue
  siendo O(n) en el peor caso.

- **¿Cómo se evita duplicar un legajo al insertar?**
  Se busca primero en el árbol; si existe, se rechaza la inserción.

- **¿Qué es un subárbol?**
  Un nodo junto con todos sus descendientes. Al reasignar se mueve el
  subárbol completo.

- **¿Por qué `jefe` es `null` solo en la raíz?**
  Porque no existe nodo superior al Gerente General. Es el caso base de
  la cadena de mando.

- **¿Cómo se actualiza el nivel de la raíz si se moviera?**
  No se puede mover la raíz (regla de negocio). Siempre queda en nivel 0.

- **¿Qué diferencia hay entre `getSubordinados().size()` y subordinados totales?**
  `size()` = hijos directos. Subordinados totales = directos + indirectos
  (recursivo).

## Estrategia para que nos hagan solo 2 preguntas

- Arrancar explicando el modelo (árbol N-ario, raíz, nodo) sin que pregunten.
- Mostrar un trazado a mano antes de ejecutar.
- Mencionar complejidades al hablar de cada algoritmo.
- Anticipar la validación de ciclos y el recálculo de niveles.
- Si el profesor ve dominio, pasa a la siguiente sección o cierra.