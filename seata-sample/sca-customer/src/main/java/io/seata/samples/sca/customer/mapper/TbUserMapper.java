package io.seata.samples.sca.customer.mapper;

import io.seata.samples.sca.common.domain.TbUser;

public interface TbUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(TbUser record);

    TbUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbUser record);

}