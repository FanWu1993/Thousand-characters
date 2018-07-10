package DBconn;

import java.sql.*;
import DBconn.DBconn;

public class PhotoBean {
  String photo_name, photo_note, photo_tu;
  String backNews = ""; //用来返回注册是否成功。
//-----------------------------------------------
  public PhotoBean() {}

  public String getPhoto_name() {
    return photo_name;
  }

  public void setphoto_name(String m) {
    photo_name = codeString(m);
  }

  public String getPhoto_tu() {
    return photo_tu;
  }

  public void setphoto_tu(String m) {
    photo_tu = codeString(m);
  }

  public String getPhoto_note() {
    return photo_note;
  }

  public void setphoto_note(String m) {
    photo_note = codeString(m);
  }

  public String getBackNews() {
    return backNews;
  }

  public void setBackNews(String s) {
    backNews = s;
  }

//-----------------------------------------------
  //处理字符串的方法：
  public String codeString(String s) {
    String str = s;
    try {
      byte b[] = str.getBytes("ISO-8859-1");
      str = new String(b);
      return str;
    }
    catch (Exception e) {
      return str;
    }
  }

//-----------------------------------------------
  //添加记录到数据库
  public void add() {
    DBconn mdb = new DBconn();
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String str =
        "insert into photo (photo_name,photo_note,photo_tu) values(?,?,?)";
    try {
      con = mdb.getConnection();
      ps = con.prepareStatement(str);
      ps.setString(1, this.photo_name);
      ps.setString(2, this.photo_note);
      ps.setString(3, this.photo_tu);

      ps.execute();
      backNews = "添加成功";
    }
    catch (Exception e) {
      backNews = str+photo_name+photo_note+photo_tu+"发生SQL异常";
    }
    finally {
      mdb.close(rs, ps, con);
    }

  }

  //-----------------------------------------------
  //修改记录
  public void modify(String id) {
    DBconn mdb = new DBconn();
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String str =
        "update photo set photo_name=?,photo_note=?,photo_tu=? where id=?";
    try {
      con = mdb.getConnection();
      ps = con.prepareStatement(str);
      ps.setString(1, this.photo_name);
      ps.setString(2, this.photo_note);
      ps.setString(3, this.photo_tu);
      ps.setString(4, id);
      ps.execute();
      backNews = str+photo_name+photo_note+photo_tu+"修改成功";
    }
    catch (Exception e) {
      backNews = str+photo_name+photo_note+photo_tu+"发生SQL异常";
    }
    finally {
      mdb.close(rs, ps, con);
    }
  }

}
