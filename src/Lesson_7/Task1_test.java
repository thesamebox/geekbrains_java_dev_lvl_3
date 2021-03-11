package Lesson_7;

public class Task1_test {
    @Test(priority = 9)
    public void methodInt(int x){
        System.out.println("int "+x);
    }
    @Test(priority = 1)
    public void methodBoolean(boolean x){
        System.out.println("boolean "+x);
    }
    @Test
    public void methodDouble(double x){
        System.out.println("double "+x);
    }
    @Test(priority = 10)
    public void methodFloat(float x){
        System.out.println("float "+x);
    }
    @Test(priority = 4)
    public void methodChar(char x){
        System.out.println("char "+x);
    }
    @Test(priority = 10)
    public void methodString(String x){
        System.out.println("String "+x);
    }
    @BeforeSuite
    public void methodBegin(){
        System.out.println("=== START ===");
    }
    @AfterSuite
    public void methodEnd(){
        System.out.println("=== END ===");
    }
}
