package cn.iocoder.yudao.module.gitread.service.theme;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.gitread.controller.admin.theme.vo.*;
import cn.iocoder.yudao.module.gitread.dal.dataobject.theme.ThemeDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 主题 Service 接口
 *
 * @author 芋道源码
 */
public interface ThemeService {

    /**
     * 创建主题
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Integer createTheme(@Valid ThemeSaveReqVO createReqVO);

    /**
     * 更新主题
     *
     * @param updateReqVO 更新信息
     */
    void updateTheme(@Valid ThemeSaveReqVO updateReqVO);

    /**
     * 删除主题
     *
     * @param id 编号
     */
    void deleteTheme(Integer id);

    /**
     * 获得主题
     *
     * @param id 编号
     * @return 主题
     */
    ThemeDO getTheme(Integer id);

    /**
     * 获得主题分页
     *
     * @param pageReqVO 分页查询
     * @return 主题分页
     */
    PageResult<ThemeDO> getThemePage(ThemePageReqVO pageReqVO);

}