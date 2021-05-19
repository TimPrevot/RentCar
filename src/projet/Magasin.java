package projet;

import java.util.List;
import java.util.Scanner;

public class Magasin {
    private List<Client> listeClients;
    private List<Employe> listeEmployes;
    private List<Vehicule> listeVehicules;
    private List<Agence> listeAgences;
    private List<ProgrammeFidelite> listeProgrammesFidelite;

    // Constructeur par défaut
    public Magasin() {}

    //Affichage de la liste des programmes de fidélité
    public void afficherProgrammes(){
        String programmeString;
        for (ProgrammeFidelite programme : listeProgrammesFidelite){
            programmeString = programme.toString();
            System.out.println(programmeString);
        }
    }

    //Souscrire à un programme de fidélité
    public void souscrireProgrammeFidele(Client client){
        Scanner scanner = new Scanner(System.in);
        this.afficherProgrammes();
        System.out.println("Veuillez indiquer l'ID du programme auquel vous souhaitez souscrire, ou tapez 0 pour ne pas souscrire :");
        int choixClient = scanner.nextInt();
        if (choixClient == 0){
            System.out.println("Opération annulée");
        }
        else {
            for (ProgrammeFidelite programme : listeProgrammesFidelite){
                if (programme.getID() == choixClient){
                    client.souscrireFidele(programme);
                }
            }
        }

    }
}
