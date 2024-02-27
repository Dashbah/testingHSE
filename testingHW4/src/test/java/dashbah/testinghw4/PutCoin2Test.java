package dashbah.testinghw4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PutCoin2Test extends TestingVendingMachineTest {

    @Test
    void testPutCoin2InAdminMode() {
        vendingMachine.enterAdminMode(code);
        assertEquals(VendingMachine.Response.ILLEGAL_OPERATION, vendingMachine.putCoin2());
    }

    @Test
    void testPutCoin2WhenCoin2SlotIsFull() {
        vendingMachine.enterAdminMode(code);
        vendingMachine.fillCoins(1, maxc2); // Заполняем отделение монет 2 вида до максимума
        vendingMachine.exitAdminMode();
        assertEquals(VendingMachine.Response.CANNOT_PERFORM, vendingMachine.putCoin2());
    }

    @Test
    void testPutCoin2WithValidParams() {
        assertEquals(VendingMachine.Response.OK, vendingMachine.putCoin2());
        assertEquals(VendingMachine.coinval2, vendingMachine.getCurrentBalance());
    }
}
