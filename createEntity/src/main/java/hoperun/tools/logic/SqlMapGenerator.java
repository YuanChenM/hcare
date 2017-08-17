package hoperun.tools.logic;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hoperun.tools.bean.DBTable;
import hoperun.tools.bean.TableColumn;
import hoperun.tools.utils.CommonUtil;
import hoperun.tools.utils.FileUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * SqlMapGenerator
 * @author yuan_chen
 */
public class SqlMapGenerator {
	public static String PK_TYPE = null;
	public static void genaratorSqlMap(Configuration cfg,
			DBTable dbTable) throws TemplateException, IOException {
	    PK_TYPE = null;
		String tableName = dbTable.getTableName();
		List<TableColumn> columnList = dbTable.getTableColumnList();
		// 生成的文件路径
		String path = CommonUtil.getSqlMapOutPutPath("mapper") + "/"
				+ getSqlMapName(tableName);
		// 生成文件夹
		FileUtil.mkdir(path);
		BufferedWriter writer = null;
		try {
			// 获得输入流
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(path), "UTF-8"));
			Map<String, Object> paramMap = new HashMap<String, Object>();
			//查询字段
			paramMap.put("selectSql",
					getSelectTableColumn(columnList));
			paramMap.put("conditionSql", getConditionSql(columnList));
			//DAO的包名称
			paramMap.put("daoPackage", CommonUtil.getDaoPackage(tableName));
			//entity名称
			paramMap.put("entityName",  CommonUtil
				.getOutputColumnName(tableName, true));
			//表名称
			paramMap.put("tabName", tableName);
			paramMap.put("insertSql", getInsertSql(columnList));
			//插入Value
			paramMap.put("insertValue", getInsertValueSql(columnList));
			paramMap.put("updateSet", getUpdateSet(columnList));
			paramMap.put("updateCondtion", getUpdateCondtion(columnList));
			paramMap.put("page", getPage(columnList));
			System.out.println(isValid(columnList));
			paramMap.put("isValid", isValid(columnList));
			paramMap.put("aaa", "#{isValid}");
			Template tpl = cfg.getTemplate("SqlMap.ftl");
			tpl.setEncoding("UTF-8");
			tpl.process(paramMap, writer);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (null != writer) {
				writer.flush();
				writer.close();
			}
		}
	}
	public static boolean isValid(List<TableColumn> columnList){
	    for(TableColumn column : columnList){
	        if("isValid".equalsIgnoreCase(column.getColumnName())){
	            return true;
	        }
	    }
	    return false;
	}
	public static String getPage(List<TableColumn> columnList){
		
		StringBuffer pageSql = new StringBuffer("order by ");
		int columnLength = columnList.size();
		for (int i = 0; i < columnLength; i++) {
			TableColumn tableColumn = columnList.get(i);
			if(!tableColumn.isIdentity()&&!tableColumn.isPk()){
				continue;
			}
			String columnName = tableColumn.getColumnName();
			pageSql.append("\n");
			pageSql.append("            ");
			pageSql.append(columnName);
//			if (columnLength != i+1) {
//				pageSql.append(",");
//			}
		}
		pageSql.append("\n");
		pageSql.append("            ");
		pageSql.append(" OFFSET #{startPos} row fetch next #{pageSize} row only");
		return pageSql.toString();
	}
	public static String getUpdateCondtion(List<TableColumn> columnList){
		StringBuffer updateCondtionSql = new StringBuffer();
		updateCondtionSql.append("        ");
		updateCondtionSql.append("WHERE");
		updateCondtionSql.append("\n");
		int columnLength = columnList.size();
		boolean flag =false;
		for (int i = 0; i < columnLength; i++) {
			TableColumn tableColumn = columnList.get(i);
			if(!tableColumn.isIdentity()&&!tableColumn.isPk()){
				continue;
			}
			if(tableColumn.isPk()){
			    PK_TYPE = tableColumn.getDataType();
			}
			String columnName = tableColumn.getColumnName();
			updateCondtionSql.append("            ");
			if(flag==true){
			    updateCondtionSql.append(" AND ");
			}
			updateCondtionSql.append(columnName+"="+"#{"+CommonUtil.getOutputColumnName(columnName, false)+"}");
			flag = true;
//			if (columnLength != i+1) {
//				updateCondtionSql.append(" AND ");
//				updateCondtionSql.append("\n");
//			}
		}
		
		return updateCondtionSql.toString();
	}
	public static String getUpdateSet(List<TableColumn> columnList){
		StringBuffer updateSetSql = new StringBuffer();
		int columnLength = columnList.size();
		for (int i = 0; i < columnLength; i++) {
			TableColumn tableColumn = columnList.get(i);
			if(tableColumn.isIdentity()||tableColumn.isPk()){
				continue;
			}
			String columnName = tableColumn.getColumnName();
			updateSetSql.append("            ");
			updateSetSql.append(columnName+"="+"#{"+CommonUtil.getOutputColumnName(columnName, false)+"}");
			
			if (columnLength != i+1) {
				updateSetSql.append(",");
				updateSetSql.append("\n");
			}
		}
		return updateSetSql.toString();
	}
	public static String getInsertValueSql(List<TableColumn> columnList){
		StringBuffer insertSql = new StringBuffer();
		int columnLength = columnList.size();
		TableColumn preTableColumn = null;
		boolean flg = false;
		for (int i = 0; i < columnLength; i++) {
			TableColumn tableColumn = columnList.get(i);
			if(tableColumn.isIdentity()){
				continue;
			}
			String columnName = tableColumn.getColumnName();
			if(0 < insertSql.length()){
				if(flg){
					insertSql.append("\n");
				}
				if("".equals(preTableColumn.getDefaultValue())){
					flg = true;
				}
				else{
					if(!flg){
						insertSql.append("\n");
					}
					insertSql.append("            </if> ");
					insertSql.append("\n");
				}
			}
			if("".equals(tableColumn.getDefaultValue())){
				insertSql.append("            ");
				if(flg){
					insertSql.append(",");
				}
				else{
					flg = true;
				}
				insertSql.append("#{"+CommonUtil.getOutputColumnName(columnName, false)+"}");
			}
			else {
				insertSql.append("            <if test=\""+CommonUtil.getOutputColumnName(columnName, false)+"!=null\">");
				insertSql.append("\n");
				insertSql.append("                ");
				if(flg){
					insertSql.append(",");
				}
				insertSql.append("#{"+CommonUtil.getOutputColumnName(columnName, false)+"}");
				if(!flg){
					insertSql.append(",");
				}
			}
			preTableColumn = tableColumn;
		}
		if(!"".equals(preTableColumn.getDefaultValue())){
			insertSql.append("\n");
			insertSql.append("            </if> ");
		}
		return insertSql.toString();
	}
	public static String getInsertSql(List<TableColumn> columnList){
		StringBuffer insertSql = new StringBuffer();
		int columnLength = columnList.size();
		TableColumn preTableColumn = null;
		boolean flg = false;
		for (int i = 0; i < columnLength; i++) {
			TableColumn tableColumn = columnList.get(i);
			if(tableColumn.isIdentity()){
				continue;
			}
			String columnName = tableColumn.getColumnName();
			if(0 < insertSql.length()){
				if(flg){
					insertSql.append("\n");
				}
				if("".equals(preTableColumn.getDefaultValue())){
					flg = true;
				}
				else{
					if(!flg){
						insertSql.append("\n");
					}
					insertSql.append("            </if> ");
					insertSql.append("\n");
				}
			}
			if("".equals(tableColumn.getDefaultValue())){
				insertSql.append("            ");
				if(flg){
					insertSql.append(",");
				}
				else{
					flg = true;
				}
				insertSql.append(columnName);
			}
			else {
				insertSql.append("            <if test=\""+CommonUtil.getOutputColumnName(columnName, false)+"!=null\">");
				insertSql.append("\n");
				insertSql.append("                ");
				if(flg){
					insertSql.append(",");
				}
				insertSql.append(columnName);
				if(!flg){
					insertSql.append(",");
				}
			}
			preTableColumn = tableColumn;
		}
		if(!"".equals(preTableColumn.getDefaultValue())){
			insertSql.append("\n");
			insertSql.append("            </if> ");
		}
		return insertSql.toString();
	}
	public static String getConditionSql(List<TableColumn> columnList){
		StringBuffer condtionSql = new StringBuffer();
		int columnLength = columnList.size();
		for (int i = 0; i < columnLength; i++) {
			TableColumn tableColumn = columnList.get(i);
			String columnName = tableColumn.getColumnName();
			condtionSql.append("            <if test=\""+CommonUtil.getOutputColumnName(columnName, false)+"!=null\">");
			condtionSql.append("\n");
			condtionSql.append("                  AND "+columnName+"=#{"+CommonUtil.getOutputColumnName(columnName, false)+"}");
			condtionSql.append("\n");
			condtionSql.append("            </if> ");
			condtionSql.append("\n");
		}
		
		return condtionSql.toString();
	}
	public static String getSelectTableColumn(List<TableColumn> columnList) {
		StringBuffer selectColumn = new StringBuffer();
		int columnLength = columnList.size();
		for (int i = 0; i < columnLength; i++) {
			TableColumn tableColumn = columnList.get(i);
			String columnName = tableColumn.getColumnName();
			selectColumn.append("        " + columnName + " AS "
					+ CommonUtil.getOutputColumnName(columnName, false));
			if (columnLength != i+1) {
				selectColumn.append(",");
				selectColumn.append("\n");
			}
		}
		return selectColumn.toString();
	}
	
	public static String getSqlMapName(String tableName) {
		String sqlMapTableName = CommonUtil
				.getOutputColumnName(tableName, true);
		return "SqlMap-" + sqlMapTableName + ".xml";
	}
	
	
}
