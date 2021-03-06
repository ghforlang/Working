/**
 * @decription
 * @author fanwh
 * @version v1.0
 * @create on 2017/12/3 15:12
 */
package jsr303;

/**
 * 由于输入验证在软件开发中是必须的一件事情，特别是与用户交互的软件产品，
 * 验证用户的潜在输入错误是必不可少的一件事情，然而各种开源的验证框架也很多，
 * 为了一统标准，jsr303规范横空出世了，它定义了一些标准的验证约束，
 * 标准毕竟是标准，它不可能定义到所有的验证约束，它只是提供了一些基本的常用的约束
 * ，不过它提供了一个可拓展的自定义验证约束。下面就来说说怎么样自定义一个约束.
 为了创建一个自定义约束，以下三个步骤是必须的。
 • Create a constraint annotation (首先定义一个约束注解)
 • Implement a validator(第二步是实现这个验证器)
 • Define a default error message(最后添加一条默认的错误消息即可)
 */