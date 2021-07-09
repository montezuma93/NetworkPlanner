package Schulung;

public class Adresse {

    String stadt;
    String strasse;
    int plz;
    String land;

    public Adresse(String strasse, int plz, String stadt, String land) {
        this.strasse = strasse;
        this.plz = plz;
        this.stadt = stadt;
        this.land = land;
    }

    @Override
    public String toString() {
        return "Adresse{" +
                "stadt='" + stadt + '\'' +
                ", straße='" + strasse + '\'' +
                ", plz=" + plz +
                ", land=" + land +
                '}';
    }
}
