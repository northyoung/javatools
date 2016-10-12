package test.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.util.regex.RegexPattern;

public class TestRegexHttp {

	RegexPattern regexPattern = new RegexPattern();
	
	@Test 
	public void test() {
		System.out.println("==== RegexHttp ====");
		regexPattern.RegexHttp();
		System.out.println("==== RegexPattern ====");
		regexPattern.RegexPattern();
		System.out.println("==== RegexCompile ====");
		regexPattern.RegexCompile();
		System.out.println("==== RegexSplit ====");
		regexPattern.RegexSplit();
		System.out.println("==== RegexLookingAt ====");
		regexPattern.RegexLookingAt();
		System.out.println("==== RegexFind ====");
		regexPattern.RegexFind();
		System.out.println("==== RegexGroup ====");
		regexPattern.RegexGroup();
		System.out.println("==== RegexrReplaceFirst ====");
		regexPattern.RegexReplaceFirst();
		System.out.println("==== RegexAppendReplacement ====");
		regexPattern.RegexAppendReplacement();
	}

}
