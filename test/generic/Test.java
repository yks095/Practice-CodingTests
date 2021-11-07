package test.generic;

public class Test {
    public static void main(String[] args) {
        System.out.println(UserType.ADMIN == UserType.MEMBER);

        UserType[] ut = new UserType[]{UserType.ADMIN, UserType.MEMBER};
    }
}
