package projet;

import connect_db.EditValue;
import connect_db.InsertValue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Magasin {
    private List<Client> listeClients;
    private List<Employe> listeEmployes;
    private List<Vehicule> listeVehicules;
    private List<Agence> listeAgences;
    private List<ProgrammeFidelite> listeProgrammesFidelite;
    private List<Vehicule> listeLocations;
    private List<Categorie> listeCategorie;
    private List<Carburant> listeCarburants;
    private Client connectedClient;

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
        if (choixCategorie.equals("eco")) {
            for (Vehicule vehicule : listeVehicules) {
                if (vehicule.getCategorie().getNom().equals("eco")) {
                    vehiculeCategorie = vehicule.toString();
                    System.out.println(vehiculeCategorie);
                }
            }
        } else if (choixCategorie.equals("confort")) {
            for (Vehicule vehicule : listeVehicules) {
                if (vehicule.getCategorie().getNom().equals("confort")) {
                    vehiculeCategorie = vehicule.toString();
                    System.out.println(vehiculeCategorie);
                }
            }
        } else if (choixCategorie.equals("luxe")) {
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
                //TODO EmptyListException
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
                        editor.updateValues("Clients", "clientFidele", "false", "client_ID=" + clientAEditer.getID());
                    } else if (choixEdit == 1) {
                        clientAEditer.setClientFidele(true);
                        for (Client client : listeClients) {
                            if (client.getID() == clientAEditer.getID()) {
                                client.setClientFidele(true);
                            }
                        }
                        editor.updateValues("Clients", "clientFidele", "true", "client_ID=" + clientAEditer.getID());
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
}
