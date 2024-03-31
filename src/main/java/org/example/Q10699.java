package org.example;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Q10699 {

    public static void main(String[] args) throws IOException {

        Date today = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(dateFormat.format(today));
    }

}
