package me.xjn.bloglite.pojo;
import lombok.Getter;
import lombok.Setter;

public class JsonResult {
    @Getter @Setter private String status;
    @Getter @Setter private String info;

    public JsonResult(boolean success, String msg){
        this.status = success ? "y" : "n";
        this.info = msg;
    }
}
