
package school_managment_project;

import java.util.ArrayList;

public class DataStore {

    public static ArrayList<Assistant> assistants = new ArrayList<>();
    public static ArrayList<Student> students = new ArrayList<>();

    public static void updateRollNoAfterDeleteStd() {
        for (int i = 0; i < students.size(); ++i) {
            students.get(i).rollNo = --students.get(i).rollNo;
        }
    }

}
