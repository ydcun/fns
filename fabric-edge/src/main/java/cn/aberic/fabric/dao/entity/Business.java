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
@Table(name = "t_business")
public class Business {

    @Column(name = "id",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
    private int id;
    @Column(name = "ca_id",type = MySqlTypeConstant.INT,length = 11)
    private int caId;
    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 255)
    private String name;
    @Column(name = "code",type = MySqlTypeConstant.VARCHAR,length = 255)
    private String code;
    @Column(name = "create_date",type = MySqlTypeConstant.VARCHAR,length = 20)
    private String createDate;
}
