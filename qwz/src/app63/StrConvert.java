package app63;

public class StrConvert {
	  public StrConvert() {
	  }
	  public String chStr(String str){
	   if(str==null){
	     str="";
	   }
	    else{
	     try{
	        str=(new String(str.getBytes("iso-8859-1"),"GB2312")).trim();
	     }
	     catch(Exception e){
	       System.out.println("chStr");
	       System.out.println(e.getMessage());
	     }
	     }
	    return str;
	 }

	}