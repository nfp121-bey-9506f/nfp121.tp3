package question1;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class UneUtilisationTest.
 *
 * @author  Jalal Hassane
 * @version 23/3/2019
 */
public class UneUtilisationTest extends junit.framework.TestCase 
{
    private Pile p1 = new Pile(3);
    /**
     * Default constructor for test class UneUtilisationTest
     */
    public UneUtilisationTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() throws PilePleineException
    {
        p1.empiler("Premier sommet");
        p1.empiler("Deuxieme sommet");
        p1.empiler("Troisieme sommet");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    public void test_UneUtilisation() throws PileVideException{
        assertTrue(p1.depiler().toString().equals("Troisieme sommet"));
        assertTrue(p1.depiler().toString().equals("Deuxieme sommet"));
        assertTrue(p1.depiler().toString().equals("Premier sommet"));
    }
}
