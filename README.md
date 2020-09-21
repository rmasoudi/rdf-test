# rdf-test
A test tool for running sparql on wikidata dumps
## Demo
1. download rdf-test.jar
2. download [wdump-691.nt](https://github.com/rmasoudi/rdf-test/raw/master/resources/wdump-691.nt) wdump-691.nt from resources
3. run the following command:
.  java -cp rdf-test.jar ir.masoudi.rdf.test.SPQLForm
4. select downloaded dump file.
5. select one of the sample queries and see results.
6. you can run custom sparql query. you should use variable ?food variable to select triples!
