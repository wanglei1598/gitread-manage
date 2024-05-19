package cn.iocoder.yudao.module.gitread.dal.mysql.theme;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.gitread.dal.dataobject.theme.ThemeDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.gitread.controller.admin.theme.vo.*;

/**
 * 主题 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ThemeMapper extends BaseMapperX<ThemeDO> {

    default PageResult<ThemeDO> selectPage(ThemePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ThemeDO>()
                .likeIfPresent(ThemeDO::getChineseName, reqVO.getChineseName())
                .likeIfPresent(ThemeDO::getEnglishName, reqVO.getEnglishName())
                .orderByDesc(ThemeDO::getId));
    }

}