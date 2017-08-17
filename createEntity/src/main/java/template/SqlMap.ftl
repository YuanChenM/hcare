<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//ibatis.apache.org//DTD Mapper 3.0//EN" "http://ibatis.apache.org/dtd/ibatis-3-mapper.dtd">
<mapper namespace="${daoPackage}.${entityName}Dao">
    <!-- 表字段 -->
	<sql id="selectSql">
${selectSql}
	</sql>
    <!--条件 -->
	<sql id="whereCondition">
		<where>
${conditionSql}
		</where>
	</sql>
    <!--数据插入 -->
	<insert id="save" parameterType="hcare.ap.com.bean.${entityName}">
		INSERT INTO ${tabName}
		(
${insertSql}			
		)
		VALUES
		(
${insertValue}
		)
	</insert>
	<update id="edit" parameterType="hcare.ap.com.bean.${entityName}">
		update ${tabName} 
		set 
${updateSet}
${updateCondtion}		
	</update>
	<select id="findAll" resultType="hcare.ap.com.bean.${entityName}">
		select 
		<include refid="selectSql"/>
		from ${tabName}
	</select>
	
	<select id="count" resultType="Integer" parameterType="hcare.ap.com.bean.${entityName}">
		select count(1)
		from ${tabName}
		<include refid="whereCondition"/>
	</select>
	<#if isValid>
	      <select id="findValidList" resultType="hcare.ap.com.bean.${entityName}" parameterType="int">
	           select 
                <include refid="selectSql"/>
               from ${tabName}
               where ISVALID = ${aaa}
	      </select>
	</#if> 
</mapper>
