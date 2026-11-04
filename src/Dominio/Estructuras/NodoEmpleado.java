package Dominio.Estructuras;

import java.util.ArrayList;
import Dominio.Entidades.Empleado;

public class NodoEmpleado {

    private Empleado aEmpleado;
    private NodoEmpleado aJefe;
    private ArrayList<NodoEmpleado> aSubordinados;
    private int aNivel;

    public Empleado getEmpleado(){return this.aEmpleado;}
    public void setEmpleado(Empleado pEmpleado){this.aEmpleado = pEmpleado;}

    public NodoEmpleado getJefe(){return this.aJefe;}
    public void setJefe(NodoEmpleado pJefe){this.aJefe = pJefe;}

    public ArrayList<NodoEmpleado> getSubordinados(){return this.aSubordinados;}
    public void setSubordinados(ArrayList<NodoEmpleado> pSubordinados){this.aSubordinados = pSubordinados;}

    public int getNivel(){return this.aNivel;}
    public void setNivel(int pNivel){this.aNivel = pNivel;}

    public NodoEmpleado(Empleado pEmpleado, NodoEmpleado pJefe,
            ArrayList<NodoEmpleado> pSubordinados, int pNivel) {
        this.aEmpleado = pEmpleado;
        this.aJefe = pJefe; // null únicamente para el Gerente General.
        this.aSubordinados = pSubordinados; // Reemplaza izq y der en el árbol N-ario.
        this.aNivel = pNivel;
    }
}
