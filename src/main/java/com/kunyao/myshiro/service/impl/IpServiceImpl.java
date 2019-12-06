package com.kunyao.myshiro.service.impl;

import com.kunyao.myshiro.entity.Ip;
import com.kunyao.myshiro.mapper.IpMapper;
import com.kunyao.myshiro.service.IIpService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * IP地址 服务实现类
 * </p>
 *
 * @author kunyao123
 * @since 2019-12-06
 */
@Service
public class IpServiceImpl extends ServiceImpl<IpMapper, Ip> implements IIpService {

}
