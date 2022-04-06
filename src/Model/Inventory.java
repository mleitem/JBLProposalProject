package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;

public class Inventory {


    protected static ObservableList<Client> allClients = FXCollections.observableArrayList();

    public static void addClient(Client newClient) { allClients.add(newClient); }

    public static ObservableList<Client> getAllClients() { return allClients;}

    public static void deleteClient(Client deleteClient) { allClients.remove(deleteClient);}

  /*  protected static ObservableList<Proposal> allProposals = FXCollections.observableArrayList();

    public static void addProposal(Proposal newProposal) { allProposals.add(newProposal); }

    public static ObservableList<Proposal> getAllProposals() { return allProposals;}

    public static void deleteProposal(Proposal deleteProposal) { allProposals.remove(deleteProposal);} */

    /** This method finds a client by the associated street address
     *
     * @param address string searched for within client addresses
     * @return client if there is a match
     */

    public static Client findClientByAddress(String address) {
        for(Client client : allClients) {
            if(client.getAddress().equals(address)) {
                return client;
            }
        }
        return null;
    }

    /** This method finds a client by the associated name
     *
     * @param name string searched for within client names
     * @return client if there is a match
     */

    public static Client findClientByName(String name) {
        for(Client client : allClients) {
            if(client.getName().equals(name)) {
                return client;
            }
        }
        return null;
    }

    /** This method finds a client by the associated phone number
     *
     * @param phone string searched for within client phone numbers
     * @return client if there is a match
     */

    public static Client findClientByPhone(String phone) {
        for(Client client : allClients) {
            if(client.getPhoneNumber().equals(phone)) {
                return client;
            }
        }
        return null;
    }

    /** This method finds a client by the associated street address
     *
     * @param email string searched for within client addresses
     * @return client if there is a match
     */

    public static Client findClientByEmail(String email) {
        for(Client client : allClients) {
            if(client.getEmailAddress().equals(email)) {
                return client;
            }
        }
        return null;
    }


    /** Searching functionality below**/



    /** This method adds proposals whose addresses contain the user input to the list
     * @param proposalAddress string searched for within proposal addresses
     * @return the list of proposals that have names that contain partialAddress
     */

   /* public static ObservableList<Proposal> lookupAddress(String proposalAddress) {
        ObservableList<Proposal> searchAddress = FXCollections.observableArrayList();
        ObservableList<Proposal> allProposals = Inventory.getAllProposals();

        for (Proposal proposal : allProposals) {
            if(proposal.getAddress().contains(proposalAddress)) {
                searchAddress.add(proposal);
            }
        }

        return searchAddress;
    } */

    /** This method adds proposals whose names contain the user input to the list
     * @param homeownerName string searched for within the names on the proposals
     * @return the list of proposals that have homeowners whose names contain partialName
     */

   /* public static ObservableList<Proposal> lookupName(String homeownerName) {
        ObservableList<Proposal> searchName = FXCollections.observableArrayList();
        ObservableList<Proposal> allProposals = FXCollections.observableArrayList();

        for (Proposal proposal : allProposals) {
            if(proposal.getName().contains(homeownerName)) {
                searchName.add(proposal);
            }
        }

        return searchName;
    } */

    /** This method adds proposals whose project type contains the user input to the list
     * @param projectType string searched for within the project types in the proposals
     * @return the list of proposals that have project types that match partialProject
     */

   /* public static ObservableList<Proposal> lookupProject(String projectType) {
        ObservableList<Proposal> searchProject = FXCollections.observableArrayList();
        ObservableList<Proposal> allProposals = FXCollections.observableArrayList();

        for (Proposal proposal : allProposals) {
            if (proposal.getName().contains(projectType)) {
                searchProject.add(proposal);
            }
        }

        return searchProject;
    } */
}
