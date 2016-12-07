package com.workforce.utility;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lcl.userimage.servlet")
public class LocalImageLoader extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.setContentType("image/jpeg");
//		String filename = "";
//		
//		if(request.getParameter("img") != null){
//			String imageParam = request.getParameter("img").toString();
//			if(imageParam.equals("defaults")){
//				filename = ResourceHelper.getPropertyValue("defaults", "defaultImageIconName");
//			}
//			InputStream readedImage = ResourceHelper.getFileAsInputStream(filename);
//			BufferedImage bufferedImage = ImageIO.read(readedImage);
//			OutputStream out = response.getOutputStream();
//			ImageIO.write(bufferedImage, "jpg", out);
//			
//			System.out.println("Image has been successfully served: " + LocalDateTime.now());
//		}
		
	}

}
