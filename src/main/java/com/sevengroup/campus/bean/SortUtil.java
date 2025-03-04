package com.sevengroup.campus.bean;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 排序类，根据类字段名，对类对象的列表进行排序
public class SortUtil {

    public static void anyProperSort(boolean asc) {
    }

    // 按任意属性进行排序
    static class AnyProperComparator implements Comparator<Object> {

        private String properName;// 根据此关键字属性排序

        private boolean flag;// 为true的时候是正序，为false的时候是倒序

        public AnyProperComparator(String properName, boolean flag) {
            super();
            this.properName = properName;
            this.flag = flag;
        }

        public void setProperName(String properName) {
            this.properName = properName;
        }

        public String getProperName() {
            return properName;
        }

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        // 实现Comparator的对比方法
        @SuppressWarnings("unchecked")
        public int compare(Object r1, Object r2) {
            Class c = r1.getClass();
            double result = 0;
            try {
                Field field = c.getDeclaredField(properName);
                String classType = field.getType().getSimpleName();
                Method method = null;
                // 这里仅根据方法的返回值类型的名称来判定，比较方便
                switch (classType) {
                    case "String":
                        method = c.getMethod("get" + properName.substring(0, 1).toUpperCase() + properName.substring(1), new Class[]{});
                        if (flag) {
                            result = ((String) method.invoke(r1)).compareTo((String) method.invoke(r2));
                        } else {
                            result = ((String) method.invoke(r2)).compareTo((String) method.invoke(r1));
                        }

                        break;
                    case "Integer":
                    case "int":
                        method = c.getMethod("get" + properName.substring(0, 1).toUpperCase() + properName.substring(1), new Class[]{});
                        if (flag) {
                            result = ((Integer) method.invoke(r1)) - ((Integer) method.invoke(r2));
                        } else {
                            result = ((Integer) method.invoke(r2)) - ((Integer) method.invoke(r1));
                        }
                        break;
                    case "Double":
                    case "double":
                        method = c.getMethod("get" + properName.substring(0, 1).toUpperCase() + properName.substring(1), new Class[]{});
                        if (flag) {
                            result = ((Double) method.invoke(r1)) - ((Double) method.invoke(r2));
                        } else {
                            result = ((Double) method.invoke(r2)) - ((Double) method.invoke(r1));
                        }
                        break;
                    case "Float":
                    case "float":
                        method = c.getMethod("get" + properName.substring(0, 1).toUpperCase() + properName.substring(1), new Class[]{});
                        if (flag) {
                            result = ((Float) method.invoke(r1)) - ((Float) method.invoke(r2));
                        } else {
                            result = ((Float) method.invoke(r2)) - ((Float) method.invoke(r1));
                        }
                        break;
                    default:
                        System.out.println("属性排序只支持数据类型和String类型，其它类型暂不支持。");
                        result = -100;
                        break;
                }
            } catch (SecurityException | NoSuchFieldException | NoSuchMethodException | IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

            // 确定返回值
            if (result > 0) {
                return 1;
            } else if (result < 0) {
                return -1;
            }
            return 0;
        }

    }

     //按任意给定的字段进行排序，升序或降序由flag决定
    public static List<TeachClassInfoBean> SortTeachClassInfoBean(List<TeachClassInfoBean> list, String properName, boolean flag) {
        AnyProperComparator comparator = new AnyProperComparator(properName, flag);
        Collections.sort(list, comparator);
        return list;
    }

    public static List<TeachClassScoreRecordBean> SortTeachClassScoreRecordBean(List<TeachClassScoreRecordBean> list, String properName, boolean flag) {
        AnyProperComparator comparator = new AnyProperComparator(properName, flag);
        Collections.sort(list, comparator);
        return list;
    }

    public static List<TeachClassAbsenceRecordBean> SortTeachClassAbsenceRecordBean(List<TeachClassAbsenceRecordBean> list, String properName, boolean flag) {
        AnyProperComparator comparator = new AnyProperComparator(properName, flag);
        Collections.sort(list, comparator);
        return list;
    }

    public static List<CRApplicationRecordBean> SortCRApplicationRecordBean(List<CRApplicationRecordBean> list, String properName, boolean flag) {
        AnyProperComparator comparator = new AnyProperComparator(properName, flag);
        Collections.sort(list, comparator);
        return list;
    }

    public static List<BookBean> SortBookBean(List<BookBean> list, String properName, boolean flag) {
        AnyProperComparator comparator = new AnyProperComparator(properName, flag);
        Collections.sort(list, comparator);
        return list;
    }
    public static List<MoneyBean> SortMoneyBean(List<MoneyBean> list, String properName, boolean flag) {
        AnyProperComparator comparator = new AnyProperComparator(properName, flag);
        Collections.sort(list, comparator);
        return list;
    }
    public static List<DmtManageBean> SortDmtManageBean(List<DmtManageBean> list, String properName, boolean flag) {
        AnyProperComparator comparator = new AnyProperComparator(properName, flag);
        Collections.sort(list, comparator);
        return list;
    }

    public static List<TeachClassLeaveRecordBean> SortTeachClassLeaveRecordBean(List<TeachClassLeaveRecordBean> list, String properName, boolean flag) {
        AnyProperComparator comparator = new AnyProperComparator(properName, flag);
        Collections.sort(list, comparator);
        return list;
    }

}
