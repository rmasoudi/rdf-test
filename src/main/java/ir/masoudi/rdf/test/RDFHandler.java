package ir.masoudi.rdf.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Rasoul Masoudi
 */
public interface RDFHandler {

    void openDump(File file) throws IOException;

    boolean hasDump();

    List<String> runQuery(String queryString);
}
