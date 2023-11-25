
public class EmployeeDriver {

    public static void main(String[] args) {
        Principal principal = new Principal("John", "Tejsialksczetr");
        Teacher teacher = new Teacher("Ave", "Lam");
        Superintendent superintendent = new Superintendent("Jerry", "Ulprtazukhocrhoczs");

        System.out.println(principal.getFirstName() + " " + principal.getLastName() + ": " + principal.getSalary());

    }
}