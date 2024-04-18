package esercizi;

public abstract class Dipendente {

    private final String matricola;
    private double stipendio;
    public static final double stipendioBase = 1200;
    private dipartimento reparto;

    public Dipendente(String matricola, double stipendio) {
        this.matricola = matricola;
        this.stipendio = stipendio;
    }

    public String getMatricola() {
        return matricola;
    }

    public double getStipendio() {
        return stipendio;
    }

    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }

    public dipartimento getReparto() {
        return reparto;
    }

    public void setReparto(dipartimento reparto) {
        this.reparto = reparto;
    }

    public abstract void calculateSalary();

    public enum dipartimento {
        PRODUZIONE,
        AMMINISTRAZIONE,
        VENDITE
    }
}

class DipendenteFullTime extends Dipendente {
    public DipendenteFullTime(String matricola, double stipendio) {
        super(matricola, stipendio);
    }

    @Override
    public void calculateSalary() {
        double salarioMensile = getStipendio() + Dipendente.stipendioBase;
        System.out.println("Salario mensile per il dipendente full-time: " + salarioMensile);
    }
}

class DipendentePartTime extends Dipendente {
    private int oreLavorate;

    public DipendentePartTime(String matricola, double stipendio, int oreLavorate) {
        super(matricola, stipendio);
        this.oreLavorate = oreLavorate;
    }

    @Override
    public void calculateSalary() {
        int salarioPerOre = 20;
        double salarioTotale = salarioPerOre * oreLavorate;
        System.out.println("Salario per il dipendente part-time basato sulle ore lavorate: " + salarioTotale);
    }
}

class Dirigente extends Dipendente {
    public Dirigente(String matricola, double stipendio) {
        super(matricola, stipendio);
    }

    @Override
    public void calculateSalary() {
        double salarioMensile = getStipendio() + Dipendente.stipendioBase;
        System.out.println("Salario mensile per il dirigente: " + salarioMensile);
    }
}
