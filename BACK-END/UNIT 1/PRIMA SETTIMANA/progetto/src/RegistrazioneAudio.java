public class RegistrazioneAudio extends ElementoMultimediale {

    private int volume;

    public RegistrazioneAudio(String titolo, int durata, int volume) {
        super(titolo, durata);
        this.volume = volume;
    }

    public void abbassaVolume() {
        volume--;
    }

    public void alzaVolume() {
       volume++;
    }

    @Override
    public void play() {
        System.out.println("Riproduzione Registrazione Audio: ");
        for (int i = 0; i < durata; i++) {
            System.out.println(">" + " !".repeat(Math.max(0, volume)));
        }
    }
}
