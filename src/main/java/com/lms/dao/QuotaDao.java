package com.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuotaDao extends JpaRepository<Quota,Integer> {

    /**
     * 查询所有指标记录
     * */
    @Override
    List<Quota> findAll();
    /**
     * 删除记录
     * @param quotaId 指标id
     * @return 数值(返回记录条数)
     * */
    Integer deleteQuotaByQuotaId(Integer quotaId);

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
    Quota findQuotaByQuotaId(Integer quotaId);
    /**
     * 根据quotaId查询记录
     * @param quotaParentId
     * @return List<Quota>
     * */
    List<Quota> findQuotasByQuotaParentId(Integer quotaParentId);
}
