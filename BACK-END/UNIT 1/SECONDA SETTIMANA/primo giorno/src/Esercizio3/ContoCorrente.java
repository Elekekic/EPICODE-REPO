package Esercizio3;

public class ContoCorrente {
    String titolare;
    int nMovimenti;
    final int maxMovimenti = 50;
    double saldo;

    ContoCorrente(String titolare, double saldo) {
        this.titolare = titolare;
        this.saldo = saldo;
        nMovimenti = 0;
    }

    void preleva(double x) throws BancaException {
        try {
            if (nMovimenti < maxMovimenti) {
                if (saldo >= x) {
                    saldo -= x;
                } else {
                    throw new BancaException("Il conto è rosso");
                }
            } else {
                if (saldo >= x + 0.50) {
                    saldo -= x + 0.50;
                } else {
                    throw new BancaException("Il conto è rosso");
                }
            }
            nMovimenti++;
        } catch (BancaException e) {
            System.out.println(e.getMessage());
        }
    }
    double restituisciSaldo() {
        return saldo;
    }
}
