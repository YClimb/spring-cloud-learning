package io.seata.samples.sca.provider.dubbo;

import io.seata.samples.sca.common.dubbo.api.DubboEchoService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * 无数据库操作：
 * 输出实现类，基于 sca-common 中的 dubbo api 接口实现；
 * 用于在 Customer 中 通过 dubbo 的方式调用
 *
 * @author yclimb
 * @date 2020/10/15
 */
@DubboService
public class DubboEchoServiceImpl implements DubboEchoService {

    @Override
    public String echo(String name) {
        return "DubboEchoServiceImpl#echo hi " + name ;
    }
}
