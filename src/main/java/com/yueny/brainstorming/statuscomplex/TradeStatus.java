package com.yueny.brainstorming.statuscomplex;

import lombok.Getter;

/**
 *
 * 代扣状态模型
 *
 *                            INITIAL
 *                              |
 *                              |
 *                              ∨
 *                  --------WAIT_PAY ---------
 *                  |            |           |
 *                  |            |           |
 *                  |            ∨           |
 *                  |           SUCCESS      |
 *                  |          支付成功       |
 *                  ∨            |  ∧        |
 *                支付失败        |  |        |
 *             -> /交易关闭       |  |        ∨
 *             |   FAILURE       |  |------ HANDING  可疑
 *             |     |           |           |  |
 *             |     |           放款         |  |
 *             |     |          /退款 REFUND  |  |
 *             |     |           |            | |
 *             |     |           ∨            |  |
 *             |      ------->FINISH 完成 <----   |
 *             |----------------------------------
 */
public enum TradeStatus {
    /**
     * 初始化
     */
    INITIAL("IN", "初始化"),

    /**
     * WAIT_PAY
     */
    WAIT_PAY("WP", "WAIT_PAY"),

    /**
     * 充值成功
     */
    SUCCESS("SU", "充值成功"),

    /**
     * 充值失败
     */
    FAILURE("FA", "充值失败"),

    /**
     * 可疑
     */
    HANDING("H", "可疑"),

    /**
     * 退款
     */
    REFUND("REFUND", "退款"),

    /**
     * 完成
     */
    FINISH("FINISH", "完成");

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
    private TradeStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * 通过枚举<code>code</code>获得枚举。
     *
     * @param code 枚举值
     * @return 枚举
     */
    public static TradeStatus of(String code) {
        for (TradeStatus status : values()) {
            if (status.getCode().equals(code)) {
                return status;
            }
        }
        return null;
    }

}
