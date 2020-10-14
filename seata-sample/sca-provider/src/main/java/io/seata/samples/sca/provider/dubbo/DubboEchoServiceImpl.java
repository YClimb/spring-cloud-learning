package io.seata.samples.sca.provider.dubbo;

import io.seata.samples.sca.common.dubbo.api.DubboEchoService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * Created by yu.hb on 2019-10-30
 */
@DubboService
public class DubboEchoServiceImpl implements DubboEchoService {

    @Override
    public String echo(String name) {
        return "DubboEchoServiceImpl#echo hi " + name ;
    }
}
