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

package com.megaease.easeagent.sniffer;

import com.megaease.easeagent.gen.Assembly;
import com.megaease.easeagent.sniffer.jedis.v3.JedisAdvice;
import com.megaease.easeagent.sniffer.kafka.v2d3.advice.KafkaConsumerAdvice;
import com.megaease.easeagent.sniffer.kafka.v2d3.advice.KafkaProducerAdvice;
import com.megaease.easeagent.sniffer.lettuce.v5.AbstractRedisClientAdvice;
import com.megaease.easeagent.sniffer.lettuce.v5.advice.*;


@Assembly({
        JdbcDataSourceAdvice.class,
        JdbcStatementAdvice.class,
        HttpServletAdvice.class,
        HttpFilterAdvice.class,
        RestTemplateAdvice.class,
        FeignClientAdvice.class,
        SpringGatewayInitGlobalFilterAdvice.class,
        SpringGatewayHttpHeadersFilterAdvice.class,
        ServiceNamePropagationAdvice.class,
        RedisClientAdvice.class,
        AbstractRedisClientAdvice.class,
        StatefulRedisConnectionAdvice.class,
        RedisChannelWriterAdvice.class,
        RedisClusterClientAdvice.class,
        JedisAdvice.class,
        KafkaProducerAdvice.class,
        KafkaConsumerAdvice.class,
        CrossThreadPropagationAdvice.class,
})
public interface GeneratedTest {
}
