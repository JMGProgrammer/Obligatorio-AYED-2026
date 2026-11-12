package Dominio;

import java.util.ArrayList;
import Dominio.Entidades.Asignacion;
import Dominio.Entidades.Cargo;
import Dominio.Entidades.Departamento;
import Dominio.Entidades.Empleado;
import Dominio.Entidades.Proyecto;
import Dominio.Estructuras.ArbolOrganigrama;
import Dominio.Estructuras.NodoEmpleado;

public class Controladora {

    private ArbolOrganigrama aOrganigrama;
    private ArrayList<Departamento> aDepartamentos;
    private ArrayList<Cargo> aCargos;
    private ArrayList<Proyecto> aProyectos;
    private ArrayList<Asignacion> aAsignaciones;

    public ArbolOrganigrama getOrganigrama(){return this.aOrganigrama;}
    public ArrayList<Departamento> getDepartamentos(){return this.aDepartamentos;}
    public ArrayList<Cargo> getCargos(){return this.aCargos;}
    public ArrayList<Proyecto> getProyectos(){return this.aProyectos;}
    public ArrayList<Asignacion> getAsignaciones(){return this.aAsignaciones;}

    public Controladora() {
        this.aOrganigrama = new ArbolOrganigrama();
        this.aDepartamentos = new ArrayList<Departamento>();
        this.aCargos = new ArrayList<Cargo>();
        this.aProyectos = new ArrayList<Proyecto>();
        this.aAsignaciones = new ArrayList<Asignacion>();
        PrecargarDatos();
    }

    private void PrecargarDatos() {
        // Primero se crean cargos y departamentos porque los empleados los necesitan.
        AltaCargo(new Cargo(1, "Gerente General", 1, 180000));
        AltaCargo(new Cargo(2, "Gerente de Área", 1, 150000));
        AltaCargo(new Cargo(3, "Líder", 2, 120000));
        AltaCargo(new Cargo(4, "Programador", 3, 90000));
        AltaCargo(new Cargo(5, "Administrador de Redes", 3, 95000));
        AltaCargo(new Cargo(6, "Vendedor", 3, 80000));
        AltaCargo(new Cargo(7, "Analista de RRHH", 3, 85000));

        AltaDepartamento(new Departamento(1, "Tecnología",
                "Desarrollo e infraestructura", null));
        AltaDepartamento(new Departamento(2, "Comercial",
                "Ventas y relación con clientes", null));
        AltaDepartamento(new Departamento(3, "RRHH",
                "Gestión de personas", null));
        AltaDepartamento(new Departamento(4, "Dirección General",
                "Dirección de la empresa", null));

        Empleado laura = new Empleado(1000, "Laura", "Méndez",
                BuscarCargo(1), BuscarDepartamento(4), 190000, "10/03/2018");
        this.aOrganigrama.CrearRaiz(laura);

        ContratarEmpleado(new Empleado(1001, "Diego", "Pérez",
                BuscarCargo(2), BuscarDepartamento(1), 155000, "12/05/2019"), 1000);
        ContratarEmpleado(new Empleado(1002, "Ana", "Rodríguez",
                BuscarCargo(3), BuscarDepartamento(1), 125000, "07/08/2020"), 1001);
        ContratarEmpleado(new Empleado(1003, "Martín", "Silva",
                BuscarCargo(4), BuscarDepartamento(1), 92000, "15/02/2022"), 1002);
        ContratarEmpleado(new Empleado(1004, "Sofía", "Castro",
                BuscarCargo(4), BuscarDepartamento(1), 91000, "18/04/2022"), 1002);
        ContratarEmpleado(new Empleado(1005, "Pablo", "Gómez",
                BuscarCargo(3), BuscarDepartamento(1), 123000, "20/09/2020"), 1001);
        ContratarEmpleado(new Empleado(1006, "Lucía", "Fernández",
                BuscarCargo(5), BuscarDepartamento(1), 97000, "11/01/2021"), 1005);
        ContratarEmpleado(new Empleado(1007, "Carolina", "Díaz",
                BuscarCargo(2), BuscarDepartamento(2), 150000, "03/06/2019"), 1000);
        ContratarEmpleado(new Empleado(1008, "Jorge", "Núñez",
                BuscarCargo(6), BuscarDepartamento(2), 82000, "09/11/2021"), 1007);
        ContratarEmpleado(new Empleado(1009, "Valentina", "Rossi",
                BuscarCargo(6), BuscarDepartamento(2), 83000, "14/12/2021"), 1007);
        ContratarEmpleado(new Empleado(1010, "Fernando", "López",
                BuscarCargo(2), BuscarDepartamento(3), 148000, "17/07/2019"), 1000);
        ContratarEmpleado(new Empleado(1011, "Camila", "Torres",
                BuscarCargo(7), BuscarDepartamento(3), 87000, "25/03/2021"), 1010);

        BuscarDepartamento(1).setResponsable(BuscarEmpleado(1001));
        BuscarDepartamento(2).setResponsable(BuscarEmpleado(1007));
        BuscarDepartamento(3).setResponsable(BuscarEmpleado(1010));
        BuscarDepartamento(4).setResponsable(BuscarEmpleado(1000));

        AltaProyecto(new Proyecto(1, "Migración a la nube", "01/09/2026",
                "30/06/2027", "EN_CURSO", BuscarEmpleado(1002)));
        AltaProyecto(new Proyecto(2, "Nuevo sistema CRM", "01/03/2027",
                "30/11/2027", "PLANIFICADO", BuscarEmpleado(1007)));

        AsignarEmpleadoProyecto(1, 1002, 1, 30, "Líder");
        AsignarEmpleadoProyecto(2, 1003, 1, 25, "Desarrollador");
        AsignarEmpleadoProyecto(3, 1004, 1, 25, "Desarrolladora");
        AsignarEmpleadoProyecto(4, 1007, 2, 20, "Responsable funcional");
        AsignarEmpleadoProyecto(5, 1008, 2, 15, "Analista comercial");
    }

    // ---------------- EMPLEADOS Y ORGANIGRAMA ----------------

    public Empleado BuscarEmpleado(int pId) {
        NodoEmpleado nodo = this.aOrganigrama.BuscarPorId(pId);
        if (nodo == null) {
            return null;
        }
        return nodo.getEmpleado();
    }

    public boolean ContratarEmpleado(Empleado pEmpleado, int pIdJefe) {
        if (pEmpleado == null) {
            return false;
        }
        if (pEmpleado.getCargo() == null) {
            return false;
        }
        if (pEmpleado.getDepartamento() == null) {
            return false;
        }
        if (pEmpleado.getSalario() <= 0) {
            return false;
        }
        return this.aOrganigrama.Insertar(pEmpleado, pIdJefe);
    }

    public boolean ModificarEmpleado(int pIdEmpleado, int pIdCargo, int pIdDepartamento, double pSalario) {
        Empleado empleado = BuscarEmpleado(pIdEmpleado);
        Cargo cargo = BuscarCargo(pIdCargo);
        Departamento departamento = BuscarDepartamento(pIdDepartamento);

        if (empleado == null) {
            return false;
        }
        if (cargo == null) {
            return false;
        }
        if (departamento == null) {
            return false;
        }
        if (pSalario <= 0) {
            return false;
        }

        empleado.setCargo(cargo);
        empleado.setDepartamento(departamento);
        empleado.setSalario(pSalario);
        return true;
    }

    public boolean BajaEmpleado(int pIdEmpleado) {
        Empleado empleado = BuscarEmpleado(pIdEmpleado);
        if (empleado == null) {
            return false;
        }
        if (EsResponsable(empleado)) {
            return false;
        }

        boolean eliminado = this.aOrganigrama.Eliminar(pIdEmpleado);
        if (!eliminado) {
            return false;
        }

        // Se recorren al revés porque se eliminan elementos de la lista.
        for (int i = this.aAsignaciones.size() - 1; i >= 0; i--) {
            Asignacion asignacion = this.aAsignaciones.get(i);
            if (asignacion.getEmpleado() == empleado) {
                asignacion.getProyecto().getAsignaciones().remove(asignacion);
                this.aAsignaciones.remove(i);
            }
        }
        return true;
    }

    private boolean EsResponsable(Empleado pEmpleado) {
        for (int i = 0; i < this.aDepartamentos.size(); i++) {
            if (this.aDepartamentos.get(i).getResponsable() == pEmpleado) {
                return true;
            }
        }

        for (int i = 0; i < this.aProyectos.size(); i++) {
            if (this.aProyectos.get(i).getResponsable() == pEmpleado) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Empleado> EmpleadosDeDepartamento(int pIdDepartamento) {
        ArrayList<Empleado> resultado = new ArrayList<Empleado>();
        ArrayList<Empleado> empleados = this.aOrganigrama.ListarEmpleados();

        for (int i = 0; i < empleados.size(); i++) {
            Empleado empleado = empleados.get(i);
            if (empleado.getDepartamento().getId() == pIdDepartamento) {
                resultado.add(empleado);
            }
        }
        return resultado;
    }

    // ---------------- CARGOS ----------------

    public boolean AltaCargo(Cargo pCargo) {
        if (pCargo == null) {
            return false;
        }
        if (BuscarCargo(pCargo.getId()) != null) {
            return false;
        }
        if (pCargo.getNivelJerarquico() <= 0) {
            return false;
        }
        if (pCargo.getSalarioBase() <= 0) {
            return false;
        }
        this.aCargos.add(pCargo);
        return true;
    }

    public Cargo BuscarCargo(int pId) {
        for (int i = 0; i < this.aCargos.size(); i++) {
            if (this.aCargos.get(i).getId() == pId) {
                return this.aCargos.get(i);
            }
        }
        return null;
    }

    public boolean ModificarCargo(int pId, String pNombre,
            int pNivelJerarquico, double pSalarioBase) {
        Cargo cargo = BuscarCargo(pId);
        if (cargo == null) {
            return false;
        }
        if (pNombre.equals("")) {
            return false;
        }
        if (pNivelJerarquico <= 0) {
            return false;
        }
        if (pSalarioBase <= 0) {
            return false;
        }
        cargo.setNombre(pNombre);
        cargo.setNivelJerarquico(pNivelJerarquico);
        cargo.setSalarioBase(pSalarioBase);
        return true;
    }

    public boolean BajaCargo(int pId) {
        Cargo cargo = BuscarCargo(pId);
        if (cargo == null) {
            return false;
        }

        ArrayList<Empleado> empleados = this.aOrganigrama.ListarEmpleados();
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getCargo() == cargo) {
                return false;
            }
        }
        return this.aCargos.remove(cargo);
    }

    // ---------------- DEPARTAMENTOS ----------------

    public boolean AltaDepartamento(Departamento pDepartamento) {
        if (pDepartamento == null) {
            return false;
        }
        if (BuscarDepartamento(pDepartamento.getId()) != null) {
            return false;
        }
        this.aDepartamentos.add(pDepartamento);
        return true;
    }

    public Departamento BuscarDepartamento(int pId) {
        for (int i = 0; i < this.aDepartamentos.size(); i++) {
            if (this.aDepartamentos.get(i).getId() == pId) {
                return this.aDepartamentos.get(i);
            }
        }
        return null;
    }

    public boolean ModificarDepartamento(int pId, String pNombre,
            String pDescripcion, int pIdResponsable) {
        Departamento departamento = BuscarDepartamento(pId);
        Empleado responsable = BuscarEmpleado(pIdResponsable);
        if (departamento == null) {
            return false;
        }
        if (responsable == null) {
            return false;
        }
        if (pNombre.equals("")) {
            return false;
        }
        departamento.setNombre(pNombre);
        departamento.setDescripcion(pDescripcion);
        departamento.setResponsable(responsable);
        return true;
    }

    public boolean BajaDepartamento(int pId) {
        Departamento departamento = BuscarDepartamento(pId);
        if (departamento == null) {
            return false;
        }
        if (EmpleadosDeDepartamento(pId).size() > 0) {
            return false;
        }
        return this.aDepartamentos.remove(departamento);
    }

    // ---------------- PROYECTOS ----------------

    public boolean AltaProyecto(Proyecto pProyecto) {
        if (pProyecto == null) {
            return false;
        }
        if (BuscarProyecto(pProyecto.getId()) != null) {
            return false;
        }
        if (pProyecto.getResponsable() == null) {
            return false;
        }
        if (!EstadoValido(pProyecto.getEstado())) {
            return false;
        }
        this.aProyectos.add(pProyecto);
        return true;
    }

    public Proyecto BuscarProyecto(int pId) {
        for (int i = 0; i < this.aProyectos.size(); i++) {
            if (this.aProyectos.get(i).getId() == pId) {
                return this.aProyectos.get(i);
            }
        }
        return null;
    }

    public boolean ModificarProyecto(int pId, String pNombre, String pFechaInicio,
            String pFechaFin, int pIdResponsable) {
        Proyecto proyecto = BuscarProyecto(pId);
        Empleado responsable = BuscarEmpleado(pIdResponsable);
        if (proyecto == null) {
            return false;
        }
        if (responsable == null) {
            return false;
        }
        if (pNombre.equals("")) {
            return false;
        }
        proyecto.setNombre(pNombre);
        proyecto.setFechaInicio(pFechaInicio);
        proyecto.setFechaFin(pFechaFin);
        proyecto.setResponsable(responsable);
        return true;
    }

    public boolean BajaProyecto(int pId) {
        Proyecto proyecto = BuscarProyecto(pId);
        if (proyecto == null) {
            return false;
        }

        for (int i = this.aAsignaciones.size() - 1; i >= 0; i--) {
            if (this.aAsignaciones.get(i).getProyecto() == proyecto) {
                this.aAsignaciones.remove(i);
            }
        }
        proyecto.getAsignaciones().clear();
        return this.aProyectos.remove(proyecto);
    }

    public boolean CambiarEstadoProyecto(int pId, String pEstado) {
        Proyecto proyecto = BuscarProyecto(pId);
        if (proyecto == null) {
            return false;
        }
        if (!EstadoValido(pEstado)) {
            return false;
        }
        proyecto.setEstado(pEstado.toUpperCase());
        return true;
    }

    private boolean EstadoValido(String pEstado) {
        if (pEstado.equalsIgnoreCase("PLANIFICADO")) {
            return true;
        }
        if (pEstado.equalsIgnoreCase("EN_CURSO")) {
            return true;
        }
        if (pEstado.equalsIgnoreCase("FINALIZADO")) {
            return true;
        }
        return false;
    }

    // ---------------- ASIGNACIONES ----------------

    public boolean AsignarEmpleadoProyecto(int pIdAsignacion, int pIdEmpleado,
            int pIdProyecto, int pHoras, String pRol) {
        Empleado empleado = BuscarEmpleado(pIdEmpleado);
        Proyecto proyecto = BuscarProyecto(pIdProyecto);

        if (BuscarAsignacion(pIdAsignacion) != null) {
            return false;
        }
        if (empleado == null) {
            return false;
        }
        if (proyecto == null) {
            return false;
        }
        if (pHoras <= 0) {
            return false;
        }
        if (pRol.equals("")) {
            return false;
        }

        for (int i = 0; i < proyecto.getAsignaciones().size(); i++) {
            if (proyecto.getAsignaciones().get(i).getEmpleado() == empleado) {
                return false;
            }
        }

        Asignacion asignacion = new Asignacion(
                pIdAsignacion, empleado, proyecto, pHoras, pRol);
        this.aAsignaciones.add(asignacion);
        proyecto.getAsignaciones().add(asignacion);
        return true;
    }

    public Asignacion BuscarAsignacion(int pId) {
        for (int i = 0; i < this.aAsignaciones.size(); i++) {
            if (this.aAsignaciones.get(i).getId() == pId) {
                return this.aAsignaciones.get(i);
            }
        }
        return null;
    }

    public boolean ModificarAsignacion(int pId, int pHoras, String pRol) {
        Asignacion asignacion = BuscarAsignacion(pId);
        if (asignacion == null) {
            return false;
        }
        if (pHoras <= 0) {
            return false;
        }
        if (pRol.equals("")) {
            return false;
        }
        asignacion.setHorasAsignadas(pHoras);
        asignacion.setRol(pRol);
        return true;
    }

    public boolean BajaAsignacion(int pId) {
        Asignacion asignacion = BuscarAsignacion(pId);
        if (asignacion == null) {
            return false;
        }
        asignacion.getProyecto().getAsignaciones().remove(asignacion);
        return this.aAsignaciones.remove(asignacion);
    }

    public int CalcularHorasProyecto(int pIdProyecto) {
        Proyecto proyecto = BuscarProyecto(pIdProyecto);
        if (proyecto == null) {
            return -1;
        }

        int total = 0;
        for (int i = 0; i < proyecto.getAsignaciones().size(); i++) {
            total = total
                    + proyecto.getAsignaciones().get(i).getHorasAsignadas();
        }
        return total;
    }
}
