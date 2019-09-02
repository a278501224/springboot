/**
 * Description:
 * Auther:cherry
 * CreateTime:2019-08-29 11:03
 */
package cn.yichaotang.shirodemo.service.impl;

import cn.yichaotang.shirodemo.dao.UserInfoDao;
import cn.yichaotang.shirodemo.entity.UserInfoEntity;
import cn.yichaotang.shirodemo.service.UserInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户业务实现
 * @author cherry
 */
@Service
@Transactional
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfoEntity> implements UserInfoService {
    @Override
    public IPage<UserInfoEntity> selectUserInfoByGtFraction(IPage<UserInfoEntity> page, Long fraction) {
        return this.baseMapper.selectUserInfoByGtFraction(page,fraction);
    }
}
