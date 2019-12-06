package com.ds.algorithms;

import java.util.Arrays;

public class PokerContinuous {
    public boolean isContinuous(int [] numbers) {
        Arrays.sort(numbers);
        if (numbers==null || numbers.length == 0 )
            return false;
        for (int i=1; i<numbers.length; ++i){
            if (numbers[i] != numbers[i-1]+1)
                return false;
        }
        return true;

    }
}
