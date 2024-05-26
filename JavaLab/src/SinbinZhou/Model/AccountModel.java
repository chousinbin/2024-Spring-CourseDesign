package SinbinZhou.Model;

/**
 * @ClassName: Usr
 * @UserName: SinBin
 * @date: 2023-07-08 10:50
 * @Description:
 * 账户实体
 */
public class AccountModel {
    private Integer id;
    private String usrName;
    private String pwd;

    public Integer getId() {
        return id;
    }

    public String getUsrName() {
        return usrName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
