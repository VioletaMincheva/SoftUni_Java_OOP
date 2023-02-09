package p02_ExtendedDatabase;

import org.junit.*;

import javax.naming.OperationNotSupportedException;

import static org.junit.jupiter.api.Assertions.*;


public class DatabaseExtendedTest {

    private Database database;
    private static final Person[] PEOPLE = new Person[]{
            new Person(1, "A"),
            new Person(2, "B"),
            new Person(3, "C")};

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    @Test
    public void testDatabaseConstructorShouldCreateObjectWithValidState() {
        assertArrayEquals(PEOPLE, database.getElements());
        assertEquals(PEOPLE.length, database.getElements().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseConstructorShouldThrowWhenCalledWithMoreThanSixteenElements() throws
            OperationNotSupportedException {
        Person[] overPeopleSize = new Person[17];
        database = new Database(overPeopleSize);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseConstructorShouldThrowWhenCalledWithZeroElements() throws
            OperationNotSupportedException {
        Person[] underPeopleSize = new Person[0];
        database = new Database(underPeopleSize);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_addNullElement_then_thrownException() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddShouldAddAtFirstFreeIndex() throws OperationNotSupportedException {
        Person expectedPerson = new Person(4, "D");
        database.add(expectedPerson);
        int expectedSize = PEOPLE.length + 1;
        int actualSize = database.getElements().length;
        assertEquals(expectedSize, actualSize);
        Person actualPerson = database.getElements()[actualSize - 1];
        assertEquals(expectedPerson.getId(), actualPerson.getId());
        assertEquals(expectedPerson.getUsername(), actualPerson.getUsername());
    }

    @Test
    public void when_removePerson_then_theLastPersonIsRemoved() throws OperationNotSupportedException {
        database.remove();
        int expectedSize = PEOPLE.length - 1;
        int actualSize = database.getElements().length;
        assertEquals(expectedSize, actualSize);
        Person actualPerson = database.getElements()[actualSize - 1];
        Person expectedPerson = PEOPLE[PEOPLE.length - 2];
        assertEquals(expectedPerson.getId(), actualPerson.getId());
        assertEquals(expectedPerson.getUsername(), actualPerson.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_removeAllPeople_then_thrownException() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove();
        database.remove();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_usernameToFindIsNull_then_exceptionIsThrown() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_findPersonInEmptyListOfPerson_then_exceptionThrown() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove();
        database.findByUsername(PEOPLE[0].getUsername());
    }

    @Test
    public void when_findPersonByUsernameInListAndFoundIt_then_returnThisUser() throws OperationNotSupportedException {
        Person expectedPerson = PEOPLE[1];
        Person actualPerson = database.findByUsername("B");
        assertEquals(expectedPerson.getId(), actualPerson.getId());
        assertEquals(expectedPerson.getUsername(), actualPerson.getUsername());
    }

    //findById
    @Test
    public void when_findPersonByIdInListAndFoundIt_then_returnThisUser() throws OperationNotSupportedException {
        Person expectedPerson = PEOPLE[0];
        Person actualPerson = database.findById(1);
        assertEquals(expectedPerson.getId(), actualPerson.getId());
        assertEquals(expectedPerson.getUsername(), actualPerson.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void when_findPersonByIdInEmptyListOfPerson_then_exceptionThrown() throws OperationNotSupportedException {
        database.remove();
        database.remove();
        database.remove();
        database.findById(PEOPLE[0].getId());
    }
}

