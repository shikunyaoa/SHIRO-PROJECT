package com.kunyao.shiro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @ClassName: PermissionsEntity
 * @Author: kunyao
 * @Description:
 * @Date: 2020/3/21 9:59
 * @Version: 1.0
 */
@Data
public class PermissionsEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String permission;

    private String description;

    private Integer available;
}
