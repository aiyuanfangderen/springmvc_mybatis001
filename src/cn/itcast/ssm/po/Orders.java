package cn.itcast.ssm.po;

public class Orders {
   
    private Integer id;

   
    private Integer userId;

   
    private String number;

   
    private String createtime;

   
    private String note;

    public Integer getId() {
        return id;
    }

   
    public void setId(Integer id) {
        this.id = id;
    }

   
    public Integer getUserId() {
        return userId;
    }

    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

   
    public String getNumber() {
        return number;
    }

   
    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

   
    public String getCreatetime() {
        return createtime;
    }

   
    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

   
    public String getNote() {
        return note;
    }

   
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}