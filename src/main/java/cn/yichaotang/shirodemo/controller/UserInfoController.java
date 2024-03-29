package cn.yichaotang.shirodemo.controller;

import cn.yichaotang.shirodemo.entity.UserInfoEntity;
import cn.yichaotang.shirodemo.service.UserInfoService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author cherry
 */
@RestController

@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 根据ID获取用户信息
     * @param userId    用户ID
     * @return  用户实体
     */


    @RequestMapping("/getInfo")
    public UserInfoEntity getInfo(  String userId){
        UserInfoEntity userInfoEntity = userInfoService.getById(userId);
        return userInfoEntity;
    }

    /**
     * 查询全部信息
     * @return List<UserInfoEntity> 用户实体集合
     */
    @RequestMapping("/getList")
    public List<UserInfoEntity> getList(){
        List<UserInfoEntity> userInfoEntityList = userInfoService.list();
        return userInfoEntityList;
    }

    /**
     * 分页查询全部数据
     * @return IPage<UserInfoEntity> 分页数据
     */
    @RequestMapping("/getInfoListPage")
    public IPage<UserInfoEntity> getInfoListPage(){
        //需要在Config配置类中配置分页插件
         IPage<UserInfoEntity> page = new Page<>();
         page.setCurrent(1);//当前页
         page.setSize(5);//每页条数
         page = userInfoService.page(page);
         return page;

    }


    /**
     * 根据指定字段查询用户信息集合
     * @return Collection<UserInfoEntity> 用户实体集合
     */
    @RequestMapping("/getListMap")
    public Collection<UserInfoEntity> getListMap(){
        Map<String,Object> map = new HashMap<>();
        //key是字段名 value是字段值
        map.put("age",20);
        Collection<UserInfoEntity> userInfoEntityList = userInfoService.listByMap(map);
        return userInfoEntityList;
    }

    /**
     * 新增用户信息
     */
    @RequestMapping("/saveInfo")
    public void saveInfo(){
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setName("小龙");
        userInfoEntity.setSkill("JAVA");
        userInfoEntity.setAge(18);
        userInfoEntity.setFraction(59L);
        userInfoEntity.setEvaluate("该学生是一个在改BUG的码农");
        userInfoService.save(userInfoEntity);
    }

    /**
     * 批量新增用户信息
     */
    @RequestMapping("/saveInfoList")
    public void saveInfoList(){
        //创建对象
        UserInfoEntity sans = new UserInfoEntity();
        sans.setName("Sans");
        sans.setSkill("睡觉");
        sans.setAge(18);
        sans.setFraction(60L);
        sans.setEvaluate("Sans是一个爱睡觉,并且身材较矮骨骼巨大的骷髅小胖子");
        UserInfoEntity papyrus = new UserInfoEntity();
        papyrus.setName("papyrus");
        papyrus.setSkill("JAVA");
        papyrus.setAge(18);
        papyrus.setFraction(58L);
        papyrus.setEvaluate("Papyrus是一个讲话大声、个性张扬的骷髅，给人自信、有魅力的骷髅小瘦子");
        //批量保存
        List<UserInfoEntity> list =new ArrayList<>();
        list.add(sans);
        list.add(papyrus);
        userInfoService.saveBatch(list);
    }

    /**
     * 更新用户信息
     */
    @RequestMapping("/updateInfo")
    public void updateInfo(){
        //根据实体中的ID去更新,其他字段如果值为null则不会更新该字段,参考yml配置文件
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setId(1L);
        userInfoEntity.setAge(19);
        userInfoService.updateById(userInfoEntity);
    }
    /**
     * 新增或者更新用户信息
     */
    @RequestMapping("/saveOrUpdateInfo")
    public void saveOrUpdate(){
        //传入的实体类userInfoEntity中ID为null就会新增(ID自增)
        //实体类ID值存在,如果数据库存在ID就会更新,如果不存在就会新增
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setId(1L);
        userInfoEntity.setAge(20);
        userInfoService.saveOrUpdate(userInfoEntity);
    }
    /**
     * 根据ID删除用户信息
     */
    @RequestMapping("/deleteInfo")
    public void deleteInfo(String userId){
        userInfoService.removeById(userId);
    }
    /**
     * 根据ID批量删除用户信息
     */
    @RequestMapping("/deleteInfoList")
    public void deleteInfoList(){
        List<String> userIdlist = new ArrayList<>();
        userIdlist.add("12");
        userIdlist.add("13");
        userInfoService.removeByIds(userIdlist);
    }
    /**
     * 根据指定字段删除用户信息
     */
    @RequestMapping("/deleteInfoMap")
    public void deleteInfoMap(){
        //kay是字段名 value是字段值
        Map<String,Object> map = new HashMap<>();
        map.put("skill","删除");
        map.put("fraction",10L);
        userInfoService.removeByMap(map);
    }
}
