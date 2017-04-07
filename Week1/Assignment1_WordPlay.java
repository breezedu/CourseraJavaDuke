package week1;
	
public class Assignment1_WordPlay {
	
	
	public static void main(String[] ugs){
		
		//1st
		if( isVowel('A') ){
			System.out.println("This is a vowel.");
		}
		
		
		//2nd
		String test_string = "Hello World";
		
		String ret_string = replaceVowels(test_string, '*');
		
		System.out.println("The new string: " + ret_string);
		
		
		//3rd 
		String empStr = emphasize("dna ctgaaactga", 'a');
		
		System.out.println("The emphasized string: " + empStr);
		
	}//end main()
	
	
	
	/********************************************
	 * This method should return a String that is the string phrase but with the Char ch 
	 * (upper- or lowercase) replaced by
	 * ‘*’ if it is in an odd number location in the string 
	 * (e.g. the first character has an odd number location but an even index, it is at index 0), 
	 * 
	 * or
	 * 
	 * ‘+’ if it is in an even number location in the string 
	 * (e.g. the second character has an even number location but an odd index, it is at index 1).
	 * 
	 * @param string
	 * @param c
	 * @return
	 */
	private static String emphasize(String str, char c) {
		// TODO Auto-generated method stub
		String retStr = "";
		
		for(int i=0; i<str.length(); i++){
			
			if( str.charAt(i) != c){
				
				retStr += str.charAt(i);
				
			} else {
				
				if( i % 2 ==0){
					retStr += '*';
				} else {
					retStr += '+';
				}
				
			}
			
		}//end for i<str.length() loop; 
		
		return retStr;
	}//end emphasize(); 


	/*******************************************
	 * This method should return a String that is the string phrase with all the vowels 
	 * (uppercase or lowercase) replaced by ch. 
	 * For example, the call replaceVowels(“Hello World”, ‘*’) 
	 * returns the string “H*ll* W*rld”.
	 * 
	 * @param test_string
	 * @param c
	 * @return
	 */
	private static String replaceVowels(String test_string, char c) {
		// TODO Auto-generated method stub
		
		String retStr = "";
		
		for(int i=0; i<test_string.length(); i++){
			
			//call isVowel() method to check if the char at i is vowel, if so replace with character c
			if( isVowel(test_string.charAt(i) ) ){
				retStr = retStr + c;
			
			} else {
				
				retStr = retStr + test_string.charAt(i);
			}
			
		}//end for i<test_string.length() loop; 
		
		return retStr;
	}//end replaceVowels() method; 



	/***********************************
	 * This method returns true if ch is a vowel 
	 * (one of 'a', 'e', 'i', 'o', or 'u' or the uppercase versions) 
	 * and false otherwise.
	 * 
	 * @param c
	 * @return
	 */
	private static boolean isVowel(char c) {
		// TODO Auto-generated method stub
		String vowel = "aeiouAEIOU";
		
		if(vowel.indexOf(c) > -1){
			return true;
			
		} else {
			
			return false;
		}
		//return false;
		
	} //end isVowel() method;
	
}//ee
