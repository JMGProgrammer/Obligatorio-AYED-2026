package Dominio.Entidades;

public class Asignacion {

    private int aId;
    private Empleado aEmpleado;
    private Proyecto aProyecto;
    private int aHorasAsignadas;
    private String aRol;

    public int getId(){return this.aId;}
    public Empleado getEmpleado(){return this.aEmpleado;}
    public void setEmpleado(Empleado pEmpleado){this.aEmpleado = pEmpleado;}
    public Proyecto getProyecto(){return this.aProyecto;}
    public void setProyecto(Proyecto pProyecto){this.aProyecto = pProyecto;}
    public int getHorasAsignadas(){return this.aHorasAsignadas;}
    public void setHorasAsignadas(int pHorasAsignadas){this.aHorasAsignadas = pHorasAsignadas;}
    public String getRol(){return this.aRol;}
    public void setRol(String pRol){this.aRol = pRol;}

    public Asignacion(int pId, Empleado pEmpleado, Proyecto pProyecto,
            int pHorasAsignadas, String pRol) {
        this.aId = pId;
        this.aEmpleado = pEmpleado;
        this.aProyecto = pProyecto;
        this.aHorasAsignadas = pHorasAsignadas;
        this.aRol = pRol;
    }

    public String toString() {
        return "[" + this.aId + "] " + this.aEmpleado.getNombreCompleto()
                + " -> " + this.aProyecto.getNombre()
                + " | " + this.aHorasAsignadas + " horas | " + this.aRol;
    }
}
