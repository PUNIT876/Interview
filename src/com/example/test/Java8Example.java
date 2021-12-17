package com.example.test;

import java.util.*;
import java.util.stream.Collectors;

public class Java8Example {

    public static void main(String[] args) {

        int[] arr = {2 , 3, 5, 1, 7 , 1 , 3 , 7};
        OptionalInt sum = Arrays.stream(arr).max();
        /*System.out.println(sum.getAsInt());*/


        // Find 3 distinct smallest numbers
        Arrays.stream(arr)
                .distinct()
                .sorted()
                .limit(3)
                .forEach(System.out::println);

        List<Integer> integerList = Arrays.asList(1, 5, 6, 3, 9);
        /*integerList.stream().sorted(((o1, o2) -> o2 - o1)).forEach(System.out::println);*/

        long count = integerList.stream().count();
        /*System.out.println(count);*/

        Optional<Integer> max = integerList.stream().max((o1, o2) -> o1 - o2);
        /*System.out.println(max.get());*/

        Optional<Integer> first = integerList.stream().findFirst();
        Optional<Integer> any = integerList.stream().findAny();

        /*System.out.println("First : " + first.get() + " Any : " + any.get());*/

        Integer reduceSum = integerList.stream().reduce(0, (o1, o2) -> o1 + o2);
        /*System.out.println(reduceSum);*/

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(101 , "Siva" , 101 , "active" , 2000));
        employeeList.add(new Employee(102 , "Punit" , 101 , "active" , 5000));
        employeeList.add(new Employee(104 , "Anand" , 102 , "inactive" , 6000));
        employeeList.add(new Employee(103 , "Vineet" , 102 , "inactive" , 3000));
        employeeList.add(new Employee(107 , "Sumit" , 104 , "active" , 12000));
        employeeList.add(new Employee(106 , "Pinu" , 103 , "active" , 7000));


        // Convert to Map
        Map<Integer, List<Employee>> employeeMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.toList()));
        /*employeeMap.forEach((integer, employees) -> {System.out.print(integer + "----->");
        System.out.println(employees);});*/
        employeeMap.entrySet().forEach(entry -> System.out.println( entry.getKey() + " ----> " + entry.getValue() ));

        Map<Integer, Employee> empMap = employeeList.stream().collect(Collectors.toMap(employee -> employee.getEmpId(), employee -> employee));

        // Print Employee count working on each Department
        Map<Integer, Long> deptCount = employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.counting()));
        deptCount.entrySet().forEach(entry -> System.out.println( entry.getKey() + " ----> " + entry.getValue() ));

        //        Print Active and Inactive Employee
        employeeList.stream().filter( employee -> employee.getStatus().equals("inactive") ).forEach(System.out::println);

        //        Max and Min Employee Salary
        Optional<Employee> maxSalary = employeeList.stream().max((o1, o2) -> o1.getSalary() - o2.getSalary());
        System.out.println(maxSalary.get());

        //        Print Max Salary of an Employee from Each Dept
        Map<Integer, Optional<Employee>> deptMaxSalary = employeeList.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.maxBy((o1, o2) -> o1.getSalary() - o2.getSalary())));
        deptMaxSalary.entrySet().forEach( entry -> System.out.println(entry.getKey() + " ---> " + entry.getValue().get().getEmpName()));

        /*Sort Employee Based on Some Parameter*/
        employeeList.stream().sorted((o1, o2) -> o1.getEmpName().compareTo(o2.getEmpName())).forEach(System.out::println
        );


    }
}
