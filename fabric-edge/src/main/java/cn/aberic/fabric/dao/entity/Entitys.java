package cn.aberic.fabric.dao.entity;


import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Table(name = "t_entitys")
public class Entitys {

    @Column(name = "id",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
    private int id;
    @Column(name = "chaincode_id",type = MySqlTypeConstant.INT,length = 11)
    private int chaincodeId;
    @Column(name = "type_id",type = MySqlTypeConstant.INT,length = 11)
    private int typeId;
    @Column(name = "firm_id",type = MySqlTypeConstant.INT,length = 11)
    private int firmId;
    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 255)
    private String name;
    @Column(name = "code",type = MySqlTypeConstant.VARCHAR,length = 255)
    private String code;
    @Column(name = "value",type = MySqlTypeConstant.DOUBLE,length = 255)
    private String value;
    @Column(name = "message",type = MySqlTypeConstant.VARCHAR,length = 255)
    private String message;
    @Column(name = "create_date",type = MySqlTypeConstant.VARCHAR,length = 20)
    private String createDate;
}
