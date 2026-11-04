package Dominio.Entidades;

public class Cargo {

    private int aId;
    private String aNombre;
    private int aNivelJerarquico;
    private double aSalarioBase;

    public int getId(){return this.aId;}
    public String getNombre(){return this.aNombre;}
    public void setNombre(String pNombre){this.aNombre = pNombre;}
    public int getNivelJerarquico(){return this.aNivelJerarquico;}
    public void setNivelJerarquico(int pNivelJerarquico){this.aNivelJerarquico = pNivelJerarquico;}
    public double getSalarioBase(){return this.aSalarioBase;}
    public void setSalarioBase(double pSalarioBase){this.aSalarioBase = pSalarioBase;}

    public Cargo(int pId, String pNombre, int pNivelJerarquico, double pSalarioBase) {
        this.aId = pId;
        this.aNombre = pNombre;
        this.aNivelJerarquico = pNivelJerarquico;
        this.aSalarioBase = pSalarioBase;
    }

    public String toString() {
        return "[" + this.aId + "] " + this.aNombre
                + " | nivel jerárquico: " + this.aNivelJerarquico
                + " | salario base: $" + this.aSalarioBase;
    }
}
