package dynamicprogram;

import javassist.*;
import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-11 16:32
 *  
 */
@FixMethodOrder(MethodSorters.JVM)
public class TestJavassist {
    Logger LOGGER = Logger.getLogger(TestJavassist.class);

    @Test
    public void testJavassist(){
        ClassPool pool = ClassPool.getDefault();
        try {
            CtClass cc = pool.get("dynamicprogram.po.Rectangle");
            cc.setSuperclass(pool.get("dynamicprogram.po.Shape"));
            cc.writeFile();
        } catch (NotFoundException e) {
            LOGGER.info(e.getMessage());
            e.printStackTrace();
        } catch (CannotCompileException e) {
            LOGGER.info(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testGenerateClass(){
        ClassPool pool = ClassPool.getDefault();
        try {
            CtClass cc = pool.get("dynamicprogram.po.Shape");
            byte[] bb = cc.toBytecode();
            Class clazz = cc.getClass();
            LOGGER.info(clazz);
        } catch (NotFoundException e) {
            LOGGER.info(e.getMessage());
            e.printStackTrace();
        } catch (CannotCompileException e) {
            LOGGER.info(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
            e.printStackTrace();
        }
    }


    @Test
    public void testCreateClass(){
        ClassPool pool = ClassPool.getDefault();
        CtClass clazz = pool.makeClass("Point");
        Class cc = null;
        try {
            clazz.setSuperclass(pool.get("dynamicprogram.po.Shape"));
            CtMethod method = CtMethod.make("public Integer getInteger() {return null;}",clazz);
            clazz.addMethod(method);

            CtField x = new CtField(CtClass.intType,"x",clazz);
            CtField y = new CtField(CtClass.intType,"y",clazz);
            clazz.addField(x);
            clazz.addField(y);

            CtMethod move = CtMethod.make("public void move(int dx,int dy){ x += dx;y += dy;}",clazz);
            clazz.addMethod(move);
            CtField field = new CtField(CtClass.intType,"i",clazz);
            clazz.addField(field);

            cc = clazz.toClass();
            Object instance = cc.newInstance();
            System.out.println(instance.getClass());
            clazz.writeFile();
        } catch (NotFoundException e) {
            LOGGER.info(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
            e.printStackTrace();
        } catch (CannotCompileException e) {
            LOGGER.info(e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            LOGGER.info(e.getMessage());
            e.printStackTrace();
        } catch (InstantiationException e) {
            LOGGER.info(e.getMessage());
            e.printStackTrace();
        }
//        LOGGER.info(clazz.getClass());
    }

    @Test
    public void testInsert(){
        ClassPool pool = ClassPool.getDefault();
        try {
            CtClass cc = pool.get("Point");
            CtMethod method = cc.getDeclaredMethod("move");
            method.insertBefore("System.out.println($1 + $2);");
            method.insertAfter("System.out.println('method execute finished');");
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }
    }
}
