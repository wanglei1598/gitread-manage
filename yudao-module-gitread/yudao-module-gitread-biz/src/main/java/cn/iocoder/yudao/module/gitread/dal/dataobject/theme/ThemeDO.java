package cn.iocoder.yudao.module.gitread.dal.dataobject.theme;

import lombok.*;
import java.util.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 主题 DO
 *
 * @author 芋道源码
 */
@TableName("gitread_theme")
@KeySequence("gitread_theme_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode()
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ThemeDO {

    /**
     * id
     */
    @TableId
    private Integer id;
    /**
     * 中文名
     */
    private String chineseName;
    /**
     * 英文名
     */
    private String englishName;

}