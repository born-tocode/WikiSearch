**Simple WikiMedia API Client**

This application return hyperlink for one Wiki Page who is about Football Club. Apllication mapping a JSON from WIKIMEDIA API and preparing hyperlink for your query.

**Key features:**

1. query from GET method over HTTP
2. 2 services: 1st for preparing URL(creating query to WikiMedia API and returning response from this API) and 2nd for JSON ObjectMapper
3. Prepared response is returned over HTTP


**How to use?**

1. Build and run project.
2. Get on browser or CURL http://localhost:8080/query/club?name= _YourClubName_

JAR Build with libs:
JDK 11

`"_JDK_LOCATION_\java.exe" -jar "_PATH_JAR_\WikiSearch-0.0.2-SNAPSHOT.jar"`
