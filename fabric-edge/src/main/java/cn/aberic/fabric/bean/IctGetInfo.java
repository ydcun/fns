package cn.aberic.fabric.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 交易数据
 */
@Setter
@Getter
@ToString
public class IctGetInfo {
    public IctGetInfo() {
    }

    public IctGetInfo(String hash, String id, String fromUserName, String toUserName, String createDate) {
        this.hash = hash;
        this.id = id;
        this.fromUserName = fromUserName;
        this.toUserName = toUserName;
        this.createDate = createDate;
    }

    //4d82788f30965d51ebe1347c42625b3eda9298367d4a739ae9e5fb4d5d38ef7b 交易hash
    private String hash;
    //String 商品id
    private String id;
    //售出方
    private String fromUserName;
    //购买方
    private String toUserName;
    //"2019-03-01 22:10:03" 交易时间
    private String createDate;
}
