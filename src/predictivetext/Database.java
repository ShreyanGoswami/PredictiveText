package predictivetext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Shreyan
 */
public class Database{
    Connection c=null;
    Statement stmt=null;
    
    Database(String dbname){
        try{
            Class.forName("org.sqlite.JDBC");
            c=DriverManager.getConnection("jdbc:sqlite:"+dbname+".db");
            stmt=c.createStatement();
            
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    void modifyDB(String sql){
        try{
            stmt.executeUpdate(sql);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
