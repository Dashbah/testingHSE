package ru.hse;

import calc.Calc;
import calc.CalcException;
import com.code_intelligence.jazzer.api.FuzzedDataProvider;

public class CalcFuzzingTarget {
    public static void fuzzerTestOneInput(FuzzedDataProvider data){
        String input = data.consumeRemainingAsString();
        try {
            String input1;
            try {
                input1 = Calc.opn(input);
            } catch (Exception e) {
                return;
            }
            Calc.calculate(input1);
        }
        catch (CalcException ignored) {
        }
    }
}
