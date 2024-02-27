package dashbah.testinghw4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PutCoin1Test extends TestingVendingMachineTest {

    @Test
    void testPutCoin1InAdminMode() {
        vendingMachine.enterAdminMode(code);
        assertEquals(VendingMachine.Response.ILLEGAL_OPERATION, vendingMachine.putCoin1());
    }

    @Test
    void testPutCoin1WhenCoin1SlotIsFull() {
        vendingMachine.enterAdminMode(code);
        vendingMachine.fillCoins(maxc1, 1); // Заполняем отделение монет 1 вида до максимума
        vendingMachine.exitAdminMode();
        assertEquals(VendingMachine.Response.CANNOT_PERFORM, vendingMachine.putCoin1());
    }

    @Test
    void testPutCoin1WithValidParams() {
        assertEquals(VendingMachine.Response.OK, vendingMachine.putCoin1());
        assertEquals(VendingMachine.coinval1, vendingMachine.getCurrentBalance());
    }
}
