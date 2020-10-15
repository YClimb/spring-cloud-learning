package io.seata.samples.sca.customer.controller;

import io.seata.core.context.RootContext;
import io.seata.samples.sca.common.domain.TbUser;
import io.seata.samples.sca.common.dubbo.api.UserService;
import io.seata.samples.sca.customer.mapper.TbUserMapper;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户交互客户端控制器
 * Description:数据库新建表
 *

CREATE TABLE `tb_user` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
 `name` varchar(25) NOT NULL,
 `age` int(3) DEFAULT NULL,
 PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8

 * @author yclimb
 * @date 2020/10/14
 */
@RestController
@Slf4j
public class UserController {

    @DubboReference
    private UserService userService;

    @Autowired
    private TbUserMapper userMapper;

    /**
     * seata 全局事务控制
     * @param user user
     */
    @PostMapping("/seata/user/add")
    @GlobalTransactional(rollbackFor = Exception.class) // 开启全局事务
    public void add(@RequestBody TbUser user) {
        log.info("globalTransactional begin, Xid:{}", RootContext.getXID());

        /*
         * error: undo_log needs to contain the primary key.
         * 解决办法：1.undo_log 增加 id 自增主键
         * 2.修改mybatis的配置: 在@Options(useGeneratedKeys = true, keyProperty = "id")或者在xml中指定useGeneratedKeys 和 keyProperty属性
         */

        // 调用本地方法保存信息
        localSave(user);

        // 调用 provider dubbo 方法保存用户信息
        userService.add(user);

        // test seata globalTransactional
        throw new RuntimeException();
    }

    /**
     * 本地 customer 内置 mapper 调用
     * @param user user
     */
    private void localSave(TbUser user) {
        user.setName("customer");
        userMapper.insertSelective(user);
    }
}
