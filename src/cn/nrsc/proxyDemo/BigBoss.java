package cn.nrsc.proxyDemo;


public class BigBoss {
    public static void main(String[] args) {

        //大老板邀请周杰伦来开演唱会
        Zhoujielun zjl = new Zhoujielun();
        //要先找其代理人
        ProxySinger proxySinger = new ProxySinger(zjl);
        //获得代理人
        Singer proxyInstance = (Singer) proxySinger.getProxyInstance();
        proxyInstance.sing();
    }

}
