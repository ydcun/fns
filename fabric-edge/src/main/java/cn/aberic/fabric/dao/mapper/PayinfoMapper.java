/*
 * Copyright (c) 2018. Aberic - All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.aberic.fabric.dao.mapper;

import cn.aberic.fabric.dao.entity.App;
import cn.aberic.fabric.dao.entity.Payinfo;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface PayinfoMapper {
    @Insert("insert into t_payinfo (form_ca_id, to_ca_id, entitys_id, fabric_hash, from_data, to_data, info_data, created_date)" +
            " values (#{a.formCaId},#{a.toCaId},#{a.entitysId},#{a.fabricHash},#{a.fromData},#{a.infoData},#{a.createdDate})")
    int add(@Param("a") Payinfo payInfo);

    @Update("update t_payinfo set form_ca_id=#{a.formCaId}, " +
            "to_ca_id=#{a.toCaId}, entitys_id=#{a.entitysId}, fabric_hash=#{a.fabricHash}," +
            "from_data=#{a.fromData}, to_data=#{a.toData}, info_data=#{a.infoData}, " +
            "created_date=#{a.createdDate}) where id=#{a.id}")
    int update(@Param("a") Payinfo payinfo);

    @Select("select count(name) from t_payinfo")
    int count();

    @Select("select to_ca_id from t_payinfo where form_ca_id=#{a.formCaId}")
    @Results({
            @Result(property = "toCaId", column = "to_ca_id")
    })
    Payinfo check(@Param("a") Payinfo payinfo);

    @Select("select id, form_ca_id, to_ca_id, entitys_id, fabric_hash, from_data, to_data, info_data, created_date from t_payinfo where id=#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "formCaId", column = "form_ca_id"),
            @Result(property = "toCaId", column = "to_ca_id"),
            @Result(property = "entitysId", column = "entitys_id"),
            @Result(property = "fabricHash", column = "fabric_hash"),
            @Result(property = "fromData", column = "from_data"),
            @Result(property = "toData", column = "to_data"),
            @Result(property = "infoData", column = "info_data"),
            @Result(property = "createdDate", column = "created_date")
    })
    List<Payinfo> list(@Param("id") int id);

    @Delete("delete from t_payinfo where id=#{id}")
    int delete(@Param("id") int id);
}
