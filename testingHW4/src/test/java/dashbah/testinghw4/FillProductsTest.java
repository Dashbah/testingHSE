package dashbah.testinghw4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FillProductsTest extends TestingVendingMachineTest {

    @Test
    void testFillProductsInOperationMode() {
        assertEquals(VendingMachine.Response.ILLEGAL_OPERATION, vendingMachine.fillProducts());
    }

    @Test
    void testFillProductsInAdminMode() {
        vendingMachine.enterAdminMode(code);
        assertEquals(VendingMachine.Response.OK, vendingMachine.fillProducts());
        assertEquals(max1, vendingMachine.getNumberOfProduct1());
        assertEquals(max2, vendingMachine.getNumberOfProduct2());
    }

}
