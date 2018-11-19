package crypto.executable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hasher {
	
	private static MessageDigest digest;
	
	private String getHash(String s, String input) {
		try {
			digest = MessageDigest.getInstance(s);
			 byte[] messageDigest = digest.digest(input.getBytes()); 
			  
	            // Convert byte array into signum representation 
	            BigInteger no = new BigInteger(1, messageDigest); 
	  
	            // Convert message digest into hex value 
	            String hashtext = no.toString(16); 
	            while (hashtext.length() < 32) { 
	                hashtext = "0" + hashtext; 
	            } 
	            return hashtext;
	        
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
		
		
	}
	
	public String getMD5(String input) {
		return getHash("MD5", input);
	}
	
	public String sha512(String input) {
		return getHash("SHA-512", input);
	}
	
	public String sha224(String input) {
		return getHash("SHA-224", input);
	}
	
	public String sha384(String input) {
		return getHash("SHA-384", input);
	}
	
	public int customHash(Object o) {
		return o.hashCode();
	}
	
	public boolean doesCollide(Object o, Object p) {
		return o.hashCode() == p.hashCode();
	}
}
