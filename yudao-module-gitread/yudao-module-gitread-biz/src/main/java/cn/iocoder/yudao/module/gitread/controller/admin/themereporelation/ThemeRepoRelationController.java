package cn.iocoder.yudao.module.gitread.controller.admin.themereporelation;

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

import cn.iocoder.yudao.module.gitread.controller.admin.themereporelation.vo.*;
import cn.iocoder.yudao.module.gitread.dal.dataobject.themereporelation.ThemeRepoRelationDO;
import cn.iocoder.yudao.module.gitread.service.themereporelation.ThemeRepoRelationService;

@Tag(name = "管理后台 - 主题内容")
@RestController
@RequestMapping("/gitread/theme-repo-relation")
@Validated
public class ThemeRepoRelationController {

    @Resource
    private ThemeRepoRelationService themeRepoRelationService;

    @PostMapping("/create")
    @Operation(summary = "创建主题内容")
    @PreAuthorize("@ss.hasPermission('gitread:theme-repo-relation:create')")
    public CommonResult<Long> createThemeRepoRelation(@Valid @RequestBody ThemeRepoRelationSaveReqVO createReqVO) {
        return success(themeRepoRelationService.createThemeRepoRelation(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新主题内容")
    @PreAuthorize("@ss.hasPermission('gitread:theme-repo-relation:update')")
    public CommonResult<Boolean> updateThemeRepoRelation(@Valid @RequestBody ThemeRepoRelationSaveReqVO updateReqVO) {
        themeRepoRelationService.updateThemeRepoRelation(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除主题内容")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gitread:theme-repo-relation:delete')")
    public CommonResult<Boolean> deleteThemeRepoRelation(@RequestParam("id") Long id) {
        themeRepoRelationService.deleteThemeRepoRelation(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得主题内容")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gitread:theme-repo-relation:query')")
    public CommonResult<ThemeRepoRelationRespVO> getThemeRepoRelation(@RequestParam("id") Long id) {
        ThemeRepoRelationDO themeRepoRelation = themeRepoRelationService.getThemeRepoRelation(id);
        return success(BeanUtils.toBean(themeRepoRelation, ThemeRepoRelationRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得主题内容分页")
    @PreAuthorize("@ss.hasPermission('gitread:theme-repo-relation:query')")
    public CommonResult<PageResult<ThemeRepoRelationRespVO>> getThemeRepoRelationPage(@Valid ThemeRepoRelationPageReqVO pageReqVO) {
        PageResult<ThemeRepoRelationDO> pageResult = themeRepoRelationService.getThemeRepoRelationPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ThemeRepoRelationRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出主题内容 Excel")
    @PreAuthorize("@ss.hasPermission('gitread:theme-repo-relation:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportThemeRepoRelationExcel(@Valid ThemeRepoRelationPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ThemeRepoRelationDO> list = themeRepoRelationService.getThemeRepoRelationPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "主题内容.xls", "数据", ThemeRepoRelationRespVO.class,
                        BeanUtils.toBean(list, ThemeRepoRelationRespVO.class));
    }

}