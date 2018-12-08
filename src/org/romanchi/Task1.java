package org.romanchi;

import org.romanchi.task1.Item;

import java.util.*;
import java.util.logging.Logger;

/**
 * @author Roman Malyarchuk
 *
 * As we can see {@link java.util.TreeSet} and {@link java.util.HashSet} need more time to add elements.
 * They need more time because, every time as  {@link java.util.TreeSet#add(Object)}
 * and {@link java.util.HashSet#add(Object)} are invoked
 * {@link Item#compareTo(Object)} is invoked too
 *
 *  As we can see such collections as {@link java.util.ArrayList} and {@link java.util.LinkedList}
 *  need more time to find and remove element (In this example we add element to the end of collection)
 *
 */
public class Task1 implements Task{
    private static final Logger logger = Logger.getLogger(Task1.class.getName());
    public void populateCollection(Collection collection, int numberOfElements, Object toFind){
        long start = System.nanoTime();
        for(int i = 0; i < numberOfElements; i++){
            collection.add(new Item());                       //Comparable needed
        }

        long end = System.nanoTime();
        collection.add(toFind);
        logger.info(String.format("Add to %s %d elements, time: %f ms", collection.getClass(),
                numberOfElements,(end - start)/ 1000000.0));
    }

    public void containsElementIn(Collection collection, Object toFind){
        long start = System.nanoTime();
        collection.contains(toFind);
        long end = System.nanoTime();
        logger.info(String.format("Find element in %s, time: %f ms", collection.getClass(),
                (end - start)/1000000.0));
    }

    public void removeElementFrom(Collection collection, Object toRemove){
        long start = System.nanoTime();
        collection.remove(toRemove);
        long end = System.nanoTime();
        logger.info(String.format("Remove element from %s, time: %f ms", collection.getClass(),
                (end - start)/1000000.0));
    }

    public void execute() {
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();
        TreeSet treeSet = new TreeSet();
        HashSet hashSet = new HashSet();

        Item itemToFind = new Item();
        populateCollection(arrayList, 100000, itemToFind);
        populateCollection(linkedList, 100000, itemToFind);
        populateCollection(treeSet, 100000, itemToFind);
        populateCollection(hashSet, 100000, itemToFind);

        containsElementIn(arrayList,itemToFind);
        containsElementIn(linkedList,itemToFind);
        containsElementIn(treeSet,itemToFind);
        containsElementIn(hashSet,itemToFind);

        removeElementFrom(arrayList,itemToFind);
        removeElementFrom(linkedList,itemToFind);
        removeElementFrom(treeSet,itemToFind);
        removeElementFrom(hashSet,itemToFind);





    }
}
