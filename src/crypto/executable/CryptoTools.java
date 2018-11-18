package crypto.executable;
public class CryptoTools {
	
	private static Hasher h = new Hasher();
	private static Caesar c = new Caesar();
	

	public static String caesarEncrypt(String message, int shift) {
		return c.encrypt(message,shift);
	}
	
	public static String caesarDecrypt(String message, int shift) {
		return c.decrypt(message, shift);
	}
	
	public static void caesarBruteForce(String message) {
		c.bruteForceDecrypt(message);
	}
	
	public static String vigEncrypt(String message, String key) {
		return new Vigenere(key).encrypt(message);
	}
	
	public static String vigDecrypt(String message, String key) {
		return new Vigenere(key).decrypt(message);
	}
	
	public static String md5(String message) {
		return h.getMD5(message);
	}
	
	public static String sha512(String message) {
		return h.sha512(message);
	}
	
	public static String sha224(String message) {
		return h.sha224(message);
	}
	
	public static String sha384(String message) {
		return h.sha384(message);
	}
	
	public static String convertBase(String num, int obase, int cbase) {
		return Integer.toString(Integer.parseInt(num, obase), cbase);
	}
	
	public static void main(String[] args) {
		System.out.println(new CryptoTools().convertBase("10", 10, 2));
	}

}
