#!/bin/bash

# This script will automatically detect if the targeted
# .jar file exists and create a bash alias in the bash
# configuration file(~/.bashrc)

# As a result, the user will be able to launch the program
# from their command line

LOCATION_JAR=""

# Find location of the .jar file
# Assign the full path of the file to var LOCATION_JAR
function find_jar(){
  if [ -e "./Pick-a-Stone.jar" ];then
    LOCATION_JAR=$(pwd)"/Pick-a-Stone.jar"
  else
    echo "Pick-a-Stone.jar not found"
    exit
  fi
}

# Bruteforce approach
# Add an alias of the program to bashrc
function add_bashrc(){
  local home=~
  local bashrc="$home/.bashrc"
  if [ -e "$home/.bashrc" ];then
    echo >> "$bashrc"
    echo "# Alias to launch pick a stone" >> "$bashrc"
    echo "alias pick-a-stone='java -jar $LOCATION_JAR'" >> "$bashrc"
  else
    touch "~/.bashrc"
    add_bashrc
  fi
}

echo "Installing Pick-a-Stone"
find_jar
add_bashrc
source ~/.bashrc
echo "Bash alias entry created. Type pick-a-stone to launch the program"
