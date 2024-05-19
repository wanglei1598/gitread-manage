package cn.iocoder.yudao.module.gitread.controller.admin.trending.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 每日爬取排行榜分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TrendingPageReqVO extends PageParam {

    @Schema(description = "create_time")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

    @Schema(description = "index_name", example = "王五")
    private String indexName;

    @Schema(description = "full_repo_name", example = "张三")
    private String fullRepoName;

    @Schema(description = "repo_name", example = "张三")
    private String repoName;

    @Schema(description = "preview_content_chinese")
    private String previewContentChinese;

    @Schema(description = "preview_content_english")
    private String previewContentEnglish;

    @Schema(description = "detail_content_chinese")
    private String detailContentChinese;

    @Schema(description = "detail_content_english")
    private String detailContentEnglish;

    @Schema(description = "repo_star")
    private Long repoStar;

    @Schema(description = "language")
    private String language;

    @Schema(description = "trending_time")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] trendingTime;

    @Schema(description = "repo_doc_json_tree")
    private String repoDocJsonTree;

    @Schema(description = "source_url", example = "https://www.iocoder.cn")
    private String sourceUrl;

    @Schema(description = "demo_video_url", example = "https://www.iocoder.cn")
    private String demoVideoUrl;

    @Schema(description = "仓库小logo图", example = "https://www.iocoder.cn")
    private String repoAvatarUrl;

    @Schema(description = "readme")
    private String readme;

    @Schema(description = "repo所属的主题类目")
    private String category;

}