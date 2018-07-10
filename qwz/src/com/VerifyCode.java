package com;

import java.io.*;
import java.util.*;
import com.sun.image.codec.jpeg.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.awt.*;
import java.awt.image.*;

public class VerifyCode extends HttpServlet {

private Font mFont = new Font("Times New Roman", Font.PLAIN, 18); //设置字体

public void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
//取得一个1000-9999的随机数
  HttpSession session = request.getSession(true);
  response.setContentType("image/gif");
  response.setHeader("Pragma", "No-cache");
  response.setHeader("Cache-Control", "no-cache");
  response.setDateHeader("Expires", 0);
  int width = 60, height = 20;

  ServletOutputStream out = response.getOutputStream();
  BufferedImage image = new BufferedImage(width, height,
  BufferedImage.TYPE_INT_RGB); //设置图片大小的
  Graphics gra = image.getGraphics();
  Random random = new Random();
  gra.setColor(getRandColor(200, 250)); //设置背景色
  gra.fillRect(0, 0, width, height);
  gra.setColor(Color.black); //设置字体色
  gra.setFont(mFont);
  // 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
  gra.setColor(getRandColor(160, 200));
  for (int i = 0; i < 155; i++) {
    int x = random.nextInt(width);
    int y = random.nextInt(height);
    int xl = random.nextInt(12);
    int yl = random.nextInt(12);
    gra.drawLine(x, y, x + xl, y + yl);
  }

  // 取随机产生的认证码(4位数字)
  String sRand = "";
  for (int i = 0; i < 4; i++) {
    String rand = String.valueOf(random.nextInt(10));
    sRand += rand;
    // 将认证码显示到图象中
    gra.setColor(new Color(20 + random.nextInt(110),
    20 + random.nextInt(110),
    20 + random.nextInt(110))); //调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
    gra.drawString(rand, 13 * i + 6, 16);
  }
  session.setAttribute("rand",sRand);
  // session.setAttribute("getImg", sRand);
  JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
  encoder.encode(image);
  out.close();
}

static Color getRandColor(int fc, int bc) { //给定范围获得随机颜色
  Random random = new Random();
  if (fc > 255)
    fc = 255;
  if (bc > 255)
    bc = 255;
  int r = fc + random.nextInt(bc - fc);
  int g = fc + random.nextInt(bc - fc);
  int b = fc + random.nextInt(bc - fc);
  return new Color(r, g, b);
}

  //Clean up resources
 public void destroy() {
   }
}
