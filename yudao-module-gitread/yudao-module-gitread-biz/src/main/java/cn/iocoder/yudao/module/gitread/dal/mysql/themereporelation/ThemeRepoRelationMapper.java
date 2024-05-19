package cn.iocoder.yudao.module.gitread.dal.mysql.themereporelation;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.gitread.dal.dataobject.themereporelation.ThemeRepoRelationDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.gitread.controller.admin.themereporelation.vo.*;

/**
 * 主题内容 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ThemeRepoRelationMapper extends BaseMapperX<ThemeRepoRelationDO> {

    default PageResult<ThemeRepoRelationDO> selectPage(ThemeRepoRelationPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ThemeRepoRelationDO>()
                .eqIfPresent(ThemeRepoRelationDO::getThemeId, reqVO.getThemeId())
                .eqIfPresent(ThemeRepoRelationDO::getThemeRepoId, reqVO.getThemeRepoId())
                .betweenIfPresent(ThemeRepoRelationDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ThemeRepoRelationDO::getId));
    }

}