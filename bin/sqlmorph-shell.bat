@echo off
setlocal
if "%~1"=="" (
    echo Usage: sqlmorph-shell.bat ^<project-directory^> 1>&2
    exit /b 2
)
if not "%~2"=="" (
    echo Usage: sqlmorph-shell.bat ^<project-directory^> 1>&2
    exit /b 2
)
set "SCRIPT_DIR=%~dp0"
set "INIT=%SCRIPT_DIR%..\jshell\init.jsh"
set "SQLMORPH_JAR=%SCRIPT_DIR%..\lib\sqlmorph.jar"
set "LOGGER_JAR=%SCRIPT_DIR%..\lib\slf4j-nop.jar"

jshell "-R-Dsqlmorph.project=%~f1" --class-path "%SQLMORPH_JAR%;%LOGGER_JAR%" --startup "%INIT%" --feedback sqlmorph
exit /b %errorlevel%
