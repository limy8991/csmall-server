package cn.tedu.csmall.product.webapi.service;

import cn.tedu.csmall.pojo.dto.CategoryAddNewDTO;
import cn.tedu.csmall.pojo.entity.Category;
import cn.tedu.csmall.pojo.vo.CategorySimpleVO;
import cn.tedu.csmall.product.service.ICategoryService;
import cn.tedu.csmall.product.webapi.mapper.CategoryMapper;
import com.example.csmall.common.ex.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    // 注意：需要创建异常
    // 注意：需要在CategoryMapper中补充getById()方法，至少返回：depth
    // 注意：需要在CategoryMapper中补充updateIsParentById()方法

    @Override
    public void addNew(CategoryAddNewDTO categoryAddNewDTO) {
        // 从参数中取出尝试添加的类别的名称
        String name = categoryAddNewDTO.getName();
        // 调用categoryMapper.getByName()方法查询
        CategorySimpleVO queryResult = categoryMapper.getByName(name);
        // 判断查询结果是否不为null
        if (queryResult != null) {
            // 是：抛出ServiceException
            throw new ServiceException();
        }


        // 从参数中取出父级类别的id：parentId
        // 判断parentId是否为0
        // 是：此次尝试添加的是一级类别，没有父级类别，则当前depth >>> 1
        // 否：此次尝试添加的不是一级类别，则应该存在父级类别，调用categoryMapper.getById()方法查询父级类别的信息
        // -- 判断查询结果是否为null
        // -- 是：抛出ServiceException
        // -- 否：当前depth >>> 父级depth + 1

        // 创建Category对象
        // 调用BeanUtils.copyProperties()将参数对象中的属性值复制到Category对象中
        // 补全Category对象中的属性值：depth >>> 前序运算结果
        // 补全Category对象中的属性值：enable >>> 1（默认即启用）
        // 补全Category对象中的属性值：isParent >>> 0
        // 补全Category对象中的属性值：gmtCreate, gmtModified >>> LocalDateTime.now()
        // 调用categoryMapper.insert(Category)插入类别数据，获取返回的受影响的行数
        // 判断返回的受影响的行数是否不为1
        // 是：抛出ServiceException

        // 判断父级类别的isParent是否为0
        // 是：调用categoryMapper.updateIsParentById()方法，将父级类别的isParent修改为1，获取返回的受影响的行数
        // 判断返回的受影响的行数是否不为1
        // 是：抛出ServiceException
    }

}