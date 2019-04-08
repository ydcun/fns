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

package cn.aberic.fabric.service.impl;

import cn.aberic.fabric.dao.mapper.*;
import cn.aberic.fabric.service.ApiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("apiService")
public class ApiServiceImpl implements ApiService {

    @Resource
    private EntitysMapper entitysMapper;
    @Resource
    private PayinfoMapper payinfoMapper;
    @Resource
    private TypeMapper typeMapper;

    @Override
    public void get() {
    }
}
