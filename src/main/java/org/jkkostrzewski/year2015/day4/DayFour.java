package org.jkkostrzewski.year2015.day4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DayFour {
    public static String partOne(final String input) throws NoSuchAlgorithmException {
        final MessageDigest md5 = MessageDigest.getInstance("MD5");
        int hashingNumber = -1;
        boolean hashFound = false;
        String hash = "";

        while (!hashFound) {
            hashingNumber++;
            String nextInput = input + hashingNumber;
            md5.update(nextInput.getBytes());
            byte[] digest = md5.digest();
            final StringBuilder result = new StringBuilder();
            for (byte b : digest) {
                result.append(String.format("%02X", b));
            }
            hash = result.toString();

            if (hash.startsWith("00000")) hashFound = true;
        }

        System.out.println(hashingNumber);
        return hash.toLowerCase();
    }

    public static String partTwo(final String input) throws NoSuchAlgorithmException {
        final MessageDigest md5 = MessageDigest.getInstance("MD5");
        int hashingNumber = -1;
        boolean hashFound = false;
        String hash = "";

        while (!hashFound) {
            hashingNumber++;
            String nextInput = input + hashingNumber;
            md5.update(nextInput.getBytes());
            byte[] digest = md5.digest();
            final StringBuilder result = new StringBuilder();
            for (byte b : digest) {
                result.append(String.format("%02X", b));
            }
            hash = result.toString();

            if (hash.startsWith("000000")) hashFound = true;
        }

        System.out.println(hashingNumber);
        return hash.toLowerCase();
    }


    public static void main(String[] args) throws NoSuchAlgorithmException {
        final String input = "bgvyzdsv";

        System.out.println(partOne(input));
        System.out.println(partTwo(input));
    }
}
