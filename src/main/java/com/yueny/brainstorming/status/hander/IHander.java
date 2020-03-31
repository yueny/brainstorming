package com.yueny.brainstorming.status.hander;

import com.yueny.brainstorming.status.IFactory;

/**
 * 状态决策者
 *
 * @E  枚举
 */
public interface IHander<E extends IFactory> {
    /**
     *
     * @param target 当前状态
     * @return
     */
    E hander(E target);
}
