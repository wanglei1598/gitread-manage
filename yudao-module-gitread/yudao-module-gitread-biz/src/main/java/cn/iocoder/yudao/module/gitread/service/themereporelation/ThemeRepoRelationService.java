package cn.iocoder.yudao.module.gitread.service.themereporelation;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.gitread.controller.admin.themereporelation.vo.*;
import cn.iocoder.yudao.module.gitread.dal.dataobject.themereporelation.ThemeRepoRelationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 主题内容 Service 接口
 *
 * @author 芋道源码
 */
public interface ThemeRepoRelationService {

    /**
     * 创建主题内容
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createThemeRepoRelation(@Valid ThemeRepoRelationSaveReqVO createReqVO);

    /**
     * 更新主题内容
     *
     * @param updateReqVO 更新信息
     */
    void updateThemeRepoRelation(@Valid ThemeRepoRelationSaveReqVO updateReqVO);

    /**
     * 删除主题内容
     *
     * @param id 编号
     */
    void deleteThemeRepoRelation(Long id);

    /**
     * 获得主题内容
     *
     * @param id 编号
     * @return 主题内容
     */
    ThemeRepoRelationDO getThemeRepoRelation(Long id);

    /**
     * 获得主题内容分页
     *
     * @param pageReqVO 分页查询
     * @return 主题内容分页
     */
    PageResult<ThemeRepoRelationDO> getThemeRepoRelationPage(ThemeRepoRelationPageReqVO pageReqVO);

}