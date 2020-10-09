package cn.edu.szpt.soccerapp;

/**
 * Created by User on 2018/6/25.
 */

public class TeamBean {

    /**
     * id : 1
     * country : 阿根廷
     * flag : Argentina.Jpg
     * groupnum : 1
     * votenum : 0
     */

    private String id;
    private String country;
    private String flag;
    private String groupnum;
    private String votenum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getGroupnum() {
        return groupnum;
    }

    public void setGroupnum(String groupnum) {
        this.groupnum = groupnum;
    }

    public String getVotenum() {
        return votenum;
    }

    public void setVotenum(String votenum) {
        this.votenum = votenum;
    }
}
