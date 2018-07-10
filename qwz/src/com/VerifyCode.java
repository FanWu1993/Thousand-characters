package com;

import java.io.*;
import java.util.*;
import com.sun.image.codec.jpeg.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.awt.*;
import java.awt.image.*;

public class VerifyCode extends HttpServlet {

private Font mFont = new Font("Times New Roman", Font.PLAIN, 18); //��������

public void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
//ȡ��һ��1000-9999�������
  HttpSession session = request.getSession(true);
  response.setContentType("image/gif");
  response.setHeader("Pragma", "No-cache");
  response.setHeader("Cache-Control", "no-cache");
  response.setDateHeader("Expires", 0);
  int width = 60, height = 20;

  ServletOutputStream out = response.getOutputStream();
  BufferedImage image = new BufferedImage(width, height,
  BufferedImage.TYPE_INT_RGB); //����ͼƬ��С��
  Graphics gra = image.getGraphics();
  Random random = new Random();
  gra.setColor(getRandColor(200, 250)); //���ñ���ɫ
  gra.fillRect(0, 0, width, height);
  gra.setColor(Color.black); //��������ɫ
  gra.setFont(mFont);
  // �������155�������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽
  gra.setColor(getRandColor(160, 200));
  for (int i = 0; i < 155; i++) {
    int x = random.nextInt(width);
    int y = random.nextInt(height);
    int xl = random.nextInt(12);
    int yl = random.nextInt(12);
    gra.drawLine(x, y, x + xl, y + yl);
  }

  // ȡ�����������֤��(4λ����)
  String sRand = "";
  for (int i = 0; i < 4; i++) {
    String rand = String.valueOf(random.nextInt(10));
    sRand += rand;
    // ����֤����ʾ��ͼ����
    gra.setColor(new Color(20 + random.nextInt(110),
    20 + random.nextInt(110),
    20 + random.nextInt(110))); //���ú�����������ɫ��ͬ����������Ϊ����̫�ӽ�������ֻ��ֱ������
    gra.drawString(rand, 13 * i + 6, 16);
  }
  session.setAttribute("rand",sRand);
  // session.setAttribute("getImg", sRand);
  JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
  encoder.encode(image);
  out.close();
}

static Color getRandColor(int fc, int bc) { //������Χ��������ɫ
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
