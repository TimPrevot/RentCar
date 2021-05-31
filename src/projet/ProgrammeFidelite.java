package projet;

public class ProgrammeFidelite {
    private int ID;
    private static int count;
    private String description;
    private int prix;
    private int reduction;

    public ProgrammeFidelite() {
        this.ID = count++;
    }

    public int getID(){
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getReduction() {
        return reduction;
    }

    public void setReduction(int reduction) {
        this.reduction = reduction;
    }

    @Override
    public String toString() {
        return "ProgrammeFidelite{" +
                "ID=" + ID +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                ", reduction=" + reduction +
                '}';
    }

    /**
     * @return a clone of this instance.
     *
     * @see Cloneable
     */
    @Override
    public ProgrammeFidelite clone() {
        ProgrammeFidelite result = new ProgrammeFidelite();
        result.setID(this.ID);
        result.setDescription(this.description);
        result.setPrix(this.prix);
        result.setReduction(this.reduction);
        return result;
    }
}
