package com.lms.dao;

import com.lms.po.Quota;
import java.util.List;

public interface QuotaDao{


    int insert(Quota record);

    int insertSelective(Quota record);

    int updateByPrimaryKeySelective(Quota record);

    int updateByPrimaryKey(Quota record);

    /**
     * 查询所有指标记录
     * @return List<Quota>
     * */
    List<Quota> findAll();
    /**
     * 删除记录
     * @param quotaId 指标id
     * @return 数值(返回记录条数)
     * */
    int deleteByPrimaryKey(Integer quotaId);

    /**
     * 根据指标类型查询所有
     * @param quotaType
     * @return List<Quota>
     * */
    List<Quota> findQuotasByQuotaType(Integer quotaType);

    /**
     * 删除记录
     * @param quotaParentId
     * @return 数值(返回记录条数)
     * */
    Integer deleteQuotaByQuotaParentId(Integer quotaParentId);
    /**
     * 根据quotaId查询记录
     * @param quotaId
     * @return Quota对象
     * */
    Quota selectByPrimaryKey(Integer quotaId);
    /**
     * 根据quotaId查询记录
     * @param quotaParentId
     * @return List<Quota>
     * */
    List<Quota> findQuotasByQuotaParentId(Integer quotaParentId);
}
