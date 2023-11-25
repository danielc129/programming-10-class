public class Teacher extends Employee{
    public Teacher(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public int getSalary() {
        return super.getSalary() + 2000;
    }
}
