package cn.iocoder.yudao.module.gitread.dal.dataobject.themereporelation;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 主题内容 DO
 *
 * @author 芋道源码
 */
@TableName("gitread_theme_repo_relation")
@KeySequence("gitread_theme_repo_relation_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ThemeRepoRelationDO extends BaseDO {

    /**
     * 主题id
     */
    private Long themeId;
    /**
     * repo id
     */
    private Long themeRepoId;
    /**
     * 主键
     */
    @TableId
    private Long id;

}