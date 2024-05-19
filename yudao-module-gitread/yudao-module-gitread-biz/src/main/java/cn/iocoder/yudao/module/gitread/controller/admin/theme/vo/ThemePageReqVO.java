package cn.iocoder.yudao.module.gitread.controller.admin.theme.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 主题分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ThemePageReqVO extends PageParam {

    @Schema(description = "中文名", example = "李四")
    private String chineseName;

    @Schema(description = "英文名", example = "赵六")
    private String englishName;

}