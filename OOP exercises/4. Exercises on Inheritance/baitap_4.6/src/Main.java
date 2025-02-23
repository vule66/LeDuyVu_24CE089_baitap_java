public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("Animal");
        System.out.println(animal);

        Mammal mammal = new Mammal("Mammal");
        System.out.println(mammal);

        Cat cat = new Cat("Cat");
        System.out.println(cat);
        cat.greets();

        Dog dog1 = new Dog("Dog1");
        System.out.println(dog1);
        dog1.greets();

        Dog dog2 = new Dog("Dog2");
        dog1.greets(dog2);
    }
}