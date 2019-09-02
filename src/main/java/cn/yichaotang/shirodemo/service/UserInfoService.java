/**
 * Description:
 * Auther:cherry
 * CreateTime:2019-08-29 11:05
 */
package cn.yichaotang.shirodemo.service;

import cn.yichaotang.shirodemo.entity.UserInfoEntity;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 用户业务接口
 */
public interface UserInfoService extends IService<UserInfoEntity> {
    /**
     * 查询大于该分数的学生
     * @author cherry
     * @param  page  分页参数
     * @param  fraction  分数
     * @return IPage<UserInfoEntity> 分页数据
     */
    IPage<UserInfoEntity> selectUserInfoByGtFraction(IPage<UserInfoEntity> page, Long fraction);
}
