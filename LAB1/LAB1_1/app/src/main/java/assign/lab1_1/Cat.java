package assign.lab1_1;

public class Cat extends Animal {

    private String name;

    // Constructor
    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String saySomething() {
        return "I'm a cat, miau! My name is " + name;
    }
}