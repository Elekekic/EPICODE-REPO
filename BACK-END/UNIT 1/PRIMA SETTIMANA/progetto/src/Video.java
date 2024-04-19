public class Video extends ElementoMultimediale implements Luminosita {
    private int volume;
    private int luminosita;

    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo, durata);
        this.volume = volume;
        this.luminosita = luminosita;
    }


    @Override
    public void play() {
        System.out.println("Riproduzione Video: ");
        for (int i = 0; i < durata; i++) {
            StringBuilder line = new StringBuilder(">>");
            line.append("!".repeat(Math.max(0, volume)));
            line.append(" *".repeat(Math.max(0, luminosita)));
            System.out.println(line);
        }
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

    }
}

