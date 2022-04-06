package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Client {

    protected static ObservableList<Proposal> associatedProposals = FXCollections.observableArrayList();
    protected String name;
    public String address;
    protected String phoneNumber;
    protected String emailAddress;

    public Client(String name, String address, String phoneNumber, String emailAddress) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public Client() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /** This method adds a new proposal to allProposals
     * @param newProposal added proposal
     */

    public static void addProposal(Proposal newProposal) { associatedProposals.add(newProposal); }

    /** This method gets a list of all proposals
     * @return a list of all proposals
     */

    public static ObservableList<Proposal> getAllProposals() { return associatedProposals;}

    /** This method deletes a proposal from the list of allProposals
     * @param deleteProposal the proposal to be deleted
     */

    public static void deleteProposal(Proposal deleteProposal) { associatedProposals.remove(deleteProposal);}


}
