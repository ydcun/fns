package cn.aberic.fabric.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 供销商
 *
 *
 */
@Setter
@Getter
@ToString
public class IctVendors {
    public IctVendors() {
    }

    public IctVendors(String userId, String name, String code) {
        this.userId = userId;
        this.name = name;
        this.code = code;
    }

    //供销商用户id
    private String userId;
    //供销商名称
    private String name;
    //供销商code
    private String code;
}
