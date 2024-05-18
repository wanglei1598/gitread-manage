package cn.iocoder.yudao.module.gitread.service.trendingrepo;

import java.util.*;
import jakarta.validation.*;
import cn.iocoder.yudao.module.gitread.controller.admin.trendingrepo.vo.*;
import cn.iocoder.yudao.module.gitread.dal.dataobject.trendingrepo.TrendingRepoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 此表用于存储 GitRead 的仓库 Service 接口
 *
 * @author 芋道源码
 */
public interface TrendingRepoService {

    /**
     * 创建此表用于存储 GitRead 的仓库
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Integer createTrendingRepo(@Valid TrendingRepoSaveReqVO createReqVO);

    /**
     * 更新此表用于存储 GitRead 的仓库
     *
     * @param updateReqVO 更新信息
     */
    void updateTrendingRepo(@Valid TrendingRepoSaveReqVO updateReqVO);

    /**
     * 删除此表用于存储 GitRead 的仓库
     *
     * @param id 编号
     */
    void deleteTrendingRepo(Integer id);

    /**
     * 获得此表用于存储 GitRead 的仓库
     *
     * @param id 编号
     * @return 此表用于存储 GitRead 的仓库
     */
    TrendingRepoDO getTrendingRepo(Integer id);

    /**
     * 获得此表用于存储 GitRead 的仓库分页
     *
     * @param pageReqVO 分页查询
     * @return 此表用于存储 GitRead 的仓库分页
     */
    PageResult<TrendingRepoDO> getTrendingRepoPage(TrendingRepoPageReqVO pageReqVO);

}