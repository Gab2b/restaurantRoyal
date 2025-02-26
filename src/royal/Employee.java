package royal;

public class Employee {

    //
    // ATTRIBUTS
    //

    private int id;
    private String lastName;
    private String firstName;
    private String role;
    private String hireDate;
    private double salary;

    //
    // CONSTRUCTEUR
    //

    public Employee(int id, String lastName, String firstName, String role, String hireDate, double salary) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.role = role;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    //
    // GETTERS
    //

    public int getIdEmployee() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getRole() {
        return role;
    }

    public String getHireDate() {
        return hireDate;
    }

    public double getSalary() {
        return salary;
    }

    //
    // SETTERS
    //

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //
    // METHODES
    //

    public String toString() {
        return String.format("Employee #%s, Last name : %s, First name : %s, Role : %s, Salary : %s Hire date : %s", id, lastName, firstName, role, salary, hireDate);
    }
}