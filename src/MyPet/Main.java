// Практическая работа № 2 - ООП
// Задача 3. Описать логику взаимодействия человека и домашнего питомца.
// Дополнительно использовать абстрактные классы (Animal) и интерфейсы (Winner).

package MyPet;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nЗадача 3. Описать в ООП - стиле логику взаимодействия человек - домашний питомец.\nДополнительно использовать абстрактные классы и интерфейсы.");
        System.out.println("\nОбъекты взаимодействия человек - собака:");
        MyPerson man = new MyPerson("Иван");
        MyDog dog = new MyDog("Рекс", 2);
        System.out.printf("Человек - > %s, ", man.getName());
        System.out.printf("Собака -> %s\n", dog.getName());
        System.out.println("\nМестоположение и статус человека и собаки:");
        System.out.println(man);
        System.out.println(dog);
        System.out.println("\nВзаимодействие человека и собаки и его результаты:");
        man.call(dog);
        dog.goRoom(MyHouse.balcony);
        man.call(dog);
        System.out.println(dog);
        dog.goRoom(MyHouse.kitchen);
        System.out.println(dog);
        man.feed(dog);
        man.goRoom(MyHouse.kitchen);
        man.feed(dog);
        man.feed(dog);

        System.out.printf("\n%s и %s - довольны и счастливы !", man.getName(), dog.getName());

        // имплементация интерфейса - Winner
        System.out.println("\n\nИнформация о наличии достижений у домашнего питомца (имплементация интерфейса Winner): ");
        System.out.printf("А еще, %s - ", dog.getName()); dog.win();

        ArrayList<MyDogFriends> myDogFriends = new ArrayList<>();

        myDogFriends.add(new MyDogFriends("Мухтар", 5));
        myDogFriends.add(new MyDogFriends("Барбос", 3));
        myDogFriends.add(new MyDogFriends("Альба", 2));
        myDogFriends.add(new MyDogFriends("Дартик", 1));
        myDogFriends.add(new MyDogFriends("Холли", 4));
        myDogFriends.add(new MyDogFriends("Кент", 7));

        System.out.println("\nНесортированный список <друзей> моей собаки Рекса:");
        for (MyDogFriends p : myDogFriends) {
            System.out.println(p.getNameDog() + " " + p.getAgeDog());
        }

        DogFriendsCompAge dogFriendsCompAge = new DogFriendsCompAge();
        myDogFriends.sort(dogFriendsCompAge);

        System.out.println("\nОтсортированный <по старшинству> список <друзей> моей собаки Рекса:");
        for (MyDogFriends p : myDogFriends) {
            System.out.println(p.getNameDog() + " " + p.getAgeDog());
        }

        System.out.println("\n__________конец__________");
    }
}
