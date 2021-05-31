package projet;

import connect_db.ConnectDB;
import connect_db.DeleteValue;
import connect_db.EditValue;
import connect_db.InsertValue;
import connect_db.ReadValue;
import exceptions.BadInputException;
import projet.ProgrammeFidelite;
import projet.Employe;
import projet.Vehicule;
import projet.Carburant;
import projet.Categorie;
import projet.Client;
import projet.Agence;
import projet.Devis;

import java.io.Reader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Vector;

import static projet.ScannerUtils.scanner;

public class Magasin {
    private Vector<Client> listeClients;
    private Vector<Employe> listeEmployes;
    private Vector<Vehicule> listeVehicules;
    private Vector<Agence> listeAgences;
    private Vector<ProgrammeFidelite> listeProgrammesFidelite;
    private Vector<Vehicule> listeLocations;
    private Vector<Categorie> listeCategories;
    private Vector<Carburant> listeCarburants;
    private Vector<Devis> listeDevis;
    private boolean userConnected;
    private Employe user;

    // Constructeur par défaut
    public Magasin() {
    }

    //Affichage de la liste des programmes de fidélité
    public void afficherProgrammes() {
        String programmeString;
        //TODO EmptyListException
        for (ProgrammeFidelite programme : listeProgrammesFidelite) {
            programmeString = programme.toString();
            System.out.println(programmeString);
        }
    }

    //Affichage de la liste des véhicules de l'agence
    public void afficherVehicules() {
        String vehiculeString;
        //TODO EmptyListException
        for (Vehicule vehicule : listeVehicules) {
            vehiculeString = vehicule.toString();
            System.out.println(vehiculeString);
        }
    }

    //Affichage de la liste des catégories de véhicules
    public void afficherCategories(){
        String categorieString;
        for(Categorie categorie : listeCategories){
            categorieString = categorie.toString();
            System.out.println(categorieString);
        }
    }

    //Affichage de la liste des carburants
    public void afficherCarburants(){
        String carburantString;
        for(Carburant carburant : listeCarburants){
            carburantString = carburant.toString();
            System.out.println(carburantString);
        }
    }

    //Affichage des véhicules par catégorie
    public void afficherVehiculeCategorie() {
        String affichCategorie;
        for (Categorie categorie : listeCategories) {
            affichCategorie = categorie.getNom();
            System.out.println(affichCategorie);
        }
        System.out.println("Veuillez sélectionner la catégorie à afficher");
        String vehiculeCategorie;
        String choixCategorie = scanner.nextLine();
        if (choixCategorie.equals("Eco")) {
            for (Vehicule vehicule : listeVehicules) {
                if (vehicule.getCategorie().getNom().equals("eco")) {
                    vehiculeCategorie = vehicule.toString();
                    System.out.println(vehiculeCategorie);
                }
            }
        } else if (choixCategorie.equals("Confort")) {
            for (Vehicule vehicule : listeVehicules) {
                if (vehicule.getCategorie().getNom().equals("confort")) {
                    vehiculeCategorie = vehicule.toString();
                    System.out.println(vehiculeCategorie);
                }
            }
        } else if (choixCategorie.equals("Luxe")) {
            for (Vehicule vehicule : listeVehicules) {
                if (vehicule.getCategorie().getNom().equals("luxe")) {
                    vehiculeCategorie = vehicule.toString();
                    System.out.println(vehiculeCategorie);
                }
            }
        }

    }

    //Affichage par marque de véhicule
    public void afficherMarque() {
        String affichMarque;
        for (Vehicule vehicule : listeVehicules) {
            affichMarque = vehicule.getMarque();
            System.out.println(affichMarque);
        }
        System.out.println("Veuillez sélectionner la marque du véhicule à afficher");
        String vehiculeMarque;
        String choixMarque = scanner.nextLine();
        if (choixMarque.equals("Honda")) {
            for (Vehicule vehicule : listeVehicules) {
                if (vehicule.getMarque().equals("Honda")) {
                    vehiculeMarque = vehicule.toString();
                    System.out.println(vehiculeMarque);
                }
            }
        } else if (choixMarque.equals("Renault")) {
            for (Vehicule vehicule : listeVehicules) {
                if (vehicule.getMarque().equals("Renault")) {
                    vehiculeMarque = vehicule.toString();
                    System.out.println(vehiculeMarque);
                }
            }
        } else if (choixMarque.equals("Citroën")) {
            for (Vehicule vehicule : listeVehicules) {
                if (vehicule.getMarque().equals("Citroën")) {
                    vehiculeMarque = vehicule.toString();
                    System.out.println(vehiculeMarque);
                }
            }
        } else if (choixMarque.equals("Mazda")) {
            for (Vehicule vehicule : listeVehicules) {
                if (vehicule.getMarque().equals("Mazda")) {
                    vehiculeMarque = vehicule.toString();
                    System.out.println(vehiculeMarque);
                }
            }
        } else if (choixMarque.equals("Mercedes")) {
            for (Vehicule vehicule : listeVehicules) {
                if (vehicule.getMarque().equals("Mercedes")) {
                    vehiculeMarque = vehicule.toString();
                    System.out.println(vehiculeMarque);
                }
            }
        } else if (choixMarque.equals("Audi")) {
            for (Vehicule vehicule : listeVehicules) {
                if (vehicule.getMarque().equals("Audi")) {
                    vehiculeMarque = vehicule.toString();
                    System.out.println(vehiculeMarque);
                }
            }
        }

    }

    //Afficher les véhicules en cours de location
    public void afficherLoue() {
        String vehiculeLoue;
        for (Vehicule vehicule : listeVehicules) {
            if (vehicule.isEstLoue()) {
                vehiculeLoue = vehicule.toString();
                System.out.println(vehiculeLoue);
            }
        }
    }

    //Affichage de la liste des clients de l'agence
    public void afficherClients() {
        String clientString;
        //TODO EmptyListException
        for (Client client : listeClients) {
            clientString = client.toString();
            System.out.println(clientString);
        }
    }

    //Souscrire à un programme de fidélité
    public void souscrireProgrammeFidele(Client client) {
        this.afficherProgrammes();
        System.out.println("Veuillez indiquer l'ID du programme auquel vous souhaitez souscrire, ou tapez 0 pour ne pas souscrire :");
        int choixClient = scanner.nextInt();
        //TODO BadUserInputException
        if (choixClient == 0) {
            System.out.println("Opération annulée");
        } else {
            for (ProgrammeFidelite programme : listeProgrammesFidelite) {
                if (programme.getID() == choixClient) {
                    client.souscrireFidele(programme);
                }
            }
        }
    }

    //Renouveler un programme de fidélité
    public void renouvelerProgramme(Client client) {
        System.out.println("Voulez vous renouveler cet abonnement au programme fidélité ?");
        String choixClient = scanner.nextLine();
        //TODO BadUserInputException
        if (choixClient.equals("N")) {
            System.out.println("La souscription au programme fidélité est terminée.");
        } else if (choixClient.equals("Y")) {
            System.out.println("De combien d'années supplémentaires voulez vous souscrire ?");
            int duree = scanner.nextInt();
            client.prolongerFidele(duree);
        }
    }

    //Ajouter une voiture aux locations
    public void ajouterLocation(Vehicule vehicule) {
        for (Vehicule vehicule2 : listeVehicules) {
            //TODO EmptyListException
            if (vehicule.getID() == vehicule2.getID()) {
                listeLocations.add(vehicule);
                vehicule.louer();
                System.out.println("Véhicule ajouté !");
            }
        }
    }

    //Créer un devis
    public void creerDevis() {
        InsertValue adder = new InsertValue();
        Devis devis = new Devis();
        afficherClients();
        System.out.println("Veuillez indiquer l'ID du client concerné par le devis :");
        int choixClient = scanner.nextInt();
        for (Client client : listeClients) {
            if (client.getID() == choixClient) {
                devis.setClient(client.clone());
            }
        }
        afficherVehicules();
        System.out.println("Veuillez indiquer l'ID du véhicule à louer :");
        int choixVehicule = scanner.nextInt();
        for (Vehicule vehicule : listeVehicules) {
            if (vehicule.getID() == choixVehicule) {
                devis.setVehiculeLoue(vehicule);
            }
        }
        if (devis.getClient().isClientFidele()) {
            devis.setMontantReduction(20);
        }
        System.out.println("Voulez-vous souscrire à une assurance ? Tapez O pour oui et N pour non");
        String choixAssurance = scanner.nextLine();
        if (choixAssurance.equals('O')) {
            devis.setAssurance(true);
        }
        System.out.println("Veuillez indiquer la date de début de location, au format année/mois/jour :");
        String dateDebut = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDateDebut = LocalDate.parse(dateDebut, formatter);
        devis.setDateDebut(localDateDebut);
        System.out.println("Veuillez indiquer la durée de la location, en jours :");
        long duree = scanner.nextInt();
        devis.setDureeJours(duree);
        LocalDate dateFin = localDateDebut.plusDays(duree);
        devis.setDateFin(dateFin);
        adder.insertValue("bdd1.Devis", "client, vehiculeLoue, dateDebut, dateFin, dureeJours," +
                " montantReduction, assurance, prixFinal", "" + devis.getClient().getID() + ", " +
                devis.getVehiculeLoue().getID() + ", " + dateDebut + ", " + dateFin + ", " + duree);
    }

    //Changer les infos personnelles du client
    public void editClient() {
        EditValue editor = new EditValue();
        boolean edit = true;
        int choixEdit;
        String choixEdit2;
        Client clientAEditer = new Client();
        afficherClients();
        System.out.println("Indiquez l'ID du client à modifier :");
        choixEdit = scanner.nextInt();
        for (Client client : listeClients) {
            if (client.getID() == choixEdit) {
                clientAEditer = client.clone();
            }
        }
        while (edit) {
            System.out.println("Veuillez choisir l'info à éditer :");
            System.out.println("1 : Nom");
            System.out.println("2 : Prénom");
            System.out.println("3 : Email");
            System.out.println("4 : Rue");
            System.out.println("5 : Ville");
            System.out.println("6 : Code Postal");
            System.out.println("7 : Téléphone");
            System.out.println("8 : Programme de fidélité");
            choixEdit = scanner.nextInt();
            scanner.nextLine();
            switch (choixEdit) {
                case 1:
                    System.out.println("Veuillez entrer un nom :");
                    choixEdit2 = scanner.nextLine();
                    clientAEditer.setNom(choixEdit2);
                    for (Client client : listeClients) {
                        if (client.getID() == clientAEditer.getID()) {
                            client.setNom(choixEdit2);
                        }
                    }
                    editor.updateValues("clients", "nom", choixEdit2, "client_id=" + clientAEditer.getID());
                    break;
                case 2:
                    System.out.println("Veuillez entrer un prénom :");
                    choixEdit2 = scanner.nextLine();
                    clientAEditer.setPrenom(choixEdit2);
                    for (Client client : listeClients) {
                        if (client.getID() == clientAEditer.getID()) {
                            client.setPrenom(choixEdit2);
                        }
                    }
                    editor.updateValues("clients", "prenom", choixEdit2, "client_id=" + clientAEditer.getID());
                    break;
                case 3:
                    System.out.println("Veuillez entrer un email :");
                    choixEdit2 = scanner.nextLine();
                    clientAEditer.setEmail(choixEdit2);
                    for (Client client : listeClients) {
                        if (client.getID() == clientAEditer.getID()) {
                            client.setEmail(choixEdit2);
                        }
                    }
                    editor.updateValues("clients", "email", choixEdit2, "client_id=" + clientAEditer.getID());
                    break;
                case 4:
                    System.out.println("Veuillez entrer une rue :");
                    choixEdit2 = scanner.nextLine();
                    clientAEditer.setRue(choixEdit2);
                    for (Client client : listeClients) {
                        if (client.getID() == clientAEditer.getID()) {
                            client.setRue(choixEdit2);
                        }
                    }
                    editor.updateValues("clients", "rue", choixEdit2, "client_id=" + clientAEditer.getID());
                    break;
                case 5:
                    System.out.println("Veuillez entrer une ville :");
                    choixEdit2 = scanner.nextLine();
                    clientAEditer.setVille(choixEdit2);
                    for (Client client : listeClients) {
                        if (client.getID() == clientAEditer.getID()) {
                            client.setVille(choixEdit2);
                        }
                    }
                    editor.updateValues("clients", "ville", choixEdit2, "client_id=" + clientAEditer.getID());
                    break;
                case 6:
                    System.out.println("Veuillez entrer un code postal :");
                    choixEdit2 = scanner.nextLine();
                    clientAEditer.setCodePostal(choixEdit2);
                    for (Client client : listeClients) {
                        if (client.getID() == clientAEditer.getID()) {
                            client.setCodePostal(choixEdit2);
                        }
                    }
                    editor.updateValues("clients", "codepostal", choixEdit2, "client_id=" + clientAEditer.getID());
                    break;
                case 7:
                    System.out.println("Veuillez entrer un numéro de téléphone :");
                    choixEdit2 = scanner.nextLine();
                    clientAEditer.setTelephone(choixEdit2);
                    for (Client client : listeClients) {
                        if (client.getID() == clientAEditer.getID()) {
                            client.setTelephone(choixEdit2);
                        }
                    }
                    editor.updateValues("clients", "telephone", choixEdit2, "client_id=" + clientAEditer.getID());
                    break;
                case 8:
                    System.out.println("Veuillez indiquer le statut du programme de fidélité : 0 si aucun programme n'est suivi, 1 si un programme est suivi :");
                    choixEdit = scanner.nextInt();
                    if (choixEdit == 0) {
                        clientAEditer.setClientFidele(false);
                        for (Client client : listeClients) {
                            if (client.getID() == clientAEditer.getID()) {
                                client.setClientFidele(false);
                            }
                        }
                        editor.updateValues("clients", "clientfidele", "'false'", "client_id=" + clientAEditer.getID());
                    } else if (choixEdit == 1) {
                        clientAEditer.setClientFidele(true);
                        for (Client client : listeClients) {
                            if (client.getID() == clientAEditer.getID()) {
                                client.setClientFidele(true);
                            }
                        }
                        editor.updateValues("clients", "clientfidele", "'true'", "client_id=" + clientAEditer.getID());

                    }
                    break;
                default:
                    break;
            }
            System.out.println("Voulez-vous modifier une autre info ? O pour Oui, N pour Non");
            choixEdit2 = scanner.nextLine();
            if (choixEdit2.equals("N") || choixEdit2.equals("n")) {
                edit = false;
            }
        }
        System.out.println("Fin de l'édition");
    }

    //Ajouter un client dans la BDD
    public void addClient() {
        InsertValue adder = new InsertValue();
        int choixEdit;
        String choixEdit2;
        Client clientAAjouter = new Client();
        System.out.println("Entrez le nom: ");
        choixEdit2 = scanner.nextLine();
        clientAAjouter.setNom(choixEdit2);
        System.out.println("Entrez le prénom: ");
        choixEdit2 = scanner.nextLine();
        clientAAjouter.setPrenom(choixEdit2);
        System.out.println("Entrez l'email: ");
        choixEdit2 = scanner.nextLine();
        clientAAjouter.setEmail(choixEdit2);
        System.out.println("Entrez la rue: ");
        choixEdit2 = scanner.nextLine();
        clientAAjouter.setRue(choixEdit2);
        System.out.println("Entrez la ville: ");
        choixEdit2 = scanner.nextLine();
        clientAAjouter.setVille(choixEdit2);
        System.out.println("Entrez le code Postal: ");
        choixEdit2 = scanner.nextLine();
        clientAAjouter.setCodePostal(choixEdit2);
        System.out.println("Entrez le numéro de téléphone: ");
        choixEdit2 = scanner.nextLine();
        clientAAjouter.setTelephone(choixEdit2);
        System.out.println("Entrez 1 si le client a souscris à un programme de fidélité, 0 sinon: ");
        choixEdit = scanner.nextInt();
        while (choixEdit != 1 && choixEdit != 0) {
            System.out.println("Veuillez entrer une valeur valide");
            choixEdit = scanner.nextInt();
        }
        String query = "";
        if (choixEdit == 1) {
            clientAAjouter.setClientFidele(true);
            listeClients.add(clientAAjouter);
            query = "INSERT INTO bdd1.clients (nom, prenom, email, rue, ville, codepostal, telephone, clientfidele," +
                    " datedebutfidele, datefinfidele, programmesuivi) VALUES (" + clientAAjouter.getNom() + "," +
                    " " + clientAAjouter.getPrenom() + ", " + clientAAjouter.getEmail() + ", " + clientAAjouter.getRue() + "," +
                    " " + clientAAjouter.getVille() + ", " + clientAAjouter.getCodePostal() + ", " + clientAAjouter.getTelephone()
                    + ", true, null, null, null";
        } else if (choixEdit == 0) {
            clientAAjouter.setClientFidele(false);
            listeClients.add(clientAAjouter);
            query = "INSERT INTO bdd1.clients (nom, prenom, email, rue, ville, codepostal, telephone, clientfidele," +
                    " datedebutfidele, datefinfidele, programmesuivi) VALUES (" + clientAAjouter.getNom() + "," +
                    " " + clientAAjouter.getPrenom() + ", " + clientAAjouter.getEmail() + ", " + clientAAjouter.getRue() + "," +
                    " " + clientAAjouter.getVille() + ", " + clientAAjouter.getCodePostal() + ", " + clientAAjouter.getTelephone()
                    + ", false, null, null, null)";

        }
        System.out.println("Query : " + query);
        adder.insertValueQuery(query);
    }

    public void addEmploye() {
        InsertValue adder = new InsertValue();
        int choixEdit;
        String choixEdit2;
        Employe nouvelEmploye = new Employe();
        System.out.println("Entrez le nom: ");
        choixEdit2 = scanner.nextLine();
        nouvelEmploye.setNom(choixEdit2);
        System.out.println("Entrez le prénom: ");
        choixEdit2 = scanner.nextLine();
        nouvelEmploye.setPrenom(choixEdit2);
        System.out.println("Entrez l'email: ");
        choixEdit2 = scanner.nextLine();
        nouvelEmploye.setEmail(choixEdit2);
        System.out.println("Entrez la rue: ");
        choixEdit2 = scanner.nextLine();
        nouvelEmploye.setRue(choixEdit2);
        System.out.println("Entrez la ville: ");
        choixEdit2 = scanner.nextLine();
        nouvelEmploye.setVille(choixEdit2);
        System.out.println("Entrez le code Postal: ");
        choixEdit2 = scanner.nextLine();
        nouvelEmploye.setCodePostal(choixEdit2);
        System.out.println("Entrez le numéro de téléphone: ");
        choixEdit2 = scanner.nextLine();
        nouvelEmploye.setTelephone(choixEdit2);
        System.out.println("Entrez le login qui sera utilisé pour vous connecter: ");
        choixEdit2 = scanner.nextLine();
        nouvelEmploye.setLogin(choixEdit2);
        System.out.println("Entrez le mot de passe associé à votre login: ");
        choixEdit2 = scanner.nextLine();
        nouvelEmploye.setPassword(choixEdit2);
        System.out.println("L'employé est-il chauffeur ? 1 pour Oui, 2 pour Non: ");
        choixEdit = scanner.nextInt();
        if (choixEdit == 1){
            nouvelEmploye.setEstChauffeur(true);
        } else {
            nouvelEmploye.setEstChauffeur(false);
        }
        System.out.println("Entrez le numéro de téléphone: ");
        choixEdit2 = scanner.nextLine();
        nouvelEmploye.setTelephone(choixEdit2);
    }

    //Supprimer un client de la BDD
    public void deleteClient() {
        DeleteValue eraser = new DeleteValue();
        int choixEdit;
        afficherClients();
        System.out.println("Selectionnez l'ID du client à supprimer");
        choixEdit = scanner.nextInt();
        for (Client client : listeClients) {
            if (choixEdit == client.getID()) {
                listeClients.remove(client);
                eraser.deleteValue("Clients", "client_ID" + client.getID());
            }
        }
    }

    //Ajouter un véhicule dans la BDD
    public void addVehicule() {
        InsertValue adder = new InsertValue();
        int choixEdit;
        String choixEdit2;
        Vehicule vehiculeAAjouter = new Vehicule();
        System.out.println("Entrez la marque: ");
        choixEdit2 = scanner.nextLine();
        vehiculeAAjouter.setMarque(choixEdit2);
        System.out.println("Entrez le modèle: ");
        choixEdit2 = scanner.nextLine();
        vehiculeAAjouter.setModele(choixEdit2);
        System.out.println("Entrez le kilometrage: ");
        choixEdit = scanner.nextInt();
        vehiculeAAjouter.setKilometrage(choixEdit);

        System.out.println("Entrez 1 si Boite auto, 0 sinon: ");
        choixEdit = scanner.nextInt();
        while (choixEdit != 1 || choixEdit != 0) {
            System.out.println("Veuillez entrer une valeur valide");
            choixEdit = scanner.nextInt();
        }
        if (choixEdit == 1) {
            vehiculeAAjouter.setBoiteAuto(true);
        } else if (choixEdit == 0) {
            vehiculeAAjouter.setBoiteAuto(false);
        }

        System.out.println("Entrez 1 si Climatisation, 0 sinon: ");
        choixEdit = scanner.nextInt();
        while (choixEdit != 1 || choixEdit != 0) {
            System.out.println("Veuillez entrer une valeur valide");
            choixEdit = scanner.nextInt();
        }
        if (choixEdit == 1) {
            vehiculeAAjouter.setClimatisation(true);
        } else if (choixEdit == 0) {
            vehiculeAAjouter.setClimatisation(false);
        }

        System.out.println("Sélectionnez l'ID de la catégorie du vehicule");
        afficherCategories();
        choixEdit = scanner.nextInt();
        while (choixEdit != 1|| choixEdit != 2 || choixEdit != 3){
            System.out.println("Veuillez entrer une valeur valide");
            choixEdit = scanner.nextInt();
        }
        if (choixEdit == 1){
            for(Categorie categorie : listeCategories){
                if(choixEdit == categorie.getID()){
                    vehiculeAAjouter.setCategorie(categorie);
                }
            }
        }
        else if (choixEdit == 2){
            for(Categorie categorie : listeCategories){
                if(choixEdit == categorie.getID()){
                    vehiculeAAjouter.setCategorie(categorie);
                }
            }
        }
        else if (choixEdit == 3){
            for(Categorie categorie : listeCategories){
                if(choixEdit == categorie.getID()){
                    vehiculeAAjouter.setCategorie(categorie);
                }
            }
        }

        System.out.println("Sélectionnez l'ID du carburant du vehicule");
        afficherCarburants();
        choixEdit = scanner.nextInt();
        while (choixEdit != 1|| choixEdit != 2 || choixEdit != 3){
            System.out.println("Veuillez entrer une valeur valide");
            choixEdit2 = scanner.nextLine();
        }
        if (choixEdit == 1){
            for(Carburant carburant : listeCarburants){
                if(choixEdit == carburant.getID()){
                    vehiculeAAjouter.setCarburant(carburant);
                }
            }
        }
        else if (choixEdit == 2){
            for(Carburant carburant : listeCarburants){
                if(choixEdit == carburant.getID()){
                    vehiculeAAjouter.setCarburant(carburant);
                }
            }
        }
        else if (choixEdit == 3){
            for(Carburant carburant : listeCarburants){
                if(choixEdit == carburant.getID()){
                    vehiculeAAjouter.setCarburant(carburant);
                }
            }
        }

        vehiculeAAjouter.setEstLoue(false);
        vehiculeAAjouter.setaDeplacer(false);

        String query = "";
        listeVehicules.add(vehiculeAAjouter);
        query = "INSERT INTO bdd1.Vehicules (marque, modele, kilometrage, boiteAuto, climatisation, estLoue, aDeplacer, carburant, categorie," +
                " agenceActuelle, clientActuel, nouvelleAgence) VALUES (" + vehiculeAAjouter.getMarque() + "," +
                " " + vehiculeAAjouter.getModele() + ", " + vehiculeAAjouter.getKilometrage() + ", " + vehiculeAAjouter.isBoiteAuto() + "," +
                " " + vehiculeAAjouter.isClimatisation() + ", " + vehiculeAAjouter.getCategorie() + ", " + vehiculeAAjouter.getCarburant()
                + ", true)";

        System.out.println("Query : " + query);
        adder.insertValueQuery(query);
    }

    //Editer les informations du véhicule
    public void editVehicule() {
        EditValue editor = new EditValue();
        boolean edit = true;
        int choixEdit;
        String choixEdit2;
        Vehicule vehiculeAEditer = new Vehicule();
        afficherVehicules();
        System.out.println("Indiquez l'ID du vehicule à modifier :");
        choixEdit = scanner.nextInt();
        for (Vehicule vehicule : listeVehicules) {
            if (vehicule.getID() == choixEdit) {
                vehiculeAEditer = vehicule.clone();
            }
        }
        while (edit) {
            System.out.println("Veuillez choisir l'info à éditer :");
            System.out.println("1 : Marque");
            System.out.println("2 : Modele");
            System.out.println("3 : Kilometrage");
            System.out.println("4 : BoiteAuto");
            System.out.println("5 : Climatisation");
            System.out.println("6 : Categorie");
            System.out.println("7 : Carburant");
            choixEdit = scanner.nextInt();
            switch (choixEdit) {
                case 1:
                    System.out.println("Veuillez entrer une marque :");
                    choixEdit2 = scanner.nextLine();
                    vehiculeAEditer.setMarque(choixEdit2);
                    for (Vehicule vehicule : listeVehicules) {
                        if (vehicule.getID() == vehiculeAEditer.getID()) {
                            vehicule.setMarque(choixEdit2);
                        }
                    }
                    editor.updateValues("Vehicules", "marque", choixEdit2, "vehicule_ID=" + vehiculeAEditer.getID());
                    break;
                case 2:
                    System.out.println("Veuillez entrer un modele :");
                    choixEdit2 = scanner.nextLine();
                    vehiculeAEditer.setModele(choixEdit2);
                    for (Vehicule vehicule : listeVehicules) {
                        if (vehicule.getID() == vehiculeAEditer.getID()) {
                            vehicule.setModele(choixEdit2);
                        }
                    }
                    editor.updateValues("Vehicules", "modele", choixEdit2, "vehicule_ID=" + vehiculeAEditer.getID());
                    break;
                case 3:
                    System.out.println("Veuillez entrer un kilometrage :");
                    choixEdit = scanner.nextInt();
                    vehiculeAEditer.setKilometrage(choixEdit);
                    for (Vehicule vehicule : listeVehicules) {
                        if (vehicule.getID() == vehiculeAEditer.getID()) {
                            vehicule.setKilometrage(choixEdit);
                        }
                    }
                    editor.updateValuesInt("Vehicules", "kilometrage", choixEdit, "vehicule_ID=" + vehiculeAEditer.getID());
                    break;
                case 4:
                    System.out.println("Veuillez indiquer s'il y'a une boite auto : 0 si non, 1 si oui :");
                    choixEdit = scanner.nextInt();
                    if (choixEdit == 0) {
                        vehiculeAEditer.setBoiteAuto(false);
                        for (Vehicule vehicule : listeVehicules) {
                            if (vehicule.getID() == vehiculeAEditer.getID()) {
                                vehicule.setBoiteAuto(false);
                            }
                        }
                        editor.updateValues("Vehicules", "boiteAuto", "false", "vehicule_ID=" + vehiculeAEditer.getID());
                    } else if (choixEdit == 1) {
                        vehiculeAEditer.setBoiteAuto(true);
                        for (Vehicule vehicule : listeVehicules) {
                            if (vehicule.getID() == vehiculeAEditer.getID()) {
                                vehicule.setBoiteAuto(true);
                            }
                        }
                        editor.updateValues("Vehicules", "boiteAuto", "true", "vehicule_ID=" + vehiculeAEditer.getID());
                    }
                    break;
                case 5:
                    System.out.println("Veuillez indiquer s'il y'a une Climatisation : 0 si non, 1 si oui :");
                    choixEdit = scanner.nextInt();
                    if (choixEdit == 0) {
                        vehiculeAEditer.setClimatisation(false);
                        for (Vehicule vehicule : listeVehicules) {
                            if (vehicule.getID() == vehiculeAEditer.getID()) {
                                vehicule.setClimatisation(false);
                            }
                        }
                        editor.updateValues("Vehicules", "climatisation", "false", "vehicule_ID=" + vehiculeAEditer.getID());
                    } else if (choixEdit == 1) {
                        vehiculeAEditer.setClimatisation(true);
                        for (Vehicule vehicule : listeVehicules) {
                            if (vehicule.getID() == vehiculeAEditer.getID()) {
                                vehicule.setClimatisation(true);
                            }
                        }
                        editor.updateValues("Vehicules", "climatisation", "true", "vehicule_ID=" + vehiculeAEditer.getID());
                    }
                    break;
                case 6:
                    System.out.println("Veuillez entrer l'ID de la catégorie :");
                    afficherCategories();
                    choixEdit = scanner.nextInt();
                    if (choixEdit == 1){
                        for(Categorie categorie : listeCategories){
                            if(choixEdit == categorie.getID()){
                                vehiculeAEditer.setCategorie(categorie);
                            }
                        }
                        for (Vehicule vehicule : listeVehicules) {
                            if (vehicule.getID() == vehiculeAEditer.getID()) {
                                vehicule.setCategorie(vehiculeAEditer.getCategorie());
                            }
                        }
                        editor.updateValuesInt("Vehicules", "categorie", choixEdit, "vehicule_ID=" + vehiculeAEditer.getID());
                    }
                    else if (choixEdit == 2){
                        for(Categorie categorie : listeCategories){
                            if(choixEdit == categorie.getID()){
                                vehiculeAEditer.setCategorie(categorie);
                            }
                        }
                        for (Vehicule vehicule : listeVehicules) {
                            if (vehicule.getID() == vehiculeAEditer.getID()) {
                                vehicule.setCategorie(vehiculeAEditer.getCategorie());
                            }
                        }
                        editor.updateValuesInt("Vehicules", "categorie", choixEdit, "vehicule_ID=" + vehiculeAEditer.getID());
                    }
                    else if (choixEdit == 3){
                        for(Categorie categorie : listeCategories){
                            if(choixEdit == categorie.getID()){
                                vehiculeAEditer.setCategorie(categorie);
                            }
                        }
                        for (Vehicule vehicule : listeVehicules) {
                            if (vehicule.getID() == vehiculeAEditer.getID()) {
                                vehicule.setCategorie(vehiculeAEditer.getCategorie());
                            }
                        }
                        editor.updateValuesInt("Vehicules", "categorie", choixEdit, "vehicule_ID=" + vehiculeAEditer.getID());
                    }
                    break;
                case 7:
                    System.out.println("Veuillez entrer l'ID du carburant :");
                    afficherCarburants();
                    choixEdit = scanner.nextInt();
                    if (choixEdit == 1){
                        for(Carburant carburant : listeCarburants){
                            if(choixEdit == carburant.getID()){
                                vehiculeAEditer.setCarburant(carburant);
                            }
                        }
                        for (Vehicule vehicule : listeVehicules) {
                            if (vehicule.getID() == vehiculeAEditer.getID()) {
                                vehicule.setCarburant(vehiculeAEditer.getCarburant());
                            }
                        }
                        editor.updateValuesInt("Vehicules", "carburant", choixEdit, "vehicule_ID=" + vehiculeAEditer.getID());
                    }
                    else if (choixEdit == 2){
                        for(Carburant carburant : listeCarburants){
                            if(choixEdit == carburant.getID()){
                                vehiculeAEditer.setCarburant(carburant);
                            }
                        }
                        for (Vehicule vehicule : listeVehicules) {
                            if (vehicule.getID() == vehiculeAEditer.getID()) {
                                vehicule.setCarburant(vehiculeAEditer.getCarburant());
                            }
                        }
                        editor.updateValuesInt("Vehicules", "carburant", choixEdit, "vehicule_ID=" + vehiculeAEditer.getID());
                    }
                    else if (choixEdit == 3){
                        for(Carburant carburant : listeCarburants){
                            if(choixEdit == carburant.getID()){
                                vehiculeAEditer.setCarburant(carburant);
                            }
                        }
                        for (Vehicule vehicule : listeVehicules) {
                            if (vehicule.getID() == vehiculeAEditer.getID()) {
                                vehicule.setCarburant(vehiculeAEditer.getCarburant());
                            }
                        }
                        editor.updateValuesInt("Vehicules", "carburant", choixEdit, "vehicule_ID=" + vehiculeAEditer.getID());
                    }
                    break;
                default:
                    break;
            }
            System.out.println("Voulez-vous modifier une autre info ? O pour Oui, N pour Non");
            choixEdit2 = scanner.nextLine();
            if (choixEdit2.equals("N") || choixEdit2.equals("n")) {
                edit = false;
            }
        }
    }

    //Supprimer un véhicule de la BDD
    public void deleteVehicule() {
        DeleteValue eraser = new DeleteValue();
        int choixEdit;
        afficherVehicules();
        System.out.println("Selectionnez l'ID du vehicule à supprimer");
        choixEdit = scanner.nextInt();
        for (Vehicule vehicule : listeVehicules) {
            if (choixEdit == vehicule.getID()) {
                listeVehicules.remove(vehicule);
                eraser.deleteValue("Vehicules", "vehicule_ID" + vehicule.getID());
            }
        }
    }

    public void connectEmploye() {
        String login = "", mdp = "";
        System.out.println("Veuillez rentrer votre login :");
        login = scanner.nextLine();
        System.out.println("Veuillez rentrer votre mot de passe :");
        mdp = scanner.nextLine();
        String query = "SELECT * FROM bdd1.Employes WHERE login='" + login + "' AND password='" + mdp + "'";
        System.out.println("Query : " + query);
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        ConnectDB obj_ConnectDB = new ConnectDB();
        connection = obj_ConnectDB.get_Connection();

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            System.out.println("Query executed");
            if (rs.next()) {
                Employe employe = new Employe();
                employe.setNom(rs.getString("nom"));
                employe.setPrenom(rs.getString("prenom"));
                employe.setEmail(rs.getString("email"));
                employe.setRue(rs.getString("rue"));
                employe.setVille(rs.getString("ville"));
                employe.setCodePostal(rs.getString("codePostal"));
                employe.setTelephone(rs.getString("telephone"));
                employe.setLogin(rs.getString("login"));
                employe.setPassword(rs.getString("password"));
                employe.setEstChauffeur(rs.getBoolean("estChauffeur"));
                userConnected = true;
                user = employe.clone();
            } else {
                throw new BadInputException("Ces identifiants ne figurent pas dans la base de données. Connexion échouée");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (BadInputException bie) {
            bie.printStackTrace();
        }
    }

    public void rendreVehicule(){
        int choixRetour;
        System.out.println("Selectionnez l'ID du véhicule retourné");
        choixRetour = scanner.nextInt();
        for(Vehicule vehicule : listeVehicules){
            if(choixRetour == vehicule.getID()){
                if(vehicule.getPleins()==0){
                    for(Devis devis : listeDevis){
                        if(devis.getVehiculeLoue().equals(vehicule)){
                            devis.setPrixFinal(devis.getPrixFinal() + 10);
                        }
                    }
                }
                else if (vehicule.getPleins() == 25){
                    for(Devis devis : listeDevis){
                        if(devis.getVehiculeLoue().equals(vehicule)){
                            devis.setPrixFinal(devis.getPrixFinal() + 20);
                        }
                    }
                }
                else if(vehicule.getPleins() == 50){
                    for(Devis devis : listeDevis){
                        if(devis.getVehiculeLoue().equals(vehicule)){
                            devis.setPrixFinal(devis.getPrixFinal() + 30);
                        }
                    }
                }
                else if(vehicule.getPleins() == 75){
                    for(Devis devis : listeDevis){
                        if(devis.getVehiculeLoue().equals(vehicule)){
                            devis.setPrixFinal(devis.getPrixFinal() + 40);
                        }
                    }
                }
            }
        }

        for(Vehicule vehicule : listeVehicules){
            if (choixRetour == vehicule.getID()){
                for (Devis devis : listeDevis){
                    if (devis.getVehiculeLoue().equals(vehicule)){
                        if(vehicule.isEndommage() && !devis.isAssurance()){
                            devis.setPrixFinal(devis.getPrixFinal() + 500);
                        }
                    }

                }
            }
        }



    }

    public void loadData() {
        System.out.println("Chargement des programmes");
        loadProgrammes();
        System.out.println("Chargement terminé");
        System.out.println("Chargement des clients");
        loadClients();
        System.out.println("Chargement terminé");
        System.out.println("Chargement des carburants");
        loadCarburant();
        System.out.println("Chargement terminé");
        System.out.println("Chargement des catégories");
        loadCategories();
        System.out.println("Chargement terminé");
        System.out.println("Chargement des agences");
        loadAgences();
        System.out.println("Chargement terminé");
        System.out.println("Chargement des employés");
        loadEmployes();
        System.out.println("Chargement terminé");
        System.out.println("Chargement des véhicules");
        loadVehicules();
        System.out.println("Chargement terminé");
        System.out.println("Chargement des devis");
        loadDevis();
        System.out.println("Chargement terminé");
    }

    public void loadEmployes() {
        Vector<Employe> listeEmployes;
        ReadValue reader = new ReadValue();
        listeEmployes = reader.readEmployes("SELECT * FROM bdd1.Employes");
        this.listeEmployes = (Vector) listeEmployes.clone();

    }

    public void loadClients(){
        Vector<Client> listeClients;
        ReadValue reader = new ReadValue();
        listeClients = reader.readClient("SELECT * FROM bdd1.Clients");
        this.listeClients = (Vector) listeClients.clone();
    }

    // WIP
    public void loadVehicules(){
        Vector<Vehicule> listeVehicules;
        ReadValue reader = new ReadValue();
        listeVehicules = reader.readVehicules("SELECT * FROM bdd1.Vehicules");
        this.listeVehicules = (Vector) listeVehicules.clone();
    }

    public void loadAgences(){
        Vector<Agence> listeAgences;
        ReadValue reader = new ReadValue();
        listeAgences = reader.readAgences("SELECT * FROM bdd1.Agences");
        this.listeAgences = (Vector) listeAgences.clone();
    }

    public void loadCarburant(){
        Vector<Carburant> listeCarburants;
        ReadValue reader = new ReadValue();
        listeCarburants = reader.readCarburants("SELECT * FROM bdd1.Carburants");
        this.listeCarburants = (Vector) listeCarburants.clone();
    }

    public void loadProgrammes(){
        Vector<ProgrammeFidelite> listeProgrammes;
        ReadValue reader = new ReadValue();
        listeProgrammes = reader.readProgrammes("SELECT * FROM bdd1.ProgrammesFidelite");
        this.listeProgrammesFidelite = (Vector) listeProgrammes.clone();
        System.out.println(this.listeProgrammesFidelite);
    }

    public void loadCategories() {
        Vector<Categorie> listeCategories;
        ReadValue reader = new ReadValue();
        listeCategories = reader.readCategories("SELECT * FROM bdd1.Categories");
        this.listeCategories = (Vector) listeCategories.clone();
    }

    public void loadDevis() {
        Vector<Devis> listeDevis;
        ReadValue reader = new ReadValue();
        listeDevis = reader.readDevis("SELECT * FROM bdd1.Devis");
        this.listeDevis = (Vector) listeDevis.clone();
    }

    public static void main(String[] args) {
        Magasin magasin = new Magasin();
        int choixUser = 0, choixUser2 = 0, choixUser3 = 0;
        System.out.println("Bienvenue");
        magasin.loadData();
        System.out.println("Connectez-vous pour continuer en appuyant sur 1, ou créez un nouvel employé en appuyant sur 2 : ");
        choixUser = scanner.nextInt();
        ScannerUtils.skip();
        if (choixUser == 1){
            magasin.connectEmploye();
        } else if (choixUser == 2){

        }
        while (magasin.userConnected) {
            System.out.println("Que voulez-vous faire ?");
            System.out.println("1 : Gestion des clients");
            System.out.println("2 : Gestion des véhicules");
            System.out.println("3 : Création d'un devis");
            System.out.println("4 : Gestion des Employes");
            choixUser = scanner.nextInt();
            switch (choixUser) {
                case 1:
                    System.out.println("1 : Ajouter un nouveau client");
                    System.out.println("2 : Modifier un client existant");
                    System.out.println("3 : Supprimer un client existant");
                    choixUser2 = scanner.nextInt();
                    switch (choixUser2) {
                        case 1:
                            magasin.addClient();
                            break;
                        case 2:
                            magasin.editClient();
                            break;
                        case 3:
                            magasin.deleteClient();
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1 : Ajouter un nouveau véhicule");
                    System.out.println("2 : Modifier un véhicule existant");
                    System.out.println("3 : Supprimer un véhicule existant");
                    choixUser2 = scanner.nextInt();
                    switch (choixUser2) {
                        case 1:
                            magasin.addVehicule();
                            break;
                        case 2:
                            magasin.editVehicule();
                            break;
                        case 3:
                            magasin.deleteVehicule();
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    magasin.creerDevis();
                    break;
                case 4:
                    //TODO
                    break;
                default:
                    break;
            }
            System.out.println("Voulez-vous continuer ou vous déconnecter ?");
            System.out.println("1 pour continuer, 2 pour arrêter");
            System.out.println("choixUser = " + choixUser + ", choixUser2 = " + choixUser2 + ", choixUser3 = " + choixUser3);

            while (choixUser3 != 1 && choixUser3 != 2){
                choixUser3 = scanner.nextInt();
                if (choixUser3 != 1 && choixUser3 != 2){
                    System.out.println("Veuillez entrer un nombre valide");
                }
            }
            if (choixUser3 == 2){
                magasin.userConnected = false;
            } else { }
        }
        System.out.println("Au revoir.");
    }
}
