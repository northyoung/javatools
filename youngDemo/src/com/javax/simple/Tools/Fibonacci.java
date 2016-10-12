package com.javax.simple.Tools;


/**
 * 
 * @author root
 *	斐波那锲数字
 *	
 */
class Fibonacci {
			
	public static void recursion(int a1,int a2,int sum,String args,int count){	
		
		if(count>2){
			if(count<Integer.parseInt(args)){
				sum = a1 + a2;
				System.out.println(sum+"  ");
				a1 = a2;
				a2 = sum;
				count++;
				recursion(a1,a2,sum,args,count);				
			}	
		}else{
			System.out.println("1");
			count++;
			recursion(a1,a2,sum,args,count);
		}			
	}
	
	public static void main(String[] args){
		int count=1;  
		int sum = 1;
		int a2=1;
		int a1=1;
		recursion(a1,a2,sum,args[0],count);			
		
	}
	
}
