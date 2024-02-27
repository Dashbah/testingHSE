package dashbah.testinghw4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestingVendingMachineTest {
    protected VendingMachine vendingMachine;
    protected long code = 117345294655382L;

    protected int max1 = 30;
    protected int max2 = 40;

    protected int maxc1 = 50;
    protected int maxc2 = 50;

    protected int price1 = 8;
    protected int price2 = 5;

    @BeforeEach
    void setUp() {
        vendingMachine = new VendingMachine();
    }
}
