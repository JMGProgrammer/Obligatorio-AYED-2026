# 6. Checklist de defensa

## Antes de empezar

- [ ] Compilar desde carpeta limpia: `cd src && javac Principal.java Dominio/Controladora.java Dominio/Entidades/*.java Dominio/Estructuras/*.java`
- [ ] Ejecutar `java Principal` y verificar menú principal.
- [ ] Tener preparada la secuencia corta de opciones (organigrama, búsqueda, conteo, masa, cadena, reasignación, ciclo, proyectos).
- [ ] Usar los legajos precargados (1000–1011). No improvisar datos difíciles.

## Conceptos que cada integrante debe explicar

- [ ] Raíz, nodo y subordinados.
- [ ] Por qué N-ario y no binario (`ArrayList` vs `izq`/`der`).
- [ ] Caso base y paso recursivo.
- [ ] Seguimiento de una búsqueda recursiva a mano.
- [ ] Una reasignación y el recálculo de niveles.
- [ ] Diferencia entre nivel y altura.
- [ ] Diferencia entre nivel jerárquico y nivel del árbol.
- [ ] Prevención de ciclos.
- [ ] Cadena de mando y jefe común más cercano.

## Durante la demostración

- [ ] Mostrar al menos una validación rechazada (baja con subordinados o ciclo).
- [ ] Explicar el resultado antes de ejecutar la opción.
- [ ] No modificar demasiados datos antes de las capturas principales.
- [ ] Si se necesita volver al estado inicial, cerrar y reiniciar la aplicación.

## Confirmar con el docente

- [ ] Aceptación de la separación `Empleado` / `NodoEmpleado`.
- [ ] Formato final de PRE y POST.
- [ ] Criterio exacto para la altura (niveles o aristas).
- [ ] Si el jefe común es obligatorio para todos los grupos.
- [ ] Formato solicitado para UML y PDF.

## Definición de terminado

El sistema está listo cuando:
- compila y ejecuta desde consola;
- muestra el organigrama precargado;
- realiza los ABM pedidos;
- valida las relaciones entre entidades;
- ejecuta los algoritmos recursivos;
- reasigna subárboles sin formar ciclos;
- calcula subordinados, salarios, altura, niveles y cadenas de mando;
- gestiona proyectos, asignaciones y horas;
- cada integrante puede explicar el código utilizado.