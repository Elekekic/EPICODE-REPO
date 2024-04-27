public class Riviste {

    private Integer codiceISBN;
    public String titolo;
    public Integer annoPubblicazione;
    public Integer numeroPagine;
    public String Autore;
    public String Genere;
    public Periodicita periodicita;

    public Riviste(Integer codiceISBN, String titolo, Integer annoPubblicazione, Integer numeroPagine, String autore, String genere, Periodicita periodicita) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
        Autore = autore;
        Genere = genere;
        this.periodicita = periodicita;
    }


    public Integer getCodiceISBN() {
        return codiceISBN;
    }

    public void setCodiceISBN(Integer codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Integer getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(Integer annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public Integer getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(Integer numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public String getAutore() {
        return Autore;
    }

    public void setAutore(String autore) {
        Autore = autore;
    }

    public String getGenere() {
        return Genere;
    }

    public void setGenere(String genere) {
        Genere = genere;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Riviste { " +
                "codiceISBN: " + codiceISBN +
                ", titolo: '" + titolo + '\'' +
                ", annoPubblicazione: " + annoPubblicazione +
                ", numeroPagine: " + numeroPagine +
                ", Autore: '" + Autore + '\'' +
                ", Genere: '" + Genere + '\'' +
                ", periodicita: " + periodicita +
                " }";
    }
}
