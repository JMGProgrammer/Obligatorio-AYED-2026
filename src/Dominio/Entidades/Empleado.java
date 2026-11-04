package Dominio.Entidades;

public class Empleado {

    private int aId;
    private String aNombre;
    private String aApellido;
    private Cargo aCargo;
    private Departamento aDepartamento;
    private double aSalario;
    private String aFechaIngreso;

    public int getId(){return this.aId;}
    public String getNombre(){return this.aNombre;}
    public void setNombre(String pNombre){this.aNombre = pNombre;}
    public String getApellido(){return this.aApellido;}
    public void setApellido(String pApellido){this.aApellido = pApellido;}
    public Cargo getCargo(){return this.aCargo;}
    public void setCargo(Cargo pCargo){this.aCargo = pCargo;}
    public Departamento getDepartamento(){return this.aDepartamento;}
    public void setDepartamento(Departamento pDepartamento){this.aDepartamento = pDepartamento;}
    public double getSalario(){return this.aSalario;}
    public void setSalario(double pSalario){this.aSalario = pSalario;}
    public String getFechaIngreso(){return this.aFechaIngreso;}
    public void setFechaIngreso(String pFechaIngreso){this.aFechaIngreso = pFechaIngreso;}

    public Empleado(int pId, String pNombre, String pApellido, Cargo pCargo,
            Departamento pDepartamento, double pSalario, String pFechaIngreso) {
        this.aId = pId;
        this.aNombre = pNombre;
        this.aApellido = pApellido;
        this.aCargo = pCargo;
        this.aDepartamento = pDepartamento;
        this.aSalario = pSalario;
        this.aFechaIngreso = pFechaIngreso;
    }

    public String getNombreCompleto() {
        return this.aNombre + " " + this.aApellido;
    }

    public String toString() {
        return "[" + this.aId + "] " + getNombreCompleto()
                + " | " + this.aCargo.getNombre()
                + " | " + this.aDepartamento.getNombre()
                + " | $" + this.aSalario;
    }
}
