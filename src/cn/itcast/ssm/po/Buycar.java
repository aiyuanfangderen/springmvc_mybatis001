package cn.itcast.ssm.po;

public class Buycar {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column buycar.id
     *
     * @mbggenerated Wed Apr 18 13:44:18 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column buycar.name
     *
     * @mbggenerated Wed Apr 18 13:44:18 CST 2018
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column buycar.price
     *
     * @mbggenerated Wed Apr 18 13:44:18 CST 2018
     */
    private String price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column buycar.detail
     *
     * @mbggenerated Wed Apr 18 13:44:18 CST 2018
     */
    private String detail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column buycar.pic
     *
     * @mbggenerated Wed Apr 18 13:44:18 CST 2018
     */
    private String pic;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column buycar.createtime
     *
     * @mbggenerated Wed Apr 18 13:44:18 CST 2018
     */
    private String createtime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column buycar.id
     *
     * @return the value of buycar.id
     *
     * @mbggenerated Wed Apr 18 13:44:18 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column buycar.id
     *
     * @param id the value for buycar.id
     *
     * @mbggenerated Wed Apr 18 13:44:18 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column buycar.name
     *
     * @return the value of buycar.name
     *
     * @mbggenerated Wed Apr 18 13:44:18 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column buycar.name
     *
     * @param name the value for buycar.name
     *
     * @mbggenerated Wed Apr 18 13:44:18 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column buycar.price
     *
     * @return the value of buycar.price
     *
     * @mbggenerated Wed Apr 18 13:44:18 CST 2018
     */
    public String getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column buycar.price
     *
     * @param price the value for buycar.price
     *
     * @mbggenerated Wed Apr 18 13:44:18 CST 2018
     */
    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column buycar.detail
     *
     * @return the value of buycar.detail
     *
     * @mbggenerated Wed Apr 18 13:44:18 CST 2018
     */
    public String getDetail() {
        return detail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column buycar.detail
     *
     * @param detail the value for buycar.detail
     *
     * @mbggenerated Wed Apr 18 13:44:18 CST 2018
     */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column buycar.pic
     *
     * @return the value of buycar.pic
     *
     * @mbggenerated Wed Apr 18 13:44:18 CST 2018
     */
    public String getPic() {
        return pic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column buycar.pic
     *
     * @param pic the value for buycar.pic
     *
     * @mbggenerated Wed Apr 18 13:44:18 CST 2018
     */
    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column buycar.createtime
     *
     * @return the value of buycar.createtime
     *
     * @mbggenerated Wed Apr 18 13:44:18 CST 2018
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column buycar.createtime
     *
     * @param createtime the value for buycar.createtime
     *
     * @mbggenerated Wed Apr 18 13:44:18 CST 2018
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }
}