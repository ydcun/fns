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
@Table(name = "t_payinfo")
public class Payinfo {

    @Column(name = "id",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
    private int id;
    @Column(name = "form_ca_id",type = MySqlTypeConstant.INT,length = 11)
    private int formCaId;
    @Column(name = "to_ca_id",type = MySqlTypeConstant.INT,length = 11)
    private int toCaId;
    @Column(name = "entitys_id",type = MySqlTypeConstant.INT,length = 11)
    private int entitysId;
    @Column(name = "fabric_hash",type = MySqlTypeConstant.VARCHAR,length = 255)
    private String fabricHash;
    @Column(name = "from_data",type = MySqlTypeConstant.TEXT)
    private String fromData;
    @Column(name = "to_data",type = MySqlTypeConstant.TEXT)
    private String toData;
    @Column(name = "info_data",type = MySqlTypeConstant.TEXT)
    private String infoData;
    @Column(name = "create_date",type = MySqlTypeConstant.VARCHAR,length = 20)
    private String createDate;
}
