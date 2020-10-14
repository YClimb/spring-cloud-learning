package io.seata.samples.sca.common.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户
 *
 * @author yclimb
 * @date 2020/10/14
 */
@Data
public class TbUser implements Serializable {
    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private Integer age;
}