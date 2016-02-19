package me.ele.logan.admin.base;


import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import me.ele.logan.admin.exception.BusinessException;
import me.ele.logan.admin.util.BeanUtil;
import me.ele.logan.admin.util.DateUtil;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;


public abstract class BaseDaoImpl<T extends BaseModel> extends SqlSessionDaoSupport implements
        BaseDao<T> {

	/**
	 * Log variable for all child classes. Uses LogFactory.getLog(getClass())
	 * from Commons Logging
	 */
	//protected final Log log = LogFactory.getLog(getClass());

    @Autowired
    public void setSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    protected <S> S getMapper(Class<S> clazz) {
        return getSqlSession().getMapper(clazz);
    }

	/**
	 * 数据库基本操作，对应*mapper.xml中的id
	 */
	private static final String INSERT = ".insert";
	private static final String DELETE = ".delete";
	private static final String DELETE_LIST = ".deleteByIdList";
	private static final String UPDATE = ".update";
	private static final String GET = ".get";
	private static final String LIST = ".findListByVO";
	private static final String COUNT = ".count";
	private static final String FIND_WITH_PG = ".findWithPG";
	private static final String EXISTS = ".exists";

	@Override
	public long insert(T object) {
		
		System.out.println("=============cetst======");
		// 此处无需instanceof检测
		BaseModel baseEntity = (BaseModel) object;
		// 集成小二系统时候再实现 TODO 
		baseEntity.setCreatorId(1l);
		baseEntity.setCreator("admin");
		baseEntity.setCreateTime(DateUtil.getTodayHHmmss());
		baseEntity.setModifierId(1l);
		baseEntity.setModifiedBy("admin");
		baseEntity.setLastModified(DateUtil.getTodayHHmmss());

		return this.getSqlSession().insert(getIbatisMapperNameSpace() + INSERT, object);
	}

	@Override
	public void deleteById(Long id) {
		this.getSqlSession().update(getIbatisMapperNameSpace() + DELETE, id);
	}

    /**
     *
     * @param vo
     */
	@Override
	public void deleteByIdList(BaseVo vo) {
		this.getSqlSession().update(getIbatisMapperNameSpace() + DELETE_LIST, vo);
	}

	@Override
	public int update(BaseVo vo) {
		//UserSession user = ApplicationUserContext.getUser();

        vo.setModifierId(1l);
        vo.setModifiedBy("modify");
        vo.setLastModified(DateUtil.getTodayHHmmss());

//		if (vo.getVersion() != null) {
//			vo.setVersion(vo.getVersion() + 1);
//		}
		int affectNum = 0;
		affectNum = getSqlSession().update(getIbatisMapperNameSpace() + UPDATE, vo);
		if (affectNum == 0) {
			throw new BusinessException("BaseDao update affectNum equal zero");
		}
		return affectNum;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(Long id) {
		return (T) getSqlSession().selectOne(getIbatisMapperNameSpace() + GET, id);
	}

	public T get(BaseVo vo) {
		List<T> list = findListByVo(vo);
		T t = null;
		if (list != null && !list.isEmpty()) {
			t = list.get(0);
		}
		return t;
	}

	public List<T> findListByVo(BaseVo vo) {
		List<T> rstList = getSqlSession().selectList(getIbatisMapperNameSpace() + LIST, vo);
		return rstList;
	}

	@Override
	public boolean exists(Long id) {
		return get(id) != null ? true : false;
	}

	@Override
	public boolean exists(Map<String, Object> map) {
		Object count = getSqlSession().selectOne(getIbatisMapperNameSpace() + EXISTS, map);
		int totalCount = Integer.parseInt(count.toString());
		return totalCount > 0 ? true : false;
	}

	@SuppressWarnings("rawtypes")
	public Pager findWithPg(BaseVo vo) {

		Object count = getSqlSession().selectOne(getIbatisMapperNameSpace() + COUNT, vo);
		int totalCount = Integer.parseInt(count.toString());

		Pager pg = vo.getPager();
		pg.setTotalCount(totalCount);
		pg.calStart();
		List rstList = null;
		try {
			rstList = getSqlSession().selectList(getIbatisMapperNameSpace() + FIND_WITH_PG, vo);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		BeanUtil.beanCopier(vo, pg);
		pg.setTotalCount(totalCount);
		pg.setResultList(rstList);

		return pg;
	}

	/**
	 * 
	 * <pre>
	 * 获取执行mapperNameSpace
	 * </pre>
	 * 
	 * @return
	 */

	public String getIbatisMapperNameSpace() {
		Class<T> clazz = getEntityClass();
		Package packAge = clazz.getPackage();
		String[] args = packAge.getName().split("\\.");
		StringBuffer sb = new StringBuffer();
		String model = ClassUtils.getShortName(clazz);
		String method = Character.toUpperCase(model.charAt(0)) + model.substring(1);
		for (int i = 0; i < args.length; i++) {
			if (i < args.length - 1) {
				sb.append(args[i] + ".");
			}
		}
		String nameSpace = sb.append("mapper.").append(method).append("Mapper").toString();
		return nameSpace;
	}

	@SuppressWarnings("unchecked")
	public Class<T> getEntityClass() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		return (Class<T>) pt.getActualTypeArguments()[0];
	}

}
