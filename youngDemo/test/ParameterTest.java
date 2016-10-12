import org.junit.Test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;


import java.util.Arrays;
import java.util.Collection;

/**
 * Created by young on 2016/8/13.
 * 参数化设置
 * 1.更改默认的测试运行器为@RunWith(Parameterized.class)
 * 2.声明变量来存放预期值和结果值
 * 3.申明一个返回值为Collection的公共静态方法，并使用@Parameter进行修饰
 * 4.为测试类声明一个带有参数的公共构造函数，并在其中为之声明变量赋值
 */

@RunWith(Parameterized.class)
public class ParameterTest {
    int expected = 0;
    int input1 = 0;
    int input2 = 0;

    @Parameterized.Parameters
    public static Collection<Object[]> t() {
        return Arrays.asList(
                new Object[][]{
                        {
                                3, 2, 1
                        },
                        {
                                4, 2, 2
                        }
                }
        );
    }

    public ParameterTest(int expected, int input1, int input2) {
        this.expected = expected;
        this.input1 = input1;
        this.input2 = input2;
    }

    @Test
    public void testAdd() {
        assertEquals(expected, new Calculate().add(input1, input2));
    }

    public class Calculate {
        public int add(int input1, int input2) {
            return input1 + input2;
        }
    }
}
