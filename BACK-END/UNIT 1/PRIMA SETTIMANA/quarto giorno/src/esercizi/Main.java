package esercizio1;

public class Main {

    public static void main(String[] args) {
        Dipendente dipendente1 = new DipendenteFullTime("201", 2500);
        Dipendente dipendente2 = new DipendentePartTime("202", 2700, 40);
        Dipendente dipendente3 = new Dirigente("203", 2600);

        Dipendente[] dipendenti = {dipendente1, dipendente2, dipendente3};

        for (Dipendente dipendente : dipendenti) {
            dipendente.calculateSalary();
            System.out.println( "La sua matricola è: " + dipendente.getMatricola() + ", ed il suo stipendio è di: " + dipendente.getStipendio());
            System.out.println("-------------------------------");
        }
    }
}
