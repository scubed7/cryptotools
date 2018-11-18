package crypto.executable;

public class Caesar{
	public static final String alpha = "abcdefghijklmnopqrstuvwxyz";
	//encrypts message by given shift
	public String encrypt(String message, int shift) {
		char[] x = message.toCharArray();
		for (int i = 0; i < x.length; i++) {
			int loc = alpha.indexOf(x[i]);
            int keyVal = (shift + loc) % 26;
            char replaceVal = alpha.charAt(keyVal);
            x[i] = replaceVal;
		}
		return new String(x);
	}

	public String decrypt(String message, int shift) {
		char[] x = message.toCharArray();
		for (int i = 0; i < x.length; i++) {
			 int loc = alpha.indexOf(message.charAt(i));
	            int keyVal = (loc - shift) % 26;
	            if (keyVal < 0)
	            {
	                keyVal = alpha.length() + keyVal;
	            }
	            char replaceVal = alpha.charAt(keyVal);
	            x[i] = replaceVal;
		}
		return new String(x);
	}

	public void bruteForceDecrypt(String message) {
		for (int i = 1; i < 26; i++) {
			System.out.println(decrypt(message, i));
		}
	}



}
