package ManagementTea;

public class TeaBean {
    private String Tno;
    private String Tname;
    private String Tsex;
    private String Tjob;
    private String Tphone;
    private String Dno;
    private String Cname;
    private String password;
    private String Grade;
    
    public String getTno() {
        return Tno;
    }

    public String getTname() {
        return Tname;
    }

    public String getTsex() {
        return Tsex;
    }

    public String getTjob() {
        return Tjob;
    }

    public String getDno() {
        return Dno;
    }
    public String getCname() {
        return Cname;
    }
    public String getpassword() {
        return password;
    }
    public String getGrade() {
        return Grade;
    }
 
    public void setTno(String Tno) {
        this.Tno = Tno;
    }
    public void setTname(String Tname) {
        this.Tname = Tname;
    }
    public void setTjob(String Tjob) {
        this.Tjob = Tjob;
    }
    public void setCname(String Cname) {
        this.Cname = Cname;
    }
    public void setpassword(String password) {
        this.password = password;
    }
    public void setGrade(String Grade) {
        this.Grade = Grade;
    }


}

