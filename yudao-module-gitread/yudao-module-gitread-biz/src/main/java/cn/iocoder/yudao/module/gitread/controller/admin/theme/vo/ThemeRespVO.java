package cn.iocoder.yudao.module.gitread.controller.admin.theme.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.util.*;
import com.alibaba.excel.annotation.*;

@Schema(description = "管理后台 - 主题 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ThemeRespVO {

    @Schema(description = "id", requiredMode = Schema.RequiredMode.REQUIRED, example = "7376")
    @ExcelProperty("id")
    private Integer id;

    @Schema(description = "中文名", example = "李四")
    @ExcelProperty("中文名")
    private String chineseName;

    @Schema(description = "英文名", example = "赵六")
    @ExcelProperty("英文名")
    private String englishName;

}