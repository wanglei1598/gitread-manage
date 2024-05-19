package cn.iocoder.yudao.module.gitread.controller.admin.trending.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 每日爬取排行榜新增/修改 Request VO")
@Data
public class TrendingSaveReqVO {

    @Schema(description = "id", example = "8972")
    private Integer id;

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
    private LocalDateTime trendingTime;

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