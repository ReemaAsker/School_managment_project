
package school_managment_project;

public class Assistant {

    static int idCnt;
    int id;
    String name = "";
    String password = "";
    String email = "";
    String contactNo = "";

    public Assistant(String name, String password, String email, String contactNo) {
        this.id = ++idCnt;
        this.name = name;
        this.password = password;
        this.email = email;
        this.contactNo = contactNo;
    }

}
