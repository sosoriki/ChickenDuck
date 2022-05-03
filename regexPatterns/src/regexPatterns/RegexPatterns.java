package regexPatterns;

/**
 * 
 * Class that has methods that uses regex to check for name, phone number, email, address, or java executables
 * @author Kendrick Pham
 *
 */
public class RegexPatterns {
	
	public static boolean testName(String name) {
		return name.matches("\\[A-Z][a-z-]+\\s[A-Z][a-z]+");
	}
	
	public static boolean testPhoneNumber(String phoneNumber) {
		return phoneNumber.matches("\\(\\(404)|(678)|(770)\\)\\d{3}-\\d{4}");
	}
	
	public static boolean testEmail(String email) {
		return email.matches("\\^[A-Za-z][A-Za-z0-9._-]+@[A-Za-z0-9._-]+\\.(com)|(org)|(net)");
	}
	
	public static boolean testAddress(String address) {
		return address.matches("\\[0-9]{1,5}\\s[w.-\\s]\\t[A-Za-z.-\\s]\\s?,?\\s?[A-Z][A-Z]\\s[0-9]{5}");
	}
	
	public static boolean testJavaExecutable(String java) {
		return java.matches("\\bpublic static void main (String[] args)\\b");
	}
	
}
