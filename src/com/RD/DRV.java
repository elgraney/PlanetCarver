package com.RD;

import java.util.Random;

/**
 * Created by Matthew on 12.2.18.
 */
public class DRV {

    public static int discreteRV(int[] values, int[] chance) {


        int rand = new Random().nextInt(100);

        int left = 0, right = 0;
        for (int i = 0; i < chance.length; i++) {
            right += chance[i];
            if (rand >= left && rand < right)
                return values[i];
            left = right;
        }

        return 999;
    }
}
