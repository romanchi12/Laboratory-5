package org.romanchi.task3;

import java.io.*;
import java.util.Scanner;

public class EmployeeReader implements Closeable {
    Scanner scanner;
    String pattern = "[0-9]+ [a-zA-z ]+ [a-zA-z]* ?[0-9]+.?[0-9]*";
    public EmployeeReader(File file){
        try {
            scanner = new Scanner(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Employee next(){
        if(!scanner.hasNextLine()){
            return null;
        }
        String employeeString = scanner.nextLine();
        if(employeeString==null){
            return null;
        }
        scanner.hasNextLine();
        return stringToEmployee(employeeString);
    }

    private Employee stringToEmployee(String employeeString){
        String [] parts = employeeString.split(" ");
        long id = Long.valueOf(parts[0]);
        double salary = Double.valueOf(parts[parts.length - 1]);
        String name = "";
        for(int i = 1; i < parts.length - 1; i++){
            name = i==parts.length - 2 ? name + parts[i]: name + parts[i] + " ";
        }
        FixedHourEmployee employee = new FixedHourEmployee(name, salary);
        employee.setId(id);
        return employee;
    }
    @Override
    public void close() throws IOException {
        scanner.close();
    }
}
