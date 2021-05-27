package java_8_features;

import java.util.Base64;

public class Base64Basic_Encryption
{
	public static void main(String[] args) 
	{
		// Getting Encoder
		Base64.Encoder encoder = Base64.getUrlEncoder();
		
		// Encoding URL
		String s=encoder.encodeToString("https://www.linkedin.com/in/rishabhnigam007".getBytes());
		
		System.out.println("Encoded URL : "+s);
		
		// Getting Decoder
		Base64.Decoder decoder = Base64.getUrlDecoder();
		
		// Decoding URL
		String ss=new String(decoder.decode(s));
		System.out.println("Decoded URL : "+ss);
	}
}