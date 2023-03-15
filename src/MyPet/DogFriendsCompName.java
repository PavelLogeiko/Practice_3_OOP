package MyPet;

public class DogFriendsCompName implements Comparator<MyDogFriends> {
        public int compare(MyDogFriends a, MyDogFriends b){
            return a.getNameDog().compareTo(b.getNameDog());
        }

    @Override
    public Comparator<MyDogFriends> thenComparing(DogFriendsCompAge dogFriendsCompAge) {
        return null;
    }
}
