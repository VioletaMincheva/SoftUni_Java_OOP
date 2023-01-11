package InterfacesAndAbstraction.SayHello_lab3;

public interface Person {
    String getName();

    default String sayHello() {
        return "Hello";
    };
}
