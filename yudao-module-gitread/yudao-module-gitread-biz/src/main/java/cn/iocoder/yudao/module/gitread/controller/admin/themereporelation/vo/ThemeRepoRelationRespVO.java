package cn.iocoder.yudao.module.gitread.controller.admin.themereporelation.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 主题内容 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ThemeRepoRelationRespVO {

    @Schema(description = "主题id", example = "23479")
    @ExcelProperty("主题id")
    private Long themeId;

    @Schema(description = "repo id", example = "12198")
    @ExcelProperty("repo id")
    private Long themeRepoId;

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "2581")
    @ExcelProperty("主键")
    private Long id;

    @Schema(description = "创建时间")
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}