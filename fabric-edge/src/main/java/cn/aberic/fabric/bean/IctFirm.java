package cn.aberic.fabric.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 厂商
 */
@Setter
@Getter
@ToString
public class IctFirm {
    public IctFirm() {
    }

    public IctFirm(String userId, String name, String code) {
        this.userId = userId;
        this.name = name;
        this.code = code;
    }

    //厂商用户id
    private String userId;
    //厂商名称
    private String name;
    //厂商code
    private String code;
}
