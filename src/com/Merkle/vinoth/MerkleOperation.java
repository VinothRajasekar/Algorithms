package com.Merkle.vinoth;

import java.math.BigInteger;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class MerkleOperation.
 */
public class MerkleOperation {

	/** The w is the super increasing sequence lists */
	private MerkleLinkedLists w;

	/** The b is the second linked lists to hold the public key material. */
	private MerkleLinkedLists b;

	/** The q is the Big Integer for private and public key. */
	private BigInteger q;

	/** The r is the big integer for private and public key. */
	private BigInteger r;

	/** The input size. */
	private int inputSize = 640;

	/**
	 * Instantiates a new merkle operation.
	 */
	public MerkleOperation() {

		w = new MerkleLinkedLists();
		b = new MerkleLinkedLists();
	}

	/**
	 * Pre Condition : The input size should be less than 80 characters. Post
	 * Condition: The encyrpted number should be single big integer. All Run
	 * Time: Big Theta(n^2)
	 * 
	 * @param the
	 *            text that needs to be encrypted
	 * @returns the encrypted big integer text value.
	 */
	public BigInteger encrypt(byte[] text) {
		if (text.length > 80) {
			return null;

		}

		keyGeneration(text.length * 8);

		BigInteger encryption = new BigInteger("0");
		byte mask = 0x01;

		inputSize = text.length * 8;

		for (int i = 0; i < text.length; i++) {
			byte inputByte = text[i];
			for (int j = 0; j < 8; j++) {
				BigInteger beta = b.getIndex(i * 8 + 7 - j).getData();
				if ((inputByte & (mask << j)) != 0) {
					encryption = encryption.add(beta);
				}
			}
			mask = 0x01;
		}

		return encryption;

	}

	/**
	 * Generated the keys using super increasing sequence
	 * 
	 * @param inputSize
	 *            is passed from the encrypt method.
	 */
	private void keyGeneration(int inputSize) {

		w.addNode(new BigInteger("1"));

		for (int i = 1; i < inputSize; i++) {
			w.addNode(superIncreasingNumber(w));
		}

		q = superIncreasingNumber(w);

		Random random = new Random();

		do {
			r = q.subtract(new BigInteger(random.nextInt(1000) + ""));
		} while ((r.compareTo(new BigInteger("0")) > 0)
				&& (q.gcd(r).intValue() != 1));

		// Generate b such that b = w * r mod q
		for (int i = 0; i < inputSize; i++) {
			b.addNode(w.getIndex(i).getData().multiply(r).mod(q));
		}
	}

	/**
	 * Generates Super increasing number.
	 * 
	 * @param item
	 *            in the list
	 * @return the big integer value
	 */
	private BigInteger superIncreasingNumber(MerkleLinkedLists item) {

		MerkleBigInteger node;
		int i = 0;
		BigInteger sum = new BigInteger("0");

		while ((node = item.getIndex(i)) != null) {
			sum = sum.add(node.getData());
			i++;
		}
		Random random = new Random();

		return sum.add(new BigInteger(random.nextInt(5) + 1 + ""));

	}

	/**
	 * Pre Condition : The encryption keys should be used for decryption. Post
	 * Condition: The method should return the decrpyted value. All Run Time:
	 * Big Theta(n^2)
	 * 
	 * @param the
	 *            encrypted number that needs decryption.
	 * @return the decrypted value.
	 */
	public byte[] decrypt(BigInteger output) {

		BigInteger beta1 = output.mod(q);
		BigInteger beta2 = r.modInverse(q);
		BigInteger beta3 = beta1.multiply(beta2);

		BigInteger value = beta3.mod(q);

		int[] bitMask = new int[inputSize];

		for (int i = inputSize - 1; value.compareTo(new BigInteger("0")) != 0; i--) {
			BigInteger decryptValue = w.getIndex(i).getData();
			if (value.compareTo(decryptValue) >= 0) {
				value = value.subtract(decryptValue);
				bitMask[i] = 1;
			}
		}

		byte[] decrypted = new byte[bitMask.length / 8];
		byte mask = 0x01;

		for (int i = 0; i < bitMask.length; i++) {
			if (bitMask[i] == 1) {
				decrypted[i / 8] = (byte) (decrypted[i / 8] | (mask << (7 - i % 8)));
			}
			mask = 0x01;
		}

		return decrypted;
	}

}