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
        Database obj=new Database("database");
        
        String str="create table singles(word varchar(30),count int,primary key(word))";
        obj.modifyDB(str);
        str="create table pairs(curr varchar(30),next varchar(30),count int,primary key(curr,next))";
        obj.modifyDB(str);
        
        
                
    }
    
}
