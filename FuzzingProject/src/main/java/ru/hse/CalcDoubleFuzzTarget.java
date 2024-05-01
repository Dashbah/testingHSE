package ru.hse;

import calc.Calc;
import calc.CalcException;
import com.code_intelligence.jazzer.api.FuzzedDataProvider;

public class CalcDoubleFuzzTarget {
    public static void fuzzerTestOneInput(FuzzedDataProvider data){
        Double left = data.consumeDouble();
        Double right = data.consumeDouble();
        try {
            String input;
            try {
                input = Calc.opn(left.toString() + "/" + right.toString());
            } catch (Exception e) {
                return;
            }
            Calc.calculate(input);

            try {
                input = Calc.opn(left.toString() + "*" + right.toString());
            } catch (Exception e) {
                return;
            }
            Calc.calculate(input);
        }
        catch (CalcException ignored) {
        }
    }
}
