package com.company;

import java.util.Random;

public class Calculator {
    public static final int limit = 10_000_000;
    private static Random randomNumber = new Random();
    private static Random randomSign = new Random();

    public static StringBuilder createExpression() {

        StringBuilder builder = new StringBuilder(randomNumber.nextInt(100) + getSign(randomSign.nextInt(2)));

        for (int i = 0; i<limit-1; i++) {
            builder.append(randomNumber.nextInt(101) + getSign(randomSign.nextInt(2)));
        }
        builder.append(randomNumber.nextInt(101));
        return builder;
    }

    public static StringBuilder createExpressionMulti() {
        StringBuilder builder = new StringBuilder(randomNumber.nextInt(100) + getSign(randomSign.nextInt(2)));

        for (int i = 0; i<limit/100 - 1; i++) {
            builder.append(randomNumber.nextInt(101) + getSign(randomSign.nextInt(2)));
        }
        builder.append(randomNumber.nextInt(101));
        return builder;
    }

    private static String getSign(int num) {
        if (num == 0)
            return "+";
        return "-";
    }

    public static long calculateExpression(StringBuilder builder) {
        int i = 0;
        int res = 0;
        while (i<builder.length()) {
            var ch = String.valueOf(builder.charAt(i));
            String s = "";
            var sign = "";

            if (i==0)
                sign = "+";
            else
            {
                if (ch.equals("-") || ch.equals("+")) {
                    sign = ch;
                    i++;
                    ch=String.valueOf(builder.charAt(i));
                }
            }

            while ((i<builder.length()) && ((!ch.equals("-") && !ch.equals("+")))) {
                s+=ch;
                i++;
                if (i!=builder.length())
                    ch=String.valueOf(builder.charAt(i));
            }

            int num = Integer.parseInt(s);
            if (sign.equals("-"))
                res-=num;
            else
                res+=num;

        }
    return res;
    }
}




























