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
import cn.aberic.fabric.dao.entity.Business;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface BusinessMapper {
    @Insert("insert into t_business (ca_id, name, code, create_date)" +
            " values (#{a.caId},#{a.name},#{a.code},#{a.createDate})")
    int add(@Param("a") Business businessMapper);

    @Update("update t_business set name=#{a.name}, ca_id=#{a.caId}, modify_date=#{a.code}, active=#{a.code} where id=#{a.id}")
    int update(@Param("a") Business businessMapper);

    @Select("select count(name) from t_business")
    int count();

    @Select("select t_business from fns_app where name=#{name} and chaincode_id=#{chaincodeId}")
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "appKey", column = "appKey"),
            @Result(property = "chaincode_id", column = "chaincodeId")
    })
    Business check( Business app);

    @Select("select id, name, app_key, chaincode_id, create_date, modify_date, active from t_business where chaincode_id=#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "appKey", column = "app_key"),
            @Result(property = "chaincodeId", column = "chaincode_id"),
            @Result(property = "createDate", column = "create_date"),
            @Result(property = "modifyDate", column = "modify_date"),
            @Result(property = "active", column = "active")
    })
    List<Business> list(@Param("id") int id);

    @Delete("delete from t_business where id=#{id}")
    int delete(@Param("id") int id);
}
