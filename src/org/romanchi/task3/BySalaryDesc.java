package org.romanchi.task3;

import java.util.Comparator;

public class BySalaryDesc implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if(o1.calculateSalary() < o2.calculateSalary()){
            return 1;
        }else if(o1.calculateSalary() > o2.calculateSalary()){
            return -1;
        }else{
            return 0;
        }
    }
}
