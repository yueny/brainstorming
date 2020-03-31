package com.yueny.brainstorming.status.stragy;

import com.yueny.brainstorming.status.IFactory;

public interface IStragy<E extends IFactory> {
    IFactory action(E target, Object req);
}
