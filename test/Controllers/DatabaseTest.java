package Controllers;

import Models.User;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    private MongoClient client;
    private MongoDatabase database;
    private String connectionString = "mongodb+srv://admin:90ZVui6wnRLIL2e9@Cluster1.kocpj.mongodb.net/<dbname>?retryWrites=true&w=majority";
    private Database db;
    private String databaseName = "CreatorHub";

    @BeforeEach
    void setUp() {
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        this.client = new MongoClient(new MongoClientURI(this.connectionString));
        db = new Database();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void databaseConnection() {
        MongoIterable<String> mc = client.listDatabaseNames();
        MongoCursor<String> cursor = mc.cursor();
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }

    @Test
    void connectToDatabase() {
    }

    @Test
    void getCollection() {
    }

    @Test
    void getAllDocuments() {
        db.getAllDocuments("Users", User.class);
    }

    @Test
    void getDocument() {
    }

    @Test
    void insertObject() {
    }

    @Test
    void deleteObject() {
    }

    @Test
    void updateObject() {
    }
}