package com.zzc.utilscore;

import java.lang.reflect.ParameterizedType;


/**
 * Created by Administrator on 2017/3/20.
 */

public class InjectUtils {
    private InjectUtils() {
    }

    public static <P> P inject(Object obj, int index) {
        P presenter = null;
        ParameterizedType pt = (ParameterizedType) obj.getClass().getGenericSuperclass();
        Class c = (Class) pt.getActualTypeArguments()[index];
        try {
            presenter = (P) c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            return presenter;
        }
    }
}
