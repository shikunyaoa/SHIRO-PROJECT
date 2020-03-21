package com.kunyao.shiro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @ClassName: UsersEntity
 * @Author: kunyao
 * @Description: 用户实体类
 * @Date: 2020/3/20 19:19
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersEntity implements Serializable {

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户姓名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 是否锁定
     */
    private  Integer locked;

    @TableField(exist = false)
    private String token;

}
