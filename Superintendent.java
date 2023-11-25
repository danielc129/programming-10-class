public class Superintendent extends Employee{
    public Superintendent(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public int getSalary() {
        return super.getSalary() + 10000;
    }
}
