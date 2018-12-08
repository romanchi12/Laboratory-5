package org.romanchi.task3;

public class FixedHourEmployee extends Employee {

    public FixedHourEmployee(String name, double fixedSalary){
        super(name, fixedSalary);
        salary = fixedSalary;
    }
    @Override
    public double calculateSalary() {
        return salary;
    }
}
