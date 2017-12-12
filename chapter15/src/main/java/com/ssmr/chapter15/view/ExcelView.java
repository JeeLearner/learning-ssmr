package com.ssmr.chapter15.view;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class ExcelView extends AbstractXlsView {

    //文件名
    private String fileName = null;
    //导出视图自定义接口
    private ExcelExportService excelExpService = null;

    // 构造方法1
    public ExcelView(ExcelExportService excelExpService) {
        this.excelExpService = excelExpService;
    }
    public ExcelView(String viewName, ExcelExportService excelExpService) {
        this.setBeanName(viewName);
    }

    /**
     * 创建Excel文件
     * @param model Spring MVC数据模型
     * @param workbook POI workbook对象
     * @param request http请求对象
     * @param response http响应对象
     * @throws Exception
     */
    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (excelExpService == null) {
            throw new RuntimeException("导出服务接口不能为null！！");
        }
        // 文件名不为空，为空则使用请求路径中的字符串作为文件名
        if(!StringUtils.isEmpty(fileName)){
            //进行字符转换
            String reqCharset = request.getCharacterEncoding();
            reqCharset = reqCharset == null ? "UTF-8" : reqCharset;
            fileName = new String(fileName.getBytes(reqCharset), "ISO8859-1");
            //设置下面文件名
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            // 回调接口方法，使用自定义生成Excel文档
            excelExpService.makeWorkBook(model, workbook);
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ExcelExportService getExcelExpService() {
        return excelExpService;
    }

    public void setExcelExpService(ExcelExportService excelExpService) {
        this.excelExpService = excelExpService;
    }
}
