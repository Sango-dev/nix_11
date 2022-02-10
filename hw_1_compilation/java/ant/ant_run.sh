#!/bin/sh
. ./setantenv.sh
cd ./app
ant delete compile jar run
