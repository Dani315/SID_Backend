package com.sid.app.sistema_informacion_digital.Helpers;

import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

@Component
public class GenerateAlphaNumericString {

    public String getRandomString(int i) {

        byte[] bytearray;
        // bind the length
        bytearray = new byte[256];
        String mystring;
        StringBuilder thebuffer;
        String theAlphaNumericS;

        new Random().nextBytes(bytearray);

        mystring
                = new String(bytearray, StandardCharsets.UTF_8);

        thebuffer = new StringBuilder();

        //remove all spacial char
        theAlphaNumericS
                = mystring
                .replaceAll("[^A-Z0-9]", "");

        //random selection
        for (int m = 0; m < theAlphaNumericS.length(); m++) {

            if (Character.isLetter(theAlphaNumericS.charAt(m))
                    && (i > 0)
                    || Character.isDigit(theAlphaNumericS.charAt(m))
                    && (i > 0)) {

                thebuffer.append(theAlphaNumericS.charAt(m));
                i--;
            }
        }

        // the resulting string
        return thebuffer.toString();

    }
}
