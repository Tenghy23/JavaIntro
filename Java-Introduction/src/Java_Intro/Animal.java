package Java_Intro;

public abstract class Animal {
    public String picture;
    protected String name;
    protected int age;

    public Animal(String picture, String name, int age) {
        this.picture = picture;
        this.name = name;
        this.age = age;
    }

    // making abstract class req child to have
    // their own makeSound method
    public abstract void makeSound();

    public int getAge() {
        return age;
    }

    public int setAge(int age) {
        return age;
    }

    public void birthday() {
        age++;
    }
}
