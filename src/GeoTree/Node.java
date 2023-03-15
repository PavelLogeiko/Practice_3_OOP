package GeoTree;
public class Node implements Printable{

    public Node (Person p1, Relationship rs, Person p2) {
        this.p1 = p1;
        this.rs = rs;
        this.p2 = p2;
    }

    Person p1;
    Relationship rs;
    Person p2;

//    @Override
//    public String toString(){
//        return String.format("<%s %s %s>", p1, rs, p2);
//    }
// добавлен вызов интерфейса Printable
    public void print(){
        System.out.println(String.format("%s: %s -> %s", p1, rs, p2));
    }
}