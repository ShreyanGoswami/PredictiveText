/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predictivetext;
import java.sql.*;
/**
 *
 * @author Shreyan
 */
public class TestConnection {
    public static void main(String args[]){
        Database obj=new Database("test");
        
        String str="insert into single values('Hello',1)";
        obj.modifyDB(str);
        
                
    }
    
}
