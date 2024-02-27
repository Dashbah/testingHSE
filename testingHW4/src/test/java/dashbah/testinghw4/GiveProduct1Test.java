package dashbah.testinghw4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GiveProduct1Test extends TestingVendingMachineTest {

    @Test
    void testGiveProduct1InAdminMode() {
        vendingMachine.enterAdminMode(code);
        assertEquals(VendingMachine.Response.ILLEGAL_OPERATION, vendingMachine.giveProduct1(1));
    }

    @Test
    void testGiveProduct1WithInvalidParams1() {
        assertEquals(VendingMachine.Response.INVALID_PARAM, vendingMachine.giveProduct1(-1));
    }

    @Test
    void testGiveProduct1WithInvalidParams2() {
        assertEquals(VendingMachine.Response.INVALID_PARAM, vendingMachine.giveProduct1(0));
    }

    @Test
    void testGiveProduct1WithInvalidParams3() {
        assertEquals(VendingMachine.Response.INVALID_PARAM, vendingMachine.giveProduct1(max1 + 1));
    }

    @Test
    void testGiveProduct1WithInsufficientMoney() {
        vendingMachine.enterAdminMode(code);
        vendingMachine.fillProducts();
        vendingMachine.exitAdminMode();
        vendingMachine.putCoin1();
        assertEquals(VendingMachine.Response.INSUFFICIENT_MONEY, vendingMachine.giveProduct1(2));
    }

    @Test
    void testGiveProduct1WithSuitableChange() {
        vendingMachine.enterAdminMode(code);
        vendingMachine.fillProducts();
        vendingMachine.exitAdminMode();
        vendingMachine.putCoin1();
        vendingMachine.putCoin2();
        vendingMachine.putCoin2();
        vendingMachine.putCoin2();
        vendingMachine.putCoin2();
        assertEquals(VendingMachine.Response.OK, vendingMachine.giveProduct1(1));
    }

}
