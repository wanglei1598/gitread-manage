package cn.iocoder.yudao.module.gitread.service.trending;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.gitread.controller.admin.trending.vo.*;
import cn.iocoder.yudao.module.gitread.dal.dataobject.trending.TrendingDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 每日爬取排行榜 Service 接口
 *
 * @author 芋道源码
 */
public interface TrendingService {

    /**
     * 创建每日爬取排行榜
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Integer createTrending(@Valid TrendingSaveReqVO createReqVO);

    /**
     * 更新每日爬取排行榜
     *
     * @param updateReqVO 更新信息
     */
    void updateTrending(@Valid TrendingSaveReqVO updateReqVO);

    /**
     * 删除每日爬取排行榜
     *
     * @param id 编号
     */
    void deleteTrending(Integer id);

    /**
     * 获得每日爬取排行榜
     *
     * @param id 编号
     * @return 每日爬取排行榜
     */
    TrendingDO getTrending(Integer id);

    /**
     * 获得每日爬取排行榜分页
     *
     * @param pageReqVO 分页查询
     * @return 每日爬取排行榜分页
     */
    PageResult<TrendingDO> getTrendingPage(TrendingPageReqVO pageReqVO);

}