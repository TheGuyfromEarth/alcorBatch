import com.sun.jdi.ObjectCollectedException;

import java.util.Collections;
import java.util.PriorityQueue;

public class PQ {

    public static void main(String[] args) {

//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//
//        pq.add(10);
//        pq.add(20);
//        pq.add(15);
//        pq.add(5);
//        pq.add(18);

//        System.out.println(pq.peek());
//        pq.poll();
//        System.out.println(pq.peek());


//        PriorityQueue<String> pq1 = new PriorityQueue<>(Collections.reverseOrder());
//
//        pq1.add("Apple");
//        pq1.add("Orange");
//        pq1.add("Grapes");
//        pq1.add("Pineapple");
//
//        System.out.println(pq1.peek());
//        pq1.poll();
//        System.out.println(pq1.peek());

        PriorityQueue<Employee> pqEmployee = new PriorityQueue<>(new EmployeeComparator());
        pqEmployee.add(new Employee("Ravi",101));
        pqEmployee.add(new Employee("Kelly",111));
        pqEmployee.add(new Employee("Harpreet",105));
        pqEmployee.add(new Employee("Jason",120));
        pqEmployee.add(new Employee("Emily",115));

        System.out.println(pqEmployee.peek());
        pqEmployee.poll();
        System.out.println(pqEmployee.peek());


    }
}
