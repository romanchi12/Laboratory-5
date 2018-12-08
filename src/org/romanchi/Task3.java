package org.romanchi;

import org.romanchi.task3.*;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Task3 implements Task{

    @Override
    public void execute() {
        Comparator employeeComparator = new BySalaryDesc().thenComparing(new ByNameAsc());

        TreeSet<Employee> employees = new TreeSet<>(employeeComparator);
        System.out.println("a)");
        employees.add(new FixedHourEmployee("Roman", 12000));
        employees.add(new FixedHourEmployee("Dmitro", 12000));
        employees.add(new FixedHourEmployee("Anton", 10000));
        employees.add(new NotFixedHourEmployee("Kolya", 60));
        employees.add(new NotFixedHourEmployee("Kolya", 65));
        employees.add(new FixedHourEmployee("Katya", 13000));
        employees.add(new NotFixedHourEmployee("Oleg", 70));

        employees.forEach(employee -> {
            System.out.println(employee);
        });
        System.out.println("b)");
        employees.stream().limit(5).forEach(employee -> {
            System.out.println(employee.getName());
        });
        System.out.println("c)");
        Iterator<Employee> descendingIterator = employees.descendingIterator();
        int count = 0;
        while(count < 3 && descendingIterator.hasNext()){
            System.out.println(descendingIterator.next().getId());
            count++;
        }
        EmployeeReader employeeReader = new EmployeeReader(new File("employeelist.txt"));
        Employee tempEmployee;
        while((tempEmployee = employeeReader.next())!=null){
            System.out.println(tempEmployee);
        }
        EmployeeWriter employeeWriter = new EmployeeWriter(new File("employeelist.txt"));
        employees.forEach((employee -> {
            employeeWriter.write(employee);
        }));
        try {
            employeeWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
