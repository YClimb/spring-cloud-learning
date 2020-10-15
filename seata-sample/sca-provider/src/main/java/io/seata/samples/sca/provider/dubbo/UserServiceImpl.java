package io.seata.samples.sca.provider.dubbo;

import io.seata.samples.sca.common.domain.TbUser;
import io.seata.samples.sca.common.dubbo.api.UserService;
import io.seata.samples.sca.provider.mapper.TbUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 涉及数据库操作：
 * 用户实现类，基于 sca-common 中的 dubbo api 接口实现；
 * 用于在 Customer 中 通过 dubbo 的方式调用
 *
 * @author yclimb
 * @date 2020/10/15
 */
@DubboService
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserMapper userMapper;

    @Override
    public void add(TbUser user) {
        log.info("add user:{}", user);

        user.setName("provider");
        userMapper.insertSelective(user);
    }
}
