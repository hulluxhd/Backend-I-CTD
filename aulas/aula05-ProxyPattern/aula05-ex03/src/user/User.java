package user;

public class User {
    static int id = 0;
    private String userType = "Free";


    public User() {
        defineID();
    }

    public void defineID(){
        this.id++;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void downloadMusic() {
        System.out.println("A música está sendo baixada.");
    }
}
