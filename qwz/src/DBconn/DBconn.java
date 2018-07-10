package DBconn;
import java.sql.*;

public class DBconn {
   Connection con = null;
   Statement sql = null;
   ResultSet rs = null;

  private String DBDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
  private String Connstr = "jdbc:odbc:banji";
  private String username = "";
  private String password = "";

  //-------------------------- �����������ݿ����� ---------------------------
  public DBconn() {
    try {
      Class.forName(DBDriver);
    }
    catch (ClassNotFoundException e) {
      System.err.println("DBconn: classnotfoundexception ");
    }
  }

  //------------------------- ��ȡ���ݿ�����,���Ԥ����----------------------
  public Connection getConnection() {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(Connstr, username, password);
      return conn;
    }
    catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }

  //----------------------------- ���ݿ��ѯ -------------------------------
  public ResultSet executeQuery(String s) {
    Connection con = null;
    Statement sql = null;
    ResultSet rs = null;
    try {
      con = DriverManager.getConnection(Connstr, username, password);
      sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                                ResultSet.CONCUR_READ_ONLY);
      rs = sql.executeQuery(s);
    }
    catch (SQLException sqlexception) {
      System.err.println("executeQuery: " + sqlexception.getMessage());
    }
    return rs;
  }

  //------------------------------ ���ݿ���� -------------------------------
  public int executeUpdate(String s) {
    int i = 0;
    Connection con = null;
    Statement sql = null;
    ResultSet rs = null;
    try {
      con = DriverManager.getConnection(Connstr, username, password);
      sql = con.createStatement();
      i = sql.executeUpdate(s);
    }
    catch (SQLException sqlexception) {
      System.err.println("executeUpdate: " + sqlexception.getMessage());
    }
    return i;
  }

  //-------------------------------- ���ݿ�ر� --------------------------------
  public void close() {
    try {
      if (rs != null) {
        rs.close();

      }
      if (sql != null) {
        sql.close();

      }
      if (con != null) {
        con.close();
      }
    }
    catch (SQLException sqlexception) {
      System.err.println("close: " + sqlexception.getMessage());
    }
  }

  //---------------------------���Ԥ����-----------------------------------------
  public static void close(ResultSet rs, PreparedStatement ps, Connection con) {
    if (rs != null) {
      try {
        rs.close();
      }
      catch (Exception e) {
        System.out.println(e);
      }
    }
    if (ps != null) {
      try {
        ps.close();
      }
      catch (Exception e) {
        System.out.println(e);
      }
    }
    if (con != null) {
      try {
        con.close();
      }
      catch (Exception e) {
        System.out.println(e);
      }
    }
  }
}
