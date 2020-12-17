package org.tof.example;

public class JNAExample {

  public static void main(String... args) {
      final String returnedValue = DoTheJob.doTheJobNative();
      System.out.println(returnedValue);
  }
}
