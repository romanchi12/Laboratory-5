package org.romanchi.task3;

public class NotFixedHourEmployee extends Employee {
    double rate;

    public NotFixedHourEmployee(String name, double rate){
        super(name, -1);
        this.rate = rate;
        salary = calculateSalary();
    }
    @Override
    public double calculateSalary() {
        salary = 20.8 * 8 * rate;
        return salary;
    }
}
