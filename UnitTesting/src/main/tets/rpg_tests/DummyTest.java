package rpg_tests;

import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

import static org.junit.jupiter.api.Assertions.*;

public class DummyTest {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 13;
    private static final int DUMMY_HEALTH = 15;
    private static final int DUMMY_EXPERIENCE = 5;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp() {
        axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void dummyLosesHealthWhenAttacked() {
        dummy.takeAttack(AXE_ATTACK);
        assertEquals(DUMMY_HEALTH - AXE_ATTACK, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsExceptionWhenAttacked() {
        dummy.takeAttack(15);
        dummy.takeAttack(AXE_ATTACK);
    }

    @Test
    public void deadDummyShouldGiveExperience() {
        dummy = new Dummy(0, DUMMY_EXPERIENCE);
        dummy.giveExperience();
        assertEquals(DUMMY_EXPERIENCE, dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCanNotGiveExperience() {
        dummy.giveExperience();
    }
}