package test.main;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

class DatabaseTest {
    private MongoClient client;
    private MongoDatabase database;
    private String connectionString = "mongodb+srv://admin:90ZVui6wnRLIL2e9@Cluster1.kocpj.mongodb.net/<dbname>?retryWrites=true&w=majority";

    @BeforeEach
    void setUp() {
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        this.client = new MongoClient(new MongoClientURI(this.connectionString));

    }

    @BeforeAll
    static void beforeAll() {

    }

    @Test
    void databaseConnection() {
        MongoIterable<String> mc = client.listDatabaseNames();
        MongoCursor<String> cursor = mc.cursor();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }

}