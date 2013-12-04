#Huffman Compression

##Code Overview

###Compressed File Format

The compressed file want to be as small as possible. It needs to hold the binary tree in a reconstrucatble form so we can traverse it while decompressing. After the binary tree we need the compressed data. At the end of the compressed data we require some padding bits that we can recognise as the compressed data may not fill bytes.

####Binary Tree

    Binary Tree as 1's and 0's
    000101111
    Makes the binary Tree
                   0
                0     0
              1   0  1 1
                 1 1
        As letters
                   0
                0     0
              a   0  b c
             d e
        Read the binary tree until we get down to a level containing all ones
        keep count of the number of ones we see. this is called "z"
    
    Characters shown in the binary tree
    XXXXXXXX repeated z times

####Compressed Data
* Unknown length
* Traverse the binary tree until we hit a hex value, then write that to the uncompressed output stream

####Padding Bits
8 bits. Each on bit counts the number of bits prior to this byte to ignore.

##Project Overview

Your task is to implement lossless data compression/decompression algorithms in java and to analyse their performance. Compression and decompression algorithms are used frequently in applications such as zip, gzip, winzip, compress, and well as in computer networks and various data formats.

This assignment can be done in pairs, although you may work on your own if you prefer.

This assignment is worth 20% of your final grade, and consists of:

10% - Java classes and source files, to be submitted to cssubmit
10% - Written report, to be submitted at the front office.
Your implementation should consist of a set of java classes including one the implements the compressor interface in the CITS2200 package. This class accepts an InputStream and OutputStream as parameters and will write a compressed version of the input stream to the output stream.

A basic example is available. The class RLE is an implementation of a very basic compression algorithm called Run-length Encoding, which hardly ever works (unless you combine it with the Burrows Wheeler Transform, or something similar). This should give you an idea how to handle IO, command line parameters etc. There is also an inner class called WriteBuffer, which can be used to buffer bits (so if you only want to write 3 bits at a time, it will store them until you have at least 8 bits to write, and then output a byte). This code has not been well tested, so please feel free to ask questions, or make suggestions on the discussion forum.

Your program should be able to be run from the command line, accepting input and output files as parameters. For example,

    java Compress -c file.txt file.z

may run your compression program on file.txt to produce file.z, and

    java Compress -d file.z file2.txt

may run your decompression algorithm on file.z to output the file file2.txt which is identical to file.txt. Your program should also be designed to give good compression rates on common file formats, including text files, class files and pdfs.

###Compression Algorithms

There is a research component to this project. You are required to investigateexisting lossless compression algorithms and choose one, or more to implement. In the workshops we will discuss the Huffman Compression algorithm, and the these notes cover Huffman and LZ algorithms.
Other potential algorithms include run-length encoding, range coding, and the Burrows Wheeler transform.

###Assessment

#####The report is worth 10% of your final grade and should consist of the following parts:

* A description of the algorithm used (both in English and psuedo-code) (25%)
* A description of your implmentation, including private methods (25%)
* A theoretical analysis of the complexity of the algorithms and data structures used (25%)
* Experimental analysis of the efficiency of your programs in terms of the compression achieved and the time taken (25%)

*The report should not be more than 5 pages.*

#####The marking scheme for the software is as follows:

* Correctness (i.e. decompressing a compressed file returns the original file) 50%
* Efficiency (compression rate achieved, and time taken) 25%
* Programming Style (use of object oriented design, commenting, etc) 25%

Note, your report should also reference all resources used to complete your assignment. The project should be submitted using cssubmit, as well as submitting a hardcopy of the report to the CSSE office. As the semester proceeds, your ongoing marks will be updated regularly and stored in a database that you can check by using the csmarks program.
