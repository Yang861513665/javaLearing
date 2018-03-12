package com.diecolor.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class AuthCode {
	private static String codes="abcdefghijklmnopqrstuvwxyz0123456789";
	
	public static String getCodeStr(int length){
		String code="";
		char charCodes[]=codes.toCharArray();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			int temp=random.nextInt(charCodes.length);
			code+=charCodes[temp];
		}
		
		return code;
	}
	
	public static BufferedImage getImage(String codeStr){
		int width=(codeStr.length()-1)*28+30+(codeStr.length()*5);
		int height=46;
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);//定义一张图片
		Graphics2D graphics2d = (Graphics2D)bi.getGraphics();
		graphics2d.setColor(new Color(230,230,200));
		graphics2d.fillRect(0, 0, width, height);
		Random random = new Random();
		int verifySiez=codeStr.length();
		int fonSize=height-4;//字体大小
		graphics2d.setFont(new Font("temp", Font.BOLD, 35));
		for (int i = 0; i < codeStr.length(); i++) {
			graphics2d.setColor(new Color(random.nextInt(100),random.nextInt(200),random.nextInt(150)));
			/*
			 * 设置字符串倾斜
			 */
			AffineTransform affine = new AffineTransform();
			affine.setToRotation(Math.PI/4*random.nextDouble()*(random.nextBoolean()?1:-1),(width/verifySiez)*i+fonSize/2,height/2);
			graphics2d.setTransform(affine);
			graphics2d.drawChars(codeStr.toCharArray(), i, 1, ((width-10)/verifySiez)*i+5,height/2+fonSize/2-10);
			
			
			
			//graphics2d.drawString(codeStr.charAt(i)+"",(i*28)+15, 35);//写入字符串
		}
		
		for (int i = 0; i <20; i++) {//绘制干扰线
			graphics2d.setColor(new Color(random.nextInt(150),random.nextInt(100),random.nextInt(60),random.nextInt(180)));
			
			graphics2d.drawLine(0, random.nextInt(height), width, random.nextInt(height));
		
		}
		
		float yawpRate = 0.05f;// 噪声率
		        int area = (int) (yawpRate * width * height);//噪点数量
		        for (int i = 0; i < area; i++) {
		        int xxx = random.nextInt(width);
		        int yyy = random.nextInt(height);
		        bi.setRGB(xxx, yyy, random.nextInt(255));
		}
		
		
		graphics2d.dispose();//释放
		
		return bi;
		
//		try {
//			ImageIO.write(bi, "JPG", new File("h:\\code.jpg"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}

	public static void main(String[] args) {
		AuthCode.getImage(getCodeStr(4));
	}
}
