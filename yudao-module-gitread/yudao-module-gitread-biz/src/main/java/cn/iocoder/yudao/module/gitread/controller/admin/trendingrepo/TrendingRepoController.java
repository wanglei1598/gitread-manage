package cn.iocoder.yudao.module.gitread.controller.admin.trendingrepo;

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

import cn.iocoder.yudao.module.gitread.controller.admin.trendingrepo.vo.*;
import cn.iocoder.yudao.module.gitread.dal.dataobject.trendingrepo.TrendingRepoDO;
import cn.iocoder.yudao.module.gitread.service.trendingrepo.TrendingRepoService;

@Tag(name = "管理后台 - 此表用于存储 GitRead 的仓库")
@RestController
@RequestMapping("/gitread/trending-repo")
@Validated
public class TrendingRepoController {

    @Resource
    private TrendingRepoService trendingRepoService;

    @PostMapping("/create")
    @Operation(summary = "创建此表用于存储 GitRead 的仓库")
    @PreAuthorize("@ss.hasPermission('gitread:trending-repo:create')")
    public CommonResult<Integer> createTrendingRepo(@Valid @RequestBody TrendingRepoSaveReqVO createReqVO) {
        return success(trendingRepoService.createTrendingRepo(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新此表用于存储 GitRead 的仓库")
    @PreAuthorize("@ss.hasPermission('gitread:trending-repo:update')")
    public CommonResult<Boolean> updateTrendingRepo(@Valid @RequestBody TrendingRepoSaveReqVO updateReqVO) {
        trendingRepoService.updateTrendingRepo(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除此表用于存储 GitRead 的仓库")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gitread:trending-repo:delete')")
    public CommonResult<Boolean> deleteTrendingRepo(@RequestParam("id") Integer id) {
        trendingRepoService.deleteTrendingRepo(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得此表用于存储 GitRead 的仓库")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gitread:trending-repo:query')")
    public CommonResult<TrendingRepoRespVO> getTrendingRepo(@RequestParam("id") Integer id) {
        TrendingRepoDO trendingRepo = trendingRepoService.getTrendingRepo(id);
        return success(BeanUtils.toBean(trendingRepo, TrendingRepoRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得此表用于存储 GitRead 的仓库分页")
    @PreAuthorize("@ss.hasPermission('gitread:trending-repo:query')")
    public CommonResult<PageResult<TrendingRepoRespVO>> getTrendingRepoPage(@Valid TrendingRepoPageReqVO pageReqVO) {
        PageResult<TrendingRepoDO> pageResult = trendingRepoService.getTrendingRepoPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, TrendingRepoRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出此表用于存储 GitRead 的仓库 Excel")
    @PreAuthorize("@ss.hasPermission('gitread:trending-repo:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportTrendingRepoExcel(@Valid TrendingRepoPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<TrendingRepoDO> list = trendingRepoService.getTrendingRepoPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "此表用于存储 GitRead 的仓库.xls", "数据", TrendingRepoRespVO.class,
                        BeanUtils.toBean(list, TrendingRepoRespVO.class));
    }

}