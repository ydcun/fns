package cn.aberic.fabric.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 售后
 */
@Setter
@Getter
@ToString
public class IctCs {
    public IctCs() {
    }

    public IctCs(String userId, String name, String code) {
        this.userId = userId;
        this.name = name;
        this.code = code;
    }

    //售后用户id
    private String userId;
    //售后名称
    private String name;
    //售后code
    private String code;
}
