public abstract class ElementoMultimediale {
    protected String titolo;
    protected int durata;

    public ElementoMultimediale(String titolo, int durata) {
        this.titolo = titolo;
        this.durata = durata;
    }

    public ElementoMultimediale(String titolo) {
        this.titolo = titolo;
    }

    public abstract void play();
}
