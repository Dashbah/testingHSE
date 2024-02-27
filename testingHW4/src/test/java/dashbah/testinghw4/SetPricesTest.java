package dashbah.testinghw4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetPricesTest extends TestingVendingMachineTest {

    @Test
    void testSetPricesInOperationMode() {
        assertEquals(VendingMachine.Response.ILLEGAL_OPERATION, vendingMachine.setPrices(10, 20));
    }

    @Test
    void testSetPricesWithInvalidParams1() {
        vendingMachine.enterAdminMode(code);
        assertEquals(VendingMachine.Response.INVALID_PARAM, vendingMachine.setPrices(-1, 20));
    }

    @Test
    void testSetPricesWithInvalidParams2() {
        vendingMachine.enterAdminMode(code);
        assertEquals(VendingMachine.Response.INVALID_PARAM, vendingMachine.setPrices(10, -1));
    }

    @Test
    void testSetPricesWithValidParams() {
        vendingMachine.enterAdminMode(code);
        assertEquals(VendingMachine.Response.OK, vendingMachine.setPrices(10, 20));
        assertEquals(10, vendingMachine.getPrice1());
        assertEquals(20, vendingMachine.getPrice2());
    }
}
