package cn.iocoder.yudao.module.gitread.controller.admin.trending.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 每日爬取排行榜 Response VO")
@Data
@ExcelIgnoreUnannotated
public class TrendingRespVO {

    @Schema(description = "id", example = "8972")
    @ExcelProperty("id")
    private Integer id;

    @Schema(description = "create_time")
    @ExcelProperty("create_time")
    private LocalDateTime createTime;

    @Schema(description = "index_name", example = "王五")
    @ExcelProperty("index_name")
    private String indexName;

    @Schema(description = "full_repo_name", example = "张三")
    @ExcelProperty("full_repo_name")
    private String fullRepoName;

    @Schema(description = "repo_name", example = "张三")
    @ExcelProperty("repo_name")
    private String repoName;

    @Schema(description = "preview_content_chinese")
    @ExcelProperty("preview_content_chinese")
    private String previewContentChinese;

    @Schema(description = "preview_content_english")
    @ExcelProperty("preview_content_english")
    private String previewContentEnglish;

    @Schema(description = "detail_content_chinese")
    @ExcelProperty("detail_content_chinese")
    private String detailContentChinese;

    @Schema(description = "detail_content_english")
    @ExcelProperty("detail_content_english")
    private String detailContentEnglish;

    @Schema(description = "repo_star")
    @ExcelProperty("repo_star")
    private Long repoStar;

    @Schema(description = "language")
    @ExcelProperty("language")
    private String language;

    @Schema(description = "trending_time")
    @ExcelProperty("trending_time")
    private LocalDateTime trendingTime;

    @Schema(description = "repo_doc_json_tree")
    @ExcelProperty("repo_doc_json_tree")
    private String repoDocJsonTree;

    @Schema(description = "source_url", example = "https://www.iocoder.cn")
    @ExcelProperty("source_url")
    private String sourceUrl;

    @Schema(description = "demo_video_url", example = "https://www.iocoder.cn")
    @ExcelProperty("demo_video_url")
    private String demoVideoUrl;

    @Schema(description = "仓库小logo图", example = "https://www.iocoder.cn")
    @ExcelProperty("仓库小logo图")
    private String repoAvatarUrl;

    @Schema(description = "readme")
    @ExcelProperty("readme")
    private String readme;

    @Schema(description = "repo所属的主题类目")
    @ExcelProperty("repo所属的主题类目")
    private String category;

}