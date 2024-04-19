public class Immagine extends ElementoMultimediale implements Luminosita {
    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;
    }

    @Override
    public void play() {
        System.out.println("Non puoi ascoltare un'immagine");
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
        System.out.println("Visualizzazione Immagine: ");
        for (int i = 0; i < luminosita; i++) {
            System.out.println(">>" + " *".repeat(Math.max(0, luminosita)));
        }
    }
}
