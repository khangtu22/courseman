package courseman2.models;

/**
 *
 * @author Khang
 */
public class ElectiveModule extends Module {
    private String faculty;

    public ElectiveModule(String faculty) {
        this.faculty = faculty;
    }

    public ElectiveModule(String name, int semester, int credits, String faculty) {
        super(name, semester, credits);
        this.faculty = faculty;
    }

    public ElectiveModule() {
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ElectiveModule{");
        sb.append("faculty='").append(faculty).append('\'');
        sb.append('}');
        return sb.toString() +" "+ super.toString();
    }

}
