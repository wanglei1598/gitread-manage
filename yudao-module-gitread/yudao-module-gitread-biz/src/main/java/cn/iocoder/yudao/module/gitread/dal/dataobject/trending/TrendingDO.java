package cn.iocoder.yudao.module.gitread.dal.dataobject.trending;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 每日爬取排行榜 DO
 *
 * @author 芋道源码
 */
@TableName("gitread_trending")
@KeySequence("gitread_trending_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode()
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrendingDO {

    /**
     * id
     */
    @TableId
    private Integer id;
    /**
     * index_name
     */
    private String indexName;
    /**
     * full_repo_name
     */
    private String fullRepoName;
    /**
     * repo_name
     */
    private String repoName;
    /**
     * preview_content_chinese
     */
    private String previewContentChinese;
    /**
     * preview_content_english
     */
    private String previewContentEnglish;
    /**
     * detail_content_chinese
     */
    private String detailContentChinese;
    /**
     * detail_content_english
     */
    private String detailContentEnglish;
    /**
     * repo_star
     */
    private Long repoStar;
    /**
     * language
     */
    private String language;
    /**
     * trending_time
     */
    private LocalDateTime trendingTime;
    /**
     * repo_doc_json_tree
     */
    private String repoDocJsonTree;
    /**
     * source_url
     */
    private String sourceUrl;
    /**
     * demo_video_url
     */
    private String demoVideoUrl;
    /**
     * 仓库小logo图
     */
    private String repoAvatarUrl;
    /**
     * readme
     */
    private String readme;
    /**
     * repo所属的主题类目
     */
    private String category;

}