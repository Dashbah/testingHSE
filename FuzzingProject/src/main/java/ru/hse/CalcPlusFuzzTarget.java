package ru.hse;
import calc.Calc;
import calc.CalcException;
import com.code_intelligence.jazzer.api.FuzzedDataProvider;

public class CalcPlusFuzzTarget {
    public static void fuzzerTestOneInput(FuzzedDataProvider data){
        Integer left = data.consumeInt(-1500, 1500);
        Integer right = data.consumeInt(-1500, 1500);
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
