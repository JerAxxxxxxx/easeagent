/*
 * Copyright (c) 2017, MegaEase
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.megaease.plugin.v5.interceptor;

import com.megaease.easeagent.plugin.Interceptor;
import com.megaease.easeagent.plugin.annotation.AdviceTo;
import com.megaease.easeagent.plugin.api.context.ContextCons;
import com.megaease.easeagent.plugin.api.interceptor.MethodInfo;
import com.megaease.easeagent.plugin.field.AgentDynamicFieldAccessor;
import com.megaease.easeagent.plugin.field.AgentFieldAccessor;
import com.megaease.plugin.v5.advice.RabbitMqConsumerAdvice;
import com.rabbitmq.client.AMQP;

import java.util.HashMap;
import java.util.Map;

@AdviceTo(RabbitMqConsumerAdvice.class)
public class RabbitMqConsumerHandleDeliveryInterceptor implements Interceptor {
    public void before(MethodInfo methodInfo, Map<Object, Object> context) {
        String uri = AgentDynamicFieldAccessor.getDynamicFieldValue(methodInfo.getInvoker());
        context.put(ContextCons.MQ_URI, uri);
        AMQP.BasicProperties properties = (AMQP.BasicProperties) methodInfo.getArgs()[2];
        Map<String, Object> headers = new HashMap<>();
        headers.put(ContextCons.MQ_URI, uri);
        if (properties.getHeaders() != null) {
            headers.putAll(properties.getHeaders());
        }
        AgentFieldAccessor.setFieldValue(properties, "headers", headers);
    }

    public Object after(MethodInfo methodInfo, Map<Object, Object> context) {
        return null;
    }
}
