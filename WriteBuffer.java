/**
  * WriteBuffer Class
  * Written By: Mitchell Pomery (21130887)
  * Buffers either bit or byte data and writes it out in bulk amounts
  * Also pads bit data nicely.
 **/

import java.io.OutputStream;
import java.io.IOException;

class WriteBuffer {
	int pos = 0; //the number of bits in the buffer
	boolean[] buffer = new boolean[8];
	byte[] outStream = new byte[12288];
	int outLength = 0; //the number of bytes waiting to be written
	OutputStream out;
	boolean booleandata = true; //If we are expecting bits
	
	/**
	  * Constructs WriteBuffer for writing to the output stream
	  * @param out the output stream to write to
	  * @param bitdata wether or not we are expecting bit data
	 **/
	public WriteBuffer(OutputStream out, boolean bitdata) {
		this.out = out;
		booleandata = bitdata;
	}
	
	/**
	  * write bit data to the output stream
	  * @param b bit data to write
	 **/
	public void write(boolean[] b) throws IOException{
		if (booleandata) {
			for (int i = 0; i < b.length; i++) {
				buffer[pos] = b[i];
				pos++;
				if (pos > 7) {
				//character |= 0x80;
					byte character = BitByteConverter.booleanArrayToByte(buffer);
					pos -= 8;
					outStream[outLength] = character;
					outLength++;
				}
				if (outLength > 12200) {
					out.write(outStream, 0, outLength);
					outLength = 0;
				}
			}
		}
	}
	
	/**
	  * write an array of bytes to the output stream
	  * @param b byte array to write
	 **/
	public void write(byte[] b) throws IOException{
		if (!booleandata) {
			for (int i = 0; i < b.length; i++) {
				outStream[outLength] = b[i];
				outLength++;
				if (outLength > 12200) {
					out.write(outStream, 0, outLength);
					outLength = 0;
				}
			}
		}
	}
	
	/**
	  * write a single byte to the output stream
	  * @param b byte to write
	 **/
	public void write(byte b) throws IOException{
		if (!booleandata) {
			outStream[outLength] = b;
			outLength++;
			if (outLength > 12200) {
				out.write(outStream, 0, outLength);
				outLength = 0;
			}
		}
	}
	
	/**
	  * pads the final output with 0's and writes to the output stream
	  * then puts 1 however many times 0 was used to pad in the previous8 bits
	**/
	public void flush() throws IOException{
		if (booleandata) {
			boolean[] padding = new boolean[8 + (8 - pos)];
			int poscopy = pos;
			while (poscopy < 8) {
				padding[padding.length - (poscopy + 1)] = true;
				poscopy++;
			}
			write(padding);
		}
		out.write(outStream, 0, outLength);
		outLength = 0;
	}
}