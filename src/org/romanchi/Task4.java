package org.romanchi;

import java.util.Random;
import java.util.Scanner;

public class Task4 implements Task {
    @Override
    public void execute() {
        int number = new Random().nextInt(101);
        Scanner scanner = new Scanner(System.in);
        int temp = -1;
        int upperBound = 100;
        int lowerBound = 0;
        String tempLine = "";
        while( null != (tempLine = scanner.nextLine())){
            try {
                temp = Integer.valueOf(tempLine);
            } catch (NumberFormatException e) {
                continue;
            }
            if(number < temp){
                upperBound = temp < upperBound? temp: upperBound;
                System.out.println(String.format("Менше, спробуйте [%d,%d]", lowerBound, upperBound));
            }else if(number > temp){
                lowerBound = temp > lowerBound ? temp:lowerBound;
                System.out.println(String.format("Більше, спробуйте [%d,%d]", lowerBound, upperBound));
            }else{
                break;
            }
        }
        System.out.println("Ви вгадали");

    }
}
