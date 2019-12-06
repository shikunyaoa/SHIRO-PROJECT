package com.kunyao.myshiro.service.impl;

import com.kunyao.myshiro.entity.Department;
import com.kunyao.myshiro.mapper.DepartmentMapper;
import com.kunyao.myshiro.service.IDepartmentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门 服务实现类
 * </p>
 *
 * @author kunyao123
 * @since 2019-12-06
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

}
