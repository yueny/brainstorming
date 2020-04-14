package com.yueny.brainstorming.status;

import com.yueny.brainstorming.status.hander.IHander;

import java.util.List;

/**
 * 流程流转
 */
public interface IFlower<E extends IFactory> {
    /**
     * 所有可用的下一节点
     * 下一节点列表
     *
     * @return
     */
    List<ProcessStatus> nextOptions();

    /**
     * 当前状态枚举的下一节点， 不需要决策，采用默认决策
     *
     * @return 流转后状态
     */
    E next();

    /**
     * 当前状态枚举的下一节点，需要决策
     *
     * @param hander 决策状态
     * @return 流转后状态
     */
    E next(IHander<E> hander);

    /**
     * 获取指定节点的下一节点信息
     *
     * @param target 当前状态
     * @param hander 决策状态
     * @return 流转后状态
     */
    E next(E target, IHander<E> hander);
}
