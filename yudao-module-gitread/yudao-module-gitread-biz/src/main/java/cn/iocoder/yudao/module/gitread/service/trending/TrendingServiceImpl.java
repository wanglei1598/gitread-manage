package cn.iocoder.yudao.module.gitread.service.trending;

import org.springframework.stereotype.Service;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.gitread.controller.admin.trending.vo.*;
import cn.iocoder.yudao.module.gitread.dal.dataobject.trending.TrendingDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.gitread.dal.mysql.trending.TrendingMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.gitread.enums.ErrorCodeConstants.*;

/**
 * 每日爬取排行榜 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class TrendingServiceImpl implements TrendingService {

    @Resource
    private TrendingMapper trendingMapper;

    @Override
    public Integer createTrending(TrendingSaveReqVO createReqVO) {
        // 插入
        TrendingDO trending = BeanUtils.toBean(createReqVO, TrendingDO.class);
        trendingMapper.insert(trending);
        // 返回
        return trending.getId();
    }

    @Override
    public void updateTrending(TrendingSaveReqVO updateReqVO) {
        // 校验存在
        validateTrendingExists(updateReqVO.getId());
        // 更新
        TrendingDO updateObj = BeanUtils.toBean(updateReqVO, TrendingDO.class);
        trendingMapper.updateById(updateObj);
    }

    @Override
    public void deleteTrending(Integer id) {
        // 校验存在
        validateTrendingExists(id);
        // 删除
        trendingMapper.deleteById(id);
    }

    private void validateTrendingExists(Integer id) {
        if (trendingMapper.selectById(id) == null) {
            throw exception(TRENDING_NOT_EXISTS);
        }
    }

    @Override
    public TrendingDO getTrending(Integer id) {
        return trendingMapper.selectById(id);
    }

    @Override
    public PageResult<TrendingDO> getTrendingPage(TrendingPageReqVO pageReqVO) {
        return trendingMapper.selectPage(pageReqVO);
    }

}