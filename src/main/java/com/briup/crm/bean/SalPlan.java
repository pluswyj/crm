package com.briup.crm.bean;

public class SalPlan {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sal_plan.pla_id
     *
     * @mbg.generated Fri Mar 20 16:24:38 CST 2020
     */
    private Long plaId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sal_plan.pla_chc_id
     *
     * @mbg.generated Fri Mar 20 16:24:38 CST 2020
     */
    private Long plaChcId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sal_plan.pla_todo
     *
     * @mbg.generated Fri Mar 20 16:24:38 CST 2020
     */
    private String plaTodo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sal_plan.pla_result
     *
     * @mbg.generated Fri Mar 20 16:24:38 CST 2020
     */
    private String plaResult;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sal_plan.pla_id
     *
     * @return the value of sal_plan.pla_id
     *
     * @mbg.generated Fri Mar 20 16:24:38 CST 2020
     */
    public Long getPlaId() {
        return plaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sal_plan.pla_id
     *
     * @param plaId the value for sal_plan.pla_id
     *
     * @mbg.generated Fri Mar 20 16:24:38 CST 2020
     */
    public void setPlaId(Long plaId) {
        this.plaId = plaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sal_plan.pla_chc_id
     *
     * @return the value of sal_plan.pla_chc_id
     *
     * @mbg.generated Fri Mar 20 16:24:38 CST 2020
     */
    public Long getPlaChcId() {
        return plaChcId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sal_plan.pla_chc_id
     *
     * @param plaChcId the value for sal_plan.pla_chc_id
     *
     * @mbg.generated Fri Mar 20 16:24:38 CST 2020
     */
    public void setPlaChcId(Long plaChcId) {
        this.plaChcId = plaChcId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sal_plan.pla_todo
     *
     * @return the value of sal_plan.pla_todo
     *
     * @mbg.generated Fri Mar 20 16:24:38 CST 2020
     */
    public String getPlaTodo() {
        return plaTodo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sal_plan.pla_todo
     *
     * @param plaTodo the value for sal_plan.pla_todo
     *
     * @mbg.generated Fri Mar 20 16:24:38 CST 2020
     */
    public void setPlaTodo(String plaTodo) {
        this.plaTodo = plaTodo == null ? null : plaTodo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sal_plan.pla_result
     *
     * @return the value of sal_plan.pla_result
     *
     * @mbg.generated Fri Mar 20 16:24:38 CST 2020
     */
    public String getPlaResult() {
        return plaResult;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sal_plan.pla_result
     *
     * @param plaResult the value for sal_plan.pla_result
     *
     * @mbg.generated Fri Mar 20 16:24:38 CST 2020
     */
    public void setPlaResult(String plaResult) {
        this.plaResult = plaResult == null ? null : plaResult.trim();
    }
}