package cn.iocoder.yudao.module.gitread.controller.admin.trendingrepo.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 此表用于存储 GitRead 的仓库分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TrendingRepoPageReqVO extends PageParam {

    @Schema(description = "Create Time")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "index_name", example = "王五")
    private String indexName;

    @Schema(description = "full_repo_nam", example = "王五")
    private String fullRepoName;

    @Schema(description = "repo_name", example = "芋艿")
    private String repoName;

    @Schema(description = "预览页一句话中文介绍")
    private String previewContentChinese;

    @Schema(description = "预览页一句话英文介绍")
    private String previewContentEnglish;

    @Schema(description = "详情页项目内容中文介绍")
    private String detailContentChinese;

    @Schema(description = "详情页项目内容英文介绍")
    private String detailContentEnglish;

    @Schema(description = "repo_star")
    private Long repoStar;

    @Schema(description = "编程语言")
    private String language;

    @Schema(description = "github trending日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] trendingTime;

    @Schema(description = "repo_doc_json_tree")
    private String repoDocJsonTree;

    @Schema(description = "github的项目地址", example = "https://www.iocoder.cn")
    private String sourceUrl;

    @Schema(description = "demo视频地址", example = "https://www.iocoder.cn")
    private String demoVideoUrl;

    @Schema(description = "repo_avatar_url", example = "https://www.iocoder.cn")
    private String repoAvatarUrl;

}