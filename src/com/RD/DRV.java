package com.RD;

import java.util.Random;

/**
 * Created by Matthew on 12.2.18.
 */
public class DRV {

    public int discreteRV(int[] values, int[] procents) {


        int rand = new Random().nextInt(100);

        int left = 0, right = 0;
        for (int i = 0; i < procents.length; i++) {
            right += procents[i];
            if (rand >= left && rand < right)
                return values[i];
            left = right;
        }

        return 999;
    }
}
