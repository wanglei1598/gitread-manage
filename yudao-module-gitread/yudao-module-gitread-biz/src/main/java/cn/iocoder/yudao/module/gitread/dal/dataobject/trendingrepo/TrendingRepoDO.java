package cn.iocoder.yudao.module.gitread.dal.dataobject.trendingrepo;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 此表用于存储 GitRead 的仓库 DO
 *
 * @author 芋道源码
 */
@TableName("gitread_trending_repo")
@KeySequence("gitread_trending_repo_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrendingRepoDO {

    /**
     * Primary Key
     */
    @TableId
    private Integer id;
    /**
     * index_name
     */
    private String indexName;
    /**
     * full_repo_nam
     */
    private String fullRepoName;
    /**
     * repo_name
     */
    private String repoName;
    /**
     * 预览页一句话中文介绍
     */
    private String previewContentChinese;
    /**
     * 预览页一句话英文介绍
     */
    private String previewContentEnglish;
    /**
     * 详情页项目内容中文介绍
     */
    private String detailContentChinese;
    /**
     * 详情页项目内容英文介绍
     */
    private String detailContentEnglish;
    /**
     * repo_star 

     */
    private Long repoStar;
    /**
     * 编程语言
     */
    private String language;
    /**
     * github trending日期
     */
    private LocalDateTime trendingTime;
    /**
     * repo_doc_json_tree
     */
    private String repoDocJsonTree;
    /**
     * github的项目地址
     */
    private String sourceUrl;
    /**
     * demo视频地址
     */
    private String demoVideoUrl;
    /**
     * repo_avatar_url
     */
    private String repoAvatarUrl;

}