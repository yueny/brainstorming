package com.yueny.brainstorming.statussample;

import lombok.Getter;

/**
 * 状态机的简单实用场景
 *
 *         <------------INITIAL-------------->
 *         |               ||                |
 *         |               ||                |
 *         |               ||                |
 *         |               \/                |
 *         |         SUBMIT_SETTLED          |
 *         |             //  \\              |
 *         |            //    \\             |
 *         |           //      \\            |
 *         |          //        \\           |
 *          -----> SUCCESS    FAILURE <------
 *                   ||
 *                   ||
 *                   ||
 *                   \/
 *                SETTLED
 */
public enum DepositInstructionStatus {
    /**
     * 初始化
     */
    INITIAL("IN", "初始化"),

    /**
     * 已报清算
     */
    SUBMIT_SETTLED("SM", "已报清算"),

    /**
     * 充值成功
     */
    SUCCESS("SU", "充值成功"),

    /**
     * 充值失败
     */
    FAILURE("FA", "充值失败"),

    /**
     * 已清算
     */
    SETTLED("SE", "已清算");

    /**
     * 枚举代码
     */
    @Getter
    private final String code;

    /**
     * 枚举描述
     */
    @Getter
    private final String description;

    /**
     * @param code        枚举代码
     * @param description 枚举描述
     */
    private DepositInstructionStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * 通过枚举<code>code</code>获得枚举。
     *
     * @param code 枚举值
     * @return 枚举
     */
    public static DepositInstructionStatus of(String code) {
        for (DepositInstructionStatus status : values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        return null;
    }

}
