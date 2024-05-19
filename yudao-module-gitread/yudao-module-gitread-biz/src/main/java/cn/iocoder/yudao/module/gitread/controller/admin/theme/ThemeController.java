package cn.iocoder.yudao.module.gitread.controller.admin.theme;

import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import jakarta.validation.constraints.*;
import jakarta.validation.*;
import jakarta.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.gitread.controller.admin.theme.vo.*;
import cn.iocoder.yudao.module.gitread.dal.dataobject.theme.ThemeDO;
import cn.iocoder.yudao.module.gitread.service.theme.ThemeService;

@Tag(name = "管理后台 - 主题")
@RestController
@RequestMapping("/gitread/theme")
@Validated
public class ThemeController {

    @Resource
    private ThemeService themeService;

    @PostMapping("/create")
    @Operation(summary = "创建主题")
    @PreAuthorize("@ss.hasPermission('gitread:theme:create')")
    public CommonResult<Integer> createTheme(@Valid @RequestBody ThemeSaveReqVO createReqVO) {
        return success(themeService.createTheme(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新主题")
    @PreAuthorize("@ss.hasPermission('gitread:theme:update')")
    public CommonResult<Boolean> updateTheme(@Valid @RequestBody ThemeSaveReqVO updateReqVO) {
        themeService.updateTheme(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除主题")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gitread:theme:delete')")
    public CommonResult<Boolean> deleteTheme(@RequestParam("id") Integer id) {
        themeService.deleteTheme(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得主题")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gitread:theme:query')")
    public CommonResult<ThemeRespVO> getTheme(@RequestParam("id") Integer id) {
        ThemeDO theme = themeService.getTheme(id);
        return success(BeanUtils.toBean(theme, ThemeRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得主题分页")
    @PreAuthorize("@ss.hasPermission('gitread:theme:query')")
    public CommonResult<PageResult<ThemeRespVO>> getThemePage(@Valid ThemePageReqVO pageReqVO) {
        PageResult<ThemeDO> pageResult = themeService.getThemePage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ThemeRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出主题 Excel")
    @PreAuthorize("@ss.hasPermission('gitread:theme:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportThemeExcel(@Valid ThemePageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ThemeDO> list = themeService.getThemePage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "主题.xls", "数据", ThemeRespVO.class,
                        BeanUtils.toBean(list, ThemeRespVO.class));
    }

}