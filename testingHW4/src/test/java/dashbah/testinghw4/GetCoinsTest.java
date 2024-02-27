package dashbah.testinghw4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetCoinsTest extends TestingVendingMachineTest {

    @Test
    void testGetCoins1InOperationMode() {
        assertEquals(0, vendingMachine.getCoins1());
    }

    @Test
    void testGetCoins2InOperationMode() {
        assertEquals(0, vendingMachine.getCoins2());
    }


    @Test
    void testGetCoins1InAdminModeAfterFilling() {
        vendingMachine.enterAdminMode(code);
        vendingMachine.fillCoins(10, 5); // Заполнение монетами
        assertEquals(10, vendingMachine.getCoins1());
    }

    @Test
    void testGetCoins1InAdminModeAfterFillingInNonOperationMode() {
        vendingMachine.enterAdminMode(code);
        vendingMachine.fillCoins(10, 5); // Заполнение монетами
        vendingMachine.exitAdminMode();
        assertEquals(0, vendingMachine.getCoins1());
    }

    @Test
    void testGetCoins2InAdminModeAfterFilling() {
        vendingMachine.enterAdminMode(code);
        vendingMachine.fillCoins(10, 5); // Заполнение монетами
        assertEquals(5, vendingMachine.getCoins2());
    }

    @Test
    void testGetCoins2InAdminModeAfterFillingInNonOperationMode() {
        vendingMachine.enterAdminMode(code);
        vendingMachine.fillCoins(10, 5); // Заполнение монетами
        vendingMachine.exitAdminMode();
        assertEquals(0, vendingMachine.getCoins2());
    }

}
