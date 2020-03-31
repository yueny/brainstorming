package com.yueny.brainstorming.status;

/**
 * 状态机工厂接口定义
 */
public interface IFactory {
    /**
     * 取得枚举值
     *
     * @return
     */
    String getName();

    /**
     * 取得权重值
     *
     * @return
     */
    int getWeight();
}
