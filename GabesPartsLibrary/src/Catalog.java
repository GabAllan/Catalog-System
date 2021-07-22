import java.util.ArrayList;

public class Catalog {
    private ArrayList<UserAcc> userAccounts = new ArrayList<UserAcc>();
    ArrayList<Engine> engines = new ArrayList<Engine>();

    public Catalog() {
    }

    public Catalog(ArrayList<UserAcc> userAccounts, ArrayList<Engine> engines) {
        this.userAccounts = userAccounts;
        this.engines = engines;
    }

    public ArrayList<UserAcc> getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(ArrayList<UserAcc> userAccounts) {
        this.userAccounts = userAccounts;
    }

    public ArrayList<Engine> getEngines() {
        return engines;
    }

    public void setEngines(ArrayList<Engine> engines) {
        this.engines = engines;
    }
}
