package cn.iocoder.yudao.module.gitread.service.themereporelation;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.gitread.controller.admin.themereporelation.vo.*;
import cn.iocoder.yudao.module.gitread.dal.dataobject.themereporelation.ThemeRepoRelationDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.gitread.dal.mysql.themereporelation.ThemeRepoRelationMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gitread.enums.ErrorCodeConstants.*;

/**
 * 主题内容 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ThemeRepoRelationServiceImpl implements ThemeRepoRelationService {

    @Resource
    private ThemeRepoRelationMapper themeRepoRelationMapper;

    @Override
    public Long createThemeRepoRelation(ThemeRepoRelationSaveReqVO createReqVO) {
        // 插入
        ThemeRepoRelationDO themeRepoRelation = BeanUtils.toBean(createReqVO, ThemeRepoRelationDO.class);
        themeRepoRelationMapper.insert(themeRepoRelation);
        // 返回
        return themeRepoRelation.getId();
    }

    @Override
    public void updateThemeRepoRelation(ThemeRepoRelationSaveReqVO updateReqVO) {
        // 校验存在
        validateThemeRepoRelationExists(updateReqVO.getId());
        // 更新
        ThemeRepoRelationDO updateObj = BeanUtils.toBean(updateReqVO, ThemeRepoRelationDO.class);
        themeRepoRelationMapper.updateById(updateObj);
    }

    @Override
    public void deleteThemeRepoRelation(Long id) {
        // 校验存在
        validateThemeRepoRelationExists(id);
        // 删除
        themeRepoRelationMapper.deleteById(id);
    }

    private void validateThemeRepoRelationExists(Long id) {
        if (themeRepoRelationMapper.selectById(id) == null) {
            throw exception(THEME_REPO_RELATION_NOT_EXISTS);
        }
    }

    @Override
    public ThemeRepoRelationDO getThemeRepoRelation(Long id) {
        return themeRepoRelationMapper.selectById(id);
    }

    @Override
    public PageResult<ThemeRepoRelationDO> getThemeRepoRelationPage(ThemeRepoRelationPageReqVO pageReqVO) {
        return themeRepoRelationMapper.selectPage(pageReqVO);
    }

}