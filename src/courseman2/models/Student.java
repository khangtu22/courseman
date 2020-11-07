package courseman2.models;
import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.OptType;

import java.io.Serializable;

import java.lang.annotation.Annotation;

/**
 * @overview Student is a person with attributes such as id, name,
 * dob, address, email.
 *
 * @object A typical Student is <i,n,d,a,e>
 * where id(i), name(n), dob(d), address(a), email(e)
 *
 * @attributes
 * id          Integer
 * name        String
 * dob         String
 * address     String
 * email       String
 *
 * @abstract_properties
 * mutable(id) = false /\ optional(id) = false /\ min(id) = 1 /\ max(if) = 10^9
 *
 * @rep_invariant
 *
 */
public class Student implements Serializable {
    private static final long serialVersionUID = -6500665823330706018L;


    // Constants
    private static int no_students = 2020;

    // Representation
    @DomainConstraint(type="Integer",mutable=false, optional=false)
    private String id;
    @DomainConstraint(type="String", mutable=true, optional=false, length=50)
    private String name;
    @DomainConstraint(type="String", mutable=true, optional=false, length=10)
    private String dob;
    @DomainConstraint(type="String", mutable=true, optional=false, length=100)
    private String address;
    @DomainConstraint(type="String", mutable=true, optional=false, length=100)
    private String email;

    // Constructor method
    /**
     * @effects <pre>
     *           Create a new Student<>
     *           </pre>
     */
    @DOpt(type = OptType.Constructor)
    public Student() {
        this.id = "S" + no_students;
        no_students++;
    }

    /**
     * @effects <pre>
     *              initialise this as Student<i,n,d,a,e>
     *              id is automatically increase when a student is created
     *           </pre>
     */
    @DOpt(type = OptType.Constructor)
    public Student(String name, String dob, String address, String email) {
        super();
        this.id = "S" + no_students;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.email = email;
        no_students++;
    }


    // methods
    /**
     * @effects return <tt>this.id</tt>
     */
    @DOpt(type=OptType.Observer) @AttrRef("id")
    public String getId() {
        return id;
    }

    /**
     * @effects <pre>
     *             set this.id = id
     *          </pre>
     */
    @DOpt(type=OptType.Mutator) @AttrRef("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @effects return <tt>this.name</tt>
     */
    @DOpt(type=OptType.Observer) @AttrRef("name")
    public String getName() {
        return name;
    }

    /**
     * @effects <pre>
     *            if name is valid
     *              set this.name = name
     *            else
     *              throws NotPossibleException</pre>
     */
    @DOpt(type=OptType.Mutator) @AttrRef("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @effects return <tt>this.dob</tt>
     */
    @DOpt(type=OptType.Observer) @AttrRef("dob")
    public String getDob() {
        return dob;
    }

    /**
     * @effects <pre>
     *            if dob is valid
     *              set this.dob = dob
     *            else
     *              throws NotPossibleException</pre>
     */
    @DOpt(type=OptType.Mutator) @AttrRef("dob")
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @effects return <tt>this.address</tt>
     */
    @DOpt(type=OptType.Observer) @AttrRef("address")
    public String getAddress() {
        return address;
    }

    /**
     * @effects <pre>
     *            if address is valid
     *              set this.address = address
     *            else
     *              throws NotPossibleException</pre>
     */
    @DOpt(type=OptType.Mutator) @AttrRef("address")
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @effects return <tt>this.email</tt>
     */
    public String getEmail() {
        return email;
    }

    /**
     * @effects <pre>
     *            if email is valid
     *              set this.email = email
     *            else
     *              throws NotPossibleException</pre>
     */
    public void setEmail(String email) {
        this.email = email;
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



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", dob=").append(dob);
        sb.append(", address='").append(address).append('\'');
        sb.append(", email='").append(email).append('\'');
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
}
