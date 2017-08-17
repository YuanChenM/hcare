package hoperun.tools.utils;

import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 配置文件读取类
 * @author yuan_chen
 */
public class PropertyFileReader {

    /**
     * 构造函数
     */
    private PropertyFileReader() {
    }

    /**
     * 属性一览取得
     * 
     * @param propertyFileName 属性文件名
     * @return 配置文件中设定的值
     */
    public static Properties getProperties(String propertyFileName) {

        Properties prop = new Properties();

        if (propertyFileName == null) {
            return null;
        }

        ResourceBundle resourceBundle = ResourceBundle
            .getBundle(propertyFileName);

        Enumeration<?> enumeration = resourceBundle.getKeys();
        while (enumeration.hasMoreElements()) {
            Object key = enumeration.nextElement();
            prop.put(key, resourceBundle.getObject((String)key));
        }

        return prop;

    }
}
