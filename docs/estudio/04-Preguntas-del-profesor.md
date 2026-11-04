# 4. Preguntas del profesor (con respuesta lista)

## Sobre la estructura

**¿Por qué utilizaron un árbol?**
Porque la empresa tiene estructura jerárquica con una única raíz. Cada
empleado (salvo el Gerente General) tiene un único jefe y puede tener
subordinados.

**¿Por qué es N-ario y no binario?**
Porque un jefe puede tener más de dos subordinados. La lista
`aSubordinados` permite almacenar cualquier cantidad de hijos.

**¿Qué es la raíz?**
El primer nodo del árbol: Gerente General, nivel 0, `jefe = null`. No es
una clase especial, es un `NodoEmpleado` normal guardado en `aRaiz`.

**¿Qué representa un nodo?**
La ubicación de un empleado dentro del organigrama: contiene al empleado, su
jefe, sus subordinados y su nivel.

**¿Por qué separaron Empleado de NodoEmpleado?**
Para separar datos laborales de la posición estructural. Empleado = persona;
NodoEmpleado = ubicación en el árbol.

**¿Qué diferencia hay entre nivel jerárquico y nivel del árbol?**
El nivel jerárquico pertenece al cargo (tipo de responsabilidad: 1
Dirección, 2 Supervisión, 3 Operativo). El nivel del árbol pertenece al
nodo (distancia real desde la raíz).

## Sobre recursividad

**¿Qué es un caso base?**
La condición que detiene las llamadas recursivas. Ej.: nodo `null` o id
coincidente en la búsqueda.

**¿Qué es el paso recursivo?**
La llamada del método sobre una parte más pequeña. En el árbol: ejecutar
el método para cada subordinado.

**¿Por qué la búsqueda es DFS?**
Porque profundiza en el subárbol de un hijo antes de continuar con el
siguiente hijo del mismo nivel.

**¿Cómo cuentan subordinados totales?**
Se empieza con la cantidad de hijos directos y se suma recursivamente la
cantidad de descendientes de cada hijo.

**¿Cómo calculan la masa salarial?**
Se toma el salario del empleado actual y se suma la masa salarial calculada
recursivamente para cada subordinado.

## Sobre nivel y altura

**¿Qué representa la altura?**
La cantidad máxima de niveles del árbol. Hoja = 1, árbol vacío = 0.

**¿Qué representa el nivel?**
La profundidad de un nodo desde la raíz. Raíz = 0; cada hijo = nivel del
jefe + 1.

**¿Por qué deben actualizar niveles al reasignar?**
Porque al mover un empleado también se mueve todo su subárbol. Todos los
descendientes cambian su distancia a la raíz.

## Sobre reasignación y ciclos

**¿Cómo impiden un ciclo?**
Antes de reasignar se busca recursivamente si el nuevo jefe ya pertenece
al subárbol del empleado. Si pertenece, se rechaza.

**¿Qué ocurriría si existiera un ciclo?**
La estructura dejaría de ser árbol y algunos recorridos recursivos podrían
no terminar.

## Sobre cadenas y jefe común

**¿Cómo se obtiene la cadena de mando?**
Se comienza en el empleado y se sigue recursivamente la referencia al jefe
hasta la raíz (`jefe == null`).

**¿Cómo encuentran el jefe común más cercano?**
Primero se igualan los niveles de ambos nodos. Luego se suben
simultáneamente hasta que ambos apuntan al mismo nodo.

## Sobre bajas y validaciones

**¿Qué regla eligieron para la baja?**
Impedir eliminar un empleado con subordinados. También se protege la raíz
y los responsables de departamentos o proyectos.

**¿Qué pasa con las asignaciones al eliminar un empleado válido?**
Se eliminan de la lista general y de la lista del proyecto correspondiente.

## Sobre datos y persistencia

**¿Por qué los datos se pierden al cerrar?**
Porque se almacenan únicamente en memoria y el alcance no incluye BD ni
archivos.

**¿Por qué las fechas son String?**
Porque el proyecto está centrado en árboles y recursividad. Guardarlas como
texto evita agregar una API no necesaria.

**¿Para qué se usa `Scanner.nextLine()` después de `nextInt()`?**
Para consumir el salto de línea que queda pendiente después de leer un
número. De lo contrario, una lectura de texto posterior puede quedar vacía.