package jef.database.query;

import java.util.Collection;

import jef.database.Field;
import jef.database.SelectProcessor;
import jef.database.wrapper.clause.QueryClause;
import jef.database.wrapper.populator.Transformer;

/**
 * 所有查询的接口
 * @author jiyi
 *
 */
public interface ConditionQuery{
	static final String CUSTOM_TABLE_NAME="_table_name";
	static final String CUSTOM_TABLE_TYPE="_table_type";
	
	/**
	 * 清除全部的请求数据
	 * 
	 */
	void clearQuery();

	/**
	 * 获取现有排序字段
	 * 
	 * @return
	 */
	Collection<OrderField> getOrderBy();

	/**
	 * 设置排序
	 * 
	 * @param asc
	 *            true is ASC, false is DESC
	 * @param orderby
	 */
	void setOrderBy(boolean asc, Field... orderby);

	/**
	 * 添加排序
	 * 
	 * @param asc
	 *            true is ASC, false is DESC
	 * @param orderby
	 */
	void addOrderBy(boolean asc, Field... orderby);
	/**
	 * 设置最大结果集限制
	 * @param size
	 */
	void setMaxResult(int size);
	/**
	 * 设置FetchSize
	 * @param size
	 */
	void setFetchSize(int size);
	/**
	 * 设置超时时间，单位秒
	 * @param timout
	 */
	void setQueryTimeout(int timout);
	/**
	 * 最大结果数限制
	 * @return
	 */
	int getMaxResult();
	/**
	 * 缓存读取大小
	 * @return
	 */
	int getFetchSize();
	/**
	 * 请求超时时间（秒）
	 * @return
	 */
	int getQueryTimeout();
	
	/**
	 * 获得结果转换器
	 * @return
	 */
	Transformer getResultTransformer();
	
	/**
	 * 内部使用：
	 * 准备进行查询。
	 * @return
	 */
	SqlContext prepare();
	/**
	 * 内部使用：转换为查询语句无绑定
	 * @param processor
	 * @return
	 */
	QueryClause toQuerySql(SelectProcessor processor,SqlContext context,boolean order);
	
	/**
	 * 内部使用：转换为查询语句(绑定)
	 * @param processor
	 * @param context
	 * @return
	 */
	QueryClause toPrepareQuerySql(SelectProcessor processor, SqlContext context,boolean order);
}
