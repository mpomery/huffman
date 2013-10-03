/**
  * Huffman Tree Class
  * Written By: Mitchell Pomery (21130887)
  * Used to create mappings for use in huffman coding
 **/

public class BitByteConverter {
	
	/**
	  * convert a boolean array of length 8 to a byte
	  * @param array the boolean array to convert
	  * @return the byte that the array creates
	 **/
	public static byte booleanArrayToByte(boolean[] array) {
		byte character = 0;
		if (array.length == 8) {
			if (array[0]) {
				character = (byte) (character | 0x80); //Leftmost
			}
			if (array[1]) {
				character = (byte) (character | 0x40);
			}
			if (array[2]) {
				character = (byte) (character | 0x20);
			}
			if (array[3]) {
				character = (byte) (character | 0x10);
			}
			if (array[4]) {
				character = (byte) (character | 0x08);
			}
			if (array[5]) {
				character = (byte) (character | 0x04);
			}
			if (array[6]) {
				character = (byte) (character | 0x02);
			}
			if (array[7]) {
				character = (byte) (character | 0x01);
			}
		}
		else {
			///TODO Throw Exception
		}
		return character;
	}
	
	/**
	  * convert a byte to a boolean array of length 8
	  * @param characterbyte the byte to convert
	  * @return boolean array the byte corresponds to
	 **/
	public static boolean[] byteToBooleanArray(byte characterbyte) {
		boolean[] array = new boolean[8];
		array[0] = ((characterbyte & 0x80) != 0); //Leftmost
		array[1] = ((characterbyte & 0x40) != 0);
		array[2] = ((characterbyte & 0x20) != 0);
		array[3] = ((characterbyte & 0x10) != 0);
		array[4] = ((characterbyte & 0x08) != 0);
		array[5] = ((characterbyte & 0x04) != 0);
		array[6] = ((characterbyte & 0x02) != 0);
		array[7] = ((characterbyte & 0x01) != 0); //Rightmost
		return array;
	}
}