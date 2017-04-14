/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-04-14 13:15
 *  
 */
package importNew.day0414;
/**
 * 问题一：synchronized锁字符串引发的坑兼再谈Java字符串
 * 描述；
 通过代理IP访问国外某网站N，每个IP对应一个固定的网站N的COOKIE，COOKIE有失效时间。

 并发下，取IP是有一定策略的，取到IP之后拿IP对应的COOKIE，发现COOKIE超过失效时间，则调用脚本访问网站N获取一次数据。

 为了防止多线程取到同一个IP，同时发现该IP对应的COOKIE失效，同时去调用脚本更新COOKIE，针对IP加了锁。
 为了保证锁的全局唯一性，在锁前面加了标识业务的前缀，使用synchronized(lock){...}的方式，
 锁住"锁前缀+IP"，这样保证多线程取到同一个IP，也只有一个IP会更新COOKIE。
 */