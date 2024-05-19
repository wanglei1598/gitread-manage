package cn.iocoder.yudao.module.gitread.controller.admin.trending;

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

import cn.iocoder.yudao.module.gitread.controller.admin.trending.vo.*;
import cn.iocoder.yudao.module.gitread.dal.dataobject.trending.TrendingDO;
import cn.iocoder.yudao.module.gitread.service.trending.TrendingService;

@Tag(name = "管理后台 - 每日爬取排行榜")
@RestController
@RequestMapping("/gitread/trending")
@Validated
public class TrendingController {

    @Resource
    private TrendingService trendingService;

    @PostMapping("/create")
    @Operation(summary = "创建每日爬取排行榜")
    @PreAuthorize("@ss.hasPermission('gitread:trending:create')")
    public CommonResult<Integer> createTrending(@Valid @RequestBody TrendingSaveReqVO createReqVO) {
        return success(trendingService.createTrending(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新每日爬取排行榜")
    @PreAuthorize("@ss.hasPermission('gitread:trending:update')")
    public CommonResult<Boolean> updateTrending(@Valid @RequestBody TrendingSaveReqVO updateReqVO) {
        trendingService.updateTrending(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除每日爬取排行榜")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('gitread:trending:delete')")
    public CommonResult<Boolean> deleteTrending(@RequestParam("id") Integer id) {
        trendingService.deleteTrending(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得每日爬取排行榜")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('gitread:trending:query')")
    public CommonResult<TrendingRespVO> getTrending(@RequestParam("id") Integer id) {
        TrendingDO trending = trendingService.getTrending(id);
        return success(BeanUtils.toBean(trending, TrendingRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得每日爬取排行榜分页")
    @PreAuthorize("@ss.hasPermission('gitread:trending:query')")
    public CommonResult<PageResult<TrendingRespVO>> getTrendingPage(@Valid TrendingPageReqVO pageReqVO) {
        PageResult<TrendingDO> pageResult = trendingService.getTrendingPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, TrendingRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出每日爬取排行榜 Excel")
    @PreAuthorize("@ss.hasPermission('gitread:trending:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportTrendingExcel(@Valid TrendingPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<TrendingDO> list = trendingService.getTrendingPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "每日爬取排行榜.xls", "数据", TrendingRespVO.class,
                        BeanUtils.toBean(list, TrendingRespVO.class));
    }

}