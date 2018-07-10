package app63;

import java.sql.*;
public class DBconn
{
  String DBDriver="sun.jdbc.odbc.JdbcOdbcDriver";
  String Connstr="jdbc:odbc:message";
  Connection con = null;
  ResultSet rs = null;
  //String username="";
  //String password="";
  public DBconn()
   {
        try{
           Class.forName(DBDriver);
         }
        catch(ClassNotFoundException e) {
           System.err.println("DBconn: classnotfoundexception ");
        }
   }
//数据添加的方法
public void executeInsert(String s)
  {
    int i = 0;
    Statement sql;
    try{
        // con = DriverManager.getConnection(Connstr,username,password);
        con = DriverManager.getConnection(Connstr);
        sql = con.createStatement();
        i = sql.executeUpdate(s);
      }
     catch(SQLException sqlexception){
         System.err.println("executeInsert:" + sqlexception.getMessage());
      }
     }
//数据查询的方法，不返回可滚动的结果集
    public ResultSet Querysimple(String s)
    {
        rs = null;
        Statement sql;
        try{
            //con = DriverManager.getConnection(Connstr,username,password);
            con = DriverManager.getConnection(Connstr);
            sql = con.createStatement();
            rs = sql.executeQuery(s);
        }
        catch(SQLException sqlexception)
        {
            System.err.println("executeQuery: " + sqlexception.getMessage());
        }
        return rs;
    }
   //数据查询的方法，可返回可滚动的结果集
    public ResultSet executeQuery(String s)
    {
        rs = null;
        Statement sql;
        try{
            //con = DriverManager.getConnection(Connstr,username,password);
            con = DriverManager.getConnection(Connstr);
            sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = sql.executeQuery(s);
        }
        catch(SQLException sqlexception){
            System.err.println("executeQuery: " + sqlexception.getMessage());
        }
        return rs;
    }
    //数据删除的方法
    public void executeDelete(String s)
    {
        Statement sql;
        try{
            //con = DriverManager.getConnection(Connstr,username,password);
            con = DriverManager.getConnection(Connstr);
            sql = con.createStatement();
            sql.executeUpdate(s);
        }
        catch(SQLException sqlexception){
            System.err.println("executeDelete: " + sqlexception.getMessage());
        }
    }
    //数据修改的方法
    public int executeUpdate(String s)
    {
        int i = 0;
        Statement sql;
        try{
            //con = DriverManager.getConnection(Connstr,username,password);
            con = DriverManager.getConnection(Connstr);
            sql = con.createStatement();
            i = sql.executeUpdate(s);
        }
        catch(SQLException sqlexception){
            System.err.println("executeUpdate: " + sqlexception.getMessage());
        }
        return i;
    }

    public void close()
    {
        try{
            if(rs != null)
            rs.close();
            if(con != null)
               con.close();
        }
        catch(SQLException sqlexception){
            System.err.println("close: " + sqlexception.getMessage());
        }
    }
  }
