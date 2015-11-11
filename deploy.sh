#!/bin/bash

#author Gabor Kokeny
#created 2015. november 10.

echo "--------------------------------------------------------------------------"
echo '-- Deploy to Tomcat';
echo "--------------------------------------------------------------------------"

pwd=`pwd`
deployDir="$CATALINA_HOME/webapps"
tomcat="$CATALINA_HOME/bin"

echo "Java home:       $JAVA_HOME";
echo "Tomcat home:     $CATALINA_HOME";
echo "Gradle home:     $GRADLE_HOME";
echo "Build directory: $pwd";
echo "Deploy dir:      $deployDir"
echo "--------------------------------------------------------------------------"
echo "-- Build war file..."
echo "--------------------------------------------------------------------------"
gradle build
ls -l "$pwd/build/libs"


echo "--------------------------------------------------------------------------"
echo "-- Deploy war file..."
echo "--------------------------------------------------------------------------"

echo "Stopping Tomcat server..."
$tomcat/shutdown.sh

#Undeploy war files
rm "$deployDir/chesscloud.war"
rm -R "$deployDir/chesscloud"

#Copy war file into deploy directory
cp "$pwd/build/libs/chesscloud.war" "$deployDir/chesscloud.war"

echo "Start Tomcat server..."
$tomcat/catalina.sh run
