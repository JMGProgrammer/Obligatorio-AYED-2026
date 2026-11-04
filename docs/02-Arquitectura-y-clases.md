# 2. Arquitectura y descripción de clases

## 2.1 Organización general

La aplicación se divide en cuatro partes:

```text
Principal
    ↓
Controladora
    ↓
Entidades + Estructuras
```

- `Principal` se ocupa de la interacción con el usuario.
- `Controladora` coordina las operaciones y validaciones.
- `Entidades` contiene los datos del dominio.
- `Estructuras` contiene la representación y los algoritmos del árbol.

## 2.2 Estructura de carpetas

```text
src/
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

## 2.3 Convención de nombres

La implementación sigue la convención indicada por la cátedra:

- atributos con prefijo `a`;
- parámetros con prefijo `p`;
- métodos de negocio con inicial mayúscula;
- getters y setters con `get` y `set`;
- variables locales con nombres descriptivos y sin prefijo.

Ejemplo:

```java
private Empleado aEmpleado;

public void setEmpleado(Empleado pEmpleado) {
    this.aEmpleado = pEmpleado;
}

public Empleado BuscarEmpleado(int pId) {
    // Implementación
}
```

En `Principal`, la variable de entrada se denomina `Scanner`, según la decisión del grupo:

```java
static Scanner Scanner = new Scanner(System.in);
```

## 2.4 Clase Principal

Es el punto de entrada de la aplicación.

Responsabilidades:

- crear la `Controladora`;
- mostrar el menú principal y los submenús;
- leer datos mediante `Scanner`;
- construir objetos a partir de los datos ingresados;
- mostrar resultados y mensajes de error.

Las lecturas se realizan directamente:

```java
System.out.print("Legajo: ");
int id = Scanner.nextInt();
Scanner.nextLine();
```

El `nextLine()` posterior a una lectura numérica consume el salto de línea pendiente. Sin esta instrucción, una lectura de texto posterior podría quedar vacía.

## 2.5 Clase Controladora

Atributos:

```text
aOrganigrama
aDepartamentos
aCargos
aProyectos
aAsignaciones
```

Responsabilidades:

- inicializar las estructuras;
- precargar datos;
- validar operaciones;
- realizar ABM;
- mantener consistencia entre entidades;
- delegar operaciones jerárquicas al árbol.

Ejemplo de coordinación:

```text
Principal solicita una contratación
        ↓
Controladora valida cargo, departamento y salario
        ↓
ArbolOrganigrama busca al jefe e inserta el nodo
```

## 2.6 Clase Empleado

Atributos:

| Atributo | Tipo | Descripción |
|---|---|---|
| `aId` | `int` | Número de legajo único |
| `aNombre` | `String` | Nombre |
| `aApellido` | `String` | Apellido |
| `aCargo` | `Cargo` | Cargo ocupado |
| `aDepartamento` | `Departamento` | Departamento de pertenencia |
| `aSalario` | `double` | Salario actual |
| `aFechaIngreso` | `String` | Fecha de ingreso |

El método `getNombreCompleto()` reúne nombre y apellido. `toString()` produce una representación legible para los listados.

## 2.7 Clase Cargo

| Atributo | Tipo | Descripción |
|---|---|---|
| `aId` | `int` | Identificador único |
| `aNombre` | `String` | Nombre del cargo |
| `aNivelJerarquico` | `int` | Clasificación del puesto |
| `aSalarioBase` | `double` | Salario de referencia |

El nivel jerárquico del cargo no es el nivel del árbol:

- `aNivelJerarquico` describe el tipo de puesto;
- `NodoEmpleado.aNivel` describe la profundidad del empleado.

## 2.8 Clase Departamento

| Atributo | Tipo | Descripción |
|---|---|---|
| `aId` | `int` | Identificador único |
| `aNombre` | `String` | Nombre del área |
| `aDescripcion` | `String` | Descripción funcional |
| `aResponsable` | `Empleado` | Empleado responsable |

El responsable puede ser inicialmente `null` durante la precarga, ya que los departamentos se crean antes que los empleados. Luego se asignan las referencias correspondientes.

## 2.9 Clase Proyecto

| Atributo | Tipo | Descripción |
|---|---|---|
| `aId` | `int` | Identificador único |
| `aNombre` | `String` | Nombre del proyecto |
| `aFechaInicio` | `String` | Fecha de inicio |
| `aFechaFin` | `String` | Fecha estimada de finalización |
| `aEstado` | `String` | Estado actual |
| `aResponsable` | `Empleado` | Responsable principal |
| `aAsignaciones` | `ArrayList<Asignacion>` | Participantes del proyecto |

## 2.10 Clase Asignacion

Relaciona un empleado con un proyecto.

| Atributo | Tipo | Descripción |
|---|---|---|
| `aId` | `int` | Identificador único |
| `aEmpleado` | `Empleado` | Participante |
| `aProyecto` | `Proyecto` | Proyecto relacionado |
| `aHorasAsignadas` | `int` | Horas de dedicación |
| `aRol` | `String` | Rol dentro del proyecto |

Una asignación se conserva en dos lugares:

- lista general de la `Controladora`;
- lista de asignaciones del `Proyecto`.

La `Controladora` mantiene ambas referencias sincronizadas al crear o eliminar una asignación.

## 2.11 Clase NodoEmpleado

| Atributo | Tipo | Descripción |
|---|---|---|
| `aEmpleado` | `Empleado` | Dato almacenado |
| `aJefe` | `NodoEmpleado` | Nodo superior |
| `aSubordinados` | `ArrayList<NodoEmpleado>` | Nodos hijos |
| `aNivel` | `int` | Profundidad desde la raíz |

En un árbol binario existirían referencias `izq` y `der`. En este árbol se utiliza una lista porque un jefe puede tener más de dos subordinados.

La raíz tiene:

```text
aJefe = null
aNivel = 0
```

## 2.12 Clase ArbolOrganigrama

Su atributo principal es:

```java
private NodoEmpleado aRaiz;
```

Responsabilidades:

- crear la raíz;
- insertar empleados;
- buscar nodos;
- recorrer el árbol;
- contar descendientes;
- calcular masa salarial;
- construir cadenas de mando;
- calcular altura;
- filtrar por nivel;
- eliminar hojas;
- reasignar subárboles;
- evitar ciclos;
- encontrar el jefe común más cercano.

## 2.13 Relaciones principales

```text
Empleado      -> Cargo
Empleado      -> Departamento
Departamento  -> Empleado responsable
Proyecto      -> Empleado responsable
Proyecto      -> muchas Asignacion
Asignacion    -> Empleado
Asignacion    -> Proyecto
NodoEmpleado  -> Empleado
NodoEmpleado  -> NodoEmpleado jefe
NodoEmpleado  -> muchos NodoEmpleado subordinados
ArbolOrganigrama -> NodoEmpleado raíz
Controladora  -> ArbolOrganigrama y listas de entidades
Principal     -> Controladora
```

El archivo `DIAGRAMA-UML.puml`, ubicado en la raíz del proyecto, representa estas relaciones en formato PlantUML.

## 2.14 Flujo de las operaciones principales

### Contratación

1. `Principal` lee los datos.
2. Busca el cargo y departamento mediante `Controladora`.
3. Construye un `Empleado`.
4. `Controladora.ContratarEmpleado` valida los datos.
5. `ArbolOrganigrama.Insertar` busca al jefe.
6. Se crea el nodo y se agrega a los subordinados del jefe.

### Reasignación

1. Se buscan empleado y nuevo jefe.
2. Se valida que ambos existan.
3. Se comprueba que no sea la raíz ni su propio jefe.
4. Se verifica que el nuevo jefe no pertenezca al subárbol movido.
5. Se quita el nodo de su jefe anterior.
6. Se agrega al nuevo jefe.
7. Se actualizan recursivamente los niveles.

### Baja

1. Se busca el empleado.
2. Se verifica que no sea responsable.
3. El árbol comprueba que no sea raíz y no tenga subordinados.
4. Se elimina de la lista de su jefe.
5. Se eliminan sus asignaciones a proyectos.
