package org.romanchi.task3;

import java.io.*;

public class EmployeeWriter implements Closeable {
    BufferedWriter bufferedWriter;
    public EmployeeWriter(File file){
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void write(Employee employee){
        try {
            bufferedWriter.write(employee.id + " " + employee.name + " " + employee.salary+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws IOException {
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
