package DBconn;

import java.sql.*;
import DBconn.DBconn;

public class NewsBean {
  String news_type,news_title,content;
  String backNews = ""; //用来返回注册是否成功。
//-----------------------------------------------
  public NewsBean() {}

  public String getNews_type() {
    return news_type;
  }

  public void  setNews_type(String m) {
    news_type = codeString(m);
  }

  public String getNews_title() {
    return news_title;
  }

  public void  setNews_title(String m) {
    news_title = codeString(m);
  }

  public String getContent() {
    return content;
  }

  public void  setContent(String m) {
    content = codeString(m);
  }

  public String getBackNews() {
    return backNews;
  }

  public void  setBackNews(String s) {
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
    java.util.Date date=new java.util.Date();
    //String s ="'"+date.toLocaleString()+ "'," + 1+",'"+news_type + "'" + "," +
    //    "'" + news_title + "'" + "," +
     //   "'" + content + "'";
     String s ="'"+news_type + "'" + "," +
             "'" + news_title + "'" + "," +
              "'" + content + "'";
    //String str = "Insert into mynews (NEWS_DATE,NEWS_NUM,NEWS_TYPE,NEWS_TITLE,NEWS_INFO) values(" + s + ")";
   String str = "Insert into mynews (NEWS_TYPE,NEWS_TITLE,NEWS_INFO) values(" + s + ")";
    backNews = "添加成功!";
    int i = mdb.executeUpdate(str);
    if (i != 1) {
      backNews = str+"发生SQL异常";
    }
  }
  //-----------------------------------------------
  //修改记录
  public void  modify(String id) {
    DBconn mdb = new DBconn();
    String s = "'" + news_type + "'" + "," +
        "'" + news_title + "'" + "," +
        "'" + content + "'";
    String str="update MyNews set NEWS_TITLE='"+news_title+"',NEWS_TYPE='"+news_type+"',NEWS_INFO='"+content+"' where NEWS_ID="+id;
    backNews = "修改成功!";
    int i = mdb.executeUpdate(str);
    if (i != 1) {
      backNews = "发生SQL异常";
    }
  }

}
