package GeoTree;

public class PersonAgeComp implements Comparator<Person>{

    @Override
    public int compare(Person a, Person b) {
    return a.getAge() - b.getAge();
}

    @Override
    public Comparator<Person> thenComparing(PersonAgeComp personAgeComp) {
        return null;
    }

}