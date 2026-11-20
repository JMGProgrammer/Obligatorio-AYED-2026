import java.util.ArrayList;
import java.util.Scanner;

import Dominio.Controladora;
import Dominio.Entidades.Asignacion;
import Dominio.Entidades.Cargo;
import Dominio.Entidades.Departamento;
import Dominio.Entidades.Empleado;
import Dominio.Entidades.Proyecto;
import Dominio.Estructuras.ArbolOrganigrama;

public class Principal {

    static Scanner Scanner = new Scanner(System.in);
    static Controladora aControladora = new Controladora();
    static ArbolOrganigrama aOrganigrama = new ArbolOrganigrama();
    static ArrayList<Departamento> aDepartamentos = new ArrayList<Departamento>();
    static ArrayList<Cargo> aCargos = new ArrayList<Cargo>();
    static ArrayList<Proyecto> aProyectos = new ArrayList<Proyecto>();
    static ArrayList<Asignacion> aAsignaciones = new ArrayList<Asignacion>();

    public static void main(String[] pArgs) {
        aControladora.PrecargarDatos(aOrganigrama, aDepartamentos, aCargos,
                aProyectos, aAsignaciones);
        int opcion;

        do {
            System.out.println("\n╔══════════════════════════════════════╗");
            System.out.println("║       NOVATECH · MENÚ PRINCIPAL      ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║  1 » Organigrama                     ║");
            System.out.println("║  2 » Empleados                       ║");
            System.out.println("║  3 » Departamentos                   ║");
            System.out.println("║  4 » Cargos                          ║");
            System.out.println("║  5 » Proyectos y asignaciones        ║");
            System.out.println("║  6 » Consultas recursivas            ║");
            System.out.println("╠──────────────────────────────────────╣");
            System.out.println("║  0 « Salir                           ║");
            System.out.println("╚══════════════════════════════════════╝");
            opcion = LeerEntero("  > Opción: ");

            switch (opcion) {
                case 1:
                    MenuOrganigrama();
                    break;
                case 2:
                    MenuEmpleados();
                    break;
                case 3:
                    MenuDepartamentos();
                    break;
                case 4:
                    MenuCargos();
                    break;
                case 5:
                    MenuProyectos();
                    break;
                case 6:
                    MenuConsultas();
                    break;
                case 0:
                    System.out.println("\n  [OK] Programa finalizado correctamente.");
                    break;
                default:
                    System.out.println("\n  [X] Opción incorrecta. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    // ---------------- MENÚ ORGANIGRAMA ----------------

    public static void MenuOrganigrama() {
        int opcion;
        do {
            System.out.println("\n╔══════════ ORGANIGRAMA ══════════╗");
            System.out.println("║  1 » Mostrar árbol              ║");
            System.out.println("║  2 » Reasignar empleado         ║");
            System.out.println("║  3 » Mostrar altura             ║");
            System.out.println("║  4 » Empleados de un nivel      ║");
            System.out.println("║  5 » Jefe común más cercano     ║");
            System.out.println("╠─────────────────────────────────╣");
            System.out.println("║  0 « Volver                     ║");
            System.out.println("╚═════════════════════════════════╝");
            opcion = LeerEntero("  > Opción: ");

            switch (opcion) {
                case 1:
                    MostrarOrganigrama();
                    break;
                case 2:
                    ReasignarEmpleado();
                    break;
                case 3:
                    MostrarAlturaOrganigrama();
                    break;
                case 4:
                    ListarEmpleadosDeNivel();
                    break;
                case 5:
                    MostrarJefeComun();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\n  [X] Opción incorrecta. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    public static void ReasignarEmpleado() {
        int idEmpleado = LeerEntero("Legajo del empleado: ");
        int idJefe = LeerEntero("Legajo del nuevo jefe: ");
        MostrarResultado(aOrganigrama.Reasignar(idEmpleado, idJefe));
    }

    public static void MostrarOrganigrama() {
        System.out.println("\n╔═════════════════════════════════════════╗");
        System.out.println("║         ORGANIGRAMA JERÁRQUICO          ║");
        System.out.println("╠═════════════════════════════════════════╣");
        System.out.println("║   Recorrido preorden del árbol N-ario   ║");
        System.out.println("╚═════════════════════════════════════════╝");
        System.out.print(aOrganigrama.MostrarOrganigrama());
    }

    public static void MostrarAlturaOrganigrama() {
        int altura = aOrganigrama.CalcularAltura();
        System.out.println("\n  [i] Altura del árbol: " + altura + " niveles.");
    }

    public static void ListarEmpleadosDeNivel() {
        int nivel = LeerEntero("Nivel: ");
        ArrayList<Empleado> empleados = aOrganigrama.EmpleadosDelNivel(nivel);
        MostrarEmpleados(empleados);
    }

    public static void MostrarJefeComun() {
        int primero = LeerEntero("Primer legajo: ");
        int segundo = LeerEntero("Segundo legajo: ");
        Empleado jefe = aOrganigrama.JefeComunMasCercano(primero, segundo);

        if (jefe == null) {
            System.out.println("No se encontró.");
        } else {
            System.out.println("Jefe común: " + jefe);
        }
    }

    // ---------------- MENÚ EMPLEADOS ----------------

    public static void MenuEmpleados() {
        int opcion;
        do {
            System.out.println("\n╔═══════════ EMPLEADOS ═══════════╗");
            System.out.println("║  1 » Alta                       ║");
            System.out.println("║  2 » Modificación               ║");
            System.out.println("║  3 » Baja                       ║");
            System.out.println("║  4 » Buscar por legajo          ║");
            System.out.println("║  5 » Buscar por apellido        ║");
            System.out.println("║  6 » Listado                    ║");
            System.out.println("╠─────────────────────────────────╣");
            System.out.println("║  0 « Volver                     ║");
            System.out.println("╚═════════════════════════════════╝");
            opcion = LeerEntero("  > Opción: ");

            switch (opcion) {
                case 1:
                    AltaEmpleado();
                    break;
                case 2:
                    ModificarEmpleado();
                    break;
                case 3:
                    BajaEmpleado();
                    break;
                case 4:
                    BuscarEmpleadoPorLegajo();
                    break;
                case 5:
                    BuscarEmpleadoPorApellido();
                    break;
                case 6:
                    MostrarEmpleados(aOrganigrama.ListarEmpleados());
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\n  [X] Opción incorrecta. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    public static void AltaEmpleado() {
        int id = LeerEntero("Legajo: ");
        String nombre = LeerTexto("Nombre: ");
        String apellido = LeerTexto("Apellido: ");
        int idCargo = LeerEntero("Id del cargo: ");
        int idDepartamento = LeerEntero("Id del departamento: ");
        double salario = LeerDouble("Salario: ");
        String fecha = LeerTexto("Fecha de ingreso: ");
        int idJefe = LeerEntero("Legajo del jefe: ");

        Cargo cargo = aControladora.BuscarCargo(aCargos, idCargo);
        Departamento departamento = aControladora.BuscarDepartamento(
                aDepartamentos, idDepartamento);
        Empleado empleado = new Empleado(id, nombre, apellido, cargo,
                departamento, salario, fecha);

        MostrarResultado(aControladora.ContratarEmpleado(
                aOrganigrama, empleado, idJefe));
    }

    public static void ModificarEmpleado() {
        int id = LeerEntero("Legajo: ");
        int idCargo = LeerEntero("Nuevo id de cargo: ");
        int idDepartamento = LeerEntero("Nuevo id de departamento: ");
        double salario = LeerDouble("Nuevo salario: ");
        MostrarResultado(aControladora.ModificarEmpleado(aOrganigrama, aCargos,
                aDepartamentos, id, idCargo, idDepartamento, salario));
    }

    public static void BajaEmpleado() {
        int id = LeerEntero("Legajo: ");
        boolean resultado = aControladora.BajaEmpleado(aOrganigrama,
                aDepartamentos, aProyectos, aAsignaciones, id);
        if (!resultado) {
            System.out.println("No se pudo Eliminar. Puede tener subordinados, "
                    + "ser responsable, ser la raíz o no existir.");
        } else {
            MostrarResultado(true);
        }
    }

    public static void BuscarEmpleadoPorLegajo() {
        int id = LeerEntero("Legajo: ");
        Empleado empleado = aControladora.BuscarEmpleado(aOrganigrama, id);
        if (empleado == null) {
            System.out.println("No se encontró.");
        } else {
            System.out.println(empleado);
        }
    }

    public static void BuscarEmpleadoPorApellido() {
        String apellido = LeerTexto("Apellido: ");
        ArrayList<Empleado> empleados = aOrganigrama.BuscarPorApellido(apellido);
        MostrarEmpleados(empleados);
    }

    // ---------------- MENÚ DEPARTAMENTOS ----------------

    public static void MenuDepartamentos() {
        int opcion;
        do {
            System.out.println("\n╔═════════ DEPARTAMENTOS ═════════╗");
            System.out.println("║  1 » Alta                       ║");
            System.out.println("║  2 » Modificación               ║");
            System.out.println("║  3 » Baja                       ║");
            System.out.println("║  4 » Listado                    ║");
            System.out.println("║  5 » Empleados por departamento ║");
            System.out.println("╠─────────────────────────────────╣");
            System.out.println("║  0 « Volver                     ║");
            System.out.println("╚═════════════════════════════════╝");
            opcion = LeerEntero("  > Opción: ");

            switch (opcion) {
                case 1:
                    AltaDepartamento();
                    break;
                case 2:
                    ModificarDepartamento();
                    break;
                case 3:
                    BajaDepartamento();
                    break;
                case 4:
                    MostrarDepartamentos();
                    break;
                case 5:
                    MostrarEmpleadosDepartamento();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\n  [X] Opción incorrecta. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    public static void AltaDepartamento() {
        int id = LeerEntero("Id: ");
        String nombre = LeerTexto("Nombre: ");
        String descripcion = LeerTexto("Descripción: ");
        Departamento departamento = new Departamento(
                id, nombre, descripcion, null);
        MostrarResultado(aControladora.AltaDepartamento(
                aDepartamentos, departamento));
    }

    public static void ModificarDepartamento() {
        int id = LeerEntero("Id: ");
        String nombre = LeerTexto("Nuevo nombre: ");
        String descripcion = LeerTexto("Nueva descripción: ");
        int responsable = LeerEntero("Legajo del responsable: ");
        MostrarResultado(aControladora.ModificarDepartamento(aOrganigrama,
                aDepartamentos, id, nombre, descripcion, responsable));
    }

    public static void BajaDepartamento() {
        int id = LeerEntero("Id: ");
        MostrarResultado(aControladora.BajaDepartamento(
                aOrganigrama, aDepartamentos, id));
    }

    public static void MostrarDepartamentos() {
        for (int i = 0; i < aDepartamentos.size(); i++) {
            System.out.println(aDepartamentos.get(i));
        }
    }

    public static void MostrarEmpleadosDepartamento() {
        int id = LeerEntero("Id del departamento: ");
        ArrayList<Empleado> empleados = aControladora.EmpleadosDeDepartamento(
                aOrganigrama, id);
        MostrarEmpleados(empleados);
        System.out.println("Cantidad: " + empleados.size());
    }

    // ---------------- MENÚ CARGOS ----------------

    public static void MenuCargos() {
        int opcion;
        do {
            System.out.println("\n╔════════════ CARGOS ═════════════╗");
            System.out.println("║  1 » Alta                       ║");
            System.out.println("║  2 » Modificación               ║");
            System.out.println("║  3 » Baja                       ║");
            System.out.println("║  4 » Listado                    ║");
            System.out.println("╠─────────────────────────────────╣");
            System.out.println("║  0 « Volver                     ║");
            System.out.println("╚═════════════════════════════════╝");
            opcion = LeerEntero("  > Opción: ");

            switch (opcion) {
                case 1:
                    AltaCargo();
                    break;
                case 2:
                    ModificarCargo();
                    break;
                case 3:
                    BajaCargo();
                    break;
                case 4:
                    MostrarCargos();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\n  [X] Opción incorrecta. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    public static void AltaCargo() {
        int id = LeerEntero("Id: ");
        String nombre = LeerTexto("Nombre: ");
        int nivel = LeerEntero("Nivel jerárquico: ");
        double salario = LeerDouble("Salario base: ");
        MostrarResultado(aControladora.AltaCargo(aCargos,
                new Cargo(id, nombre, nivel, salario)));
    }

    public static void ModificarCargo() {
        int id = LeerEntero("Id: ");
        String nombre = LeerTexto("Nuevo nombre: ");
        int nivel = LeerEntero("Nuevo nivel jerárquico: ");
        double salario = LeerDouble("Nuevo salario base: ");
        MostrarResultado(aControladora.ModificarCargo(
                aCargos, id, nombre, nivel, salario));
    }

    public static void BajaCargo() {
        int id = LeerEntero("Id: ");
        MostrarResultado(aControladora.BajaCargo(aOrganigrama, aCargos, id));
    }

    public static void MostrarCargos() {
        for (int i = 0; i < aCargos.size(); i++) {
            System.out.println(aCargos.get(i));
        }
    }

    // ---------------- MENÚ PROYECTOS ----------------

    public static void MenuProyectos() {
        int opcion;
        do {
            System.out.println("\n╔═════ PROYECTOS Y ASIGNACIONES ═════╗");
            System.out.println("║  1  » Alta de proyecto             ║");
            System.out.println("║  2  » Modificación de proyecto     ║");
            System.out.println("║  3  » Baja de proyecto             ║");
            System.out.println("║  4  » Listar proyectos             ║");
            System.out.println("║  5  » Cambiar estado               ║");
            System.out.println("║  6  » Asignar empleado             ║");
            System.out.println("║  7  » Modificar asignación         ║");
            System.out.println("║  8  » Baja de asignación           ║");
            System.out.println("║  9  » Listar asignaciones          ║");
            System.out.println("║  10 » Calcular horas del proyecto  ║");
            System.out.println("╠────────────────────────────────────╣");
            System.out.println("║  0  « Volver                       ║");
            System.out.println("╚════════════════════════════════════╝");
            opcion = LeerEntero("  > Opción: ");

            switch (opcion) {
                case 1:
                    AltaProyecto();
                    break;
                case 2:
                    ModificarProyecto();
                    break;
                case 3:
                    BajaProyecto();
                    break;
                case 4:
                    MostrarProyectos();
                    break;
                case 5:
                    CambiarEstadoProyecto();
                    break;
                case 6:
                    AltaAsignacion();
                    break;
                case 7:
                    ModificarAsignacion();
                    break;
                case 8:
                    BajaAsignacion();
                    break;
                case 9:
                    MostrarAsignaciones();
                    break;
                case 10:
                    MostrarHorasProyecto();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\n  [X] Opción incorrecta. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    public static void AltaProyecto() {
        int id = LeerEntero("Id: ");
        String nombre = LeerTexto("Nombre: ");
        String inicio = LeerTexto("Fecha de inicio: ");
        String fin = LeerTexto("Fecha de fin: ");
        String estado = LeerTexto("Estado: ");
        int responsable = LeerEntero("Legajo del responsable: ");
        Proyecto proyecto = new Proyecto(id, nombre, inicio, fin, estado,
                aControladora.BuscarEmpleado(aOrganigrama, responsable));
        MostrarResultado(aControladora.AltaProyecto(aProyectos, proyecto));
    }

    public static void ModificarProyecto() {
        int id = LeerEntero("Id: ");
        String nombre = LeerTexto("Nuevo nombre: ");
        String inicio = LeerTexto("Nueva fecha de inicio: ");
        String fin = LeerTexto("Nueva fecha de fin: ");
        int responsable = LeerEntero("Legajo del responsable: ");
        MostrarResultado(aControladora.ModificarProyecto(aOrganigrama,
                aProyectos, id, nombre, inicio, fin, responsable));
    }

    public static void BajaProyecto() {
        int id = LeerEntero("Id: ");
        MostrarResultado(aControladora.BajaProyecto(
                aProyectos, aAsignaciones, id));
    }

    public static void CambiarEstadoProyecto() {
        int id = LeerEntero("Id: ");
        String estado = LeerTexto("PLANIFICADO, EN_CURSO o FINALIZADO: ");
        MostrarResultado(aControladora.CambiarEstadoProyecto(
                aProyectos, id, estado));
    }

    public static void AltaAsignacion() {
        int id = LeerEntero("Id de asignación: ");
        int empleado = LeerEntero("Legajo: ");
        int proyecto = LeerEntero("Id de proyecto: ");
        int horas = LeerEntero("Horas asignadas: ");
        String rol = LeerTexto("Rol: ");
        MostrarResultado(aControladora.AsignarEmpleadoProyecto(aOrganigrama,
                aProyectos, aAsignaciones, id, empleado, proyecto, horas, rol));
    }

    public static void ModificarAsignacion() {
        int id = LeerEntero("Id de asignación: ");
        int horas = LeerEntero("Nuevas horas: ");
        String rol = LeerTexto("Nuevo rol: ");
        MostrarResultado(aControladora.ModificarAsignacion(
                aAsignaciones, id, horas, rol));
    }

    public static void BajaAsignacion() {
        int id = LeerEntero("Id de asignación: ");
        MostrarResultado(aControladora.BajaAsignacion(aAsignaciones, id));
    }

    public static void MostrarHorasProyecto() {
        int id = LeerEntero("Id del proyecto: ");
        int horas = aControladora.CalcularHorasProyecto(aProyectos, id);

        if (horas == -1) {
            System.out.println("El proyecto no existe.");
        } else {
            System.out.println("Horas totales: " + horas);
        }
    }

    public static void MostrarProyectos() {
        for (int i = 0; i < aProyectos.size(); i++) {
            Proyecto proyecto = aProyectos.get(i);
            System.out.println(proyecto + " | horas: "
                    + aControladora.CalcularHorasProyecto(
                            aProyectos, proyecto.getId()));
        }
    }

    public static void MostrarAsignaciones() {
        for (int i = 0; i < aAsignaciones.size(); i++) {
            System.out.println(aAsignaciones.get(i));
        }
    }

    // ---------------- CONSULTAS RECURSIVAS ----------------

    public static void MenuConsultas() {
        int opcion;
        do {
            System.out.println("\n╔══════ CONSULTAS RECURSIVAS ══════╗");
            System.out.println("║  1 » Contar subordinados totales ║");
            System.out.println("║  2 » Calcular masa salarial      ║");
            System.out.println("║  3 » Mostrar cadena de mando     ║");
            System.out.println("║  4 » Organigrama en preorden     ║");
            System.out.println("╠──────────────────────────────────╣");
            System.out.println("║  0 « Volver                      ║");
            System.out.println("╚══════════════════════════════════╝");
            opcion = LeerEntero("  > Opción: ");

            switch (opcion) {
                case 1:
                    MostrarCantidadSubordinados();
                    break;
                case 2:
                    MostrarMasaSalarial();
                    break;
                case 3:
                    MostrarCadenaDeMando();
                    break;
                case 4:
                    MostrarOrganigrama();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\n  [X] Opción incorrecta. Intente nuevamente.");
            }
        } while (opcion != 0);
    }

    public static void MostrarCantidadSubordinados() {
        int id = LeerEntero("Legajo: ");
        int cantidad = aOrganigrama.ContarSubordinados(id);

        if (cantidad == -1) {
            System.out.println("El empleado no existe.");
        } else {
            System.out.println("Subordinados: " + cantidad);
        }
    }

    public static void MostrarMasaSalarial() {
        int id = LeerEntero("Legajo: ");
        double masaSalarial = aOrganigrama.CalcularMasaSalarial(id);

        if (masaSalarial == -1) {
            System.out.println("El empleado no existe.");
        } else {
            System.out.println("Masa salarial: $" + masaSalarial);
        }
    }

    public static void MostrarCadenaDeMando() {
        int id = LeerEntero("Legajo: ");
        String cadena = aOrganigrama.ObtenerCadenaDeMando(id);
        System.out.println(cadena);
    }

    // ---------------- MÉTODOS AUXILIARES ----------------

    public static void MostrarEmpleados(ArrayList<Empleado> pEmpleados) {
        if (pEmpleados.size() == 0) {
            System.out.println("  [i] No hay empleados para mostrar.");
        }

        for (int i = 0; i < pEmpleados.size(); i++) {
            System.out.println(pEmpleados.get(i));
        }
    }

    public static int LeerEntero(String pMensaje) {
        System.out.print(pMensaje);
        int numero = Scanner.nextInt();
        Scanner.nextLine(); // Limpia el Enter pendiente.
        return numero;
    }

    public static double LeerDouble(String pMensaje) {
        System.out.print(pMensaje);
        double numero = Scanner.nextDouble();
        Scanner.nextLine();
        return numero;
    }

    public static String LeerTexto(String pMensaje) {
        System.out.print(pMensaje);
        return Scanner.nextLine();
    }

    public static void MostrarResultado(boolean pResultado) {
        if (pResultado) {
            System.out.println("\n  [OK] Operación realizada correctamente.");
        } else {
            System.out.println("\n  [X] No se pudo realizar la operación.");
        }
    }
}
