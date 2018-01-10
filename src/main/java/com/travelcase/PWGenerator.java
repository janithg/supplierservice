package com.travelcase;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PWGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("a123"));
    }
}
