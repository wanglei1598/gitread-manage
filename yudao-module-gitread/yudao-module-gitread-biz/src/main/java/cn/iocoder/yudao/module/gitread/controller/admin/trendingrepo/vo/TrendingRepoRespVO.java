package cn.iocoder.yudao.module.gitread.controller.admin.trendingrepo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 此表用于存储 GitRead 的仓库 Response VO")
@Data
@ExcelIgnoreUnannotated
public class TrendingRepoRespVO {

    @Schema(description = "Primary Key", requiredMode = Schema.RequiredMode.REQUIRED, example = "2876")
    @ExcelProperty("Primary Key")
    private Integer id;

    @Schema(description = "Create Time")
    @ExcelProperty("Create Time")
    private LocalDateTime createTime;

    @Schema(description = "index_name", example = "王五")
    @ExcelProperty("index_name")
    private String indexName;

    @Schema(description = "full_repo_nam", example = "王五")
    @ExcelProperty("full_repo_nam")
    private String fullRepoName;

    @Schema(description = "repo_name", example = "芋艿")
    @ExcelProperty("repo_name")
    private String repoName;

    @Schema(description = "预览页一句话中文介绍")
    @ExcelProperty("预览页一句话中文介绍")
    private String previewContentChinese;

    @Schema(description = "预览页一句话英文介绍")
    @ExcelProperty("预览页一句话英文介绍")
    private String previewContentEnglish;

    @Schema(description = "详情页项目内容中文介绍")
    @ExcelProperty("详情页项目内容中文介绍")
    private String detailContentChinese;

    @Schema(description = "详情页项目内容英文介绍")
    @ExcelProperty("详情页项目内容英文介绍")
    private String detailContentEnglish;

    @Schema(description = "repo_star")
    @ExcelProperty("repo_star")
    private Long repoStar;

    @Schema(description = "编程语言")
    @ExcelProperty("编程语言")
    private String language;

    @Schema(description = "github trending日期")
    @ExcelProperty("github trending日期")
    private LocalDateTime trendingTime;

    @Schema(description = "repo_doc_json_tree")
    @ExcelProperty("repo_doc_json_tree")
    private String repoDocJsonTree;

    @Schema(description = "github的项目地址", example = "https://www.iocoder.cn")
    @ExcelProperty("github的项目地址")
    private String sourceUrl;

    @Schema(description = "demo视频地址", example = "https://www.iocoder.cn")
    @ExcelProperty("demo视频地址")
    private String demoVideoUrl;

    @Schema(description = "repo_avatar_url", example = "https://www.iocoder.cn")
    @ExcelProperty("repo_avatar_url")
    private String repoAvatarUrl;

}