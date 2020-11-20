#!/bin/sh
rm *.o *.dylib
gcc -c dothejob.c | exit 1
gcc -dynamiclib dothejob.o -o libdothejob.dylib | exit 2
cp libdothejob.dylib ../src/main/resources