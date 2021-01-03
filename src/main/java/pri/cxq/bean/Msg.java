package pri.cxq.bean;

public class Msg {
    private boolean flag;
    private String info;

    public Msg() {
    }

    public Msg(boolean flag, String info) {
        this.flag = flag;
        this.info = info;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
