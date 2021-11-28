package com.epam.tat.domainmodel.giftbox;

import com.epam.tat.domainmodel.candies.Candy;
import com.epam.tat.domainmodel.util.Finding;
import com.epam.tat.domainmodel.util.Sorting;

import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;


/**
 * Class Description:
 * Implement interfaces: Sorting and Finding and
 * their methods for sorting candies by name or weight and
 * finding candies by parameters.
 * <p>
 */

public class GiftBox implements Finding, Sorting {

    /**
     * No actions are required for class variable candiesList.
     *
     * List<Candy> - переменная класса candiesList
     */
    public List<Candy> candiesList;

    /**
     * No actions are required for constructor GiftBox().
     *
     * Конструктор GiftBox()
     */
    public GiftBox() {
        candiesList = new ArrayList<Candy>();
    }

    /**
     * No actions are required for method addCandy()
     *
     * Это метод addCandy()
     */
    public void addCandy(Candy candy) {
        this.candiesList.add(candy);
    }

    /**
     * Implement sorting of candiesList by its names in ascending order
     * and return sorted by name ascending list of candies.
     */

    class CompareCandyByName implements Comparator<Candy>{
        public int compare(Candy o1, Candy o2) {

            return o1.getName().compareTo(o2.getName());
            }
        }


    @Override
    public List<Candy> sortCandiesByNameAsc() {
        CompareCandyByName candyComp = new CompareCandyByName();
        candiesList.sort(candyComp);
        return candiesList;
//        throw new UnsupportedOperationException("You need to implement this method");
    }

    /**
     * Implement sorting of candiesList by its weight in ascending order
     * and return sorted by weight ascending list of candies.
     */
    class CompareCandy implements Comparator<Candy>{
        public int compare(Candy o1, Candy o2) {
            if (o1.getWeight() == o2.getWeight()){
                return 0;
            }else if(o1.getWeight() > o2.getWeight()){
                return 1;
            }else{
                return -1;
            }
        }
    }

    @Override
    public List<Candy> sortCandiesByWeightAsc() {
        CompareCandy candyComp = new CompareCandy();
        candiesList.sort(candyComp);
        return candiesList;

    }

    /**
     * Implement selection of candies from candiesList with names started with candyNameFirstLetter
     * and return list of candies which names started with candyNameFirstLetter in name ascending list of candies.
     */

    class ComporatorFindName implements Comparator<Candy> {
        @Override
        public int compare(Candy o1, Candy o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    @Override
    public List<Candy> findCandiesByNameStartedWith(char candyNameFirstLetter) {

        List<Candy> list = new ArrayList<>();

        for (Candy c : candiesList) {
            if (c.getName().charAt(0) == candyNameFirstLetter) {
                list.add(c);
            }
        }
        ComporatorFindName comporatorFindName = new ComporatorFindName();
        list.sort(comporatorFindName);
        return list;

    }

    /**
     * Implement selection ot candies from candiesList so that its [weightFrom <= weight => weightTo]
     * and return list of candies with weight in range [weightFrom, weightTo] in weight ascending list of candies.
     */
    @Override
    public List<Candy> findCandiesByWeightInRange(int weightFrom, int weightTo) {

        List<Candy> list1 = new ArrayList<>();

        for (Candy c : candiesList) {
            if (weightFrom <= c.getWeight() && c.getWeight() <= weightTo){
                list1.add(c);
            }
        }
        return list1;
    }
}
