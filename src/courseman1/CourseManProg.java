package courseman1;


public class CourseManProg {

    public static void main(String[] args) {

        Student s1 = new Student();
        s1.setName("John1");
        s1.setDob("29/12/1999");
        s1.setEmail("vankhang@gmail.com");
        s1.setAddress("HN1");

        Student s2 = new Student();
        s2.setName("John2");
        s2.setDob("29/12/1999");
        s2.setEmail("vankhang2@gmail.com");
        s2.setAddress("HN2");

        Student s3 = new Student();
        s3.setName("John3");
        s3.setDob("29/12/1999");
        s3.setEmail("vankhang3@gmail.com");
        s3.setAddress("HN3");


        Student s4 = new Student();
        s4.setName("John4");
        s4.setDob("29/12/1999");
        s4.setEmail("vankhang4@gmail.com");
        s4.setAddress("HN4");

        Student s5 = new Student();
        s5.setName("John5");
        s5.setDob("29/12/1999");
        s5.setEmail("vankhang5@gmail.com");
        s5.setAddress("HN5");

        CompulsoryModule m1 = new CompulsoryModule();
        m1.setName("SQA1");
        m1.setCredits(2);
        m1.setSemester(1);

        CompulsoryModule m2 = new CompulsoryModule();
        m2.setName("SQA2");
        m2.setCredits(3);
        m2.setSemester(1);

        CompulsoryModule m3 = new CompulsoryModule();
        m3.setName("SQA3");
        m3.setCredits(4);
        m3.setSemester(2);

        ElectiveModule m4 = new ElectiveModule();
        m4.setFaculty("F1");
        m4.setName("SQA4");
        m4.setCredits(4);
        m4.setSemester(2);

        ElectiveModule m5 = new ElectiveModule();
        m5.setFaculty("F1");
        m5.setName("SQA3");
        m5.setCredits(4);
        m5.setSemester(2);


        EnrolmentManager enr = EnrolmentManager.getInstance();
        enr.addEnrolment(s1, m1);
        enr.addEnrolment(s2, m2);
        enr.addEnrolment(s2, m1);
        enr.addEnrolment(s5, m3);
        enr.addEnrolment(s4, m1);
        enr.addEnrolment(s1, m4);
        enr.addEnrolment(s5, m1);
        enr.addEnrolment(s3, m5);
        enr.addEnrolment(s5, m2);
        enr.addEnrolment(s2, m3);
        System.out.println(enr.report());
        enr.sort();
        System.out.println("");
        System.out.println("Sorted Below: ");
        System.out.println(enr.report());
        System.out.println("");

        enr.setMarks(s1,m1, 4.0,8.6);
        enr.setMarks(s2,m2, 3.0,6.6);
        enr.setMarks(s2,m1, 5.0,4.6);
        enr.setMarks(s5,m3, 8.0,9.6);
        enr.setMarks(s4,m1, 4.0,8.6);

        System.out.println("");
        System.out.println("Report Assessment: ");
        System.out.println(enr.reportAssessment());
    }
}
