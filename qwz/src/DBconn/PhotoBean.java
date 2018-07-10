package DBconn;

import java.sql.*;
import DBconn.DBconn;

public class PhotoBean {
  String photo_name, photo_note, photo_tu;
  String backNews = ""; //��������ע���Ƿ�ɹ���
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
  //�����ַ����ķ�����
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
  //��Ӽ�¼�����ݿ�
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
      backNews = "��ӳɹ�";
    }
    catch (Exception e) {
      backNews = str+photo_name+photo_note+photo_tu+"����SQL�쳣";
    }
    finally {
      mdb.close(rs, ps, con);
    }

  }

  //-----------------------------------------------
  //�޸ļ�¼
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
      backNews = str+photo_name+photo_note+photo_tu+"�޸ĳɹ�";
    }
    catch (Exception e) {
      backNews = str+photo_name+photo_note+photo_tu+"����SQL�쳣";
    }
    finally {
      mdb.close(rs, ps, con);
    }
  }

}
