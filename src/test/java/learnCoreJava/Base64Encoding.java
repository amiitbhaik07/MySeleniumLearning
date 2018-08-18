package learnCoreJava;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Encoding 
{
	public static void main(String args[])
	{
		final String s = "ICW_SELL_PDR.gen:cisco123";
        final byte[] authBytes = s.getBytes(StandardCharsets.UTF_8);
        final String encoded = Base64.getEncoder().encodeToString(authBytes);
        System.out.println(s + " => " + encoded);
	}

}
