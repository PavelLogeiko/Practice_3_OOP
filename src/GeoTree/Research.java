package GeoTree;

import java.util.ArrayList;
import java.util.HashSet;

enum SearchGrand {
    grandParent,
    grandChildren,
}

enum SearchAge {
    ageYoung,
    ageOld
}

public class Research {

    HashSet<Person> result = new HashSet<>();
    ArrayList<Node> tree;

    public Research (GeoTree geoTree){
        tree = geoTree.getTree();
    }

    public String getResult(){
        StringBuilder people = new StringBuilder();
        for (Person t: this.result) people.append(t.getFullName());
        return people.toString();
    }

    public HashSet<Person> spend (Person p, Relationship rs) {
        for (Node t: tree) {
            if (t.p1.getFullName() == p.getFullName() && t.rs == rs) {
                result.add(t.p2);
            }
        }
        return result;
    }
    public HashSet<Person> spend (Person p, SearchGrand rs){
        Relationship rsTemp = Relationship.parent;
        if (rs == SearchGrand.grandParent) rsTemp = Relationship.parent;
        if (rs == SearchGrand.grandChildren) rsTemp = Relationship.children;
        ArrayList<Person> resultTemp = new ArrayList<Person>(spend(p, rsTemp));
        this.result.clear();
        for (Person q: resultTemp) spend(q, rsTemp);
        return result;
    }

    public HashSet<Person> spend (Gender gender){
        for (Node t: tree) {
            if (t.p1.getGender() == gender.toString()) result.add(t.p1);
        }
        return result;
    }
    // добавлен метод исследования - выборка людей по возрасту
    public HashSet<Person> spend(SearchAge re, int ageRe){
        for (Node t : tree) {
            if (re == SearchAge.ageOld) if (t.p1.getAge() >= ageRe) result.add(t.p1);
            if (re == SearchAge.ageYoung) if (t.p1.getAge() <= ageRe) result.add(t.p1);
        }
        return result;
    }
}
