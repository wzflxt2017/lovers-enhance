package com.lovers.common.domain;

import java.util.Date;

public class WorkflowTask {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column workflow_task.task_id
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    private Integer taskId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column workflow_task.business_id
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    private Integer businessId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column workflow_task.start_user_id
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    private Integer startUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column workflow_task.start_user_name
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    private String startUserName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column workflow_task.start_time
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    private Date startTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column workflow_task.end_user_id
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    private Integer endUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column workflow_task.end_user_name
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    private String endUserName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column workflow_task.end_time
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    private Date endTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column workflow_task.node_id
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    private Integer nodeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column workflow_task.link_id
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    private Integer linkId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column workflow_task.status
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column workflow_task.task_id
     *
     * @return the value of workflow_task.task_id
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    public Integer getTaskId() {
        return taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column workflow_task.task_id
     *
     * @param taskId the value for workflow_task.task_id
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column workflow_task.business_id
     *
     * @return the value of workflow_task.business_id
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    public Integer getBusinessId() {
        return businessId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column workflow_task.business_id
     *
     * @param businessId the value for workflow_task.business_id
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column workflow_task.start_user_id
     *
     * @return the value of workflow_task.start_user_id
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    public Integer getStartUserId() {
        return startUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column workflow_task.start_user_id
     *
     * @param startUserId the value for workflow_task.start_user_id
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    public void setStartUserId(Integer startUserId) {
        this.startUserId = startUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column workflow_task.start_user_name
     *
     * @return the value of workflow_task.start_user_name
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    public String getStartUserName() {
        return startUserName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column workflow_task.start_user_name
     *
     * @param startUserName the value for workflow_task.start_user_name
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    public void setStartUserName(String startUserName) {
        this.startUserName = startUserName == null ? null : startUserName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column workflow_task.start_time
     *
     * @return the value of workflow_task.start_time
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column workflow_task.start_time
     *
     * @param startTime the value for workflow_task.start_time
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column workflow_task.end_user_id
     *
     * @return the value of workflow_task.end_user_id
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    public Integer getEndUserId() {
        return endUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column workflow_task.end_user_id
     *
     * @param endUserId the value for workflow_task.end_user_id
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    public void setEndUserId(Integer endUserId) {
        this.endUserId = endUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column workflow_task.end_user_name
     *
     * @return the value of workflow_task.end_user_name
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    public String getEndUserName() {
        return endUserName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column workflow_task.end_user_name
     *
     * @param endUserName the value for workflow_task.end_user_name
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    public void setEndUserName(String endUserName) {
        this.endUserName = endUserName == null ? null : endUserName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column workflow_task.end_time
     *
     * @return the value of workflow_task.end_time
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column workflow_task.end_time
     *
     * @param endTime the value for workflow_task.end_time
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column workflow_task.node_id
     *
     * @return the value of workflow_task.node_id
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    public Integer getNodeId() {
        return nodeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column workflow_task.node_id
     *
     * @param nodeId the value for workflow_task.node_id
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column workflow_task.link_id
     *
     * @return the value of workflow_task.link_id
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    public Integer getLinkId() {
        return linkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column workflow_task.link_id
     *
     * @param linkId the value for workflow_task.link_id
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column workflow_task.status
     *
     * @return the value of workflow_task.status
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column workflow_task.status
     *
     * @param status the value for workflow_task.status
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}