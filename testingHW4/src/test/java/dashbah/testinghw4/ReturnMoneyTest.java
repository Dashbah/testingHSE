package dashbah.testinghw4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReturnMoneyTest extends TestingVendingMachineTest {

    @BeforeEach
    void fillProducts() {
        vendingMachine.enterAdminMode(code);
        vendingMachine.fillProducts();
        vendingMachine.exitAdminMode();
    }

    @Test
    void testReturnMoneyWithNoBalance() {
        assertEquals(VendingMachine.Response.OK, vendingMachine.returnMoney());
    }

    @Test
    void testReturnMoneyWithNotEnoughSecondCoins() {
        vendingMachine.putCoin2();
        for (int i = 0; i < 6; ++i) {
            vendingMachine.putCoin1();
        }
        vendingMachine.giveProduct2(1);
        assertEquals(VendingMachine.Response.OK, vendingMachine.returnMoney());
        assertEquals(5, vendingMachine.getCoins1());
        assertEquals(0, vendingMachine.getCoins2());
    }

    @Test
    void testReturnMoneyWithOddBalance() {
        vendingMachine.putCoin2();
        vendingMachine.putCoin2();
        for (int i = 0; i < 3; ++i) {
            vendingMachine.putCoin1();
        }
        vendingMachine.giveProduct2(1);
        assertEquals(VendingMachine.Response.OK, vendingMachine.returnMoney());
        assertEquals(3, vendingMachine.getCoins1());
        assertEquals(1, vendingMachine.getCoins2());
    }

    @Test
    void testReturnMoneyWithNoCoin1AndOddBalance() {
        vendingMachine.putCoin2();
        vendingMachine.putCoin2();
        vendingMachine.putCoin2();
        vendingMachine.giveProduct2(1); // Покупаем продукт с нечетным балансом без монет 1 вида
        assertEquals(VendingMachine.Response.UNSUITABLE_CHANGE, vendingMachine.returnMoney());
    }

    @Test
    void testReturnMoneyWithEnoughCoins() {
        for (int i = 0; i < 2; ++i) {
            vendingMachine.putCoin1();
        }
        for (int i = 0; i < 4; ++i) {
            vendingMachine.putCoin2();
        }
        vendingMachine.giveProduct2(1);
        assertEquals(VendingMachine.Response.OK, vendingMachine.returnMoney());
        assertEquals(1, vendingMachine.getCoins1());
        assertEquals(2, vendingMachine.getCoins2());
    }
}
