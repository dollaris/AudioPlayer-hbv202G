@ECHO OFF

rem ------ ENVIRONMENT --------------------------------------------------------
rem The script depends on various environment variables to exist in order to
rem run properly. The java version we want to use, the location of the java
rem binaries (java home), and the project version as defined inside the pom.xml
rem file, e.g. 1.0-SNAPSHOT.
rem
rem PROJECT_VERSION: version used in pom.xml, e.g. 1.0-SNAPSHOT
rem APP_VERSION: the application version, e.g. 1.0.0, shown in "about" dialog

set JAVA_VERSION=21
set JAVA_HOME=%JAVA_HOME%
set PROJECT_VERSION=1
set APP_VERSION=1
set APP_NAME=Spilari
set MAIN_JAR=AudioPlayer-1.0-SNAPSHOT-jar-with-dependencies.jar

rem ------ SETUP DIRECTORIES AND FILES ----------------------------------------
rem Remove previously generated java runtime and installers. Copy all required
rem jar files into the input/libs folder.

IF EXIST java-runtime rmdir /S /Q  .\java-runtime
IF EXIST installer rmdir /S /Q installer

xcopy /S /Q libs\* installer\input\libs\
copy %MAIN_JAR% installer\input\libs\

rem ------ REQUIRED MODULES ---------------------------------------------------
rem Use jlink to detect all modules that are required to run the application.
rem Starting point for the jdep analysis is the set of jars being used by the
rem application.

echo detecting required modules

"%JAVA_HOME%\bin\jdeps" ^
  --multi-release %JAVA_VERSION% ^
  --ignore-missing-deps ^
  --class-path "AudioPlayer-1.0-SNAPSHOT-jar-with-dependencies.jar" ^
  --print-module-deps classes/hi/project/audioplayer/vidmot/AudioApplication.class classes/hi/project/audioplayer/vidmot/AudioApplication.class > temp.txt

set /p detected_modules=<temp.txt

echo detected modules: %detected_modules%

pause

rem ------ RUNTIME IMAGE ------------------------------------------------------
rem Use the jlink tool to create a runtime image for our application. We are
rem doing this is a separate step instead of letting jlink do the work as part
rem of the jpackage tool. This approach allows for finer configuration and also
rem works with dependencies that are not fully modularized, yet.

echo creating java runtime image

call "%JAVA_HOME%\bin\jlink" ^
  --no-header-files ^
  --no-man-pages ^
  --compress=2 ^
  --strip-debug ^
  --add-modules %detected_modules%,%manual_modules% ^
  --output java-runtime


rem ------ PACKAGING ----------------------------------------------------------

call "%JAVA_HOME%\bin\jpackage" ^
  --type app-image ^
  --dest installer ^
  --input installer/input/libs ^
  --name "%APP_NAME%" ^
  --main-class hi.project.audioplayer.vidmot.AudioApplication ^
  --main-jar %MAIN_JAR% ^
  --java-options -Xmx512m ^
  --runtime-image java-runtime ^
  --app-version %APP_VERSION% ^
  --vendor "Hopur 29" ^

pause
  --copyright "SidelineSports"