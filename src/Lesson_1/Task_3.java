package Lesson_1;

import java.util.ArrayList;
import java.util.List;

public class Task_3 {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        appleBox.put(new Apple(1.0));
        appleBox.put(new Apple(1.3));
        appleBox.put(new Apple(2));

        orangeBox.put(new Orange(2.3));
        orangeBox.put(new Orange(2));

        appleBox.getWeight();

        System.out.println(appleBox.compare(orangeBox));

        appleBox.clear();
//        appleBox.putAll(orangeBox);
    }
}

abstract class Fruit {
    private double WEIGHT;

    public double getWeight(){
        return WEIGHT;
    }

    public void setWeight(double weight) {
        this.WEIGHT = weight;
    }
}



class Apple extends Fruit {
    public Apple(double appleWeight) {
        setWeight(appleWeight);
    }
}



class Orange extends Fruit {
    public Orange(double orangeWeight) {
        setWeight(orangeWeight);
    }
}



class Box<T extends Fruit> {
    private List<T> fruitsInside;

    public Box() {
        fruitsInside = new ArrayList<>();
    }

    public double getWeight() {
        double boxWeight = 0;
        for (Fruit fruit : this.fruitsInside) {
            boxWeight += fruit.getWeight();
        }
        return boxWeight;
    }

    public boolean compare(Box<?> box) {
        return this.getWeight() == box.getWeight();
    }

    public void putAll(Box<T> box){
        fruitsInside.addAll(box.getFruits());
        box.clear();
    }

    public void put(T fruit) {
        fruitsInside.add(fruit);
    }

    public List<T> getFruits() {
        return fruitsInside;
    }

    public void clear() {
        fruitsInside.clear();
    }
}