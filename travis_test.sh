#!/bin/sh
echo "Start of script travis_test.sh"
echo "PWD=$PWD"
export OPENDADIR=$PWD/bin
ls -tralala
echo debug1
ls -tralal bin
echo debug2
source bin/settings_local.sh linux
echo debug3


source $OPENDADIR/settings_local.sh linux
echo debug4
env

ant test-travis

