import java.util.Objects;

final class TestClass {
    protected Integer a;
    private boolean isB;
    public String ccc;

    private TestClass(Integer a, boolean isB, String ccc) {
        this.a = a;
        this.isB = isB;
        this.ccc = ccc;
    }

    public TestClass(){
    }

    public static void test1(){
        System.out.println("Test is over");
    }

    private Integer test2(int a){
        a += 3;
        return a;
    }

    protected String test3(String str){
        str += "This is test";
        return str;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestClass testClass = (TestClass) o;
        return isB == testClass.isB &&
                Objects.equals(a, testClass.a) &&
                Objects.equals(ccc, testClass.ccc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, isB, ccc);
    }
}
