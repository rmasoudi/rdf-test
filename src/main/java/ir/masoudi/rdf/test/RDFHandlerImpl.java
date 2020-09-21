/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.masoudi.rdf.test;

import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.sail.SailRepository;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.sail.memory.MemoryStore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Rasoul Masoudi
 */
public class RDFHandlerImpl implements RDFHandler {

    private RepositoryConnection conn = null;
    private FileInputStream fis = null;

    @Override
    public void openDump(File file) throws IOException {
        closeConnectionIfExists();
        fis = new FileInputStream(file);
        Repository db = new SailRepository(new MemoryStore());
        conn = db.getConnection();
        conn.add(fis, "", RDFFormat.TURTLE);
    }

    @Override
    public boolean hasDump() {
        return conn != null;
    }

    @Override
    public List<String> runQuery(String queryString) {
        List<String> results = new ArrayList<>();
        if (conn == null) {
            return results;
        }
        TupleQuery query = conn.prepareTupleQuery(queryString);
        try (TupleQueryResult result = query.evaluate()) {
            for (BindingSet solution : result) {
                String entityUrl = solution.getValue(Constants.FOOD).stringValue();
                String entityId = entityUrl.substring(entityUrl.lastIndexOf("/") + 1);
                results.add(getEntityLabel(entityId));
            }
        }
        return results;
    }

    private void closeConnectionIfExists() throws IOException {
        if (conn != null) {
            conn.close();
        }
        if (fis != null) {
            fis.close();
        }
    }

    String getEntityLabel(String entityId) {
        String persianLabel = getLabelByLang(entityId, "fa");
        if (persianLabel != null) {
            return persianLabel;
        }
        String englishLabel = getLabelByLang(entityId, "en");
        if (englishLabel != null) {
            return englishLabel;
        }
        return entityId;
    }

    private String getLabelByLang(String entityId, String lang) {
        String queryString = Constants.PREFIX_LIST
                + "SELECT  *\n"
                + "WHERE {\n"
                + "        wd:" + entityId + " rdfs:label ?label .\n"
                + "        FILTER (langMatches( lang(?label), \"" + lang + "\" ) )\n"
                + "      } \n"
                + "LIMIT 1";
        TupleQuery query = conn.prepareTupleQuery(queryString);
        try (TupleQueryResult result = query.evaluate()) {
            for (BindingSet solution : result) {
                return solution.getValue(Constants.LABEL).stringValue();
            }
        }
        return null;
    }

}
