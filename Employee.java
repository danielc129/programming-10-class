public class Employee extends Person{

    private int salary;
    public Employee(String firstName, String lastName) {
        super(firstName, lastName);
        this.salary = 10000;
    }

    public int getSalary() {
        return salary;
    }

}
