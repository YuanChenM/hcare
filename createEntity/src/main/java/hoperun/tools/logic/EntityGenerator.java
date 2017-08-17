package hoperun.tools.logic;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import hoperun.tools.bean.DBTable;
import hoperun.tools.bean.EntityField;
import hoperun.tools.bean.TableColumn;
import hoperun.tools.utils.CommonUtil;
import hoperun.tools.utils.FileUtil;
import hoperun.tools.utils.Globles;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * EntityGenerator
 * @author yuan_chen
 */
public class EntityGenerator implements Globles {

    public static void genaratorEntity(Configuration cfg,
        DBTable dbTable) throws IOException,
        TemplateException {
        BufferedWriter writer = null;
        String tableName = dbTable.getTableName();
        try {
            String _package=CommonUtil.getEntityOutPutPath();
            String path =_package  + "/"
                + getDomainName(tableName) + ".java";
            FileUtil.mkdir(path);
            System.out.println("<typeAlias type=\""+CommonUtil.getEntityPackage()+"."+getDomainName(tableName) +".java\" alias=\""+getDomainName(tableName) +"\"/>");
            writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(path), CommonUtil.getSourceEncode()));

            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("date", "2014/09/23");
            paramMap.put("package", CommonUtil.getEntityPackage());
            paramMap.put("tableName", tableName);
            paramMap.put("entityName", getDomainName(tableName));
            paramMap.put("fieldList", getEntityFieldList(dbTable.getTableColumnList()));
            
            Template tpl = cfg.getTemplate("Entity.ftl");
            tpl.setEncoding("UTF-8");

            tpl.process(paramMap, writer);
        } finally {
            if (null != writer) {
                writer.flush();
                writer.close();
            }
        }

    }
    
    public static List<EntityField> getEntityFieldList(List<TableColumn> tableColumnList){
    	List<EntityField> list = new ArrayList<EntityField>();
    	for (TableColumn column : tableColumnList) {
    		EntityField entityField = new EntityField();
    		entityField.setName(CommonUtil.getOutputColumnName(column.getColumnName(), false));
    		entityField.setMethodAppend(CommonUtil.getOutputColumnName(column.getColumnName(), true));
    		String comment = column.getColumnDescription();
    		if("".equals(comment)){
    			entityField.setComment(CommonUtil.getOutputColumnName(column.getColumnName(), false));
    		}else{
    			entityField.setComment(comment);
    		}
    		//System.out.println(column.getDataType());
    		entityField.setType(CommonUtil.getJavaMappingType(column.getDataType()));
    		list.add(entityField);
		}
    	
    	return list;
    }

    private static String getDomainName(String tableName) {
        return CommonUtil.getOutputColumnName(tableName, true);
    }
}
