package courseman1;

import java.util.Vector;

public class EnrolmentManager extends Enrolment{

    private final Vector<Enrolment> enrolments = new Vector<Enrolment>();
    private static final EnrolmentManager instance = new EnrolmentManager();

    private EnrolmentManager() {
    }

    // singleton pattern
    public static EnrolmentManager getInstance() {
        return instance;
    }

    /**
     * A method that implements addEnrolment to enrol student in the course
     *
     * @effects add the enrolment to vector
     *
     */
    public void addEnrolment(Student student, Module module) {
        Enrolment enrolment = new Enrolment(student, module);
        if (checkExist(student,module) ) {
            System.out.println("Existed: Not added.");
        }else {
            enrolments.add(enrolment);
        }
    }

    /**
     * A method that implements getEnrolment to show the if the student is enrol in specific course (module).
     *
     * @effects return the model
     *
     * @return Object
     */
    public Enrolment getEnrolment(Student student, Module module) {
        for(Enrolment model : enrolments) {
            if (student.getName().equals(model.getStudent().getName()) && module.getCode().equals(model.getModule().getCode()))
            {
                return model;
            }
        }
        return null;
    }


    /**
     * A method that implements CheckExist to show see if student is enrol in specific course.
     *
     * @effects return true or false
     *
     * @return Boolean
     */
    public boolean checkExist(Student student, Module module) {
        for(Enrolment model : enrolments) {
            if (student.getName().equals(model.getStudent().getName()) && module.getCode().equals(model.getModule().getCode()))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * A method that implements setMark method to setMark for specific student.
     *
     * @param student for Student Object
     *
     *                @param module for Module Object
     *  @param internalMark for to set internal mark for student
     *               @param examinationMark for to set exam mark for student
     * @requires  s, m, i and e Not null
     * @effects if student is exist then add mark. Else student is not enrol in the course.
     *
     */
    public void setMarks(Student student, Module module, double internalMark, double examinationMark){
        Enrolment enrol =  getEnrolment(student, module);
        if (checkExist(student,module)){
            System.out.println("You just update the "+ student.getName() +"'s mark.");
            enrol.setInternalMark((float) internalMark);
            enrol.setExaminationMark((float) examinationMark);
        }else {
            System.out.println("This student not yet enrol the course yet!");
        }

    }

    /**
     * A method that implements report to show the information not include mark
     *
     * @effects iterate throw vector then print out all element in vector.
     *
     * @return String
     */
    public String report(){
        StringBuilder sb = new StringBuilder();
        for (courseman1.Enrolment en : enrolments) {
            sb.append("[").append(en.getStudent().toString()).append(en.getModule().toString()).append("]");
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * A method that implements report assessment to show the information include mark
     *
     * @effects iterate throw vector then print out all element in vector add to string builder.
     *
     * @return toString
     */
    public String reportAssessment(){
        final StringBuilder sb = new StringBuilder("Module{");
        for (Enrolment en : enrolments) {
            sb.append("[").append(en.getStudent().toString()).append(en.getModule().toString()).append("]");
            sb.append("Enrolment [internalMark=").append(en.getInternalMark()).append(", examinationMark=")
                    .append(en.getExaminationMark()).append(", finalGrade=").append(en.getFinalGrade()).append("]");
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * A method to sort for the index of a given element of a sorted array.
     *
     * @requires  enrolments is not empty
     * @effects   enrolment will sort.
     */
    public void sort(){
        Arrays.quickSort(enrolments);
    }
}
