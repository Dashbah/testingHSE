package ru.hse;

import calc.Calc;
import calc.CalcException;
import com.code_intelligence.jazzer.api.FuzzedDataProvider;

public class CalcBigNumberFuzzTarget {
    public static void fuzzerTestOneInput(FuzzedDataProvider data){
        Integer left = data.consumeInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        Integer right = data.consumeInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        try {
            String input;
            try {
                input = Calc.opn(left.toString() + "+" + right.toString());
            } catch (Exception e) {
                return;
            }
            Calc.calculate(input);
        }
        catch (CalcException ignored) {
        }
    }
}
