package com.dgbiztech.generator.plugin.batchplugin;

import com.dgbiztech.generator.utils.MethodGeneratorTool;
import com.dgbiztech.generator.utils.SqlMapperGeneratorTool;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;

import java.util.List;

public class BatchUpdatePlugin extends PluginAdapter {

    private final static String BATCH_UPDATE = "batchUpdate";

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

//    /**
//     * 接口方法在这里添加
//     * @param interfaze
//     * @param topLevelClass
//     * @param introspectedTable
//     * @return
//     */
//    @Override
//    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
//
//        return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
//    }

    /**
     * 方法对应的xml节点在这里添加
     * @param document
     * @param introspectedTable
     * @return
     */
    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        if (introspectedTable.getTargetRuntime().equals(IntrospectedTable.TargetRuntime.MYBATIS3)) {
            addSqlMapper(document, introspectedTable);
        }
        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

    public void addSqlMapper(Document document, IntrospectedTable introspectedTable) {
        String tableName = introspectedTable.getFullyQualifiedTableNameAtRuntime();

        List<IntrospectedColumn> columnList = introspectedTable.getAllColumns();
        //primaryKey的JDBC名字
        String primaryKeyName = introspectedTable.getPrimaryKeyColumns().get(0).getActualColumnName();

        //primaryKey的JAVA变量
        String primaryKeyParameterClause = MyBatis3FormattingUtilities.getParameterClause(introspectedTable.getPrimaryKeyColumns().get(0), "item.");

        //primaryKey的JAVA名字
        String primaryKeyJavaName = introspectedTable.getPrimaryKeyColumns().get(0).getJavaProperty();

        //构建一个xml节点，
        XmlElement updateXmlElement = SqlMapperGeneratorTool.baseElementGenerator(SqlMapperGeneratorTool.UPDATE,
                BATCH_UPDATE,
                FullyQualifiedJavaType.getNewListInstance(),
                null);

        XmlElement foreachElement = SqlMapperGeneratorTool.baseForeachElementGenerator("list", "item", "index", ";","begin",";end;");
        foreachElement.addElement(new TextElement(String.format("UPDATE %s",tableName)));
        updateXmlElement.addElement(foreachElement);

        XmlElement setElement = new XmlElement("set");
        foreachElement.addElement(setElement);

        for (int i = 0; i < columnList.size(); i++) {

            IntrospectedColumn introspectedColumn = columnList.get(i);

            String columnName = introspectedColumn.getActualColumnName();

            String columnJavaTypeName = introspectedColumn.getJavaProperty("item.");

            String parameterClause = MyBatis3FormattingUtilities.getParameterClause(introspectedColumn, "item.");

            //如果是主键
            if(primaryKeyParameterClause.equals(parameterClause)){
                continue;
            }

            if (introspectedColumn.isIdentity()) {
                continue;
            }

            String ifSql = String.format(" %s = %s ",columnName,parameterClause);
            XmlElement ifElement = SqlMapperGeneratorTool.baseIfJudgeElementGen(columnJavaTypeName, ifSql);

            setElement.addElement(ifElement);

//            String ifNullSql = String.format("when %s then %s", primaryKeyParameterClause, tableName + "." + columnName);
//            XmlElement ifNullElement = SqlMapperGeneratorTool.baseIfJudgeElementGen(columnJavaTypeName, ifNullSql, true);


//            XmlElement foreachElement = SqlMapperGeneratorTool.baseForeachElementGenerator(PARAMETER_NAME, "item", "index", null);
//            foreachElement.addElement(ifElement);
//            foreachElement.addElement(ifNullElement);
//
//            XmlElement caseTrimElement = SqlMapperGeneratorTool.baseTrimElement(columnName + " =case " + primaryKeyName, "end,", null);
//            caseTrimElement.addElement(foreachElement);

//            trimElement.addElement(caseTrimElement);
        }

//        updateXmlElement.addElement(trimElement);

//        XmlElement foreachElement = SqlMapperGeneratorTool.baseForeachElementGenerator(PARAMETER_NAME,
//                "item",
//                "index",
//                ",");
//        foreachElement.addElement(new TextElement(primaryKeyParameterClause));
//
//        updateXmlElement.addElement(new TextElement(String.format("where %s in(", primaryKeyName)));
//
//        updateXmlElement.addElement(foreachElement);
//
//        updateXmlElement.addElement(new TextElement(")"));
//
        foreachElement.addElement(new TextElement(String.format("WHERE %s = %s",primaryKeyName,primaryKeyParameterClause)));
        document.getRootElement().addElement(updateXmlElement);
    }


//    public void addSqlMapper(Document document, IntrospectedTable introspectedTable) {
//        String tableName = introspectedTable.getFullyQualifiedTableNameAtRuntime();
//        List<IntrospectedColumn> columnList = introspectedTable.getAllColumns();
//        //primaryKey的JDBC名字
//        String primaryKeyName = introspectedTable.getPrimaryKeyColumns().get(0).getActualColumnName();
//
//        //primaryKey的JAVA变量
//        String primaryKeyParameterClause = MyBatis3FormattingUtilities.getParameterClause(introspectedTable.getPrimaryKeyColumns().get(0), "item.");
//
//        //primaryKey的JAVA名字
//        String primaryKeyJavaName = introspectedTable.getPrimaryKeyColumns().get(0).getJavaProperty();
//
//
//        XmlElement updateXmlElement = SqlMapperGeneratorTool.baseElementGenerator(SqlMapperGeneratorTool.UPDATE,
//                BATCH_UPDATE,
//                FullyQualifiedJavaType.getNewListInstance());
//
//        updateXmlElement.addElement(new TextElement(String.format("update %s ", tableName)));
//
//        XmlElement trimElement = SqlMapperGeneratorTool.baseTrimElement("set", null, ",");
//
//        for (int i = 0; i < columnList.size(); i++) {
//
//            IntrospectedColumn introspectedColumn = columnList.get(i);
//
//            String columnName = introspectedColumn.getActualColumnName();
//
//            String columnJavaTypeName = introspectedColumn.getJavaProperty("item.");
//
//            String parameterClause = MyBatis3FormattingUtilities.getParameterClause(introspectedColumn, "item.");
//
//
//            if (introspectedColumn.isIdentity()) {
//                continue;
//            }
//
//            String ifSql = String.format("when %s then %s", primaryKeyParameterClause, parameterClause);
//            XmlElement ifElement = SqlMapperGeneratorTool.baseIfJudgeElementGen(columnJavaTypeName, ifSql, false);
//
//            String ifNullSql = String.format("when %s then %s", primaryKeyParameterClause, tableName + "." + columnName);
//            XmlElement ifNullElement = SqlMapperGeneratorTool.baseIfJudgeElementGen(columnJavaTypeName, ifNullSql, true);
//
//
//            XmlElement foreachElement = SqlMapperGeneratorTool.baseForeachElementGenerator(PARAMETER_NAME, "item", "index", null);
//            foreachElement.addElement(ifElement);
//            foreachElement.addElement(ifNullElement);
//
//            XmlElement caseTrimElement = SqlMapperGeneratorTool.baseTrimElement(columnName + " =case " + primaryKeyName, "end,", null);
//            caseTrimElement.addElement(foreachElement);
//
//            trimElement.addElement(caseTrimElement);
//        }
//
//        updateXmlElement.addElement(trimElement);
//
//        XmlElement foreachElement = SqlMapperGeneratorTool.baseForeachElementGenerator(PARAMETER_NAME,
//                "item",
//                "index",
//                ",");
//        foreachElement.addElement(new TextElement(primaryKeyParameterClause));
//
//        updateXmlElement.addElement(new TextElement(String.format("where %s in(", primaryKeyName)));
//
//        updateXmlElement.addElement(foreachElement);
//
//        updateXmlElement.addElement(new TextElement(")"));
//
//        document.getRootElement().addElement(updateXmlElement);
//    }
}
