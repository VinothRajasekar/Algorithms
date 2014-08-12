package com.Merkle.vinoth;

import java.math.BigInteger;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class TestDriverMerkle.
 */
public class TestDriverMerkle {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		MerkleOperation mh = new MerkleOperation();
		
		Scanner scan = new Scanner(System.in);
		
		String text = new String();
		
	   do
		{ 
			System.out.println("Enter a string and I will encrypt it in a single number:");
			text = scan.nextLine();
			System.out.println("Clear text: " + text);
			 System.out.println("Number of clear text bytes = " + text.length());
			 if (text.length() > 80)
			 {
				 System.out.println("Maximum character length allowed is 80. Please try again.");
				 
				
			 }}while (text.length() > 80);
				 
	
		
		    byte[] encryptBytes = text.getBytes();
	        BigInteger encryption = mh.encrypt(encryptBytes);
	        System.out.println("\"" + text + "\" " + "is encryped as " + encryption );

	        byte[] decryptBytes = mh.decrypt(encryption);
	        System.out.println("Result of decryption: " + new String(decryptBytes)); 
		

	
	}
}



