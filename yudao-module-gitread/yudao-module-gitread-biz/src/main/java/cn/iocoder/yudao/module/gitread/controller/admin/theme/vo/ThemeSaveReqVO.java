package cn.iocoder.yudao.module.gitread.controller.admin.theme.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import jakarta.validation.constraints.*;

@Schema(description = "管理后台 - 主题新增/修改 Request VO")
@Data
public class ThemeSaveReqVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "7376")
    private Integer id;

    @Schema(description = "中文名", example = "李四")
    private String chineseName;

    @Schema(description = "英文名", example = "赵六")
    private String englishName;

}