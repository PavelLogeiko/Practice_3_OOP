package GeoTree;

public class PersonNameComp implements Comparator<Person> {

    @Override
    public int compare(Person a, Person b) {
        return a.getFullName().compareTo(b.getFullName());
    }

    @Override
    public Comparator<Person> thenComparing(PersonAgeComp personAgeComp) {
        return null;
    }
}

