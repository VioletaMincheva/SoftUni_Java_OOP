package p03_IteratorTest;

import org.junit.*;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

    private static final String[] ELEMENTS = {"wood", "chair", "table"};
    private ListIterator listIterator;

    @Before
    public void setUp() throws OperationNotSupportedException {
        listIterator = new ListIterator(ELEMENTS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_elementsPassedToConstructorAreNull_then_exceptionIsThrown() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void when_elementsPassedToConstructor_then_moveReturnCorrectBoolean() {
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void when_collectionIsEmpty_then_exceptionIsThrown() throws OperationNotSupportedException {
        new ListIterator().print();
    }

    @Test
    public void when_collectionIsNotEmpty_then_print() {
        for (int i = 0; listIterator.hasNext(); listIterator.move(), i++) {
            assertEquals(ELEMENTS[i], listIterator.print());
        }

    }
}