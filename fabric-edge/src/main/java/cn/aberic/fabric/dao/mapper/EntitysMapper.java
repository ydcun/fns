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

import cn.aberic.fabric.dao.entity.Entitys;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EntitysMapper {
    @Insert("insert into t_entitys (chaincode_id, type_id, name, code, firm_id, value, message, created_date)" +
            " values (#{e.chaincodeId},#{a.typeId},#{e.code},#{e.firmId},#{value},#{message},#{createdDate})")
    int add(@Param("e") Entitys entitys);

    @Update("update t_entitys set chaincode_id=#{a.chaincodeId}, type_id=#{a.typeId}, name=#{a.name}, code=#{a.code}" +
            ",firm_id=#{a.firmId}, value=#{a.value}, message=#{a.message}, created_date=#{a.createdDate} where id=#{a.id}")
    int update(@Param("e") Entitys entitys);

    @Select("select count(name) from t_entitys")
    int count();

    @Select("select chaincode_id from t_entitys where id=#{a.id}")
    @Results({
            @Result(property = "chaincodeId", column = "chaincode_id")
    })
    Entitys check(@Param("e") Entitys entitys);

    @Select("select id, chaincode_id, type_id, name, code, firm_id, value, message, created_date from t_entitys where chaincode_id=#{chaincodeId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "chaincodeId", column = "chaincode_id"),
            @Result(property = "typeId", column = "type_id"),
            @Result(property = "name", column = "name"),
            @Result(property = "code", column = "code"),
            @Result(property = "firm_id", column = "firm_id"),
            @Result(property = "value", column = "value"),
            @Result(property = "message", column = "message"),
            @Result(property = "createdDate", column = "created_date")
    })
    List<Entitys> list(@Param("id") int id);

    @Delete("delete from t_entitys where id=#{id}")
    int delete(@Param("id") int id);

}
