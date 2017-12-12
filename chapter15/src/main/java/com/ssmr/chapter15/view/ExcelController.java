package com.ssmr.chapter15.view;

import com.ssmr.chapter15.pojo.PageParams;
import com.ssmr.chapter15.pojo.Role;
import com.ssmr.chapter15.pojo.RoleParams;
import com.ssmr.chapter15.service.RoleService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    private RoleService roleService;


    /**
     * 导出Excel
     * @return
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public ModelAndView export(){
        ModelAndView mv = new ModelAndView();
        ExcelExportService excelExportService = exportService();
        ExcelView ev = new ExcelView(exportService());
        ev.setFileName("所有角色.xlsx");

        RoleParams roleParams = new RoleParams();
        //限制1万条
        PageParams page = new PageParams();
        page.setStart(0);
        page.setLimit(10000);
        roleParams.setPageParams(page);
        //查询
        List<Role> roleList = roleService.findRoles(roleParams);
        mv.addObject("roleList", roleList);
        mv.setView(ev);
        return mv;
    }


    @SuppressWarnings({ "unchecked"})
    private ExcelExportService exportService(){
        //使用Lambda表达式自定义导出excel规则
        return (Map<String, Object> model, Workbook workbook) -> {
            List<Role> roleList = (List<Role>) model.get("roleList");

            //生成Sheet
            Sheet sheet = workbook.createSheet("所有角色");
            Row title = sheet.createRow(0);
            title.createCell(0).setCellValue("编号");
            title.createCell(1).setCellValue("名称");
            title.createCell(2).setCellValue("备注");
            for (int i=0; i<roleList.size(); i++) {
                Role role = roleList.get(i);
                int rowIdx = i + 1;
                Row row = sheet.createRow(rowIdx);
                row.createCell(0).setCellValue(role.getId());
                row.createCell(1).setCellValue(role.getRoleName());
                row.createCell(2).setCellValue(role.getNote());
            }
        };
    }
}
