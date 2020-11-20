#!/bin/sh
rm -f *.o *.so
gcc -c dothejob.c | exit 1
gcc -shared dothejob.o -o libdothejob.so | exit 2
cp libdothejob.so ../src/main/resources | exit 3
rm -f *.o *.so

