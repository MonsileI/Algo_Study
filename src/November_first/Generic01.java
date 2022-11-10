package November_first;



import java.util.*;

 

class Human { public void eat() { System.out.println("사람은 : 밥을 먹는다"); } }

class Halim extends Human { public void eat() { System.out.println("나는 하림 : 얌얌"); } }

class Hongbin extends Human { public void eat() { System.out.println("나는 홍빈 : 욤욤"); } }

class Ansongbin { public void eat() { System.out.println("나는 송빈 : 우걱우걱"); } }

 

class AnimalList<T> {

    ArrayList<T> al = new ArrayList<T>();

 

    void add(T animal) { al.add(animal); }

    T get(int index) { return al.get(index); }

    boolean remove(T animal) { return al.remove(animal); }

    int size() { return al.size(); }

}

 

public class Generic01 {

    public static void main(String[] args) {

        AnimalList<Human> landAnimal = new AnimalList<>(); // Java SE 7부터 생략가능함.

 

        landAnimal.add(new Human());

        landAnimal.add(new Halim());

        landAnimal.add(new Hongbin());


        // landAnimal.add(new Sparrow()); // 오류가 발생함.

 

        for (int i = 0; i < landAnimal.size() ; i++) {

            landAnimal.get(i).eat();

        }

    }

}

