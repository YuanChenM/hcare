package hoperun.tools.logic;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import hoperun.tools.bean.DBTable;
import hoperun.tools.utils.CommonUtil;
import hoperun.tools.utils.FileUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * DaoGenerator
 * @author yuan_chen
 */
public class DaoGenerator {

    public static void genaratorDao(Configuration cfg,
       DBTable dbTable) throws IOException,
        TemplateException {
        BufferedWriter writer = null;
        String tableName = dbTable.getTableName();
        try {
            String _package=CommonUtil.getDaoOutPutPath(tableName);
            String path = _package + "/"
                + getDaoName(tableName) + ".java";
            FileUtil.mkdir(path);
            writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(path), CommonUtil.getSourceEncode()));
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("date", "2014/09/23");
            paramMap.put("package", CommonUtil.getDaoPackage(""));
            paramMap.put("entityName", CommonUtil
				.getOutputColumnName(tableName, true));
            paramMap.put("entityPackage", CommonUtil.getEntityPackage());
            paramMap.put("pk", "Long");
            Template tpl = cfg.getTemplate("Dao.ftl");
            tpl.setEncoding("UTF-8");
            tpl.process(paramMap, writer);
            
        } finally {
            if (null != writer) {
                writer.flush();
                writer.close();
            }
        }

    }

   

    /**
     * <p>
     * ドメイン名称の取得処理。
     * </p>
     *
     * @param tableName テーブルの名称
     * @return ドメインの名称
     */
    public static String getDaoName(String tableName) {
        String domainName = CommonUtil.getOutputColumnName(tableName, true);
        return domainName + "Dao";
    }
}
