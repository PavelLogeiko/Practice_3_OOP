package GeoTree;

public interface Comparator <T>{

    int compare (T a, T b);

    Comparator<Person> thenComparing(PersonAgeComp personAgeComp);

}
