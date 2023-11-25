public class Principal extends Employee{
    public Principal(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public int getSalary() {
        return super.getSalary() + 20000;
    }
}
