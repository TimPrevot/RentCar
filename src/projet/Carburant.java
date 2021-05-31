package projet;

public class Carburant implements Cloneable{

    private int ID;
    private static int count;
    private String nom;

    public Carburant(String nom){
        this.ID = count++;
        this.nom = nom;
    }

    public Carburant(){ this.ID = count++; }

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
        Carburant.count = count;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return a clone of this instance.
     *
     * @see Cloneable
     */
    @Override
    public Carburant clone() {
        Carburant result = new Carburant();
        result.setID(this.ID);
        result.setNom(this.nom);
        return result;
    }
}
