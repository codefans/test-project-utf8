package com.codefans.opensource.ognl;

import ognl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 对象导航访问工具栏
 * @author: codefans
 * @date: 2020-02-10 12:03
 */
public class OgnlUtil {

    /**
     * ognl上下文
     */
    private static OgnlContext context = (OgnlContext) Ognl.createDefaultContext(OgnlUtil.class, new DefaultMemberAccess(true), new DefaultClassResolver(), new DefaultTypeConverter());

    /**
     * expression缓存
     */
    private static Map<String, Object> expressionCache = new HashMap<String, Object>();

    /**
     * 获取值
     * @param expression
     * @param root
     * @return
     * @throws OgnlException
     */
    public static Object getValue(String expression, Object root) throws OgnlException {
        context.setRoot(root);
        return Ognl.getValue(getExpression(expression), context, context.getRoot());
    }

    /**
     * 设置值
     * @param expression
     * @param root
     * @param value
     * @throws OgnlException
     */
    public static void setValue(String expression, Object root, String value) throws OgnlException {
        Ognl.setValue(getExpression(expression), context, root, value);
    }

    /**
     * 获取expression对象
     * @param expression
     * @return
     * @throws OgnlException
     */
    private static Object getExpression(String expression) throws OgnlException {
        Object expressionObj = null;
        if(expressionCache.containsKey(expression)) {
            expressionObj = expressionCache.get(expression);
        } else {
            expressionObj = Ognl.parseExpression(expression);
            expressionCache.put(expression, expressionObj);
        }
        return expressionObj;
    }

}
