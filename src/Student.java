public class Student {
    //class fields or private data or instance variables of Student
    private String firstname, lastname;

    private int grade;

    private double gpa;

    /* Constructors are special methods of a class that
    help build an instance of that object when calling a new
    keyboard. Constructors have no return type and they are not
    designated with anything other than public ClassName.
     */

    /**
     * Parameterized constructor for class Student
     *
     * @param fn First name, a String
     * @param ln Last name, a String
     * @param gr Grade, an int
     * @param gp GPA, a double
     */
    public Student(String fn, String ln, int gr, double gp) {
        firstname = fn;
        lastname = ln;
        grade = gr;
        gpa = gp;
    }

    /**
     * Default constructor for class Student
     */
    public Student() {
        firstname = new String();
        lastname = new String();
        grade = 0;
        gpa = 0.;
    }

    //ACCESSOR METHODS

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getGrade() {
        return grade;
    }

    public double getGPA() {
        return gpa;
    }

    //MUTATOR METHODS
    public void setFirstname(String newFN) {
        firstname = newFN;
    }

    public void setLastname(String newLN) {
        lastname = newLN;
    }

    public void setGrade(int ngrade) {
        grade = ngrade;
    }

    public void setGPA(double ngpa) {
        gpa = ngpa;
    }
    public String toString(){
        return lastname + " " + firstname + " | Gr: " + grade + " | GPA: " + gpa;
    }
}