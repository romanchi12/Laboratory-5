package org.romanchi;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;


public class Task2 implements Task{
    private static final Logger logger = Logger.getLogger(Task2.class.getName());
    private AtomicReference<List> alphaReference = new AtomicReference<>(null);
    private AtomicReference<List> bethaReference = new AtomicReference<>(null);
    private void initializeList(AtomicReference<List> listAtomicReference, Class<? extends List> collectionType){
        try {
            Constructor constructor = collectionType.getConstructor();
            listAtomicReference.set((List)constructor.newInstance());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public void populateAlpha(Class<? extends List> alphaType){
        initializeList(alphaReference, alphaType);
        Iterator intIterator = new Random().
                ints(150,1,201).limit(150).iterator();
        while(intIterator.hasNext()) {
            alphaReference.get().add(intIterator.next());
        }
    }


    public void populateBethaFromAlpha(Class<? extends List> bethaType){
        initializeList(bethaReference, bethaType);
        List alphaList = alphaReference.get();
        List bethaList = bethaReference.get();
        alphaList.stream().sorted(new Comparator() {
            @Override
            public int compare(Object left, Object right) {
                Integer leftInteger = (Integer)left;
                Integer rightInteger = (Integer) right;
                if(leftInteger < rightInteger){
                    return 1;                                   // maximum wanted
                }else if(leftInteger.equals(rightInteger)){
                    return 0;
                }else{
                    return -1;
                }
            }
        }).limit(15).forEach(item -> {
            bethaList.add(item);
        });
    }



    @Override
    public void execute() {
        populateAlpha(LinkedList.class);
        printList(alphaReference);
        populateBethaFromAlpha(LinkedList.class);
        printList(bethaReference);
        printListToFile(bethaReference, new File("betha.txt"));
    }

    public String listToString(AtomicReference<List> listAtomicReference){
        List list = listAtomicReference.get();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(list.getClass()).append(" ");
        list.forEach(item -> {
            stringBuilder.append(item).append(" ");
        });
        return stringBuilder.toString();
    }

    public void printList(AtomicReference<List> listAtomicReference){
        String listString = listToString(listAtomicReference);
        logger.info(listString);
    }

    public void printListToFile(AtomicReference<List> listAtomicReference, File file){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));) {
            bufferedWriter.write(listToString(listAtomicReference));
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
