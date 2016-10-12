package test.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.util.classutil.ClassUtil;

public class TestClassUtil {

	@Test
	public void test() {
		String a = "a";
		//ClassUtil.printFieldMessage(a);
		ClassUtil.printConMessage(a);
	}

}
