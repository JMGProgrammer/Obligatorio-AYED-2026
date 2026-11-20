package Dominio.Estructuras;

import java.util.ArrayList;
import Dominio.Entidades.Empleado;

public class ArbolOrganigrama {

    private NodoEmpleado aRaiz;

    public NodoEmpleado getRaiz(){return this.aRaiz;}
    public void setRaiz(NodoEmpleado pRaiz){this.aRaiz = pRaiz;}

    public ArbolOrganigrama() {
        this.aRaiz = null;
    }

    public boolean CrearRaiz(Empleado pEmpleado) {
        if (this.aRaiz != null) {
            return false;
        }
        if (pEmpleado == null) {
            return false;
        }

        ArrayList<NodoEmpleado> subordinados = new ArrayList<NodoEmpleado>();
        this.aRaiz = new NodoEmpleado(pEmpleado, null, subordinados, 0);
        return true;
    }

    public boolean Insertar(Empleado pEmpleado, int pIdJefe) {
        if (pEmpleado == null) {
            return false;
        }
        if (BuscarPorId(pEmpleado.getId()) != null) {
            return false;
        }

        NodoEmpleado jefe = BuscarPorId(pIdJefe);
        if (jefe == null) {
            return false;
        }

        ArrayList<NodoEmpleado> subordinados = new ArrayList<NodoEmpleado>();
        NodoEmpleado nuevo = new NodoEmpleado(
                pEmpleado, jefe, subordinados, jefe.getNivel() + 1);
        jefe.getSubordinados().add(nuevo);
        return true;
    }

    public NodoEmpleado BuscarPorId(int pId) {
        return BuscarPorIdRecursivo(this.aRaiz, pId);
    }

    // PRE: actual es null o pertenece al árbol.
    // POST: devuelve el nodo buscado o null si no existe.
    private NodoEmpleado BuscarPorIdRecursivo(NodoEmpleado pActual, int pId) {
        if (pActual == null) {
            return null;
        }

        if (pActual.getEmpleado().getId() == pId) {
            return pActual;
        }

        for (int i = 0; i < pActual.getSubordinados().size(); i++) {
            NodoEmpleado hijo = pActual.getSubordinados().get(i);
            NodoEmpleado encontrado = BuscarPorIdRecursivo(hijo, pId);

            if (encontrado != null) {
                return encontrado;
            }
        }

        return null;
    }

    public ArrayList<Empleado> BuscarPorApellido(String pApellido) {
        ArrayList<Empleado> resultado = new ArrayList<Empleado>();
        BuscarPorApellidoRecursivo(this.aRaiz, pApellido, resultado);
        return resultado;
    }

    private void BuscarPorApellidoRecursivo(NodoEmpleado pActual,
            String pApellido, ArrayList<Empleado> pResultado) {
        if (pActual == null) {
            return;
        }

        if (pActual.getEmpleado().getApellido().equalsIgnoreCase(pApellido)) {
            pResultado.add(pActual.getEmpleado());
        }

        for (int i = 0; i < pActual.getSubordinados().size(); i++) {
            BuscarPorApellidoRecursivo(
                    pActual.getSubordinados().get(i), pApellido, pResultado);
        }
    }

    public String MostrarOrganigrama() {
        if (this.aRaiz == null) {
            return "El organigrama está vacío.";
        }
        return MostrarPreordenRecursivo(this.aRaiz, "", true);
    }

    // PRE: actual no es null y pertenece al árbol.
    // POST: devuelve el subárbol en recorrido preorden.
    private String MostrarPreordenRecursivo(NodoEmpleado pActual,
            String pPrefijo, boolean pEsUltimo) {
        String resultado = "";
        String rama = pActual == this.aRaiz ? "■ RAÍZ  " :
                (pEsUltimo ? "└── " : "├── ");

        resultado = resultado + pPrefijo + rama;
        resultado = resultado + "[" + pActual.getEmpleado().getId() + "] ";
        resultado = resultado + pActual.getEmpleado().getNombreCompleto();
        resultado = resultado + " | Cargo: "
                + pActual.getEmpleado().getCargo().getNombre();
        resultado = resultado + " | Nivel: " + pActual.getNivel();
        resultado = resultado + " | Subordinados: "
                + ContarSubordinadosRecursivo(pActual) + "\n";

        for (int i = 0; i < pActual.getSubordinados().size(); i++) {
            boolean esUltimo = i == pActual.getSubordinados().size() - 1;
            String prefijoHijo = pPrefijo;

            if (pActual != this.aRaiz) {
                prefijoHijo = prefijoHijo + (pEsUltimo ? "    " : "│   ");
            }

            resultado = resultado + MostrarPreordenRecursivo(
                    pActual.getSubordinados().get(i), prefijoHijo, esUltimo);
        }

        return resultado;
    }

    public int ContarSubordinados(int pIdEmpleado) {
        NodoEmpleado nodo = BuscarPorId(pIdEmpleado);
        if (nodo == null) {
            return -1;
        }
        return ContarSubordinadosRecursivo(nodo);
    }

    // PRE: actual no es null y pertenece al árbol.
    // POST: devuelve la cantidad de descendientes directos e indirectos.
    private int ContarSubordinadosRecursivo(NodoEmpleado pActual) {
        int cantidad = pActual.getSubordinados().size();

        for (int i = 0; i < pActual.getSubordinados().size(); i++) {
            cantidad = cantidad
                    + ContarSubordinadosRecursivo(pActual.getSubordinados().get(i));
        }

        return cantidad;
    }

    public double CalcularMasaSalarial(int pIdEmpleado) {
        NodoEmpleado nodo = BuscarPorId(pIdEmpleado);
        if (nodo == null) {
            return -1;
        }
        return CalcularMasaSalarialRecursiva(nodo);
    }

    // PRE: actual no es null y los salarios son válidos.
    // POST: suma el salario actual y los de todo su subárbol.
    private double CalcularMasaSalarialRecursiva(NodoEmpleado pActual) {
        double total = pActual.getEmpleado().getSalario();

        for (int i = 0; i < pActual.getSubordinados().size(); i++) {
            total = total
                    + CalcularMasaSalarialRecursiva(pActual.getSubordinados().get(i));
        }

        return total;
    }

    public String ObtenerCadenaDeMando(int pIdEmpleado) {
        NodoEmpleado nodo = BuscarPorId(pIdEmpleado);
        if (nodo == null) {
            return "El empleado no existe.";
        }
        return ObtenerCadenaRecursiva(nodo);
    }

    private String ObtenerCadenaRecursiva(NodoEmpleado pActual) {
        if (pActual.getJefe() == null) {
            return pActual.getEmpleado().getNombreCompleto();
        }

        return pActual.getEmpleado().getNombreCompleto()
                + " <- " + ObtenerCadenaRecursiva(pActual.getJefe());
    }

    public int CalcularAltura() {
        return CalcularAlturaRecursiva(this.aRaiz);
    }

    // PRE: actual es null o pertenece al árbol.
    // POST: devuelve la cantidad de niveles del subárbol.
    private int CalcularAlturaRecursiva(NodoEmpleado pActual) {
        if (pActual == null) {
            return 0;
        }

        int mayorAltura = 0;

        for (int i = 0; i < pActual.getSubordinados().size(); i++) {
            int altura = CalcularAlturaRecursiva(pActual.getSubordinados().get(i));
            if (altura > mayorAltura) {
                mayorAltura = altura;
            }
        }

        return mayorAltura + 1;
    }

    public ArrayList<Empleado> EmpleadosDelNivel(int pNivel) {
        ArrayList<Empleado> resultado = new ArrayList<Empleado>();
        EmpleadosDelNivelRecursivo(this.aRaiz, pNivel, resultado);
        return resultado;
    }

    private void EmpleadosDelNivelRecursivo(NodoEmpleado pActual, int pNivel,
            ArrayList<Empleado> pResultado) {
        if (pActual == null) {
            return;
        }

        if (pActual.getNivel() == pNivel) {
            pResultado.add(pActual.getEmpleado());
        }

        for (int i = 0; i < pActual.getSubordinados().size(); i++) {
            EmpleadosDelNivelRecursivo(
                    pActual.getSubordinados().get(i), pNivel, pResultado);
        }
    }

    public ArrayList<Empleado> ListarEmpleados() {
        ArrayList<Empleado> resultado = new ArrayList<Empleado>();
        ListarEmpleadosRecursivo(this.aRaiz, resultado);
        return resultado;
    }

    private void ListarEmpleadosRecursivo(NodoEmpleado pActual,
            ArrayList<Empleado> pResultado) {
        if (pActual == null) {
            return;
        }

        pResultado.add(pActual.getEmpleado());

        for (int i = 0; i < pActual.getSubordinados().size(); i++) {
            ListarEmpleadosRecursivo(pActual.getSubordinados().get(i), pResultado);
        }
    }

    public boolean Eliminar(int pIdEmpleado) {
        NodoEmpleado nodo = BuscarPorId(pIdEmpleado);

        // Regla elegida: no se elimina la raíz ni un empleado con subordinados.
        if (nodo == null) {
            return false;
        }
        if (nodo == this.aRaiz) {
            return false;
        }
        if (nodo.getSubordinados().size() > 0) {
            return false;
        }

        return nodo.getJefe().getSubordinados().remove(nodo);
    }

    public boolean Reasignar(int pIdEmpleado, int pIdNuevoJefe) {
        NodoEmpleado nodo = BuscarPorId(pIdEmpleado);
        NodoEmpleado nuevoJefe = BuscarPorId(pIdNuevoJefe);

        if (nodo == null) {
            return false;
        }
        if (nuevoJefe == null) {
            return false;
        }
        if (nodo == this.aRaiz) {
            return false;
        }
        if (nodo == nuevoJefe) {
            return false;
        }

        if (EstaEnSubarbolRecursivo(nodo, nuevoJefe)) {
            return false; // Impide colocar un jefe debajo de su subordinado.
        }

        nodo.getJefe().getSubordinados().remove(nodo);
        nodo.setJefe(nuevoJefe);
        nuevoJefe.getSubordinados().add(nodo);
        ActualizarNivelesRecursivo(nodo, nuevoJefe.getNivel() + 1);
        return true;
    }

    private boolean EstaEnSubarbolRecursivo(NodoEmpleado pActual,
            NodoEmpleado pBuscado) {
        if (pActual == pBuscado) {
            return true;
        }

        for (int i = 0; i < pActual.getSubordinados().size(); i++) {
            if (EstaEnSubarbolRecursivo(
                    pActual.getSubordinados().get(i), pBuscado)) {
                return true;
            }
        }

        return false;
    }

    private void ActualizarNivelesRecursivo(NodoEmpleado pActual, int pNivel) {
        pActual.setNivel(pNivel);

        for (int i = 0; i < pActual.getSubordinados().size(); i++) {
            ActualizarNivelesRecursivo(
                    pActual.getSubordinados().get(i), pNivel + 1);
        }
    }

    public Empleado JefeComunMasCercano(int pIdPrimero, int pIdSegundo) {
        NodoEmpleado primero = BuscarPorId(pIdPrimero);
        NodoEmpleado segundo = BuscarPorId(pIdSegundo);

        if (primero == null) {
            return null;
        }
        if (segundo == null) {
            return null;
        }

        while (primero.getNivel() > segundo.getNivel()) {
            primero = primero.getJefe();
        }

        while (segundo.getNivel() > primero.getNivel()) {
            segundo = segundo.getJefe();
        }

        while (primero != segundo) {
            primero = primero.getJefe();
            segundo = segundo.getJefe();
        }

        return primero.getEmpleado();
    }
}
