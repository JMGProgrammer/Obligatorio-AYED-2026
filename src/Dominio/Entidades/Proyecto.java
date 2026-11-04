package Dominio.Entidades;

import java.util.ArrayList;

public class Proyecto {

    private int aId;
    private String aNombre;
    private String aFechaInicio;
    private String aFechaFin;
    private String aEstado;
    private Empleado aResponsable;
    private ArrayList<Asignacion> aAsignaciones;

    public int getId(){return this.aId;}
    public String getNombre(){return this.aNombre;}
    public void setNombre(String pNombre){this.aNombre = pNombre;}
    public String getFechaInicio(){return this.aFechaInicio;}
    public void setFechaInicio(String pFechaInicio){this.aFechaInicio = pFechaInicio;}
    public String getFechaFin(){return this.aFechaFin;}
    public void setFechaFin(String pFechaFin){this.aFechaFin = pFechaFin;}
    public String getEstado(){return this.aEstado;}
    public void setEstado(String pEstado){this.aEstado = pEstado;}
    public Empleado getResponsable(){return this.aResponsable;}
    public void setResponsable(Empleado pResponsable){this.aResponsable = pResponsable;}
    public ArrayList<Asignacion> getAsignaciones(){return this.aAsignaciones;}

    public Proyecto(int pId, String pNombre, String pFechaInicio, String pFechaFin,
            String pEstado, Empleado pResponsable) {
        this.aId = pId;
        this.aNombre = pNombre;
        this.aFechaInicio = pFechaInicio;
        this.aFechaFin = pFechaFin;
        this.aEstado = pEstado;
        this.aResponsable = pResponsable;
        this.aAsignaciones = new ArrayList<Asignacion>();
    }

    public String toString() {
        return "[" + this.aId + "] " + this.aNombre
                + " | " + this.aEstado
                + " | responsable: " + this.aResponsable.getNombreCompleto();
    }
}
