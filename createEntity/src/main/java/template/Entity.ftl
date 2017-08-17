/*
 * ${date} 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package ${package};
/**
 * <p>表${tableName}对应的${entityName}</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public class ${entityName} extends BaseEntity{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
<#list fieldList as field>
    /** ${field.comment} */
    private ${field.type} ${field.name};
</#list>
    /**
     * <p>默认构造函数</p>
     */
    public ${entityName}() {

    }

<#list fieldList as field>
    /**
     * <p>${field.comment}</p>
     *
     * @return the ${field.comment}
     */
    public ${field.type} get${field.methodAppend}() {
        return ${field.name};
    }

    /**
     * <p>${field.comment}</p>
     *
     * @param ${field.name} ${field.comment}
     */
    public void set${field.methodAppend}(${field.type} ${field.name}) {
        this.${field.name} = ${field.name};
    }

</#list>
}
