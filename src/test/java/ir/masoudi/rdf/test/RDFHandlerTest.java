package ir.masoudi.rdf.test;

import org.eclipse.rdf4j.query.MalformedQueryException;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Rasoul Masoudi
 */
public class RDFHandlerTest {

    private final RDFHandlerImpl rdfHandler = new RDFHandlerImpl();

    @Before
    public void init() throws IOException {
        rdfHandler.openDump(new File("resources/wdump-691.nt"));
    }

    @Test
    public void testGetEntityLabel() {
        String label = rdfHandler.getEntityLabel("Q93165");
        assertEquals("روغن زیتون", label);
    }

    @Test
    public void testRunQuery() {
        String query = Constants.PREFIX_LIST + "SELECT ?food \n"
                + "WHERE { \n"
                + "    ?food wdt:P495 wd:Q794 .\n"
                + "}";
        List<String> result = rdfHandler.runQuery(query);
        assertEquals(1, result.size());
        String val = result.get(0);
        assertEquals("خورش قورمه\u200Cسبزی", val);
    }

    @Test(expected = MalformedQueryException.class)
    public void testRunBadQuery() {
        String query = Constants.PREFIX_LIST + "SELECTTTT ?food \n"
                + "WHERE { \n"
                + "    ?food wdt:P495 wd:Q794 .\n"
                + "}";
        rdfHandler.runQuery(query);
    }
}