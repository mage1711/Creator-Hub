package Controllers;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoIterable;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    public void DatabaseConnection(){
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
            String connectionString = "mongodb+srv://admin:90ZVui6wnRLIL2e9@Cluster1.kocpj.mongodb.net/<dbname>?retryWrites=true&w=majority";

        try (MongoClient client = new MongoClient(new MongoClientURI(connectionString)))
        {

            MongoIterable<String> mc = client.listDatabaseNames();
            MongoCursor<String> cursor = mc.cursor();
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }


        }

        catch (Exception e){
            System.out.println("Cannot connect:" + e);
           
        }
    }
}

