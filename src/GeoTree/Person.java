package GeoTree;

enum Gender {
    man, woman
}
// класс Person наследует основные шаблонные параметры от абстрактного класса People
public class Person extends People {

    public Person(String fullName, int age, String gender) {
        super(fullName, age, gender);
    }

    public String toString() {
        return String.format("%s: %d %s", getFullName(), getAge(), getGender());
    }
}
