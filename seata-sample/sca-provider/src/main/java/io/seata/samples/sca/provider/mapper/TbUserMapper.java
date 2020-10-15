package io.seata.samples.sca.provider.mapper;

import io.seata.samples.sca.common.domain.TbUser;

/**
 * mysql generator 自动生成 mapper
 * 自动生成代码见本项目 test 目录
 *
 * @author yclimb
 * @date 2020/10/15
 */
public interface TbUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(TbUser record);

    TbUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbUser record);
}