package com.lovers.common.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Workflow implements Serializable {

    private static final long serialVersionUID = 6266994119707117330L;
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column workflow.workflow_id
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    private Integer workflowId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column workflow.workflow_key
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    private String workflowKey;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column workflow.workflow_name
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    private String workflowName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column workflow.workflow_describe
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    private String workflowDescribe;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column workflow.order_number
     *
     * @mbg.generated Wed Sep 25 10:59:33 CST 2019
     */
    private Integer orderNumber;


}