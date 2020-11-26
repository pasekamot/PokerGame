@ECHO OFF
ECHO 			************	Poker Five-Hand-draw Game	************
ECHO 			************************************************************					
ECHO 			Pass arguments as follows: run = To run the game.
ECHO 						compile = To compile it.
ECHO 						test = To run unit tests
ECHO				************************************************************					
ECHO				************************************************************

if "%1" == "compile" mvn clean install

if "%1" == "test" mvn test

if "%1" == "play" java -cp target/PokerGame-1.0-SNAPSHOT.jar Main


