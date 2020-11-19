package org.tof.example;

public class JNAExample {

  public static void main(String... args) {
      final String returnedValue = new DoTheJob().doTheJob();
      System.out.println(returnedValue);
  }
}
