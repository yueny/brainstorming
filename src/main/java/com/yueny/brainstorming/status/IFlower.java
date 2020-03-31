package com.yueny.brainstorming.status;

/**
 * 流程流转
 */
public interface IFlower {
    /**
     * 当前状态为当前枚举
     *
     * @param hander 决策状态
     * @return 流转后状态
     */
    IFactory next(IHander hander);

    /**
     *
     * @param current 当前状态
     * @param hander 决策状态
     * @return 流转后状态
     */
    IFactory next(IFactory current, IHander hander);
}
