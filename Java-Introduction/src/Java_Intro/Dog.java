package Java_Intro;

public class Dog extends Animal implements IPettable{
    // static called in the class if you know that this value most
    // likely wont ever change, use final if the value cfm
    // wont change
    public static final int dogToHumanYearMultiplier = 7;

    public Dog(String picture, String name, int age) {
        super(picture, name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(this.name + " just woofed!");
    }

    @Override
    public void pet() {
        System.out.println(this.name + " just scratched!");
    }
}
