@echo off
:start
cls
echo Compiling
javac -cp CITS2200.jar Compress.java Huffman.java HuffmanTree.java BitByteConverter.java WriteBuffer.java
move /Y *.class compiled/
echo.
echo Compiled
pause
goto start