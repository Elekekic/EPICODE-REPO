public class Immagine extends ElementoMultimediale implements Luminosita {
    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;
    }

    @Override
    public void play() {

    }

    @Override
    public void aumentaLuminosita() {
        luminosita++;
    }

    @Override
    public void diminuisciLuminosita() {
        luminosita--;
    }

    @Override
    public void show() {
        System.out.println(titolo + "*".repeat(Math.max(0, luminosita)));
    }
}
