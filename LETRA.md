# OBLIGATORIO AYED 2026 — NOVATECH

## Sistema de Gestión de Organigrama Empresarial

Lenguaje: Java  
Modalidad: aplicación de consola  
Persistencia: datos en memoria

> Este documento acompaña la implementación y explica cómo funciona. El grupo debe estudiar, ejecutar, modificar y poder justificar el código antes de la defensa.

---

## 1. Problema

NovaTech necesita administrar su estructura de empleados. Cada empleado tiene un solo jefe directo y puede tener varios subordinados.

La estructura se representa con un árbol N-ario:

```text
Laura Méndez
├── Diego Pérez
│   ├── Ana Rodríguez
│   │   ├── Martín Silva
│   │   └── Sofía Castro
│   └── Pablo Gómez
│       └── Lucía Fernández
├── Carolina Díaz
│   ├── Jorge Núñez
│   └── Valentina Rossi
└── Fernando López
    └── Camila Torres
```

También se administran departamentos, cargos, proyectos y asignaciones.

## 2. Estructura del proyecto

```text
Obligatorio-AYED-IA/
├── DIAGRAMA-UML.puml
├── LETRA.md
└── src/
    ├── Principal.java
    └── Dominio/
        ├── Controladora.java
        ├── Entidades/
        │   ├── Empleado.java
        │   ├── Departamento.java
        │   ├── Cargo.java
        │   ├── Proyecto.java
        │   └── Asignacion.java
        └── Estructuras/
            ├── NodoEmpleado.java
            └── ArbolOrganigrama.java
```

`DIAGRAMA-UML.puml` contiene el diagrama de clases en formato PlantUML y puede exportarse como imagen para incorporarlo al PDF.

### Principal

- Tiene el método `main`.
- Muestra los menús.
- Lee datos mediante `Scanner`.
- Llama a los métodos de `Controladora` y `ArbolOrganigrama`.

### Controladora

- Crea las listas del sistema.
- Precarga los datos iniciales.
- Implementa las operaciones ABM.
- Valida las relaciones entre entidades.
- Conserva una instancia del árbol completo.

### Entidades

Representan los datos del problema:

- `Empleado`.
- `Departamento`.
- `Cargo`.
- `Proyecto`.
- `Asignacion`.

### Estructuras

Representan el árbol y sus operaciones:

- `NodoEmpleado` guarda la posición de un empleado.
- `ArbolOrganigrama` guarda la raíz y contiene los algoritmos del árbol.

## Convención de nombres utilizada por la cátedra

El código sigue los prefijos indicados por el docente:

```text
a = atributo de una clase
p = parámetro recibido por un método o constructor
```

Ejemplo:

```java
private Empleado aEmpleado;

public void setEmpleado(Empleado pEmpleado) {
    this.aEmpleado = pEmpleado;
}
```

Los métodos de negocio comienzan con mayúscula:

```java
public Empleado BuscarEmpleado(int pId)
public boolean ContratarEmpleado(Empleado pEmpleado, int pIdJefe)
```

Los getters y setters conservan su forma habitual:

```java
getEmpleado()
setEmpleado(...)
```

`main` y `toString` también conservan esos nombres porque Java los reconoce de esa manera.

En `Principal`, el grupo decidió llamar `Scanner` a la variable de entrada. Las lecturas se escriben directamente donde se necesitan:

```java
System.out.print("Legajo: ");
int id = Scanner.nextInt();
Scanner.nextLine(); // Consume el Enter pendiente.
```

No se utilizan métodos auxiliares como `LeerEntero`, `LeerDouble` o `LeerTexto`.

## 3. Decisión: Empleado y NodoEmpleado separados

El enunciado presenta `Empleado` como nodo y menciona allí jefe, subordinados y nivel. En esta implementación se separaron las responsabilidades:

```text
Empleado
├── id, nombre y apellido
├── cargo y departamento
├── salario
└── fecha de ingreso

NodoEmpleado
├── empleado
├── jefe
├── subordinados
└── nivel
```

La información pedida continúa existiendo, pero la estructura del árbol no se mezcla con los datos laborales.

Esta decisión debe poder explicarse en la defensa:

> `Empleado` representa a la persona y `NodoEmpleado` representa su ubicación dentro del organigrama.

## 4. Diferencia entre árbol binario y N-ario

En un árbol binario se usa:

```java
private NodoEmpleado izq;
private NodoEmpleado der;
```

Esto permite como máximo dos hijos.

El organigrama necesita cualquier cantidad de subordinados. Por eso se usa:

```java
    private ArrayList<NodoEmpleado> aSubordinados;
```

Operaciones básicas de `ArrayList` utilizadas:

```java
    aSubordinados.add(nodo);      // Agregar
    aSubordinados.get(i);         // Obtener por posición
    aSubordinados.size();         // Cantidad
    aSubordinados.remove(nodo);   // Quitar
```

Recorrido:

```java
for (int i = 0; i < actual.getSubordinados().size(); i++) {
    NodoEmpleado hijo = actual.getSubordinados().get(i);
}
```

## 5. Qué es la raíz

La raíz es el primer nodo del árbol:

```java
    private NodoEmpleado aRaiz;
```

En este sistema la raíz es Laura Méndez, Gerente General.

Sus valores estructurales son:

```text
jefe = null
nivel = 0
```

No existe una clase especial para la raíz. Es un `NodoEmpleado` normal guardado en una variable que indica dónde comienza el árbol.

Todas las búsquedas y recorridos completos comienzan en la raíz.

## 6. Entidades

### Empleado

```text
id
nombre
apellido
cargo
departamento
salario
fechaIngreso
```

La fecha se guarda como `String` porque el objetivo central es practicar árboles y recursividad.

### Cargo

```text
id
nombre
nivelJerarquico
salarioBase
```

`nivelJerarquico` indica el tipo de responsabilidad del puesto:

```text
1 = Dirección
2 = Supervisión
3 = Operativo
```

No debe confundirse con `NodoEmpleado.nivel`, que indica la profundidad real dentro del árbol.

### Departamento

```text
id
nombre
descripcion
responsable
```

`responsable` es una referencia a un objeto `Empleado`.

### Proyecto

```text
id
nombre
fechaInicio
fechaFin
estado
responsable
asignaciones
```

Estados aceptados:

```text
PLANIFICADO
EN_CURSO
FINALIZADO
```

### Asignacion

Relaciona un empleado con un proyecto:

```text
id
empleado
proyecto
horasAsignadas
rol
```

## 7. Cómo se crea el sistema

En `Principal` se ejecuta:

```java
static Controladora controladora = new Controladora();
```

El constructor de `Controladora`:

```java
public Controladora() {
    this.aOrganigrama = new ArbolOrganigrama();
    this.aDepartamentos = new ArrayList<Departamento>();
    this.aCargos = new ArrayList<Cargo>();
    this.aProyectos = new ArrayList<Proyecto>();
    this.aAsignaciones = new ArrayList<Asignacion>();
    PrecargarDatos();
}
```

Orden de precarga:

```text
1. Cargos
2. Departamentos
3. Gerente General
4. Demás empleados, siempre después de sus jefes
5. Responsables de departamentos
6. Proyectos
7. Asignaciones
```

El orden importa porque no se puede crear un empleado si todavía no existen su cargo, departamento o jefe.

## 8. Inserción de un empleado

Para contratar un empleado:

1. Se valida que no sea `null`.
2. Se verifica que tenga cargo, departamento y salario válido.
3. Se busca recursivamente el jefe.
4. Se comprueba que el legajo no esté repetido.
5. Se crea un `NodoEmpleado`.
6. Su nivel se calcula como `nivel del jefe + 1`.
7. Se agrega a la lista de subordinados del jefe.

Fragmento principal:

```java
NodoEmpleado nuevo = new NodoEmpleado(
        empleado, jefe, subordinados, jefe.getNivel() + 1);

jefe.getSubordinados().add(nuevo);
```

## 9. Algoritmos recursivos

### 9.1 Búsqueda DFS por legajo

```text
Caso base 1: actual es null -> no se encontró.
Caso base 2: el id actual coincide -> se encontró.
Paso recursivo: buscar dentro de cada subordinado.
```

PRE:

```text
El nodo actual es null o pertenece al árbol.
```

POST:

```text
Devuelve el nodo buscado o null si no existe.
```

### 9.2 Recorrido preorden

Orden:

```text
1. Mostrar el empleado actual.
2. Recorrer cada subordinado.
3. Mostrar recursivamente su subárbol.
```

Se llama preorden porque el nodo se procesa antes que sus hijos.

PRE:

```text
El nodo actual existe y pertenece al árbol.
```

POST:

```text
Devuelve un texto con todos los nodos del subárbol en preorden.
```

### 9.3 Contar subordinados

```java
int cantidad = actual.getSubordinados().size();

for (int i = 0; i < actual.getSubordinados().size(); i++) {
    cantidad = cantidad
            + ContarSubordinadosRecursivo(actual.getSubordinados().get(i));
}
```

Primero cuenta los subordinados directos. Después suma los descendientes de cada subordinado.

PRE:

```text
El nodo actual existe y pertenece al árbol.
```

POST:

```text
Devuelve la cantidad de descendientes directos e indirectos.
```

### 9.4 Masa salarial

Comienza con el salario actual:

```java
double total = actual.getEmpleado().getSalario();
```

Después suma recursivamente la masa salarial de cada hijo.

PRE:

```text
El nodo existe y todos los salarios del subárbol son válidos.
```

POST:

```text
Devuelve el salario del empleado y el de todos sus descendientes.
```

### 9.5 Cadena de mando

Utiliza la referencia `jefe` para subir hasta la raíz:

```text
Martín Silva <- Ana Rodríguez <- Diego Pérez <- Laura Méndez
```

Caso base:

```java
if (actual.getJefe() == null) {
    return actual.getEmpleado().getNombreCompleto();
}
```

### 9.6 Altura

- Un árbol vacío tiene altura `0`.
- Una hoja tiene altura `1`.
- Un nodo interno tiene `1 + mayor altura de sus hijos`.

El organigrama inicial tiene altura `4` porque contiene los niveles 0, 1, 2 y 3.

### 9.7 Empleados de un nivel

Recorre todo el árbol y agrega solamente los empleados cuyo nivel coincide con el solicitado.

### 9.8 Actualización de niveles

Al cambiar un empleado de jefe, se mueve todo su subárbol. Por eso no alcanza con modificar el nivel del empleado: también deben cambiar todos sus descendientes.

```java
private void ActualizarNivelesRecursivo(NodoEmpleado pActual, int pNivel) {
    pActual.setNivel(pNivel);

    for (int i = 0; i < pActual.getSubordinados().size(); i++) {
        ActualizarNivelesRecursivo(
                pActual.getSubordinados().get(i), pNivel + 1);
    }
}
```

### 9.9 Prevención de ciclos

No puede colocarse un jefe debajo de uno de sus propios subordinados.

Ejemplo inválido:

```text
Diego
└── Ana
    └── Martín
```

No se puede mover a Diego debajo de Martín. Eso formaría un ciclo y la estructura dejaría de ser un árbol.

Antes de mover se busca recursivamente si el nuevo jefe pertenece al subárbol que se intenta mover.

### 9.10 Jefe común más cercano

Algoritmo:

1. Buscar los dos nodos.
2. Subir el nodo más profundo hasta igualar niveles.
3. Subir ambos nodos al mismo tiempo.
4. El primer nodo donde coinciden es el ancestro común más cercano.

Ejemplo:

```text
Martín + Sofía -> Ana
Martín + Lucía -> Diego
Martín + Jorge -> Laura
```

## 10. Regla elegida para la baja

El enunciado permite impedir la baja o Reasignar automáticamente.

La implementación elige:

> No se puede Eliminar un empleado que tenga subordinados.

Tampoco se permite Eliminar:

- al Gerente General;
- un responsable de departamento;
- un responsable de proyecto.

Si se elimina un empleado válido, también se quitan sus asignaciones a proyectos.

Esta regla se eligió porque es más segura y sencilla de explicar.

## 11. Validaciones importantes

### Empleados

- Legajo no repetido.
- Jefe existente.
- Cargo existente.
- Departamento existente.
- Salario mayor que cero.
- No formar ciclos al Reasignar.

### Cargos

- Id no repetido.
- Nivel jerárquico y salario base positivos.
- No Eliminar un cargo utilizado por empleados.

### Departamentos

- Id no repetido.
- Responsable existente.
- No Eliminar si todavía contiene empleados.

### Proyectos

- Id no repetido.
- Responsable existente.
- Estado válido.
- Al Eliminar, también se eliminan sus asignaciones.

### Asignaciones

- Id no repetido.
- Empleado y proyecto existentes.
- Horas mayores que cero.
- No repetir al mismo empleado dentro del mismo proyecto.

## 12. Correspondencia con los requisitos

| Requisito | Implementación |
|---|---|
| Árbol N-ario | `NodoEmpleado.subordinados` |
| Raíz única | `ArbolOrganigrama.raiz` |
| Mostrar organigrama | `MostrarOrganigrama` |
| Contratar | `ContratarEmpleado` + `Insertar` |
| Baja validada | `BajaEmpleado` + `Eliminar` |
| Modificar empleado | `ModificarEmpleado` |
| Reasignar | `Reasignar` |
| Buscar por legajo | `BuscarPorIdRecursivo` |
| Buscar por apellido | `BuscarPorApellidoRecursivo` |
| Contar subordinados | `ContarSubordinadosRecursivo` |
| Masa salarial | `CalcularMasaSalarialRecursiva` |
| Cadena de mando | `ObtenerCadenaRecursiva` |
| Altura | `CalcularAlturaRecursiva` |
| Empleados por nivel | `EmpleadosDelNivelRecursivo` |
| Jefe común | `JefeComunMasCercano` |
| ABM de departamentos | Métodos de `Controladora` |
| ABM de cargos | Métodos de `Controladora` |
| ABM de proyectos | Métodos de `Controladora` |
| Asignaciones y horas | `AsignarEmpleadoProyecto` y `CalcularHorasProyecto` |
| Datos precargados | `PrecargarDatos` |

## 13. Datos iniciales

La aplicación comienza con:

- 12 empleados contando al Gerente General;
- 4 niveles de árbol, desde nivel 0 hasta nivel 3;
- 4 departamentos;
- 7 cargos;
- 2 proyectos;
- 5 asignaciones.

Resultados conocidos:

```text
Subordinados totales de Laura: 11
Subordinados totales de Diego: 5
Altura inicial: 4
Masa salarial de la rama de Diego: 683000
Horas del proyecto Migración a la nube: 80
Horas del proyecto Nuevo sistema CRM: 35
```

## 14. Cómo compilar y ejecutar

Desde la raíz del proyecto:

```bash
cd src
javac Principal.java Dominio/Controladora.java Dominio/Entidades/*.java Dominio/Estructuras/*.java
java Principal
```

Para borrar los archivos compilados:

```bash
find . -name '*.class' -delete
```

## 15. Pruebas manuales recomendadas

| Prueba | Entrada | Resultado esperado |
|---|---|---|
| Mostrar organigrama | Menú 1 → 1 | Laura aparece como raíz |
| Buscar empleado | Legajo 1003 | Martín Silva |
| Buscar inexistente | Legajo 9999 | No se encontró |
| Contar subordinados | Legajo 1001 | 5 |
| Masa salarial | Legajo 1001 | 683000 |
| Cadena de mando | Legajo 1003 | Martín ← Ana ← Diego ← Laura |
| Altura | Menú organigrama | 4 |
| Nivel | Nivel 2 | Ana, Pablo, Jorge, Valentina y Camila |
| Jefe común | 1003 y 1004 | Ana Rodríguez |
| Baja inválida | Legajo 1001 | Rechazada porque tiene subordinados |
| Baja válida | Legajo 1009 | Valentina se elimina |
| Ciclo inválido | Diego debajo de Martín | Rechazado |
| Cargo en uso | Eliminar cargo 4 | Rechazado |
| Horas proyecto | Proyecto 1 | 80 |

### Prueba importante de reasignación

Mover a Ana (`1002`) debajo de Jorge (`1008`):

```text
Ana pasa del nivel 2 al nivel 3.
Martín y Sofía pasan del nivel 3 al nivel 4.
La altura cambia de 4 a 5.
```

Esto demuestra que se mueve un subárbol completo y no solamente una persona.

## 16. Orden recomendado para estudiar

No comenzar por `Principal.java`, porque contiene muchos menús.

Orden sugerido:

1. `Empleado.java`.
2. `NodoEmpleado.java`.
3. `ArbolOrganigrama.java` hasta entender búsqueda e inserción.
4. Algoritmos recursivos de `ArbolOrganigrama`.
5. `Cargo`, `Departamento`, `Proyecto` y `Asignacion`.
6. `Controladora.java`.
7. `Principal.java`.

Para estudiar `ArbolOrganigrama`:

```text
CrearRaiz
Insertar
BuscarPorIdRecursivo
MostrarPreordenRecursivo
ContarSubordinadosRecursivo
CalcularMasaSalarialRecursiva
ObtenerCadenaRecursiva
CalcularAlturaRecursiva
Reasignar
ActualizarNivelesRecursivo
JefeComunMasCercano
```

## 17. Preguntas posibles de defensa

### ¿Por qué es un árbol N-ario?

Porque un jefe puede tener cualquier cantidad de subordinados, no solamente dos.

### ¿Qué representa la raíz?

Al Gerente General, que no tiene jefe y se encuentra en el nivel 0.

### ¿Cuál es el caso base de la búsqueda?

Cuando el nodo es `null` o cuando su id coincide con el buscado.

### ¿Por qué la búsqueda es DFS?

Porque explora completamente el subárbol de cada subordinado antes de continuar con el siguiente.

### ¿Qué diferencia existe entre nivel y altura?

`nivel` pertenece a un nodo y mide su distancia desde la raíz. `altura` pertenece al árbol o subárbol y representa su cantidad máxima de niveles.

### ¿Qué diferencia hay entre nivel jerárquico y nivel del árbol?

El nivel jerárquico clasifica un cargo. El nivel del árbol indica la posición real de un empleado dentro del organigrama.

### ¿Por qué se recalculan niveles al Reasignar?

Porque al mover un empleado también se mueve toda su descendencia, y todos quedan a una nueva distancia de la raíz.

### ¿Cómo se evita un ciclo?

Antes de Reasignar se comprueba recursivamente que el nuevo jefe no pertenezca al subárbol del empleado movido.

### ¿Por qué jefe es null para la raíz?

Porque no existe ningún nodo superior al Gerente General.

### ¿Por qué se separaron Empleado y NodoEmpleado?

Para separar los datos laborales de la posición estructural dentro del árbol.

### ¿Qué sucede con los datos al cerrar?

Se pierden porque el sistema funciona en memoria y no utiliza base de datos.

## 18. Limitaciones conscientes

- Las fechas se guardan como texto y no se valida su formato.
- `Scanner.nextInt` y `nextDouble` esperan que el usuario ingrese números válidos.
- No hay base de datos.
- No hay archivos ni persistencia después de cerrar.
- No se utilizan pruebas automatizadas dentro del proyecto.

Estas decisiones mantienen el código dentro del nivel de Java trabajado en clase.

## 19. Checklist previo a la entrega

- [ ] Todos los integrantes pueden explicar raíz, nodo y subordinados.
- [ ] Todos pueden seguir una búsqueda recursiva a mano.
- [ ] Todos pueden explicar el caso base y el paso recursivo.
- [ ] Todos pueden explicar una reasignación y el recálculo de niveles.
- [ ] El grupo confirma con el docente la separación `Empleado` / `NodoEmpleado`.
- [ ] Se realizan las pruebas manuales.
- [ ] Se agregan capturas de consola al PDF.
- [ ] El UML coincide con las clases reales.
- [ ] Se documentan PRE y POST.
- [ ] Se prueba la compilación desde una carpeta limpia.
- [ ] El ZIP incluye código fuente, PDF y UML.

## 20. Definición de terminado

El sistema está funcional cuando:

- compila y ejecuta desde consola;
- muestra el organigrama precargado;
- realiza los ABM pedidos;
- valida las relaciones entre entidades;
- ejecuta los algoritmos recursivos;
- reasigna subárboles sin formar ciclos;
- calcula subordinados, salarios, altura, niveles y cadenas de mando;
- gestiona proyectos, asignaciones y horas;
- cada integrante puede explicar el código utilizado.
