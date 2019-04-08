package cn.aberic.fabric.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 设备
 */
@Setter
@Getter
@ToString
public class IctGoods {
    public IctGoods() {
    }

    public IctGoods(String id, String className, String classCode, String name, String code, String status, String createDate, String userId, String venderId, String supplierId) {
        this.id = id;
        this.className = className;
        this.classCode = classCode;
        this.name = name;
        this.code = code;
        this.status = status;
        this.createDate = createDate;
        this.userId = userId;
        this.venderId = venderId;
        this.supplierId = supplierId;
    }

    //: string 商品id
    private String id;
    //: string "电冰箱" 类别名称
    private String className;
    //: string "refrigerator" 类别名称code
    private String classCode;
    //: string "Haier/海尔 双门冰箱对开门 576升 风冷无霜除味变频家用保鲜电冰箱 BCD-576WDPU"
    private String name;
    //: string "Haier BCD-576WDPU"
    private String code;
    //: string 售出、待售、使用中、待维修
    private String status;
    //: string "2019-03-01 22:10:03" 最后交易时间
    private String createDate;
    //: 用户id aaac6f9c9970b855
    private String userId;
    //：厂商id
    private String venderId;
    //：供销商id
    private String supplierId;

}

