package MyPet;

public class DogFriendsCompAge implements Comparator<MyDogFriends>, java.util.Comparator<MyDogFriends> {

    public  int compare (MyDogFriends a, MyDogFriends b) {
        return b.getAgeDog()-a.getAgeDog();
    }

    @Override
    public java.util.Comparator<MyDogFriends> reversed() {
        return java.util.Comparator.super.reversed();
    }

    @Override
    public Comparator<MyDogFriends> thenComparing(DogFriendsCompAge dogFriendsCompAge) {
        return null;
    }
}

