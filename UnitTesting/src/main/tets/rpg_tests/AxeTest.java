package rpg_tests;

import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

import static org.junit.Assert.*;

public class AxeTest {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 13;
    private static final int DUMMY_HEALTH = 8;
    private static final int DUMMY_EXPERIENCE = 5;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp() {
        axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void weaponAttacksLosesDurability() {
        axe.attack(dummy);
        assertEquals(AXE_DURABILITY - 1, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void atackWithBrokenWeapon() {
        axe = new Axe(AXE_ATTACK, 0);
        axe.attack(dummy);
        assertEquals(0, axe.getDurabilityPoints());
    }
}
