package Dominio.Entidades;

public class Departamento {

    private int aId;
    private String aNombre;
    private String aDescripcion;
    private Empleado aResponsable;

    public int getId(){return this.aId;}
    public String getNombre(){return this.aNombre;}
    public void setNombre(String pNombre){this.aNombre = pNombre;}
    public String getDescripcion(){return this.aDescripcion;}
    public void setDescripcion(String pDescripcion){this.aDescripcion = pDescripcion;}
    public Empleado getResponsable(){return this.aResponsable;}
    public void setResponsable(Empleado pResponsable){this.aResponsable = pResponsable;}

    public Departamento(int pId, String pNombre, String pDescripcion,
            Empleado pResponsable) {
        this.aId = pId;
        this.aNombre = pNombre;
        this.aDescripcion = pDescripcion;
        this.aResponsable = pResponsable;
    }

    public String toString() {
        String nombreResponsable = "Sin responsable";
        if (this.aResponsable != null) {
            nombreResponsable = this.aResponsable.getNombreCompleto();
        }

        return "[" + this.aId + "] " + this.aNombre
                + " | responsable: " + nombreResponsable;
    }
}
