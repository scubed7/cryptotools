package crypto.executable;

import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {

	private final static BigInteger one = new BigInteger("1");
	private final static SecureRandom random = new SecureRandom();

	private BigInteger privKey;
	private BigInteger pubKey;
	private BigInteger mod;
	private BigInteger phi;


	public RSA(int bits, String pub, String priv) {
		BigInteger p = BigInteger.probablePrime(bits/2, random);
		BigInteger q = BigInteger.probablePrime(bits/2, random);
		privKey = new BigInteger(priv);
		pubKey = new BigInteger(pub);
		phi = (p.subtract(one)).multiply(q.subtract(one));
	}

	public BigInteger encrypt(BigInteger plaintext) {
		return plaintext.modPow(pubKey, mod);
	}
	
	public BigInteger encrypt(String plain) {
		return encrypt(new BigInteger(plain.getBytes()));
	}

	public BigInteger decrypt(BigInteger cipher) {
		return cipher.modPow(privKey, mod);
	}
	
	public BigInteger getTotient() {
		return phi;
	}

	public String toString() {
		String s = "";
		s += "public  = " + pubKey  + "\n";
		s += "private = " + privKey + "\n";
		s += "modulus = " + mod;
		return s;
	}

}
