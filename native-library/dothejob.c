char * doTheJobNative() {
    return "it works";
}

int doTheJobArrayNative(unsigned char inputArray[], int outputArray[], int arraySize) {
    for(int i=0; i < arraySize; i++) {
        outputArray[i]= inputArray[i]*2;
    }
    return arraySize;
}
