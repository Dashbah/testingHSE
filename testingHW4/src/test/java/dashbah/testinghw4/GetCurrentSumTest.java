package dashbah.testinghw4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GetCurrentSumTest extends TestingVendingMachineTest {

    @Test
    void testGetCurrentSumInOperationMode() {
        assertEquals(0, vendingMachine.getCurrentSum());
    }

    @Test
    void testGetCurrentSumInAdminModeWithZeroCoins() {
        vendingMachine.enterAdminMode(code);
        assertEquals(0, vendingMachine.getCurrentSum());
    }

    @Test
    void testGetCurrentSumInAdminModeWithNonZeroCoins() {
        vendingMachine.enterAdminMode(code);
        vendingMachine.fillCoins(10, 5);
        assertEquals(20, vendingMachine.getCurrentSum());
    }

    @Test
    void testGetCurrentSumInAdminModeWithNonZeroCoinsInNonOperationMode() {
        vendingMachine.enterAdminMode(code);
        vendingMachine.fillCoins(10, 5);
        vendingMachine.exitAdminMode();
        assertEquals(0, vendingMachine.getCurrentSum());
    }
}
