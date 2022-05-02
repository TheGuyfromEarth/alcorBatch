import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee employee, Employee employee1) {
            return employee.getEmpId() - employee1.getEmpId();
    }
}
