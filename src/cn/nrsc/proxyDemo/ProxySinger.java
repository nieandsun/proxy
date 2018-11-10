package cn.nrsc.proxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxySinger implements InvocationHandler {
    //需要代理的对象
    private Singer singer;

    public ProxySinger(Singer singer) {
        this.singer = singer;
    }

    @Override
    //实际代理的内容
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        doSomethingBefore();
        Object ret = method.invoke(singer, args);
        doSomethingAfter();
        //可以按需进行返回，这里返回的是歌手实现某个方法本来应该返回的返回值
        return ret;
    }

    private void doSomethingBefore() {
        System.out.println("开演唱会前的准备");
    }

    private void doSomethingAfter() {
        System.out.println("进行演唱会善后工作");
    }

    //生成真正的代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(singer.getClass().getClassLoader(), singer.getClass().getInterfaces(), this);
    }
}
