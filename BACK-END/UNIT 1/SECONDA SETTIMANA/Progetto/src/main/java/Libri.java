public class Libri {

    private int codiceISBN;
    public String titolo;
    public int annoPubblicazione;
    public int numeroPagine;
    public String autore;
    public String genere;
    public Periodicita periodicita;

    public Libri(int codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere, Periodicita periodicita) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
        this.autore = autore;
        this.genere = genere;
        this.periodicita = periodicita;
    }

    public int getCodiceISBN() {
        return codiceISBN;
    }

    public void setCodiceISBN(int codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Libri { " +
                "codiceISBN:" + codiceISBN +
                ", titolo:'" + titolo + '\'' +
                ", annoPubblicazione:" + annoPubblicazione +
                ", numeroPagine:" + numeroPagine +
                ", autore:'" + autore + '\'' +
                ", genere:'" + genere + '\'' +
                ", periodicita:" + periodicita +
                " }";
    }
}
