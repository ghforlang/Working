package sort;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class TestSort {

    public static void main(String[] args) {
        List<People> peopleList = listPeople();
        System.out.println(JSON.toJSONString(peopleList));
        SortBuilder.<People>newBuilder(People.class).addDesc("age").addDesc("height").addDesc("weight").sortList(peopleList);
        System.out.println(JSON.toJSONString(peopleList));

        peopleList.sort(Comparator.comparing(People::getAge).reversed().thenComparing(people -> people.getHeight()).thenComparing(People::getWeight));
        System.out.println(JSON.toJSONString(peopleList));
        Collections.sort(peopleList,People::compareTo);
//        List<Comparator<People>> comparators = new ArrayList<>();
//        comparators.add(People.ageASC);
//        comparators.add(People.heightDESC);
//        comparators.add(People.weightDESC);
//        sort(peopleList,comparators);
        System.out.println(JSON.toJSONString(peopleList));
    }

    private static List<People> listPeople(){
        List<People> peopleList = new ArrayList<>();
        Random random = new Random();
        for(int i = 0;i<20 ;i ++){
            People people = new People();
            people.setAge(random.nextInt(20));
            people.setHeight(random.nextInt(20));
            people.setWeight(random.nextInt(20));
            people.setName("name" + i);
            peopleList.add(people);
        }
        return peopleList;
    }

    public static void sort(List<People> list,final List<Comparator<People>> comparators){
        Comparator<People> comparator = new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                for(Comparator<People> com : comparators){
                    if(com.compare(o1,o2) > 0){
                        return 1;
                    }else{
                        return -1;
                    }
                }
                return 0;
            }
        };
        Collections.sort(list,comparator);
    }

}
