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
import cn.aberic.fabric.dao.entity.Type;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface TypeMapper {

    @Insert("insert into t_type (name, code, create_date)" +
            " values (#{a.name},#{a.code},#{a.createDate})")
    int add(@Param("a") Type type);

    @Update("update t_type set name=#{a.name}, code=#{a.code}, create_date=#{a.createDate} where id=#{a.id}")
    int update(@Param("a") Type type);

    @Select("select count(name) from t_type")
    int count();

    @Select("select name,code,create_date from t_type where id=#{a.id}")
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "code", column = "code"),
            @Result(property = "create_date", column = "create_date")
    })
    Type check(@Param("a") Type type);

    @Select("select id, name, code, create_date from t_type where id=#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "code", column = "code"),
            @Result(property = "createDate", column = "create_date")
    })
    List<Type> list(@Param("id") int id);

    @Delete("delete from t_type where id=#{id}")
    int delete(@Param("id") int id);

}
