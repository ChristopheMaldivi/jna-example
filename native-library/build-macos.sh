#!/bin/sh
rm -f *.o *.dylib
gcc -Wall -c dothejob.c | exit 1
gcc -dynamiclib dothejob.o -o libdothejob.dylib | exit 2
cp libdothejob.dylib ../src/main/resources | exit 3
rm -f *.o *.dylib
