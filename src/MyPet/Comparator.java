package MyPet;

    public interface Comparator <T> {
    int compare (T a, T b);

        Comparator<MyDogFriends> thenComparing(DogFriendsCompAge dogFriendsCompAge);
    }
