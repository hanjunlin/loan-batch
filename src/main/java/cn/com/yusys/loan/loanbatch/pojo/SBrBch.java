/*
 * 代码生成器自动生成的
 * Since 2008 - 2020
 *
 */

package cn.com.yusys.loan.loanbatch.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @version 1.0.0
 * @项目名称: ycloans-own-mybatis模块
 * @类名称: SBrBch
 * @类描述: s_br_bch数据实体类
 * @功能描述:
 * @创建人: Administrator
 * @创建时间: 2020-05-19 15:32:28
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 宇信科技-版权所有
 */
@Table(name = "s_br_bch")
public class SBrBch implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 机构号
     **/
    @Id
    @Column(name = "BR_NO")
    private String brNo;

    /**
     * 机构名
     **/
    @Column(name = "BR_NAME", unique = false, nullable = true, length = 120)
    private String brName;

    /**
     * 0：科技部（做日终处理）
     * 3：总行营业部
     * 7：营业网点（信用社）
     * 8：总行汇总（虚拟机构）
     * 9：联社汇总（虚拟机构）
     **/
    @Column(name = "BR_TYPE", unique = false, nullable = true, length = 1)
    private String brType;

    /**
     * Y：有下级机构
     * N：无下级机构（1,2,3有；4无）
     **/
    @Column(name = "SUB_BR_YN", unique = false, nullable = true, length = 1)
    private String subBrYn;

    /**
     * 1：一级机构
     * 2：二级机构
     * 3：三级机构
     * 4：四级机构
     **/
    @Column(name = "BR_LVL", unique = false, nullable = true, length = 2)
    private String brLvl;

    /**
     * 上级机构号（若为第一级就填第一季的机构号）
     **/
    @Column(name = "UP_BR_NO", unique = false, nullable = true, length = 20)
    private String upBrNo;

    /**
     * 电话号码
     **/
    @Column(name = "BR_TELE", unique = false, nullable = true, length = 20)
    private String brTele;

    /**
     * 联系人
     **/
    @Column(name = "CONTACT", unique = false, nullable = true, length = 10)
    private String contact;

    /**
     * 创建日期
     **/
    @Column(name = "CRT_DT", unique = false, nullable = true, length = 10)
    private String crtDt;

    /**
     * 最后更新日期
     **/
    @Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 20)
    private String lastChgDt;

    /**
     * 备用字段
     **/
    @Column(name = "BACK_UP", unique = false, nullable = true, length = 200)
    private String backUp;

    /**
     * @return brNo
     */
    public String getBrNo() {
        return this.brNo;
    }

    /**
     * @param brNo
     */
    public void setBrNo(String brNo) {
        this.brNo = brNo;
    }

    /**
     * @return brName
     */
    public String getBrName() {
        return this.brName;
    }

    /**
     * @param brName
     */
    public void setBrName(String brName) {
        this.brName = brName;
    }

    /**
     * @return brType
     */
    public String getBrType() {
        return this.brType;
    }

    /**
     * @param brType
     */
    public void setBrType(String brType) {
        this.brType = brType;
    }

    /**
     * @return subBrYn
     */
    public String getSubBrYn() {
        return this.subBrYn;
    }

    /**
     * @param subBrYn
     */
    public void setSubBrYn(String subBrYn) {
        this.subBrYn = subBrYn;
    }

    /**
     * @return brLvl
     */
    public String getBrLvl() {
        return this.brLvl;
    }

    /**
     * @param brLvl
     */
    public void setBrLvl(String brLvl) {
        this.brLvl = brLvl;
    }

    /**
     * @return upBrNo
     */
    public String getUpBrNo() {
        return this.upBrNo;
    }

    /**
     * @param upBrNo
     */
    public void setUpBrNo(String upBrNo) {
        this.upBrNo = upBrNo;
    }

    /**
     * @return brTele
     */
    public String getBrTele() {
        return this.brTele;
    }

    /**
     * @param brTele
     */
    public void setBrTele(String brTele) {
        this.brTele = brTele;
    }

    /**
     * @return contact
     */
    public String getContact() {
        return this.contact;
    }

    /**
     * @param contact
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * @return crtDt
     */
    public String getCrtDt() {
        return this.crtDt;
    }

    /**
     * @param crtDt
     */
    public void setCrtDt(String crtDt) {
        this.crtDt = crtDt;
    }

    /**
     * @return lastChgDt
     */
    public String getLastChgDt() {
        return this.lastChgDt;
    }

    /**
     * @param lastChgDt
     */
    public void setLastChgDt(String lastChgDt) {
        this.lastChgDt = lastChgDt;
    }

    /**
     * @return backUp
     */
    public String getBackUp() {
        return this.backUp;
    }

    /**
     * @param backUp
     */
    public void setBackUp(String backUp) {
        this.backUp = backUp;
    }

}