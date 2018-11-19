package crypto.executable;

public class Xorcrypt {

	public int[] encrypt(String m, String key) {
		int[] x = new int[m.length()];
		for (int i = 0; i < m.length(); i++) {
			x[i] = ((int)(m.charAt(i)) ^ (int)(key.charAt(i % (key.length() - 1)))) + '0';
		}
		return x;
	}

	
	public String decrypt(int[] m, String key) {
		String output = "";        
        for(int i = 0; i < m.length; i++) {
            output += (char) ((m[i] - 48) ^ (int) key.charAt(i % (key.length() - 1)));
        }
        return output;
	}

}
