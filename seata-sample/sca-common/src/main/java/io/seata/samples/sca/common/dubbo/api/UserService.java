package io.seata.samples.sca.common.dubbo.api;

import io.seata.samples.sca.common.domain.TbUser;

public interface UserService {

    void add(TbUser user);
}
