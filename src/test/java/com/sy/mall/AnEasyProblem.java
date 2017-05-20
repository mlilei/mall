package com.sy.mall;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by acm on 2017/5/18.
 */
public class AnEasyProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int q = 0;
        BigInteger m;
        int[] a = new int[11111];
        int[] b = new int[11111];
        for (int t = 1; t <= T; t++) {
            System.out.println("Case #" + t + ":");
            q = scanner.nextInt();
            m = scanner.nextBigInteger();
            BigInteger res = new BigInteger("1");
            for (int i = 1; i <= q; i++) {
                a[i] = scanner.nextInt();
                b[i] = scanner.nextInt();
                if (a[i] == 1) {
                    res = res.multiply(new BigInteger(String.valueOf(b[i])));
                } else {
                    res = res.divide(new BigInteger(String.valueOf(b[b[i]])));
                }
                System.out.println(res.mod(m));
            }
        }
    }
}
