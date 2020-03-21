package com.kunyao.shiro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @ClassName: RolesEntity
 * @Author: kunyao
 * @Description:
 * @Date: 2020/3/21 9:56
 * @Version: 1.0
 */
@Data
public class RolesEntity {


    @TableId(type = IdType.AUTO)
    private Long id;

    private String role;

    private String description;

    private Integer available;
}
