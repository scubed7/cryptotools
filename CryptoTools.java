package crypto.executable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class CryptoTools {

	private static Hasher h = new Hasher();
	private static Caesar c = new Caesar();

	private static String plaintext;

	public CryptoTools(String fname) {
		Scanner fileIn = null;

		try {
			fileIn = new Scanner(new File(fname));
		}
		catch(FileNotFoundException e) {
			System.out.println("File Not Found");
			System.exit(-1);
		}
		
		plaintext = fileIn.nextLine();


	}


	public static String caesarEncrypt(int shift) {
		return c.encrypt(plaintext,shift);
	}

	public static String caesarDecrypt(int shift) {
		return c.decrypt(plaintext, shift);
	}

	public static void caesarBruteForce() {
		c.bruteForceDecrypt(plaintext);
	}

	public static String vigEncrypt(String key) {
		return new Vigenere(key).encrypt(plaintext);
	}

	public static String vigDecrypt(String key) {
		return new Vigenere(key).decrypt(plaintext);
	}

	public static String md5() {
		return h.getMD5(plaintext);
	}

	public static String sha512() {
		return h.sha512(plaintext);
	}

	public static String sha224() {
		return h.sha224(plaintext);
	}

	public static String sha384() {
		return h.sha384(plaintext);
	}

	public static String convertBase(String num, int obase, int cbase) {
		return Integer.toString(Integer.parseInt(num, obase), cbase);
	}

	public static String xor(Str)

}
