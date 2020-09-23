package test.generic;

public class GenericTest {
    public static void main(String[] args) {
        Skill<?, ?> first = new Skill<>("String", 33);
        Skill<Integer, Character> multiGenericClass2= new Skill<>(10, 'c');

        first.print();
        multiGenericClass2.print();
    }
}

class Skill<T, V>   {
    private T key;
    private V value;

    public Skill(T key, V value) {
        this.key = key;
        this.value = value;
    }

    public void print() {
        System.out.println("제 타입은 " + this.key + "이고, 값은 " + this.value + "입니다.");
    }
}

//class GenericClass<T extends Integer>  {
//    private String key;
//    private T value;
//
//    public GenericClass(String key, T value) {
//        this.key = key;
//        this.value = value;
//    }
//
//    public void print()  {
//        System.out.println("제 타입은 " + this.key + "이고, 값은 " + this.value + "입니다.");
//    }
//}