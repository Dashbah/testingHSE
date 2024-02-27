package dashbah.testinghw4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnterAdminModeTest extends TestingVendingMachineTest {

    @Test
    void testEnterAdminModeWithCorrectCodeAndZeroBalance() {
        assertEquals(VendingMachine.Response.OK, vendingMachine.enterAdminMode(code));
        assertEquals(VendingMachine.Mode.ADMINISTERING, vendingMachine.getCurrentMode());
    }

    @Test
    void testEnterAdminModeWithIncorrectCodeAndZeroBalance() {
        assertEquals(VendingMachine.Response.INVALID_PARAM, vendingMachine.enterAdminMode(9999));
        assertEquals(VendingMachine.Mode.OPERATION, vendingMachine.getCurrentMode());
    }

    @Test
    void testEnterAdminModeWithCorrectCodeAndNonZeroBalance() {
        vendingMachine.putCoin1(); // Добавляем монету
        assertEquals(VendingMachine.Response.CANNOT_PERFORM, vendingMachine.enterAdminMode(code));
        assertEquals(VendingMachine.Mode.OPERATION, vendingMachine.getCurrentMode());
    }
}
