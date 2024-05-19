package cn.iocoder.yudao.module.gitread.controller.admin.themereporelation.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 主题内容新增/修改 Request VO")
@Data
public class ThemeRepoRelationSaveReqVO {

    @Schema(description = "主题id", example = "23479")
    private Long themeId;

    @Schema(description = "repo id", example = "12198")
    private Long themeRepoId;

    @Schema(description = "主键", requiredMode = Schema.RequiredMode.REQUIRED, example = "2581")
    private Long id;

}