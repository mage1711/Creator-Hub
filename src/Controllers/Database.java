package Controllers;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private MongoClient client;
    private String connectionString = "mongodb+srv://admin:90ZVui6wnRLIL2e9@Cluster1.kocpj.mongodb.net/<dbname>?retryWrites=true&w=majority";
    private MongoDatabase database;
    private String databaseName = "CreatorHub";

    Database() {
        DatabaseConnection();
        ConnectToDatabase();
    }

    public void DatabaseConnection() {
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try {
            this.client = new MongoClient(new MongoClientURI(this.connectionString));

        } catch (Exception e) {
            System.out.println("Cannot connect:" + e);
        }
    }

    public void ConnectToDatabase() {
        this.database = client.getDatabase(databaseName);
    }

    public MongoCollection GetCollection(String collectionName){
        return database.getCollection(collectionName);
    }

    public void GetAllDocuments(MongoCollection collection){
        FindIterable results = collection.find();

    }
}

