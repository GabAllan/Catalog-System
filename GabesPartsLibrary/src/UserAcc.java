public class UserAcc {
    private String userName;
    private String password;
    private String fullName;
    private boolean isAdmin;

    public UserAcc() {
    }

    public UserAcc(String userName, String password, String fullName, boolean isAdmin) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.isAdmin = isAdmin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
