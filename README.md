We demonstrate here the use of JNA, the java native access library, with two simple functions:
 - `String doTheJobNative()` which simply returns "it works!" from native side
 - `int doTheJobArrayNative(byte[] inputArray, int[] outputArray, int arraySize)` which plays with array reading and writing


We use the "Direct Method Mapping" to optimize native calls duration.

## Build and run
 - build the native library (mac and linux are supported): `(cd native-library/ && ./build-linux.sh)`
 - run the tests on java side: `mvn clean install`

NB: you need java 11 at least to get performance measures working (relies on `Instant` class)
