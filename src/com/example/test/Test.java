package com.example.test;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

/*Inheritance Constructor super() and this()
super() --- By Default in each Constructor

If Parent method is not declared (throws) with any Checked Exception,
then subclass overriden Method CANNOT declare any Checked exception

Subclass overridden method MUST declare same or sub Exception only. Cannot not declare Parent Exception.
* */
class A {
    int a;

    public A() {
        System.out.println("In A");
    }

    public A(int a) {
        this.a = a;
        System.out.println("In Para A");
    }

    public void show() throws RuntimeException, Exception {
        System.out.println("In Show A");
    }
}

class B extends A {
    int b;
    String bs;

    public B() {
        System.out.println("In B");
    }

    public B(int b) {
        this.b = b;
        System.out.println("In Para B");
    }

    public B(int b, String bs) {
        this();
        this.b = b;
        this.bs = bs;
        System.out.println("In Para B");

    }

    @Override
    public void show() throws FileNotFoundException {
            System.out.println("In Show B");
    }
}
class C extends B{
    int c;

    public C() {
        System.out.println("In C");
    }

    public C(int c) {
        super(c);
        this.c = c;
        System.out.println("In Para C");
    }

    public C(int b, String bs, int c) {
        super(b, bs);
        this.c = c;
    }

    @Override
    public void show(){
        System.out.println("In Show C");
    }
}

public class Test {

    public static void main(String[] args) {

       /*C obj1 = new C(2);*/
       /*C a = new C();
       a.show();*/






            /*Thread Questions*/

        /*int[] a = {1 ,2 , 9, 5 ,3 , 7 , 6};

        Thread t1 = new Thread(() -> {
            for(int i = 1 ; i <= 10 ; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hello Thread1 " + i);
            }

        });

        Thread t2 = new Thread(() -> {
            for(int i = 1 ; i <= 10 ; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hello Thread2 " + i);
            }
        });


        t1.start();
        t1.join();
        t2.start();*/



                    /*Stream Questions */


        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(101 , "Siva" , 101 , "active" , 2000));
        employeeList.add(new Employee(102 , "Punit" , 101 , "active" , 5000));
        employeeList.add(new Employee(104 , "Anand" , 102 , "inactive" , 6000));
        employeeList.add(new Employee(103 , "Vineet" , 102 , "inactive" , 3000));
        employeeList.add(new Employee(107 , "Sumit" , 104 , "active" , 12000));
        employeeList.add(new Employee(106 , "Pinu" , 103 , "active" , 7000));

        Map<Integer, Employee> listToMap = employeeList.stream().collect(Collectors.toMap(Employee::getEmpId, employee -> employee));
        System.out.println(listToMap);

        Map<String, Integer> map = new HashMap<>();
        map.put("Abc" , 123);
        map.put("Pqr" , 876);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();

        List<Map.Entry<String, Integer>> mapList = new ArrayList<>(entries);
        mapList.forEach(System.out::println);


        // Print Employee Details Based on Department
        /*Map<Integer, List<Employee>> groupDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.toList()));

        groupDept.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + "-----" + entry.getValue());
        });*/

        // Print Employee count working on each Department

        /*Map<Integer, Long> empCount = employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.counting()));
        empCount.entrySet().forEach(entry ->{
            System.out.println("Dept : " + entry.getKey() + " Number of Employees : " + entry.getValue());
        });*/

//        Print Active and Inactive Employee

        /*long activeCount = employeeList.stream().filter(employee -> employee.getStatus().equals("active")).count();
        System.out.println("Active Employees Count : " + activeCount);

        long inactiveCount = employeeList.stream().filter(employee -> employee.getStatus().equals("inactive")).count();
        System.out.println("Inactive Employees Count : " + inactiveCount);*/

//        Max and Min Employee Salary

        /*Optional<Employee> maxSalary = employeeList.stream().max((o1, o2) -> o1.getSalary() - o2.getSalary());
        System.out.println(maxSalary.get().getEmpName() + " Has max salary " + maxSalary.get().getSalary());

        Optional<Employee> minSalary = employeeList.stream().min(Comparator.comparing(Employee::getSalary));
        System.out.println(minSalary.get().getEmpName() + " Has min salary " + minSalary.get().getSalary());*/

//        Print Max Salary of an Employee from Each Dept

        /*Map<Integer, Optional<Employee>> maxSalaryForDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))));
        maxSalaryForDept.entrySet().forEach( entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue().get());
        });*/

        /*Sort Employee Based on Some Parameter*/
        /*employeeList.stream().sorted((o1 , o2) -> o1.getEmpName().compareTo(o2.getEmpName()) ).forEach(System.out::println);*/


    }

}
