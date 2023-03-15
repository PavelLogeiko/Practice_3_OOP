package MyPet;

public class MyDogFriends {
    private String nameDog;
    private int ageDog;

    public MyDogFriends(String n, int a){
        nameDog = n;
        ageDog = a;
    }
    public String getNameDog() {
        return nameDog;
    }

    public void setNameDog(String nameDog) {
        this.nameDog = nameDog;
    }

    public int getAgeDog() {
        return ageDog;
    }

    public void setAgeDog(int ageDog) {
        this.ageDog = ageDog;
    }
}
