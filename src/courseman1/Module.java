package courseman1;

//import utils.AttrRef;
//import utils.DOpt;
//import utils.DomainConstraint;
//import utils.OptType;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @overview Module is module such as code, name, semester and credit
 *
 * @object A typical Module is <c,n,s,c>
 * where code(c), name(n), semester(s), credit(c)
 *
 * @attributes
 * code          String
 * name        String
 * semester        Integer
 * credit     Integer
 *
 */

public abstract class Module {

    // Representation
//    @DomainConstraint(type="String",mutable=false, optional=false)
    private String code;
//    @DomainConstraint(type="String")
    private String name;
//    @DomainConstraint(type="Integer")
    private int semester;
//    @DomainConstraint(type="Integer")
    private int credits;

    private static final AtomicInteger count1 = new AtomicInteger(0);
    private static final AtomicInteger count2 = new AtomicInteger(0);

    // Constructor method
    /**
     * @effects <pre>
     *           Create a new Module<>
     *           </pre>
     */
//    @DOpt(type = OptType.Constructor)
    public Module() {
    }

    /**
     * @effects <pre>
     *           Create a new Module<n,s,c>
     *               code is auto increment
     *           </pre>
     */
//    @DOpt(type = OptType.Constructor)
    public Module(String code, String name, int semester, int credits) {
        this.code = code;
        this.name = name;
        this.semester = semester;
        this.credits = credits;
    }

    /**
     * @effects <pre>
     *           Create a new Module<n,s,c>
     *               code is auto increment
     *           </pre>
     */
//    @DOpt(type = OptType.Constructor)
    public Module(String name, int semester, int credits) {
        this.name = name;
        this.semester = semester;
        this.credits = credits;
        if(this.semester == 1){
            this.code = "M" + (100 + count1.incrementAndGet());
        }else if(this.semester == 2){
            this.code = "M" + (200 + count2.incrementAndGet());
        }else{
            throw new NoSuchElementException("2 semesters only allow");
        }
    }

    // methods
    /**
     * @effects return <tt>this.code</tt>
     */
//    @DOpt(type=OptType.Observer) @AttrRef("code")
    public String getCode() {
        return code;
    }

    // methods
    /**
     * @effects return <tt>this.name</tt>
     */
//    @DOpt(type=OptType.Observer) @AttrRef("name")
    public String getName() {
        return name;
    }

    /**
     * @effects <pre>
     *             set this.name = name
     *          </pre>
     */
//    @DOpt(type=OptType.Mutator) @AttrRef("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @effects return <tt>this.semester</tt>
     */
//    @DOpt(type=OptType.Observer) @AttrRef("semester")
    public int getSemester() {
        return semester;
    }

    /**
     * @effects <pre>
     *             set this.semester = semester
     *          </pre>
     */
//    @DOpt(type=OptType.Mutator) @AttrRef("semester")
    public void setSemester(int semester) {
        this.semester = semester;
        if(this.semester == 1){
            this.code = "M" + (100 + count1.incrementAndGet());
        }else if(this.semester == 2){
            this.code = "M" + (200 + count2.incrementAndGet());
        }else{
            throw new NoSuchElementException("2 semesters only allow");
        }
    }

    /**
     * @effects return <tt>this.credits</tt>
     */
//    @DOpt(type=OptType.Observer) @AttrRef("credits")
    public int getCredits() {
        return credits;
    }

    /**
     * @effects <pre>
     *             set this.credits = credits
     *          </pre>
     */
//    @DOpt(type=OptType.Mutator) @AttrRef("credits")
    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Module{");
        sb.append("code='").append(code).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", semester=").append(semester);
        sb.append(", credits=").append(credits);
        sb.append('}');
        return sb.toString();
    }


    /**
     * @effects <pre>
     *            if o is null
     *              throw NullPointerException
     *            else if o is not a Customer object
     *              throw ClassCastException
     *            else
     *              return this.name.compareTo(o.name)
     *          </pre>
     */
    // interface
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Module)) return false;
        Module module = (Module) o;
        return getSemester() == module.getSemester() &&
                getCredits() == module.getCredits() &&
                getCode().equals(module.getCode()) &&
                getName().equals(module.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getName(), getSemester(), getCredits());
    }

    /**
     * @effects <pre>
     *            if this satisfies rep invariant
     *              return true
     *            else
     *              return false</pre>
     */
    public boolean repOK() {
        return true;
    }
}
