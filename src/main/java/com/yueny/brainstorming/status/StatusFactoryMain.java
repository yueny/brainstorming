package com.yueny.brainstorming.status;

public class StatusFactoryMain {
    public static void main(String[] args) {
        IHander hander = new IHander() {
            @Override
            public IFactory hander(IFactory current) {
                return current;
            }
        };

        IFactory factory = StatusFactory.INIT.next(hander);

        System.out.println(factory.getWeight());
        System.out.println(factory.getName());
    }
}
