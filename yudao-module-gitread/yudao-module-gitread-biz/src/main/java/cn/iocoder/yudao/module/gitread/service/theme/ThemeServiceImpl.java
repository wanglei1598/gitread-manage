package cn.iocoder.yudao.module.gitread.service.theme;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.gitread.controller.admin.theme.vo.*;
import cn.iocoder.yudao.module.gitread.dal.dataobject.theme.ThemeDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.gitread.dal.mysql.theme.ThemeMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gitread.enums.ErrorCodeConstants.*;

/**
 * 主题 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ThemeServiceImpl implements ThemeService {

    @Resource
    private ThemeMapper themeMapper;

    @Override
    public Integer createTheme(ThemeSaveReqVO createReqVO) {
        // 插入
        ThemeDO theme = BeanUtils.toBean(createReqVO, ThemeDO.class);
        themeMapper.insert(theme);
        // 返回
        return theme.getId();
    }

    @Override
    public void updateTheme(ThemeSaveReqVO updateReqVO) {
        // 校验存在
        validateThemeExists(updateReqVO.getId());
        // 更新
        ThemeDO updateObj = BeanUtils.toBean(updateReqVO, ThemeDO.class);
        themeMapper.updateById(updateObj);
    }

    @Override
    public void deleteTheme(Integer id) {
        // 校验存在
        validateThemeExists(id);
        // 删除
        themeMapper.deleteById(id);
    }

    private void validateThemeExists(Integer id) {
        if (themeMapper.selectById(id) == null) {
            throw exception(THEME_NOT_EXISTS);
        }
    }

    @Override
    public ThemeDO getTheme(Integer id) {
        return themeMapper.selectById(id);
    }

    @Override
    public PageResult<ThemeDO> getThemePage(ThemePageReqVO pageReqVO) {
        return themeMapper.selectPage(pageReqVO);
    }

}