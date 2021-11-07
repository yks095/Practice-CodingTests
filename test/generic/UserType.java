package test.generic;

public enum UserType {
    ADMIN(0), MEMBER(0);

    public int val;

    UserType(int i) {
        this.val = i;
    }

    public int getVal() {
        return val;
    }
}
