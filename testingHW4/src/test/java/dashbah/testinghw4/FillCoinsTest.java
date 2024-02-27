package dashbah.testinghw4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FillCoinsTest  extends TestingVendingMachineTest {

    @Test
    void testFillCoinsInOperationMode() {
        assertEquals(VendingMachine.Response.ILLEGAL_OPERATION, vendingMachine.fillCoins(10, 10));
    }

    @Test
    void testFillCoinsWithInvalidParams1() {
        vendingMachine.enterAdminMode(code);
        assertEquals(VendingMachine.Response.INVALID_PARAM, vendingMachine.fillCoins(-1, 10));
    }

    @Test
    void testFillCoinsWithInvalidParams2() {
        vendingMachine.enterAdminMode(code);
        assertEquals(VendingMachine.Response.INVALID_PARAM, vendingMachine.fillCoins(10, -1));
    }

    @Test
    void testFillCoinsWithExceedingMax1() {
        vendingMachine.enterAdminMode(code);
        assertEquals(VendingMachine.Response.INVALID_PARAM, vendingMachine.fillCoins(maxc1 + 1, 10));
    }

    @Test
    void testFillCoinsWithExceedingMax2() {
        vendingMachine.enterAdminMode(code);
        assertEquals(VendingMachine.Response.INVALID_PARAM, vendingMachine.fillCoins(10, maxc2 + 1));
    }

    @Test
    void testFillCoinsWithValidParams() {
        vendingMachine.enterAdminMode(code);
        assertEquals(VendingMachine.Response.OK, vendingMachine.fillCoins(10, 5));
        assertEquals(10, vendingMachine.getCoins1());
        assertEquals(5, vendingMachine.getCoins2());
    }
}
