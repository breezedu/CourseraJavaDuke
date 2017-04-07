package week1;

import edu.duke.FileResource;

/************************
 * Assignment #2 CaesarCipher
 * 
 * @author jeffd
 *
 */
public class CaesarCipher {
	
	public static void main(String[] args){
		
		String retStr = encrypt("FIRST LEGION ATTACK EAST FLANK!", 23);
		
		System.out.println("The return string: " + retStr);
		
		
		FileResource fr = new FileResource();
		String message = fr.asString();
		message = "First Legion";
		int key = 23;
		
		String encrypted = encrypt(message, key);
		System.out.println("key is " + key + "\n" + encrypted);
		
		
		
		//encrypt two keys
		System.out.println(encryptTwoKeys("First Legion", 23, 17));
		
	}//end main()

	
	/**************************************
	 * This method returns a String that has been encrypted using the following algorithm. 
	 * Parameter key1 is used to encrypt every other character with the Caesar Cipher algorithm, 
	 * starting with the first character, and key2 is used to encrypt every other character, 
	 * starting with the second character. 
	 * For example, the call encryptTwoKeys(“First Legion”, 23, 17) should return “Czojq Ivdzle”.
	 * @param str
	 * @param key1
	 * @param key2
	 * @return
	 */
	private static String encryptTwoKeys(String str, int key1, int key2) {
		// TODO Auto-generated method stub
		String str1 = "";
		String str2 = "";
		
		for(int i=0; i<str.length(); i++){
			
			if(i%2 == 0){
				
				str1 += str.charAt(i); 
			
			} else {
				
				str2 += str.charAt(i); 
			}
			
		}//end for i< str.length() loop; 
		
		str1 = encrypt(str1, key1);
		str2 = encrypt(str2, key2); 
		
		String retStr = "";
		if(str1.length() == str2.length()){
			
			for(int i=0; i<str1.length(); i++){
				retStr = retStr + str1.charAt(i) + str2.charAt(i);
			}
		
		} else {
			
			for(int i=0; i<str2.length(); i++){
				retStr = retStr + str1.charAt(i) + str2.charAt(i);
			}
			
			retStr += str1.charAt(str1.length() - 1);
			
		}
		
		return retStr;
	}


	/*************************************************
	 * Modify the encrypt method to be able to handle both uppercase and lowercase letters. 
	 * For example, encrypt(“First Legion”, 23) should return “Cfopq Ibdflk”, 
	 * and encrypt(“First Legion”, 17) should return “Wzijk Cvxzfe”. 
	 * Be sure to test the encrypt method.
	 * @param string
	 * @param i
	 * @return
	 */
	private static String encrypt(String str, int key) {
		// TODO Auto-generated method stub
		String albetaUP = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
		String albetaLOW = "abcdefghijklmnopqrstuvwxyz";
		
		String albeta = albetaUP + albetaLOW;
		
		String encryptedUp = albetaUP.substring(key) + albetaUP.substring(0, key);
		String encryptedLow = albetaLOW.substring(key) + albetaLOW.substring(0, key);
		
		String encrypted = encryptedUp + encryptedLow;
		
		String retStr = "";
		
		for(int i=0; i<str.length(); i++){
			
			//get the index in the alpha-beta string
			int index = albeta.indexOf(str.charAt(i)); 
			
			if(index > -1 ){
				
				//get the char at the same index in the encrypted string;
				char c = encrypted.charAt(index);
				
				//add char c to the return string
				retStr += c;
				
			} else {
				
				retStr += str.charAt(i); 
			}

						
		}//end for i<str.length() loop; 
		
		return retStr;
	}//end encrypt() method; 

}//ee
