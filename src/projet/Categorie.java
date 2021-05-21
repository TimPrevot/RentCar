package projet;

public class Categorie {
    private int ID;
    private static int count;
    private String nom;
    private int prixJour;
    private int caution;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Categorie.count = count;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrixJour() {
        return prixJour;
    }

    public void setPrixJour(int prixJour) {
        this.prixJour = prixJour;
    }

    public int getCaution() {
        return caution;
    }

    public void setCaution(int caution) {
        this.caution = caution;
    }
}
