package com.yueny.brainstorming.statuscomplex;

import lombok.Getter;

/**
 * 状态签转路径模型
 */
public class Transition {
    /** 起始状态 */
    @Getter
    private final String fromStatus;

    /** 交易动作 */
    @Getter
    private final String action;

    /** 目标状态 */
    @Getter
    private final String toStatus;

    public Transition(String fromStatus, String action, String toStatus) {
        this.fromStatus = fromStatus;
        this.action = action;
        this.toStatus = toStatus;
    }
}
