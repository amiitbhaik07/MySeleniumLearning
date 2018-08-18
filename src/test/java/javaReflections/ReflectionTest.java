package javaReflections;

import java.lang.reflect.Method;

public class ReflectionTest
{

	public static void main(String[] args) throws Exception
	{
		Class cls = Class.forName("javaReflections.OtherClass");
		Object obj = cls.newInstance();
		Method method = cls.getDeclaredMethod("getName", null);
		String s = (String)method.invoke(obj, null);
		System.out.println(s);


		//We can use Other Package as well
		/*Class cls1 = Class.forName("otherPackage.OtherPackageClass");
		Object obj1 = cls1.newInstance();
		Method method1 = cls1.getDeclaredMethod("getNameOtherPackage", null);
		String s1 = (String)method1.invoke(obj1, null);
		System.out.println(s1);*/
		
		System.out.println("Hello");
	}



}
