package cn.iocoder.yudao.module.gitread.dal.mysql.trending;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.gitread.dal.dataobject.trending.TrendingDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.gitread.controller.admin.trending.vo.*;

/**
 * 每日爬取排行榜 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface TrendingMapper extends BaseMapperX<TrendingDO> {

    default PageResult<TrendingDO> selectPage(TrendingPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TrendingDO>()
                .likeIfPresent(TrendingDO::getIndexName, reqVO.getIndexName())
                .likeIfPresent(TrendingDO::getFullRepoName, reqVO.getFullRepoName())
                .likeIfPresent(TrendingDO::getRepoName, reqVO.getRepoName())
                .eqIfPresent(TrendingDO::getPreviewContentChinese, reqVO.getPreviewContentChinese())
                .eqIfPresent(TrendingDO::getPreviewContentEnglish, reqVO.getPreviewContentEnglish())
                .eqIfPresent(TrendingDO::getDetailContentChinese, reqVO.getDetailContentChinese())
                .eqIfPresent(TrendingDO::getDetailContentEnglish, reqVO.getDetailContentEnglish())
                .eqIfPresent(TrendingDO::getRepoStar, reqVO.getRepoStar())
                .eqIfPresent(TrendingDO::getLanguage, reqVO.getLanguage())
                .betweenIfPresent(TrendingDO::getTrendingTime, reqVO.getTrendingTime())
                .eqIfPresent(TrendingDO::getRepoDocJsonTree, reqVO.getRepoDocJsonTree())
                .eqIfPresent(TrendingDO::getSourceUrl, reqVO.getSourceUrl())
                .eqIfPresent(TrendingDO::getDemoVideoUrl, reqVO.getDemoVideoUrl())
                .eqIfPresent(TrendingDO::getRepoAvatarUrl, reqVO.getRepoAvatarUrl())
                .eqIfPresent(TrendingDO::getReadme, reqVO.getReadme())
                .eqIfPresent(TrendingDO::getCategory, reqVO.getCategory())
                .orderByDesc(TrendingDO::getId));
    }

}