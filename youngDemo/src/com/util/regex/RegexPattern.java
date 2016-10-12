package com.util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPattern {	
	
	public void RegexHttp(){
		String text = "This is the text to be searched " +
		        "for occurrences of the http:// pattern.";
		String pattern = ".*http://.*";
		boolean matches = Pattern.matches(pattern, text);
		System.out.println("matches = " + matches);		
	}
	
	/**
	 * Pattern (java.util.regex.Pattern)
	 * 
	 */
	
	public void RegexPattern(){
		String text = "This is the text to be searched " +
		        "for occurrences of the http:// pattern.";
		String pattern = ".*is.*";
		boolean matches = Pattern.matches(pattern, text);
		System.out.println("matches = "+matches);
	}
	
	/**
	 * Pattern.compile()
	 * 如果需要匹配一个正则表达式在文本中多次出现，需要通过Pattern.compile() 方法创建一个Pattern对象。
	 * Pattern.matcher()
	 */
	
	public void RegexCompile(){
		String text    =
		        "This is the text to be searched " +
		        "for occurrences of the http:// pattern.";
		String patternString = ".*http://.*";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(text);
		boolean matches = matcher.matches();		
		System.out.println("matches = " + matches);
		//忽略大小写
		//Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
	}
	
	/**
	 * Pattern.split()
	 */
	public void RegexSplit(){
		String text = "A sep Text sep With sep Many sep Separators";
		String patternString = "sep";
		Pattern pattern = Pattern.compile(patternString);
		String[] split = pattern.split(text);
		System.out.println("split.length = " + split.length);
		for(String element : split){
			    System.out.println("element = " + element);
			}

	}	
	
	/**
	 * RegexLookingAt
	 * lookingAt() 与matches() 方法类似，最大的不同是，lookingAt()方法对文本的开头匹配正则表达式；而
		matches() 对整个文本匹配正则表达式
	 */
	
	public void RegexLookingAt(){
		String text    =
		        "This is the text to be searched " +
		        "for occurrences of the http:// pattern.";
		String patternString = "This is the";
		Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(text);
		System.out.println("lookingAt = " + matcher.lookingAt());
		System.out.println("matches   = " + matcher.matches());
	}
	
	/**
	 * find() + start() + end()
	 * find() 方法用于在文本中查找出现的正则表达式，文本是创建Matcher 事，通过 Pattern.matcher(text) 方法传入的。如果在文本中多次匹配，find() 方法返回第一个，之后每次调用 find() 都会返回下一个。
	 */
	public void RegexFind(){
		String text    =
		        "This is the text which is to be searched " +
		        "for occurrences of the word 'is'.";
		String patternString = "is";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(text);
		int count = 0;
		while(matcher.find()) {
		    count++;
		    System.out.println("found: " + count + " : "  + matcher.start() + " - " + matcher.end());
		}
	}
	
	/**
	 * reset(),reset() 方法会重置Matcher 内部的 匹配状态
	 */
	
	/**
	 * group(),假设想在一个文本中查找URL链接，并且想把找到的链接提取出来。当然可以通过 start()和 end()方法完成。但是用group()方法更容易些。
	 */
	
	public void RegexGroup(){
		String text    =  "John writes about this, and John writes about that," +
                " and John writes about everything. "  ;
		String patternString1 = "(John)";
		Pattern pattern = Pattern.compile(patternString1);
		Matcher matcher = pattern.matcher(text);
		while(matcher.find()) {
			System.out.println("found: " + matcher.group(1));
		}
	}
	
	/**
	 * replaceAll() + replaceFirst()replaceAll() 和 replaceFirst() 方法可以用于替换Matcher搜索字符串中的一部分。replaceAll() 方法替换全部匹配的正则表达式，replaceFirst() 只替换第一个匹配的。
	 */
	public void RegexReplaceFirst(){
		String text    =
		          "John writes about this, and John Doe writes about that," +
		                  " and John Wayne writes about everything."
		        ;
		String patternString1 = "((John) (.+?)) ";
		Pattern pattern = Pattern.compile(patternString1);
		Matcher matcher = pattern.matcher(text);

		String replaceAll = matcher.replaceAll("Joe Blocks ");
		System.out.println("replaceAll   = " + replaceAll);

		String replaceFirst = matcher.replaceFirst("Joe Blocks ");
		System.out.println("replaceFirst = " + replaceFirst);
	}
	
	/**
	 * appendReplacement() + appendTail()
	 */
	public void RegexAppendReplacement(){
		String text    =
		          "John writes about this, and John Doe writes about that," +
		                  " and John Wayne writes about everything."
		        ;

		String patternString1 = "((John) (.+?)) ";
		Pattern      pattern      = Pattern.compile(patternString1);
		Matcher      matcher      = pattern.matcher(text);
		StringBuffer stringBuffer = new StringBuffer();

		while(matcher.find()){
		    matcher.appendReplacement(stringBuffer, "Joe Blocks ");
		    System.out.println(stringBuffer.toString());
		}
		matcher.appendTail(stringBuffer);
		System.out.println(stringBuffer.toString());
	}
	
}
