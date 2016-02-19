package me.ele.logan.admin.base;

import java.util.List;
import java.util.Map;

/**
 * @author chengjun
 * 
 */
public interface BaseDao<T extends BaseModel> {
	/** 插入数据：{mapper.xml需要实现} */
	long insert(T object);

	/** 根据id删除数据：{mapper.xml需要实现} */
	void deleteById(Long id);

	/** 根据idList删除数据：{mapper.xml需要实现} */
	void deleteByIdList(BaseVo vo);

	/** 更新数据{mapper.xml需要实现} */
	int update(BaseVo vo);

	/** 根据id查找数据行：{mapper.xml需要实现} */
	T get(Long id);

	/** 通过查询vo查找符合条件的数据行：{mapper.xml需要实现} */
	List<T> findListByVo(BaseVo vo);

	/** 根据多个字段查询指定数据行是否存在 {需要自己写mapper实现} */
	boolean exists(Map<String, Object> map);

	/** 根据查询条件vo物理分页查询出数据行：{mapper.xml需要实现} */
	Pager<T> findWithPg(BaseVo vo);

	/** 根据vo查询指定数据行是存在：{调用findListByDto方法不需要实现} */
	T get(BaseVo vo);

	/** 根据id查询指定数据行是否存在：{调用get方法不需要实现} */
	boolean exists(Long id);

}
