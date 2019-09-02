/**
 * Description:
 * Auther:cherry
 * CreateTime:2019-08-29 10:55
 */
package cn.yichaotang.shirodemo.dao;

import cn.yichaotang.shirodemo.entity.UserInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 用户信息
 * @author cherry
 */
public interface UserInfoDao extends BaseMapper<UserInfoEntity> {
    /**
     * 查询大于该分数的学生
     * @param page	分页参数
     * @param fraction	分数
     * @return IPage<UserInfoEntity> 分页数据
     */
    IPage<UserInfoEntity> selectUserInfoByGtFraction(IPage<UserInfoEntity> page,Long fraction);

}
