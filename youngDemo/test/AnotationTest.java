import org.junit.Test;
/**
 * Created by young on 2016/8/13.
 *
 * JUNIT 常用的注解
 */
public class AnotationTest {

    /**
     * @Test:将一个普通方法修饰成为测试方法。
     *  @Test(expected=XX.class)
     *  @Test(timeout=毫秒)
     * @BeforeClass:他会在所有的方法运行前被执行，static修饰
     * @AfterClass:他会在所有的方法运行结束后被执行，static修饰
     * @Before:会在每一个测试方法被运行前执行一次
     * @After:会在每一个测试方法运行后被执行一次
     * @Ignone:所修饰的测试方法会被忽略
     * @RunWith:可以更改测试运行器 继承org.junit.runner.Runner就可以了
     * @Assert 断言是非常重要的
     */

    @Test(timeout = 2000)
    public void TestWhile(){
        while (true){
            System.out.println("run forever...");
        }
    }

    @Test(timeout = 3000)
    public void TestSleep(){
        try{
            Thread.sleep(2000);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
