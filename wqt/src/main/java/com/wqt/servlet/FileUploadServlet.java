package com.wqt.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.talkweb.twdpe.core.util.StringUtil;
import com.talkweb.twdpe.core.util.UniqueIdUtils;
import com.talkweb.twdpe.web.session.util.DateUtil;

/**
 * Servlet implementation class UploadFileServlet
 */
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		ServletContext servletContext = config.getServletContext();;

		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
	}

	/**
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String kind=request.getParameter("kind");
		
		String dirname="";   //upload下的子目录名
		String uploadFileName = ""; // 文件名称
		String UUIDfileName = "";
		long fileSize = 0; // 上传文件的大小;
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		// 上传目录设置，如不存存新创建一个
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");		
		String date = df.format(new Date());
		if("newswqt".equals(kind))    //总站新闻
		{
			dirname="news/wqt";
		}
		else if("newsipr".equals(kind))    //知识产权新闻
		{
			dirname="news/ipr";
		}
		else if("newses".equals(kind))    //企业服务新闻
		{
			dirname="news/es";
		}
		else if("brand".equals(kind))  //商标
		{
			dirname="ipr/brand";
		}
		else if("copyright".equals(kind))  //版权
		{
			dirname="ipr/copyright";
		}
		else if("patent".equals(kind))  //专利
		{
			dirname="ipr/patent";
		}
		else if("iprcase".equals(kind))  //知识产权案列
		{
			dirname="ipr/case";
		}
		else if("escase".equals(kind))  //企业服务案列
		{
			dirname="es/case";
		}
		else if("worker".equals(kind))  //企业服务案列
		{
			dirname="worker";
		}
		
		String path  = request.getSession().getServletContext().getRealPath("/upload") + File.separator+dirname+ File.separator;
		
		File uploadDir = new File(path);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		} 

		// 创建一个磁盘文件的工厂，然后将它 传递到servletFileUplaod的实例中
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

		try {

			// 根据request对象获取所有的文件集合，这里包括input标签输入的值也属于FileInput
			List<FileItem> fileItemList = servletFileUpload.parseRequest(request);
			
			Iterator iterator = fileItemList.iterator();
			String showFileName = "";

			while (iterator.hasNext()) {

				FileItem fileItem = (FileItem) iterator.next();

				if (fileItem.isFormField()) { // 是否是表单提交域，可以分区是否上传的附件

					String name = fileItem.getFieldName(); // input标签的name
					String value = fileItem.getString(); // input表单的value
					if ("uploadName".equals(name)) {
						showFileName = value;
					}
				} 
				else {
					uploadFileName = fileItem.getName(); // input标签中name的属性值

					// 生成文件全名
					UUIDfileName = date+UniqueIdUtils.getUID() + uploadFileName.substring(uploadFileName.lastIndexOf("."));
					String fileSavePath = path + UUIDfileName;
					
					// 将文件写入磁盘中
					File saveFile = new File(fileSavePath);
					fileItem.write(saveFile); 
					out.print("/upload/"+dirname+"/"+UUIDfileName);
					out.close();
				}
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			out.print("false");
			out.close();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}