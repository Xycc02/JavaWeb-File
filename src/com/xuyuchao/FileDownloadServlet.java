package com.xuyuchao;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @auther xuyuchao
 * @create 2022-03-29-16:49
 */
public class FileDownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取要下载的文件名
        String downloadFileName = "中文名.jpg";
        //2、读取要下载的文件内容(通过ServletContext对象读取)
        ServletContext servletContext = getServletContext();
        //获取要下载的文件类型
        String mimeType = servletContext.getMimeType("/download/" + downloadFileName);
        System.out.println("下载的文件类型为: " + mimeType);
        //3、在回传之前，通过响应头告诉客户端返回的数据类型
        resp.setContentType(mimeType);
        //4、告诉客户端收到的数据是用于下载使用（通过响应头）,并设置文件名
            //Content-Disposition响应头，表示收到的数据怎么处理
            //attachment表示附件，表示下载使用
            //filename= 表示指定下载的文件名
            //url编码是把汉字转换成%xx%xx的格式
        resp.setHeader("content-Disposition","attachment;filename=" + URLEncoder.encode(downloadFileName,"utf-8"));

        InputStream resourceAsStream = servletContext.getResourceAsStream("/download/" + downloadFileName);
        //获取响应的输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        //把下载的文件内容回传给客户端
        //读取输入流中的全部数据，复制给输出流，输出给客户端
        IOUtils.copy(resourceAsStream,outputStream);
    }
}
