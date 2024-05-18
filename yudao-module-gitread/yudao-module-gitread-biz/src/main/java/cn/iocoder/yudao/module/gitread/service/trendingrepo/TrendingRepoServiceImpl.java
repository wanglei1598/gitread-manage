package cn.iocoder.yudao.module.gitread.service.trendingrepo;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.gitread.controller.admin.trendingrepo.vo.*;
import cn.iocoder.yudao.module.gitread.dal.dataobject.trendingrepo.TrendingRepoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.gitread.dal.mysql.trendingrepo.TrendingRepoMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gitread.enums.ErrorCodeConstants.*;

/**
 * 此表用于存储 GitRead 的仓库 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class TrendingRepoServiceImpl implements TrendingRepoService {

    @Resource
    private TrendingRepoMapper trendingRepoMapper;

    @Override
    public Integer createTrendingRepo(TrendingRepoSaveReqVO createReqVO) {
        // 插入
        TrendingRepoDO trendingRepo = BeanUtils.toBean(createReqVO, TrendingRepoDO.class);
        trendingRepoMapper.insert(trendingRepo);
        // 返回
        return trendingRepo.getId();
    }

    @Override
    public void updateTrendingRepo(TrendingRepoSaveReqVO updateReqVO) {
        // 校验存在
        validateTrendingRepoExists(updateReqVO.getId());
        // 更新
        TrendingRepoDO updateObj = BeanUtils.toBean(updateReqVO, TrendingRepoDO.class);
        trendingRepoMapper.updateById(updateObj);
    }

    @Override
    public void deleteTrendingRepo(Integer id) {
        // 校验存在
        validateTrendingRepoExists(id);
        // 删除
        trendingRepoMapper.deleteById(id);
    }

    private void validateTrendingRepoExists(Integer id) {
        if (trendingRepoMapper.selectById(id) == null) {
            throw exception(TRENDING_REPO_NOT_EXISTS);
        }
    }

    @Override
    public TrendingRepoDO getTrendingRepo(Integer id) {
        return trendingRepoMapper.selectById(id);
    }

    @Override
    public PageResult<TrendingRepoDO> getTrendingRepoPage(TrendingRepoPageReqVO pageReqVO) {
        return trendingRepoMapper.selectPage(pageReqVO);
    }

}