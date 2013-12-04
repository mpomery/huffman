@echo off
cls
echo How This Works:
echo Files in /in/ are compressed to /comp/
echo Files in /comp/ are then decompressed to /deco/
echo Files in /deco/ are then compared to the files in /comp/
echo Disimilar are marked, ones that are the same have compresed and decompressed file sizes compared
echo /comp/ and /deco/ are then emptied
pause
echo TODO: Impliment the above method
:start
del out\*.* /Q
del deco\*.* /Q
cls
echo Compress Testing Script
echo Test


REM for %%i in (in\*) do java Compress -c "%%i" "%%i.z"
REM for %%i in (in\*.z) do java Compress -d "%%i" "%%i.z"



java Compress --help
echo.
echo Test
java Compress -c "in/0.txt" "out/0.z"
java Compress -d "out/0.z" "deco/0.z"
echo.
echo Test
java Compress -c "in/1.pdf" "out/1.z"
java Compress -d "out/1.z" "deco/1.z"
echo.
echo Test
java Compress -c "in/2.pdf" "out/2.z"
java Compress -d "out/2.z" "deco/2.z"
echo.
echo Test
java Compress -c "in/3.pdf" "out/3.z"
java Compress -d "out/3.z" "deco/3.z"
echo.
echo Test
java Compress -c "in/4.pdf" "out/4.z"
java Compress -d "out/4.z" "deco/4.z"
echo.
echo Test
java Compress -c "in/5.txt" "out/5.z"
java Compress -d "out/5.z" "deco/5.z"
echo.
echo Test
java Compress -c "in/6.txt" "out/6.z"
java Compress -d "out/6.z" "deco/6.z"
echo.
echo Test
java Compress -c "in/7.txt" "out/7.z"
java Compress -d "out/7.z" "deco/7.z"
echo.
echo Test
java Compress -c "in/8.txt" "out/8.z"
java Compress -d "out/8.z" "deco/8.z"
echo.
echo Test
java Compress -c "in/9.txt" "out/9.z"
java Compress -d "out/9.z" "deco/9.z"
echo.
echo Test
java Compress -c "in/10.avi" "out/10.z"
java Compress -d "out/10.z" "deco/10.z"
echo.
echo Test
java Compress -c "in/11.mp4" "out/11.z"
java Compress -d "out/11.z" "deco/11.z"
echo.
echo Test
java Compress -c "in/12.txt" "out/12.z"
java Compress -d "out/12.z" "deco/12.z"
echo.
echo Test
java Compress -c "in/13.jpg" "out/13.z"
java Compress -d "out/13.z" "deco/13.z"
echo.
echo Test
java Compress -c "in/14.jpg" "out/14.z"
java Compress -d "out/14.z" "deco/14.z"
echo.
echo Test
java Compress -c "in/15.jpg" "out/15.z"
java Compress -d "out/15.z" "deco/15.z"
echo.
echo Test
java Compress -c "in/16.avi" "out/16.z"
java Compress -d "out/16.z" "deco/16.z"

pause
goto start