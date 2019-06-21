package com.thunder.util;

import com.alibaba.fastjson.JSONObject;
import com.thunder.util.beans.QccCountyXls;
import jdk.nashorn.internal.runtime.JSONFunctions;
import net.sf.jxls.reader.ReaderBuilder;
import net.sf.jxls.reader.XLSReader;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class JxlsUtil {
    /**
     * excel数据导入至数据库
     * @return
     * @throws Exception
     * @author ZYX
     */
    @Test
    public void dataFromExcelToDB(){


        //文件上传
//        Long timeStamp = new Date().getTime();	//获取时间戳
//        String fileName = file.getOriginalFilename();
//        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String realPath = request.getServletContext().getRealPath("/importExcel/"+sdf.format(new Date())+"/");	//每天创建一个单独的文件夹
////		System.err.println("======="+realPath);
//        File pFile = new File(realPath);	//父路径
//        if(!pFile.exists()){		//路径不存在则创建
//            pFile.mkdirs();
//        }
//        File excelPath = new File(pFile, timeStamp+fileName);
//        file.transferTo(excelPath);
//        String filePath = excelPath.getPath();
//		System.err.println("=======----------------"+filePath);
//		--------------------------------上传结束-----------------------------------
        List<QccCountyXls> qccCountyXls = new ArrayList<QccCountyXls>();

        try{
            // 读取excel
            InputStream inputStream = new BufferedInputStream(getClass().getResourceAsStream("/jxls/materialExcelConfig.xml"));
            XLSReader reader = ReaderBuilder.buildFromXML(inputStream);
            String filePath = "/Users/zhangyuxiao/Downloads/开发文档/企查查/CountyCode.xls";
            InputStream stream = new BufferedInputStream(new FileInputStream(filePath));

            Map<String, Object> beans = new HashMap<String, Object>();

            beans.put("qccCountyXls", qccCountyXls);

            reader.read(stream, beans);
            System.err.println(qccCountyXls);
        }catch(Exception e){
            if(e.getMessage().contains("Can't read cell")){		//数据格式异常
                String error = e.getMessage();
                String mess = error.substring(error.indexOf("cell")+4, error.indexOf("on sheet"));
            }else{
            }
        }
        System.err.println("===============");
        StringBuffer sb = new StringBuffer();
//        for (QccCountyXls qccCountyXl : qccCountyXls) {
//            if(!StringUtils.isEmpty(qccCountyXl.getName())){
//                sb.append("CO_"+qccCountyXl.getCode()+"(\""+qccCountyXl.getCode()+"\",\""+qccCountyXl.getName()+"\"),\n");
//            }
//        }
        sb.append("{");
        for (QccCountyXls qccCountyXl : qccCountyXls) {
            if(!StringUtils.isEmpty(qccCountyXl.getName())){
                sb.append("\""+qccCountyXl.getCode()+"\":\""+qccCountyXl.getName()+"\",\n");
            }
        }
        sb.append("}");

        System.out.println(sb);
    }
}
