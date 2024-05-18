package cn.iocoder.yudao.module.gitread.service.trendingrepo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import jakarta.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.gitread.controller.admin.trendingrepo.vo.*;
import cn.iocoder.yudao.module.gitread.dal.dataobject.trendingrepo.TrendingRepoDO;
import cn.iocoder.yudao.module.gitread.dal.mysql.trendingrepo.TrendingRepoMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.module.gitread.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * {@link TrendingRepoServiceImpl} 的单元测试类
 *
 * @author 芋道源码
 */
@Import(TrendingRepoServiceImpl.class)
public class TrendingRepoServiceImplTest extends BaseDbUnitTest {

    @Resource
    private TrendingRepoServiceImpl trendingRepoService;

    @Resource
    private TrendingRepoMapper trendingRepoMapper;

    @Test
    public void testCreateTrendingRepo_success() {
        // 准备参数
        TrendingRepoSaveReqVO createReqVO = randomPojo(TrendingRepoSaveReqVO.class).setId(null);

        // 调用
        Integer trendingRepoId = trendingRepoService.createTrendingRepo(createReqVO);
        // 断言
        assertNotNull(trendingRepoId);
        // 校验记录的属性是否正确
        TrendingRepoDO trendingRepo = trendingRepoMapper.selectById(trendingRepoId);
        assertPojoEquals(createReqVO, trendingRepo, "id");
    }

    @Test
    public void testUpdateTrendingRepo_success() {
        // mock 数据
        TrendingRepoDO dbTrendingRepo = randomPojo(TrendingRepoDO.class);
        trendingRepoMapper.insert(dbTrendingRepo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        TrendingRepoSaveReqVO updateReqVO = randomPojo(TrendingRepoSaveReqVO.class, o -> {
            o.setId(dbTrendingRepo.getId()); // 设置更新的 ID
        });

        // 调用
        trendingRepoService.updateTrendingRepo(updateReqVO);
        // 校验是否更新正确
        TrendingRepoDO trendingRepo = trendingRepoMapper.selectById(updateReqVO.getId()); // 获取最新的
        assertPojoEquals(updateReqVO, trendingRepo);
    }

    @Test
    public void testUpdateTrendingRepo_notExists() {
        // 准备参数
        TrendingRepoSaveReqVO updateReqVO = randomPojo(TrendingRepoSaveReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> trendingRepoService.updateTrendingRepo(updateReqVO), TRENDING_REPO_NOT_EXISTS);
    }

    @Test
    public void testDeleteTrendingRepo_success() {
        // mock 数据
        TrendingRepoDO dbTrendingRepo = randomPojo(TrendingRepoDO.class);
        trendingRepoMapper.insert(dbTrendingRepo);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Integer id = dbTrendingRepo.getId();

        // 调用
        trendingRepoService.deleteTrendingRepo(id);
       // 校验数据不存在了
       assertNull(trendingRepoMapper.selectById(id));
    }

    @Test
    public void testDeleteTrendingRepo_notExists() {
        // 准备参数
        Integer id = randomIntegerId();

        // 调用, 并断言异常
        assertServiceException(() -> trendingRepoService.deleteTrendingRepo(id), TRENDING_REPO_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetTrendingRepoPage() {
       // mock 数据
       TrendingRepoDO dbTrendingRepo = randomPojo(TrendingRepoDO.class, o -> { // 等会查询到
           o.setCreateTime(null);
           o.setIndexName(null);
           o.setFullRepoName(null);
           o.setRepoName(null);
           o.setPreviewContentChinese(null);
           o.setPreviewContentEnglish(null);
           o.setDetailContentChinese(null);
           o.setDetailContentEnglish(null);
           o.setRepoStar(null);
           o.setLanguage(null);
           o.setTrendingTime(null);
           o.setRepoDocJsonTree(null);
           o.setSourceUrl(null);
           o.setDemoVideoUrl(null);
           o.setRepoAvatarUrl(null);
       });
       trendingRepoMapper.insert(dbTrendingRepo);
       // 测试 createTime 不匹配
       trendingRepoMapper.insert(cloneIgnoreId(dbTrendingRepo, o -> o.setCreateTime(null)));
       // 测试 indexName 不匹配
       trendingRepoMapper.insert(cloneIgnoreId(dbTrendingRepo, o -> o.setIndexName(null)));
       // 测试 fullRepoName 不匹配
       trendingRepoMapper.insert(cloneIgnoreId(dbTrendingRepo, o -> o.setFullRepoName(null)));
       // 测试 repoName 不匹配
       trendingRepoMapper.insert(cloneIgnoreId(dbTrendingRepo, o -> o.setRepoName(null)));
       // 测试 previewContentChinese 不匹配
       trendingRepoMapper.insert(cloneIgnoreId(dbTrendingRepo, o -> o.setPreviewContentChinese(null)));
       // 测试 previewContentEnglish 不匹配
       trendingRepoMapper.insert(cloneIgnoreId(dbTrendingRepo, o -> o.setPreviewContentEnglish(null)));
       // 测试 detailContentChinese 不匹配
       trendingRepoMapper.insert(cloneIgnoreId(dbTrendingRepo, o -> o.setDetailContentChinese(null)));
       // 测试 detailContentEnglish 不匹配
       trendingRepoMapper.insert(cloneIgnoreId(dbTrendingRepo, o -> o.setDetailContentEnglish(null)));
       // 测试 repoStar 不匹配
       trendingRepoMapper.insert(cloneIgnoreId(dbTrendingRepo, o -> o.setRepoStar(null)));
       // 测试 language 不匹配
       trendingRepoMapper.insert(cloneIgnoreId(dbTrendingRepo, o -> o.setLanguage(null)));
       // 测试 trendingTime 不匹配
       trendingRepoMapper.insert(cloneIgnoreId(dbTrendingRepo, o -> o.setTrendingTime(null)));
       // 测试 repoDocJsonTree 不匹配
       trendingRepoMapper.insert(cloneIgnoreId(dbTrendingRepo, o -> o.setRepoDocJsonTree(null)));
       // 测试 sourceUrl 不匹配
       trendingRepoMapper.insert(cloneIgnoreId(dbTrendingRepo, o -> o.setSourceUrl(null)));
       // 测试 demoVideoUrl 不匹配
       trendingRepoMapper.insert(cloneIgnoreId(dbTrendingRepo, o -> o.setDemoVideoUrl(null)));
       // 测试 repoAvatarUrl 不匹配
       trendingRepoMapper.insert(cloneIgnoreId(dbTrendingRepo, o -> o.setRepoAvatarUrl(null)));
       // 准备参数
       TrendingRepoPageReqVO reqVO = new TrendingRepoPageReqVO();
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setIndexName(null);
       reqVO.setFullRepoName(null);
       reqVO.setRepoName(null);
       reqVO.setPreviewContentChinese(null);
       reqVO.setPreviewContentEnglish(null);
       reqVO.setDetailContentChinese(null);
       reqVO.setDetailContentEnglish(null);
       reqVO.setRepoStar(null);
       reqVO.setLanguage(null);
       reqVO.setTrendingTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setRepoDocJsonTree(null);
       reqVO.setSourceUrl(null);
       reqVO.setDemoVideoUrl(null);
       reqVO.setRepoAvatarUrl(null);

       // 调用
       PageResult<TrendingRepoDO> pageResult = trendingRepoService.getTrendingRepoPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbTrendingRepo, pageResult.getList().get(0));
    }

}