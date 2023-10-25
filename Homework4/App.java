import java.util.List;

public class App {

    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();

        directory.addEmployee(1, "1234567890", "John Doe", 5);
        directory.addEmployee(2, "9876543210", "Jane Smith", 10);

        List<Employee> foundByExperience = directory.findEmployeesByExperience(5);
        System.out.println("Employees with experience of 5 years:");
        for (Employee employee : foundByExperience) {
            System.out.println("Name: " + employee.getName());
            System.out.println("Phone Number: " + employee.getPhoneNumber());
            System.out.println("=================================");
        }

        List<String> phoneNumbers = directory.getPhoneNumberByName("Jane Smith");
        System.out.println("Phone Numbers of employees named Jane Smith:");
        for (String phoneNumber : phoneNumbers) {
            System.out.println(phoneNumber);
            System.out.println("==============================");
        }

        Employee foundById = directory.findEmployeeById(2);
        System.out.println("Employee found by ID 2:");
        if (foundById != null) {
            System.out.println("Name: " + foundById.getName());
            System.out.println("Phone Number: " + foundById.getPhoneNumber());
            System.out.println("Experience: " + foundById.getExperience());
        } else {
            System.out.println("Employee with ID 2 not found");
        }
    }
}
