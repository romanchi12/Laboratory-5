package org.romanchi.task3;

import java.util.Comparator;

public class ByNameAsc  implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.name.compareTo(o2.name);
    }
}
