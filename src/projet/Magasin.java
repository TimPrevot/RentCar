package projet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Magasin {
    private List<Client> listeClients;
    private List<Employe> listeEmployes;
    private List<Vehicule> listeVehicules;
    private List<Agence> listeAgences;
    private List<ProgrammeFidelite> listeProgrammesFidelite;
    private List<Vehicule> listeLocations;

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

    //Affichage de la liste des véhicules de l'agence
    public void afficherVehicules(){
        String vehiculeString;
        for (Vehicule vehicule : listeVehicules){
            vehiculeString = vehicule.toString();
            System.out.println(vehiculeString);
        }
    }

    //Affichage de la liste des clients de l'agence
    public void afficherClients(){
        String clientString;
        for (Client client : listeClients){
            clientString = client.toString();
            System.out.println(clientString);
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
        scanner.close();
    }
    public void renouvelerProgramme(Client client){
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Voulez vous renouveler cet abonnement au programme fidélité ?");
        String choixClient = scanner.nextLine();
        if (choixClient.equals("N")){
            System.out.println("La souscription au programme fidélité est terminée.");
        }
        else if (choixClient.equals("Y")){
            System.out.println("De combien d'années supplémentaires voulez vous souscrire ?");
            int duree = scanner1.nextInt();
                client.prolongerFidele(duree);
        }
        scanner.close();
        scanner1.close();
    }

    public void ajouterLocation(Vehicule vehicule){
        for (Vehicule vehicule2 : listeVehicules){
            if (vehicule.getID() == vehicule2.getID()){
                listeLocations.add(vehicule);
                vehicule.louer();
                System.out.println("Véhicule ajouté !");
            }
        }
    }

    public void creerDevis(){
        Scanner scanner = new Scanner(System.in);
        Devis devis = new Devis();
        afficherClients();
        System.out.println("Veuillez indiquer l'ID du client concerné par le devis :");
        int choixClient = scanner.nextInt();
        for (Client client : listeClients){
            if (client.getID() == choixClient){
                devis.setClient(client);
            }
        }
        afficherVehicules();
        System.out.println("Veuillez indiquer l'ID du véhicule à louer :");
        int choixVehicule = scanner.nextInt();
        for (Vehicule vehicule : listeVehicules){
            if (vehicule.getID() == choixVehicule){
                devis.setVehiculeLoue(vehicule);
            }
        }
        if (devis.getClient().isClientFidele()){
            devis.setMontantReduction(20);
        }
        System.out.println("Voulez-vous souscrire à une assurance ? Tapez O pour oui et N pour non");
        String choixAssurance = scanner.nextLine();
        if (choixAssurance.equals('O')){
            devis.setAssurance(true);
        }
        System.out.println("Veuillez indiquer la date de début de location, au format jour/mois/année :");
        String dateDebut = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate localDateDebut = LocalDate.parse(dateDebut, formatter);
        devis.setDateDebut(localDateDebut);
        System.out.println("Veuillez indiquer la durée de la location, en jours :");
        long duree = scanner.nextInt();
        devis.setDureeJours(duree);
        LocalDate dateFin = localDateDebut.plusDays(duree);
        devis.setDateFin(dateFin);
    }
}
