package com.epam.tat.domainmodel.candies;

/**
 * Class Description:
 * Extend class 'com.epam.tat.domainmodel.candies.Candy' from abstract class 'com.epam.tat.domainmodel.candies.CandyBase',
 * implement constructor om.epam.tat.domainmodel.candies.Candy() with two arguments:
 * 'name' as String, 'weight' as int,
 * override and implement get() and set() methods by default and
 * put this class into package 'com.epam.tat.domainmodel.candies'.
 * <p>
 */
public class Candy extends CandyBase implements Comparable<Candy> {

    /**
     * Implement constructor with two arguments:
     * @param name
     * @param weight
     */
    public Candy(String name, int weight) {
        this.name = name;
        this.weight = weight;
        /**
         * Assign parameter 'name' to class variable 'name' and
         * parameter 'weight' to class variable 'weight'.
         */
    }

    public Candy(String name) {
        super();
    }

    /**
     * No actions are required within the method getName
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * No actions are required within the method setName
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Implement method getWeight which
     * returns class variable 'weight'
     */
    @Override
    public int getWeight(){
        return weight;
    }

    /**
     * Implement method setWeight with
     * @param weight
     * which is assigned to class variable 'weight'.
     */
    @Override
    public void setWeight(int weight) {
        this.weight = weight;
        /**
         * Assign parameter weight to class variable 'weight'.
         */

    }

    @Override
    public int compareTo(Candy o) {
        return 0;
    }
}


