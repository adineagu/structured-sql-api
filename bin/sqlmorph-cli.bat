@echo off
set SCRIPT_DIR=%~dp0
set INIT=%SCRIPT_DIR%..\jshell\boot.jsh
set SQLMORPH_JAR=%SCRIPT_DIR%..\lib\sqlmorph.jar
set LOGGER_JAR=%SCRIPT_DIR%..\lib\slf4j-nop.jar

java -cp "%SQLMORPH_JAR%;%LOGGER_JAR%" org.pecheasoft.odigen.repl.Main %1