package com.xuyuchao;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @auther xuyuchao
 * @create 2022-03-29-13:39
 */
public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        System.out.println("文件上传成功!");
        //先判断上传的数据是否是多段的数据
        if(ServletFileUpload.isMultipartContent(req)) {
            //创建DiskFileItemFactory类
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //得到servletFileUpload类的实例（解析上传数据的工具类）
            ServletFileUpload servletFileUpload = new ServletFileUpload(factory);

            try {
                //解析上传的数据，得到每一个表单项FileItem并以List集合存储
                List<FileItem> list = servletFileUpload.parseRequest(req);
                //循环判断每个表单项是不同类型还是文件类型
                for(FileItem fileItem : list) {
                    if(fileItem.isFormField()) {
                        //普通表单项
                        System.out.println("表单项的name属性值: " + fileItem.getFieldName());
                    }else{
                        //文件表单项
                        System.out.println("表单项的name属性值: " + fileItem.getFieldName());
                        //文件名
                        System.out.println("上传的文件名: " + fileItem.getName());
                        fileItem.write(new File("E:\\javaweb\\File-demo\\web\\upload\\" + fileItem.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
