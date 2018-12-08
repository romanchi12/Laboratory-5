package org.romanchi.task1;

import java.util.Random;

public class Item implements Comparable {
    @Override
    public int compareTo(Object o) {
        //return new Random().nextInt(3) - 1;
        return 1;
    }
}
