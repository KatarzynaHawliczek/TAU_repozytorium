#!/bin/sh

cd $(dirname $0)

if [ ! -f hsqldb.jar ]; then
    wget http://puzniakowski.pl/repo/libs/hsqldb.jar
fi

java -cp hsqldb.jar org.hsqldb.util.DatabaseManagerSwing --url jdbc:hsqldb:hsql://localhost/workdb