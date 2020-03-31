package com.yueny.brainstorming.status;

/**
 * 状态决策者
 */
public interface IHander {
    IFactory hander(IFactory current);
}
