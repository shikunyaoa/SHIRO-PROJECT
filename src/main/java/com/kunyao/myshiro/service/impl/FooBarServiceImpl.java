package com.kunyao.myshiro.service.impl;

import com.kunyao.myshiro.entity.FooBar;
import com.kunyao.myshiro.mapper.FooBarMapper;
import com.kunyao.myshiro.service.IFooBarService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * FooBar 服务实现类
 * </p>
 *
 * @author kunyao123
 * @since 2019-12-06
 */
@Service
public class FooBarServiceImpl extends ServiceImpl<FooBarMapper, FooBar> implements IFooBarService {

}
