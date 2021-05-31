package projet;

import connect_db.ConnectDB;
import connect_db.DeleteValue;
import connect_db.EditValue;
import connect_db.InsertValue;
import exceptions.BadInputException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class Magasin {
    private Vector<Client> listeClients;
    private Vector<Employe> listeEmployes;
    private Vector<Vehicule> listeVehicules;
    private Vector<Agence> listeAgences;
    private Vector<ProgrammeFidelite> listeProgrammesFidelite;
    private Vector<Vehicule> listeLocations;
    private Vector<Categorie> listeCategorie;
    private Vector<Carburant> listeCarburants;
    private Vector<Devis> listeDevis;
    private boolean userConnected;

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

    //Affichage des véhicules par catégorie
    public void afficherCategorie() {
        Scanner scanner = new Scanner(System.in);
        String affichCategorie;
        for (Categorie categorie : listeCategorie) {
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

        scanner.close();
    }

    //Affichage par marque de véhicule
    public void afficherMarque() {
        Scanner scanner = new Scanner(System.in);
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

        scanner.close();
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
        Scanner scanner = new Scanner(System.in);
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
        scanner.close();
    }

    //Renouveler un programme de fidélité
    public void renouvelerProgramme(Client client) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Voulez vous renouveler cet abonnement au programme fidélité ?");
        String choixClient = scanner.nextLine();
        //TODO BadUserInputException
        if (choixClient.equals("N")) {
            System.out.println("La souscription au programme fidélité est terminée.");
        } else if (choixClient.equals("Y")) {
            System.out.println("De combien d'années supplémentaires voulez vous souscrire ?");
            int duree = scanner1.nextInt();
            client.prolongerFidele(duree);
        }
        scanner.close();
        scanner1.close();
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
        Scanner scanner = new Scanner(System.in);
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
        adder.insertValue("Devis", "client, vehiculeLoue, dateDebut, dateFin, dureeJours," +
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
        Scanner scanner = new Scanner(System.in);
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
                    editor.updateValues("Clients", "nom", choixEdit2, "client_ID=" + clientAEditer.getID());
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
                    editor.updateValues("Clients", "prenom", choixEdit2, "client_ID=" + clientAEditer.getID());
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
                    editor.updateValues("Clients", "email", choixEdit2, "client_ID=" + clientAEditer.getID());
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
                    editor.updateValues("Clients", "rue", choixEdit2, "client_ID=" + clientAEditer.getID());
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
                    editor.updateValues("Clients", "ville", choixEdit2, "client_ID=" + clientAEditer.getID());
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
                    editor.updateValues("Clients", "codePostal", choixEdit2, "client_ID=" + clientAEditer.getID());
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
                    editor.updateValues("Clients", "telephone", choixEdit2, "client_ID=" + clientAEditer.getID());
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
                        editor.updateValues("Clients", "clientFidele", "'false'", "client_ID=" + clientAEditer.getID());
                    } else if (choixEdit == 1) {
                        clientAEditer.setClientFidele(true);
                        for (Client client : listeClients) {
                            if (client.getID() == clientAEditer.getID()) {
                                client.setClientFidele(true);
                            }
                        }
                        editor.updateValues("Clients", "clientFidele", "'true'", "client_ID=" + clientAEditer.getID());

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
        scanner.close();
        System.out.println("Fin de l'édition");
    }

    //Ajouter un client dans la BDD
    public void addClient() {
        InsertValue adder = new InsertValue();
        int choixEdit;
        String choixEdit2;
        Client clientAAjouter = new Client();
        Scanner scanner = new Scanner(System.in);
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
        while (choixEdit != 1 || choixEdit != 0) {
            System.out.println("Veuillez entrer une valeur valide");
            choixEdit = scanner.nextInt();
        }
        String query = "";
        if (choixEdit == 1) {
            clientAAjouter.setClientFidele(true);
            listeClients.add(clientAAjouter);
            query = "INSERT INTO bdd1.Clients (nom, prenom, email, rue, ville, codePostal, telephone, clientFidele," +
                    " dateDebutFidele, dateFinFidele, programmeSuivi) VALUES (" + clientAAjouter.getNom() + "," +
                    " " + clientAAjouter.getPrenom() + ", " + clientAAjouter.getEmail() + ", " + clientAAjouter.getRue() + "," +
                    " " + clientAAjouter.getVille() + ", " + clientAAjouter.getCodePostal() + ", " + clientAAjouter.getTelephone()
                    + ", true)";
        } else if (choixEdit == 0) {
            clientAAjouter.setClientFidele(false);
            listeClients.add(clientAAjouter);
            query = "INSERT INTO bdd1.Clients (nom, prenom, email, rue, ville, codePostal, telephone, clientFidele," +
                    " dateDebutFidele, dateFinFidele, programmeSuivi) VALUES (" + clientAAjouter.getNom() + "," +
                    " " + clientAAjouter.getPrenom() + ", " + clientAAjouter.getEmail() + ", " + clientAAjouter.getRue() + "," +
                    " " + clientAAjouter.getVille() + ", " + clientAAjouter.getCodePostal() + ", " + clientAAjouter.getTelephone()
                    + ", false)";

        }
        System.out.println("Query : " + query);
        adder.insertValueQuery(query);
        scanner.close();
    }

    //Supprimer un client de la BDD
    public void deleteClient() {
        DeleteValue eraser = new DeleteValue();
        int choixEdit;
        Scanner scanner = new Scanner(System.in);
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
        Scanner scanner = new Scanner(System.in);
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

        System.out.println("Sélectionnez la catégorie du vehicule");
        choixEdit2 = scanner.nextLine();
        while (!choixEdit2.equals("Luxe") || !choixEdit2.equals("Confort") || !choixEdit2.equals("Eco")) {
            System.out.println("Veuillez entrer une valeur valide");
            choixEdit2 = scanner.nextLine();
        }
        if (choixEdit2.equals("Luxe")) {
            vehiculeAAjouter.setCategorie("choixEdit2");
        } else if (choixEdit2.equals("Confort")) {
            vehiculeAAjouter.setCategorie("choixEdit2");
        } else if (choixEdit2.equals("Eco")) {
            vehiculeAAjouter.setCategorie("choixEdit2");
        }

        System.out.println("Sélectionnez le carburant du vehicule");
        choixEdit2 = scanner.nextLine();
        while (!choixEdit2.equals("SP98") || !choixEdit2.equals("SP95") || !choixEdit2.equals("Diesel")) {
            System.out.println("Veuillez entrer une valeur valide");
            choixEdit2 = scanner.nextLine();
        }
        if (choixEdit2.equals("SP98")) {
            vehiculeAAjouter.setCarburant("choixEdit2");
        } else if (choixEdit2.equals("SP95")) {
            vehiculeAAjouter.setCarburant("choixEdit2");
        } else if (choixEdit2.equals("Diesel")) {
            vehiculeAAjouter.setCarburant("choixEdit2");
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
        scanner.close();
    }

    //Editer les informations du véhicule
    public void editVehicule() {
        EditValue editor = new EditValue();
        boolean edit = true;
        int choixEdit;
        String choixEdit2;
        Vehicule vehiculeAEditer = new Vehicule();
        Scanner scanner = new Scanner(System.in);
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
                    editor.updateValues("Vehicules", "kilometrage", choixEdit, "vehicule_ID=" + vehiculeAEditer.getID());
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
                default:
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
                default:
                    break;
                case 6:
                    afficherCategorie();
                    System.out.println("Veuillez entrer une catégorie :");
                    choixEdit2 = scanner.nextLine();
                    if (choixEdit2.equals("Luxe")) {
                        vehiculeAEditer.setCategorieInt(choixEdit2);
                        for (Vehicule vehicule : listeVehicules) {
                            if (vehicule.getID() == vehiculeAEditer.getID()) {
                                vehicule.setCategorie(choixEdit2);
                            }
                        }
                        editor.updateValues("Vehicules", "categorie", choixEdit2, "vehicule_ID=" + vehiculeAEditer.getID());
                    } else if (choixEdit2.equals("Confort")) {
                        vehiculeAEditer.setCategorie(choixEdit2);
                        for (Vehicule vehicule : listeVehicules) {
                            if (vehicule.getID() == vehiculeAEditer.getID()) {
                                vehicule.setCategorie(choixEdit2);
                            }
                        }
                        editor.updateValues("Vehicules", "categorie", choixEdit2, "vehicule_ID=" + vehiculeAEditer.getID());
                    } else if (choixEdit2.equals("Eco")) {
                        vehiculeAEditer.setCategorie(choixEdit2);
                        for (Vehicule vehicule : listeVehicules) {
                            if (vehicule.getID() == vehiculeAEditer.getID()) {
                                vehicule.setCategorie(choixEdit2);
                            }
                        }
                        editor.updateValues("Vehicules", "categorie", choixEdit2, "vehicule_ID=" + vehiculeAEditer.getID());
                    }
                    break;
                default:
                    break;
                case 7:
                    System.out.println("Veuillez entrer le carburant :");
                    choixEdit2 = scanner.nextLine();
                    if (choixEdit2.equals("SP98")) {
                        vehiculeAEditer.setCategorie(choixEdit2);
                        for (Vehicule vehicule : listeVehicules) {
                            if (vehicule.getID() == vehiculeAEditer.getID()) {
                                vehicule.setCategorie(choixEdit2);
                            }
                        }
                        editor.updateValues("Vehicules", "carburant", choixEdit2, "vehicule_ID=" + vehiculeAEditer.getID());
                    } else if (choixEdit2.equals("SP95")) {
                        vehiculeAEditer.setCategorie(choixEdit2);
                        for (Vehicule vehicule : listeVehicules) {
                            if (vehicule.getID() == vehiculeAEditer.getID()) {
                                vehicule.setCategorie(choixEdit2);
                            }
                        }
                        editor.updateValues("Vehicules", "carburant", choixEdit2, "vehicule_ID=" + vehiculeAEditer.getID());
                    } else if (choixEdit2.equals("Diesel")) {
                        vehiculeAEditer.setCategorie(choixEdit2);
                        for (Vehicule vehicule : listeVehicules) {
                            if (vehicule.getID() == vehiculeAEditer.getID()) {
                                vehicule.setCategorie(choixEdit2);
                            }
                        }
                        editor.updateValues("Vehicules", "carburant", choixEdit2, "vehicule_ID=" + vehiculeAEditer.getID());
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
        Scanner scanner = new Scanner(System.in);
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
        Scanner scanner = new Scanner(System.in);
        String login = "", mdp = "";
        System.out.println("Veuillez rentrer votre login :");
        login = scanner.nextLine();
        System.out.println("Veuillez rentrer votre mot de passe :");
        mdp = scanner.nextLine();
        String query = "SELECT * FROM Employes WHERE login='" + login + "' AND password='" + mdp + "'";
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        ConnectDB obj_ConnectDB = new ConnectDB();
        connection = obj_ConnectDB.get_Connection();

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            if (rs != null) {
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
            } else {
                throw new BadInputException("Ces identifiants ne figurent pas dans la base de données. Connexion échouée");
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (BadInputException bie) {
            bie.printStackTrace();
        }
    }

    public void loadData() {
        loadEmployes();
        loadClients();
        loadVehicules();
        loadAgences();
        loadProgrammes();
        loadCategories();
        loadCarburants();
        loadDevis();
    }

    public void loadEmployes() {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        ConnectDB connectDB = new ConnectDB();
        connection = connectDB.get_Connection();
        Vector<Employe> listeEmployes = new Vector<>();

        try {
            while (rs.next()) {
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
                listeEmployes.add(employe);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        this.listeEmployes = (Vector) listeEmployes.clone();


    }

    public void loadClients(){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        ConnectDB connectDB = new ConnectDB();
        connection = connectDB.get_Connection();
        Vector<Client> listeClients = new Vector<>();

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()){
                Client client = new Client();
                client.setNom(rs.getString("nom"));
                client.setPrenom(rs.getString("prenom"));
                client.setEmail(rs.getString("email"));
                client.setRue(rs.getString("rue"));
                client.setVille(rs.getString("ville"));
                client.setCodePostal(rs.getString("codePostal"));
                client.setTelephone(rs.getString("telephone"));
                client.setClientFidele(rs.getBoolean("clientFidele");
                client.setDateDebutFidele(this.);
                listeClients.add(client);
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
        }
        this.listeClients = (Vector) listeClients.clone();
    }

    // WIP
    public void loadVehicules(){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        ConnectDB connectDB = new ConnectDB();
        connection = connectDB.get_Connection();
        Vector<Vehicule> listeVehicules = new Vector<>();

        try {
            while (rs.next()) {
                Vehicule vehicule = new Vehicule();
                vehicule.setNom(rs.getString("nom"));
                employe.setPrenom(rs.getString("prenom"));
                employe.setEmail(rs.getString("email"));
                employe.setRue(rs.getString("rue"));
                employe.setVille(rs.getString("ville"));
                employe.setCodePostal(rs.getString("codePostal"));
                employe.setTelephone(rs.getString("telephone"));
                employe.setLogin(rs.getString("login"));
                employe.setPassword(rs.getString("password"));
                employe.setEstChauffeur(rs.getBoolean("estChauffeur"));
                listeEmployes.add(employe);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        this.listeVehicules = (Vector) listeVehicules.clone();
    }

    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choixUser = 0, choixUser2 = 0;
        System.out.println("Bienvenue");
        System.out.println("Connectez-vous pour continuer :");
        connectEmploye();
        while (userConnected) {
            laodData();
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
                    System.out.println("3: Supprimer un client existant");
                    choixUser2 = scanner.nextInt();
                    switch (choixUser2) {
                        case 1:
                            addClient();
                            break;
                        case 2:
                            editClient();
                            break;
                        case 3:
                            deleteClient();
                            break;
                        case 4:

                    }
            }
        }

    }
}
