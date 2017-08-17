package hoperun.tools;

import java.io.File;
import java.io.IOException;
import java.util.List;

import hoperun.tools.bean.DBTable;
import hoperun.tools.db.DBConnection;
import hoperun.tools.logic.DaoGenerator;
import hoperun.tools.logic.EntityGenerator;
import hoperun.tools.logic.SqlMapGenerator;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;

/**
 * 根据数据库结构，取得Entity
 * @author yuan_chen
 */
public class Generator {
	private static Configuration config = null;
	static {
		if (null == config) {
			config = new Configuration();
			try {
				config.setDirectoryForTemplateLoading(new File(Generator.class
						.getResource("/").getPath().replaceAll("%20", " ") + "template"));
				config.setDefaultEncoding("UTF-8");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		List<String> tableList = DBConnection.getTableNames();
		for (String table : tableList) {
			DBTable dbTable = DBConnection.getTableColumns(table);
			try {
				SqlMapGenerator.genaratorSqlMap(config, dbTable);
				DaoGenerator.genaratorDao(config, dbTable);
				EntityGenerator.genaratorEntity(config, dbTable);
			} catch (TemplateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
