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

    // La Controladora no guarda datos. Recibe las estructuras y aplica la lógica.

    public void PrecargarDatos(ArbolOrganigrama pOrganigrama,
            ArrayList<Departamento> pDepartamentos, ArrayList<Cargo> pCargos,
            ArrayList<Proyecto> pProyectos, ArrayList<Asignacion> pAsignaciones) {

        AltaCargo(pCargos, new Cargo(1, "Gerente General", 1, 180000));
        AltaCargo(pCargos, new Cargo(2, "Gerente de Área", 1, 150000));
        AltaCargo(pCargos, new Cargo(3, "Líder", 2, 120000));
        AltaCargo(pCargos, new Cargo(4, "Programador", 3, 90000));
        AltaCargo(pCargos, new Cargo(5, "Administrador de Redes", 3, 95000));
        AltaCargo(pCargos, new Cargo(6, "Vendedor", 3, 80000));
        AltaCargo(pCargos, new Cargo(7, "Analista de RRHH", 3, 85000));

        AltaDepartamento(pDepartamentos, new Departamento(1, "Tecnología",
                "Desarrollo e infraestructura", null));
        AltaDepartamento(pDepartamentos, new Departamento(2, "Comercial",
                "Ventas y relación con clientes", null));
        AltaDepartamento(pDepartamentos, new Departamento(3, "RRHH",
                "Gestión de personas", null));
        AltaDepartamento(pDepartamentos, new Departamento(4, "Dirección General",
                "Dirección de la empresa", null));

        Empleado laura = new Empleado(1000, "Laura", "Méndez",
                BuscarCargo(pCargos, 1), BuscarDepartamento(pDepartamentos, 4),
                190000, "10/03/2018");
        pOrganigrama.CrearRaiz(laura);

        ContratarEmpleado(pOrganigrama, new Empleado(1001, "Diego", "Pérez",
                BuscarCargo(pCargos, 2), BuscarDepartamento(pDepartamentos, 1),
                155000, "12/05/2019"), 1000);
        ContratarEmpleado(pOrganigrama, new Empleado(1002, "Ana", "Rodríguez",
                BuscarCargo(pCargos, 3), BuscarDepartamento(pDepartamentos, 1),
                125000, "07/08/2020"), 1001);
        ContratarEmpleado(pOrganigrama, new Empleado(1003, "Martín", "Silva",
                BuscarCargo(pCargos, 4), BuscarDepartamento(pDepartamentos, 1),
                92000, "15/02/2022"), 1002);
        ContratarEmpleado(pOrganigrama, new Empleado(1004, "Sofía", "Castro",
                BuscarCargo(pCargos, 4), BuscarDepartamento(pDepartamentos, 1),
                91000, "18/04/2022"), 1002);
        ContratarEmpleado(pOrganigrama, new Empleado(1005, "Pablo", "Gómez",
                BuscarCargo(pCargos, 3), BuscarDepartamento(pDepartamentos, 1),
                123000, "20/09/2020"), 1001);
        ContratarEmpleado(pOrganigrama, new Empleado(1006, "Lucía", "Fernández",
                BuscarCargo(pCargos, 5), BuscarDepartamento(pDepartamentos, 1),
                97000, "11/01/2021"), 1005);
        ContratarEmpleado(pOrganigrama, new Empleado(1007, "Carolina", "Díaz",
                BuscarCargo(pCargos, 2), BuscarDepartamento(pDepartamentos, 2),
                150000, "03/06/2019"), 1000);
        ContratarEmpleado(pOrganigrama, new Empleado(1008, "Jorge", "Núñez",
                BuscarCargo(pCargos, 6), BuscarDepartamento(pDepartamentos, 2),
                82000, "09/11/2021"), 1007);
        ContratarEmpleado(pOrganigrama, new Empleado(1009, "Valentina", "Rossi",
                BuscarCargo(pCargos, 6), BuscarDepartamento(pDepartamentos, 2),
                83000, "14/12/2021"), 1007);
        ContratarEmpleado(pOrganigrama, new Empleado(1010, "Fernando", "López",
                BuscarCargo(pCargos, 2), BuscarDepartamento(pDepartamentos, 3),
                148000, "17/07/2019"), 1000);
        ContratarEmpleado(pOrganigrama, new Empleado(1011, "Camila", "Torres",
                BuscarCargo(pCargos, 7), BuscarDepartamento(pDepartamentos, 3),
                87000, "25/03/2021"), 1010);
        ContratarEmpleado(pOrganigrama, new Empleado(1012, "Nicolás", "Pérez",
                BuscarCargo(pCargos, 4), BuscarDepartamento(pDepartamentos, 1),
                93000, "08/05/2023"), 1002);
        ContratarEmpleado(pOrganigrama, new Empleado(1013, "Emilia", "Silva",
                BuscarCargo(pCargos, 4), BuscarDepartamento(pDepartamentos, 1),
                92500, "19/06/2023"), 1002);
        ContratarEmpleado(pOrganigrama, new Empleado(1014, "Tomás", "Gómez",
                BuscarCargo(pCargos, 5), BuscarDepartamento(pDepartamentos, 1),
                98000, "11/09/2022"), 1005);
        ContratarEmpleado(pOrganigrama, new Empleado(1015, "Julieta", "Fernández",
                BuscarCargo(pCargos, 4), BuscarDepartamento(pDepartamentos, 1),
                91500, "04/03/2024"), 1005);
        ContratarEmpleado(pOrganigrama, new Empleado(1016, "Mateo", "Rodríguez",
                BuscarCargo(pCargos, 4), BuscarDepartamento(pDepartamentos, 1),
                94000, "15/01/2023"), 1002);
        ContratarEmpleado(pOrganigrama, new Empleado(1017, "Paula", "Díaz",
                BuscarCargo(pCargos, 6), BuscarDepartamento(pDepartamentos, 2),
                84000, "21/08/2022"), 1007);
        ContratarEmpleado(pOrganigrama, new Empleado(1018, "Bruno", "Pérez",
                BuscarCargo(pCargos, 6), BuscarDepartamento(pDepartamentos, 2),
                81500, "10/04/2024"), 1007);
        ContratarEmpleado(pOrganigrama, new Empleado(1019, "Agustina", "Rossi",
                BuscarCargo(pCargos, 6), BuscarDepartamento(pDepartamentos, 2),
                83500, "02/10/2023"), 1007);
        ContratarEmpleado(pOrganigrama, new Empleado(1020, "Ramiro", "Torres",
                BuscarCargo(pCargos, 7), BuscarDepartamento(pDepartamentos, 3),
                88000, "17/02/2022"), 1010);
        ContratarEmpleado(pOrganigrama, new Empleado(1021, "Martina", "López",
                BuscarCargo(pCargos, 7), BuscarDepartamento(pDepartamentos, 3),
                86500, "06/07/2023"), 1010);
        ContratarEmpleado(pOrganigrama, new Empleado(1022, "Sebastián", "Méndez",
                BuscarCargo(pCargos, 7), BuscarDepartamento(pDepartamentos, 3),
                89000, "12/12/2022"), 1010);
        ContratarEmpleado(pOrganigrama, new Empleado(1023, "Clara", "Castro",
                BuscarCargo(pCargos, 4), BuscarDepartamento(pDepartamentos, 1),
                92000, "23/05/2024"), 1005);
        ContratarEmpleado(pOrganigrama, new Empleado(1024, "Federico", "Núñez",
                BuscarCargo(pCargos, 6), BuscarDepartamento(pDepartamentos, 2),
                85000, "14/11/2022"), 1007);

        BuscarDepartamento(pDepartamentos, 1).setResponsable(BuscarEmpleado(pOrganigrama, 1001));
        BuscarDepartamento(pDepartamentos, 2).setResponsable(BuscarEmpleado(pOrganigrama, 1007));
        BuscarDepartamento(pDepartamentos, 3).setResponsable(BuscarEmpleado(pOrganigrama, 1010));
        BuscarDepartamento(pDepartamentos, 4).setResponsable(BuscarEmpleado(pOrganigrama, 1000));

        AltaProyecto(pProyectos, new Proyecto(1, "Migración a la nube",
                "01/09/2026", "30/06/2027", "EN_CURSO",
                BuscarEmpleado(pOrganigrama, 1002)));
        AltaProyecto(pProyectos, new Proyecto(2, "Nuevo sistema CRM",
                "01/03/2027", "30/11/2027", "PLANIFICADO",
                BuscarEmpleado(pOrganigrama, 1007)));

        AsignarEmpleadoProyecto(pOrganigrama, pProyectos, pAsignaciones,
                1, 1002, 1, 30, "Líder");
        AsignarEmpleadoProyecto(pOrganigrama, pProyectos, pAsignaciones,
                2, 1003, 1, 25, "Desarrollador");
        AsignarEmpleadoProyecto(pOrganigrama, pProyectos, pAsignaciones,
                3, 1004, 1, 25, "Desarrolladora");
        AsignarEmpleadoProyecto(pOrganigrama, pProyectos, pAsignaciones,
                4, 1007, 2, 20, "Responsable funcional");
        AsignarEmpleadoProyecto(pOrganigrama, pProyectos, pAsignaciones,
                5, 1008, 2, 15, "Analista comercial");
    }

    public Empleado BuscarEmpleado(ArbolOrganigrama pOrganigrama, int pId) {
        NodoEmpleado nodo = pOrganigrama.BuscarPorId(pId);
        return nodo == null ? null : nodo.getEmpleado();
    }

    public boolean ContratarEmpleado(ArbolOrganigrama pOrganigrama,
            Empleado pEmpleado, int pIdJefe)
    {
        if (pEmpleado == null || pEmpleado.getCargo() == null
                || pEmpleado.getDepartamento() == null
                || pEmpleado.getSalario() <= 0) {
            return false;
        }
        return pOrganigrama.Insertar(pEmpleado, pIdJefe);
    }

    public boolean ModificarEmpleado(ArbolOrganigrama pOrganigrama,
            ArrayList<Cargo> pCargos, ArrayList<Departamento> pDepartamentos,
            int pIdEmpleado, int pIdCargo, int pIdDepartamento, double pSalario)
    {
        Empleado empleado = BuscarEmpleado(pOrganigrama, pIdEmpleado);
        Cargo cargo = BuscarCargo(pCargos, pIdCargo);
        Departamento departamento = BuscarDepartamento(pDepartamentos, pIdDepartamento);

        if (empleado == null || cargo == null || departamento == null || pSalario <= 0) {
            return false;
        }

        empleado.setCargo(cargo);
        empleado.setDepartamento(departamento);
        empleado.setSalario(pSalario);
        return true;
    }

    public boolean BajaEmpleado(ArbolOrganigrama pOrganigrama,
            ArrayList<Departamento> pDepartamentos, ArrayList<Proyecto> pProyectos,
            ArrayList<Asignacion> pAsignaciones, int pIdEmpleado)
    {
        Empleado empleado = BuscarEmpleado(pOrganigrama, pIdEmpleado);
        if (empleado == null || EsResponsable(pDepartamentos, pProyectos, empleado)
                || !pOrganigrama.Eliminar(pIdEmpleado)) {
            return false;
        }
        for (int i = pAsignaciones.size() - 1; i >= 0; i--) {
            Asignacion asignacion = pAsignaciones.get(i);
            if (asignacion.getEmpleado() == empleado) {
                asignacion.getProyecto().getAsignaciones().remove(asignacion);
                pAsignaciones.remove(i);
            }
        }
        return true;
    }

    private boolean EsResponsable(ArrayList<Departamento> pDepartamentos,
            ArrayList<Proyecto> pProyectos, Empleado pEmpleado)
    {
        for (int i = 0; i < pDepartamentos.size(); i++) {
            if (pDepartamentos.get(i).getResponsable() == pEmpleado) {
                return true;
            }
        }
        for (int i = 0; i < pProyectos.size(); i++) {
            if (pProyectos.get(i).getResponsable() == pEmpleado) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Empleado> EmpleadosDeDepartamento(
            ArbolOrganigrama pOrganigrama, int pIdDepartamento)
    {
        ArrayList<Empleado> resultado = new ArrayList<Empleado>();
        ArrayList<Empleado> empleados = pOrganigrama.ListarEmpleados();
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getDepartamento().getId() == pIdDepartamento) {
                resultado.add(empleados.get(i));
            }
        }
        return resultado;
    }

    public boolean AltaCargo(ArrayList<Cargo> pCargos, Cargo pCargo) {
        if (pCargo == null || BuscarCargo(pCargos, pCargo.getId()) != null
                || pCargo.getNivelJerarquico() <= 0 || pCargo.getSalarioBase() <= 0) {
            return false;
        }
        pCargos.add(pCargo);
        return true;
    }

    public Cargo BuscarCargo(ArrayList<Cargo> pCargos, int pId) {
        for (int i = 0; i < pCargos.size(); i++) {
            if (pCargos.get(i).getId() == pId) {
                return pCargos.get(i);
            }
        }
        return null;
    }

    public boolean ModificarCargo(ArrayList<Cargo> pCargos, int pId,
            String pNombre, int pNivelJerarquico, double pSalarioBase)
    {
        Cargo cargo = BuscarCargo(pCargos, pId);
        if (cargo == null || pNombre.equals("") || pNivelJerarquico <= 0
                || pSalarioBase <= 0) {
            return false;
        }
        cargo.setNombre(pNombre);
        cargo.setNivelJerarquico(pNivelJerarquico);
        cargo.setSalarioBase(pSalarioBase);
        return true;
    }

    public boolean BajaCargo(ArbolOrganigrama pOrganigrama,
            ArrayList<Cargo> pCargos, int pId)
    {
        Cargo cargo = BuscarCargo(pCargos, pId);
        if (cargo == null) {
            return false;
        }
        ArrayList<Empleado> empleados = pOrganigrama.ListarEmpleados();
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getCargo() == cargo) {
                return false;
            }
        }
        return pCargos.remove(cargo);
    }

    public boolean AltaDepartamento(ArrayList<Departamento> pDepartamentos,
            Departamento pDepartamento)
    {
        if (pDepartamento == null
                || BuscarDepartamento(pDepartamentos, pDepartamento.getId()) != null) {
            return false;
        }
        pDepartamentos.add(pDepartamento);
        return true;
    }

    public Departamento BuscarDepartamento(ArrayList<Departamento> pDepartamentos,
            int pId)
    {
        for (int i = 0; i < pDepartamentos.size(); i++) {
            if (pDepartamentos.get(i).getId() == pId) {
                return pDepartamentos.get(i);
            }
        }
        return null;
    }

    public boolean ModificarDepartamento(ArbolOrganigrama pOrganigrama,
            ArrayList<Departamento> pDepartamentos, int pId, String pNombre,
            String pDescripcion, int pIdResponsable)
    {
        Departamento departamento = BuscarDepartamento(pDepartamentos, pId);
        Empleado responsable = BuscarEmpleado(pOrganigrama, pIdResponsable);
        if (departamento == null || responsable == null || pNombre.equals("")) {
            return false;
        }
        departamento.setNombre(pNombre);
        departamento.setDescripcion(pDescripcion);
        departamento.setResponsable(responsable);
        return true;
    }

    public boolean BajaDepartamento(ArbolOrganigrama pOrganigrama,
            ArrayList<Departamento> pDepartamentos, int pId) {
        Departamento departamento = BuscarDepartamento(pDepartamentos, pId);
        if (departamento == null
                || EmpleadosDeDepartamento(pOrganigrama, pId).size() > 0) {
            return false;
        }
        return pDepartamentos.remove(departamento);
    }

    public boolean AltaProyecto(ArrayList<Proyecto> pProyectos, Proyecto pProyecto) {
        if (pProyecto == null || BuscarProyecto(pProyectos, pProyecto.getId()) != null
                || pProyecto.getResponsable() == null
                || !EstadoValido(pProyecto.getEstado())) {
            return false;
        }
        pProyectos.add(pProyecto);
        return true;
    }

    public Proyecto BuscarProyecto(ArrayList<Proyecto> pProyectos, int pId) {
        for (int i = 0; i < pProyectos.size(); i++) {
            if (pProyectos.get(i).getId() == pId) {
                return pProyectos.get(i);
            }
        }
        return null;
    }

    public boolean ModificarProyecto(ArbolOrganigrama pOrganigrama,
            ArrayList<Proyecto> pProyectos, int pId, String pNombre,
            String pFechaInicio, String pFechaFin, int pIdResponsable) {
        Proyecto proyecto = BuscarProyecto(pProyectos, pId);
        Empleado responsable = BuscarEmpleado(pOrganigrama, pIdResponsable);
        if (proyecto == null || responsable == null || pNombre.equals("")) {
            return false;
        }
        proyecto.setNombre(pNombre);
        proyecto.setFechaInicio(pFechaInicio);
        proyecto.setFechaFin(pFechaFin);
        proyecto.setResponsable(responsable);
        return true;
    }

    public boolean BajaProyecto(ArrayList<Proyecto> pProyectos,
            ArrayList<Asignacion> pAsignaciones, int pId) {
        Proyecto proyecto = BuscarProyecto(pProyectos, pId);
        if (proyecto == null) {
            return false;
        }
        for (int i = pAsignaciones.size() - 1; i >= 0; i--) {
            if (pAsignaciones.get(i).getProyecto() == proyecto) {
                pAsignaciones.remove(i);
            }
        }
        proyecto.getAsignaciones().clear();
        return pProyectos.remove(proyecto);
    }

    public boolean CambiarEstadoProyecto(ArrayList<Proyecto> pProyectos,
            int pId, String pEstado) {
        Proyecto proyecto = BuscarProyecto(pProyectos, pId);
        if (proyecto == null || !EstadoValido(pEstado)) {
            return false;
        }
        proyecto.setEstado(pEstado.toUpperCase());
        return true;
    }

    private boolean EstadoValido(String pEstado) {
        return pEstado.equalsIgnoreCase("PLANIFICADO")
                || pEstado.equalsIgnoreCase("EN_CURSO")
                || pEstado.equalsIgnoreCase("FINALIZADO");
    }

    public boolean AsignarEmpleadoProyecto(ArbolOrganigrama pOrganigrama,
            ArrayList<Proyecto> pProyectos, ArrayList<Asignacion> pAsignaciones,
            int pIdAsignacion, int pIdEmpleado, int pIdProyecto,
            int pHoras, String pRol) {
        Empleado empleado = BuscarEmpleado(pOrganigrama, pIdEmpleado);
        Proyecto proyecto = BuscarProyecto(pProyectos, pIdProyecto);
        if (BuscarAsignacion(pAsignaciones, pIdAsignacion) != null
                || empleado == null || proyecto == null || pHoras <= 0
                || pRol.equals("")) {
            return false;
        }
        for (int i = 0; i < proyecto.getAsignaciones().size(); i++) {
            if (proyecto.getAsignaciones().get(i).getEmpleado() == empleado) {
                return false;
            }
        }
        Asignacion asignacion = new Asignacion(
                pIdAsignacion, empleado, proyecto, pHoras, pRol);
        pAsignaciones.add(asignacion);
        proyecto.getAsignaciones().add(asignacion);
        return true;
    }

    public Asignacion BuscarAsignacion(ArrayList<Asignacion> pAsignaciones, int pId) {
        for (int i = 0; i < pAsignaciones.size(); i++) {
            if (pAsignaciones.get(i).getId() == pId) {
                return pAsignaciones.get(i);
            }
        }
        return null;
    }

    public boolean ModificarAsignacion(ArrayList<Asignacion> pAsignaciones,
            int pId, int pHoras, String pRol) {
        Asignacion asignacion = BuscarAsignacion(pAsignaciones, pId);
        if (asignacion == null || pHoras <= 0 || pRol.equals("")) {
            return false;
        }
        asignacion.setHorasAsignadas(pHoras);
        asignacion.setRol(pRol);
        return true;
    }

    public boolean BajaAsignacion(ArrayList<Asignacion> pAsignaciones, int pId) {
        Asignacion asignacion = BuscarAsignacion(pAsignaciones, pId);
        if (asignacion == null) {
            return false;
        }
        asignacion.getProyecto().getAsignaciones().remove(asignacion);
        return pAsignaciones.remove(asignacion);
    }

    public int CalcularHorasProyecto(ArrayList<Proyecto> pProyectos, int pIdProyecto) {
        Proyecto proyecto = BuscarProyecto(pProyectos, pIdProyecto);
        if (proyecto == null) {
            return -1;
        }
        int total = 0;
        for (int i = 0; i < proyecto.getAsignaciones().size(); i++) {
            total = total + proyecto.getAsignaciones().get(i).getHorasAsignadas();
        }
        return total;
    }
}
