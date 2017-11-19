package com.lonelyyhu.exercise.customlistview.data;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hulonelyy on 2017/11/18.
 */

public class Letters {

    public static final String[] UPPER_CASE_LETTER = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static final String[] LOWER_CASE_LETTER = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public static List<LetterModel> getLetters() {
        List<LetterModel> letterModels = new ArrayList<>();

        for (int i = 0; i < Letters.LOWER_CASE_LETTER.length; i++) {

            LetterModel model = new LetterModel(Letters.UPPER_CASE_LETTER[i], Letters.LOWER_CASE_LETTER[i]);
            letterModels.add(model);

        }

        return letterModels;
    }

}
