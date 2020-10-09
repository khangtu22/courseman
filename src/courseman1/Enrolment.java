package courseman1;

//import utils.AttrRef;
//import utils.DOpt;
//import utils.DomainConstraint;
//import utils.OptType;

/**
 * @overview Enrolment is a enrolment which implement comparable to create an enrolment.
 *
 * @object A typical Module is <s,m,i,e,f>
 * where id(i), name(n), dob(d), address(a), email(e)
 *
 * @attributes
 * s Student
 * m module
 * i internalMark
 * e examinationMark
 * f finalGrade
 *
 * @abstract_properties
 *
 * @rep_invariant
 *
 */
public class Enrolment implements Comparable<Enrolment>{

    //Constant
    enum Grade {
        E, G, P, F;
    }
    // Representation
//    @DomainConstraint(type="Student",mutable=false, optional=false)
    private Student student;
//    @DomainConstraint(type="Module",mutable=false, optional=false)
    private Module module;
//    @DomainConstraint(type="Float",mutable=false, optional=false)
    private float internalMark;
//    @DomainConstraint(type="Float",mutable=false, optional=false)
    private float examinationMark;
//    @DomainConstraint(type="Grate",mutable=false, optional=false)
    private Grade finalGrade = Grade.F;

    // Constructor method
    /**
     * @effects <pre>
     *           Create a new Enrolment<>
     *           </pre>
     */
//    @DOpt(type = OptType.Constructor)
    public Enrolment() {

    }

    // Constructor method
    /**
     * @effects <pre>
     *           Create a new Enrolment<s,m>
     *           </pre>
     */
//    @DOpt(type = OptType.Constructor)
    public Enrolment(Student student, Module module) {
        this.student = student;
        this.module = module;
    }

    // Constructor method
    /**
     * @effects <pre>
     *           Create a new Enrolment<s,m,i,e>
     *           </pre>
     */
//    @DOpt(type = OptType.Constructor)
    public Enrolment(Student student, Module module, float internalMark, float examinationMark) {
        this.student = student;
        this.module = module;
        this.internalMark = internalMark;
        this.examinationMark = examinationMark;
    }

    // methods
    /**
     * @effects return <tt>this.id</tt>
     */
//    @DOpt(type=OptType.Observer) @AttrRef("student")
    public Student getStudent() {
        return student;
    }
    /**
     * @effects <pre>
     *             set this.student = student
     *          </pre>
     */
//    @DOpt(type=OptType.Mutator) @AttrRef("student")
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * @effects return <tt>this.id</tt>
     */
//    @DOpt(type=OptType.Observer) @AttrRef("module")
    public Module getModule() {
        return module;
    }

    /**
     * @effects <pre>
     *             set this.module = module
     *          </pre>
     */
//    @DOpt(type=OptType.Mutator) @AttrRef("module")
    public void setModule(Module module) {
        this.module = module;
    }

    /**
     * @effects return <tt>this.internalMark</tt>
     */
//    @DOpt(type=OptType.Observer) @AttrRef("internalMark")
    public float getInternalMark() {
        return internalMark;
    }

    /**
     * @effects <pre>
     *             set this.internalMark = internalMark
     *          </pre>
     */
//    @DOpt(type=OptType.Mutator) @AttrRef("internalMark")
    public void setInternalMark(float internalMark) {
        this.internalMark = internalMark;
        setFinalGrade(this.internalMark, this.examinationMark);
    }

    /**
     * @effects return <tt>this.examinationMark</tt>
     */
//    @DOpt(type=OptType.Observer) @AttrRef("examinationMark")
    public float getExaminationMark() {
        return examinationMark;
    }

    /**
     * @effects <pre>
     *             set this.examinationMark = examinationMark
     *          </pre>
     */
//    @DOpt(type=OptType.Mutator) @AttrRef("examinationMark")
    public void setExaminationMark(float examinationMark) {
        this.examinationMark = examinationMark;
        setFinalGrade(this.internalMark, this.examinationMark);
    }

    /**
     * @effects return <tt>this.finalGrade</tt>
     */
//    @DOpt(type=OptType.Observer) @AttrRef("finalGrade")
    public Grade getFinalGrade() {
        return finalGrade;
    }

    /**
     * @effects <pre>
     *             set this.finalGrade = finalGrade
     *          </pre>
     */
//    @DOpt(type=OptType.Mutator) @AttrRef("finalGrade")
    public void setFinalGrade(double internalMark1, double examinationMark1) {
        double a = internalMark * 0.4 + examinationMark * 0.6;
        if (a >= 9) {
            this.finalGrade = Grade.E;
        } else if (a >= 7) {
            this.finalGrade = Grade.G;
        } else if (a >= 5) {
            this.finalGrade = Grade.P;
        } else {
            this.finalGrade = Grade.F;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Enrolment{");
        sb.append("student=").append(student.getName());
        sb.append(", module=").append(module.getCode());
        sb.append(", internalMark=").append(internalMark);
        sb.append(", examinationMark=").append(examinationMark);
        sb.append(", finalGrade='").append(finalGrade).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Enrolment o) {
        return this.student.compareTo(o.getStudent());
    }
}
