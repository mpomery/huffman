/**
  * Huffman Tree Class
  * Written By: Mitchell Pomery (21130887)
  * Used to create mappings for use in huffman coding
 **/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Compress
{
	/**
	  * main method for the Compress program
	  * @param args the arguments from the command line
	 **/
	public static void main(String [] args) {
		//Timing
		long startTime = System.nanoTime();
		
		if (args.length == 3) {
			if (args[0].equals("-c")) {
				doCompress(args[1], args[2]);
			}
			else if (args[0].equals("-d")) {
				doDecompress(args[1], args[2]);
			}
			else {
				usage();
			}
		}
		else {
			usage();
		}
		
		//More Timing
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("Time Taken: " + (duration/Math.pow(10,9)) + "s");
	}
	
	/**
	  * Prints the usage for the Compress program
	 **/
	private static void usage() {
		System.out.println();
		System.out.println("Usage: java Compress -c input output [-t]");
		System.out.println("OR");
		System.out.println("Usage: java Compress -d input output [-t]");
		System.out.println();
		System.out.println("Options:");
		System.out.println("\t-c\tCompress input file into output file");
		System.out.println("\t-d\tDecompress input file into output file");
		System.out.println();
	}
	
	/**
	  * Compress an input stream into an output stream
	  * @param cin the input stream to compress
	  * @param cout the output stream to write the compressed data to
	 **/
	private static void doCompress(String cin, String cout) {
		File f1 = new File(cin);
		boolean in_exists = f1.exists();
		File f2 = new File(cout);
		boolean out_exists = f2.exists();
		
		if (!in_exists)
			System.out.println("Compression Input file does not exist.");
		else if (out_exists)
			System.out.println("Compression Output file already exists.");
		else {
			try {
				//The only way to reset the input stream to the start seems to
				//be to coles and reopen it
				
				FileInputStream fis1 = new FileInputStream(cin);
				FileInputStream fis2 = new FileInputStream(cin);
				FileOutputStream fos = new FileOutputStream(cout);
				
				///TODO Compress
				Huffman hc = new Huffman();
				hc.compress(fis1, fis2, fos);
				
				fis1.close();
				fis2.close();
				fos.close();
			} catch (FileNotFoundException ex) {
				System.out.println("Error finding one of the files.");
				System.out.println(ex.getMessage());
			} catch (IOException ex) {
				System.out.println("IO Exception");
				System.out.println(ex.getMessage());
			}
		}
	}
	
	/**
	  * Decompress an already compressed input stream into an output stream
	  * @param cin the input stream to decompress
	  * @param cout the output stream to write the decompressed data to
	 **/
	private static void doDecompress(String din, String dout) {
		///TODO impliment Decompress starter
		
		File f1 = new File(din);
		boolean in_exists = f1.exists();
		File f2 = new File(dout);
		boolean out_exists = f2.exists();
		
		if (!in_exists)
			System.out.println("Decompression Input file does not exist.");
		else if (out_exists)
			System.out.println("Decompression Output file already exists.");
		else {
			try {
				//The only way to reset the input stream to the start seems to
				//be to coles and reopen it
				
				FileInputStream fis = new FileInputStream(din);
				FileOutputStream fos = new FileOutputStream(dout);
				
				///TODO Compress
				Huffman hc = new Huffman();
				hc.decompress(fis, fos);
				
				fis.close();
				fos.close();
			} catch (FileNotFoundException ex) {
				System.out.println("Error finding one of the files.");
				System.out.println(ex.getMessage());
			} catch (IOException ex) {
				System.out.println("IO Exception");
				System.out.println(ex.getMessage());
			}
		}
	}
	

}