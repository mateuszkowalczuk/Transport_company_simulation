package pl.programowanie;

import java.util.LinkedList;
import java.util.Queue;

public class Storage {

    Queue<Baloon> storage = new LinkedList<>();

    public void add(Baloon baloon) {
        storage.add(baloon);
    }

    public Baloon peek() {
        return storage.peek();
    }

    public int size() {
        return storage.size();
    }

    public void remove(){
        storage.remove();
    }

    public void clear(){
        storage.clear();
    }

    public void forEach(Queue<Baloon> baloons){
        for (Baloon baloon : storage)
            baloons.add(baloon);
    }
}