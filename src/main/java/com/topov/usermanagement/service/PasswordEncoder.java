package com.topov.usermanagement.service;

import com.topov.usermanagement.exception.UserManagementException;
import com.topov.usermanagement.model.Address;
import com.topov.usermanagement.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

/**
 * Class to perform MD5 hashing of the password before saving it into the database.
 */

@Service
public class PasswordEncoder {
    public String encodePassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(password.getBytes("UTF-8"));
        StringBuilder hashedPassword = new StringBuilder();
        for (byte b : hash) {
            hashedPassword.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));
        }
        return hashedPassword.toString();
    }
}
