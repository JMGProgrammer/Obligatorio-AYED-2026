# **Sistema de Gestión de** 

# **Organigrama Empresarial**

## Empresa ficticia NovaTech

**Obligatorio AYED 2026** 

CTC Rosario

Docente:  
Gonzalo Alonso 

Alumnos:  
Mateo Rilla  
Juan Meny  
Facundo Villalba

Fecha: 3 de diciembre de 2026, 19:00

# **Índice general** {#índice-general}

[**Índice general	2**](#índice-general)

[**1\. Descripción y alcance del sistema	8**](#1.-descripción-y-alcance-del-sistema)

[1.1 Datos de la entrega	8](#1.1-datos-de-la-entrega)

[1.2 Introducción	8](#1.2-introducción)

[1.3 Objetivo general	9](#1.3-objetivo-general)

[1.4 Objetivos específicos	9](#1.4-objetivos-específicos)

[1.5 Alcance funcional	9](#1.5-alcance-funcional)

[Gestión del organigrama	9](#gestión-del-organigrama)

[Gestión de cargos	10](#gestión-de-cargos)

[Gestión de departamentos	10](#gestión-de-departamentos)

[Gestión de proyectos y asignaciones	10](#gestión-de-proyectos-y-asignaciones)

[**1.6 Funcionalidades excluidas	10**](#1.6-funcionalidades-excluidas)

[**1.7 Datos iniciales	11**](#1.7-datos-iniciales)

[**1.8 Reglas de negocio adoptadas	12**](#1.8-reglas-de-negocio-adoptadas)

[**1.9 Decisiones técnicas	12**](#1.9-decisiones-técnicas)

[Separación entre Empleado y NodoEmpleado	12](#separación-entre-empleado-y-nodoempleado)

[Fechas almacenadas como texto	12](#fechas-almacenadas-como-texto)

[Baja de empleados con subordinados	12](#baja-de-empleados-con-subordinados)

[**2\. Arquitectura y descripción de clases	13**](#2.-arquitectura-y-descripción-de-clases)

[2.1 Organización general	13](#2.1-organización-general)

[2.2 Estructura de carpetas	13](#2.2-estructura-de-carpetas)

[2.3 Convención de nombres	14](#2.3-convención-de-nombres)

[Ejemplo:	14](#ejemplo:)

[2.4 Clase Principal	14](#2.4-clase-principal)

[Responsabilidades:	14](#responsabilidades:)

[2.5 Clase Controladora	15](#2.5-clase-controladora)

[Atributos:	15](#atributos:)

[Responsabilidades:	15](#responsabilidades:-1)

[Ejemplo de coordinación:	15](#ejemplo-de-coordinación:)

[2.6 Clase Empleado	15](#2.6-clase-empleado)

[Atributos:	15](#atributos:-1)

[2.7 Clase Cargo	16](#2.7-clase-cargo)

[2.8 Clase Departamento	16](#2.8-clase-departamento)

[2.9 Clase Proyecto	17](#2.9-clase-proyecto)

[2.10 Clase Asignación	17](#2.10-clase-asignación)

[2.11 Clase NodoEmpleado	17](#2.11-clase-nodoempleado)

[2.12 Clase ArbolOrganigrama	18](#2.12-clase-arbolorganigrama)

[Su atributo principal es:	18](#su-atributo-principal-es:)

[Responsabilidades:	18](#responsabilidades:-2)

[2.13 Relaciones principales	18](#2.13-relaciones-principales)

[2.14 Flujo de las operaciones principales	19](#2.14-flujo-de-las-operaciones-principales)

[Contratación	19](#contratación)

[Reasignación	19](#reasignación)

[Baja	19](#baja)

[**3\. Árbol N-ario y algoritmos recursivos	20**](#3.-árbol-n-ario-y-algoritmos-recursivos)

[3.1 Estructura elegida	20](#3.1-estructura-elegida)

[La raíz representa al Gerente General:	20](#la-raíz-representa-al-gerente-general:)

[3.2 Conceptos utilizados	20](#3.2-conceptos-utilizados)

[3.3 Recursividad	21](#3.3-recursividad)

[3.4 Búsqueda DFS por legajo	21](#3.4-búsqueda-dfs-por-legajo)

[Método público	21](#método-público)

[Método recursivo	21](#método-recursivo)

[Objetivo	21](#objetivo)

[PRE	21](#pre)

[POST	21](#post)

[Casos base	22](#casos-base)

[Paso recursivo	22](#paso-recursivo)

[Ejemplo resumido	22](#ejemplo-resumido)

[Complejidad	22](#complejidad)

[3.5 Búsqueda por apellido	22](#3.5-búsqueda-por-apellido)

[Objetivo	22](#objetivo-1)

[PRE	22](#pre-1)

[POST	22](#post-1)

[Diferencia con la búsqueda por legajo	23](#diferencia-con-la-búsqueda-por-legajo)

[Complejidad	23](#complejidad-1)

[3.6 Recorrido preorden	23](#3.6-recorrido-preorden)

[Método	23](#método)

[Objetivo	23](#objetivo-2)

[PRE	23](#pre-2)

[POST	23](#post-2)

[Orden	23](#orden)

[Ejemplo:	24](#ejemplo:-1)

[Complejidad	24](#complejidad-2)

[3.7 Conteo de subordinados totales	24](#3.7-conteo-de-subordinados-totales)

[Método público	24](#método-público-1)

[Método recursivo	24](#método-recursivo-1)

[PRE	24](#pre-3)

[POST	24](#post-3)

[Lógica	24](#lógica)

[Ejemplo con Diego	25](#ejemplo-con-diego)

[Complejidad	25](#complejidad-3)

[3.8 Masa salarial	25](#3.8-masa-salarial)

[Método público	25](#método-público-2)

[Método recursivo	25](#método-recursivo-2)

[PRE	25](#pre-4)

[POST	25](#post-4)

[Lógica	25](#lógica-1)

[Ejemplo con Diego	26](#ejemplo-con-diego-1)

[Complejidad	26](#complejidad-4)

[3.9 Cadena de mando	26](#3.9-cadena-de-mando)

[Método	26](#método-1)

[Objetivo	26](#objetivo-3)

[PRE	26](#pre-5)

[POST	26](#post-5)

[Caso base	26](#caso-base)

[Ejemplo	26](#ejemplo)

[Complejidad	27](#complejidad-5)

[3.10 Altura del organigrama	27](#3.10-altura-del-organigrama)

[Método recursivo	27](#método-recursivo-3)

[PRE	27](#pre-6)

[POST	27](#post-6)

[Lógica	27](#lógica-2)

[El organigrama inicial tiene altura 4:	28](#el-organigrama-inicial-tiene-altura-4:)

[Complejidad	28](#complejidad-6)

[3.11 Empleados de un nivel	28](#3.11-empleados-de-un-nivel)

[Método recursivo	28](#método-recursivo-4)

[PRE	28](#pre-7)

[POST	28](#post-7)

[Resultado conocido para nivel 2	28](#resultado-conocido-para-nivel-2)

[Complejidad	29](#complejidad-7)

[3.12 Reasignación de un subárbol	29](#3.12-reasignación-de-un-subárbol)

[Método	29](#método-2)

[PRE	29](#pre-8)

[POST si la operación es válida	29](#post-si-la-operación-es-válida)

[POST si la operación es inválida	29](#post-si-la-operación-es-inválida)

[Pasos	29](#pasos)

[3.13 Prevención de ciclos	30](#3.13-prevención-de-ciclos)

[Método	30](#método-3)

[PRE	30](#pre-9)

[POST	30](#post-8)

[Motivo	30](#motivo)

[3.14 Actualización recursiva de niveles	31](#3.14-actualización-recursiva-de-niveles)

[Método	31](#método-4)

[PRE	31](#pre-10)

[POST	31](#post-9)

[Ejemplo	31](#ejemplo-1)

[3.15 Jefe común más cercano	32](#3.15-jefe-común-más-cercano)

[Método	32](#método-5)

[PRE	32](#pre-11)

[POST	32](#post-10)

[Algoritmo	32](#algoritmo)

[Ejemplos	32](#ejemplos)

[Complejidad	33](#complejidad-8)

[3.16 Terminación de los métodos recursivos	33](#3.16-terminación-de-los-métodos-recursivos)

[**4\. Manual de instalación y uso	33**](#4.-manual-de-instalación-y-uso)

[4.1 Requisitos	33](#4.1-requisitos)

[4.2 Ubicación del proyecto	34](#4.2-ubicación-del-proyecto)

[4.3 Compilación	34](#4.3-compilación)

[4.4 Ejecución	34](#4.4-ejecución)

[4.5 Eliminación de archivos compilados	34](#4.5-eliminación-de-archivos-compilados)

[4.6 Uso del Scanner	35](#4.6-uso-del-scanner)

[4.7 Menú de organigrama	35](#4.7-menú-de-organigrama)

[Mostrar organigrama	35](#mostrar-organigrama)

[Reasignar empleado	35](#reasignar-empleado)

[Mostrar altura	35](#mostrar-altura)

[Mostrar empleados de un nivel	35](#mostrar-empleados-de-un-nivel)

[Jefe común más cercano	36](#jefe-común-más-cercano)

[4.8 Menú de empleados	36](#4.8-menú-de-empleados)

[Alta	36](#alta)

[Modificación	36](#modificación)

[Baja	36](#baja-1)

[Búsquedas	36](#búsquedas)

[4.9 Menú de departamentos	36](#4.9-menú-de-departamentos)

[4.10 Menú de cargos	37](#4.10-menú-de-cargos)

[4.11 Menú de proyectos y asignaciones	37](#4.11-menú-de-proyectos-y-asignaciones)

[Proyectos	37](#proyectos)

[Asignaciones	37](#asignaciones)

[4.12 Menú de consultas recursivas	37](#4.12-menú-de-consultas-recursivas)

[4.13 Identificadores precargados	38](#4.13-identificadores-precargados)

[Empleados	38](#empleados)

[Departamentos	38](#departamentos)

[Cargos	38](#cargos)

[Proyectos	38](#proyectos-1)

[4.14 Errores de entrada	38](#4.14-errores-de-entrada)

[**5\. Plan de pruebas	39**](#5.-plan-de-pruebas)

[5.1 Objetivo	39](#5.1-objetivo)

[5.2 Criterios generales	39](#5.2-criterios-generales)

[5.3 Pruebas de precarga	40](#5.3-pruebas-de-precarga)

[5.4 Pruebas del organigrama	40](#5.4-pruebas-del-organigrama)

[5.5 Pruebas de búsqueda	40](#5.5-pruebas-de-búsqueda)

[5.6 Pruebas recursivas	40](#5.6-pruebas-recursivas)

[5.7 Pruebas de contratación	41](#5.7-pruebas-de-contratación)

[Alta válida	41](#alta-válida)

[Legajo repetido	41](#legajo-repetido)

[Jefe inexistente	41](#jefe-inexistente)

[5.8 Pruebas de baja	41](#5.8-pruebas-de-baja)

[5.9 Pruebas de reasignación	42](#5.9-pruebas-de-reasignación)

[Reasignación válida	42](#reasignación-válida)

[Intento de ciclo	42](#intento-de-ciclo)

[Mover la raíz	42](#mover-la-raíz)

[Empleado como su propio jefe	42](#empleado-como-su-propio-jefe)

[5.10 Pruebas de cargos	42](#5.10-pruebas-de-cargos)

[5.11 Pruebas de departamentos	43](#5.11-pruebas-de-departamentos)

[5.12 Pruebas de proyectos	43](#5.12-pruebas-de-proyectos)

[5.13 Registro de ejecución	43](#5.13-registro-de-ejecución)

[5.14 Verificaciones ya realizadas durante el desarrollo	44](#5.14-verificaciones-ya-realizadas-durante-el-desarrollo)

[**6\. Guía para la defensa oral	44**](#6.-guía-para-la-defensa-oral)

[6.1 Objetivo	44](#6.1-objetivo)

[6.2 Presentación sugerida	45](#6.2-presentación-sugerida)

[Parte 1 \- Problema y modelo	45](#parte-1---problema-y-modelo)

[Parte 2 \- Arquitectura	45](#parte-2---arquitectura)

[Parte 3 \- Demostración	45](#parte-3---demostración)

[Parte 4 \- Algoritmos	45](#parte-4---algoritmos)

[6.3 Preguntas y respuestas sugeridas	45](#6.3-preguntas-y-respuestas-sugeridas)

[¿Por qué utilizaron un árbol?	45](#¿por-qué-utilizaron-un-árbol?)

[¿Por qué es N-ario y no binario?	46](#¿por-qué-es-n-ario-y-no-binario?)

[¿Qué es la raíz?	46](#¿qué-es-la-raíz?)

[¿Qué representa un nodo?	46](#¿qué-representa-un-nodo?)

[¿Por qué separaron Empleado de NodoEmpleado?	46](#¿por-qué-separaron-empleado-de-nodoempleado?)

[¿Qué significa legajo?	46](#¿qué-significa-legajo?)

[¿Qué diferencia existe entre nivel jerárquico y nivel del árbol?	46](#¿qué-diferencia-existe-entre-nivel-jerárquico-y-nivel-del-árbol?)

[¿Qué es un caso base?	46](#¿qué-es-un-caso-base?)

[¿Qué es el paso recursivo?	46](#¿qué-es-el-paso-recursivo?)

[¿Cómo funciona la búsqueda por legajo?	46](#¿cómo-funciona-la-búsqueda-por-legajo?)

[¿Por qué se considera DFS?	46](#¿por-qué-se-considera-dfs?)

[¿Cómo cuentan subordinados totales?	46](#¿cómo-cuentan-subordinados-totales?)

[¿Cómo calculan la masa salarial?	47](#¿cómo-calculan-la-masa-salarial?)

[¿Qué representa la altura?	47](#¿qué-representa-la-altura?)

[¿Qué representa el nivel?	47](#¿qué-representa-el-nivel?)

[¿Por qué deben actualizar niveles al reasignar?	47](#¿por-qué-deben-actualizar-niveles-al-reasignar?)

[¿Cómo impiden un ciclo?	47](#¿cómo-impiden-un-ciclo?)

[¿Qué ocurriría si existiera un ciclo?	47](#¿qué-ocurriría-si-existiera-un-ciclo?)

[¿Cómo se obtiene la cadena de mando?	47](#¿cómo-se-obtiene-la-cadena-de-mando?)

[¿Cómo encuentran el jefe común más cercano?	47](#¿cómo-encuentran-el-jefe-común-más-cercano?)

[¿Qué regla eligieron para la baja?	47](#¿qué-regla-eligieron-para-la-baja?)

[¿Qué pasa con las asignaciones al eliminar un empleado válido?	47](#¿qué-pasa-con-las-asignaciones-al-eliminar-un-empleado-válido?)

[¿Por qué los datos se pierden al cerrar?	47](#¿por-qué-los-datos-se-pierden-al-cerrar?)

[¿Por qué las fechas son String?	48](#¿por-qué-las-fechas-son-string?)

[¿Para qué se usa Scanner.nextLine() después de nextInt()?	48](#¿para-qué-se-usa-scanner.nextline\(\)-después-de-nextint\(\)?)

[6.4 Seguimiento manual de una búsqueda	49](#6.4-seguimiento-manual-de-una-búsqueda)

[6.5 Seguimiento manual del conteo	49](#6.5-seguimiento-manual-del-conteo)

[6.6 Seguimiento manual de masa salarial	49](#6.6-seguimiento-manual-de-masa-salarial)

[6.7 Distribución posible de la exposición	50](#6.7-distribución-posible-de-la-exposición)

[Integrante 1	50](#integrante-1)

[Integrante 2	50](#integrante-2)

[Integrante 3	50](#integrante-3)

[Integrante 4, si corresponde	50](#integrante-4,-si-corresponde)

[6.8 Recomendaciones para la demostración	50](#6.8-recomendaciones-para-la-demostración)

[6.9 Aspectos que deben confirmar con el docente	50](#6.9-aspectos-que-deben-confirmar-con-el-docente)

[7\. Capturas de funcionamiento	51](#7.-capturas-de-funcionamiento)

[7.1 Menú principal	51](#7.1-menú-principal)

[7.2 Organigrama completo	51](#7.2-organigrama-completo)

[7.3 Búsqueda de empleado	51](#7.3-búsqueda-de-empleado)

[7.4 Conteo de subordinados	51](#7.4-conteo-de-subordinados)

[7.5 Masa salarial	51](#7.5-masa-salarial)

[7.6 Cadena de mando	51](#7.6-cadena-de-mando)

[7.7 Empleados por nivel	51](#7.7-empleados-por-nivel)

[7.8 Organigrama antes de una reasignación	51](#7.8-organigrama-antes-de-una-reasignación)

[7.9 Organigrama después de una reasignación	51](#7.9-organigrama-después-de-una-reasignación)

[7.10 Prevención de ciclos	51](#7.10-prevención-de-ciclos)

[7.11 Listado de proyectos	51](#7.11-listado-de-proyectos)

[7.12 Asignaciones y horas	51](#7.12-asignaciones-y-horas)

# **1\. Descripción y alcance del sistema** {#1.-descripción-y-alcance-del-sistema}

## **1.1 Datos de la entrega** {#1.1-datos-de-la-entrega}

| Campo | Información |
| :---- | :---- |
| Proyecto | Sistema de Gestión de Organigrama Empresarial |
| Empresa ficticia | NovaTech |
| Materia | Algoritmos y Estructuras de Datos |
| Lenguaje | Java |
| Modalidad | Aplicación de consola |
| Persistencia | En memoria |
| Institución | CTC Rosario |
| Docente | Gonzalo Alonso |
| Integrantes | Mateo Rilla, Juan Meny, Facundo Villalba |
| Fecha de entrega | 3 de diciembre de 2026, 19:00 |

## **1.2 Introducción** {#1.2-introducción}

El proyecto consiste en una aplicación de consola destinada a representar y administrar el organigrama de la empresa ficticia NovaTech. La empresa cuenta con un Gerente General, diferentes gerencias, líderes y empleados operativos. Cada empleado tiene un único jefe directo y puede tener cualquier cantidad de subordinados. 

Esta relación jerárquica se representa mediante un árbol N-ario. El Gerente General ocupa la raíz del árbol y los subordinados de cada empleado constituyen sus nodos hijos. A diferencia de un árbol binario, un árbol N-ario no limita cada nodo a dos hijos. 

Además del organigrama, el sistema administra cargos, departamentos, proyectos y asignaciones de empleados. Todos los datos permanecen en memoria durante la ejecución; al cerrar el programa se pierden, ya que no se utiliza una base de datos ni almacenamiento en archivos. 

## **1.3 Objetivo general** {#1.3-objetivo-general}

Desarrollar una aplicación Java de consola que permita administrar la estructura jerárquica del personal de NovaTech, junto con las entidades relacionadas, aplicando recorridos, búsquedas y cálculos recursivos sobre un árbol N-ario. 

## **1.4 Objetivos específicos** {#1.4-objetivos-específicos}

* Representar el organigrama mediante un árbol N-ario.   
* Implementar altas, bajas y modificaciones de las entidades principales.   
* Buscar empleados por legajo y por apellido.   
* Mostrar la jerarquía completa en recorrido preorden.   
* Calcular subordinados totales y masa salarial de un subárbol.   
* Obtener la cadena de mando de un empleado.   
* Calcular la altura del organigrama.   
* Listar empleados pertenecientes a un nivel determinado.   
* Reasignar un empleado junto con todo su subárbol.   
* Impedir que una reasignación forme ciclos.   
* Encontrar el jefe común más cercano entre dos empleados.   
* Administrar proyectos, asignaciones y horas de dedicación.   
* Precargar datos suficientes para demostrar las funcionalidades. 

## **1.5 Alcance funcional** {#1.5-alcance-funcional}

### **Gestión del organigrama** {#gestión-del-organigrama}

* El sistema permite:   
* Mostrar el organigrama con indentación según el nivel;   
* Mostrar el nivel de cada empleado;   
* Mostrar la cantidad total de subordinados;   
* Contratar un empleado indicando su jefe;   
* Modificar cargo, departamento y salario;   
* Dar de baja empleados que cumplan las condiciones establecidas;   
* Reasignar empleados a otro jefe;   
* Buscar por legajo o apellido;   
* Consultar altura, niveles y cadenas de mando;   
* Calcular el jefe común más cercano. 

### **Gestión de cargos**  {#gestión-de-cargos}

Se implementan: 

* Alta;   
* Modificación;   
* Baja;   
* Listado;   
* Validación para impedir la eliminación de cargos utilizados. 

### **Gestión de departamentos**  {#gestión-de-departamentos}

* Se implementan:   
* Alta;   
* Modificación;   
* Baja;   
* Listado;   
* Asignación de responsable;   
* Listado y conteo de empleados pertenecientes al departamento;   
* Validación para impedir la eliminación de departamentos con empleados. 

### **Gestión de proyectos y asignaciones** {#gestión-de-proyectos-y-asignaciones}

* Se implementan:  
* Alta, modificación, baja y listado de proyectos;   
* Cambio de estado;   
* Asignación de empleados;   
* Modificación y baja de asignaciones;   
* Cálculo de horas totales;   
* Validación de empleados repetidos dentro del mismo proyecto. 

# **1.6 Funcionalidades excluidas** {#1.6-funcionalidades-excluidas}

El sistema no incluye: 

* Base de datos.  
* Persistencia en archivos.  
* Interfaz gráfica.  
* Autenticación de usuarios.  
* Conexión de red  
* Validación avanzada de fechas.   
* Recuperación automática de datos al reiniciar. 

Estas exclusiones son coherentes con el alcance académico y con la exigencia de trabajar en memoria mediante una aplicación de consola.

# **1.7 Datos iniciales** {#1.7-datos-iniciales}

* La aplicación se inicia con:   
* 12 empleados, incluyendo al Gerente General;   
* 4 niveles de árbol, numerados del 0 al 3;   
* 4 departamentos;   
* 7 cargos;   
* 2 proyectos;   
* 5 asignaciones. 

El organigrama precargado es: 

Laura Méndez — Gerente General   
├── Diego Pérez — Gerente de Área   
│ ├── Ana Rodríguez — Líder   
│ │ ├── Martín Silva — Programador   
│ │ └── Sofía Castro — Programadora   
│ └── Pablo Gómez — Líder   
│ └── Lucía Fernández — Administradora de Redes   
├── Carolina Díaz — Gerente de Área   
│ ├── Jorge Núñez — Vendedor   
│ └── Valentina Rossi — Vendedora   
└── Fernando López — Gerente de Área   
 └── Camila Torres — Analista de RRHH

# **1.8 Reglas de negocio adoptadas** {#1.8-reglas-de-negocio-adoptadas}

1. Los identificadores deben ser únicos dentro de cada entidad.   
2. El Gerente General es la única raíz y no tiene jefe.   
3. No puede eliminarse la raíz.   
4. No puede eliminarse un empleado que tenga subordinados.   
5. No puede eliminarse un empleado responsable de un departamento o proyecto.   
6. Al eliminar un empleado válido se eliminan sus asignaciones.   
7. No puede eliminarse un cargo en uso.   
8. No puede eliminarse un departamento con empleados.   
9. Los salarios y horas deben ser mayores que cero.   
10. Los estados válidos son PLANIFICADO, EN\_CURSO y FINALIZADO.   
11. Un empleado no puede repetirse dentro del mismo proyecto.   
12. Una reasignación no puede colocar un empleado debajo de su propio subárbol. 

# **1.9 Decisiones técnicas** {#1.9-decisiones-técnicas}

### **Separación entre Empleado y NodoEmpleado**  {#separación-entre-empleado-y-nodoempleado}

Empleado conserva los datos personales y laborales, mientras que NodoEmpleado conserva la información estructural: jefe, subordinados y nivel. 

La separación permite distinguir dos responsabilidades: 

1. La entidad representa al empleado;   
2. El nodo representa su ubicación dentro del organigrama. 

La información exigida por el enunciado continúa presente entre ambas clases. Esta decisión debe confirmarse con el docente antes de la entrega definitiva. 

### **Fechas almacenadas como texto**  {#fechas-almacenadas-como-texto}

Las fechas se guardan mediante String. Esta decisión mantiene el código dentro de los contenidos trabajados y evita incorporar APIs que no son necesarias para demostrar árboles y recursividad.

### **Baja de empleados con subordinados**  {#baja-de-empleados-con-subordinados}

Se eligió impedir la baja en lugar de reasignar automáticamente los subordinados. La regla resulta fácil de verificar, evita cambios jerárquicos involuntarios y es una de las alternativas permitidas por el enunciado.

# **2\. Arquitectura y descripción de clases** {#2.-arquitectura-y-descripción-de-clases}

## **2.1 Organización general** {#2.1-organización-general}

La aplicación se divide en cuatro partes: 

Principal  
↓   
Controladora   
↓  
Entidades \+ Estructuras 

* Principal se ocupa de la interacción con el usuario.   
* Controladora coordina las operaciones y validaciones.   
* Entidades contiene los datos del dominio.   
* Estructuras contiene la representación y los algoritmos del árbol. 

## **2.2 Estructura de carpetas** {#2.2-estructura-de-carpetas}

src/   
├── Principal.java   
└── Dominio/   
 	├── Controladora.java   
 	├── Entidades/   
 	│ ├── Empleado.java   
 	│ ├── Departamento.java   
 	│ ├── Cargo.java   
 	│ ├── Proyecto.java   
│ └── Asignacion.java   
 	└── Estructuras/   
 		├── NodoEmpleado.java   
 		└── ArbolOrganigrama.java 

## **2.3 Convención de nombres** {#2.3-convención-de-nombres}

La implementación sigue la convención elegida preferentemente por los integrantes del grupo: 

* Atributos con prefijo a;   
* Parámetros con prefijo p;   
* Métodos de negocio con inicial mayúscula;   
* Getters y Setters con get y set;   
* Variables locales con nombres descriptivos y sin prefijo. 

### **Ejemplo:** {#ejemplo:}

private Empleado aEmpleado;   
public void setEmpleado(Empleado pEmpleado) {   
 this.aEmpleado \= pEmpleado;   
}   
public Empleado BuscarEmpleado(int pId) {   
 // Implementación   
}

En Principal, la variable de entrada se denomina Scanner, según la decisión del grupo:

static Scanner Scanner \= new Scanner(System.in); 

## **2.4 Clase Principal** {#2.4-clase-principal}

Es el punto de entrada de la aplicación. 

### **Responsabilidades:** {#responsabilidades:}

* Crear la Controladora;   
* Mostrar el menú principal y los submenús;   
* Leer datos mediante Scanner;   
* Construir objetos a partir de los datos ingresados;   
* Mostrar resultados y mensajes de error. 

Las lecturas se realizan directamente: 

System.out.print("Legajo: ");   
int id \= Scanner.nextInt();   
Scanner.nextLine(); 

El nextLine() posterior a una lectura numérica consume el salto de línea pendiente. Sin esta instrucción, una lectura de texto posterior podría quedar vacía.

## **2.5 Clase Controladora** {#2.5-clase-controladora}

### **Atributos:** {#atributos:}

* aOrganigrama   
* aDepartamentos   
* aCargos   
* aProyectos   
* aAsignaciones

### **Responsabilidades:** {#responsabilidades:-1}

* Inicializar las estructuras;   
* Precargar datos;   
* Validar operaciones;   
* Realizar ABM;   
* Mantener consistencia entre entidades;   
* Delegar operaciones jerárquicas al árbol. 

### **Ejemplo de coordinación:**  {#ejemplo-de-coordinación:}

Principal solicita una contratación, luego Controladora valida cargo, departamento y salario, para que ArbolOrganigrama busque al jefe e inserte el nodo.

## **2.6 Clase Empleado** {#2.6-clase-empleado}

### **Atributos:**  {#atributos:-1}

| Atributo | Tipo | Descripción |
| :---- | :---- | :---- |
| aId | int | Número de legajo único |
| aNombre | String | Nombre |
| aApellido | String | Apellido |
| aCargo | Cargo | Cargo ocupado |
| aDepartamento | Departamento | Departamento de pertenencia |
| aSalario | double | Salario actual |
| aFechaIngreso | String | Fecha de ingreso |

El método getNombreCompleto() reúne nombre y apellido. toString() produce una representación legible para los listados.

## **2.7 Clase Cargo** {#2.7-clase-cargo}

| Atributo | Tipo | Descripción |
| :---- | :---- | :---- |
| aId | int | Identificador único |
| aNombre | String | Nombre del cargo |
| aNivelJerarquico | int | Clasificación del puesto |
| aSalarioBase | double | Salario de referencia |

El nivel jerárquico del cargo no es el nivel del árbol:

* aNivelJerarquico describe el tipo de puesto.  
* NodoEmpleado.aNivel describe la profundidad del empleado. 

## **2.8 Clase Departamento** {#2.8-clase-departamento}

| Atributo | Tipo | Descripción |
| :---- | :---- | :---- |
| aId | int | Identificador único |
| aNombre | String | Nombre del área |
| aDescripcion | String | Descripción funcional |
| aResponsable | Empleado | Empleado responsable |

El responsable puede ser inicialmente null durante la precarga, ya que los departamentos se crean antes que los empleados. Luego se asignan las referencias correspondientes.

## **2.9 Clase Proyecto** {#2.9-clase-proyecto}

| Atributo | Tipo | Descripción |
| :---- | :---- | :---- |
| aId | int | Identificador único |
| aNombre | String | Nombre del proyecto |
| aFechaInicio | String | Fecha de inicio |
| aFechaFin | String | Fecha estimada de finalización |
| aEstado | String | Estado actual |
| aResponsable | Empleado | Responsable principal |
| aAsignaciones | ArrayList\<Asignacion\> | Participantes del proyecto |

## **2.10 Clase Asignación** {#2.10-clase-asignación}

Relaciona un empleado con un proyecto.

| Atributo | Tipo | Descripción |
| :---- | :---- | :---- |
| aId | int | Identificador único |
| aEmpleado | Empleado | Participante |
| aProyecto | Proyecto | Proyecto relacionado |
| aHorasAsignadas | int | Horas de dedicación |
| aRol | String | Rol dentro del proyecto |

Una asignación se conserva en dos lugares:  
Lista general de la Controladora.  
Lista de asignaciones del Proyecto.  
La Controladora mantiene ambas referencias sincronizadas al crear o eliminar una asignación. 

## **2.11 Clase NodoEmpleado**  {#2.11-clase-nodoempleado}

| Atributo | Tipo | Descripción |
| :---- | :---- | :---- |
| aEmpleado | Empleado | Dato almacenado |
| aJefe | NodoEmpleado | Nodo superior |
| aSubordinados | ArrayList\<NodoEmpleado\> | Nodos hijos |
| aNivel | int | Profundidad desde la raíz |

En este árbol se utiliza una lista porque un jefe puede tener más de dos subordinados.   
La raíz tiene:   
aJefe \= null   
aNivel \= 0

## **2.12 Clase ArbolOrganigrama** {#2.12-clase-arbolorganigrama}

### **Su atributo principal es:** {#su-atributo-principal-es:}

private NodoEmpleado aRaiz;

### **Responsabilidades:** {#responsabilidades:-2}

* Crear la raíz.  
* Insertar empleados.  
* Buscar nodos.  
* Recorrer el árbol.  
* Contar descendientes.   
* Calcular masa salarial.  
* Construir cadenas de mando.   
* Calcular altura.  
* Filtrar por nivel.   
* Eliminar hojas.  
* Reasignar subárboles.  
* Evitar ciclos.  
* Encontrar el jefe común más cercano. 

## **2.13 Relaciones principales**  {#2.13-relaciones-principales}

Empleado \-\> Cargo   
Empleado \-\> Departamento   
Departamento \-\> Empleado responsable   
Proyecto \-\> Empleado responsable   
Proyecto \-\> muchas Asignacion   
Asignacion \-\> Empleado   
Asignacion \-\> Proyecto   
NodoEmpleado \-\> Empleado   
NodoEmpleado \-\> NodoEmpleado jefe   
NodoEmpleado \-\> muchos NodoEmpleado subordinados   
ArbolOrganigrama \-\> NodoEmpleado raíz   
Controladora \-\> ArbolOrganigrama y listas de entidades   
Principal \-\> Controladora

Estas relaciones pueden representarse mediante un diagrama de clases UML. 

## **2.14 Flujo de las operaciones principales**  {#2.14-flujo-de-las-operaciones-principales}

### **Contratación** {#contratación}

1. Principal lee los datos.  
2. Busca el cargo y departamento mediante Controladora.  
3. Construye un Empleado.  
4. Controladora.ContratarEmpleado valida los datos.  
5. ArbolOrganigrama.Insertar busca al jefe.

Se crea el nodo y se agrega a los subordinados del jefe.

### **Reasignación**  {#reasignación}

1. Se leen legajo del empleado y del nuevo jefe.  
2. Se buscan empleado y nuevo jefe.  
3. Se valida que ambos existan.  
4. Se comprueba que no sea la raíz ni su propio jefe.  
5. Se verifica que el nuevo jefe no pertenezca al subárbol movido.  
6. Se quita el nodo de su jefe anterior.  
7. Se agrega al nuevo jefe.

Se actualizan recursivamente los niveles.

### **Baja** {#baja}

1. Se lee el legajo del empleado.  
2. Se busca el empleado.  
3. Se verifica que no sea responsable.  
4. El árbol comprueba que no sea raíz y no tenga subordinados.  
5. Se elimina de la lista de su jefe.

Se eliminan sus asignaciones a proyectos.

# **3\. Árbol N-ario y algoritmos recursivos** {#3.-árbol-n-ario-y-algoritmos-recursivos}

## **3.1 Estructura elegida** {#3.1-estructura-elegida}

El organigrama se representa mediante un árbol N-ario. Cada nodo contiene un empleado y una lista de subordinados. La cantidad de hijos no está limitada a dos. 

### **La raíz representa al Gerente General:**  {#la-raíz-representa-al-gerente-general:}

NodoEmpleado raíz   
├── empleado \= Laura Méndez   
├── jefe \= null   
├── nivel \= 0   
└── subordinados \= \[Diego, Carolina, Fernando\]

Cada subordinado puede ser a su vez la raíz de un subárbol. 

## **3.2 Conceptos utilizados** {#3.2-conceptos-utilizados}

| Concepto | Descripción |
| :---- | :---- |
| Nodo | Elemento individual del árbol. En este proyecto es una instancia de NodoEmpleado. |
| Raíz | Primer nodo del árbol. No tiene jefe y su nivel es cero. |
| Padre o jefe | Nodo ubicado inmediatamente por encima de otro. |
| Hijo o subordinado directo | Nodo ubicado inmediatamente debajo de otro. |
| Descendiente | Subordinado directo o indirecto. |
| Hoja | Nodo sin subordinados. |
| Subárbol | Un nodo junto con todos sus descendientes. |
| Nivel | Distancia desde la raíz. La raíz tiene nivel 0\. |
| Altura | Cantidad máxima de niveles que contiene el árbol o subárbol. En esta implementación una hoja tiene altura 1\. |

## **3.3 Recursividad** {#3.3-recursividad}

Un método recursivo se llama a sí mismo para resolver una versión más pequeña del mismo problema. Debe tener: 

1. Uno o más casos base que detengan las llamadas;   
2. Un paso recursivo que avance hacia un caso más pequeño.

   
En un árbol, el caso más pequeño suele ser un nodo null o una hoja. El paso recursivo consiste en aplicar el algoritmo a cada hijo. 

## **3.4 Búsqueda DFS por legajo** {#3.4-búsqueda-dfs-por-legajo}

### **Método público** {#método-público}

public NodoEmpleado BuscarPorId(int pId) 

### **Método recursivo** {#método-recursivo}

private NodoEmpleado BuscarPorIdRecursivo(   
NodoEmpleado pActual, int pId) 

### **Objetivo** {#objetivo}

Encontrar el nodo correspondiente a un número de legajo. 

### **PRE** {#pre}

* pActual es null o pertenece al organigrama.   
* pId representa el legajo buscado. 

### **POST** {#post}

* Retorna el nodo cuyo empleado tiene el legajo buscado.   
* Retorna null si el empleado no existe.   
* No modifica el árbol. 

### **Casos base** {#casos-base}

if (pActual \== null) {   
 return null;   
}   
if (pActual.getEmpleado().getId() \== pId) {   
 return pActual;   
} 

### **Paso recursivo**  {#paso-recursivo}

Busca dentro del subárbol de cada subordinado. Cuando encuentra el nodo, lo retorna sin continuar con las ramas restantes. 

### **Ejemplo resumido** {#ejemplo-resumido}

Para buscar a Martín (1003):   
Laura \!= 1003   
└── Diego \!= 1003   
└── Ana \!= 1003   
 		└── Martín \= 1003 \-\> encontrado 

### **Complejidad** {#complejidad}

En el peor caso visita todos los empleados: O(n).

## **3.5 Búsqueda por apellido** {#3.5-búsqueda-por-apellido}

### **Objetivo** {#objetivo-1}

Encontrar todos los empleados cuyo apellido coincida con el solicitado. 

### **PRE**  {#pre-1}

* El nodo actual es null o pertenece al árbol.   
* La lista de resultados está creada.   
* El apellido no es null. 

### **POST**  {#post-1}

* La lista contiene todos los empleados con el apellido buscado.   
* Puede quedar vacía si no existen coincidencias.   
* El árbol no se modifica. 

### **Diferencia con la búsqueda por legajo** {#diferencia-con-la-búsqueda-por-legajo}

El legajo es único y permite detenerse en la primera coincidencia. El apellido puede repetirse, por lo que es necesario recorrer todas las ramas. 

### **Complejidad**  {#complejidad-1}

Siempre visita el árbol completo: O(n). 

## **3.6 Recorrido preorden** {#3.6-recorrido-preorden}

### **Método**  {#método}

private String MostrarPreordenRecursivo(NodoEmpleado pActual) 

### **Objetivo**  {#objetivo-2}

Construir una representación textual del organigrama, mostrando primero al jefe y después a sus subordinados. 

### **PRE**  {#pre-2}

• pActual no es null.   
• pActual pertenece al organigrama.   
• Los niveles del subárbol están actualizados. 

### **POST**  {#post-2}

• Retorna el subárbol en recorrido preorden.   
• Cada empleado aparece indentado según su nivel.   
• Incluye cargo, nivel y subordinados totales.   
• No modifica el árbol. 

### **Orden**  {#orden}

1\. Procesar el nodo actual.   
2\. Recorrer el primer hijo.   
3\. Recorrer el segundo hijo.   
4\. Continuar con los restantes. 

### **Ejemplo:** {#ejemplo:-1}

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

### **Complejidad**  {#complejidad-2}

Visita cada nodo una vez, aunque el listado también calcula subordinados para cada empleado. El recorrido base es O(n); al recalcular descendientes para cada nodo, la visualización completa puede llegar a O(n²) en una estructura muy desbalanceada. 

## **3.7 Conteo de subordinados totales** {#3.7-conteo-de-subordinados-totales}

### **Método público**  {#método-público-1}

public int ContarSubordinados(int pIdEmpleado) 

### **Método recursivo**  {#método-recursivo-1}

private int ContarSubordinadosRecursivo(NodoEmpleado pActual) 

### **PRE**  {#pre-3}

* pActual no es null.   
* pActual pertenece al organigrama. 

### **POST**  {#post-3}

* Retorna la cantidad de descendientes directos e indirectos.   
* Una hoja retorna 0\.   
* No modifica el árbol. 

### **Lógica**  {#lógica}

cantidad \= cantidad de hijos directos 

por cada hijo:   
cantidad \= cantidad \+ subordinados totales del hijo 

### **Ejemplo con Diego**  {#ejemplo-con-diego}

Hijos directos de Diego: Ana y Pablo \= 2   
Descendientes de Ana: Martín y Sofía \= 2   
Descendientes de Pablo: Lucía \= 1   
Total \= 2 \+ 2 \+ 1 \= 5 

### **Complejidad**  {#complejidad-3}

O(k), donde k es la cantidad de nodos del subárbol consultado.

## **3.8 Masa salarial** {#3.8-masa-salarial}

### **Método público**  {#método-público-2}

public double CalcularMasaSalarial(int pIdEmpleado) 

### **Método recursivo**  {#método-recursivo-2}

private double CalcularMasaSalarialRecursiva(NodoEmpleado pActual) 

### **PRE**  {#pre-4}

* pActual no es null.   
* Todos los empleados del subárbol tienen salario mayor que cero. 

### **POST**  {#post-4}

* Retorna el salario del empleado actual más los salarios de todos sus descendientes. • No modifica salarios ni estructura. 

### **Lógica**  {#lógica-1}

total \= salario del empleado actual 

por cada subordinado:   
total \= total \+ masa salarial del subordinado 

### **Ejemplo con Diego**  {#ejemplo-con-diego-1}

Diego 155000   
Ana 125000   
Martín 92000   
Sofía 91000   
Pablo 123000   
Lucía 97000   
\- \- \- \- \- \- \- \- \- \- \- \-  
Total 683000 

### **Complejidad**  {#complejidad-4}

O(k), donde k es la cantidad de empleados del subárbol. 

## **3.9 Cadena de mando** {#3.9-cadena-de-mando}

### **Método** {#método-1}

private String ObtenerCadenaRecursiva(NodoEmpleado pActual) 

### **Objetivo**  {#objetivo-3}

Construir la ruta desde un empleado hasta el Gerente General. 

### **PRE**  {#pre-5}

* pActual no es null.   
* El nodo pertenece al árbol.   
* Las referencias a jefe son correctas. 

### **POST**  {#post-5}

* Retorna una cadena desde el empleado hasta la raíz.   
* La raíz aparece al final.  
* El árbol no se modifica. 

### **Caso base**  {#caso-base}

if (pActual.getJefe() \== null) {   
return pActual.getEmpleado().getNombreCompleto();   
} 

### **Ejemplo**  {#ejemplo}

Martín Silva \<- Ana Rodríguez \<- Diego Pérez \<- Laura Méndez 

### **Complejidad**  {#complejidad-5}

O(h), donde h es la cantidad de nodos entre el empleado y la raíz. 

## **3.10 Altura del organigrama** {#3.10-altura-del-organigrama}

### **Método recursivo**  {#método-recursivo-3}

private int CalcularAlturaRecursiva(NodoEmpleado pActual);

### **PRE**  {#pre-6}

* pActual es null o pertenece al árbol. 

### **POST**  {#post-6}

* Retorna 0 para un árbol vacío.   
* Retorna 1 para una hoja.   
* Para un nodo interno retorna 1 más la mayor altura de sus hijos.   
* No modifica el árbol. 

### **Lógica**  {#lógica-2}

si actual es null:   
retornar 0

mayorAltura \= 0 

por cada hijo:   
calcular altura del hijo   
conservar la mayor 

retornar mayorAltura \+ 1 

#### **El organigrama inicial tiene altura 4:**  {#el-organigrama-inicial-tiene-altura-4:}

Nivel 0: Laura   
Nivel 1: Diego   
Nivel 2: Ana   
Nivel 3: Martín 

### **Complejidad**  {#complejidad-6}

O(n).

## **3.11 Empleados de un nivel**  {#3.11-empleados-de-un-nivel}

### **Método recursivo**  {#método-recursivo-4}

private void EmpleadosDelNivelRecursivo(   
NodoEmpleado pActual,   
int pNivel,   
ArrayList\<Empleado\> pResultado);

### **PRE**  {#pre-7}

* La lista de resultados está creada.   
* pNivel es mayor o igual que cero.   
* pActual es null o pertenece al árbol. 

### **POST**  {#post-7}

* La lista contiene todos los empleados del nivel buscado.   
* El árbol no se modifica. 

### **Resultado conocido para nivel 2**  {#resultado-conocido-para-nivel-2}

Ana Rodríguez   
Pablo Gómez   
Jorge Núñez   
Valentina Rossi   
Camila Torres 

### **Complejidad**  {#complejidad-7}

O(n) porque se revisan todos los nodos. 

## **3.12 Reasignación de un subárbol** {#3.12-reasignación-de-un-subárbol}

### **Método**  {#método-2}

public boolean Reasignar(int pIdEmpleado, int pIdNuevoJefe) 

### **PRE**  {#pre-8}

* El empleado existe.   
* El nuevo jefe existe.   
* El empleado no es la raíz.   
* El empleado no es su propio nuevo jefe.   
* El nuevo jefe no pertenece al subárbol del empleado. 

### **POST si la operación es válida**  {#post-si-la-operación-es-válida}

* El empleado deja de pertenecer a los hijos del jefe anterior.   
* Su referencia a jefe apunta al nuevo jefe.   
* Aparece en la lista de subordinados del nuevo jefe.   
* Todos los niveles de su subárbol quedan actualizados.   
* La estructura continúa siendo un árbol. 

### **POST si la operación es inválida**  {#post-si-la-operación-es-inválida}

* Retorna false.  
* El organigrama no se modifica. 

### **Pasos**  {#pasos}

1. Buscar el empleado.   
2. Buscar el nuevo jefe.   
3. Validar la operación.   
4. Quitar del jefe anterior.   
5. Cambiar la referencia a jefe.   
6. Agregar al nuevo jefe.   
7. Actualizar niveles recursivamente.

 

## **3.13 Prevención de ciclos** {#3.13-prevención-de-ciclos}

### **Método**  {#método-3}

private boolean EstaEnSubarbolRecursivo(   
NodoEmpleado pActual,   
NodoEmpleado pBuscado) 

### **PRE**  {#pre-9}

* Ambos nodos existen.   
* pActual pertenece al organigrama. 

### **POST**  {#post-8}

* Retorna true si pBuscado es el nodo actual o uno de sus descendientes.   
* Retorna false en caso contrario.   
* No modifica el árbol. 

### **Motivo**  {#motivo}

Si Diego contiene a Ana y Ana contiene a Martín, mover a Diego debajo de Martín produciría: 

Diego \-\> Ana \-\> Martín \-\> Diego \-\> ... 

La estructura tendría un ciclo, las búsquedas recursivas no terminarían y dejaría de ser un árbol. 

## **3.14 Actualización recursiva de niveles** {#3.14-actualización-recursiva-de-niveles}

### **Método**  {#método-4}

private void ActualizarNivelesRecursivo(NodoEmpleado pActual, int pNivel);

### **PRE**  {#pre-10}

* pActual no es null.   
* pNivel corresponde al nuevo nivel del nodo. 

### **POST**  {#post-9}

* El nodo actual queda en pNivel.   
* Cada hijo queda un nivel por debajo de su padre.   
* Se actualiza todo el subárbol. 

### **Ejemplo**  {#ejemplo-1}

Si Ana se mueve debajo de Jorge: 

Antes:   
Ana nivel 2   
Martín nivel 3   
Sofía nivel 3 

Después:   
Ana nivel 3   
Martín nivel 4   
Sofía nivel 4

## **3.15 Jefe común más cercano** {#3.15-jefe-común-más-cercano}

### **Método**  {#método-5}

public Empleado JefeComunMasCercano(   
 int pIdPrimero,   
 int pIdSegundo) 

### **PRE**  {#pre-11}

* Los dos legajos corresponden a empleados existentes.   
* Las referencias a jefe y los niveles son correctos. 

### **POST**  {#post-10}

* Retorna el ancestro común más bajo de ambos nodos.   
* Retorna null si alguno no existe.   
* No modifica el árbol. 

### **Algoritmo**  {#algoritmo}

1. Buscar ambos nodos.   
2. Subir el nodo de mayor nivel hasta igualar profundidades.   
3. Subir ambos nodos simultáneamente.   
4. Detenerse cuando las referencias coincidan. 

### **Ejemplos**  {#ejemplos}

Martín \+ Sofía \-\> Ana   
Martín \+ Lucía \-\> Diego   
Martín \+ Jorge \-\> Laura 

### **Complejidad**  {#complejidad-8}

Las búsquedas iniciales son O(n). La subida posterior es O(h).

## **3.16 Terminación de los métodos recursivos** {#3.16-terminación-de-los-métodos-recursivos}

Los recorridos hacia abajo terminan porque cada llamada avanza hacia un hijo y el árbol es finito. En las hojas, la lista de subordinados está vacía y no se producen nuevas llamadas. 

Los recorridos hacia arriba terminan al encontrar un nodo cuyo jefe es null, es decir, la raíz. 

La prevención de ciclos es fundamental para conservar esta propiedad de terminación.

# **4\. Manual de instalación y uso** {#4.-manual-de-instalación-y-uso}

## **4.1 Requisitos** {#4.1-requisitos}

• Java Development Kit instalado.   
• Terminal o consola.   
• Editor de código opcional (IDE), por ejemplo Visual Studio Code. 

El proyecto fue verificado con OpenJDK 21\. 

Para consultar la versión instalada:   
java \-version   
javac \-version 

## **4.2 Ubicación del proyecto** {#4.2-ubicación-del-proyecto}

El código fuente está dentro de la carpeta src del proyecto. 

## **4.3 Compilación** {#4.3-compilación}

Abrir una terminal y ejecutar:   
cd src   
javac Principal.java Dominio/Controladora.java Dominio/Entidades/\*.java Dominio/Estructuras/\*.java 

Si la compilación termina sin mostrar errores, se generarán archivos .class. 

## **4.4 Ejecución** {#4.4-ejecución}

Desde la carpeta src:   
java Principal 

Se mostrará el menú principal:   
\========== NOVATECH \==========   
1 \- Organigrama   
2 \- Empleados   
3 \- Departamentos   
4 \- Cargos   
5 \- Proyectos y asignaciones   
6 \- Consultas recursivas   
0 \- Salir   
Opción: 

## **4.5 Eliminación de archivos compilados** {#4.5-eliminación-de-archivos-compilados}

Si se desea limpiar la carpeta:   
find . \-name '\*.class' \-delete

Este comando elimina solamente los archivos generados por el compilador, no los .java. 

## **4.6 Uso del Scanner** {#4.6-uso-del-scanner}

La entrada se realiza mediante:   
static Scanner Scanner \= new Scanner(System.in);

Lectura numérica:  
System.out.print("Legajo: ");   
int id \= Scanner.nextInt();   
Scanner.nextLine(); 

Lectura de texto:   
System.out.print("Nombre: ");   
String nombre \= Scanner.nextLine(); 

Después de nextInt() o nextDouble() se ejecuta nextLine() para consumir el Enter que permanece en el búfer.

## **4.7 Menú de organigrama** {#4.7-menú-de-organigrama}

### **Mostrar organigrama**  {#mostrar-organigrama}

Presenta la estructura completa con indentación, cargo, nivel y cantidad total de subordinados. 

### **Reasignar empleado**  {#reasignar-empleado}

Solicita: 

* legajo del empleado;   
* legajo del nuevo jefe. 

La operación se rechaza si genera un ciclo, intenta mover la raíz o utiliza legajos inexistentes. 

### **Mostrar altura**  {#mostrar-altura}

Indica la cantidad máxima de niveles. El valor inicial es 4\. 

### **Mostrar empleados de un nivel**  {#mostrar-empleados-de-un-nivel}

Solicita un nivel numérico. La raíz pertenece al nivel 0\. 

### **Jefe común más cercano**  {#jefe-común-más-cercano}

Solicita dos legajos y muestra el ancestro común más bajo. 

## **4.8 Menú de empleados** {#4.8-menú-de-empleados}

### **Alta**  {#alta}

* Solicita:   
* legajo;   
* nombre;   
* apellido;   
* id de cargo;   
* id de departamento;   
* salario;   
* fecha de ingreso;   
* legajo del jefe. 

Antes del alta conviene consultar los listados de cargos y departamentos. 

### **Modificación**  {#modificación}

Permite modificar cargo, departamento y salario. El legajo no cambia.

### **Baja**  {#baja-1}

Se rechaza si el empleado: 

* no existe;   
* es la raíz;   
* tiene subordinados;   
* es responsable de departamento;   
* es responsable de proyecto. 

### **Búsquedas**  {#búsquedas}

* Por legajo: retorna una única coincidencia.   
* Por apellido: puede retornar varias coincidencias. 

## **4.9 Menú de departamentos** {#4.9-menú-de-departamentos}

Permite alta, modificación, baja y listado. También muestra empleados y cantidad por departamento.  
Para modificar un departamento se solicita el legajo del responsable. 

## **4.10 Menú de cargos** {#4.10-menú-de-cargos}

Permite alta, modificación, baja y listado. 

El nivel jerárquico sugerido es: 

* 1 \= Dirección   
* 2 \= Supervisión   
* 3 \= Operativo 

No puede eliminarse un cargo utilizado por un empleado. 

## **4.11 Menú de proyectos y asignaciones** {#4.11-menú-de-proyectos-y-asignaciones}

### **Proyectos**  {#proyectos}

* Permite:   
* alta;   
* modificación;   
* baja;   
* listado;   
* cambio de estado. 

Estados válidos:   
PLANIFICADO   
EN\_CURSO   
FINALIZADO 

### **Asignaciones**  {#asignaciones}

Permite: 

* asignar un empleado;   
* modificar horas y rol;   
* eliminar una asignación;  
* listar asignaciones;   
* calcular horas totales de un proyecto. 

## **4.12 Menú de consultas recursivas** {#4.12-menú-de-consultas-recursivas}

* conteo de subordinados totales;   
* cálculo de masa salarial;   
* cadena de mando;   
* organigrama en preorden. 

## **4.13 Identificadores precargados** {#4.13-identificadores-precargados}

### **Empleados**  {#empleados}

Legajo Empleado 1000 Laura Méndez 1001 Diego Pérez 1002 Ana Rodríguez 1003 Martín Silva 1004 Sofía Castro 1005 Pablo Gómez 1006 Lucía Fernández 1007 Carolina Díaz 1008 Jorge Núñez 1009 Valentina Rossi 1010 Fernando López 1011 Camila Torres 

### **Departamentos** {#departamentos}

| Id Departamento | Nombre |
| :---- | :---- |
| 1 | Tecnología |
| 2 | Comercial |
| 3 | RRHH |
| 4 | Dirección General |

### **Cargos** {#cargos}

| Id Cargo | Nombre |
| :---- | :---- |
| 1 | Gerente General |
| 2 | Gerente de Área |
| 3 | Líder |
| 4 | Programador |
| 5 | Administrador de Redes |
| 6 | Vendedor |
| 7 | Analista de RRHH |

### **Proyectos** {#proyectos-1}

| Id Proyecto | Nombre | Estado inicial |
| :---- | :---- | :---- |
| 1 | Migración a la nube | EN\_CURSO |
| 2 | Nuevo sistema CRM | PLANIFICADO |

## **4.14 Errores de entrada**  {#4.14-errores-de-entrada}

La aplicación supone que el usuario ingresa números cuando se solicitan valores numéricos. Si se escribe texto en una lectura nextInt() o nextDouble(), Java puede generar una excepción de entrada.   
Esta limitación se conserva para mantener el código dentro del nivel trabajado. Durante la demostración se recomienda ingresar datos del tipo solicitado.

# **5\. Plan de pruebas** {#5.-plan-de-pruebas}

## **5.1 Objetivo**  {#5.1-objetivo}

El plan verifica que las operaciones produzcan los resultados esperados y que las validaciones protejan la estructura y las relaciones entre entidades. 

## **5.2 Criterios generales** {#5.2-criterios-generales}

* Ejecutar las pruebas desde una nueva instancia de Controladora cuando se necesiten los datos iniciales.   
* Registrar resultado esperado y obtenido.   
* Tomar capturas de las funcionalidades principales.   
* Repetir la compilación antes de la entrega. 

## **5.3 Pruebas de precarga** {#5.3-pruebas-de-precarga}

| Id | Prueba | Resultado esperado |
| :---- | :---- | :---- |
| P01 | Iniciar aplicación | Menú principal visible |
| P02 | Listar empleados | 12 empleados |
| P03 | Listar departamentos | 4 departamentos |
| P04 | Listar cargos | 7 cargos |
| P05 | Listar proyectos | 2 proyectos |
| P06 | Listar asignaciones | 5 asignaciones |

## **5.4 Pruebas del organigrama** {#5.4-pruebas-del-organigrama}

| Id | Operación | Entrada | Resultado esperado |
| :---- | :---- | :---- | :---- |
| A01 | Mostrar organigrama | — | Laura aparece como raíz |
| A02 | Altura inicial | — | 4 |
| A04 | Empleados nivel 2 | 2 | Ana, Pablo, Jorge, Valentina y Camila |
| A05 | Jefe común | 1003 y 1004 | Ana Rodríguez |
| A06 | Jefe común | 1003 y 1006 | Diego Pérez |
| A07 | Jefe común | 1003 y 1008 | Laura Méndez |

## **5.5 Pruebas de búsqueda**  {#5.5-pruebas-de-búsqueda}

| Id | Operación | Entrada | Resultado esperado |
| :---- | :---- | :---- | :---- |
| B01 | Buscar legajo existente | 1003 | Martín Silva |
| B02 | Buscar legajo raíz | 1000 | Laura Méndez |
| B03 | Buscar legajo inexistente | 9999 | No se encontró |
| B04 | Buscar apellido existente | Silva | Martín Silva |
| B05 | Buscar apellido inexistente | García | Lista vacía |

## **5.6 Pruebas recursivas** {#5.6-pruebas-recursivas}

| Id | Operación | Entrada | Resultado esperado |
| :---- | :---- | :---- | :---- |
| R01 | Subordinados de Laura | 1000 | 11 |
| R02 | Subordinados de Diego | 1001 | 5 |
| R03 | Subordinados de Ana | 1002 | 2 |
| R04 | Subordinados de Martín | 1003 | 0 |
| R05 | Masa salarial de DIego | 1001 | 683000 |
| R06 | Cadena de Martín | 1003 | Martín \<- Ana \<- Diego \<- Laura |
| R07 | Cadena de Laura | 1000 | Laura Méndez |

## **5.7 Pruebas de contratación** {#5.7-pruebas-de-contratación}

### **Alta válida**  {#alta-válida}

Datos sugeridos: 

Legajo: 2000   
Nombre: Juan   
Apellido: Prueba   
Cargo: 4   
Departamento: 1   
Salario: 90000   
Fecha: 02/11/2026  
Jefe: 1002

Resultado esperado:

* Operación realizada;   
* Empleado visible en búsquedas;   
* Aparece debajo de Ana;   
* Nivel 3\.

### **Legajo repetido**  {#legajo-repetido}

Intentar crear otro empleado con legajo 1003\.   
Resultado esperado: Operación rechazada.

### **Jefe inexistente** {#jefe-inexistente}

Crear un empleado indicando jefe 9999\.   
Resultado esperado: Operación rechazada. 

## **5.8 Pruebas de baja** {#5.8-pruebas-de-baja}

| Id | Entrada | Condición | Resultado esperado |
| :---- | :---- | :---- | :---- |
| D01 | 1000 | Es raíz | Rechazada |
| D02 | 1001 | Tiene subordinados | Rechazada |
| D03 | 1007 | Responsable | Rechazada |
| D04 | 1009 | Hoja no responsable | Aceptada |
| D05 | 9999 | No existe | Rechazada |

Después de D04, Valentina no debe aparecer en búsquedas ni listados. 

## **5.9 Pruebas de reasignación** {#5.9-pruebas-de-reasignación}

### **Reasignación válida** {#reasignación-válida}

Mover a Ana (1002) debajo de Jorge (1008). 

Resultado esperado:   
Ana: nivel 3   
Martín: nivel 4   
Sofía: nivel 4   
Altura total: 5 

### **Intento de ciclo**  {#intento-de-ciclo}

Después de la operación anterior, intentar mover a Jorge (1008) debajo de Martín (1003).   
Resultado esperado: 	Operación rechazada y árbol sin modificaciones. 

### **Mover la raíz**  {#mover-la-raíz}

Intentar mover a Laura (1000) debajo de Diego (1001).   
Resultado esperado: Operación rechazada. 

### **Empleado como su propio jefe**  {#empleado-como-su-propio-jefe}

Intentar mover 1003 debajo de 1003\.   
Resultado esperado: Operación rechazada.

## **5.10 Pruebas de cargos**  {#5.10-pruebas-de-cargos}

| Id | Operación | Resultado esperado |
| :---- | :---- | :---- |
| C01 | Alta con id nuevo y salario positivo | Aceptada |
| C02 | Alta con id repetido | Rechazada |
| C03 | Modificar nombre y salario | Datos actualizados |
| C04 | Eliminar cargo 4, actualmente en uso | Rechazada |
| C05 | Eliminar cargo nuevo sin uso | Aceptada |

## **5.11 Pruebas de departamentos** {#5.11-pruebas-de-departamentos}

| Id | Operación | Resultado esperado |
| :---- | :---- | :---- |
| DP01 | Listar empleados de Tecnología | 6 empleados inicialmente |
| DP02 | Eliminar Tecnología | Rechazada |
| DP03 | Alta de departamento nuevo | Aceptada |
| DP04 | Modificar responsable con legajo válido | Aceptada |
| DP05 | Eliminar departamento sin empleados | Aceptada |

## **5.12 Pruebas de proyectos** {#5.12-pruebas-de-proyectos}

| Id | Operación | Entrada | Resultado esperado |
| :---- | :---- | :---- | :---- |
| PR01 | Horas proyecto 1 | 1 | 80 |
| PR02 | Horas proyecto 2 | 2 | 35 |
| PR03 | Estado válido | FINALIZADO | Aceptado |
| PR04 | Estado inválido | PAUSADO | Rechazado |
| PR05 | Asignar empleado nuevo | Datos válidos | Aceptado |
| PR06 | Repetir empleado en proyecto | Mismo empleado/proyecto | Rechazado |
| PR07 | Asignar cero horas | 0 | Rechazado |
| PR08 | Eliminar proyecto | Id existente | Proyecto y asignaciones eliminados |

## **5.13 Registro de ejecución** {#5.13-registro-de-ejecución}

| Id | Resultado obtenido | Estado | Observaciones |
| :---- | :---- | :---- | :---- |
| P01 |  | Pendiente |  |
| A01 |  | Pendiente |  |
| A02 |  | Pendiente |  |
| B01 |  | Pendiente |  |
| R01 |  | Pendiente |  |
| R05 |  | Pendiente |  |
| D02 |  | Pendiente |  |
| D04 |  | Pendiente |  |

## **5.14 Verificaciones ya realizadas durante el desarrollo**  {#5.14-verificaciones-ya-realizadas-durante-el-desarrollo}

Durante la preparación del proyecto se verificaron: 

* compilación completa con javac;   
* inicio y cierre de la aplicación;   
* alta y búsqueda de un empleado mediante consola;   
* conteo de subordinados de Diego igual a 5;   
* masa salarial de Diego igual a 683000;   
* cadena de mando de Martín;   
* reasignación válida de un subárbol;   
* actualización de niveles descendientes;   
* cambio de altura de 4 a 5;   
* rechazo de una reasignación cíclica;   
* baja válida de una hoja;   
* rechazo de la baja de un cargo en uso;   
* horas del proyecto 1 iguales a 80\.

# **6\. Guía para la defensa oral** {#6.-guía-para-la-defensa-oral}

## **6.1 Objetivo**  {#6.1-objetivo}

La defensa debe demostrar que el grupo comprende la estructura utilizada, las decisiones adoptadas y el comportamiento de los algoritmos. No es suficiente ejecutar las opciones; cada integrante debe poder explicar qué sucede internamente. 

## **6.2 Presentación sugerida** {#6.2-presentación-sugerida}

### **Parte 1 \- Problema y modelo**  {#parte-1---problema-y-modelo}

Explicar brevemente: 

* qué necesidad tiene NovaTech;   
* por qué la jerarquía se representa con un árbol;   
* por qué el árbol es N-ario;   
* quién ocupa la raíz;   
* qué representan los hijos de un nodo. 

### **Parte 2 \- Arquitectura**  {#parte-2---arquitectura}

Mostrar el diagrama UML y explicar: 

* Principal para consola;   
* Controladora para coordinación y validaciones;   
* entidades para datos;   
* NodoEmpleado para la posición jerárquica;   
* ArbolOrganigrama para algoritmos estructurales. 

### **Parte 3 \- Demostración**  {#parte-3---demostración}

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

### **Parte 4 \- Algoritmos**  {#parte-4---algoritmos}

Elegir al menos dos métodos recursivos y seguir sus llamadas utilizando un ejemplo pequeño.

## **6.3 Preguntas y respuestas sugeridas**  {#6.3-preguntas-y-respuestas-sugeridas}

### **¿Por qué utilizaron un árbol?**  {#¿por-qué-utilizaron-un-árbol?}

Porque la empresa posee una estructura jerárquica con una única raíz. Cada empleado, excepto el Gerente General, tiene un único jefe y puede tener subordinados. 

### **¿Por qué es N-ario y no binario?**  {#¿por-qué-es-n-ario-y-no-binario?}

Porque un jefe puede tener más de dos subordinados. La lista aSubordinados permite almacenar cualquier cantidad de hijos. 

### **¿Qué es la raíz?**  {#¿qué-es-la-raíz?}

Es el primer nodo del árbol. Representa al Gerente General, tiene nivel 0 y su referencia a jefe es null. 

### **¿Qué representa un nodo?**  {#¿qué-representa-un-nodo?}

Representa la ubicación de un empleado dentro del organigrama. Contiene al empleado, su jefe, su lista de subordinados y su nivel. 

### **¿Por qué separaron Empleado de NodoEmpleado?**  {#¿por-qué-separaron-empleado-de-nodoempleado?}

Para separar los datos laborales de la estructura del árbol. Empleado representa a la persona; NodoEmpleado representa su posición jerárquica. 

### **¿Qué significa legajo?**  {#¿qué-significa-legajo?}

Es el identificador único del empleado dentro de la empresa. En el código corresponde a Empleado.aId. 

### **¿Qué diferencia existe entre nivel jerárquico y nivel del árbol?**  {#¿qué-diferencia-existe-entre-nivel-jerárquico-y-nivel-del-árbol?}

El nivel jerárquico pertenece al cargo y clasifica el tipo de responsabilidad. El nivel del árbol pertenece al nodo e indica su distancia desde la raíz. 

### **¿Qué es un caso base?**  {#¿qué-es-un-caso-base?}

Es la condición que detiene las llamadas recursivas. Por ejemplo, en una búsqueda se detiene al encontrar null o el legajo buscado. 

### **¿Qué es el paso recursivo?**  {#¿qué-es-el-paso-recursivo?}

Es la llamada del método sobre una parte más pequeña del problema. En este árbol consiste en ejecutar el método para cada subordinado. 

### **¿Cómo funciona la búsqueda por legajo?**  {#¿cómo-funciona-la-búsqueda-por-legajo?}

Compara el nodo actual. Si coincide, lo retorna. En caso contrario busca recursivamente en cada subárbol hasta encontrarlo o agotar todos los nodos. 

### **¿Por qué se considera DFS?**  {#¿por-qué-se-considera-dfs?}

Porque profundiza en el subárbol de un hijo antes de continuar con el siguiente hijo del mismo nivel. 

### **¿Cómo cuentan subordinados totales?**  {#¿cómo-cuentan-subordinados-totales?}

Se comienza con la cantidad de hijos directos y se suma recursivamente la cantidad de descendientes de cada hijo.  
33 

### **¿Cómo calculan la masa salarial?**  {#¿cómo-calculan-la-masa-salarial?}

Se toma el salario del empleado actual y se suma la masa salarial calculada recursivamente para cada subordinado. 

### **¿Qué representa la altura?**  {#¿qué-representa-la-altura?}

La cantidad máxima de niveles del árbol. Una hoja tiene altura 1 y el árbol vacío altura 0\. 

### **¿Qué representa el nivel?**  {#¿qué-representa-el-nivel?}

La profundidad de un nodo desde la raíz. La raíz está en nivel 0 y cada hijo tiene el nivel de su jefe más uno. 

### **¿Por qué deben actualizar niveles al reasignar?**  {#¿por-qué-deben-actualizar-niveles-al-reasignar?}

Porque al mover un empleado también se mueve todo su subárbol. Todos los descendientes cambian su distancia respecto de la raíz. 

### **¿Cómo impiden un ciclo?**  {#¿cómo-impiden-un-ciclo?}

Antes de reasignar se busca si el nuevo jefe ya pertenece al subárbol del empleado. Si pertenece, la operación se rechaza. 

### **¿Qué ocurriría si existiera un ciclo?**  {#¿qué-ocurriría-si-existiera-un-ciclo?}

La estructura dejaría de ser un árbol y algunos recorridos recursivos podrían no terminar. 

### **¿Cómo se obtiene la cadena de mando?**  {#¿cómo-se-obtiene-la-cadena-de-mando?}

Se comienza en el empleado y se sigue recursivamente la referencia al jefe hasta alcanzar la raíz, cuyo jefe es null. 

### **¿Cómo encuentran el jefe común más cercano?**  {#¿cómo-encuentran-el-jefe-común-más-cercano?}

Primero se igualan los niveles de ambos nodos. Luego se suben simultáneamente hasta que ambos apuntan al mismo nodo. 

### **¿Qué regla eligieron para la baja?**  {#¿qué-regla-eligieron-para-la-baja?}

Se impide eliminar un empleado con subordinados. También se protege la raíz y los responsables de departamentos o proyectos. 

### **¿Qué pasa con las asignaciones al eliminar un empleado válido?**  {#¿qué-pasa-con-las-asignaciones-al-eliminar-un-empleado-válido?}

Se eliminan de la lista general y de la lista del proyecto correspondiente.

### **¿Por qué los datos se pierden al cerrar?**  {#¿por-qué-los-datos-se-pierden-al-cerrar?}

Porque se almacenan únicamente en memoria y el alcance no incluye base de datos ni archivos. 

### **¿Por qué las fechas son String?**  {#¿por-qué-las-fechas-son-string?}

Porque el proyecto está centrado en árboles y recursividad. Guardarlas como texto evita agregar una API no necesaria para los objetivos evaluados. 

### **¿Para qué se usa Scanner.nextLine() después de nextInt()?**  {#¿para-qué-se-usa-scanner.nextline()-después-de-nextint()?}

Para consumir el salto de línea que queda pendiente después de leer un número. De lo contrario, una lectura de texto posterior puede quedar vacía.

## **6.4 Seguimiento manual de una búsqueda** {#6.4-seguimiento-manual-de-una-búsqueda}

Buscar el legajo 1006, correspondiente a Lucía:  
Buscar(Laura, 1006\)   
├── Laura no coincide   
└── Buscar(Diego, 1006\)   
├── Diego no coincide   
└── Buscar(Ana, 1006\)   
 		├── Ana no coincide   
 		├── Buscar(Martín, 1006\) \-\> null    
 		└── Buscar(Sofía, 1006\) \-\> null    
└── Buscar(Pablo, 1006\)   
 		├── Pablo no coincide   
 		└── Buscar(Lucía, 1006\) \-\> encontrada 

## **6.5 Seguimiento manual del conteo** {#6.5-seguimiento-manual-del-conteo}

Contar subordinados de Ana:

Ana tiene 2 hijos directos: Martín y Sofía.   
Martín tiene 0 hijos.   
Sofía tiene 0 hijos.  
   
Resultado \= 2 \+ 0 \+ 0 \= 2\. 

## **6.6 Seguimiento manual de masa salarial** {#6.6-seguimiento-manual-de-masa-salarial}

Rama de Ana:

Masa(Ana)   
\= salario Ana \+ Masa(Martín) \+ Masa(Sofía)  
\= 125000 \+ 92000 \+ 91000   
\= 308000

## **6.7 Distribución posible de la exposición** {#6.7-distribución-posible-de-la-exposición}

### **Integrante 1**  {#integrante-1}

* problema;   
* entidades;   
* arquitectura;   
* árbol N-ario. 

### **Integrante 2**  {#integrante-2}

* búsqueda DFS;   
* preorden;   
* subordinados y masa salarial. 

### **Integrante 3**  {#integrante-3}

* reasignación;   
* prevención de ciclos;   
* altura, nivel y jefe común. 

### **Integrante 4, si corresponde** {#integrante-4,-si-corresponde}

* ABM;  
* proyectos y asignaciones;  
* validaciones y pruebas.

## **6.8 Recomendaciones para la demostración**  {#6.8-recomendaciones-para-la-demostración}

* Compilar antes de comenzar.   
* Utilizar los legajos precargados.   
* Tener preparada una secuencia corta de opciones.   
* No improvisar datos numéricos difíciles de recordar.   
* Mostrar al menos una validación rechazada.   
* Explicar el resultado antes de ejecutar la opción.   
* Evitar modificar demasiados datos antes de las capturas principales.   
* Si se necesita volver al estado inicial, cerrar y reiniciar la aplicación. 

## **6.9 Aspectos que deben confirmar con el docente** {#6.9-aspectos-que-deben-confirmar-con-el-docente}

* criterio exacto para la altura: niveles o aristas;   
* si el desafío del jefe común es obligatorio para todos los grupos;   
* formato solicitado para el UML y el PDF.

## **7\. Capturas de funcionamiento** {#7.-capturas-de-funcionamiento}

## **7.1 Menú principal** {#7.1-menú-principal}

## **7.2 Organigrama completo** {#7.2-organigrama-completo}

## **7.3 Búsqueda de empleado** {#7.3-búsqueda-de-empleado}

## **7.4 Conteo de subordinados** {#7.4-conteo-de-subordinados}

## **7.5 Masa salarial** {#7.5-masa-salarial}

## **7.6 Cadena de mando** {#7.6-cadena-de-mando}

## **7.7 Empleados por nivel** {#7.7-empleados-por-nivel}

## **7.8 Organigrama antes de una reasignación** {#7.8-organigrama-antes-de-una-reasignación}

## **7.9 Organigrama después de una reasignación** {#7.9-organigrama-después-de-una-reasignación}

## **7.10 Prevención de ciclos** {#7.10-prevención-de-ciclos}

## **7.11 Listado de proyectos** {#7.11-listado-de-proyectos}

## **7.12 Asignaciones y horas** {#7.12-asignaciones-y-horas}