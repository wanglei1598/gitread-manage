package cn.iocoder.yudao.module.gitread.dal.mysql.trendingrepo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.gitread.dal.dataobject.trendingrepo.TrendingRepoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.gitread.controller.admin.trendingrepo.vo.*;

/**
 * 此表用于存储 GitRead 的仓库 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface TrendingRepoMapper extends BaseMapperX<TrendingRepoDO> {

    default PageResult<TrendingRepoDO> selectPage(TrendingRepoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TrendingRepoDO>()
                .likeIfPresent(TrendingRepoDO::getIndexName, reqVO.getIndexName())
                .likeIfPresent(TrendingRepoDO::getFullRepoName, reqVO.getFullRepoName())
                .likeIfPresent(TrendingRepoDO::getRepoName, reqVO.getRepoName())
                .eqIfPresent(TrendingRepoDO::getPreviewContentChinese, reqVO.getPreviewContentChinese())
                .eqIfPresent(TrendingRepoDO::getPreviewContentEnglish, reqVO.getPreviewContentEnglish())
                .eqIfPresent(TrendingRepoDO::getDetailContentChinese, reqVO.getDetailContentChinese())
                .eqIfPresent(TrendingRepoDO::getDetailContentEnglish, reqVO.getDetailContentEnglish())
                .eqIfPresent(TrendingRepoDO::getRepoStar, reqVO.getRepoStar())
                .eqIfPresent(TrendingRepoDO::getLanguage, reqVO.getLanguage())
                .betweenIfPresent(TrendingRepoDO::getTrendingTime, reqVO.getTrendingTime())
                .eqIfPresent(TrendingRepoDO::getRepoDocJsonTree, reqVO.getRepoDocJsonTree())
                .eqIfPresent(TrendingRepoDO::getSourceUrl, reqVO.getSourceUrl())
                .eqIfPresent(TrendingRepoDO::getDemoVideoUrl, reqVO.getDemoVideoUrl())
                .eqIfPresent(TrendingRepoDO::getRepoAvatarUrl, reqVO.getRepoAvatarUrl())
                .orderByDesc(TrendingRepoDO::getId));
    }

}