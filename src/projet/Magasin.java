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
    private List<Categorie> listeCategorie;

    // Constructeur par défaut
    public Magasin() {}

    //Affichage de la liste des programmes de fidélité
    public void afficherProgrammes(){
        String programmeString;
        //TODO EmptyListException
        for (ProgrammeFidelite programme : listeProgrammesFidelite){
            programmeString = programme.toString();
            System.out.println(programmeString);
        }
    }

    //Affichage de la liste des véhicules de l'agence
    public void afficherVehicules(){
        String vehiculeString;
        //TODO EmptyListException
        for (Vehicule vehicule : listeVehicules){
            vehiculeString = vehicule.toString();
            System.out.println(vehiculeString);
        }
    }

    //Affichage des véhicules par catégorie
    public void afficherCategorie(){
        Scanner scanner = new Scanner(System.in);
        String affichCategorie;
        for (Categorie categorie : listeCategorie){
            affichCategorie = categorie.getNom();
            System.out.println(affichCategorie);
        }
        System.out.println("Veuillez sélectionner la catégorie à afficher");
        String vehiculeCategorie;
        String choixCategorie = scanner.nextLine();
        if (choixCategorie.equals("eco")){
            for (Vehicule vehicule : listeVehicules){
                if (vehicule.getCategorie().getNom().equals("eco")){
                    vehiculeCategorie = vehicule.toString();
                    System.out.println(vehiculeCategorie);
                }
            }
        }
        else if(choixCategorie.equals("confort")){
            for (Vehicule vehicule : listeVehicules){
                if (vehicule.getCategorie().getNom().equals("confort")){
                    vehiculeCategorie = vehicule.toString();
                    System.out.println(vehiculeCategorie);
                }
            }
        }
        else if(choixCategorie.equals("luxe")){
            for (Vehicule vehicule : listeVehicules){
                if (vehicule.getCategorie().getNom().equals("luxe")){
                    vehiculeCategorie = vehicule.toString();
                    System.out.println(vehiculeCategorie);
                }
            }
        }

        scanner.close();
    }

    //Affichage par marque de véhicule
    public void afficherMarque(){
        Scanner scanner = new Scanner(System.in);
        String affichMarque;
        for (Vehicule vehicule : listeVehicules){
            affichMarque = vehicule.getMarque();
            System.out.println(affichMarque);
        }
        System.out.println("Veuillez sélectionner la marque du véhicule à afficher");
        String vehiculeMarque;
        String choixMarque = scanner.nextLine();
        if (choixMarque.equals("Honda")){
            for (Vehicule vehicule : listeVehicules){
                if (vehicule.getMarque().equals("Honda")){
                    vehiculeMarque = vehicule.toString();
                    System.out.println(vehiculeMarque);
                }
            }
        }
        else if(choixMarque.equals("Renault")){
            for (Vehicule vehicule : listeVehicules){
                if (vehicule.getMarque().equals("Renault")){
                    vehiculeMarque = vehicule.toString();
                    System.out.println(vehiculeMarque);
                }
            }
        }
        else if(choixMarque.equals("Citroën")){
            for (Vehicule vehicule : listeVehicules){
                if (vehicule.getMarque().equals("Citroën")){
                    vehiculeMarque = vehicule.toString();
                    System.out.println(vehiculeMarque);
                }
            }
        }
        else if(choixMarque.equals("Mazda")){
            for (Vehicule vehicule : listeVehicules){
                if (vehicule.getMarque().equals("Mazda")){
                    vehiculeMarque = vehicule.toString();
                    System.out.println(vehiculeMarque);
                }
            }
        }
        else if(choixMarque.equals("Mercedes")){
            for (Vehicule vehicule : listeVehicules){
                if (vehicule.getMarque().equals("Mercedes")){
                    vehiculeMarque = vehicule.toString();
                    System.out.println(vehiculeMarque);
                }
            }
        }
        else if(choixMarque.equals("Audi")){
            for (Vehicule vehicule : listeVehicules){
                if (vehicule.getMarque().equals("Audi")){
                    vehiculeMarque = vehicule.toString();
                    System.out.println(vehiculeMarque);
                }
            }
        }

        scanner.close();
    }

    //Afficher les véhicules en cours de location
    public void afficherLoue(){
        String vehiculeLoue;
        for (Vehicule vehicule : listeVehicules){
            if (vehicule.isEstLoue()){
                vehiculeLoue = vehicule.toString();
                System.out.println(vehiculeLoue);
            }
        }
    }

    //Affichage de la liste des clients de l'agence
    public void afficherClients(){
        String clientString;
        //TODO EmptyListException
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
        //TODO BadUserInputException
        if (choixClient == 0){
            System.out.println("Opération annulée");
        }
        else {
            for (ProgrammeFidelite programme : listeProgrammesFidelite){
                //TODO EmptyListException
                if (programme.getID() == choixClient){
                    client.souscrireFidele(programme);
                }
            }
        }
        scanner.close();
    }

    //Renouveler un programme de fidélité
    public void renouvelerProgramme(Client client){
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Voulez vous renouveler cet abonnement au programme fidélité ?");
        String choixClient = scanner.nextLine();
        //TODO BadUserInputException
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

    //Ajouter une voiture aux locations
    public void ajouterLocation(Vehicule vehicule){
        for (Vehicule vehicule2 : listeVehicules){
            //TODO EmptyListException
            if (vehicule.getID() == vehicule2.getID()){
                listeLocations.add(vehicule);
                vehicule.louer();
                System.out.println("Véhicule ajouté !");
            }
        }
    }

    //Créer un devis
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
