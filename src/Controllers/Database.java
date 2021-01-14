package Controllers;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private MongoClient client;
    private MongoDatabase database;
    private final Gson gson = new Gson();

    public Database() {
        DatabaseConnection();
        connectToDatabase();
    }

    public void DatabaseConnection() {
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        try {
            String connectionString = "mongodb+srv://admin:90ZVui6wnRLIL2e9@Cluster1.kocpj.mongodb.net/<dbname>?retryWrites=true&w=majority";
            this.client = new MongoClient(new MongoClientURI(connectionString));
        } catch (Exception e) {
            System.out.println("Cannot connect:" + e);
        }
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void connectToDatabase() {
        String databaseName = "CreatorHub";
        this.database = client.getDatabase(databaseName);
    }

    public MongoCollection<Document> getCollection(String collectionName) {
        return database.getCollection(collectionName);
    }

    public ArrayList<Object> getAllDocuments(String collectionName, Type classType) {
        MongoCollection<Document> collection = getCollection(collectionName);
        ArrayList<Object> results = new ArrayList<>();
        ArrayList<Document> documents = collection.find().into(new ArrayList<>());
        System.out.println(documents);
        for (Document document : documents) {
            results.add(gson.fromJson(document.toJson(), classType));
        }
        System.out.println(results);
        return results;
    }

    public ArrayList<Object> getAllDocuments(String collectionName, Type classType, String filterFieldName, Object filterFieldValue) {
        MongoCollection<Document> collection = getCollection(collectionName);
        ArrayList<Object> results = new ArrayList<>();
        ArrayList<Document> documents = collection.find(Filters.eq(filterFieldName, filterFieldValue)).into(new ArrayList<>());
        System.out.println(documents);
        for (Document document : documents) {
            results.add(gson.fromJson(document.toJson(), classType));
        }
        System.out.println(results);
        return results;
    }

    public Object getDocument(String collectionName, String filterFieldName, Object filterFieldValue, Type classType) {
        MongoCollection<Document> collection = getCollection(collectionName);
        Document document = collection.find(Filters.eq(filterFieldName, filterFieldValue)).first();
        if (document != null) {
            return gson.fromJson(document.toJson(), classType);
        }
        return null;
    }

    public void insertObject(String collectionName ,Object object) {
        MongoCollection<Document> collection = getCollection(collectionName);
        collection.insertOne(Document.parse(gson.toJson(object)));
        System.out.println("Inserted");
    }

    public void deleteObject(String collectionName, Object object, String fieldName, Object value) {
        MongoCollection<Document> collection = getCollection(collectionName);
        collection.deleteOne(Filters.eq(fieldName, value));
        System.out.println("Deleted");
    }

    public void updateObject(String collectionName, Object object, String filterFieldName, Object filterFieldValue) {
        MongoCollection<Document> collection = getCollection(collectionName);
        Document document = Document.parse(gson.toJson(object));
        collection.replaceOne(Filters.eq(filterFieldName, filterFieldValue), document);
    }

    public void updateDocument(String collectionName, String filterFieldName, Object filterFieldValue,
                               String updatedFieldName, String updatedValue) {
        MongoCollection<Document> collection = getCollection(collectionName);
        collection.updateOne(Filters.eq(filterFieldName, filterFieldValue), Updates.set(updatedFieldName, updatedValue));
    }
}

