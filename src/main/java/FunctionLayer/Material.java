package FunctionLayer;

public class Material {

    /**

     @author Nikolaj
     @author Mathias
     Denne klasse indeholder data for materiale objekter.

     */
    private String navn;
    private String beskrivelse;
    private String enhed;
    private String kategori;
    private int laengde;
    private double pris;
    private int antal;

    public Material(String navn, String beskrivelse, String enhed, String kategori, int laengde, double pris) {
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.enhed = enhed;
        this.kategori = kategori;
        this.laengde = laengde;
        this.pris = pris;
    }

    public Material(String navn, String beskrivelse, String enhed, String kategori, int laengde, double pris, int antal) {
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.enhed = enhed;
        this.kategori = kategori;
        this.laengde = laengde;
        this.pris = pris;
        this.antal = antal;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public String getEnhed() {
        return enhed;
    }

    public void setEnhed(String enhed) {
        this.enhed = enhed;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getLaengde() {
        return laengde;
    }

    public void setLaengde(int laengde) {
        this.laengde = laengde;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    @Override
    public String toString() {
        return "Material{" +
                "navn='" + navn + '\'' +
                ", beskrivelse='" + beskrivelse + '\'' +
                ", enhed='" + enhed + '\'' +
                ", kategori='" + kategori + '\'' +
                ", laengde=" + laengde +
                ", pris=" + pris +
                '}';
    }
}
