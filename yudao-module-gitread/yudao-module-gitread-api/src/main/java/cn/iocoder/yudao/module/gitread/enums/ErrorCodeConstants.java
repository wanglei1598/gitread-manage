package cn.iocoder.yudao.module.gitread.enums;// TODO 待办：请将下面的错误码复制到 yudao-module-gitread-api 模块的 ErrorCodeConstants 类中。注意，请给“TODO 补充编号”设置一个错误码编号！！！

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

// ========== 此表用于存储 GitRead 的仓库 TODO 补充编号 ==========
public interface ErrorCodeConstants {

    ErrorCode TRENDING_REPO_NOT_EXISTS = new ErrorCode(1, "此表用于存储 GitRead 的仓库不存在");

    ErrorCode TRENDING_NOT_EXISTS = new ErrorCode(2, "每日爬取排行榜不存在");

    ErrorCode THEME_NOT_EXISTS = new ErrorCode(3, "主题不存在");

    ErrorCode THEME_REPO_RELATION_NOT_EXISTS = new ErrorCode(4, "主题关系不存在");

}