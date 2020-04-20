package hw6.composite;


public class Users {
    private String indexUser;
    private String nameUser;
    private String description;

    public void setIndexUser(String indexUser) {
        this.indexUser = indexUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Users(String indexUser, String nameUser, String description) {
        this.indexUser = indexUser;
        this.nameUser = nameUser;
        this.description = description;
    }

    public String getIndexUser() {
        return indexUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return indexUser +" "+nameUser+" "+description;

    }


}
